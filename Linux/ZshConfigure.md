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

### Theme
24h format.
```shell
PROMPT=$'%{$fg_bold[green]%}%n@%m %{$fg[blue]%}%D{[%T]} %{$reset_color%}%{$fg[white]%}[%~]%{$reset_color%} $(git_prompt_info) \
%{$fg[blue]%}->%{$fg_bold[blue]%} %#%{$reset_color%} '

ZSH_THEME_GIT_PROMPT_PREFIX="%{$fg[green]%}["
ZSH_THEME_GIT_PROMPT_SUFFIX="]%{$reset_color%}"
ZSH_THEME_GIT_PROMPT_DIRTY=" %{$fg[red]%}*%{$fg[green]%}"
ZSH_THEME_GIT_PROMPT_CLEAN=""
```

### Plugins

```shell
cd ~/.oh-my-zsh/plugins

git clone https://github.com/zsh-users/zsh-autosuggestions.git
git clone https://github.com/zsh-users/zsh-syntax-highlighting.git
git clone https://github.com/zsh-users/zsh-history-substring-search
```

## csvtk Configuration

```shell
csvtk genautocompletion --shell zsh
```

`~/script/pretty`
```shell
csvtk pretty -t -Z -S default "$1" | less -S
```
`bash ~/script/pretty_no_header`
```shell
csvtk pretty -t -Z -H "$1" | less -S
```

## CLI Tools

```shell
brew install 

icdiff
sd
lsd
eza
fzf
ripgrep
fd
atool

```

