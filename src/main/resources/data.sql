INSERT INTO USER(name, email, password) VALUES('Thiago', 'thiago@email.com', '$2a$10$X30c5ecb9OG8uyKQeHg29.E8vsmUNCgzAyEq2iXtFxPQipiWBGb0y');
-- Password = 123456

INSERT INTO COURSE(name, category) VALUES('Spring Boot', 'Programming');
INSERT INTO COURSE(name, category) VALUES('HTML 5', 'Front-end');

INSERT INTO TOPIC(title, message, dt_creation, status, user_id, course_id) VALUES('Doubt', 'Error on create project', '2019-05-05 18:00:00', 'NOT_ANSWERED', 1, 1);
INSERT INTO TOPIC(title, message, dt_creation, status, user_id, course_id) VALUES('Doubt 2', 'Project does not compile', '2019-05-05 19:00:00', 'NOT_ANSWERED', 1, 1);
INSERT INTO TOPIC(title, message, dt_creation, status, user_id, course_id) VALUES('Doubt 3', 'Tag HTML', '2019-05-05 20:00:00', 'NOT_ANSWERED', 1, 2);