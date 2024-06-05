CREATE TABLE user (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      username VARCHAR(50) NOT NULL,
                      password VARCHAR(50) NOT NULL,
                      role VARCHAR(20) NOT NULL
);

CREATE TABLE item (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(100) NOT NULL,
                      description TEXT,
                      price DOUBLE NOT NULL,
                      sold BOOLEAN DEFAULT FALSE,
                      seller_id BIGINT,
                      CONSTRAINT fk_seller FOREIGN KEY (seller_id) REFERENCES user(id)
);
