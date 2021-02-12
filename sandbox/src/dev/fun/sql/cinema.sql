DROP SCHEMA IF EXISTS cinema CASCADE;
CREATE SCHEMA cinema;

SET search_path TO cinema;

DROP TABLE IF EXISTS films_tbl;
CREATE TABLE films_tbl (
  id_fld SERIAL PRIMARY KEY,
  title_fld VARCHAR(255) NOT NULL,
  duration_fld SMALLINT NOT NULL,
  base_price_fld INT NOT NULL
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
  total_price INT,
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

DROP FUNCTION IF EXISTS compute_total_price(type_of_day_id INT, session_id INT,  film_id INT);
CREATE FUNCTION compute_total_price(type_of_day_id INT, session_id INT,  film_id INT) RETURNS INT AS
$$
  SELECT f.base_price_fld * tod.price_coefficient_fld * s.price_coefficient_fld 
  FROM films_tbl f, types_of_days_tbl tod, sessions_tbl s
  WHERE tod.id_fld=$1 AND s.id_fld=$2 AND f.id_fld=$3;
$$ LANGUAGE SQL;

-- ################################################################################################

INSERT INTO films_tbl (title_fld, duration_fld, base_price_fld) VALUES ('film1', 60, 50);
INSERT INTO films_tbl (title_fld, duration_fld, base_price_fld) VALUES ('film2', 90, 60);
INSERT INTO films_tbl (title_fld, duration_fld, base_price_fld) VALUES ('film3', 120, 70);

INSERT INTO sessions_tbl (start_fld, finish_tbl, price_coefficient_fld) VALUES ('07:00', '12:00', 2);
INSERT INTO sessions_tbl (start_fld, finish_tbl, price_coefficient_fld) VALUES ('12:30', '17:30', 2);
INSERT INTO sessions_tbl (start_fld, finish_tbl, price_coefficient_fld) VALUES ('18:00', '23:00', 3);
INSERT INTO sessions_tbl (start_fld, finish_tbl, price_coefficient_fld) VALUES ('23:30', '04:30', 1);

INSERT INTO types_of_days_tbl (type_fld, price_coefficient_fld) VALUES ('weekday', 1);
INSERT INTO types_of_days_tbl (type_fld, price_coefficient_fld) VALUES ('day_off', 2);
INSERT INTO types_of_days_tbl (type_fld, price_coefficient_fld) VALUES ('holiday', 3);

INSERT INTO timetable_tbl (type_of_day_id_fld, session_id_fld, film_id_fld, total_price) VALUES (1, 1, 1, compute_total_price(1, 1, 1));
INSERT INTO timetable_tbl (type_of_day_id_fld, session_id_fld, film_id_fld, total_price) VALUES (1, 1, 2, compute_total_price(1, 1, 2));
INSERT INTO timetable_tbl (type_of_day_id_fld, session_id_fld, film_id_fld, total_price) VALUES (1, 1, 3, compute_total_price(1, 1, 3));
INSERT INTO timetable_tbl (type_of_day_id_fld, session_id_fld, film_id_fld, total_price) VALUES (1, 2, 1, compute_total_price(1, 2, 1));
INSERT INTO timetable_tbl (type_of_day_id_fld, session_id_fld, film_id_fld, total_price) VALUES (1, 2, 2, compute_total_price(1, 2, 2));
INSERT INTO timetable_tbl (type_of_day_id_fld, session_id_fld, film_id_fld, total_price) VALUES (1, 3, 1, compute_total_price(1, 3, 1));
INSERT INTO timetable_tbl (type_of_day_id_fld, session_id_fld, film_id_fld, total_price) VALUES (1, 3, 2, compute_total_price(1, 3, 2));
INSERT INTO timetable_tbl (type_of_day_id_fld, session_id_fld, film_id_fld, total_price) VALUES (1, 3, 3, compute_total_price(1, 3, 3));
INSERT INTO timetable_tbl (type_of_day_id_fld, session_id_fld, film_id_fld, total_price) VALUES (1, 4, 3, compute_total_price(1, 4, 3));
