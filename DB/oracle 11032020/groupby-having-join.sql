select
    sum(salary)
from
    employees;
--------------------------------------------
select
    count(*)
from
    employees;
    
select
    count(*)
from
    employees
where
    department_id = 80;
--------------------------------------------
select
    max(salary) as  최대월급
    ,min(salary)    as  최소월급
    ,avg(salary)    as  월급평균
from
    employees;
--------------------------------------------
select
    max(salary) as  최대월급
    ,min(salary)    as  최소월급
    ,avg(salary)    as  월급평균
from
    employees
where
    department_id = 80;
--------------------------------------------
select
    department_id    as 부서번호
    ,sum(salary)    as  부서당총월급
    ,avg(salary)    as 부서당평균월급
from
    employees
group by 
    department_id;
--------------------------------------------
select
    department_id    as 부서번호
    ,sum(salary)    as  부서당총월급
    ,round(avg(salary))    as 부서당평균월급
from
    employees
group by 
    department_id, job_id
having
    avg(salary) >=10000
order by
    department_id, job_id;
    
------------------------------------
-- problem 1
select
    department_id  as  부서번호
    ,trunc(avg(salary))  as 평균월급
    ,max(salary)        as  최고월급
    ,min(salary)        as  최소월급
    ,count(*)           as  사원수
from
    employees
group by 
    department_id
order by 
    department_id asc;
------------------------------------
-- problem 2
select
    job_id  as  직책
    ,count(*)    as  사원수
from
    employees
group by 
    job_id
having  
    count(*) >= 3
order by 
    job_id asc;
------------------------------------
-- problem 3
select
    to_char(hire_date, 'yyyy')   as  입사일
    ,department_id  as  부서
    ,count(to_char(hire_date, 'yyyy')) as 사원수
from
    employees
group by 
    to_char(hire_date, 'yyyy'), department_id
order by 
   to_char(hire_date, 'yyyy'), department_id  asc;
------------------------------------
--problem 4
select
    nvl2(COMMISSION_PCT, 'O', 'X') as 커미션여부
    ,count(*) as 사원수
from
     employees
group by 
    nvl2(COMMISSION_PCT, 'O', 'X')
order by 
    nvl2(COMMISSION_PCT, 'O', 'X') desc;
------------------------------------
-- hr 과제 1
select
    employee_id as  사원번호
    ,last_name   as  성
    ,first_name as  이름
    ,to_char(hire_date, 'yyyy-mm-dd')  as  입사일
from
    employees
order by 
    to_char(hire_date, 'yyyy-mm-dd') desc;

-- hr 과제 2
select
    to_char(sysdate, 'yyyy-mm-dd') as  오늘날짜
    ,to_char(trunc(to_date('2021-05-31')-sysdate))   as  남은날짜
from
    dual;
    
-- hr 과제 3
select
    employee_id as  사원번호
    ,last_name  as  성
    ,first_name  as  이름
    ,to_char(salary, 'L999,999')  as 월급
    ,to_char(nvl(COMMISSION_PCT*100, 0), '990.99')||'%'  as  보너스
    ,to_char((salary+(salary*nvl(COMMISSION_PCT, 0)))*12, 'L9999,999') as 연봉
from
    employees
order by 
    employee_id asc;
------------------------------------
-- join
select
    *  
from
    employees, departments
where
    employees.department_id = departments.department_id;

