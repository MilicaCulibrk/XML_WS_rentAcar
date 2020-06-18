INSERT INTO public.request(status) VALUES ('PENDING');
INSERT INTO public.request(status) VALUES ('PENDING');
INSERT INTO public.request(status) VALUES ('PENDING');

INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-06-21', '2020-06-29', 1, 'ss', 'mm', false, 1, 'BMW X5');

INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-06-21', '2020-06-25', 2, 'ss', 'mm', false, 1, 'Mercedes I5');

INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-06-21', '2020-06-23', 2, 'ss', 'mm', false, 2, 'Mercedes I5');
	
INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-06-26', '2020-06-29', 2, 'ss', 'mm', false, 3, 'Mercedes I5');

