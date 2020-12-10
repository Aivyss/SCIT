--[������_Mybatis_����]
create table book(
	bnum number primary key
	,title varchar2(50) not null
	,author varchar2(50) not null	
	,publisher varchar2(50) not null
	,price number default 0
	,inputdate date default sysdate
);

-- ����������
create sequence bookseq;



/**
 * ���ϴ� DML �������� �׽�Ʈ�� ���� INSERT�� ���ԵǾ� �ֽ��ϴ�. 
 **/

-- �������� ���� ���� ui-case 1
insert into
	book(
		bnum
		,title
		,author
		,publisher
		,price
	) values (
		bookseq.nextval
		'ȫ�浿��'
		'ȫ�浿'
		,'����'
		,1500000
	);
	
-- ���� ��ü ��� ui-case 2
select
	bnum
	,title
	,author
	,publisher
	,price
	,to_char(inputdate, 'yy/mm/dd')
from
	book
order by
	bnum asc;
-- ���� ���� ���� ���� ui-case 3
delete from 
	book
where
	bnum = 25;
	
-- �������� ���� ���� ui-case 4
update book
	set title = '������'
	,author = '������'
	,publisher = '������'
	,price = 200000
where
	bnum = 1235;

-- ����˻� ui-case 5
select
	bnum
	,title
	,author
	,publisher
	,price
	,to_char(inputdate, 'yy/mm/dd')	as inputdate
from
	book
where
	upper(title) like '%'||upper('ramin')||'%'
order by
	title desc;
	
-- ���ǻ纰 �ּҰ��� �˻� ui-case 6
select
    publisher
    ,min(price)	as price
from
    book
group by 
    publisher
having
    count(*)>=3
order by
	publisher asc;

-- �׽�Ʈ�� ������
insert into book(bnum, title, author, publisher, price) values (bookseq.nextval, '��Ѱ�', 'ȫ�浿', '����', 1500000);
insert into book(bnum, title, author, publisher, price) values (bookseq.nextval, '�Ѱ�', 'ȫ�浿', '����', 150000);
insert into book(bnum, title, author, publisher, price) values (bookseq.nextval, '����Ѱ�', 'ȫ�浿', '����', 15000);
insert into book(bnum, title, author, publisher, price) values (bookseq.nextval, '��Ѱ�', 'ȫ�浿', '�û�', 1300000);
insert into book(bnum, title, author, publisher, price) values (bookseq.nextval, '�Ѱ�', 'ȫ�浿', '�û�', 130000);
insert into book(bnum, title, author, publisher, price) values (bookseq.nextval, '����Ѱ�', 'ȫ�浿', '�û�', 13000);
commit;    
	