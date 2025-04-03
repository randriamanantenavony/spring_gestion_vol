create table enfant(
    id serial primary key,
    age_min integer not null,
    age_max integer not null,
    pourcentage_prix integer,
    date_changement datetime default now()
);

alter table enfant add column date_changement timestamp default now();


