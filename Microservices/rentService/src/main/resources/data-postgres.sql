INSERT INTO public.request(status) VALUES ('PENDING');
INSERT INTO public.request(status) VALUES ('PAID');
INSERT INTO public.request(status) VALUES ('PENDING');
INSERT INTO public.request(status) VALUES ('PAID');
INSERT INTO public.request(status) VALUES ('PAID');
INSERT INTO public.request(status) VALUES ('PAID');
INSERT INTO public.request(status) VALUES ('PAID');
INSERT INTO public.request(status) VALUES ('PAID');

INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-06-21', '2020-06-29', 11, 'ss', 'mm', false, 1, 'BMW X5');
INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-06-21', '2020-06-25', 11, 'ss', 'mm', false, 1, 'Suzuki Vitara SE');
INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-05-21', '2020-05-23', 9, 'vm', 'ss', true, 2, 'Mercedes GLB');
INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-06-23', '2020-06-26', 11, 'ss', 'mm', false, 3, 'Suzuki Vitara SE');
INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-05-18', '2020-06-06', 10, 'ss', 'ss', true, 4, 'Renault Tigra');
INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-05-26', '2020-05-29', 17, 'vs', 'sm', true, 5, 'Peugeot 206');
INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-05-23', '2020-05-26', 11, 'ss', 'mm', true, 6, 'Suzuki Vitara SE');
INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-04-18', '2020-04-06', 9, 'ss', 'mm', true, 7, 'Renault Tigra');
INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-03-26', '2020-03-29', 17, 'vs', 'vm', true, 8, 'Peugeot 206');
INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
    VALUES ( '2020-05-21', '2020-06-03', 18, 'ss', 'mm', false, 4, 'BMW Vitara');
INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
    VALUES ( '2020-05-21', '2020-06-03', 18, 'ss', 'sm', false, 4, 'BMW Vitara');

INSERT INTO public.comment(accepted, text, title, user_id, user_username, addvertisment_id)
VALUES ('true', 'This car was excellent and my experience was great. Addvertiser was very nice and helpful. I really recommend this car!', 'Great', 1, 'mm', 9);
INSERT INTO public.comment(accepted, text, title, user_id, user_username, addvertisment_id)
VALUES ('true', 'I was not satisfied with this car', 'Bad', 2, 'sm', 10);
INSERT INTO public.comment(accepted, text, title, user_id, user_username, addvertisment_id)
VALUES ('true', 'Everything was good', 'Very good', 2, 'sm', 11);
INSERT INTO public.comment(accepted, text, title, user_id, user_username, addvertisment_id)
VALUES ('true', 'Everything was excellent and my experience was great.  I really recommend this car!', 'Excellent!!!!', 4, 'vm', 18);
INSERT INTO public.comment(accepted, text, title, user_id, user_username, addvertisment_id)
VALUES ('false', 'Not recommend. I was not satisfied with this car', 'Very bad', 4, 'vm', 18);
INSERT INTO public.comment(text, title, user_id, user_username, addvertisment_id)
VALUES ('Great, everything was good. Addvertiser was very nice and helpful.', 'Very good', 4, 'vm', 14);

INSERT INTO public.addvertisment_comments(addvertisment_id, comments_id)
VALUES ('18','1');
INSERT INTO public.addvertisment_comments(addvertisment_id, comments_id)
VALUES ('18','2');
INSERT INTO public.addvertisment_comments(addvertisment_id, comments_id)
VALUES ('9','3');
INSERT INTO public.addvertisment_comments(addvertisment_id, comments_id)
VALUES ('10','4');
INSERT INTO public.addvertisment_comments(addvertisment_id, comments_id)
VALUES ('11','5');

INSERT INTO public.grade(number, user_id, addvertisment_id)
VALUES ('5', '2', '10');
INSERT INTO public.grade(number, user_id, addvertisment_id)
VALUES ('3', '2', '10');
INSERT INTO public.grade(number, user_id, addvertisment_id)
VALUES ('4', '2', '10');
INSERT INTO public.grade(number, user_id, addvertisment_id)
VALUES ('3', '2', '18');
INSERT INTO public.grade(number, user_id, addvertisment_id)
VALUES ('4', '2', '9');
INSERT INTO public.grade(number, user_id, addvertisment_id)
VALUES ('5', '2', '9');
