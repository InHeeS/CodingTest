WITH RECURSIVE Hours AS (
    SELECT 0 AS hour
    UNION ALL
    SELECT hour + 1
    FROM Hours
    WHERE hour < 23
)
SELECT 
    H.hour,
    COUNT(A.ANIMAL_ID) AS count
FROM 
    Hours H
LEFT JOIN 
    ANIMAL_OUTS A
ON 
    H.hour = HOUR(A.DATETIME)
GROUP BY 
    H.hour
ORDER BY 
    H.hour ASC;
