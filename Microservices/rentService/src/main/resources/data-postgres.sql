INSERT INTO public.request(status) VALUES ('PENDING');
INSERT INTO public.request(status) VALUES ('PENDING');

INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request)
	VALUES ( '24.06.2020', '30.06.2020', 1, 'ss', 'mm', false, 1);

INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request)
	VALUES ( '24.06.2020', '30.06.2020', 2, 'ss', 'mm', false, 1);

INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request)
	VALUES ( '24.06.2020', '30.06.2020', 3, 'ss', 'mm', false, 2);

