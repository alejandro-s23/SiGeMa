--
-- PostgreSQL database dump
--

\restrict 2FMsX3cQJ2uNbUuOCesn9FwDE7Qggxchqn5ejI2HzRpmvBVW9LRuOWkopnckqab

-- Dumped from database version 18.0 (Ubuntu 18.0-1.pgdg24.04+3)
-- Dumped by pg_dump version 18.0 (Ubuntu 18.0-1.pgdg24.04+3)

CREATE USER cliente WITH SUPERUSER PASSWORD 'senha123';

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: cautelas; Type: TABLE; Schema: public; Owner: cliente
--

CREATE TABLE public.cautelas (
    id integer CONSTRAINT cautelas_id_not_null1 NOT NULL,
    material_id integer NOT NULL,
    qnt integer NOT NULL,
    data_cautela date DEFAULT CURRENT_DATE NOT NULL,
    pg character varying(10) NOT NULL,
    nome character varying(50) NOT NULL,
    obs character varying(255),
    sit_cautela boolean DEFAULT true,
    data_descautela date,
    descautelado integer DEFAULT 0,
    CONSTRAINT cautelas_qnt_check CHECK ((qnt >= 0))
);


ALTER TABLE public.cautelas OWNER TO cliente;

--
-- Name: materiais; Type: TABLE; Schema: public; Owner: cliente
--

CREATE TABLE public.materiais (
    id integer CONSTRAINT cautelas_id_not_null NOT NULL,
    material character varying(150),
    tipo character varying(25),
    previsto integer,
    existente integer,
    sit_carga boolean,
    CONSTRAINT cautelas_existente_check CHECK ((existente >= 0)),
    CONSTRAINT cautelas_previsto_check CHECK ((previsto >= 0))
);


ALTER TABLE public.materiais OWNER TO cliente;

--
-- Name: cautelas_id_seq; Type: SEQUENCE; Schema: public; Owner: cliente
--

CREATE SEQUENCE public.cautelas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.cautelas_id_seq OWNER TO cliente;

--
-- Name: cautelas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: cliente
--

ALTER SEQUENCE public.cautelas_id_seq OWNED BY public.materiais.id;


--
-- Name: cautelas_id_seq1; Type: SEQUENCE; Schema: public; Owner: cliente
--

CREATE SEQUENCE public.cautelas_id_seq1
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.cautelas_id_seq1 OWNER TO cliente;

--
-- Name: cautelas_id_seq1; Type: SEQUENCE OWNED BY; Schema: public; Owner: cliente
--

ALTER SEQUENCE public.cautelas_id_seq1 OWNED BY public.cautelas.id;


--
-- Name: cautelas id; Type: DEFAULT; Schema: public; Owner: alejandro
--

ALTER TABLE ONLY public.cautelas ALTER COLUMN id SET DEFAULT nextval('public.cautelas_id_seq1'::regclass);


--
-- Name: materiais id; Type: DEFAULT; Schema: public; Owner: alejandro
--

ALTER TABLE ONLY public.materiais ALTER COLUMN id SET DEFAULT nextval('public.cautelas_id_seq'::regclass);


--
-- Name: materiais cautelas_pkey; Type: CONSTRAINT; Schema: public; Owner: alejandro
--

ALTER TABLE ONLY public.materiais
    ADD CONSTRAINT cautelas_pkey PRIMARY KEY (id);


--
-- Name: cautelas cautelas_pkey1; Type: CONSTRAINT; Schema: public; Owner: alejandro
--

ALTER TABLE ONLY public.cautelas
    ADD CONSTRAINT cautelas_pkey1 PRIMARY KEY (id);


--
-- Name: cautelas cautelas_material_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: alejandro
--

ALTER TABLE ONLY public.cautelas
    ADD CONSTRAINT cautelas_material_id_fkey FOREIGN KEY (material_id) REFERENCES public.materiais(id);

--
-- PostgreSQL database dump complete
--

\unrestrict 2FMsX3cQJ2uNbUuOCesn9FwDE7Qggxchqn5ejI2HzRpmvBVW9LRuOWkopnckqab

