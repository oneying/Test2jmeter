;chrome����
ControlFocus("��","","Edit1")
WinWait("[CLASS:#32770]","",3)
ControlSetText("��","", "Edit1", "C:\Users\admin\.jenkins\workspace\testwebkyy\src\test\resources\test.txt")
Sleep(2000)
ControlClick("��","","Button1")
