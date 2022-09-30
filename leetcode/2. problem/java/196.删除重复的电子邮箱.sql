--
-- @lc app=leetcode.cn id=196 lang=mysql
--
-- [196] 删除重复的电子邮箱
--
-- @lc code=start
# Please write a DELETE statement and DO NOT write a SELECT statement.
# Write your MySQL query statement below
DELETE a
from
    Person a,
    Person b
where
    a.Email = b.Email
    and a.id > b.id;

-- @lc code=end