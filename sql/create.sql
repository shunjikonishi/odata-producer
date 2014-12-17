create table maker (
  maker_id integer primary key,
  maker_name varchar(100),
  display_order integer,
  del_flg boolean,
  insert_date timestamp default now(),
  update_date timestamp default now()
);

create table car (
  car_id serial primary key,
  car_name varchar(100),
  maker_id int,
  display_order int,
  del_flg boolean,
  insert_date timestamp default now(),
  update_date timestamp default now()
);

alter table car add constraint fk_car_maker foreign key (maker_id) references maker(maker_id);
