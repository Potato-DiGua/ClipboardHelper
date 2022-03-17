# ClipboardHelper
一款帮助开发人员使用 adb 读取/写入 Android 剪贴板的应用。
# 使用方法
安装APP,使用如下adb命令操作剪贴板
```shell
# 写
adb shell am broadcast -n ""com.potatodigua.clipboardhelper/.ClipperReceiver"" -f 32 -e text 'This may be pasted now'
# 读
adb shell am broadcast -n "com.potatodigua.clipboardhelper/.ClipperReceiver" -f 32
```
