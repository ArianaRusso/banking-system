CREATE TABLE address (
    id UUID PRIMARY KEY,
    postal_code VARCHAR(10),
    street VARCHAR(100),
    number INT,
    complement VARCHAR(10),
    city VARCHAR(20),
    state VARCHAR(20),
    country VARCHAR(20)
);

CREATE TABLE account (
    id UUID PRIMARY KEY,
    number VARCHAR(20),
    balance DECIMAL(10, 2)
);

CREATE TABLE customer (
    id UUID PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    document VARCHAR(20),
    address_id UUID,
    FOREIGN KEY (address_id) REFERENCES address (id)
);

CREATE TABLE customer_account (
    customer_id UUID,
    account_id UUID,
    FOREIGN KEY (customer_id) REFERENCES customer (id),
    FOREIGN KEY (account_id) REFERENCES account (id)
);