create table bids (
    id int AUTO_INCREMENT primary key,
    title varchar(255),
    start_price double,
    close_date TIMESTAMP,
    winner_id int,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    foreign key (winner_id) references users(id)
);