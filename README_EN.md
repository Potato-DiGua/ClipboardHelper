# ClipboardHelper
An app that helps developers read/write Android clipboard using adb.
### [Download](https://github.com/Potato-DiGua/ClipboardHelper/releases)
# Usage
Install the APP and use the following adb command to operate the clipboard.
```shell
# write
adb shell am broadcast -n "com.potatodigua.clipboardhelper/.ClipperReceiver" -a clipper.set -f 32 -e text 'This may be pasted now'
# read
adb shell am broadcast -n "com.potatodigua.clipboardhelper/.ClipperReceiver" -a clipper.get -f 32
```
