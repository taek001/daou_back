insert into department (seq, name)
values (1, '인사팀'),(2, '기획팀'),(3, '총무팀');
select setval('department_seq_seq', 3);

insert into budget (seq, amt, department_seq, quarter, year)
values
    (1, 1000000, 1, 1, 2025),
    (2, 2000000, 2, 1, 2025),
    (3, 3000000, 3, 1, 2025)
;
select setval('budget_seq_seq', 3);