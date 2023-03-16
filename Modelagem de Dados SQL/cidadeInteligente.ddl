-- Gerado por Oracle SQL Developer Data Modeler 22.2.0.165.1149
--   em:        2023-03-06 21:11:00 BRT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE tb_evento (
    id_evento               NUMBER NOT NULL,
    nm_evento               VARCHAR2(200) NOT NULL,
    dt_evento               TIMESTAMP NOT NULL,
    ds_local_evento         VARCHAR2(200) NOT NULL,
    tb_trafego_id_do_sensor NUMBER NOT NULL
);

CREATE UNIQUE INDEX tb_evento__idx ON
    tb_evento (
        tb_trafego_id_do_sensor
    ASC );

ALTER TABLE tb_evento ADD CONSTRAINT tb_evento_pk PRIMARY KEY ( id_evento );

CREATE TABLE tb_sensor (
    id_sensor      NUMBER NOT NULL,
    ds_localizacao VARCHAR2(200) NOT NULL,
    tp_sensor      VARCHAR2(100) NOT NULL,
    dt_instalacao  TIMESTAMP NOT NULL
);

ALTER TABLE tb_sensor ADD CONSTRAINT tb_sensor_pk PRIMARY KEY ( id_sensor );

CREATE TABLE tb_serv_publico (
    id_servico          NUMBER NOT NULL,
    ds_tipo_serv        VARCHAR2(200) NOT NULL,
    ds_local_serv       VARCHAR2(200) NOT NULL,
    dt_instalacao       TIMESTAMP NOT NULL,
    tb_evento_id_evento NUMBER NOT NULL
);

ALTER TABLE tb_serv_publico ADD CONSTRAINT tb_serv_publico_pk PRIMARY KEY ( id_servico );

CREATE TABLE tb_trafego (
    id_do_sensor        NUMBER NOT NULL,
    hr_leitura          DATE NOT NULL,
    vl_vol_trafego      VARCHAR2(200) NOT NULL,
    tb_sensor_id_sensor NUMBER NOT NULL,
    tb_evento_id_evento NUMBER NOT NULL
);

CREATE UNIQUE INDEX tb_trafego__idx ON
    tb_trafego (
        tb_evento_id_evento
    ASC );

ALTER TABLE tb_trafego ADD CONSTRAINT tb_trafego_pk PRIMARY KEY ( id_do_sensor );

ALTER TABLE tb_evento
    ADD CONSTRAINT tb_evento_tb_trafego_fk FOREIGN KEY ( tb_trafego_id_do_sensor )
        REFERENCES tb_trafego ( id_do_sensor );

ALTER TABLE tb_serv_publico
    ADD CONSTRAINT tb_serv_publico_tb_evento_fk FOREIGN KEY ( tb_evento_id_evento )
        REFERENCES tb_evento ( id_evento );

ALTER TABLE tb_trafego
    ADD CONSTRAINT tb_trafego_tb_evento_fk FOREIGN KEY ( tb_evento_id_evento )
        REFERENCES tb_evento ( id_evento );

ALTER TABLE tb_trafego
    ADD CONSTRAINT tb_trafego_tb_sensor_fk FOREIGN KEY ( tb_sensor_id_sensor )
        REFERENCES tb_sensor ( id_sensor );



-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             4
-- CREATE INDEX                             2
-- ALTER TABLE                              8
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
