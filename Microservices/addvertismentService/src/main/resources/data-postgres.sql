
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


INSERT INTO public.addvertisment(cdw, child_seats, price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, addvertiser_id)
VALUES ('true', '2', '2000', 'Beograd', '200000', '100', '3', '1', '1', '1', '1', 'mm');
INSERT INTO public.addvertisment(cdw, child_seats, price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, addvertiser_id)
VALUES ('true', '1', '3000', 'Novi Sad', '211000', '0', '1', '2', '3', '18', '5', 'mm');
INSERT INTO public.addvertisment(cdw, child_seats, price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, addvertiser_id)
VALUES ('false', '2', '1500', 'Sombor', '300000', '90', '7', '2', '2', '11', '10', 'sm');
INSERT INTO public.addvertisment(cdw, child_seats, price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, addvertiser_id)
VALUES ('true', '2', '2000', 'Beograd', '400000', '100', '9', '3', '3', '34', '9', 'bm');
INSERT INTO public.addvertisment(cdw, child_seats, price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, addvertiser_id)
VALUES ('false', '3', '3500', 'Beograd', '100000', '70', '8', '2', '3', '31', '7', 'bm');
INSERT INTO public.addvertisment(cdw, child_seats, price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, addvertiser_id)
VALUES ('false', '2', '1500', 'Sombor', '115000', '90', '3', '2', '2', '1', '6', 'bm');
INSERT INTO public.addvertisment(cdw, child_seats, price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, addvertiser_id)
VALUES ('true', '2', '4000', 'Beograd', '285000', '100', '3', '1', '2', '1', '1', 'vm');
INSERT INTO public.addvertisment(cdw, child_seats, price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, addvertiser_id)
VALUES ('false', '1', '1000', 'Beograd', '211000', '50', '1', '1', '3', '21', '5', 'vm');
INSERT INTO public.addvertisment(cdw, child_seats, price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, addvertiser_id)
VALUES ('false', '2', '1500', 'Sombor', '323000', '90', '2', '1', '1', '6', '10', 'ss');
INSERT INTO public.addvertisment(cdw, child_seats, price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, addvertiser_id)
VALUES ('true', '2', '5000', 'Beograd', '440000', '130', '3', '1', '1', '5', '3', 'ss');
INSERT INTO public.addvertisment(cdw, child_seats, price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, addvertiser_id)
VALUES ('true', '4', '3000', 'Beograd', '211000', '0', '2', '2', '3', '9', '4', 'ss');
INSERT INTO public.addvertisment(cdw, child_seats, price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, addvertiser_id)
VALUES ('false', '2', '1500', 'Sombor', '553000', '90', '2', '2', '2', '3', '2', 'ss');
INSERT INTO public.addvertisment(cdw, child_seats, price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, addvertiser_id)
VALUES ('true', '2', '2000', 'Beograd', '98000', '130', '1', '1', '1', '22', '1', 'vs');
INSERT INTO public.addvertisment(cdw, child_seats, price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, addvertiser_id)
VALUES ('true', '1', '1500', 'Novi Sad', '211000', '0', '8', '2', '3', '30', '8', 'ms');
INSERT INTO public.addvertisment(cdw, child_seats, price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, addvertiser_id)
VALUES ('false', '2', '1500', 'Novi Sad', '300000', '170', '9', '2', '3', '33', '10', 'ms');
INSERT INTO public.addvertisment(cdw, child_seats, price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, addvertiser_id)
VALUES ('true', '3', '2000', 'Beograd', '262000', '100', '9', '1', '1', '32', '7', 'vs');
INSERT INTO public.addvertisment(cdw, child_seats, price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, addvertiser_id)
VALUES ('true', '1', '2500', 'Novi Sad', '333000', '80', '7', '2', '3', '10', '3', 'vs');
INSERT INTO public.addvertisment(cdw, child_seats, price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id, addvertiser_id)
VALUES ('false', '2', '1500', 'Sombor', '300000', '0', '3', '2', '2', '2', '10', 'ss');

INSERT INTO public.comment(accepted, text, title, user_id, user_username, addvertisment_id)
VALUES ('true', 'This car was excellent and my experience was great. Addvertiser was very nice and helpful. I really recommend this car!', 'Great', 1, 'mm', 8);
INSERT INTO public.comment(accepted, text, title, user_id, user_username, addvertisment_id)
VALUES ('true', 'I was not satisfied with this car', 'Bad', 2, 'sm', 17);
INSERT INTO public.comment(accepted, text, title, user_id, user_username, addvertisment_id)
VALUES ('true', 'Everything was good', 'Very good', 2, 'sm', 14);
INSERT INTO public.comment(accepted, text, title, user_id, user_username, addvertisment_id)
VALUES ('true', 'Everything was excellent and my experience was great.  I really recommend this car!', 'Excellent!!!!', 4, 'vm', 8);
INSERT INTO public.comment(accepted, text, title, user_id, user_username, addvertisment_id)
VALUES ('false', 'Not recommend. I was not satisfied with this car', 'Very bad', 4, 'vm', 17);
INSERT INTO public.comment(text, title, user_id, user_username, addvertisment_id)
VALUES ('Great, everything was good. Addvertiser was very nice and helpful.', 'Very good', 4, 'vm', 14);

INSERT INTO public.addvertisment_comments(addvertisment_id, comments_id)
VALUES ('8','1');
INSERT INTO public.addvertisment_comments(addvertisment_id, comments_id)
VALUES ('17','2');
INSERT INTO public.addvertisment_comments(addvertisment_id, comments_id)
VALUES ('14','3');
INSERT INTO public.addvertisment_comments(addvertisment_id, comments_id)
VALUES ('8','4');
