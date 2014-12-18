create table maker (
  maker_id integer primary key,
  maker_name varchar(100),
  display_order integer,
  del_flg boolean default false,
  insert_date timestamp default now(),
  update_date timestamp default now()
);

create table car (
  car_id serial primary key,
  car_name varchar(100),
  maker_id int,
  display_order int,
  del_flg boolean default false,
  insert_date timestamp default now(),
  update_date timestamp default now()
);

INSERT INTO maker (maker_id, maker_name, display_order) VALUES (10, 'NISSAN', 1);
INSERT INTO maker (maker_id, maker_name, display_order) VALUES (20, 'TOYOTA', 2);
INSERT INTO maker (maker_id, maker_name, display_order) VALUES (30, 'HONDA', 3);
INSERT INTO maker (maker_id, maker_name, display_order) VALUES (40, 'MITSUBISHI MOTORS', 4);
INSERT INTO maker (maker_id, maker_name, display_order) VALUES (50, 'MAZDA', 5);
INSERT INTO maker (maker_id, maker_name, display_order) VALUES (60, 'SUBARU', 6);


INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (1, 'WINGROAD', 10, 1);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (2, 'X-TRAIL', 10, 2);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (3, 'ELGRAND', 10, 3);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (4, 'CUBE', 10, 4);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (5, 'NOTE', 10, 5);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (6, 'PRIUS', 20, 1);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (7, 'WISH', 20, 2);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (8, 'Vitz', 20, 3);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (9, 'ESTIMA', 20, 4);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (10, 'ALPHARD', 20, 5);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (11, 'Fit', 30, 1);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (12, 'CR-Z', 30, 2);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (13, 'FREED', 30, 3);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (14, 'GRACE', 30, 4);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (15, 'LEGEND', 30, 5);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (16, 'RVR', 40, 1);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (17, 'OUTLANDER', 40, 2);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (18, 'MIRAGE', 40, 3);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (19, 'GALANT', 40, 4);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (20, 'PAJERO', 40, 5);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (21, 'CX-3', 50, 1);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (22, 'DEMIO', 50, 2);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (23, 'AXELA', 50, 3);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (24, 'ATENZA', 50, 4);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (25, 'ROADSTER', 50, 5);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (26, 'LEGACY', 60, 1);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (27, 'FORESTER', 60, 2);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (28, 'IMPREZA', 60, 3);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (29, 'WRX', 60, 4);
INSERT INTO car (car_id, car_name, maker_id, display_order) VALUES (30, 'EXIGA', 60, 5);
