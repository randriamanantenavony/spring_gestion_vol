CREATE TABLE enfant (
    id SERIAL PRIMARY KEY,
    age_min INT NOT NULL,
    age_max INT NOT NULL,
    pourcentage_prix DECIMAL(5,2) NOT NULL
);

INSERT INTO enfant (age_min, age_max, pourcentage_prix) VALUES 
(6, 12, 75.00);



CREATE TABLE reservation (
    id SERIAL PRIMARY KEY,
    dateHeure TIMESTAMP NOT NULL,
    id_passager INT REFERENCES passager(id),
    passeport_img VARCHAR(100),
    id_etat_reservation INT REFERENCES etat_reservation(id)
);

CREATE TABLE reservation_detail (
    id_reservation_detail SERIAL PRIMARY KEY,
    id_reservation INT REFERENCES reservation(id),
    id_vol INT REFERENCES vol(id),
    id_type_siege INT REFERENCES type_siege(id),
    siege_adulte integer not NULL DEFAULT 0,
    siege_enfant integer not NULL DEFAULT 0  
);


-- data
INSERT INTO vol (dateHeureDepart, dateHeureArrivee, id_avion, id_ville_depart, id_ville_arrivee)
VALUES ('2025-04-20 08:00:00', '2025-04-20 16:00:00', 1, 1, 2);

INSERT INTO vol_detail (id_vol, id_type_siege, prix, nombre_disponible)
VALUES 
(1, 1, 300.00, 100), 
(1, 2, 600.00, 20);

-- reservation
INSERT INTO reservation (dateHeure, id_passager, passeport_img, id_etat_reservation)
VALUES (NOW(), 1, 'passeport_jean.png', 1);


-- reservation_detail
INSERT INTO reservation_detail (id_reservation, id_vol, id_type_siege, siege_adulte, siege_enfant)
VALUES (1, 1, 1, 2, 1); 


create or replace VIEW v_detail_reservation as 
SELECT
    r.id AS reservation_id,
    r.dateHeure AS date_reservation,
    p.id AS passager_id,
    p.mail AS mail_passager,
    r.passeport_img,
    er.libelle AS statut_reservation,

    rd.id_reservation_detail,
    rd.siege_adulte,
    rd.siege_enfant,

    ts.libelle AS type_siege,
    vd.prix,

    v.id AS vol_id

FROM reservation r
JOIN passager p ON r.id_passager = p.id
JOIN etat_reservation er ON r.id_etat_reservation = er.id
JOIN reservation_detail rd ON rd.id_reservation = r.id
JOIN vol v ON v.id = rd.id_vol
JOIN (
    SELECT DISTINCT ON (id_vol, id_type_siege) *
    FROM vol_detail
) vd ON vd.id_vol = v.id AND vd.id_type_siege = rd.id_type_siege
JOIN type_siege ts ON ts.id = rd.id_type_siege
JOIN ville ville_dep ON ville_dep.id = v.id_ville_depart
JOIN ville ville_arr ON ville_arr.id = v.id_ville_arrivee;

