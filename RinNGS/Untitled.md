```R
#####################################################
## 包的导入和Lab2的一致
#####################################################


Before start, Make sure following packages are already installed:
#options(BioC_mirror="http://mirrors.ustc.edu.cn/bioc/")
#BiocManager::install("systemPipeRdata")
BiocManager::install("systemPipeR")
BiocManager::install("ChIPseeker")
BiocManager::install("ChIPpeakAnno")
BiocManager::install("seqLogo")
BiocManager::install("BCRANK")
install.packages("tidyr")
install.packages("graphlayouts")
install.packages("ggridges")

library(systemPipeR)
library(systemPipeRdata)
#####################################################
## 1. Generate workflow environment
#####################################################
setwd(choose.dir())
genWorkenvir(workflow = "chipseq")#在工作目录中自动创建了chipseq目录及子目录，并生成了实验数据
setwd("chipseq")

#####################################################
## 2. Read preprocessing
#####################################################
## 2.1 Experiment definition provided by targets file
## The targets file defines all FASTQ files and sample comparisons of the analysis workflow. 
# 实验定义由目标文件提供。目标文件定义了分析工作流程的所有FASTQ文件和样本比较。
targetspath <- system.file("extdata", "targets_chip.txt", package = "systemPipeR")
targets <- read.delim(targetspath, comment.char = "#")
targets[1:4, -c(5, 6)]

## 2.2 Read quality filtering and trimming
## The following example shows how one can design a custom read preprocessing
## function using utilities provided by the ShortRead package, and then apply it with
## preprocessReads in batch mode to all FASTQ samples referenced in the
## corresponding SYSargs2 instance (trim object below). More detailed information
## on read preprocessing is provided in systemPipeR's main vignette.
## First, we construct SYSargs2 object from cwl and yml param and targets files.
# 读取质量过滤和修剪。以下示例显示如何使用ShortRead包提供的实用程序设计自定义读取预处理函数，然后使用批处理模式中的preprocessReads将其应用于所有FASTQ样本，这些样本引用了相应的SYSargs2实例（下面的trim对象）。有关读取预处理的更详细信息，请参见systemPipeR的主要vignette。首先，我们从cwl和yml param和targets文件构造SYSargs2对象。
dir_path <- system.file("extdata/cwl/preprocessReads/trim-se", package = "systemPipeR")
trim <- loadWF(targets = targetspath, wf_file = "trim-se.cwl", input_file = "trim-se.yml", dir_path = dir_path)
trim <- renderWF(trim, inputvars = c(FileName = "_FASTQ_PATH1_", SampleName = "_SampleName_"))
output(trim)[1:2]
## Next, we execute the code for trimming all the raw data.
filterFct <- function(fq, cutoff = 20, Nexceptions = 0) {
  qcount <- rowSums(as(quality(fq), "matrix") <= cutoff, na.rm = TRUE)
  fq[qcount <= Nexceptions]
  # Retains reads where Phred scores are >= cutoff with N
  # exceptions
}
preprocessReads(args = trim, Fct = "filterFct(fq, cutoff=20, Nexceptions=0)", 
                batchsize = 1e+05)
writeTargetsout(x = trim, file = "targets_chip_trim.txt", step = 1, 
                new_col = "FileName", new_col_output_index = 1, overwrite = TRUE)

## 2.3 FASTQ quality report
## The following seeFastq and seeFastqPlot functions generate and plot a series of
## useful quality statistics for a set of FASTQ files including per cycle quality box 
## plots, base proportions, base-level quality trends, relative k-mer diversity, length
## and occurrence distribution of reads, number of reads above quality cutoffs and mean
## quality distribution. The results are written to a PDF file named fastqReport.pdf.
## Parallelization of FASTQ quality report via scheduler (e.g. Slurm) across several
## compute nodes.
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
## 3.1 Read mapping with Bowtie2
## The NGS reads of this project will be aligned with Bowtie2 against the reference
## genome sequence (Langmead and Salzberg 2012). The parameter settings of the
## aligner are defined in the bowtie2-index.cwl and bowtie2-index.yml files. In
## ChIP-Seq experiments it is usually more appropriate to eliminate reads mapping to
## multiple locations. To achieve this, users want to remove the argument setting
## -k 50 non-deterministic in the configuration files.
# Building the index:
#dir_path <- system.file("extdata/cwl/bowtie2/bowtie2-idx", package = "systemPipeR")
#idx <- loadWorkflow(targets = NULL, wf_file = "bowtie2-index.cwl",
#                    input_file = "bowtie2-index.yml", dir_path = dir_path)
#idx <- renderWF(idx)
#idx
#cmdlist(idx)
# Run in single machine
#runCommandline(idx, make_bam = FALSE)   # Skip, This must run on Linux
#targets <- system.file("extdata", "targets_chip.txt", package = "systemPipeR")
#dir_path <- system.file("extdata/cwl/bowtie2/bowtie2-se", package = "systemPipeR")
#args <- loadWF(targets = targets, wf_file = "bowtie2-mapping-se.cwl",
#               input_file = "bowtie2-mapping-se.yml", dir_path = dir_path)
#args <- renderWF(args, inputvars = c(FileName = "_FASTQ_PATH1_", SampleName = "_SampleName_"))
#args
#cmdlist(args)[1:2]
# run the alignments sequentially on a single system.
#args <- runCommandline(args, force = F)
# Check whether all BAM files have been created and write out the new targets file.
#writeTargetsout(x = args, file = "targets_bam.txt", step = 1, new_col = "FileName", new_col_output_index = 1, overwrite = TRUE)
#outpaths <- subsetWF(args, slot = "output", subset = 1, index = 1)
#file.exists(outpaths)

# 3.2 Read and alignment stats
#read_statsDF <- alignStats(args = args)
#write.table(read_statsDF, "results/alignStats.xls", row.names = FALSE,
#            quote = FALSE, sep = "\t")
#read.delim("results/alignStats.xls")

#####################################################
## 4   Peak calling with MACS2 (Skip this step)
#####################################################
# Merging BAM files of technical and/or biological replicates can improve the
# sensitivity of the peak calling by increasing the depth of read coverage. The
# mergeBamByFactor function merges BAM files based on grouping information
# specified by a factor, here the Factor column of the imported targets file. It also
# returns an updated SYSargs2 object containing the paths to the merged BAM files
# as well as to any unmerged files without replicates. This step can be skipped if
# merging of BAM files is not desired.
# 4.1 Merge BAM files of replicates prior to peak calling
#dir_path <- system.file("extdata/cwl/mergeBamByFactor", package = "systemPipeR")
#args <- loadWF(targets = "targets_bam.txt", wf_file = "merge-bam.cwl", 
#               input_file = "merge-bam.yml", dir_path = dir_path)
#args <- renderWF(args, inputvars = c(FileName = "_BAM_PATH_", SampleName = "_SampleName_"))
#args_merge <- mergeBamByFactor(args = args, overwrite = TRUE)
#writeTargetsout(x = args_merge, file = "targets_mergeBamByFactor.txt", 
#                step = 1, new_col = "FileName", new_col_output_index = 1, 
#                overwrite = TRUE)
# 4.2 Peak calling without input/reference sample
# MACS2 can perform peak calling on ChIP-Seq data with and without input samples
# (Zhang et al. 2008). The following performs peak calling without input on all samples
# specified in the corresponding args object. Note, due to the small size of the
# sample data, MACS2 needs to be run here with the nomodel setting. For real data
# sets, users want to remove this parameter in the corresponding *.param file(s).
#dir_path <- system.file("extdata/cwl/MACS2/MACS2-noinput/", package = "systemPipeR")
#args <- loadWF(targets = "targets_mergeBamByFactor.txt", wf_file = "macs2.cwl", 
#               input_file = "macs2.yml", dir_path = dir_path)
#args <- renderWF(args, inputvars = c(FileName = "_FASTQ_PATH1_", 
#                                     SampleName = "_SampleName_"))

#runCommandline(args, make_bam = FALSE, force = T)
#outpaths <- subsetWF(args, slot = "output", subset = 1, index = 1)
#file.exists(outpaths)
#writeTargetsout(x = args, file = "targets_macs.txt", step = 1, 
#                new_col = "FileName", new_col_output_index = 1, overwrite = TRUE)
# 4.3 Peak calling with input/reference sample
# To perform peak calling with input samples, they can be most conveniently specified
# in the SampleReference column of the initial targets file. The writeTargetsRef
# function uses this information to create a targets file intermediate for running
# MACS2 with the corresponding input samples.
#writeTargetsRef(infile = "targets_mergeBamByFactor.txt", outfile = "targets_bam_ref.txt", 
#                silent = FALSE, overwrite = TRUE)
#dir_path <- system.file("extdata/cwl/MACS2/MACS2-input/", package = "systemPipeR")
#args_input <- loadWF(targets = "targets_bam_ref.txt", wf_file = "macs2-input.cwl", 
#                     input_file = "macs2.yml", dir_path = dir_path)
#args_input <- renderWF(args_input, inputvars = c(FileName1 = "_FASTQ_PATH1_", 
#                                                 FileName2 = "_FASTQ_PATH2_", SampleName = "_SampleName_"))
#cmdlist(args_input)[1]
## Run
#args_input <- runCommandline(args_input, make_bam = FALSE, force = T)
#outpaths_input <- subsetWF(args_input, slot = "output", subset = 1, 
#                           index = 1)
#file.exists(outpaths_input)
#writeTargetsout(x = args_input, file = "targets_macs_input.txt", 
#                step = 1, new_col = "FileName", new_col_output_index = 1, 
#                overwrite = TRUE)
# The peak calling results from MACS2 are written for each sample to separate files in
# the results directory. They are named after the corresponding files with extensions
# used by MACS2.
# 4.4 Identify consensus peaks
# The following example shows how one can identify consensus preaks among two
# peak sets sharing either a minimum absolute overlap and/or minimum relative
# overlap using the subsetByOverlaps or olRanges functions, respectively. Note, the
# latter is a custom function imported below by sourcing it.
#outpaths <- subsetWF(args, slot = "output", subset = 1, index = 1)  ## escolher um dos outputs index
#peak_M1A <- outpaths["M1A"]
#peak_M1A <- as(read.delim(peak_M1A, comment = "#")[, 1:3], "GRanges")
#peak_A1A <- outpaths["A1A"]
#peak_A1A <- as(read.delim(peak_A1A, comment = "#")[, 1:3], "GRanges")
#(myol1 <- subsetByOverlaps(peak_M1A, peak_A1A, minoverlap = 1))
# Returns any overlap
#myol2 <- olRanges(query = peak_M1A, subject = peak_A1A, output = "gr")
# Returns any overlap with OL length information
#myol2[values(myol2)["OLpercQ"][, 1] >= 50]
# Returns only query peaks with a minimum overlap of 50%

#####################################################
## 5. Annotate peaks with genomic context
#####################################################
## 5.1 Annotation with ChIPpeakAnno package
## The following annotates the identified peaks with genomic context information
## using the ChIPpeakAnno and ChIPseeker packages, respectively (Zhu et al. 2010;
## Yu, Wang, and He 2015).
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
## The peak annotation results are written for each peak set to separate files in the
## results directory. They are named after the corresponding peak files with
## extensions specified in the annotate_peaks.param file, here *.peaks.annotated.xls.

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
## The countRangeset function is a convenience wrapper to perform read counting
## iteratively over serveral range sets, here peak range sets. Internally, the read
## counting is performed with the summarizeOverlaps function from the
## GenomicAlignments package. The resulting count tables are directly saved to files,
## one for each peak set.
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
## The runDiff function performs differential binding analysis in batch mode for
## several count tables using edgeR or DESeq2 (Robinson, McCarthy, and Smyth 2010;
## Love, Huber, and Anders 2014). Internally, it calls the functions run_edgeR and
## run_DESeq2. It also returns the filtering results and plots from the downstream
## filterDEGs function using the fold change and FDR cutoffs provided under the
## dbrfilter argument.
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
## The following performs GO term enrichment analysis for each annotated peak set.
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
## Enrichment analysis of known DNA binding motifs or de novo discovery of novel
## motifs requires the DNA sequences of the identified peak regions. To parse the
## corresponding sequences from the reference genome, the getSeq function from
## the Biostrings package can be used. The following example parses the sequences
## for each peak set and saves the results to separate FASTA files, one for each peak
## set. In addition, the sequences in the FASTA files are ranked (sorted) by increasing ## p-values as expected by some motif discovery tools, such as BCRANK.
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
## The Bioconductor package BCRANK is one of the many tools available for de novo
## discovery of DNA binding motifs in peak regions of ChIP-Seq experiments. The given
## example applies this method on the first peak sample set and plots the sequence
## logo of the highest ranking motif.
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

