INSERT INTO users (name, username, password)
VALUES ('Иван Иванов', 'ivan123', 'password1'),
       ('Мария Петрова', 'maria_pet', 'password2'),
       ('Алексей Сидоров', 'alex_s', 'password3');

INSERT INTO tasks (title, description, status, expiration_date)
VALUES ('Купить продукты', 'Купить хлеб, молоко и яйца', 'TODO', '2025-02-15 18:00:00'),
       ('Сделать домашку', 'Решить 5 задач по математике', 'IN_PROGRESS', '2025-02-14 23:59:59'),
       ('Позвонить клиенту', 'Обсудить условия контракта', 'DONE', NULL);

INSERT INTO users_tasks (user_id, task_id)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (3, 3);

INSERT INTO users_roles (user_id, role)
VALUES (1, 'ADMIN'),
       (2, 'USER'),
       (3, 'USER');
