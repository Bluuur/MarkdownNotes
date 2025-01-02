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



### oh-my-zsh Configuration

```shell
plugins=(
    git
    zsh-autosuggestions
    zsh-syntax-highlighting
    zsh-history-substring-search
    z
)
```



## csvtk Configuration

```shell
csvtk genautocompletion --shell zsh
```

## Useful alias

### Shell alias

```shell
alias lt='ls -lrth --color=auto'
alias ll='ls -lh --color=auto'
alias l='less -S -R'
alias abs='realpath'
```

### csvtk alias

```shell
alias concat='tsv concat'
alias filter='tsv filter'
alias filter2='tsv filter2'
alias freq='tsv freq'
alias header='tsv headers -v'
alias join='tsv join'
alias md='tsv csv2md'
alias mutate='tsv mutate'
alias mutate2='tsv mutate2'
alias pretty='tsv pretty -t -Z'
alias rename='tsv rename'
alias rename2='tsv rename2'
alias replace='tsv replace'
alias stat='tsv stat'
alias tcut='tsv cut'
alias thead='tsv head'
alias transpose='tsv transpose'
alias tsort='tsv sort'
alias tsv='csvtk -t -T -j 64'
alias tsv2xlsx='tsv csv2xlsx'
alias tuniq='tsv uniq'
alias xlsx2tsv='tsv xlsx2csv'

alias lp='bash ~/script/pretty'
alias ph='pretty -H | l'
alias pl='pretty | l'
alias hp='bash ~/script/pretty_no_header'
```

`~/script/pretty`
```shell
csvtk pretty -t -Z -S default "$1" | less -S
```
`bash ~/script/pretty_no_header`
```shell
csvtk pretty -t -Z -H "$1" | less -S
```

```shell
for i in /etc/profile.d/*.sh /etc/profile.d/sh.local ; do
    if [ -r "$i" ]; then
        if [ "${-#*i}" != "$-" ]; then 
            . "$i" >/dev/null
        else
            . "$i" >/dev/null
        fi
    fi
done


. /public/setting/profile_path >/dev/null


# If you come from bash you might have to change your $PATH.
# export PATH=$HOME/bin:$HOME/.local/bin:/usr/local/bin:$PATH

# Path to your Oh My Zsh installation.
export ZSH="/users/zhangzd/.oh-my-zsh"

# Set name of the theme to load --- if set to "random", it will
# load a random theme each time Oh My Zsh is loaded, in which case,
# to know which specific one was loaded, run: echo $RANDOM_THEME
# See https://github.com/ohmyzsh/ohmyzsh/wiki/Themes
ZSH_THEME="candy24"

# Set list of themes to pick from when loading at random
# Setting this variable when ZSH_THEME=random will cause zsh to load
# a theme from this variable instead of looking in $ZSH/themes/
# If set to an empty array, this variable will have no effect.
# ZSH_THEME_RANDOM_CANDIDATES=( "robbyrussell" "agnoster" )

# Uncomment the following line to use case-sensitive completion.
# CASE_SENSITIVE="true"

# Uncomment the following line to use hyphen-insensitive completion.
# Case-sensitive completion must be off. _ and - will be interchangeable.
# HYPHEN_INSENSITIVE="true"

# Uncomment one of the following lines to change the auto-update behavior
zstyle ':omz:update' mode disabled  # disable automatic updates
# zstyle ':omz:update' mode auto      # update automatically without asking
# zstyle ':omz:update' mode reminder  # just remind me to update when it's time

# Uncomment the following line to change how often to auto-update (in days).
# zstyle ':omz:update' frequency 13

# Uncomment the following line if pasting URLs and other text is messed up.
# DISABLE_MAGIC_FUNCTIONS="true"

# Uncomment the following line to disable colors in ls.
# DISABLE_LS_COLORS="true"

# Uncomment the following line to disable auto-setting terminal title.
# DISABLE_AUTO_TITLE="true"

# Uncomment the following line to enable command auto-correction.
ENABLE_CORRECTION="true"

# Uncomment the following line to display red dots whilst waiting for completion.
# You can also set it to another string to have that shown instead of the default red dots.
# e.g. COMPLETION_WAITING_DOTS="%F{yellow}waiting...%f"
# Caution: this setting can cause issues with multiline prompts in zsh < 5.7.1 (see #5765)
# COMPLETION_WAITING_DOTS="true"

# Uncomment the following line if you want to disable marking untracked files
# under VCS as dirty. This makes repository status check for large repositories
# much, much faster.
# DISABLE_UNTRACKED_FILES_DIRTY="true"

# Uncomment the following line if you want to change the command execution time
# stamp shown in the history command output.
# You can set one of the optional three formats:
# "mm/dd/yyyy"|"dd.mm.yyyy"|"yyyy-mm-dd"
# or set a custom format using the strftime function format specifications,
# see 'man strftime' for details.
HIST_STAMPS="yyyy-mm-dd"

# Would you like to use another custom folder than $ZSH/custom?
# ZSH_CUSTOM=/path/to/new-custom-folder

# Which plugins would you like to load?
# Standard plugins can be found in $ZSH/plugins/
# Custom plugins may be added to $ZSH_CUSTOM/plugins/
# Example format: plugins=(rails git textmate ruby lighthouse)
# Add wisely, as too many plugins slow down shell startup.
plugins=(
    git
    zsh-autosuggestions
    zsh-syntax-highlighting
    samtools
    zsh-history-substring-search
    z
)

source $ZSH/oh-my-zsh.sh

# User configuration

# export MANPATH="/usr/local/man:$MANPATH"

# You may need to manually set your language environment
# export LANG=en_US.UTF-8

# Preferred editor for local and remote sessions
# if [[ -n $SSH_CONNECTION ]]; then
#   export EDITOR='vim'
# else
#   export EDITOR='mvim'
# fi

# Compilation flags
# export ARCHFLAGS="-arch x86_64"

# Set personal aliases, overriding those provided by Oh My Zsh libs,
# plugins, and themes. Aliases can be placed here, though Oh My Zsh
# users are encouraged to define aliases within a top-level file in
# the $ZSH_CUSTOM folder, with .zsh extension. Examples:
# - $ZSH_CUSTOM/aliases.zsh
# - $ZSH_CUSTOM/macos.zsh
# For a full list of active aliases, run `alias`.
#
# Example aliases
# alias zshconfig="mate ~/.zshrc"
# alias ohmyzsh="mate ~/.oh-my-zsh"
# Lines configured by zsh-newuser-install
HISTFILE=~/.histfile
HISTSIZE=1000000
SAVEHIST=1000000
setopt extendedglob
setopt no_nomatch
# Share history in every terminal session
setopt SHARE_HISTORY
bindkey -v
# End of lines configured by zsh-newuser-install
# The following lines were added by compinstall
zstyle :compinstall filename '/users/zhangzd/.zshrc'

autoload -Uz compinit
compinit
# End of lines added by compinstall

export LC_ALL=en_US.UTF-8
export LANG=en_US.UTF-8

source ~/.alias

# User specific aliases and functions
alias l='less -S -R'
alias ll='ls -lh --color=auto'
alias lt='ls -lrth --color=auto'
alias peek='cat ~/.bashrc ~/.alias | grep alias'
alias trees="tree --du -h -C -t -F"
alias wttr="curl wttr.in/洪山区?lang=zh"
alias cht='curl cht.sh/'

# shopt -s extglob

# >>> conda initialize >>>
# !! Contents within this block are managed by 'conda init' !!
__conda_setup="$('/data1/develop/16s/soft/conda/bin/conda' 'shell.bash' 'hook' 2> /dev/null)"
if [ $? -eq 0 ]; then
    eval "$__conda_setup"
else
    if [ -f "/data1/develop/16s/soft/conda/etc/profile.d/conda.sh" ]; then
        . "/data1/develop/16s/soft/conda/etc/profile.d/conda.sh"
    else
        export PATH="/data1/develop/16s/soft/conda/bin:$PATH"
    fi
fi
unset __conda_setup
# <<< conda initialize <<<

# Enable bash completion
# if [ -f $HOME/.local/share/bash-completion/bash_completion ]; then
#     . $HOME/.local/share/bash-completion/bash_completion
# fi

# source ~/.bash_completion

# source ~/bin/mcfly.bash

alias tsv2xlsx="tsv csv2xlsx"
alias p="pretty"
alias killaux='sed "s/ \+/\t/g" | cut -f 2 | sed "s/^/kill -9 /"'
alias h='history | sed "s/^ \+[0-9]\+ \+//" | tuniq -l | sed "s/\"\"/\"/g; s/^\"//g; s/\"$//g"'

export NXF_OFFLINE='true'

alias abs="realpath"

source /users/zhangzd/.bash_completion.d/csvtk_zsh.sh

```

