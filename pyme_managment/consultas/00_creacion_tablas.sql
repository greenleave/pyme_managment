CREATE TABLE  PM_TYPE_CLIENT(
	ID INT AUTO_INCREMENT,
    DESCRIPTION VARCHAR(20),
    constraint pk_id_type_client primary key(ID)
);

create table PM_COUNTRY(
ID INT AUTO_INCREMENT,
DESCRIPTION VARCHAR(100),
constraint pk_id_type_country primary key (ID)
);

CREATE TABLE PM_TYPE_DOCUMENT(
	ID INT AUTO_INCREMENT,
    DESCRIPTION VARCHAR(20),
    ID_COUNTRY INT,
    constraint pk_id_type_document primary key(ID),
    constraint fk_id_country_doc foreign key(ID_COUNTRY) references PM_COUNTRY(ID)
);


CREATE TABLE PM_TYPE_PHONE(
	ID INT AUTO_INCREMENT,
    DESCRIPTION VARCHAR(20),
    constraint pk_id_type_phone primary key(ID)
);

### Tipo de telefono (personal, laboral, celular, celular trabajo)
create table PM_PHONE(
ID INT AUTO_INCREMENT,
PHONE VARCHAR(30),
ID_TYPE_PHONE INT,
CONSTRAINT pk_id_phone PRIMARY KEY(ID),
constraint fk_type_phone FOREIGN KEY (ID_TYPE_PHONE) references PM_TYPE_PHONE(ID)
);



### TIPO DE DIRECCION Y DIRECCION
CREATE TABLE PM_TYPE_ADRESS(
	ID INT AUTO_INCREMENT,
    DESCRIPTION VARCHAR(20),
    constraint pk_id_type_adress primary key(ID)
);

commit;

create table PM_ADRESS(
	ID INT AUTO_INCREMENT,
    STREET VARCHAR(30),
    NUM INT,
    APARTMENT VARCHAR(10),
    ID_TYPE_ADRESS INT,
    CONSTRAINT pk_id_adress PRIMARY KEY(ID),
    CONSTRAINT fk_id_type_adress FOREIGN KEY (ID_TYPE_ADRESS) references PM_TYPE_ADRESS(ID)
);


commit;






