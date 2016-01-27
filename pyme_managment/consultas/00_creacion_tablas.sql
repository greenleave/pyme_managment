  create schema pyme_managment;
  commit;
  use pyme_managment;
  
  
  CREATE TABLE  PM_TYPE_PERSON(
	ID INT AUTO_INCREMENT,
    DESCRIPTION VARCHAR(20),
    constraint pk_id_type_client primary key(ID)
);

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

COMMIT ;

create table PM_PHONE(
ID INT AUTO_INCREMENT,
PHONE VARCHAR(30),
AREA_CODE VARCHAR(20),
ID_TYPE_PHONE INT,
ID_COUNTRY INT,
CONSTRAINT pk_id_phone PRIMARY KEY(ID),
constraint fk_type_phone FOREIGN KEY (ID_TYPE_PHONE) references PM_TYPE_PHONE(ID),
constraint fk_country_phone FOREIGN KEY (ID_COUNTRY) references PM_COUNTRY(ID)
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

