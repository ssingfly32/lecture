-- 모든 사원의 정보 + 부서명을 얻어오는 쿼리

select e.*, d.department_name from employees e inner join departments d
on e.department_id = d.department_id;

-- 사원 이름으로 사원 검색하는 쿼리문 (like문)
select e.*, d.department_name from employees e inner join departments d
on e.department_id = d.department_id where lower(e.first_name) like '%?%';

-- 사번으로 사원 검색하는 쿼리문
select e.*, d.department_name from employees e inner join departments d
on e.department_id = d.department_id where employee_id = ?;

-- 사번 오름차순
select e.*, d.department_name from employees e inner join departments d
on e.department_id = d.department_id order by employee_id;

-- 입사일 내림차순
select e.*, d.department_name from employees e inner join departments d
on e.department_id = d.department_id order by hire_date desc; 

-- 급여 내림차순
select e.*, d.department_name from employees e inner join departments d
on e.department_id = d.department_id order by salary desc; 

-- 사원을 저장하는 쿼리문
insert into employees values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);

-- 직급 정보를 얻어오는 쿼리문
select * from jobs;

-- 직속상사 정보를 얻어오는 쿼리문
select first_name||','||last_name as fullName, employee_id
from employees;

-- 부서정보를 얻어오는 쿼리문
select department_id, department_name
from departments;

-- 다음 저장될 사원의 사번을 알기 위한 쿼리문(sequence를 사용 안한다면..)
-- 시퀀스를 반드시 사용해야 할 때 : insert문이 빈번하게 사용될 때...
select max(employee_id) + 1 from employees;

-- 사원 삭제 쿼리문
delete from employees where employee_id = ?;