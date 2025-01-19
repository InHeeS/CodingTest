SELECT DISTINCT id, email, first_name, last_name
FROM developers a
         JOIN skillcodes b
              ON a.skill_code & b.CODE = b.CODE
WHERE CATEGORY = 'Front End'
ORDER BY 1