--
-- @lc app=leetcode.cn id=197 lang=mysql
--
-- [197] 上升的温度
--
-- @lc code=start
# Write your MySQL query statement below
SELECT
    a.id
from
    weather a
    join weather b on datediff(a.recordDate, b.recordDate) = 1
    and a.Temperature > b.Temperature;

-- @lc code=end