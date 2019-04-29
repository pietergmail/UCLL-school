CREATE SCHEMA "boxing club";

CREATE TABLE "boxing club".sponser ( 
	sponsor_id           integer  NOT NULL ,
	wedstrijdnr          integer   ,
	bedrag               integer   ,
	startdatum           integer   ,
	einddatum            integer   ,
	naam                 integer   ,
	CONSTRAINT pk_sponser_id PRIMARY KEY ( sponsor_id ),
	CONSTRAINT unq_sponser_wedstrijdnr UNIQUE ( wedstrijdnr ) 
 );

CREATE TABLE "boxing club".trainers ( 
	train_id             integer  NOT NULL ,
	naam                 varchar   ,
	begin_datum          integer   ,
	eind_datum           integer   ,
	functie              integer   ,
	CONSTRAINT pk_trainers_id PRIMARY KEY ( train_id )
 );

CREATE TABLE "boxing club".wedstrijden ( 
	wedstrijdnr          integer  NOT NULL ,
	bokser_id            integer  NOT NULL ,
	datum                date   ,
	locatie              varchar   ,
	verloren             bool   ,
	gewonnen             bool   ,
	CONSTRAINT pk_wedstrijden_id PRIMARY KEY ( wedstrijdnr ),
	CONSTRAINT unq_wedstrijden_bokser_id UNIQUE ( bokser_id ) 
 );

CREATE TABLE "boxing club".boksers ( 
	bokser_id            integer  NOT NULL ,
	naam                 varchar   ,
	woonplaats           varchar   ,
	geslacht             varchar   ,
	gewicht              bigint   ,
	leeftijd             bigint   ,
	telefoonnr           bigint   ,
	train_id             integer  NOT NULL ,
	CONSTRAINT pk_leden_id PRIMARY KEY ( bokser_id )
 );

COMMENT ON TABLE "boxing club".boksers IS 'De leden van de club';

COMMENT ON COLUMN "boxing club".boksers.woonplaats IS 'Wordt vaak gemeente mee bedoeld';

CREATE TABLE "boxing club"."boksers wedstrijden" ( 
	bokser_id            integer  NOT NULL ,
	wedstrijdnr          integer  NOT NULL 
 );

CREATE TABLE "boxing club"."gesponserde wedstrijden" ( 
	wedstrijdnr          integer  NOT NULL ,
	sponsor_id           integer  NOT NULL 
 );

CREATE TABLE "boxing club".betaling ( 
	betalingsnr          integer  NOT NULL ,
	bedrag               bigint   ,
	datum                date   ,
	bokser_id            integer  NOT NULL ,
	CONSTRAINT pk_betaling_id PRIMARY KEY ( betalingsnr )
 );

ALTER TABLE "boxing club".betaling ADD CONSTRAINT fk_betaling_boksers FOREIGN KEY ( bokser_id ) REFERENCES "boxing club".boksers( bokser_id );

ALTER TABLE "boxing club".boksers ADD CONSTRAINT fk_boksers_trainers FOREIGN KEY ( train_id ) REFERENCES "boxing club".trainers( train_id );

ALTER TABLE "boxing club"."boksers wedstrijden" ADD CONSTRAINT "fk_boksers wedstrijden_boksers" FOREIGN KEY ( bokser_id ) REFERENCES "boxing club".boksers( bokser_id );

ALTER TABLE "boxing club"."boksers wedstrijden" ADD CONSTRAINT "fk_boksers wedstrijden_wedstrijden" FOREIGN KEY ( wedstrijdnr ) REFERENCES "boxing club".wedstrijden( wedstrijdnr );

ALTER TABLE "boxing club"."gesponserde wedstrijden" ADD CONSTRAINT "fk_gesponserde wedstrijden_wedstrijden" FOREIGN KEY ( wedstrijdnr ) REFERENCES "boxing club".wedstrijden( wedstrijdnr );

ALTER TABLE "boxing club"."gesponserde wedstrijden" ADD CONSTRAINT "fk_gesponserde wedstrijden_sponser" FOREIGN KEY ( sponsor_id ) REFERENCES "boxing club".sponser( sponsor_id );

