  create schema user_center_pyme_managment;
  commit;
  use user_center_pyme_managment;

create table PM_PERMISO(
	ID INT AUTO_INCREMENT,
	NOMBRE VARCHAR(40),
	CONSTRAINT pk_id_permiso PRIMARY KEY (ID)
);

commit;

create table PM_PERFIL(
	ID INT auto_increment,
	NOMBRE VARCHAR(40),
	CONSTRAINT pk_id_perfil PRIMARY KEY (ID)
);

COMMIT;

create table PM_PERFIL_PERMISO(
ID INT auto_increment,
ID_PERFIL INT,
ID_PERMISO INT,
constraint pk_id_perfil_permiso PRIMARY KEY (ID),
constraint fk_id_perfil_permiso FOREIGN KEY (ID_PERFIL)  references PM_PERFIL (ID),
CONSTRAINT fk_id_permiso_perfil foreign key (ID_PERMISO) references PM_PERMISO(ID)
);

COMMIT;

create table PM_USER(
ID INT AUTO_INCREMENT,
name varchar(50),
username varchar(20),
password varchar(100),
email varchar(60),
locked char(1),
last_login datetime,
phone varchar(30),
constraint pk_id_user primary key (id)
);

commit;

create table PM_USER_PERFILES(
ID INT AUTO_INCREMENT,
ID_USER INT,
ID_PERFIL INT,
constraint pk_id_user_perfil primary key (id),
constraint fk_id_user_perfil foreign key(id_user) references PM_USER(ID),
constraint fk_id_prefil_user foreign key(id_perfil) references PM_PERFIL(ID)
);
commit;