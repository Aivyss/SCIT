drop table AddressVO;
create table AddressVO(
    name        varchar2(30)    primary key
    ,aGroup      varchar2(30)    not null
    ,phone      varchar2(30)    not null
    ,address    varchar2(30)    not null
    ,email      varchar2(30)    not null
);

insert into AddressVO(name,aGroup,phone,address,email)values('홍길동','친구','010-1111-1111','길동이네집','hong@gmail.com');
insert into AddressVO(name,aGroup,phone,address,email)values('김철수','회사','010-2222-2222','철수네집','kim@gmail.com');
insert into AddressVO(name,aGroup,phone,address,email)values('이영희','친구','010-3333-3333','영희네집','lee@gmail.com');
insert into AddressVO(name,aGroup,phone,address,email)values('유경달','가족','010-4444-4444','경달이네집','you@gmail.com');
insert into AddressVO(name,aGroup,phone,address,email)values('정근원','대학교','010-5555-5555','근원이네집','jung@gmail.com');
insert into AddressVO(name,aGroup,phone,address,email)values('구홍길','친구','010-6666-6666','홍길이네집','ku@gmail.com');
insert into AddressVO(name,aGroup,phone,address,email)values('정지천','회사','010-7777-7777','지천이네집','jung2@gmail.com');
insert into AddressVO(name,aGroup,phone,address,email)values('안직리','가족','010-8888-8888','직리네집','an@gmail.com');
insert into AddressVO(name,aGroup,phone,address,email)values('진송달','친구','010-9999-9999','송달이네집','jin@gmail.com');
insert into AddressVO(name,aGroup,phone,address,email)values('장규새','동아리','010-1234-1234','규새네집','jang@gmail.com');
insert into AddressVO(name,aGroup,phone,address,email)values('손해보','친구','010-5678-5678','해보네집','son@gmail.com');
insert into AddressVO(name,aGroup,phone,address,email)values('임구월','동아리','010-4545-6767','구월이네집','im@gmail.com');
insert into AddressVO(name,aGroup,phone,address,email)values('전남악','친구','010-7878-9090','남악이네집','jun@gmail.com');

commit;

select
-- 속성명 as 보여질 속성명
    name    as  이름
    ,agroup as  그룹
    ,phone  as  전화번호
    ,address    as  주소
    ,email  as  이메일
from
    AddressVO
order by name asc;

select
    name    as  이름
    ,agroup as  그룹
    ,phone  as  전화번호
    ,address    as  주소
    ,email  as  이메일
from
    AddressVO
order by agroup, name asc;

select
-- 속성명 as 보여질 속성명
    name    as  이름
    ,agroup as  그룹
    ,phone  as  전화번호
    ,address    as  주소
    ,email  as  이메일
from
    AddressVO
where
    agroup = '동아리'
order by name desc;

select
-- 속성명 as 보여질 속성명
    name    as  이름
    ,agroup as  그룹
    ,phone  as  전화번호
    ,address    as  주소
    ,email  as  이메일
from
-- 가져올 릴레이션의 이름 (테이블 명)
    AddressVO
where
    agroup = '친구'
order by name desc;

select
    name as 이름
    , phone as 폰번호
from
    addressvo
where
    name like '홍%'
order by name asc;

select
    name as 이름
    ,phone as 폰번호
    ,email as 이메일
from
    addressvo
where lower(email) like lower('%Im%');

select
    name    as  이름
    ,agroup as  그룹
    ,phone  as  전화번호
    ,address    as  주소
    ,email  as  이메일
    ,length(address) as 주소길이
from
    AddressVO
where
    length(address) > 4
order by name asc;
