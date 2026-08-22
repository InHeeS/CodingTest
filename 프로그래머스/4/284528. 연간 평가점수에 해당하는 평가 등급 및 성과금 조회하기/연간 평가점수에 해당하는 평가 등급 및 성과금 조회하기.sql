-- R_DEPARTMENT, HR_EMPLOYEES, HR_GRADE 테이블을 이용해 사원별 성과금 정보를 조회하려합니다. 평가 점수별 등급과 등급에 따른 성과금 정보가 아래와 같을 때, 사번, 성명, 평가 등급, 성과금을 조회하는 SQL문을 작성해주세요
SELECT E.EMP_NO,
       E.EMP_NAME,
       CASE
           WHEN AVG(G.SCORE) >= 96 THEN 'S'
           WHEN AVG(G.SCORE) >= 90 THEN 'A'
           WHEN AVG(G.SCORE) >= 80 THEN 'B'
           ELSE 'C'
       END AS GRADE,
       CASE
           WHEN AVG(G.SCORE) >= 96 THEN E.SAL * 0.20
           WHEN AVG(G.SCORE) >= 90 THEN E.SAL * 0.15
           WHEN AVG(G.SCORE) >= 80 THEN E.SAL * 0.10
           ELSE 0
       END AS BONUS
FROM HR_EMPLOYEES E
JOIN HR_GRADE G ON E.EMP_NO = G.EMP_NO
GROUP BY E.EMP_NO
ORDER BY E.EMP_NO;