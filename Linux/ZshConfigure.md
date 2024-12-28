# zsh Configuration

## Install zsh

```shell
# On Ubuntu
sudo apt update
sudo apt install -y zsh
```

## Install oh-my-zsh

```shell
sh -c "$(curl -fsSL https://install.ohmyz.sh/)"
```

### Plugins

```shell
cd ~/.oh-my-zsh/plugins

# zsh-autosuggestion
git clone https://github.com/zsh-users/zsh-autosuggestions.git

# zsh-syntax-highlighting
git clone https://github.com/zsh-users/zsh-syntax-highlighting.git
```



### oh-my-zsh Configuration

```shell
plugins=(
        git
        z
        zsh-autosuggestions
        zsh-syntax-highlighting
)
```



## csvtk Configuration

```shell
csvtk genautocompletion --shell zsh
```

## Useful alias

### Shell alias

```shell
alias lt =''
alias l =''
```

### csvtk alias

```shell
alias tsv='csvtk -t'
alias p='tsv pretty'
alias pl='pretty | less -S'
filter
filter2
tsv2xlsx
mutate
mutate2
mutate3
replace
join
tcut='tsv cut'
tuniq

```

