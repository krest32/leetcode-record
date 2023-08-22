--
-- @lc app=leetcode.cn id=183 lang=mysql
--
-- [183] 从不订购的客户
--
-- @lc code=start
# Write your MySQL query statement below
select
    a.name as Customers
from
    Customers a
where
    a.id not in (
        select
            distinct CustomerId
        from
            orders
    );

-- @lc code=end