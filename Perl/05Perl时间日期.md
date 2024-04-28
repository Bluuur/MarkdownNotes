# 时间日期

[toc]

## 当前时间和日期

1. `time()` 获取时间戳
2. `localtime()` 获取本地时区时间
3. `gmtime()` 获取格林威治时间

### `localtime()`

按顺序返回以下参数：

```
sec,     # 秒， 0 到 61
min,     # 分钟， 0 到 59
hour,    # 小时， 0 到 24
mday,    # 天， 1 到 31
mon,     # 月， 0 到 11
year,    # 年，从 1900 开始
wday,    # 星期几，0-6,0表示周日
yday,    # 一年中的第几天,0-364,365
isdst    # 如果夏令时有效，则为真
```

调用函数并接收参数：

```perl
(
	$sec, 
	$min, 
	$hour, 
	$mday, 
	$mon, 
	$year, 
	$wday, 
	$yday, 
	$isdst
	) = localtime();
```

直接调用：

```perl
#!/usr/bin/perl
 
$datestring = localtime();
print("date and time: $datestring\n");
```

输出：

```
date and time: Tue Apr  2 15:31:58 2024
```

