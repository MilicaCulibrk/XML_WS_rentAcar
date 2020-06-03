INSERT INTO public.request(status) VALUES ('PENDING');
INSERT INTO public.request(status) VALUES ('PENDING');

INSERT INTO public.purchase(date_from, date_to, id_add, id_ovner, id_user, ordered, request)
	VALUES ( '24.06.2020', '30.06.2020', 1, 1, 1, false, 1);

INSERT INTO public.purchase(date_from, date_to, id_add, id_ovner, id_user, ordered, request)
	VALUES ( '24.06.2020', '30.06.2020', 2, 1,1, false, 1);

INSERT INTO public.purchase(date_from, date_to, id_add, id_ovner, id_user, ordered, request)
	VALUES ( '24.06.2020', '30.06.2020', 3, 1,1, false, 2);

