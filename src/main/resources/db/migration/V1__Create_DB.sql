create table collection
(
    id        bigserial not null,
    likes     int4,
    name      varchar(255),
    editor_id int8,
    primary key (id)
);
create table color
(
    id          bigserial not null,
    base_color  varchar(255),
    description varchar(255),
    hex         varchar(255),
    primary key (id)
);
create table palette
(
    id            bigserial not null,
    is_private    boolean,
    model_type    varchar(255),
    name          varchar(255),
    creator_id    int8,
    collection_id int8,
    primary key (id)
);
create table palette_color
(
    color_id   int8 not null,
    palette_id int8 not null,
    color_role varchar(255),
    primary key (color_id, palette_id)
);
create table palette_tag
(
    palette_id int8 not null,
    tag_id     int8 not null
);
create table tag
(
    id          bigserial not null,
    description varchar(255),
    name        varchar(255),
    primary key (id)
);
create table users
(
    id       bigserial not null,
    password varchar(255),
    role     varchar(255),
    username varchar(255),
    primary key (id)
);
alter table collection
    add constraint FK7i2aessmnolwpwfh6f135gudb foreign key (editor_id) references users;
alter table palette
    add constraint FKtpuqkuej514y68a071wtrwxr2 foreign key (creator_id) references users;
alter table palette
    add constraint FKenecknf3wyke36a3nlq9jp57n foreign key (collection_id) references collection;
alter table palette_color
    add constraint FKb9i0crxrg9gmqprrs7bstag3n foreign key (color_id) references color;
alter table palette_color
    add constraint FKmjly33cw8qako5qjr6b44vfmm foreign key (palette_id) references palette;
alter table palette_tag
    add constraint FKnj716nea27e8dvbwlff8fhk61 foreign key (tag_id) references tag;
alter table palette_tag
    add constraint FKsqcth5101n9a4j821piqf4tgd foreign key (palette_id) references palette;