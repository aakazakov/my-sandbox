DROP SCHEMA IF EXISTS cinema CASCADE;
CREATE SCHEMA cinema;

SET search_path TO cinema;

DROP TABLE IF EXISTS films_tbl;
CREATE TABLE films_tbl (
  id_fld SERIAL PRIMARY KEY,
  title_fld VARCHAR(255) NOT NULL,
  duration_fld SMALLINT NOT NULL,
  price_fld INT NOT NULL
);

DROP TABLE IF EXISTS sessions_tbl;
CREATE TABLE sessions_tbl (
  id_fld SERIAL PRIMARY KEY,
  start_fld TIME NOT NULL,
  finish_tbl TIME NOT NULL
);

DROP TABLE IF EXISTS types_of_days_tbl;
CREATE TABLE types_of_days_tbl (
  id_fld SERIAL PRIMARY KEY,
  type_fld VARCHAR(32) NOT NULL,
  price_coefficient_fld SMALLINT NOT NULL
)