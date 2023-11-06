CREATE TABLE address (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    postal_code VARCHAR(10),
    street VARCHAR(100),
    number INT,
    complement VARCHAR(10),
    city VARCHAR(20),
    state VARCHAR(20),
    country VARCHAR(20)
);

CREATE TABLE customer (
   id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    document VARCHAR(20),
    address_id UUID,
    FOREIGN KEY (address_id) REFERENCES address (id) ON DELETE CASCADE
);

CREATE SEQUENCE number_sequence START 1;

CREATE TABLE account (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    number INT DEFAULT nextval('number_sequence'),
    balance DECIMAL(10, 2),
    customer_id UUID,
    FOREIGN KEY (customer_id) REFERENCES customer (id) ON DELETE CASCADE
);

