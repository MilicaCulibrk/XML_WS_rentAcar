INSERT INTO rental.request(status) VALUES ('PENDING');
INSERT INTO rental.request(status) VALUES ('PAID');
INSERT INTO rental.request(status) VALUES ('PENDING');
INSERT INTO rental.request(status) VALUES ('PAID');
INSERT INTO rental.request(status) VALUES ('PAID');
INSERT INTO rental.request(status) VALUES ('PAID');
INSERT INTO rental.request(status) VALUES ('PAID');
INSERT INTO rental.request(status) VALUES ('PAID');


INSERT INTO rental.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-07-21', '2020-07-29', 11, 'ss', 'mm', false, 1, 'Suzuki Vitara SE');
INSERT INTO rental.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-07-21', '2020-07-25', 12, 'ss', 'mm', false, 1, 'Suzuki Vitara');
INSERT INTO rental.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-05-21', '2020-05-23', 9, 'vm', 'ss', true, 2, 'Suzuki Cross');
INSERT INTO rental.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-06-23', '2020-06-26', 11, 'ss', 'mm', false, 3, 'Suzuki Vitara SE');
INSERT INTO rental.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)

	VALUES ( '2020-05-18', '2020-06-06', 10, 'ss', 'mm', true, 4, 'BMW X3');
INSERT INTO rental.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-05-26', '2020-05-29', 3, 'vs', 'sm', true, 5, 'Peugeot 205');
INSERT INTO rental.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-05-23', '2020-05-26', 11, 'ss', 'mm', true, 6, 'Suzuki Vitara SE');

INSERT INTO rental.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-04-18', '2020-04-06', 9, 'ss', 'mm', true, 7, 'Suzuki Cross');
INSERT INTO rental.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)

	VALUES ( '2020-03-26', '2020-03-29', 18, 'vs', 'vm', true, 8, 'Peugeot 206');
INSERT INTO rental.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
    VALUES ( '2020-03-26', '2020-03-29', 17, 'vs', 'mm', false, 8, 'Volkswagen Polo');
INSERT INTO rental.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
    VALUES ( '2020-03-26', '2020-03-29', 14, 'vs', 'sm', false, 8, 'Mercedes GLA');

INSERT INTO rental.soap_rent_sync( agent_app_id, ms_app_id) VALUES (1, 1);
INSERT INTO rental.soap_rent_sync( agent_app_id, ms_app_id) VALUES (2, 2);
INSERT INTO rental.soap_rent_sync( agent_app_id, ms_app_id) VALUES (3, 3);
INSERT INTO rental.soap_rent_sync( agent_app_id, ms_app_id) VALUES (4, 4);
INSERT INTO rental.soap_rent_sync( agent_app_id, ms_app_id) VALUES (5, 6);
INSERT INTO rental.soap_rent_sync( agent_app_id, ms_app_id) VALUES (6, 7);

