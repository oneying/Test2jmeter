;�������
;title:�ļ��ϴ�(Ӣ�İ�:File Upload)
;class:#32770
;�ļ��������
;class:Edit
;instance:1
;�򿪰�ť
;class:Button
;instance:1

;ControlFocus("title","text",controlID) Edit1=Edit instance 1,ControlFocus()��������ʶ��Window����
ControlFocus("File Upload","","Edit1")
; WinWait()����3�������ڵȴ����ڵ���ʾ
  WinWait("[CLASS:#32770]","",3)
; ControlSetText()�������ļ���������������뱾���ļ���·��
  ControlSetText("File Upload","", "Edit1", "C:\Users\admin\workspace\KyyWebUITest\src\test\resources\test.txt")
;�̶�����2000����
  Sleep(2000)
; ControlClick()���ڵ���ϴ������еġ��򿪡���ť
  ControlClick("File Upload","","Button1")



