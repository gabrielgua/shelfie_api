create table product(
    id bigint not null auto_increment,
    sku varchar(36) not null unique,
    name varchar(255) not null,
    price decimal(10,2) not null,
    description text,
    image_url varchar(255),
    created_at timestamp default now(),
    updated_at timestamp default now(),

    primary key(id)
);

create table inventory(
    id bigint not null auto_increment,
    product_id bigint not null,
    active tinyint(1) not null,
    current_quantity int default 0,
    minimum_quantity int default 0,
    last_updated timestamp default now(),

    primary key (id),
    constraint fk_inventory_product foreign key (product_id) references product (id) on delete cascade
);

create table movement(
    id bigint not null auto_increment,
    product_id bigint not null,
    movement_type varchar(50) not null,
    movement_quantity int not null,
    movement_date timestamp default now(),
    remarks text,

    primary key (id),
    constraint fk_movement_product foreign key (product_id) references product (id) on delete cascade
);