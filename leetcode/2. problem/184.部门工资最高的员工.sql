--
-- @lc app=leetcode.cn id=184 lang=mysql
--
-- [184] 部门工资最高的员工
--
-- @lc code=start
# Write your MySQL query statement below

select
    d.name as Department,
    e.name as Employee,
    salary as Salary
from
    Employee e,
    Department d,
    (
        select
            Max(salary) as max,
            departmentId
        from
            Employee
        group by
            departmentId
    ) f
where
    e.departmentId = f.departmentId
    and e.salary = f.max
    and d.id = f.departmentId;

-- @lc code=end