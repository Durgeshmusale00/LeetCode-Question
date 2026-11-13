# Write your MySQL query statement below
select e.name AS Employee 
  from Employee as e
  JOIN Employee m
  ON e.managerId = m.id
  WHERE e.salary > m.salary;

