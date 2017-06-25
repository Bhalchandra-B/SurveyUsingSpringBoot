INSERT INTO public.survey(id, description, title) VALUES (1, 'Desc-1', 'title-1');

INSERT INTO questions(id, answer, question) VALUES (1, 'Russia', 'Largest Country in the World');
INSERT INTO questions(id, answer, question) VALUES (2, 'China', 'Most populous Country in the World');
INSERT INTO questions(id, answer, question) VALUES (3, 'United States', 'Highest GDP in the World');
INSERT INTO questions(id, answer, question) VALUES (4, 'India', 'Second largest English speaking country');

--insert into QuestionEntity que INNER JOIN Question_Options queOpt on que.id = queOpt.questionId (que.questionId, que.description, que.correctAns, queOpt.options) values ('Question1', 'Largest Country in the World', 'Russia', 'A');

INSERT INTO options(question_entity_id, options) VALUES (1, 'India'), (1, 'China'), (1, 'Russia'), (1, 'US');
INSERT INTO options(question_entity_id, options) VALUES (2, 'India'), (2, 'China'), (2, 'Russia'), (2, 'US');
INSERT INTO options(question_entity_id, options) VALUES (3, 'India'), (3, 'China'), (3, 'Russia'), (3, 'US');
INSERT INTO options(question_entity_id, options) VALUES (4, 'India'), (4, 'China'), (4, 'Russia'), (4, 'US');

INSERT INTO survey_questions(survey_entity_id, questions_id) VALUES (1, 1);
INSERT INTO survey_questions(survey_entity_id, questions_id) VALUES (1, 2);
INSERT INTO survey_questions(survey_entity_id, questions_id) VALUES (1, 3);
INSERT INTO survey_questions(survey_entity_id, questions_id) VALUES (1, 4);