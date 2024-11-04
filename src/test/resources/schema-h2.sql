BEGIN;


CREATE TABLE IF NOT EXISTS fsweb.fruit
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ),
    name character varying(45) NOT NULL,
    price double precision NOT NULL,
    fruit_type character varying(10) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS fsweb.vegetable
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ),
    name character varying(45) NOT NULL,
    price double precision NOT NULL,
    grown_on_tree boolean NOT NULL,
    PRIMARY KEY (id)
    );
END;