  create schema pyme_managment;
  commit;
  use pyme_managment;
  
/*  
CREATE TABLE  PM_TYPE_PERSON(
	ID INT AUTO_INCREMENT,
    DESCRIPTION VARCHAR(20),
    constraint pk_id_type_client primary key(ID)
);*/

create table PM_COUNTRY(
ID INT AUTO_INCREMENT,
COUNTRY VARCHAR(100),
COUNTRY_CODE VARCHAR(10),
TELEPHONE_CODE VARCHAR(10),
constraint pk_id_type_country primary key (ID)
);

commit;



CREATE TABLE PM_TYPE_DOCUMENT(
	ID INT AUTO_INCREMENT,
    DESCRIPTION VARCHAR(20),
    ID_COUNTRY INT,
    constraint pk_id_type_document primary key(ID),
    constraint fk_id_country_doc foreign key(ID_COUNTRY) references PM_COUNTRY(ID)
);
COMMIT;

### Tipo de telefono (personal, laboral, celular, celular trabajo)
CREATE TABLE PM_TYPE_PHONE(
	ID INT AUTO_INCREMENT,
    DESCRIPTION VARCHAR(30),    
    constraint pk_id_type_phone primary key(ID)
);

commit;
### TIPO DE DIRECCION Y DIRECCION  
CREATE TABLE PM_TYPE_ADRESS(
	ID INT AUTO_INCREMENT,
    DESCRIPTION VARCHAR(20),
    constraint pk_id_type_adress primary key(ID)
);

commit;


create table PM_PERSON(
	ID INT auto_increment,
	NAME VARCHAR(70),
	ID_TYPE_DOCUMENT INT,
	DOCUMENT VARCHAR(20),
	TYPE_PERSON varchar(20),
	MAIN_ADRESS int,
	constraint pk_id_person PRIMARY KEY (ID),
	constraint fk_id_type_document FOREIGN KEY(ID_TYPE_DOCUMENT) REFERENCES PM_TYPE_DOCUMENT(ID)
);

COMMIT ;


create table PM_PHONE(
ID INT AUTO_INCREMENT,
PHONE VARCHAR(30),
AREA_CODE VARCHAR(20),
ID_TYPE_PHONE INT,
ID_COUNTRY INT,
ID_PERSON int,
CONSTRAINT pk_id_phone PRIMARY KEY(ID),
constraint fk_type_phone FOREIGN KEY (ID_TYPE_PHONE) references PM_TYPE_PHONE(ID),
constraint fk_country_phone FOREIGN KEY (ID_COUNTRY) references PM_COUNTRY(ID),
CONSTRAINT fk_person_phone FOREIGN KEY (ID_PERSON) references PM_PERSON(ID)

);

commit;


create table PM_ADRESS(
	ID INT AUTO_INCREMENT,
    STREET VARCHAR(30),
    NUM INT,
    APARTMENT VARCHAR(10),
    ID_TYPE_ADRESS INT,
	ID_PERSON INT,
	ID_COUNTRY INT,
	POST_CODE VARCHAR(10), ##CODIGO POSTAL
    CONSTRAINT pk_id_adress PRIMARY KEY(ID),
    CONSTRAINT fk_id_type_adress FOREIGN KEY (ID_TYPE_ADRESS) references PM_TYPE_ADRESS(ID),
	CONSTRAINT fk_id_person_adress foreign key(ID_PERSON) references PM_PERSON(ID)
);
commit;

create table PM_TYPE_VENDOR(
	ID INT auto_increment,
	DESCRIPTION varchar(30),
	CONSTRAINT pk_id_type_vendor PRIMARY KEY (ID)
);

commit;

create table PM_TYPE_CLIENT(
	ID INT auto_increment,
	DESCRIPTION varchar(30),
	CONSTRAINT pk_id_type_client PRIMARY KEY (ID)
);


commit;

create table PM_TYPE_PRODUCT(
	ID INT auto_increment,
	DESCRIPTION varchar(20),
	ID_PADRE int,
	constraint pk_id_type_product PRIMARY KEY(ID)
);
commit;

alter table PM_TYPE_PRODUCT
add constraint fk_id_type_product FOREIGN KEY (ID_PADRE) references PM_TYPE_PRODUCT(ID);
commit;

create table PM_CLIENT(
	ID INT auto_increment,
	ID_TYPE_CLIENT INT,
	ID_PERSON INT,
	CONSTRAINT pk_id_client primary key(id),
	CONSTRAINT fk_id_type_client foreign key (ID_TYPE_CLIENT) references PM_TYPE_CLIENT(ID), 
	constraint fk_id_persona_client foreign key(ID_PERSON) REFERENCES PM_PERSON(ID)
);
commit;

create table PM_VENDOR(
	ID INT auto_increment,
	ID_TYPE_VENDOR INT,
	ID_PERSON INT,
	CONSTRAINT pk_id_vendor primary key(id),
	CONSTRAINT fk_id_type_vendor foreign key (ID_TYPE_VENDOR) references PM_TYPE_VENDOR(ID), 
	constraint fk_id_persona_vendor foreign key(ID_PERSON) REFERENCES PM_PERSON(ID)
); 

commit;
/*
	alter table pm
*/