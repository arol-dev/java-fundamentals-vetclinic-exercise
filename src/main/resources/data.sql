INSERT INTO owner (id, name, phone, address) VALUES (1, 'Luffy', '600123123', 'Calle Mayor 1');
INSERT INTO owner (id, name, phone, address) VALUES (2, 'ViniciusJR', '600456456', 'Calle Sol 3');

-- PETS
INSERT INTO pet (id, name, type, birth_date, owner_id)
VALUES (1, 'Torete', 'DOG', '2020-01-01', 1);

-- VISITS
INSERT INTO visit (id, date, reason, pet_id)
VALUES (1, '2025-01-01', 'Vacuna', 1);