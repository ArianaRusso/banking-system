INSERT INTO address (postal_code, street, number, complement, city, state, country)
VALUES
  ('12345', 'Rua A', 42, 'Apto 101', 'Cidade X', 'Estado Y', 'País Z'),
  ('54321', 'Rua B', 25, 'Apto 202', 'Cidade Y', 'Estado X', 'País W');


INSERT INTO customer (first_name, last_name, document, address_id)
VALUES
  ('João', 'Silva', '123456789', (SELECT id FROM address WHERE street = 'Rua A')),
  ('Maria', 'Santos', '987654321', (SELECT id FROM address WHERE street = 'Rua B'));

INSERT INTO account (balance, customer_id)
VALUES
  (1000.00, (SELECT id FROM customer WHERE first_name = 'João')),
  (2500.50, (SELECT id FROM customer WHERE first_name = 'Maria'));