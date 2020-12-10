--[역량평가_Mybatis_서점]
create table book(
	bnum number primary key
	,title varchar2(50) not null
	,author varchar2(50) not null	
	,publisher varchar2(50) not null
	,price number default 0
	,inputdate date default sysdate
);

-- 시퀀스생성
create sequence bookseq;



/**
 * 이하는 DML 쿼리문과 테스트를 위한 INSERT이 포함되어 있습니다. 
 **/

-- 도서정보 저장 예제 ui-case 1
insert into
	book(
		bnum
		,title
		,author
		,publisher
		,price
	) values (
		bookseq.nextval
		'홍길동전'
		'홍길동'
		,'동아'
		,1500000
	);
	
-- 도서 전체 출력 ui-case 2
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
-- 도서 정보 삭제 예제 ui-case 3
delete from 
	book
where
	bnum = 25;
	
-- 도서정보 수정 예제 ui-case 4
update book
	set title = '수정용'
	,author = '수정용'
	,publisher = '수정용'
	,price = 200000
where
	bnum = 1235;

-- 제목검색 ui-case 5
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
	
-- 출판사별 최소가격 검색 ui-case 6
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

-- 테스트용 데이터
insert into book(bnum, title, author, publisher, price) values (bookseq.nextval, '비싼것', '홍길동', '동아', 1500000);
insert into book(bnum, title, author, publisher, price) values (bookseq.nextval, '싼것', '홍길동', '동아', 150000);
insert into book(bnum, title, author, publisher, price) values (bookseq.nextval, '가장싼것', '홍길동', '동아', 15000);
insert into book(bnum, title, author, publisher, price) values (bookseq.nextval, '비싼것', '홍길동', '시사', 1300000);
insert into book(bnum, title, author, publisher, price) values (bookseq.nextval, '싼것', '홍길동', '시사', 130000);
insert into book(bnum, title, author, publisher, price) values (bookseq.nextval, '가장싼것', '홍길동', '시사', 13000);
commit;    
	