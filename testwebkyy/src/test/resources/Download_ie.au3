;IE窗口，下载
;title:Internet Explorer
;class:#32770
;保存按钮
;class:Button
;instance:2
ControlFocus("Internet Explorer","","")
WinWait("[CLASS:#32770]","",3)
Sleep(2000)
ControlClick("Internet Explorer","","Button2")