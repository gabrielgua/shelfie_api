set foreign_key_checks = 0;

delete from product;
delete from movement;
delete from inventory;
set foreign_key_checks = 1;

alter table product auto_increment = 1;
alter table movement auto_increment = 1;
alter table inventory auto_increment = 1;

insert into product(sku, name, price, description) values
('923784_WAP_CP3202', "Detergente Limpa e Extrai 1 Litro", 41.89, null),
('873451_WAP_CP3236', "Anti odor WAP 500ml gatilho", 32.89, null),
('872390_WAP_CP3201', "Detergente Limpe PRO 5 LITROS", 182.89, "Detergente muito bom...");

insert into inventory(product_id, active, current_quantity) values
(1, true, 12),
(2, true, 4),
(3, false, 0);

insert into movement(product_id, movement_type, movement_quantity, remarks) values
(1, "IN", 12, "Primeira leva"),
(2, "IN", 6, null),
(2, "OUT", -2, "Venda n.: 1283981273"),
(3, "IN", 5, "Primeira leva"),
(3, "ADJUSTMENT", -1, "Corrigindo número correto"),
(3, "OUT", -4, "Venda n.: 9087987234");