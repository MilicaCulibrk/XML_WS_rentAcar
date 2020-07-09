INSERT INTO public.brand(brand_name)
VALUES ('Mercedes');
INSERT INTO public.brand(brand_name)
VALUES ('Suzuki');
INSERT INTO public.brand(brand_name)
VALUES ('BMW');
INSERT INTO public.brand(brand_name)
VALUES ('Audi');
INSERT INTO public.brand(brand_name)
VALUES ('Ford');
INSERT INTO public.brand(brand_name)
VALUES ('Opel');
INSERT INTO public.brand(brand_name)
VALUES ('Peugeot');
INSERT INTO public.brand(brand_name)
VALUES ('Renault');
INSERT INTO public.brand(brand_name)
VALUES ('Volkswagen');

INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('X6', '3');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('X4', '3');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('Vitara', '2');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('X2', '3');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('X3', '3');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('Cross', '2');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('X1', '3');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('X5', '3');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('Vitara SE', '2');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('206', '7');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('205', '7');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('207', '7');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('Megane', '8');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('Clio', '8');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('Espace', '8');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('Koleos', '8');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('Clio', '1');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('Vision', '1');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('Maybach', '1');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('AMG', '1');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('GLB', '1');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('GLA', '1');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('A5', '4');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('A6', '4');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('A7', '4');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('Fiesta', '5');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('Focus', '5');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('Galaxy', '5');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('Corsa', '6');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('Tigra', '6');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('Kadett', '6');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('Polo', '9');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('Passat', '9');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('Golf', '9');


INSERT INTO public.fuel_type(fuel_type_name)
VALUES ('gas');
INSERT INTO public.fuel_type(fuel_type_name)
VALUES ('bio-diesel');
INSERT INTO public.fuel_type(fuel_type_name)
VALUES ('petroleum');

INSERT INTO public.vehicle_class(vehicle_class_name)
VALUES ('A');
INSERT INTO public.vehicle_class(vehicle_class_name)
VALUES ('B');
INSERT INTO public.vehicle_class(vehicle_class_name)
VALUES ('C');
INSERT INTO public.vehicle_class(vehicle_class_name)
VALUES ('D');
INSERT INTO public.vehicle_class(vehicle_class_name)
VALUES ('Coupe');
INSERT INTO public.vehicle_class(vehicle_class_name)
VALUES ('Cabriolet');
INSERT INTO public.vehicle_class(vehicle_class_name)
VALUES ('SX4');
INSERT INTO public.vehicle_class(vehicle_class_name)
VALUES ('Limousine');
INSERT INTO public.vehicle_class(vehicle_class_name)
VALUES ('Caravan');
INSERT INTO public.vehicle_class(vehicle_class_name)
VALUES ('SUV');


INSERT INTO public.transmission_type(transmission_type_name)
VALUES ('manual');
INSERT INTO public.transmission_type(transmission_type_name)
VALUES ('automatic');
INSERT INTO public.transmission_type(transmission_type_name)
VALUES ('semi-automatic');

INSERT INTO public.company(name, password,username, email, address, city, phone_number, company_number)
VALUES ('Stasa', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','ss', 'ss@gmail.com', 'Sibinjanin Janka 9', 'Novi Sad', '0645858456', '1');


INSERT INTO public.addvertisment(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, company_id)
VALUES ('false', '2', '1500', 'Sombor', '323000', '90', '2', '1', '1', '6', '10', '1');
INSERT INTO public.addvertisment(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, company_id)
VALUES ('true', '2', '5000', 'Beograd', '440000', '130', '3', '1', '1', '5', '3', '1');
INSERT INTO public.addvertisment(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, company_id)
VALUES ('true', '4', '3000', 'Beograd', '211000', '0', '2', '2', '3', '9', '4', '1');
INSERT INTO public.addvertisment(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, company_id)
VALUES ('false', '2', '1500', 'Sombor', '553000', '90', '2', '1', '2', '2', '3', '1');
INSERT INTO public.addvertisment(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, company_id)
VALUES ('false', '2', '1500', 'Sombor', '300000', '0', '3', '2', '2', '2', '10', '1');

INSERT INTO public.comment(accepted, text, title, user_id, user_username, addvertisment_id)
VALUES ('true', 'This car was excellent and my experience was great. Addvertiser was very nice and helpful. I really recommend this car!', 'Great', 1, 'mm', 1);
INSERT INTO public.comment(accepted, text, title, user_id, user_username, addvertisment_id)
VALUES ('true', 'Everything was excellent and my experience was great.  I really recommend this car!', 'Excellent!!!!', 4, 'vm', 2);


INSERT INTO public.addvertisment_comments(addvertisment_id, comments_id)
VALUES ('1','1');
INSERT INTO public.addvertisment_comments(addvertisment_id, comments_id)
VALUES ('2','2');


INSERT INTO public.reserved_date(one_date, addvertisment_id)
VALUES ('2020-06-13', '1');
INSERT INTO public.reserved_date(one_date, addvertisment_id)
VALUES ('2020-06-14', '1');
INSERT INTO public.reserved_date(one_date, addvertisment_id)
VALUES ('2020-06-15', '1');
INSERT INTO public.reserved_date(one_date, addvertisment_id)
VALUES ('2020-06-10', '3');
INSERT INTO public.reserved_date(one_date, addvertisment_id)
VALUES ('2020-06-11', '3');
INSERT INTO public.reserved_date(one_date, addvertisment_id)
VALUES ('2020-06-19', '3');
INSERT INTO public.reserved_date(one_date, addvertisment_id)
VALUES ('2020-06-20', '3');
INSERT INTO public.reserved_date(one_date, addvertisment_id)
VALUES ('2020-06-21', '5');
INSERT INTO public.reserved_date(one_date, addvertisment_id)
VALUES ('2020-06-22', '5');
INSERT INTO public.reserved_date(one_date, addvertisment_id)
VALUES ('2020-06-23', '5');
INSERT INTO public.reserved_date(one_date, addvertisment_id)
VALUES ('2020-06-24', '5');
INSERT INTO public.reserved_date(one_date, addvertisment_id)
VALUES ('2020-06-25', '5');
INSERT INTO public.reserved_date(one_date, addvertisment_id)
VALUES ('2020-06-26', '5');

INSERT INTO public.image(url, addvertisment_id)
VALUES ('https://firebasestorage.googleapis.com/v0/b/xml-ws-rentacar.appspot.com/o/addvertisments%2F0.6084565811608329_images%20(8).jpg?alt=media&token=aec09cb8-d2ca-442f-b5fb-d1ea1cb5a03e', '1');
INSERT INTO public.image(url, addvertisment_id)
VALUES ('https://firebasestorage.googleapis.com/v0/b/xml-ws-rentacar.appspot.com/o/addvertisments%2F0.6491975468328182_images%20(4).jpg?alt=media&token=d9c8efc5-06d5-44e5-bbbb-5b9f3e6f82e4', '2');
INSERT INTO public.image(url, addvertisment_id)
VALUES ('https://firebasestorage.googleapis.com/v0/b/xml-ws-rentacar.appspot.com/o/addvertisments%2F0.6084565811608329_images%20(8).jpg?alt=media&token=aec09cb8-d2ca-442f-b5fb-d1ea1cb5a03e', '3');
INSERT INTO public.image(url, addvertisment_id)
VALUES ('https://firebasestorage.googleapis.com/v0/b/xml-ws-rentacar.appspot.com/o/addvertisments%2F0.6084565811608329_images%20(8).jpg?alt=media&token=aec09cb8-d2ca-442f-b5fb-d1ea1cb5a03e', '4');
INSERT INTO public.image(url, addvertisment_id)
VALUES ('https://firebasestorage.googleapis.com/v0/b/xml-ws-rentacar.appspot.com/o/addvertisments%2F0.6084565811608329_images%20(8).jpg?alt=media&token=aec09cb8-d2ca-442f-b5fb-d1ea1cb5a03e', '5');


INSERT INTO public.user_entity(name, surname, password, username, email, address, city, phone_number, number_of_addvertisment, active)
VALUES ('Masa', 'Matovic', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','mm', 'mm@gmail.com', 'Sibinjanin Janka 9', 'Novi Sad', '0645858028', '2', true);
INSERT INTO public.user_entity(name, surname, password, username, email, address, city, phone_number, number_of_addvertisment, active)
VALUES ('Stevan', 'Matovic', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','sm', 'sm@gmail.com', 'Sibinjanin Janka 9', 'Novi Sad', '064585467', '1', true);
INSERT INTO public.user_entity(name, surname, password, username, email, address, city, phone_number, number_of_addvertisment, active)
VALUES ('Biljana', 'Matovic', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','bm', 'bm@gmail.com', 'Sibinjanin Janka 9', 'Novi Sad', '064585899', '3', true);
INSERT INTO public.user_entity(name, surname, password, username, email, address, city, phone_number, number_of_addvertisment, active)
VALUES ('Veljko', 'Matovic', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','vm', 'vm@gmail.com', 'Sibinjanin Janka 9', 'Novi Sad', '0645850578', '2', true);


INSERT INTO public.grade(number, user_id, addvertisment_id)
VALUES ('5', '2', '1');
INSERT INTO public.grade(number, user_id, addvertisment_id)
VALUES ('3', '2', '1');
INSERT INTO public.grade(number, user_id, addvertisment_id)
VALUES ('4', '2', '1');
INSERT INTO public.grade(number, user_id, addvertisment_id)
VALUES ('3', '2', '2');
INSERT INTO public.grade(number, user_id, addvertisment_id)
VALUES ('4', '2', '3');
INSERT INTO public.grade(number, user_id, addvertisment_id)
VALUES ('5', '2', '4');

INSERT INTO public.soap_add_sync(agent_app_id, ms_app_id) VALUES (1, 9);
INSERT INTO public.soap_add_sync(agent_app_id, ms_app_id) VALUES (2, 10);
INSERT INTO public.soap_add_sync(agent_app_id, ms_app_id) VALUES (3, 11);
INSERT INTO public.soap_add_sync(agent_app_id, ms_app_id) VALUES (4, 12);
INSERT INTO public.soap_add_sync(agent_app_id, ms_app_id) VALUES (5, 12);

INSERT INTO public.request(status) VALUES ('PENDING');
INSERT INTO public.request(status) VALUES ('PAID');
INSERT INTO public.request(status) VALUES ('PENDING');
INSERT INTO public.request(status) VALUES ('PAID');
INSERT INTO public.request(status) VALUES ('PAID');
INSERT INTO public.request(status) VALUES ('PAID');


INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-06-21', '2020-06-29', 3, 'ss', 'mm', false, 1, 'BMW X5');
INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-06-21', '2020-06-25', 4, 'ss', 'mm', false, 1, 'Suzuki Vitara SE');
INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-05-21', '2020-05-23', 1, 'vm', 'ss', true, 2, 'Mercedes GLB');
INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-06-23', '2020-06-26', 3, 'ss', 'mm', false, 3, 'Suzuki Vitara SE');
INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-05-18', '2020-06-06', 2, 'ss', 'ss', true, 4, 'Renault Tigra');
INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-05-23', '2020-05-26', 3, 'ss', 'mm', true, 5, 'Suzuki Vitara SE');
INSERT INTO public.purchase(date_from, date_to, id_add, owner, client, ordered, request, brand_model)
	VALUES ( '2020-04-18', '2020-04-06', 1, 'ss', 'mm', true, 6, 'Renault Tigra');

INSERT INTO public.soap_rent_sync( agent_app_id, ms_app_id) VALUES (1, 1);
INSERT INTO public.soap_rent_sync( agent_app_id, ms_app_id) VALUES (2, 2);
INSERT INTO public.soap_rent_sync( agent_app_id, ms_app_id) VALUES (3, 3);
INSERT INTO public.soap_rent_sync( agent_app_id, ms_app_id) VALUES (4, 4);
INSERT INTO public.soap_rent_sync( agent_app_id, ms_app_id) VALUES (5, 6);
INSERT INTO public.soap_rent_sync( agent_app_id, ms_app_id) VALUES (6, 7);



