;chrome窗口
ControlFocus("打开","","Edit1")
WinWait("[CLASS:#32770]","",3)
ControlSetText("打开","", "Edit1", "C:\Users\admin\.jenkins\workspace\testwebkyy\src\test\resources\test.txt")
Sleep(2000)
ControlClick("打开","","Button1")
