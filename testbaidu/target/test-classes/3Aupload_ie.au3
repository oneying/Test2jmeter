;IE窗口
ControlFocus("选择要加载的文件","","Edit1")
WinWait("[CLASS:#32770]","",3)
ControlSetText("选择要加载的文件","", "Edit1", "C:\Users\admin\workspace\KyyWebUITest\src\test\resources\test.txt")
Sleep(2000)
ControlClick("选择要加载的文件","","Button1")