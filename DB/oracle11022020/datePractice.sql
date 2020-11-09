select
    employee_id as  사원번호
    ,first_name as  이름
    ,last_name  as  성
    ,hire_date  as  입사일
from
    employees
where
    hire_date > '2007-01-01'
order by hire_date asc;
-----------------------------------------------------
select
    employee_id as  사원번호
    ,first_name as  이름
    ,last_name  as  성
    ,hire_date  as  입사일  
from
    employees
where
    hire_date >= '2008-01-01' and hire_date <='2008-12-31'
order by hire_date asc;
-----------------------------------------------------
select
    employee_id as  사원번호
    ,first_name as  이름
    ,last_name  as  성
    ,hire_date  as  입사일  
    ,trunc(sysdate - hire_date)  as  근무일
from
    employees
order by hire_date asc;
-----------------------------------------------------
select
    employee_id as  사원번호
    ,first_name as  이름
    ,last_name  as  성
    ,hire_date  as  입사일  
    ,trunc(sysdate - hire_date)  as  근무일
from
    employees
where 
    trunc(sysdate - hire_date) between 5700 and 6000
order by hire_date asc;