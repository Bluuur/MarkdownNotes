```R

.libPaths("D:/HZAU/课程/第6学期/R_in_NGS/Lab3/lab3packages")
library(systemPipeR)
library(systemPipeRdata)
#####################################################
## 1. Generate workflow environment
#####################################################
setwd("C:/Users/ZidongZh/Documents/BioInf/RinNGS")
genWorkenvir(workflow = "chipseq")#在工作目录中自动创建了chipseq目录及子目录，并生成了实验数据
setwd("chipseq")

#####################################################
## 2. Read preprocessing
#####################################################
## 2.1 Experiment definition provided by targets file 
targetsPath <- system.file("extdata", "targets_chip.txt", package = "systemPipeR")
targets <- read.delim(targetsPath, comment.char = "#")
targets[1:4, -c(5, 6)]
 
## 2.2 Read quality filtering and trimming
dir_path <- system.file("extdata/cwl/preprocessReads/trim-se", package = "systemPipeR")
trim <- loadWF(targets = targetsPath, wf_file = "trim-se.cwl", input_file = "trim-se.yml", dir_path = dir_path)
trim <- renderWF(trim, inputvars = c(FileName = "_FASTQ_PATH1_", SampleName = "_SampleName_"))
output(trim)[1:2]
## Next, we execute the code for trimming all the raw data.
filterFct <- function(fq, cutoff = 20, Nexceptions = 0) {
  qcount <- rowSums(as(quality(fq), "matrix") <= cutoff, na.rm = TRUE)
  fq[qcount <= Nexceptions]
}
preprocessReads(args = trim, Fct = "filterFct(fq, cutoff=20, Nexceptions=0)", 
                batchsize = 1e+05)
writeTargetsout(x = trim, file = "targets_chip_trim.txt", step = 1, 
                new_col = "FileName", new_col_output_index = 1, overwrite = TRUE)

## 2.3 FASTQ quality report
library(BiocParallel)
library(batchtools)
f <- function(x) {
  targets <- system.file("extdata", "targets_chip.txt", package = "systemPipeR")
  dir_path <- system.file("extdata/cwl/preprocessReads/trim-se", 
                          package = "systemPipeR")
  trim <- loadWorkflow(targets = targets, wf_file = "trim-se.cwl", 
                       input_file = "trim-se.yml", dir_path = dir_path)
  trim <- renderWF(trim, inputvars = c(FileName = "_FASTQ_PATH1_", 
                                       SampleName = "_SampleName_"))
  seeFastq(fastq = infile1(trim)[x], batchsize = 1e+05, klength = 8)
}
resources <- list(walltime = 120, ntasks = 1, ncpus = 4, memory = 1024)
fqlist <- lapply(seq(along = trim), f)
pdf("./results/fastqReport.pdf", height = 18, width = 4 * length(fqlist))
seeFastqPlot(unlist(fqlist, recursive = FALSE))
dev.off()

#####################################################
## 3   Alignments (Skip this step)
#####################################################

#####################################################
## 4   Peak calling with MACS2 (Skip this step)
#####################################################


#####################################################
## 5. Annotate peaks with genomic context
#####################################################
## 5.1 Annotation with ChIPpeakAnno package
library(ChIPpeakAnno)
library(GenomicFeatures)
dir_path <- system.file("extdata/cwl/annotate_peaks", package = "systemPipeR")
# 将targets_macs.txt复制到chipseq目录中
args <- loadWF(targets = "targets_macs.txt", wf_file = "annotate_peaks.cwl", 
               input_file = "annotate_peaks.yml", dir_path = dir_path)
args <- renderWF(args, inputvars = c(FileName = "_FASTQ_PATH1_", 
                                     SampleName = "_SampleName_"))

txdb <- makeTxDbFromGFF(file = "data/tair10.gff", format = "gff", 
                        dataSource = "TAIR", organism = "Arabidopsis thaliana")
ge <- genes(txdb, columns = c("tx_name", "gene_id", "tx_type"))
# 将Peaks中的文件复制到chipseq/results目录中
for (i in seq(along = args)) {
  peaksGR <- as(read.delim(infile1(args)[i], comment = "#"), 
                "GRanges")
  annotatedPeak <- annotatePeakInBatch(peaksGR, AnnotationData = genes(txdb))
  df <- data.frame(as.data.frame(annotatedPeak), as.data.frame(values(ge[values(annotatedPeak)$feature, 
  ])))
  df$tx_type <- unlist(df$tx_type)
  tx_name <- c()
  for (j in df$tx_name){
    tx_name <- rbind(tx_name, j[1])
  }
  df$tx_name <- tx_name
  outpaths <- subsetWF(args, slot = "output", subset = 1, index = 1)
  write.table(df, outpaths[i], quote = FALSE, row.names = FALSE,
              sep = "\t")
}
writeTargetsout(x = args, file = "targets_peakanno.txt", step = 1, 
                new_col = "FileName", new_col_output_index = 1, overwrite = TRUE)

## 5.2 Annotation with ChIPseeker package
## Same as in previous step but using the ChIPseeker package for annotating the peaks.
library(ChIPseeker)
for (i in seq(along = args)) {
  peakAnno <- annotatePeak(infile1(args)[i], TxDb = txdb, verbose = FALSE)
  df <- as.data.frame(peakAnno)
  outpaths <- subsetWF(args, slot = "output", subset = 1, index = 1)
  write.table(df, outpaths[i], quote = FALSE, row.names = FALSE, 
              sep = "\t")
}
writeTargetsout(x = args, file = "targets_peakanno.txt", step = 1, 
                new_col = "FileName", new_col_output_index = 1, overwrite = TRUE)
# Summary plots provided by the ChIPseeker package. Here applied only to one sample for demonstration purposes.
peak <- readPeakFile(infile1(args)[1])
covplot(peak, weightCol = "X.log10.pvalue.")
outpaths <- subsetWF(args, slot = "output", subset = 1, index = 1)
peakHeatmap(outpaths[1], TxDb = txdb, upstream = 1000, downstream = 1000, 
            palette = 'Reds')
plotAvgProf2(outpaths[1], TxDb = txdb, upstream = 1000, downstream = 1000, conf=0.05,
             xlab = "Genomic Region (5'->3')", ylab = "Read Count Frequency")

#####################################################
## 6 Count reads overlapping peaks 
#####################################################

library(GenomicRanges)
dir_path <- system.file("extdata/cwl/count_rangesets", package = "systemPipeR")
args <- loadWF(targets = "targets_macs.txt", wf_file = "count_rangesets.cwl", 
               input_file = "count_rangesets.yml", dir_path = dir_path)
args <- renderWF(args, inputvars = c(FileName = "_FASTQ_PATH1_", 
                                     SampleName = "_SampleName_"))

## Bam Files
targets <- system.file("extdata", "targets_chip.txt", package = "systemPipeR")
dir_path <- system.file("extdata/cwl/bowtie2", package = "systemPipeR")
args_bam <- loadWF(targets = targets, wf_file = "bowtie2-mapping-se.cwl", 
                   input_file = "bowtie2-mapping-se.yml", dir_path = dir_path)
args_bam <- renderWF(args_bam, inputvars = c(FileName = "_FASTQ_PATH1_", 
                                             SampleName = "_SampleName_"))
args_bam <- output_update(args_bam, dir = FALSE, replace = TRUE, 
                          extension = c(".sam", ".bam"))
outpaths <- subsetWF(args_bam, slot = "output", subset = 1, index = 1)

# 将Bam中的文件复制到chipseq/results目录中
bfl <- BamFileList(outpaths, yieldSize = 50000, index = character())
countDFnames <- countRangeset(bfl, args, mode = "Union", ignore.strand = TRUE)
# 如果这步不能运行或者运行时间过长，可以跳过这步，将targets_countDF.txt复制到chipseq目录中，将countDF中的文件复制到chipseq/results目录中，这步也跳过↓
writeTargetsout(x = args, file = "targets_countDF.txt", step = 1, 
                new_col = "FileName", new_col_output_index = 1, overwrite = TRUE)

#####################################################
## 7 Differential binding analysis
#####################################################

dir_path <- system.file("extdata/cwl/rundiff", package = "systemPipeR")
args_diff <- loadWF(targets = "targets_countDF.txt", wf_file = "rundiff.cwl", 
                    input_file = "rundiff.yml", dir_path = dir_path)
args_diff <- renderWF(args_diff, inputvars = c(FileName = "_FASTQ_PATH1_", 
                                               SampleName = "_SampleName_"))

cmp <- readComp(file = args_bam, format = "matrix")
dbrlist <- runDiff(args = args_diff, diffFct = run_edgeR, targets = targets.as.df(targets(args_bam)), 
                   cmp = cmp[[1]], independent = TRUE, dbrfilter = c(Fold = 2, 
                                                                     FDR = 1))
writeTargetsout(x = args_diff, file = "targets_rundiff.txt", 
                step = 1, new_col = "FileName", new_col_output_index = 1, 
                overwrite = TRUE)

#####################################################
## 8 GO term enrichment analysis
#####################################################

dir_path <- system.file("extdata/cwl/annotate_peaks", package = "systemPipeR")
# 将targets_bam_ref.txt复制到chipseq目录中
args <- loadWF(targets = "targets_bam_ref.txt", wf_file = "annotate_peaks.cwl", 
               input_file = "annotate_peaks.yml", dir_path = dir_path)
args <- renderWF(args, inputvars = c(FileName1 = "_FASTQ_PATH1_", 
                                     SampleName = "_SampleName_"))

args_anno <- loadWF(targets = "targets_macs.txt", wf_file = "annotate_peaks.cwl", 
                    input_file = "annotate_peaks.yml", dir_path = dir_path)
args_anno <- renderWF(args_anno, inputvars = c(FileName = "_FASTQ_PATH1_", 
                                               SampleName = "_SampleName_"))
annofiles <- subsetWF(args_anno, slot = "output", subset = 1, 
                      index = 1)
gene_ids <- sapply(names(annofiles), function(x) unique(as.character(read.delim(annofiles[x])[, 
                                                                                              "geneId"])), simplify = FALSE)
load("data/GO/catdb.RData")
BatchResult <- GOCluster_Report(catdb = catdb, setlist = gene_ids, 
                                method = "all", id_type = "gene", CLSZ = 2, cutoff = 0.9, 
                                gocats = c("MF", "BP", "CC"), recordSpecGO = NULL)

#####################################################
## 9 Motif analysis
#####################################################
## 9.1 Parse DNA sequences of peak regions from genome
library(Biostrings)
library(seqLogo)
library(BCRANK)
dir_path <- system.file("extdata/cwl/annotate_peaks", package = "systemPipeR")
args <- loadWF(targets = "targets_macs.txt", wf_file = "annotate_peaks.cwl", 
               input_file = "annotate_peaks.yml", dir_path = dir_path)
args <- renderWF(args, inputvars = c(FileName = "_FASTQ_PATH1_", 
                                     SampleName = "_SampleName_"))

rangefiles <- infile1(args)
for (i in seq(along = rangefiles)) {
  df <- read.delim(rangefiles[i], comment = "#")
  peaks <- as(df, "GRanges")
  names(peaks) <- paste0(as.character(seqnames(peaks)), "_", 
                         start(peaks), "-", end(peaks))
  peaks <- peaks[order(values(peaks)$X.log10.pvalue., decreasing = TRUE)]
  pseq <- getSeq(FaFile("./data/tair10.fasta"), peaks)
  names(pseq) <- names(peaks)
  writeXStringSet(pseq, paste0(rangefiles[i], ".fasta"))
}

## 9.2 Motif discovery with BCRANK
set.seed(0)
BCRANKout <- bcrank(paste0(rangefiles[1], ".fasta"), restarts = 25, 
                    use.P1 = TRUE, use.P2 = TRUE)
toptable(BCRANKout)
topMotif <- toptable(BCRANKout, 1)
weightMatrix <- pwm(topMotif, normalize = FALSE)
weightMatrixNormalized <- pwm(topMotif, normalize = TRUE)
pdf("results/seqlogo.pdf")
seqLogo(weightMatrixNormalized)
dev.off()
```

