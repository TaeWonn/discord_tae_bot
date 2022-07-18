CREATE TABLE mari_shop (
    id INT unsigned NOT NULL,
    name VARCHAR(45) NOT NULL,
    amount INT unsigned NOT NULL,
    created_date date NOT NULL,
    open_type VARCHAR(20) NOT NULL,
    created_at datetime NOT NULL,
    PRIMARY KEY(id)
);