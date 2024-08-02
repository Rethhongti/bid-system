create table users(
    id INT AUTO_INCREMENT primary key,
    email varchar(255),
    username varchar(255),
    password varchar(255),
    role varchar(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);