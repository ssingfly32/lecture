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