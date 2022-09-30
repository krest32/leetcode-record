--
-- @lc app=leetcode.cn id=178 lang=mysql
--
-- [178] 分数排名
--
-- @lc code=start
# Write your MySQL query statement below
SELECT
    a.Score as Score,
    (
        SELECT
            count(DISTINCT b.Score)
        from
            Scores b
        where
            b.Score >= a.Score
    ) as `Rank`
from
    Scores a
ORDER by
    a.Score DESC;

-- @lc code=end