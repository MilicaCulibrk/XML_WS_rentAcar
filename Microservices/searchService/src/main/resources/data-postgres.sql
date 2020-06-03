
INSERT INTO public.brands(brands_name)
VALUES ('Mercedes');
INSERT INTO public.brands(brands_name)
VALUES ('Suzuki');
INSERT INTO public.brands(brands_name)
VALUES ('BMW');
INSERT INTO public.brands(brands_name)
VALUES ('Audi');
INSERT INTO public.brands(brands_name)
VALUES ('Ford');
INSERT INTO public.brands(brands_name)
VALUES ('Opel');
INSERT INTO public.brands(brands_name)
VALUES ('Peugeot');
INSERT INTO public.brands(brands_name)
VALUES ('Renault');
INSERT INTO public.brands(brands_name)
VALUES ('Volkswagen');

INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('X6', '3');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('X4', '3');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('Vitara', '2');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('X2', '3');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('X3', '3');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('Cross', '2');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('X1', '3');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('X5', '3');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('Vitara SE', '2');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('206', '7');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('205', '7');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('207', '7');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('Megane', '8');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('Clio', '8');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('Espace', '8');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('Koleos', '8');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('Clio', '1');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('Vision', '1');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('Maybach', '1');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('AMG', '1');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('GLB', '1');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('GLA', '1');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('A5', '4');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('A6', '4');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('A7', '4');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('Fiesta', '5');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('Focus', '5');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('Galaxy', '5');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('Corsa', '6');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('Tigra', '6');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('Kadett', '6');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('Polo', '9');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('Passat', '9');
INSERT INTO public.vehicle_models(vehicle_models_name, brand_id)
VALUES ('Golf', '9');


INSERT INTO public.fuel_types(fuel_types_name)
VALUES ('gas');
INSERT INTO public.fuel_types(fuel_types_name)
VALUES ('bio-diesel');
INSERT INTO public.fuel_types(fuel_types_name)
VALUES ('petroleum');

INSERT INTO public.vehicle_classes(vehicle_classes_name)
VALUES ('A');
INSERT INTO public.vehicle_classes(vehicle_classes_name)
VALUES ('B');
INSERT INTO public.vehicle_classes(vehicle_classes_name)
VALUES ('C');
INSERT INTO public.vehicle_classes(vehicle_classes_name)
VALUES ('D');
INSERT INTO public.vehicle_classes(vehicle_classes_name)
VALUES ('Coupe');
INSERT INTO public.vehicle_classes(vehicle_classes_name)
VALUES ('Cabriolet');
INSERT INTO public.vehicle_classes(vehicle_classes_name)
VALUES ('SX4');
INSERT INTO public.vehicle_classes(vehicle_classes_name)
VALUES ('Limousine');
INSERT INTO public.vehicle_classes(vehicle_classes_name)
VALUES ('Caravan');
INSERT INTO public.vehicle_classes(vehicle_classes_name)
VALUES ('SUV');


INSERT INTO public.transmission_types(transmission_types_name)
VALUES ('manual');
INSERT INTO public.transmission_types(transmission_types_name)
VALUES ('automatic');
INSERT INTO public.transmission_types(transmission_types_name)
VALUES ('semi-automatic');

INSERT INTO public.search(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id)
VALUES ('true', '2', '2000', 'Beograd', '200.000', '100', '3', '1', '1', '1', '1');
INSERT INTO public.search(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id)
VALUES ('true', '1', '3000', 'Novi Sad', '211.000', '70', '1', '2', '3', '18', '5');
INSERT INTO public.search(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id)
VALUES ('false', '2', '1500', 'Sombor', '300.000', '90', '7', '2', '2', '11', '10');
INSERT INTO public.search(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id)
VALUES ('true', '2', '2000', 'Beograd', '400.000', '100', '9', '3', '3', '34', '9');
INSERT INTO public.search(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id)
VALUES ('false', '3', '3500', 'Beograd', '100.000', '70', '8', '2', '3', '31', '7');
INSERT INTO public.search(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id)
VALUES ('false', '2', '1500', 'Sombor', '115.000', '90', '3', '2', '2', '1', '6');
INSERT INTO public.search(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id)
VALUES ('true', '2', '4000', 'Beograd', '285.000', '100', '3', '1', '2', '1', '1');
INSERT INTO public.search(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id)
VALUES ('false', '1', '1000', 'Beograd', '211.000', '50', '1', '1', '3', '21', '5');
INSERT INTO public.search(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id)
VALUES ('false', '2', '1500', 'Sombor', '323.000', '90', '2', '1', '1', '6', '10');
INSERT INTO public.search(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id)
VALUES ('true', '2', '5000', 'Beograd', '440.000', '130', '3', '1', '1', '5', '3');
INSERT INTO public.search(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id)
VALUES ('true', '4', '3000', 'Beograd', '211.000', '70', '2', '2', '3', '9', '4');
INSERT INTO public.search(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id)
VALUES ('false', '2', '1500', 'Sombor', '553.000', '90', '2', '2', '2', '3', '2');
INSERT INTO public.search(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id)
VALUES ('true', '2', '2000', 'Beograd', '98.000', '130', '1', '1', '1', '22', '1');
INSERT INTO public.search(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id)
VALUES ('true', '1', '1500', 'Novi Sad', '211.000', '200', '8', '2', '3', '30', '8');
INSERT INTO public.search(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id)
VALUES ('false', '2', '1500', 'Novi Sad', '300.000', '170', '9', '2', '3', '33', '10');
INSERT INTO public.search(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id)
VALUES ('true', '3', '2000', 'Beograd', '262.000', '100', '9', '1', '1', '32', '7');
INSERT INTO public.search(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id)
VALUES ('true', '1', '2500', 'Novi Sad', '333.000', '80', '7', '2', '3', '10', '3');
INSERT INTO public.search(cdw, child_seats, daily_price, location, mileage, mileage_limit, brand_id, fuel_type_id, transmission_type_id, vehicle_model_id, vehicle_class_id)
VALUES ('false', '2', '1500', 'Sombor', '300.000', '140', '3', '2', '2', '2', '10');