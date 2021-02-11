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
  finish_tbl TIME NOT NULL,
  price_coefficient_fld SMALLINT NOT NULL
);

DROP TABLE IF EXISTS types_of_days_tbl;
CREATE TABLE types_of_days_tbl (
  id_fld SERIAL PRIMARY KEY,
  type_fld VARCHAR(32) NOT NULL,
  price_coefficient_fld SMALLINT NOT NULL
);

DROP TABLE IF EXISTS timetable_tbl;
CREATE TABLE timetable_tbl (
  type_of_day_id_fld INT NOT NULL,
  session_id_fld INT NOT NULL,
  film_id_fld INT NOT NULL,
  price INT NOT NULL,
  CONSTRAINT timetable_pkey
    PRIMARY KEY(type_of_day_id_fld, session_id_fld, film_id_fld),
  CONSTRAINT fk_type_of_day
    FOREIGN KEY(type_of_day_id_fld)
      REFERENCES types_of_days_tbl(id_fld)
        ON DELETE CASCADE,
  CONSTRAINT fk_session
    FOREIGN KEY(session_id_fld)
      REFERENCES sessions_tbl(id_fld)
        ON DELETE CASCADE,
  CONSTRAINT fk_film
    FOREIGN KEY(film_id_fld)
      REFERENCES films_tbl(id_fld)
        ON DELETE CASCADE
);
