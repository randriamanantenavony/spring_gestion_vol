- base : 
   - enfant : id, age_min,age_max, pourcentage_prix 

CREATE TABLE enfant (
    id SERIAL PRIMARY KEY,
    age_min INT NOT NULL,
    age_max INT NOT NULL,
    pourcentage_prix DECIMAL(5,2) NOT NULL
);

INSERT INTO enfant (age_min, age_max, pourcentage_prix) VALUES 
(6, 12, 75.00);
