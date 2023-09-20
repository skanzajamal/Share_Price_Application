CREATE TABLE IF NOT EXISTS stock (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    symbol VARCHAR(250),
    name VARCHAR(250),
    price DOUBLE,
    exchange VARCHAR(250),
    exchange_short_name VARCHAR(250),
    type VARCHAR(250)
);

CREATE TABLE IF NOT EXISTS filter (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    symbol VARCHAR(250)
);

INSERT INTO filter (id, symbol) VALUES (1, 'SPY');
INSERT INTO filter (id, symbol) VALUES (2, 'CMCSA');
INSERT INTO filter (id, symbol) VALUES (3, 'KMI');
INSERT INTO filter (id, symbol) VALUES (4, 'FG');
