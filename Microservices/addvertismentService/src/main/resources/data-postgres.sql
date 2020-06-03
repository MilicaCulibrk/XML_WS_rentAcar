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

INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('X6', '3');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('X4', '3');
INSERT INTO public.vehicle_model(vehicle_model_name, brand_id)
VALUES ('Vitara', '2');

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

INSERT INTO public.transmission_type(transmission_type_name)
VALUES ('manual');
INSERT INTO public.transmission_type(transmission_type_name)
VALUES ('automatic');
INSERT INTO public.transmission_type(transmission_type_name)
VALUES ('semi-automatic');



