-- 모든 사원의 정보 + 부서명을 얻어오는 쿼리

select e.*, d.department_name from employees e inner join departments d
on e.department_id = d.department_id;