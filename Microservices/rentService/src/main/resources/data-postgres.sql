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
	VALUES ( '2020-06-21', '2020-06-25', 12, 'ss', 'mm', false, 1, 'Suzuki Vitara SE');
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

INSERT INTO public.soap_rent_sync( agent_app_id, ms_app_id) VALUES (1, 1);
INSERT INTO public.soap_rent_sync( agent_app_id, ms_app_id) VALUES (2, 2);
INSERT INTO public.soap_rent_sync( agent_app_id, ms_app_id) VALUES (3, 3);
INSERT INTO public.soap_rent_sync( agent_app_id, ms_app_id) VALUES (4, 4);
INSERT INTO public.soap_rent_sync( agent_app_id, ms_app_id) VALUES (5, 6);
INSERT INTO public.soap_rent_sync( agent_app_id, ms_app_id) VALUES (6, 7);



