drop table Player;

create table Player(
    id          varchar2(30)        primary key
    ,name       varchar2(30)        not null
    ,team       varchar2(100)       not null
    ,salary     number              not null
    ,war        number              not null
);

insert into Player(id,name,team,salary,war)values('aaa','NC김','NC',3500,1.0);
insert into Player(id,name,team,salary,war)values('bbb','LG리','LG',4000,1.5);
insert into Player(id,name,team,salary,war)values('ccc','키움박','키움',3800,2.3);
insert into Player(id,name,team,salary,war)values('ddd','두산최','두산',6000,1.4);
insert into Player(id,name,team,salary,war)values('eee','KT정','KT',9000,2.6);
insert into Player(id,name,team,salary,war)values('fff','KIA강','KIA',5200,6.3);
insert into Player(id,name,team,salary,war)values('ggg','롯데조','롯데',3900,4.4);
insert into Player(id,name,team,salary,war)values('hhh','삼성윤','삼성',4300,1.9);
insert into Player(id,name,team,salary,war)values('iii','SK장','SK',8000,5.8);
insert into Player(id,name,team,salary,war)values('jjj','한화임','한화',7300,3.9);

insert into Player(id,name,team,salary,war)values('kkk','NC한','NC',4000,5.0);
insert into Player(id,name,team,salary,war)values('lll','LG오','LG',4898,3.5);
insert into Player(id,name,team,salary,war)values('mmm','키움서','키움',8400,1.3);
insert into Player(id,name,team,salary,war)values('nnn','두산신','두산',3300,4.4);
insert into Player(id,name,team,salary,war)values('ooo','KT권','KT',8800,8.6);
insert into Player(id,name,team,salary,war)values('ppp','KIA황','KIA',5500,5.5);
insert into Player(id,name,team,salary,war)values('qqq','롯데안','롯데',4600,6.4);
insert into Player(id,name,team,salary,war)values('rrr','삼성송','삼성',6200,2.9);
insert into Player(id,name,team,salary,war)values('sss','SK전','SK',4400,4.1);
insert into Player(id,name,team,salary,war)values('ttt','한화홍','한화',8300,4.9);
commit;
-------------------------------------------------------
select
    id  as  아이디
    ,name   as  이름
    ,team   as  팀
    ,salary as  연봉
    ,war    as  WAR
from
    player
order by name, id asc;
-------------------------------------------------------
select
    id  as  아이디
    ,name   as  이름
    ,team   as  팀
    ,salary as  연봉
    ,war    as  WAR
from
    player
where
    salary>=5000 and salary<=7000
order by salary asc;
-------------------------------------------------------
select
    id  as  아이디
    ,name   as  이름
    ,team   as  팀
    ,salary as  연봉
    ,war    as  WAR
from
    player
where 
    war>=4.0
order by team, war desc;
-------------------------------------------------------
select
    id  as  아이디
    ,name   as  이름
    ,team   as  팀
    ,salary as  연봉
    ,war    as  WAR
from
    player
where
    salary<=4000 or salary>=8000
order by salary asc;
-------------------------------------------------------
select
    id  as  아이디
    ,name   as  이름
    ,team   as  팀
    ,salary as  연봉
    ,war    as  WAR
from
    player
where 
    war>=5.0 and upper(team) != upper('KIA')
order by war asc;
-------------------------------------------------------
select
    id  as  아이디
    ,name   as  이름
    ,team   as  팀
    ,salary as  연봉
    ,war    as  WAR
from
    player
where 
    upper(team) = upper('KIA') or upper(team) = upper('SK') or upper(team) = upper('NC') 
order by team desc; 
-------------------------------------------------------
select
    id  as  아이디
    ,name   as  이름
    ,team   as  팀
    ,salary as  연봉
    ,war    as  WAR
from
    player
where 
    name like '%한%'
order by id asc; 
-------------------------------------------------------
select
    id  as  아이디
    ,name   as  이름
    ,team   as  팀
    ,salary as  연봉
    ,war    as  WAR
from
    player
where 
    (name like '%K%' or name like '%C%') and (salary>=5000 and salary<=9000)
order by war asc; 
-------------------------------------------------------
select
    EMPLOYEE_ID as  사원번호
    ,FIRST_NAME  as  성
    ,LAST_NAME   as  이름
from
    EMPLOYEES
where
    concat(FIRST_NAME, LAST_NAME) like '%nB%'
order by EMPLOYEE_ID asc;
-------------------------------------------------------
select
    EMPLOYEE_ID as  사원번호
    ,FIRST_NAME  as  성
    ,LAST_NAME   as  이름
    ,phone_number as  전화번호
from
    EMPLOYEES
where
    substr(phone_number, 9, 4) = '4567'
order by employee_id asc;
-------------------------------------------------------
select
    EMPLOYEE_ID as  사원번호
    ,FIRST_NAME  as  성
    ,LAST_NAME   as  이름
    ,phone_number as  전화번호
from
    EMPLOYEES
where
    upper(first_name) like upper('%eR%') and upper(last_name) like upper('%eR%')
order by employee_id asc;