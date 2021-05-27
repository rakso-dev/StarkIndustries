INSERT INTO public.ingeniero(
	cedula, nombre, telefono, direccion, estudios)
	VALUES ('88888888', row('Vicente', 'Corona', 'Nunez'), 1122334455, row('Sirenas', 97, '00000', 'Tangamandapio', 'Mexico'), 'Licenciatura');

--profesora, esta tabla tiene como PK la cedula y es por eso que no la trabajo como auto-incremental, el resto creo que cumple con lo solicitado