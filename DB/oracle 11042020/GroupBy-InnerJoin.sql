-- Group by 문제 1
select
    job_id  as  직책
    ,trunc(avg(salary)) as  평균급여
    ,max(salary)    as  최고급여
    ,min(salary)    as  최저급여
from
    employees
group by
    job_id;
------------------------------------------------------------------------
--Group by 문제 2
select
    nvl(manager_id, 0)  as  매니저번호
    ,trunc(avg(salary)) as  평균급여
    ,max(salary)    as  최고급여
    ,min(salary)    as  최저급여
from
    employees
group by
    nvl(manager_id, 0)
order by
    nvl(manager_id, 0)  asc;
------------------------------------------------------------------------
--inner join 문제 1
select
    d.department_id   as    부서번호
    ,d.department_name  as  부서명
    ,l.street_address   as  주소
from
    departments d, locations l
where
    d.location_id = l.location_id
order by
    d.department_id asc;
------------------------------------------------------------------------
--inner join 문제 2
select
    e.employee_id   as
    ,e.first_name   as
    ,e.last_name    as
    ,e.department_id    as
    ,d.department_name  as
    ,l.street_address   as
from
    employees e, departments d, locations l
where
    e.department_id = d.department_id 
    and
    d.location_id = l.location_id
order by
    e.employee_id asc;