## --Annotate

```shell
nohup pgcgap 
	--Annotate \
	--scafPath /mnt/e/Data \
	--Scaf_suffix .fna \
	--genus Bacillus \
	--species subtilis \
	--codon 11 \
	--threads 4 &
	
nohup pgcgap --Annotate --scafPath /mnt/e/Data/genomes --Scaf_suffix .fna --genus Bacillus --species subtilis --codon 11 --threads 8 &
```