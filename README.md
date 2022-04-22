![Download](https://img.shields.io/github/downloads/Potato-DiGua/ClipboardHelper/total)
# ClipboardHelper
一款帮助开发人员使用 adb 读取/写入 Android 剪贴板的应用。
### [English README](https://github.com/Potato-DiGua/ClipboardHelper/blob/master/README_EN.md)
### [下载](https://github.com/Potato-DiGua/ClipboardHelper/releases)
# 使用方法
安装APP,使用如下adb命令操作剪贴板
```shell
# 写
adb shell am broadcast -n "com.potatodigua.clipboardhelper/.ClipperReceiver" -a clipper.set -f 32 -e text 'This may be pasted now'
# 读
adb shell am broadcast -n "com.potatodigua.clipboardhelper/.ClipperReceiver" -a clipper.get -f 32
```
