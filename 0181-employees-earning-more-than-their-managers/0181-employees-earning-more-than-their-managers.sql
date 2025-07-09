select Employee.Name as Employee
from Employee
    inner join Employee as Manager on Employee.managerid = Manager.id
where Employee.Salary > Manager.Salary
