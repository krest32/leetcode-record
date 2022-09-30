--
-- @lc app=leetcode.cn id=175 lang=mysql
--
-- [175] 组合两个表
--
-- @lc code=start
# Write your MySQL query statement below
select
    a.FirstName,
    a.LastName,
    b.City,
    b.State
from
    Person a
    left join Address b on a.PersonId = b.PersonId;

-- @lc code=end