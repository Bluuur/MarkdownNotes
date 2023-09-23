# If you want to analyze the abundance of KEGG pathways instead of KO within the pathway, please set `ko_to_kegg` to TRUE.
# KEGG pathways typically have more descriptive explanations.

library(readr)
library(ggpicrust2)
library(tibble)
library(tidyverse)
library(ggprism)
library(patchwork)
rm(list=ls())

en_abundance_file <- "result/picrust2_result/en/KO_metagenome_out/pred_metagenome_unstrat.tsv"

en_kegg_abundance <- ko2kegg_abundance("result/picrust2_result/en/KO_metagenome_out/pred_metagenome_unstrat.tsv") 

# Load necessary data: abundance data and metadata
# abundance_file <- "path/to/your/abundance_file.tsv"

metadata <- read_delim(
  "path/to/your/metadata.txt",
  delim = "\t",
  escape_double = FALSE,
  trim_ws = TRUE
)


# Run ggpicrust2 with input file path
results_file_input <- ggpicrust2(file = en_abundance_file,
                                 metadata = en_metadata,
                                 group = "Group", # For example dataset, group = "Environment"
                                 pathway = "KO",
                                 daa_method = "LinDA",
                                 ko_to_kegg = TRUE,
                                 order = "pathway_class",
                                 p_values_bar = TRUE,
                                 x_lab = "pathway_name")

# Run ggpicrust2 with imported data.frame
abundance_data <- read_delim(en_abundance_file, delim = "\t", col_names = TRUE, trim_ws = TRUE)

# Run ggpicrust2 with input data
results_data_input <- ggpicrust2(data = abundance_data,
                                 metadata = metadata,
                                 group = "your_group_column", # For example dataset, group = "Environment"
                                 pathway = "KO",
                                 daa_method = "LinDA",
                                 ko_to_kegg = TRUE,
                                 order = "pathway_class",
                                 p_values_bar = TRUE,
                                 x_lab = "pathway_name")

# -------------------------------- test --------------------------------
results_data_input <- ggpicrust2(data = test,
                                 metadata = testMetadata,
                                 group = "Group", # For example dataset, group = "Environment"
                                 pathway = "KO",
                                 daa_method = "LinDA",
                                 ko_to_kegg = TRUE,
                                 order = "pathway_class",
                                 p_values_bar = TRUE,
                                 x_lab = "pathway_name")
# -------------------------------- test --------------------------------

# Access the plot and results dataframe for the first DA method
example_plot <- results_file_input[[1]]$plot
example_results <- results_file_input[[1]]$results

# Use the example data in ggpicrust2 package
data(ko_abundance)
data(metadata)
results_file_input <- ggpicrust2(data = ko_abundance,
                                 metadata = metadata,
                                 group = "Environment",
                                 pathway = "KO",
                                 daa_method = "LinDA",
                                 ko_to_kegg = TRUE,
                                 order = "pathway_class",
                                 p_values_bar = TRUE,
                                 x_lab = "pathway_name")

# Analyze the EC or MetaCyc pathway
data(metacyc_abundance)
results_file_input <- ggpicrust2(data = metacyc_abundance,
                                 metadata = metadata,
                                 group = "Environment",
                                 pathway = "MetaCyc",
                                 daa_method = "LinDA",
                                 ko_to_kegg = FALSE,
                                 order = "group",
                                 p_values_bar = TRUE,
                                 x_lab = "description")
results_file_input[[1]]$plot
results_file_input[[1]]$results

# ------------------------------------------


library(readr)
library(ggpicrust2)
library(tibble)
library(tidyverse)
library(ggprism)
library(patchwork)

rm(list = ls())

# If you want to analyze KEGG pathway abundance instead of KO within the pathway, turn ko_to_kegg to TRUE.
# KEGG pathways typically have more explainable descriptions.

# Load metadata as a tibble
# data(metadata)
en_metadata <- read_delim("result/en_mapping.txt", 
                       delim = "\t", 
                       escape_double = FALSE, 
                       trim_ws = TRUE) 

# Load KEGG pathway abundance
# data(kegg_abundance)

# kegg_abundance <- ko2kegg_abundance("path/to/your/pred_metagenome_unstrat.tsv")

en_ko_abundance <- read_delim("result/picrust2_result/en/KO_metagenome_out/pred_metagenome_unstrat.tsv")
rhi_ko_abundance <- read_delim("result/picrust2_result/rhi/KO_metagenome_out/pred_metagenome_unstrat.tsv")

en_kegg_abundance <- ko2kegg_abundance("result/picrust2_result/en/KO_metagenome_out/pred_metagenome_unstrat.tsv") 
rhi_kegg_abundance <- ko2kegg_abundance("result/picrust2_result/rhi/KO_metagenome_out/pred_metagenome_unstrat.tsv") 


# Perform pathway differential abundance analysis (DAA) using ALDEx2 method
# Please change group to "your_group_column" if you are not using example dataset
daa_results_df <- pathway_daa(abundance = en_kegg_abundance, 
                              metadata = en_metadata, 
                              group = "Group", 
                              daa_method = "ALDEx2", 
                              select = NULL, 
                              reference = NULL) 

daa_results_df <- pathway_daa(abundance = test, 
                              metadata = testMetadata, 
                              group = "Group", 
                              daa_method = "ALDEx2", 
                              select = NULL, 
                              reference = NULL) 

# Filter results for ALDEx2_Welch's t test method
# Please check the unique(daa_results_df$method) and choose one
daa_sub_method_results_df <- daa_results_df[daa_results_df$method == "ALDEx2_Wilcoxon rank test", ]

# Annotate pathway results using KO to KEGG conversion
daa_annotated_sub_method_results_df <- pathway_annotation(pathway = "KO", 
                                                          daa_results_df = daa_sub_method_results_df, 
                                                          ko_to_kegg = TRUE)

# Generate pathway error bar plot
# Please change Group to metadata$your_group_column if you are not using example dataset
p <- pathway_errorbar(abundance = kegg_abundance, 
                      daa_results_df = daa_annotated_sub_method_results_df, 
                      Group = metadata$Environment, 
                      p_values_threshold = 0.05, 
                      order = "pathway_class", 
                      select = NULL, 
                      ko_to_kegg = TRUE, 
                      p_value_bar = TRUE, 
                      colors = NULL, 
                      x_lab = "pathway_name")

Group = testMetadata$Group

p <- pathway_errorbar(abundance = selected[1:10,], 
                      daa_results_df = daa_annotated_sub_method_results_df_bind[1:10,], 
                      Group = Group, 
                      p_values_threshold = 0.0000005, 
                      order = "pathway_class", 
                      select = NULL, 
                      ko_to_kegg = TRUE, 
                      p_value_bar = TRUE, 
                      colors = NULL, 
                      x_lab = "pathway_name")

pathway_heatmap(abundance = selected[122:182,], 
                metadata = testMetadata, 
                group = "Group")

pathway_pca(abundance = selected, 
            metadata = testMetadata, 
            group = "Group")

# RelativeAbundance

# If you want to analyze EC, MetaCyc, and KO without conversions, turn ko_to_kegg to FALSE.

# Load metadata as a tibble
# data(metadata)
metadata <- read_delim("path/to/your/metadata.txt", 
                       delim = "\t", 
                       escape_double = FALSE, 
                       trim_ws = TRUE)

# Load KO abundance as a data.frame
# data(ko_abundance)
ko_abundance <- read.delim("path/to/your/pred_metagenome_unstrat.tsv")

# Perform pathway DAA using ALDEx2 method
# Please change column_to_rownames() to the feature column if you are not using example dataset
# Please change group to "your_group_column" if you are not using example dataset
daa_results_df <- pathway_daa(abundance = en_ko_abundance %>% column_to_rownames("OTUID"), 
                              metadata = en_metadata, 
                              group = "Description", 
                              daa_method = "ALDEx2", 
                              select = NULL, 
                              reference = NULL)

# Filter results for ALDEx2_Kruskal-Wallace test method
daa_sub_method_results_df <- daa_results_df[daa_results_df$method == "ALDEx2_Wilcoxon rank test", ]

# Annotate pathway results without KO to KEGG conversion
daa_annotated_sub_method_results_df <- pathway_annotation(pathway = "KO", 
                                                          daa_results_df = daa_sub_method_results_df, 
                                                          ko_to_kegg = FALSE)

# Generate pathway error bar plot
# Please change column_to_rownames() to the feature column
# Please change Group to metadata$your_group_column if you are not using example dataset
p <- pathway_errorbar(abundance = ko_abundance %>% column_to_rownames("#NAME"), 
                      daa_results_df = daa_annotated_sub_method_results_df, 
                      Group = metadata$Environment, 
                      p_values_threshold = 0.05, 
                      order = "group",
                      select = daa_annotated_sub_method_results_df %>% arrange(p_adjust) %>% slice(1:20) %>% dplyr::select(feature) %>% pull(), 
                      ko_to_kegg = FALSE, 
                      p_value_bar = TRUE, 
                      colors = NULL, 
                      x_lab = "description")

# Workflow for MetaCyc Pathway and EC

# Load MetaCyc pathway abundance and metadata
# data("metacyc_abundance")
# data("metadata")

# Perform pathway DAA using LinDA method
# Please change column_to_rownames() to the feature column if you are not using example dataset
# Please change group to "your_group_column" if you are not using example dataset
metacyc_daa_results_df <- pathway_daa(abundance = metacyc_abundance %>% column_to_rownames("function"), 
                                      metadata = metadata, 
                                      group = "Environment", 
                                      daa_method = "LinDA")
EC_abundance_en <- read_delim("D:/culturome/result/picrust2_result/en/EC_metagenome_out/pred_metagenome_unstrat.tsv.gz")
EC_abundance_rhi <- read_delim("D:/culturome/result/picrust2_result/rhi/EC_metagenome_out/pred_metagenome_unstrat.tsv")
EC_abundance <- na.omit(EC_abundance)
rownames(EC_abundance) <- EC_abundance$`function`
EC_daa_results_df <- pathway_daa(abundance = EC_abundance, 
                                metadata = metadataEC, 
                                group = "Group", 
                                daa_method = "LinDA")

# Annotate MetaCyc pathway results without KO to KEGG conversion
EC_daa_annotated_results_df <- pathway_annotation(pathway = "EC", 
                                                  daa_results_df = EC_daa_results_df, 
                                                  ko_to_kegg = FALSE)

# Generate pathway error bar plot
# Please change column_to_rownames() to the feature column
# Please change Group to metadata$your_group_column if you are not using example dataset
pathway_errorbar(abundance = EC_abundance[1:30,], 
                 daa_results_df = EC_daa_annotated_results_df[1:30,], 
                 Group = metadata$Group, 
                 ko_to_kegg = FALSE, 
                 p_values_threshold = 0.05, 
                 order = "group", 
                 select = NULL, 
                 p_value_bar = TRUE, 
                 colors = NULL, 
                 x_lab = "description")

# Generate pathway heatmap
# Please change column_to_rownames() to the feature column if you are not using example dataset
# Please change group to "your_group_column" if you are not using example dataset
feature_with_p_0.05 <- EC_daa_results_df %>% filter(p_adjust < 0.05)
EC_ab_fitlered <- EC_abundance[feature_with_p_0.05$feature,]
pathway_heatmap(abundance = EC_ab_fitlered[1:100,], 
                metadata = metadataEC, group = "Group")

# Generate pathway PCA plot
# Please change column_to_rownames() to the feature column if you are not using example dataset
# Please change group to "your_group_column" if you are not using example dataset
pathway_pca(abundance = EC_abundance %>% column_to_rownames("pathway"), 
            metadata = metadata, 
            group = "Environment")

pathway_pca(abundance = EC_abundance, 
            metadata = metadataEC, 
            group = "Group")

# Run pathway DAA for multiple methods
# Please change column_to_rownames() to the feature column if you are not using example dataset
# Please change group to "your_group_column" if you are not using example dataset
methods <- c("ALDEx2", "DESeq2", "edgeR")
daa_results_list <- lapply(methods, function(method) {
  pathway_daa(abundance = metacyc_abundance %>% column_to_rownames("pathway"), metadata = metadata, group = "Environment", daa_method = method)
})

# Compare results across different methods
comparison_results <- compare_daa_results(daa_results_list = daa_results_list, method_names = c("ALDEx2_Welch's t test", "ALDEx2_Wilcoxon rank test", "DESeq2", "edgeR"))

