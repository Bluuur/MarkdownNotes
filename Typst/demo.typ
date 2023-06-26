// 将 title 存入变量
#let title = [
  A fluid dynamic model
  for glacier flow
]

// 页面设置
#set page(
  paper: "a4",
  header: align(right)[
    // header
    #title
  ],
  // 页码标注格式
  numbering: "1",
)

#set heading(numbering: "1.1")

// title
#align(center, text(17pt)[
  *#title*
])



// 网格功能
// 这里用于写作者
#grid(
  columns: (1fr, 1fr),
  align(center)[
    Therese Tungsten\
    Artos Institute\
    #link("123@456.com")
  ],
  align(center)[
    Dr. John Doe\
    Artos Institute\
    #link("789@123.com")
  ]
)

// 设置文本格式
#set text(
  font: "Songti SC",
  size: 12pt,
)

你好啊

#show: rest => columns(2, rest) 

= heading one 

#lorem(100)

== heading two

#lorem(100)

// surpport .jpg .png .gif .svg
#image("hzau_logo.svg", width: 70%)

#figure(
  image("hzau_logo.svg", width: 70%),
  caption: [
    Logo of HZAU.
  ],
)<HZAU>

@HZAU is the logo of HZAU.

// new page
// #pagebreak()

// overline equation
$ G_"引力"=G (M m)/(r^3) $

// inline equation
this is inline equation $G_"引力"=G (M m)/(r^2)$

$1 times 1 = 1$

$1 < 2$

$1 <= 1$

「」（）。。“引号”引号“引号”