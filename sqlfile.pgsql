--
-- PostgreSQL database dump
--

-- Dumped from database version 10.4
-- Dumped by pg_dump version 10.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: attachment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.attachment (
    file_id integer NOT NULL,
    file_name character varying(100),
    sow_id integer
);


ALTER TABLE public.attachment OWNER TO postgres;

--
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client (
    client_id integer,
    client_name character varying(50)
);


ALTER TABLE public.client OWNER TO postgres;

--
-- Name: seq7; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq7
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq7 OWNER TO postgres;

--
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee (
    employee_id integer DEFAULT nextval('public.seq7'::regclass) NOT NULL,
    employee_name character varying(50)
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- Name: seq5; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq5
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq5 OWNER TO postgres;

--
-- Name: milestone; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.milestone (
    id integer DEFAULT nextval('public.seq5'::regclass) NOT NULL,
    project_id integer,
    milestone_name character varying(100),
    startdate date,
    enddate date,
    status character varying(20),
    completion_date date,
    acceptance_date date,
    invoice_date date
);


ALTER TABLE public.milestone OWNER TO postgres;

--
-- Name: seq4; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq4
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq4 OWNER TO postgres;

--
-- Name: project; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project (
    project_id integer DEFAULT nextval('public.seq4'::regclass) NOT NULL,
    sow_id integer,
    project_name character varying(100),
    project_startdate date,
    project_enddate date
);


ALTER TABLE public.project OWNER TO postgres;

--
-- Name: resources; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.resources (
    employee_id integer,
    project_id integer,
    startdate date,
    enddate date
);


ALTER TABLE public.resources OWNER TO postgres;

--
-- Name: seq1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq1 OWNER TO postgres;

--
-- Name: seq2; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq2
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq2 OWNER TO postgres;

--
-- Name: seq2; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.seq2 OWNED BY public.client.client_id;


--
-- Name: seq3; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq3
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq3 OWNER TO postgres;

--
-- Name: seq3; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.seq3 OWNED BY public.attachment.file_id;


--
-- Name: seq6; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq6
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq6 OWNER TO postgres;

--
-- Name: sow; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sow (
    id integer DEFAULT nextval('public.seq1'::regclass) NOT NULL,
    sow_id integer NOT NULL,
    sow_name character varying(20),
    sow_budget numeric(4,0),
    sow_status character varying(20),
    sow_startdate date,
    sow_enddate date,
    client_id integer NOT NULL,
    currency_type character varying(10),
    remarks character varying(200)
);


ALTER TABLE public.sow OWNER TO postgres;

--
-- Name: attachment file_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.attachment ALTER COLUMN file_id SET DEFAULT nextval('public.seq3'::regclass);


--
-- Name: client client_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client ALTER COLUMN client_id SET DEFAULT nextval('public.seq2'::regclass);


--
-- Data for Name: attachment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.attachment (file_id, file_name, sow_id) FROM stdin;
\.


--
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.client (client_id, client_name) FROM stdin;
3	hello
4	hello
5	hello
6	hello
\.


--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee (employee_id, employee_name) FROM stdin;
\.


--
-- Data for Name: milestone; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.milestone (id, project_id, milestone_name, startdate, enddate, status, completion_date, acceptance_date, invoice_date) FROM stdin;
\.


--
-- Data for Name: project; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.project (project_id, sow_id, project_name, project_startdate, project_enddate) FROM stdin;
\.


--
-- Data for Name: resources; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.resources (employee_id, project_id, startdate, enddate) FROM stdin;
\.


--
-- Data for Name: sow; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sow (id, sow_id, sow_name, sow_budget, sow_status, sow_startdate, sow_enddate, client_id, currency_type, remarks) FROM stdin;
\.


--
-- Name: seq1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq1', 3, true);


--
-- Name: seq2; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq2', 6, true);


--
-- Name: seq3; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq3', 4, true);


--
-- Name: seq4; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq4', 1, false);


--
-- Name: seq5; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq5', 1, false);


--
-- Name: seq6; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq6', 1, false);


--
-- Name: seq7; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq7', 1, false);


--
-- Name: attachment attachment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.attachment
    ADD CONSTRAINT attachment_pkey PRIMARY KEY (file_id);


--
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (employee_id);


--
-- Name: milestone milestone_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.milestone
    ADD CONSTRAINT milestone_pkey PRIMARY KEY (id);


--
-- Name: project project_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project
    ADD CONSTRAINT project_pkey PRIMARY KEY (project_id);


--
-- Name: sow sow_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sow
    ADD CONSTRAINT sow_pkey PRIMARY KEY (id);


--
-- Name: client uk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT uk UNIQUE (client_id);


--
-- Name: sow uk2; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sow
    ADD CONSTRAINT uk2 UNIQUE (sow_id);


--
-- Name: sow uk3; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sow
    ADD CONSTRAINT uk3 UNIQUE (sow_id);


--
-- Name: sow fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sow
    ADD CONSTRAINT fk1 FOREIGN KEY (client_id) REFERENCES public.client(client_id);


--
-- Name: attachment fk4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.attachment
    ADD CONSTRAINT fk4 FOREIGN KEY (sow_id) REFERENCES public.sow(sow_id);


--
-- Name: milestone milestone_project_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.milestone
    ADD CONSTRAINT milestone_project_id_fkey FOREIGN KEY (project_id) REFERENCES public.project(project_id);


--
-- Name: project project_sow_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project
    ADD CONSTRAINT project_sow_id_fkey FOREIGN KEY (sow_id) REFERENCES public.sow(sow_id);


--
-- Name: resources resources_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resources
    ADD CONSTRAINT resources_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.employee(employee_id);


--
-- Name: resources resources_project_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resources
    ADD CONSTRAINT resources_project_id_fkey FOREIGN KEY (project_id) REFERENCES public.project(project_id);


--
-- PostgreSQL database dump complete
--