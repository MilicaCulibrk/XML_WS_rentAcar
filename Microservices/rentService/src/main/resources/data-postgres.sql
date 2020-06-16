INSERT INTO public.request(status) VALUES ('PENDING');
INSERT INTO public.request(status) VALUES ('PENDING');

INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '24.06.2020', '30.06.2020', 1, 'ss', 'mm', false, 1, 'BMW X5');

INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '24.06.2020', '30.06.2020', 2, 'ss', 'mm', false, 1, 'Mercedes I5');

INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '24.06.2020', '30.06.2020', 3, 'ss', 'mm', false, 2, 'Opel Astra');

