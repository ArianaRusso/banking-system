ALTER TABLE account
ADD COLUMN id_customer UUID;

ALTER TABLE account
ADD CONSTRAINT fk_id_customer
FOREIGN KEY (id_customer)
REFERENCES customer (id);
