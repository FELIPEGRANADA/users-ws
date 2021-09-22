-- Table: public.User

-- DROP TABLE public."User";

CREATE TABLE IF NOT EXISTS public."User"
(
    id integer NOT NULL,
    username character varying(20) COLLATE pg_catalog."default" NOT NULL,
    password character varying(20) COLLATE pg_catalog."default" NOT NULL,
    email character varying(50) COLLATE pg_catalog."default" NOT NULL,
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    phone character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "PK_ID_USER" PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public."User"
    OWNER to postgres;

COMMENT ON TABLE public."User"
    IS 'Entity User';