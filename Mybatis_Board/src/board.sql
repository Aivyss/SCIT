--�Խ��� ������ ���̺�
create table board(
	boardnum	number			primary key
	,name		varchar2(20)	not null
	,title		varchar2(200)	not null
	,content	varchar2(2000)	not null
	,hits		number			default 0
	,indate		date			default sysdate
);

--�Խ��� �� �Ϸù�ȣ�� ����� ������ ����
create sequence boardseq;

