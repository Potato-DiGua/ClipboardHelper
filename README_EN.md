# ClipboardHelper
An app that helps developers read/write Android clipboard using adb.
# 使用方法
Install the APP and use the following adb command to operate the clipboard.
```shell
# 写
adb shell am broadcast -n ""com.potatodigua.clipboardhelper/.ClipperReceiver"" -f 32 -e text 'This may be pasted now'
# 读
adb shell am broadcast -n "com.potatodigua.clipboardhelper/.ClipperReceiver" -f 32
```
