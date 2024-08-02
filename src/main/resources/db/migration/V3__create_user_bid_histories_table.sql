create table user_bid_histories (
    id int AUTO_INCREMENT not null primary key,
    user_id int,
    bid_id int,
    amount double,
    status enum('lost', 'win'),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    foreign key (user_id) references users(id),
    foreign key (bid_id) references bids(id)
);