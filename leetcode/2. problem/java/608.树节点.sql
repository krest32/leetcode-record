--
-- @lc app=leetcode.cn id=608 lang=mysql
--
-- [608] 树节点
--
-- @lc code=start
# Write your MySQL query statement below

SELECT
    atree.id,
    IF(
        ISNULL(atree.p_id),
        'Root',
        IF(
            atree.id IN (
                SELECT
                    p_id
                FROM
                    tree
            ),
            'Inner',
            'Leaf'
        )
    ) Type
FROM
    tree atree
ORDER BY
    atree.id;

-- @lc code=end