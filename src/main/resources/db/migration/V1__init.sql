-- drop table if exists exchange_value;
create table exchange_value
(
    id uuid primary key,
    currency_from varchar,
    currency_to varchar,
    conversion_multiple numeric,
    time timestamp
);
insert into exchange_value(id, currency_from, currency_to, conversion_multiple, time)
values (gen_random_uuid(), 'USD', 'INR', 65, '2023-07-31 17:19:02.127519');
insert into exchange_value(id, currency_from, currency_to, conversion_multiple, time)
values (gen_random_uuid(), 'EUR', 'INR', 75, '2023-07-31 17:19:02.127519');
insert into exchange_value(id, currency_from, currency_to, conversion_multiple, time)
values (gen_random_uuid(), 'AUD', 'INR', 25, '2023-07-31 17:19:02.127519');