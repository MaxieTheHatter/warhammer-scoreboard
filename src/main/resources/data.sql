CREATE TABLE IF NOT EXISTS Player (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250),
    army VARCHAR(250),
    score INT default 0,
    id_resource INT default null
);

CREATE TABLE IF NOT EXISTS Resource (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(250),
    resource int default 0
);

alter table Player
    add foreign key (id_resource)
    references Resource (id);

/*
insert into Resource (type) values ('Dildo points');
insert into player (name, army, id_resource)
    values (
            'Monzy',
            'Hedonites of Slaanesh',
            select id from Resource where type = 'Dildo points'
);
*/
