--
-- PostgreSQL database dump
--

-- Dumped from database version 10.3
-- Dumped by pg_dump version 10.3

-- Started on 2018-04-04 12:13:06




CREATE SCHEMA IF NOT EXISTS hello_schema AUTHORIZATION hello_user;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
--

--
-- TOC entry 198 (class 1259 OID 16470)
-- Name: contacts; Type: TABLE; Schema: hello_schema; Owner: postgres
--

CREATE TABLE hello_schema.contacts (
  id bigint NOT NULL,
  name character varying(255)
);


ALTER TABLE hello_schema.contacts OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16468)
-- Name: contacts_id_seq; Type: SEQUENCE; Schema: hello_schema; Owner: postgres
--

CREATE SEQUENCE hello_schema.contacts_id_seq
  AS integer
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;


ALTER TABLE hello_schema.contacts_id_seq OWNER TO postgres;

--
-- TOC entry 2803 (class 0 OID 0)
-- Dependencies: 197
-- Name: contacts_id_seq; Type: SEQUENCE OWNED BY; Schema: hello_schema; Owner: postgres
--

ALTER SEQUENCE hello_schema.contacts_id_seq OWNED BY hello_schema.contacts.id;


--
-- TOC entry 2671 (class 2604 OID 16473)
-- Name: contacts id; Type: DEFAULT; Schema: hello_schema; Owner: postgres
--

ALTER TABLE ONLY hello_schema.contacts ALTER COLUMN id SET DEFAULT nextval('hello_schema.contacts_id_seq'::regclass);


--
-- TOC entry 2673 (class 2606 OID 16475)
-- Name: contacts contacts_pkey; Type: CONSTRAINT; Schema: hello_schema; Owner: postgres
--

ALTER TABLE ONLY hello_schema.contacts
  ADD CONSTRAINT contacts_pkey PRIMARY KEY (id);


-- Completed on 2018-04-04 12:13:06

--
-- PostgreSQL database dump complete
--


INSERT INTO hello_schema.contacts (id, name) VALUES (1, 'Vasya');
INSERT INTO hello_schema.contacts (id, name) VALUES (2, 'Katya');
INSERT INTO hello_schema.contacts (id, name) VALUES (3, 'Igor');
INSERT INTO hello_schema.contacts (id, name) VALUES (4, 'Serhii');
INSERT INTO hello_schema.contacts (id, name) VALUES (5, 'Oleg');
INSERT INTO hello_schema.contacts (id, name) VALUES (6, 'Volodymyr');
INSERT INTO hello_schema.contacts (id, name) VALUES (7, 'Andrii');
INSERT INTO hello_schema.contacts (id, name) VALUES (8, 'Oleksandr');
INSERT INTO hello_schema.contacts (id, name) VALUES (9, 'Stanislav');
INSERT INTO hello_schema.contacts (id, name) VALUES (10, 'Dmytro');
INSERT INTO hello_schema.contacts (id, name) VALUES (11, 'Stepan');
INSERT INTO hello_schema.contacts (id, name) VALUES (12, 'Ivan');
INSERT INTO hello_schema.contacts (id, name) VALUES (13, 'Tanya');
INSERT INTO hello_schema.contacts (id, name) VALUES (14, 'Ylia');
INSERT INTO hello_schema.contacts (id, name) VALUES (15, 'Victoria');
