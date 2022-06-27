create table movie(
id bigint not null auto_increment,
genre_id bigint not null,
title varchar(50) not null,
image_link varchar(50) not null,
actors varchar(50) not null,
review varchar(200) not null,

primary key(id),
foreign key(genre_id) references genre(id)

);

