--
-- @lc app=leetcode.cn id=586 lang=mysql
--
-- [586] 订单最多的客户
--
-- @lc code=start
# Write your MySQL query statement below
select
    customer_number
from
    orders
Group by
    customer_number
order by
    Count(*) desc
Limit
    1;

-- @lc code=end