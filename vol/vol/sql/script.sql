create table enfant(
    id serial primary key,
    age_min integer not null,
    age_max integer not null,
    pourcentage_prix integer,
    date_changement timestamp default now()
);



