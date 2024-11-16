--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3
-- Dumped by pg_dump version 16.4

-- Started on 2024-11-16 13:50:30 CST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 4345 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 240 (class 1255 OID 17462)
-- Name: new_customer(character varying, character varying, character varying, character varying, character varying, character varying, integer, character varying, integer, character varying, character varying, integer, character varying, character varying, character varying, character varying, integer, integer, character varying); Type: FUNCTION; Schema: public; Owner: makila
--

CREATE FUNCTION public.new_customer(firstname_in character varying, lastname_in character varying, address1_in character varying, address2_in character varying, city_in character varying, state_in character varying, zip_in integer, country_in character varying, region_in integer, email_in character varying, phone_in character varying, creditcardtype_in integer, creditcard_in character varying, creditcardexpiration_in character varying, username_in character varying, password_in character varying, age_in integer, income_in integer, gender_in character varying, OUT customerid_out integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
  DECLARE
    rows_returned INT;
  BEGIN
    SELECT COUNT(*) INTO rows_returned FROM CUSTOMERS WHERE USERNAME = username_in;
    IF rows_returned = 0 THEN
	    INSERT INTO CUSTOMERS
	      (
	      FIRSTNAME,
	      LASTNAME,
	      EMAIL,
	      PHONE,
	      USERNAME,
	      PASSWORD,
	      ADDRESS1,
	      ADDRESS2,
	      CITY,
	      STATE,
	      ZIP,
	      COUNTRY,
	      REGION,
	      CREDITCARDTYPE,
	      CREDITCARD,
	      CREDITCARDEXPIRATION,
	      AGE,
	      INCOME,
	      GENDER
	      )
	    VALUES
	      (
	      firstname_in,
	      lastname_in,
	      email_in,
	      phone_in,
	      username_in,
	      password_in,
	      address1_in,
	      address2_in,
	      city_in,
	      state_in,
	      zip_in,
	      country_in,
	      region_in,
	      creditcardtype_in,
	      creditcard_in,
	      creditcardexpiration_in,
	      age_in,
	      income_in,
	      gender_in
	      )
	     ;
    select currval(pg_get_serial_sequence('customers', 'customerid')) into customerid_out;
  ELSE 
  	customerid_out := 0;
  END IF;
END
$$;


ALTER FUNCTION public.new_customer(firstname_in character varying, lastname_in character varying, address1_in character varying, address2_in character varying, city_in character varying, state_in character varying, zip_in integer, country_in character varying, region_in integer, email_in character varying, phone_in character varying, creditcardtype_in integer, creditcard_in character varying, creditcardexpiration_in character varying, username_in character varying, password_in character varying, age_in integer, income_in integer, gender_in character varying, OUT customerid_out integer) OWNER TO makila;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 218 (class 1259 OID 17464)
-- Name: categories; Type: TABLE; Schema: public; Owner: makila
--

CREATE TABLE public.categories (
    category integer NOT NULL,
    categoryname character varying(50) NOT NULL
);


ALTER TABLE public.categories OWNER TO makila;

--
-- TOC entry 217 (class 1259 OID 17463)
-- Name: categories_category_seq; Type: SEQUENCE; Schema: public; Owner: makila
--

CREATE SEQUENCE public.categories_category_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.categories_category_seq OWNER TO makila;

--
-- TOC entry 4346 (class 0 OID 0)
-- Dependencies: 217
-- Name: categories_category_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: makila
--

ALTER SEQUENCE public.categories_category_seq OWNED BY public.categories.category;


--
-- TOC entry 219 (class 1259 OID 17468)
-- Name: cust_hist; Type: TABLE; Schema: public; Owner: makila
--

CREATE TABLE public.cust_hist (
    customerid integer NOT NULL,
    orderid integer NOT NULL,
    prod_id integer NOT NULL
);


ALTER TABLE public.cust_hist OWNER TO makila;

--
-- TOC entry 221 (class 1259 OID 17472)
-- Name: customers; Type: TABLE; Schema: public; Owner: makila
--

CREATE TABLE public.customers (
    customerid integer NOT NULL,
    firstname character varying(50) NOT NULL,
    lastname character varying(50) NOT NULL,
    address1 character varying(50) NOT NULL,
    address2 character varying(50),
    city character varying(50) NOT NULL,
    state character varying(50),
    zip integer,
    country character varying(50) NOT NULL,
    region smallint NOT NULL,
    email character varying(50),
    phone character varying(50),
    creditcardtype integer NOT NULL,
    creditcard character varying(50) NOT NULL,
    creditcardexpiration character varying(50) NOT NULL,
    username character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    age smallint,
    income integer,
    gender character varying(1),
    delivery_info jsonb
);


ALTER TABLE public.customers OWNER TO makila;

--
-- TOC entry 220 (class 1259 OID 17471)
-- Name: customers_customerid_seq; Type: SEQUENCE; Schema: public; Owner: makila
--

CREATE SEQUENCE public.customers_customerid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.customers_customerid_seq OWNER TO makila;

--
-- TOC entry 4347 (class 0 OID 0)
-- Dependencies: 220
-- Name: customers_customerid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: makila
--

ALTER SEQUENCE public.customers_customerid_seq OWNED BY public.customers.customerid;


--
-- TOC entry 222 (class 1259 OID 17478)
-- Name: inventory; Type: TABLE; Schema: public; Owner: makila
--

CREATE TABLE public.inventory (
    prod_id integer NOT NULL,
    quan_in_stock integer NOT NULL,
    sales integer NOT NULL
);


ALTER TABLE public.inventory OWNER TO makila;

--
-- TOC entry 223 (class 1259 OID 17481)
-- Name: orderlines; Type: TABLE; Schema: public; Owner: makila
--

CREATE TABLE public.orderlines (
    orderlineid integer NOT NULL,
    orderid integer NOT NULL,
    prod_id integer NOT NULL,
    quantity smallint NOT NULL,
    orderdate date NOT NULL
);


ALTER TABLE public.orderlines OWNER TO makila;

--
-- TOC entry 225 (class 1259 OID 17485)
-- Name: orders; Type: TABLE; Schema: public; Owner: makila
--

CREATE TABLE public.orders (
    orderid integer NOT NULL,
    orderdate date NOT NULL,
    customerid integer,
    netamount numeric(12,2) NOT NULL,
    tax numeric(12,2) NOT NULL,
    totalamount numeric(12,2) NOT NULL
);


ALTER TABLE public.orders OWNER TO makila;

--
-- TOC entry 224 (class 1259 OID 17484)
-- Name: orders_orderid_seq; Type: SEQUENCE; Schema: public; Owner: makila
--

CREATE SEQUENCE public.orders_orderid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.orders_orderid_seq OWNER TO makila;

--
-- TOC entry 4348 (class 0 OID 0)
-- Dependencies: 224
-- Name: orders_orderid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: makila
--

ALTER SEQUENCE public.orders_orderid_seq OWNED BY public.orders.orderid;


--
-- TOC entry 227 (class 1259 OID 17490)
-- Name: products; Type: TABLE; Schema: public; Owner: makila
--

CREATE TABLE public.products (
    prod_id integer NOT NULL,
    category integer NOT NULL,
    title character varying(50) NOT NULL,
    actor character varying(50) NOT NULL,
    price numeric(12,2) NOT NULL,
    special smallint,
    common_prod_id integer NOT NULL,
    description text
);


ALTER TABLE public.products OWNER TO makila;

--
-- TOC entry 226 (class 1259 OID 17489)
-- Name: products_prod_id_seq; Type: SEQUENCE; Schema: public; Owner: makila
--

CREATE SEQUENCE public.products_prod_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.products_prod_id_seq OWNER TO makila;

--
-- TOC entry 4349 (class 0 OID 0)
-- Dependencies: 226
-- Name: products_prod_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: makila
--

ALTER SEQUENCE public.products_prod_id_seq OWNED BY public.products.prod_id;


--
-- TOC entry 228 (class 1259 OID 17494)
-- Name: reorder; Type: TABLE; Schema: public; Owner: makila
--

CREATE TABLE public.reorder (
    prod_id integer NOT NULL,
    date_low date NOT NULL,
    quan_low integer NOT NULL,
    date_reordered date,
    quan_reordered integer,
    date_expected date
);


ALTER TABLE public.reorder OWNER TO makila;

--
-- TOC entry 4174 (class 2604 OID 17467)
-- Name: categories category; Type: DEFAULT; Schema: public; Owner: makila
--

ALTER TABLE ONLY public.categories ALTER COLUMN category SET DEFAULT nextval('public.categories_category_seq'::regclass);


--
-- TOC entry 4175 (class 2604 OID 17475)
-- Name: customers customerid; Type: DEFAULT; Schema: public; Owner: makila
--

ALTER TABLE ONLY public.customers ALTER COLUMN customerid SET DEFAULT nextval('public.customers_customerid_seq'::regclass);


--
-- TOC entry 4176 (class 2604 OID 17488)
-- Name: orders orderid; Type: DEFAULT; Schema: public; Owner: makila
--

ALTER TABLE ONLY public.orders ALTER COLUMN orderid SET DEFAULT nextval('public.orders_orderid_seq'::regclass);


--
-- TOC entry 4177 (class 2604 OID 17493)
-- Name: products prod_id; Type: DEFAULT; Schema: public; Owner: makila
--

ALTER TABLE ONLY public.products ALTER COLUMN prod_id SET DEFAULT nextval('public.products_prod_id_seq'::regclass);


--
-- TOC entry 4179 (class 2606 OID 17498)
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: makila
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (category);


--
-- TOC entry 4182 (class 2606 OID 17500)
-- Name: customers customers_pkey; Type: CONSTRAINT; Schema: public; Owner: makila
--

ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (customerid);


--
-- TOC entry 4185 (class 2606 OID 17502)
-- Name: inventory inventory_pkey; Type: CONSTRAINT; Schema: public; Owner: makila
--

ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT inventory_pkey PRIMARY KEY (prod_id);


--
-- TOC entry 4189 (class 2606 OID 17504)
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: makila
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (orderid);


--
-- TOC entry 4193 (class 2606 OID 17506)
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: makila
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (prod_id);


--
-- TOC entry 4180 (class 1259 OID 17507)
-- Name: ix_cust_hist_customerid; Type: INDEX; Schema: public; Owner: makila
--

CREATE INDEX ix_cust_hist_customerid ON public.cust_hist USING btree (customerid);


--
-- TOC entry 4183 (class 1259 OID 17508)
-- Name: ix_cust_username; Type: INDEX; Schema: public; Owner: makila
--

CREATE UNIQUE INDEX ix_cust_username ON public.customers USING btree (username);


--
-- TOC entry 4187 (class 1259 OID 17509)
-- Name: ix_order_custid; Type: INDEX; Schema: public; Owner: makila
--

CREATE INDEX ix_order_custid ON public.orders USING btree (customerid);


--
-- TOC entry 4186 (class 1259 OID 17510)
-- Name: ix_orderlines_orderid; Type: INDEX; Schema: public; Owner: makila
--

CREATE UNIQUE INDEX ix_orderlines_orderid ON public.orderlines USING btree (orderid, orderlineid);


--
-- TOC entry 4190 (class 1259 OID 17511)
-- Name: ix_prod_category; Type: INDEX; Schema: public; Owner: makila
--

CREATE INDEX ix_prod_category ON public.products USING btree (category);


--
-- TOC entry 4191 (class 1259 OID 17512)
-- Name: ix_prod_special; Type: INDEX; Schema: public; Owner: makila
--

CREATE INDEX ix_prod_special ON public.products USING btree (special);


--
-- TOC entry 4194 (class 2606 OID 17513)
-- Name: cust_hist fk_cust_hist_customerid; Type: FK CONSTRAINT; Schema: public; Owner: makila
--

ALTER TABLE ONLY public.cust_hist
    ADD CONSTRAINT fk_cust_hist_customerid FOREIGN KEY (customerid) REFERENCES public.customers(customerid) ON DELETE CASCADE;


--
-- TOC entry 4196 (class 2606 OID 17518)
-- Name: orders fk_customerid; Type: FK CONSTRAINT; Schema: public; Owner: makila
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fk_customerid FOREIGN KEY (customerid) REFERENCES public.customers(customerid) ON DELETE SET NULL;


--
-- TOC entry 4195 (class 2606 OID 17523)
-- Name: orderlines fk_orderid; Type: FK CONSTRAINT; Schema: public; Owner: makila
--

ALTER TABLE ONLY public.orderlines
    ADD CONSTRAINT fk_orderid FOREIGN KEY (orderid) REFERENCES public.orders(orderid) ON DELETE CASCADE;


-- Completed on 2024-11-16 13:50:37 CST

--
-- PostgreSQL database dump complete
--

