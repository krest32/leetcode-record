--
-- @lc app=leetcode.cn id=511 lang=mysql
--
-- [511] 游戏玩法分析 I
--
-- @lc code=start
# Write your MySQL query statement below
SELECT
    player_id,
    min(event_date) first_login
from
    activity
group by
    player_id;

-- @lc code=end