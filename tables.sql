create type nombre_comp as (
	nom_pila varchar(15),
	apellido1 varchar(20),
	apellido2 varchar(20)
);

create type dir as (
	calle varchar(20),
	numero int,
	codigo_postal char(5),
	ciudad varchar(20),
	pais varchar(20)
	);

create type dim as (
	largo decimal,
	ancho decimal,
	alto decimal
);

create table Ingeniero (
	cedula char(8) not null,
	nombre nombre_comp,
	telefono char(10),
	direccion dir,
	estudios varchar(15),
	constraint pk_ingeniero primary key(cedula)
	);

create table Cliente (
	rfc char(13) not null,
	nombre nombre_comp,
	telefono char(10),
	direccion dir,
	constraint pk_cliente primary key (rfc)
	);

create table Fabricante (
	rfc char(13) not null,
	nombre varchar(25),
	direccion dir,
	constraint pk_fabricante primary key (rfc)
);

create table Distribuidor(
	rfc char(13) not null,
	nombre varchar(25),
	direccion dir,
	constraint pk_distribuidor primary key (rfc)
);

create table tipo_upper(
	id serial,
	tipo varchar(10),
	constraint pk_tipoupper primary key (id)
);

create table Armadura(
	num_serie int not null,
	modelo varchar(20),
	constraint pk_armadura primary key (num_serie)
);

create table pieza_robotica(
	id serial,
	linea text,
	color varchar(10),
	medidas dim,
	r_fabricante char(13),
	r_armadura int,
	constraint pk_piezar primary key (id),
	foreign key (r_fabricante) references Fabricante (rfc),
	foreign key (r_armadura) references Armadura (num_serie)
);

create table pieza_grande (
	constraint pk_piezag primary key(id)
) inherits (pieza_robotica);

create table pieza_chica(
	constraint pk_piezach primary key(id)
) inherits(pieza_robotica);

create table upper_body (
	tipo int,
	constraint pk_upperbody primary key (id),
	foreign key (tipo) references tipo_upper(id)
) inherits(pieza_robotica);

create table lower_body (
	altura_suelo decimal,
	constraint pk_lowerbody primary key(id)
) inherits (pieza_robotica);

create table ing_armor(
	r_ing char(8),
	r_armor int,
	foreign key (r_ing) references Ingeniero(cedula),
	foreign key (r_armor) references Armadura(num_serie)
);

create table pieces_armor(
	r_pieza int,
	r_armor int,
	foreign key (r_pieza) references pieza_robotica(id),
	foreign key (r_armor) references Armadura(num_serie)
);

create table distribuidor_fabricante(
	r_fabricante char(13),
	r_distribuidor char(13),
	foreign key (r_fabricante) references Fabricante(rfc),
	foreign key (r_distribuidor) references Distribuidor(rfc)
);

create table distribuidor_armadura(
	clave serial,
	r_armadura int,
	r_distribuidor char(13),
	contrato date,
	constraint pk_disarm primary key (clave),
	foreign key (r_armadura) references Armadura(num_serie),
	foreign key (r_distribuidor) references Distribuidor(rfc)
);

create table Ventas(
	r_armadura int,
	r_cliente char(13),
	foreign key (r_armadura) references Armadura(num_serie),
	foreign key (r_cliente) references Cliente(rfc)
);

insert into tipo_upper (tipo) values ('Brazos'), ('Pecho'), ('Casco');