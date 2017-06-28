CREATE TABLE anho (
    numero smallint NOT NULL,
    ciclo character varying(2) NOT NULL,
    fecha_inicio date,
    fecha_fin date,
    fecha_egreso date
);

CREATE TABLE carrera (
    codigo character varying(7) NOT NULL,
    plan_estudios smallint NOT NULL,
    tipo character varying(15) NOT NULL,
    nombre character varying(150) NOT NULL,
    estructura character varying(30) DEFAULT 'Asignaturas'::character varying NOT NULL,
    numero_ciclos smallint NOT NULL,
    total_obligatorias smallint DEFAULT 0 NOT NULL,
    total_electivas smallint,
    total_optativas smallint,
    total_humanisticas smallint,
    total_complementarias smallint,
    cum real NOT NULL,
    total_uv real NOT NULL,
    horas_sociales smallint NOT NULL,
    unidad_horas_sociales character varying(10),
    estado character varying(10) NOT NULL,
    codigo_unidad_administrativa character varying(10) NOT NULL,
    puntaje_minimo integer,
    cupo_maximo integer,
    capacidad_ocupada integer,
    codigo_unidad_academica character varying(10),
    nota_aprobacion double precision,
    titulo_m character varying(100),
    titulo_f character varying(100),
    modalidad character varying(3)
);

CREATE TABLE cambio_carrera (
    carnet_alumno character varying(10) NOT NULL,
    numero smallint NOT NULL,
    unidad_origen character varying(10),
    codigo_carrera_origen character varying(7) NOT NULL,
    plan_estudios_carrera_origen smallint NOT NULL,
    codigo_carrera_destino character varying(7) NOT NULL,
    plan_estudios_carrera_destino smallint NOT NULL,
    unidad_destino character varying(10),
    tipo_cambio character varying(1),
    fecha_cambio date
);


CREATE TABLE alumno (
    carnet character varying(10) NOT NULL,
    nota_examen_ingreso real NOT NULL,
    nombre character varying(40) NOT NULL,
    apellidos character varying(50) NOT NULL,
    sexo character varying(1) NOT NULL,
    telefono character varying(9),
    direccion character varying(150),
    fecha_nacimiento date,
    estado_civil character varying(1) NOT NULL,
    estado_laboral character varying(1) NOT NULL,
    actividad character varying(1) NOT NULL,
    nacionalidad character varying(2) DEFAULT 'sv'::character varying NOT NULL,
    departamento_sv character varying(2),
    profesion_madre character varying(2),
    profesion_padre character varying(2),
    deporte character varying(2),
    codigo_institucion_proveniencia character varying(11),
    codigo_titulo character varying(5),
    anho_titulo smallint,
    cuota_proveniencia real,
    beca_proveniencia character varying(1),
    dui character varying(20),
    pais_origen text,
    numero_opcion smallint,
    telefono2 character varying(9),
    pasaporte character varying(25),
    carnet_residencia character varying(25),
    cantidad_cambios smallint,
    nit character varying(20),
    fecha_expe_titulo date,
    tipo_alumno character varying(4),
    municipio integer,
    email character varying(250),
    id integer NOT NULL
);

CREATE TABLE ciclo (
    codigo character varying(2) NOT NULL
);

CREATE TABLE docente (
    codigo_personal character varying(10) NOT NULL,
    escalafon character varying(10) NOT NULL,
    clave_acceso character varying(10)
);

CREATE TABLE espacio (
    denominacion character varying(20) NOT NULL,
    tipo character varying(10) NOT NULL,
    capacidad_inicial smallint NOT NULL,
    capacidad_restante smallint NOT NULL,
    descripcion text,
    codigo_unidad_administrativa character varying(10) NOT NULL
);

CREATE TABLE examen_reposicion (
    carnet_alumno_exp character varying(10) NOT NULL,
    numero_matricula_exp smallint NOT NULL,
    codigo_materia_grupo_exp character varying(8) NOT NULL,
    codigo_carrera_materia_grupo_exp character varying(7) NOT NULL,
    plan_estudios_carrera_materia_grupo_exp smallint NOT NULL,
    numero_anho_grupo_exp smallint NOT NULL,
    ciclo_anho_grupo_exp character varying(2) NOT NULL,
    numero_grupo_exp character varying(5) NOT NULL,
    tipo_grupo_exp character varying(1) NOT NULL,
    notas text,
    nota_final real,
    porcentajes_notas text
);

CREATE TABLE rendimiento (
    carnet_alumno character varying(10) NOT NULL,
    codigo_carrera character varying(7) NOT NULL,
    plan_estudios_carrera smallint NOT NULL,
    promedio_global double precision DEFAULT 0.0,
    total_uv integer DEFAULT 0,
    cum_general double precision DEFAULT 0.0,
    porcentaje_carrera double precision DEFAULT 0.0,
    materias_ganadas integer DEFAULT 0,
    materias_reprobadas integer DEFAULT 0,
    ultima_matricula_reprobada integer DEFAULT 0,
    obligatorias_g integer DEFAULT 0,
    electivas_g integer DEFAULT 0,
    humanisticas_g integer DEFAULT 0,
    complementarias_g integer DEFAULT 0,
    optativas_g integer DEFAULT 0,
    progreso character varying(50) DEFAULT 'Estudiante'::character varying,
    md5_expediente character varying(100),
    md5_oferta_academica character varying(100),
    ultimo_calculo timestamp without time zone DEFAULT now()
);

CREATE TABLE retiro_materia (
    carnet_alumno character varying(10) NOT NULL,
    numero smallint NOT NULL,
    codigo_materia character varying(8) NOT NULL,
    codigo_carrera_materia character varying(7) NOT NULL,
    plan_estudios_carrera_materia smallint NOT NULL
);

CREATE TABLE examen_suficiencia (
    carnet_alumno_exp character varying(10) NOT NULL,
    numero_matricula_exp smallint NOT NULL,
    codigo_materia_grupo_exp character varying(8) NOT NULL,
    codigo_carrera_materia_grupo_exp character varying(7) NOT NULL,
    plan_estudios_carrera_materia_grupo_exp smallint NOT NULL,
    numero_anho_grupo_exp smallint NOT NULL,
    ciclo_anho_grupo_exp character varying(2) NOT NULL,
    numero_grupo_exp character varying(5) NOT NULL,
    tipo_grupo_exp character varying(1) NOT NULL,
    notas text,
    nota_final double precision
);

CREATE TABLE grupo (
    codigo_materia character varying(8) NOT NULL,
    codigo_carrera_materia character varying(7) NOT NULL,
    plan_estudios_carrera_materia smallint NOT NULL,
    numero_anho smallint NOT NULL,
    ciclo_anho character varying(2) NOT NULL,
    numero character varying(5) DEFAULT '1'::character varying NOT NULL,
    tipo character varying(1) NOT NULL,
    cupo smallint NOT NULL,
    llave character varying(8),
    porcentaje character varying(80),
    inscritos smallint DEFAULT 0,
    descrip_evaluaciones text
);

CREATE TABLE imparte_materia (
    codigo_materia character varying(8) NOT NULL,
    codigo_unidad_academica character varying(10) NOT NULL
);

CREATE TABLE materia_ciclo (
    cod_mat_cic character varying(8) NOT NULL,
    cod_car_mat_cic character varying(7) NOT NULL,
    pla_est_car_mat_cic smallint NOT NULL,
    cod_cic character varying(2) NOT NULL
);


CREATE TABLE materia (
    codigo character varying(8) NOT NULL,
    codigo_carrera character varying(7) NOT NULL,
    plan_estudios_carrera smallint NOT NULL,
    nombre character varying(100) NOT NULL,
    uv real NOT NULL,
    tipo character varying(30) DEFAULT 'Obligatoria'::character varying NOT NULL,
    prerrequisito_uv real,
    porcentaje_area_nivel1 smallint,
    codigo_area_nivel1 character varying(15),
    codigo_unidad_academica character varying(10) NOT NULL,
    materia_anual boolean DEFAULT false
 );

 CREATE TABLE matricula (
    numero smallint NOT NULL
);

 CREATE TABLE parciales (
    carnet_alumno_exp character varying(10),
    numero_matricula_exp smallint,
    codigo_materia_grupo_exp character varying(8),
    codigo_carrera_materia_grupo_exp character varying(7),
    plan_estudios_carrera_materia_grupo_exp smallint,
    numero_anho_grupo_exp smallint,
    ciclo_anho_grupo_exp character varying(2),
    numero_grupo_exp character varying(5),
    tipo_grupo_exp character varying(1),
    notas text,
    nota_final real,
    porcentajes_notas text
);

CREATE TABLE unidad_academica (
    codigo character varying(10) NOT NULL,
    nombre character varying(80) NOT NULL,
    estado character varying(10) NOT NULL,
    codigo_unidad_administrativa character varying(10) NOT NULL
 );

CREATE TABLE usuario (
    nombre character varying(30) NOT NULL,
    grupo_usuarios character varying(20) NOT NULL,
    contrasenha character varying(50) NOT NULL,
    database character varying(20),
    directorio character varying(30),
    nombre_persona character varying(80),
    apellidos_persona character varying(80),
    esta_activo boolean DEFAULT true,
    email character varying(200),
    cambiar_contrasenha boolean,
    codigo_restablecer_contrasenha character varying(10),
    bloquear_cambio_contrasenha boolean,
    fecha_contrasenha date,
    id integer NOT NULL,
    ubicacion character varying(10)
);