--
-- @lc app=leetcode.cn id=181 lang=mysql
--
-- [181] 超过经理收入的员工
--
-- @lc code=start
# Write your MySQL query statement below
select
    a.name as Employee
from
    Employee a
    join Employee b on a.managerId = b.id
where
    a.salary > b.salary;

-- @lc code=end