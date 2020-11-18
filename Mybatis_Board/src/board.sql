--게시판 글정보 테이블
create table board(
	boardnum	number			primary key
	,name		varchar2(20)	not null
	,title		varchar2(200)	not null
	,content	varchar2(2000)	not null
	,hits		number			default 0
	,indate		date			default sysdate
);

--게시판 글 일련번호에 사용할 시퀀스 생성
create sequence boardseq;

