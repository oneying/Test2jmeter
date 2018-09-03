;火狐窗口
;title:文件上传(英文版:File Upload)
;class:#32770
;文件名输入框
;class:Edit
;instance:1
;打开按钮
;class:Button
;instance:1

;ControlFocus("title","text",controlID) Edit1=Edit instance 1,ControlFocus()方法用于识别Window窗口
ControlFocus("File Upload","","Edit1")
; WinWait()设置3秒钟用于等待窗口的显示
  WinWait("[CLASS:#32770]","",3)
; ControlSetText()用于向“文件名”输入框内输入本地文件的路径
  ControlSetText("File Upload","", "Edit1", "C:\Users\admin\workspace\KyyWebUITest\src\test\resources\test.txt")
;固定休眠2000毫秒
  Sleep(2000)
; ControlClick()用于点击上传窗口中的“打开”按钮
  ControlClick("File Upload","","Button1")



