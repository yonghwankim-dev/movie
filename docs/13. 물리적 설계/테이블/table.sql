
CREATE TABLE mem
(
	mem_code             VARCHAR2(20) NOT NULL  CONSTRAINT  Val_Rule_MemberCode_1481953204 CHECK (REGEXP_LIKE(mem_code, '^MEM\d+$')),
	name                 VARCHAR2(50) NOT NULL ,
	birthday             DATE NOT NULL ,
	contact              VARCHAR2(13) NOT NULL  CONSTRAINT  Val_Rule_Contact_1581313007 CHECK (REGEXP_LIKE(contact, '^01([0|1|6|7|8|9])-([0-9]{3,4})-([0-9]{4})$')),
	addr                 VARCHAR2(200) NOT NULL ,
	email                VARCHAR2(200) NOT NULL  CONSTRAINT  Val_Rule_Email_486034511 CHECK (REGEXP_LIKE(email, '^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$')),
	id                   VARCHAR2(50) NOT NULL ,
	pwd                  VARCHAR2(100) NOT NULL ,
	gender               VARCHAR2(1) NOT NULL  CONSTRAINT  Val_Rule_Gender_2017482109 CHECK (gender IN ('M', 'F'))
);

CREATE UNIQUE INDEX XPK회원 ON mem
(mem_code   ASC);

ALTER TABLE mem
	ADD CONSTRAINT  XPK회원 PRIMARY KEY (mem_code);

CREATE UNIQUE INDEX XAK1회원 ON mem
(id   ASC,email   ASC,contact   ASC);

ALTER TABLE mem
ADD CONSTRAINT  XAK1회원 UNIQUE (id,email,contact);

CREATE TABLE book
(
	book_code            VARCHAR2(20) NOT NULL  CONSTRAINT  Val_Rule_BookCode_1426906598 CHECK (REGEXP_LIKE(book_code, '^BOOK\d+$')),
	total_price          NUMBER NOT NULL ,
	teenager             NUMBER NOT NULL ,
	adult                NUMBER NOT NULL ,
	senior               NUMBER NOT NULL ,
	screen_sch_code      VARCHAR2(20) NOT NULL  CONSTRAINT  Val_Rule_ScreenScheduleCode_945673960 CHECK (REGEXP_LIKE(screen_sch_code, '^SS\d+$')),
	mem_code             VARCHAR2(20) NOT NULL  CONSTRAINT  Val_Rule_MemberCode_1509084586 CHECK (REGEXP_LIKE(mem_code, '^MEM\d+$'))
);

CREATE UNIQUE INDEX XPK예약 ON book
(book_code   ASC);

ALTER TABLE book
	ADD CONSTRAINT  XPK예약 PRIMARY KEY (book_code);

CREATE TABLE cinema
(
	cinema_code          VARCHAR2(20) NOT NULL  CONSTRAINT  Val_Rule_CinemaCode_2054199965 CHECK (REGEXP_LIKE(cinema_code, '^CINEMA\d+$')),
	name                 VARCHAR2(50) NOT NULL ,
	loc                  VARCHAR2(50) NOT NULL 
);

CREATE UNIQUE INDEX XPK영화관 ON cinema
(cinema_code   ASC);

ALTER TABLE cinema
	ADD CONSTRAINT  XPK영화관 PRIMARY KEY (cinema_code);

CREATE TABLE movie
(
	movie_code           VARCHAR2(20) NOT NULL  CONSTRAINT  Val_Rule_MovieCode_844437914 CHECK (REGEXP_LIKE(movie_code, '^MOVIE\d+$')),
	name                 VARCHAR2(50) NOT NULL ,
	audi_rating          NUMBER(2) NOT NULL  CONSTRAINT  Val_Rule_Audiance_Rating_69449237 CHECK (audi_rating IN (0, 7, 12, 15, 19)),
	runtime              NUMBER NOT NULL 
);

CREATE UNIQUE INDEX XPK영화 ON movie
(movie_code   ASC);

ALTER TABLE movie
	ADD CONSTRAINT  XPK영화 PRIMARY KEY (movie_code);

CREATE TABLE theater
(
	theater_code         VARCHAR2(20) NOT NULL  CONSTRAINT  Val_Rule_TheaterCode_1530205439 CHECK (REGEXP_LIKE(theater_code, '^TH\d+$')),
	name                 VARCHAR2(50) NOT NULL ,
	cinema_code          VARCHAR2(20) NOT NULL  CONSTRAINT  Val_Rule_CinemaCode_2004717088 CHECK (REGEXP_LIKE(cinema_code, '^CINEMA\d+$'))
);

CREATE UNIQUE INDEX XPK상영관 ON theater
(theater_code   ASC);

ALTER TABLE theater
	ADD CONSTRAINT  XPK상영관 PRIMARY KEY (theater_code);

CREATE TABLE screen
(
	movie_code           VARCHAR2(20) NOT NULL  CONSTRAINT  Val_Rule_MovieCode_893683865 CHECK (REGEXP_LIKE(movie_code, '^MOVIE\d+$')),
	theater_code         VARCHAR2(20) NOT NULL  CONSTRAINT  Val_Rule_TheaterCode_1806835705 CHECK (REGEXP_LIKE(theater_code, '^TH\d+$')),
	start_date           DATE NOT NULL ,
	end_date             DATE NOT NULL 
);

CREATE UNIQUE INDEX XPK상영 ON screen
(movie_code   ASC,theater_code   ASC);

ALTER TABLE screen
	ADD CONSTRAINT  XPK상영 PRIMARY KEY (movie_code,theater_code);

CREATE TABLE screen_sch
(
	screen_sch_code      VARCHAR2(20) NOT NULL  CONSTRAINT  Val_Rule_ScreenScheduleCode_86787666 CHECK (REGEXP_LIKE(screen_sch_code, '^SS\d+$')),
	screen_date          DATE NOT NULL ,
	start_time           VARCHAR2(5) NOT NULL  CONSTRAINT  Val_Rule_Start_time_1393155528 CHECK (REGEXP_LIKE(start_time, '^([01][0-9]|2[0-3]):([0-5][0-9])$')),
	end_time             VARCHAR2(5) NOT NULL  CONSTRAINT  Val_Rule_End_time_1103009144 CHECK (REGEXP_LIKE(end_time, '^([01][0-9]|2[0-3]):([0-5][0-9])$')),
	screen_num           NUMBER NOT NULL ,
	movie_code           VARCHAR2(20) NOT NULL  CONSTRAINT  Val_Rule_MovieCode_1799885823 CHECK (REGEXP_LIKE(movie_code, '^MOVIE\d+$')),
	theater_code         VARCHAR2(20) NOT NULL  CONSTRAINT  Val_Rule_TheaterCode_886733983 CHECK (REGEXP_LIKE(theater_code, '^TH\d+$'))
);

CREATE UNIQUE INDEX XPK상영일정 ON screen_sch
(screen_sch_code   ASC);

ALTER TABLE screen_sch
	ADD CONSTRAINT  XPK상영일정 PRIMARY KEY (screen_sch_code);

CREATE TABLE seat
(
	seat_code            VARCHAR2(20) NOT NULL  CONSTRAINT  Val_Rule_SeatCode_1610926577 CHECK (REGEXP_LIKE(seat_code, '^SEAT\d+$')),
	seat_row             VARCHAR2(20) NOT NULL ,
	seat_col             NUMBER NOT NULL ,
	theater_code         VARCHAR2(20) NOT NULL  CONSTRAINT  Val_Rule_TheaterCode_1823582364 CHECK (REGEXP_LIKE(theater_code, '^TH\d+$'))
);

CREATE UNIQUE INDEX XPK좌석 ON seat
(seat_code   ASC);

ALTER TABLE seat
	ADD CONSTRAINT  XPK좌석 PRIMARY KEY (seat_code);

CREATE TABLE book_seat
(
	book_code            VARCHAR2(20) NOT NULL  CONSTRAINT  Val_Rule_BookCode_146645632 CHECK (REGEXP_LIKE(book_code, '^BOOK\d+$')),
	seat_code            VARCHAR2(20) NOT NULL  CONSTRAINT  Val_Rule_SeatCode_196912511 CHECK (REGEXP_LIKE(seat_code, '^SEAT\d+$'))
);

CREATE UNIQUE INDEX XPK예약좌석 ON book_seat
(book_code   ASC,seat_code   ASC);

ALTER TABLE book_seat
	ADD CONSTRAINT  XPK예약좌석 PRIMARY KEY (book_code,seat_code);

CREATE TABLE screen_sch_seat
(
	screen_sch_code      VARCHAR2(20) NOT NULL  CONSTRAINT  Val_Rule_ScreenScheduleCode_1687666970 CHECK (REGEXP_LIKE(screen_sch_code, '^SS\d+$')),
	seat_code            VARCHAR2(20) NOT NULL  CONSTRAINT  Val_Rule_SeatCode_634646709 CHECK (REGEXP_LIKE(seat_code, '^SEAT\d+$')),
	seat_status          VARCHAR2(1) NOT NULL  CONSTRAINT  Val_Rule_Seat_Status_1502738162 CHECK (seat_status IN ('R', 'A'))
);

CREATE UNIQUE INDEX XPK상영일정좌석 ON screen_sch_seat
(screen_sch_code   ASC,seat_code   ASC);

ALTER TABLE screen_sch_seat
	ADD CONSTRAINT  XPK상영일정좌석 PRIMARY KEY (screen_sch_code,seat_code);

ALTER TABLE book
	ADD (CONSTRAINT R_6 FOREIGN KEY (screen_sch_code) REFERENCES screen_sch (screen_sch_code));

ALTER TABLE book
	ADD (CONSTRAINT R_7 FOREIGN KEY (mem_code) REFERENCES mem (mem_code));

ALTER TABLE theater
	ADD (CONSTRAINT R_1 FOREIGN KEY (cinema_code) REFERENCES cinema (cinema_code));

ALTER TABLE screen
	ADD (CONSTRAINT R_3 FOREIGN KEY (movie_code) REFERENCES movie (movie_code));

ALTER TABLE screen
	ADD (CONSTRAINT R_4 FOREIGN KEY (theater_code) REFERENCES theater (theater_code));

ALTER TABLE screen_sch
	ADD (CONSTRAINT R_5 FOREIGN KEY (movie_code, theater_code) REFERENCES screen (movie_code, theater_code));

ALTER TABLE seat
	ADD (CONSTRAINT R_2 FOREIGN KEY (theater_code) REFERENCES theater (theater_code));

ALTER TABLE book_seat
	ADD (CONSTRAINT R_8 FOREIGN KEY (book_code) REFERENCES book (book_code));

ALTER TABLE book_seat
	ADD (CONSTRAINT R_9 FOREIGN KEY (seat_code) REFERENCES seat (seat_code));

ALTER TABLE screen_sch_seat
	ADD (CONSTRAINT R_10 FOREIGN KEY (screen_sch_code) REFERENCES screen_sch (screen_sch_code));

ALTER TABLE screen_sch_seat
	ADD (CONSTRAINT R_11 FOREIGN KEY (seat_code) REFERENCES seat (seat_code));

CREATE  TRIGGER  tD_mem AFTER DELETE ON mem for each row
-- erwin Builtin Trigger
-- DELETE trigger on mem 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* mem  book on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="0000c259", PARENT_OWNER="", PARENT_TABLE="mem"
    CHILD_OWNER="", CHILD_TABLE="book"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_7", FK_COLUMNS="mem_code" */
    SELECT count(*) INTO NUMROWS
      FROM book
      WHERE
        /*  %JoinFKPK(book,:%Old," = "," AND") */
        book.mem_code = :old.mem_code;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete mem because book exists.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_mem AFTER UPDATE ON mem for each row
-- erwin Builtin Trigger
-- UPDATE trigger on mem 
DECLARE NUMROWS INTEGER;
BEGIN
  /* erwin Builtin Trigger */
  /* mem  book on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="0000e5a0", PARENT_OWNER="", PARENT_TABLE="mem"
    CHILD_OWNER="", CHILD_TABLE="book"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_7", FK_COLUMNS="mem_code" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.mem_code <> :new.mem_code
  THEN
    SELECT count(*) INTO NUMROWS
      FROM book
      WHERE
        /*  %JoinFKPK(book,:%Old," = "," AND") */
        book.mem_code = :old.mem_code;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update mem because book exists.'
      );
    END IF;
  END IF;


-- erwin Builtin Trigger
END;
/


CREATE  TRIGGER  tD_book AFTER DELETE ON book for each row
-- erwin Builtin Trigger
-- DELETE trigger on book 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* book  book_seat on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="0000d5d4", PARENT_OWNER="", PARENT_TABLE="book"
    CHILD_OWNER="", CHILD_TABLE="book_seat"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_8", FK_COLUMNS="book_code" */
    SELECT count(*) INTO NUMROWS
      FROM book_seat
      WHERE
        /*  %JoinFKPK(book_seat,:%Old," = "," AND") */
        book_seat.book_code = :old.book_code;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete book because book_seat exists.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tI_book BEFORE INSERT ON book for each row
-- erwin Builtin Trigger
-- INSERT trigger on book 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* mem  book on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="0001f1a7", PARENT_OWNER="", PARENT_TABLE="mem"
    CHILD_OWNER="", CHILD_TABLE="book"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_7", FK_COLUMNS="mem_code" */
    SELECT count(*) INTO NUMROWS
      FROM mem
      WHERE
        /* %JoinFKPK(:%New,mem," = "," AND") */
        :new.mem_code = mem.mem_code;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert book because mem does not exist.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* screen_sch  book on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="screen_sch"
    CHILD_OWNER="", CHILD_TABLE="book"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_6", FK_COLUMNS="screen_sch_code" */
    SELECT count(*) INTO NUMROWS
      FROM screen_sch
      WHERE
        /* %JoinFKPK(:%New,screen_sch," = "," AND") */
        :new.screen_sch_code = screen_sch.screen_sch_code;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert book because screen_sch does not exist.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_book AFTER UPDATE ON book for each row
-- erwin Builtin Trigger
-- UPDATE trigger on book 
DECLARE NUMROWS INTEGER;
BEGIN
  /* erwin Builtin Trigger */
  /* book  book_seat on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="0002f93f", PARENT_OWNER="", PARENT_TABLE="book"
    CHILD_OWNER="", CHILD_TABLE="book_seat"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_8", FK_COLUMNS="book_code" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.book_code <> :new.book_code
  THEN
    SELECT count(*) INTO NUMROWS
      FROM book_seat
      WHERE
        /*  %JoinFKPK(book_seat,:%Old," = "," AND") */
        book_seat.book_code = :old.book_code;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update book because book_seat exists.'
      );
    END IF;
  END IF;

  /* erwin Builtin Trigger */
  /* mem  book on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="mem"
    CHILD_OWNER="", CHILD_TABLE="book"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_7", FK_COLUMNS="mem_code" */
  SELECT count(*) INTO NUMROWS
    FROM mem
    WHERE
      /* %JoinFKPK(:%New,mem," = "," AND") */
      :new.mem_code = mem.mem_code;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update book because mem does not exist.'
    );
  END IF;

  /* erwin Builtin Trigger */
  /* screen_sch  book on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="screen_sch"
    CHILD_OWNER="", CHILD_TABLE="book"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_6", FK_COLUMNS="screen_sch_code" */
  SELECT count(*) INTO NUMROWS
    FROM screen_sch
    WHERE
      /* %JoinFKPK(:%New,screen_sch," = "," AND") */
      :new.screen_sch_code = screen_sch.screen_sch_code;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update book because screen_sch does not exist.'
    );
  END IF;


-- erwin Builtin Trigger
END;
/


CREATE  TRIGGER  tD_cinema AFTER DELETE ON cinema for each row
-- erwin Builtin Trigger
-- DELETE trigger on cinema 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* cinema  theater on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="0000d332", PARENT_OWNER="", PARENT_TABLE="cinema"
    CHILD_OWNER="", CHILD_TABLE="theater"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_1", FK_COLUMNS="cinema_code" */
    SELECT count(*) INTO NUMROWS
      FROM theater
      WHERE
        /*  %JoinFKPK(theater,:%Old," = "," AND") */
        theater.cinema_code = :old.cinema_code;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete cinema because theater exists.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_cinema AFTER UPDATE ON cinema for each row
-- erwin Builtin Trigger
-- UPDATE trigger on cinema 
DECLARE NUMROWS INTEGER;
BEGIN
  /* erwin Builtin Trigger */
  /* cinema  theater on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="000101c0", PARENT_OWNER="", PARENT_TABLE="cinema"
    CHILD_OWNER="", CHILD_TABLE="theater"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_1", FK_COLUMNS="cinema_code" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.cinema_code <> :new.cinema_code
  THEN
    SELECT count(*) INTO NUMROWS
      FROM theater
      WHERE
        /*  %JoinFKPK(theater,:%Old," = "," AND") */
        theater.cinema_code = :old.cinema_code;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update cinema because theater exists.'
      );
    END IF;
  END IF;


-- erwin Builtin Trigger
END;
/


CREATE  TRIGGER  tD_movie AFTER DELETE ON movie for each row
-- erwin Builtin Trigger
-- DELETE trigger on movie 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* movie  screen on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="0000ce23", PARENT_OWNER="", PARENT_TABLE="movie"
    CHILD_OWNER="", CHILD_TABLE="screen"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_3", FK_COLUMNS="movie_code" */
    SELECT count(*) INTO NUMROWS
      FROM screen
      WHERE
        /*  %JoinFKPK(screen,:%Old," = "," AND") */
        screen.movie_code = :old.movie_code;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete movie because screen exists.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_movie AFTER UPDATE ON movie for each row
-- erwin Builtin Trigger
-- UPDATE trigger on movie 
DECLARE NUMROWS INTEGER;
BEGIN
  /* erwin Builtin Trigger */
  /* movie  screen on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="0000f1b9", PARENT_OWNER="", PARENT_TABLE="movie"
    CHILD_OWNER="", CHILD_TABLE="screen"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_3", FK_COLUMNS="movie_code" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.movie_code <> :new.movie_code
  THEN
    SELECT count(*) INTO NUMROWS
      FROM screen
      WHERE
        /*  %JoinFKPK(screen,:%Old," = "," AND") */
        screen.movie_code = :old.movie_code;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update movie because screen exists.'
      );
    END IF;
  END IF;


-- erwin Builtin Trigger
END;
/


CREATE  TRIGGER  tD_theater AFTER DELETE ON theater for each row
-- erwin Builtin Trigger
-- DELETE trigger on theater 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* theater  screen on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="0001b87b", PARENT_OWNER="", PARENT_TABLE="theater"
    CHILD_OWNER="", CHILD_TABLE="screen"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_4", FK_COLUMNS="theater_code" */
    SELECT count(*) INTO NUMROWS
      FROM screen
      WHERE
        /*  %JoinFKPK(screen,:%Old," = "," AND") */
        screen.theater_code = :old.theater_code;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete theater because screen exists.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* theater  seat on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="theater"
    CHILD_OWNER="", CHILD_TABLE="seat"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_2", FK_COLUMNS="theater_code" */
    SELECT count(*) INTO NUMROWS
      FROM seat
      WHERE
        /*  %JoinFKPK(seat,:%Old," = "," AND") */
        seat.theater_code = :old.theater_code;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete theater because seat exists.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tI_theater BEFORE INSERT ON theater for each row
-- erwin Builtin Trigger
-- INSERT trigger on theater 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* cinema  theater on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="0000ea52", PARENT_OWNER="", PARENT_TABLE="cinema"
    CHILD_OWNER="", CHILD_TABLE="theater"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_1", FK_COLUMNS="cinema_code" */
    SELECT count(*) INTO NUMROWS
      FROM cinema
      WHERE
        /* %JoinFKPK(:%New,cinema," = "," AND") */
        :new.cinema_code = cinema.cinema_code;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert theater because cinema does not exist.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_theater AFTER UPDATE ON theater for each row
-- erwin Builtin Trigger
-- UPDATE trigger on theater 
DECLARE NUMROWS INTEGER;
BEGIN
  /* erwin Builtin Trigger */
  /* theater  screen on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00030977", PARENT_OWNER="", PARENT_TABLE="theater"
    CHILD_OWNER="", CHILD_TABLE="screen"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_4", FK_COLUMNS="theater_code" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.theater_code <> :new.theater_code
  THEN
    SELECT count(*) INTO NUMROWS
      FROM screen
      WHERE
        /*  %JoinFKPK(screen,:%Old," = "," AND") */
        screen.theater_code = :old.theater_code;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update theater because screen exists.'
      );
    END IF;
  END IF;

  /* erwin Builtin Trigger */
  /* theater  seat on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="theater"
    CHILD_OWNER="", CHILD_TABLE="seat"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_2", FK_COLUMNS="theater_code" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.theater_code <> :new.theater_code
  THEN
    SELECT count(*) INTO NUMROWS
      FROM seat
      WHERE
        /*  %JoinFKPK(seat,:%Old," = "," AND") */
        seat.theater_code = :old.theater_code;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update theater because seat exists.'
      );
    END IF;
  END IF;

  /* erwin Builtin Trigger */
  /* cinema  theater on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="cinema"
    CHILD_OWNER="", CHILD_TABLE="theater"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_1", FK_COLUMNS="cinema_code" */
  SELECT count(*) INTO NUMROWS
    FROM cinema
    WHERE
      /* %JoinFKPK(:%New,cinema," = "," AND") */
      :new.cinema_code = cinema.cinema_code;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update theater because cinema does not exist.'
    );
  END IF;


-- erwin Builtin Trigger
END;
/


CREATE  TRIGGER  tD_screen AFTER DELETE ON screen for each row
-- erwin Builtin Trigger
-- DELETE trigger on screen 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* screen  screen_sch on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="0000f12d", PARENT_OWNER="", PARENT_TABLE="screen"
    CHILD_OWNER="", CHILD_TABLE="screen_sch"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_5", FK_COLUMNS="movie_code""theater_code" */
    SELECT count(*) INTO NUMROWS
      FROM screen_sch
      WHERE
        /*  %JoinFKPK(screen_sch,:%Old," = "," AND") */
        screen_sch.movie_code = :old.movie_code AND
        screen_sch.theater_code = :old.theater_code;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete screen because screen_sch exists.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tI_screen BEFORE INSERT ON screen for each row
-- erwin Builtin Trigger
-- INSERT trigger on screen 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* theater  screen on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="0001f5a3", PARENT_OWNER="", PARENT_TABLE="theater"
    CHILD_OWNER="", CHILD_TABLE="screen"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_4", FK_COLUMNS="theater_code" */
    SELECT count(*) INTO NUMROWS
      FROM theater
      WHERE
        /* %JoinFKPK(:%New,theater," = "," AND") */
        :new.theater_code = theater.theater_code;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert screen because theater does not exist.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* movie  screen on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="movie"
    CHILD_OWNER="", CHILD_TABLE="screen"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_3", FK_COLUMNS="movie_code" */
    SELECT count(*) INTO NUMROWS
      FROM movie
      WHERE
        /* %JoinFKPK(:%New,movie," = "," AND") */
        :new.movie_code = movie.movie_code;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert screen because movie does not exist.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_screen AFTER UPDATE ON screen for each row
-- erwin Builtin Trigger
-- UPDATE trigger on screen 
DECLARE NUMROWS INTEGER;
BEGIN
  /* erwin Builtin Trigger */
  /* screen  screen_sch on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00032567", PARENT_OWNER="", PARENT_TABLE="screen"
    CHILD_OWNER="", CHILD_TABLE="screen_sch"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_5", FK_COLUMNS="movie_code""theater_code" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.movie_code <> :new.movie_code OR 
    :old.theater_code <> :new.theater_code
  THEN
    SELECT count(*) INTO NUMROWS
      FROM screen_sch
      WHERE
        /*  %JoinFKPK(screen_sch,:%Old," = "," AND") */
        screen_sch.movie_code = :old.movie_code AND
        screen_sch.theater_code = :old.theater_code;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update screen because screen_sch exists.'
      );
    END IF;
  END IF;

  /* erwin Builtin Trigger */
  /* theater  screen on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="theater"
    CHILD_OWNER="", CHILD_TABLE="screen"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_4", FK_COLUMNS="theater_code" */
  SELECT count(*) INTO NUMROWS
    FROM theater
    WHERE
      /* %JoinFKPK(:%New,theater," = "," AND") */
      :new.theater_code = theater.theater_code;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update screen because theater does not exist.'
    );
  END IF;

  /* erwin Builtin Trigger */
  /* movie  screen on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="movie"
    CHILD_OWNER="", CHILD_TABLE="screen"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_3", FK_COLUMNS="movie_code" */
  SELECT count(*) INTO NUMROWS
    FROM movie
    WHERE
      /* %JoinFKPK(:%New,movie," = "," AND") */
      :new.movie_code = movie.movie_code;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update screen because movie does not exist.'
    );
  END IF;


-- erwin Builtin Trigger
END;
/


CREATE  TRIGGER  tD_screen_sch AFTER DELETE ON screen_sch for each row
-- erwin Builtin Trigger
-- DELETE trigger on screen_sch 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* screen_sch  screen_sch_seat on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="0001e984", PARENT_OWNER="", PARENT_TABLE="screen_sch"
    CHILD_OWNER="", CHILD_TABLE="screen_sch_seat"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_10", FK_COLUMNS="screen_sch_code" */
    SELECT count(*) INTO NUMROWS
      FROM screen_sch_seat
      WHERE
        /*  %JoinFKPK(screen_sch_seat,:%Old," = "," AND") */
        screen_sch_seat.screen_sch_code = :old.screen_sch_code;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete screen_sch because screen_sch_seat exists.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* screen_sch  book on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="screen_sch"
    CHILD_OWNER="", CHILD_TABLE="book"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_6", FK_COLUMNS="screen_sch_code" */
    SELECT count(*) INTO NUMROWS
      FROM book
      WHERE
        /*  %JoinFKPK(book,:%Old," = "," AND") */
        book.screen_sch_code = :old.screen_sch_code;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete screen_sch because book exists.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tI_screen_sch BEFORE INSERT ON screen_sch for each row
-- erwin Builtin Trigger
-- INSERT trigger on screen_sch 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* screen  screen_sch on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="000107f3", PARENT_OWNER="", PARENT_TABLE="screen"
    CHILD_OWNER="", CHILD_TABLE="screen_sch"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_5", FK_COLUMNS="movie_code""theater_code" */
    SELECT count(*) INTO NUMROWS
      FROM screen
      WHERE
        /* %JoinFKPK(:%New,screen," = "," AND") */
        :new.movie_code = screen.movie_code AND
        :new.theater_code = screen.theater_code;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert screen_sch because screen does not exist.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_screen_sch AFTER UPDATE ON screen_sch for each row
-- erwin Builtin Trigger
-- UPDATE trigger on screen_sch 
DECLARE NUMROWS INTEGER;
BEGIN
  /* erwin Builtin Trigger */
  /* screen_sch  screen_sch_seat on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00034f81", PARENT_OWNER="", PARENT_TABLE="screen_sch"
    CHILD_OWNER="", CHILD_TABLE="screen_sch_seat"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_10", FK_COLUMNS="screen_sch_code" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.screen_sch_code <> :new.screen_sch_code
  THEN
    SELECT count(*) INTO NUMROWS
      FROM screen_sch_seat
      WHERE
        /*  %JoinFKPK(screen_sch_seat,:%Old," = "," AND") */
        screen_sch_seat.screen_sch_code = :old.screen_sch_code;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update screen_sch because screen_sch_seat exists.'
      );
    END IF;
  END IF;

  /* erwin Builtin Trigger */
  /* screen_sch  book on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="screen_sch"
    CHILD_OWNER="", CHILD_TABLE="book"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_6", FK_COLUMNS="screen_sch_code" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.screen_sch_code <> :new.screen_sch_code
  THEN
    SELECT count(*) INTO NUMROWS
      FROM book
      WHERE
        /*  %JoinFKPK(book,:%Old," = "," AND") */
        book.screen_sch_code = :old.screen_sch_code;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update screen_sch because book exists.'
      );
    END IF;
  END IF;

  /* erwin Builtin Trigger */
  /* screen  screen_sch on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="screen"
    CHILD_OWNER="", CHILD_TABLE="screen_sch"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_5", FK_COLUMNS="movie_code""theater_code" */
  SELECT count(*) INTO NUMROWS
    FROM screen
    WHERE
      /* %JoinFKPK(:%New,screen," = "," AND") */
      :new.movie_code = screen.movie_code AND
      :new.theater_code = screen.theater_code;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update screen_sch because screen does not exist.'
    );
  END IF;


-- erwin Builtin Trigger
END;
/


CREATE  TRIGGER  tD_seat AFTER DELETE ON seat for each row
-- erwin Builtin Trigger
-- DELETE trigger on seat 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* seat  screen_sch_seat on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="0001d031", PARENT_OWNER="", PARENT_TABLE="seat"
    CHILD_OWNER="", CHILD_TABLE="screen_sch_seat"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_11", FK_COLUMNS="seat_code" */
    SELECT count(*) INTO NUMROWS
      FROM screen_sch_seat
      WHERE
        /*  %JoinFKPK(screen_sch_seat,:%Old," = "," AND") */
        screen_sch_seat.seat_code = :old.seat_code;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete seat because screen_sch_seat exists.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* seat  book_seat on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="seat"
    CHILD_OWNER="", CHILD_TABLE="book_seat"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_9", FK_COLUMNS="seat_code" */
    SELECT count(*) INTO NUMROWS
      FROM book_seat
      WHERE
        /*  %JoinFKPK(book_seat,:%Old," = "," AND") */
        book_seat.seat_code = :old.seat_code;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete seat because book_seat exists.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tI_seat BEFORE INSERT ON seat for each row
-- erwin Builtin Trigger
-- INSERT trigger on seat 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* theater  seat on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="0000e987", PARENT_OWNER="", PARENT_TABLE="theater"
    CHILD_OWNER="", CHILD_TABLE="seat"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_2", FK_COLUMNS="theater_code" */
    SELECT count(*) INTO NUMROWS
      FROM theater
      WHERE
        /* %JoinFKPK(:%New,theater," = "," AND") */
        :new.theater_code = theater.theater_code;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert seat because theater does not exist.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_seat AFTER UPDATE ON seat for each row
-- erwin Builtin Trigger
-- UPDATE trigger on seat 
DECLARE NUMROWS INTEGER;
BEGIN
  /* erwin Builtin Trigger */
  /* seat  screen_sch_seat on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00030978", PARENT_OWNER="", PARENT_TABLE="seat"
    CHILD_OWNER="", CHILD_TABLE="screen_sch_seat"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_11", FK_COLUMNS="seat_code" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.seat_code <> :new.seat_code
  THEN
    SELECT count(*) INTO NUMROWS
      FROM screen_sch_seat
      WHERE
        /*  %JoinFKPK(screen_sch_seat,:%Old," = "," AND") */
        screen_sch_seat.seat_code = :old.seat_code;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update seat because screen_sch_seat exists.'
      );
    END IF;
  END IF;

  /* erwin Builtin Trigger */
  /* seat  book_seat on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="seat"
    CHILD_OWNER="", CHILD_TABLE="book_seat"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_9", FK_COLUMNS="seat_code" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.seat_code <> :new.seat_code
  THEN
    SELECT count(*) INTO NUMROWS
      FROM book_seat
      WHERE
        /*  %JoinFKPK(book_seat,:%Old," = "," AND") */
        book_seat.seat_code = :old.seat_code;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update seat because book_seat exists.'
      );
    END IF;
  END IF;

  /* erwin Builtin Trigger */
  /* theater  seat on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="theater"
    CHILD_OWNER="", CHILD_TABLE="seat"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_2", FK_COLUMNS="theater_code" */
  SELECT count(*) INTO NUMROWS
    FROM theater
    WHERE
      /* %JoinFKPK(:%New,theater," = "," AND") */
      :new.theater_code = theater.theater_code;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update seat because theater does not exist.'
    );
  END IF;


-- erwin Builtin Trigger
END;
/


CREATE  TRIGGER tI_book_seat BEFORE INSERT ON book_seat for each row
-- erwin Builtin Trigger
-- INSERT trigger on book_seat 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* seat  book_seat on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="0001d4ef", PARENT_OWNER="", PARENT_TABLE="seat"
    CHILD_OWNER="", CHILD_TABLE="book_seat"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_9", FK_COLUMNS="seat_code" */
    SELECT count(*) INTO NUMROWS
      FROM seat
      WHERE
        /* %JoinFKPK(:%New,seat," = "," AND") */
        :new.seat_code = seat.seat_code;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert book_seat because seat does not exist.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* book  book_seat on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="book"
    CHILD_OWNER="", CHILD_TABLE="book_seat"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_8", FK_COLUMNS="book_code" */
    SELECT count(*) INTO NUMROWS
      FROM book
      WHERE
        /* %JoinFKPK(:%New,book," = "," AND") */
        :new.book_code = book.book_code;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert book_seat because book does not exist.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_book_seat AFTER UPDATE ON book_seat for each row
-- erwin Builtin Trigger
-- UPDATE trigger on book_seat 
DECLARE NUMROWS INTEGER;
BEGIN
  /* erwin Builtin Trigger */
  /* seat  book_seat on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="0001db61", PARENT_OWNER="", PARENT_TABLE="seat"
    CHILD_OWNER="", CHILD_TABLE="book_seat"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_9", FK_COLUMNS="seat_code" */
  SELECT count(*) INTO NUMROWS
    FROM seat
    WHERE
      /* %JoinFKPK(:%New,seat," = "," AND") */
      :new.seat_code = seat.seat_code;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update book_seat because seat does not exist.'
    );
  END IF;

  /* erwin Builtin Trigger */
  /* book  book_seat on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="book"
    CHILD_OWNER="", CHILD_TABLE="book_seat"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_8", FK_COLUMNS="book_code" */
  SELECT count(*) INTO NUMROWS
    FROM book
    WHERE
      /* %JoinFKPK(:%New,book," = "," AND") */
      :new.book_code = book.book_code;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update book_seat because book does not exist.'
    );
  END IF;


-- erwin Builtin Trigger
END;
/


CREATE  TRIGGER tI_screen_sch_seat BEFORE INSERT ON screen_sch_seat for each row
-- erwin Builtin Trigger
-- INSERT trigger on screen_sch_seat 
DECLARE NUMROWS INTEGER;
BEGIN
    /* erwin Builtin Trigger */
    /* seat  screen_sch_seat on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="0001f6e8", PARENT_OWNER="", PARENT_TABLE="seat"
    CHILD_OWNER="", CHILD_TABLE="screen_sch_seat"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_11", FK_COLUMNS="seat_code" */
    SELECT count(*) INTO NUMROWS
      FROM seat
      WHERE
        /* %JoinFKPK(:%New,seat," = "," AND") */
        :new.seat_code = seat.seat_code;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert screen_sch_seat because seat does not exist.'
      );
    END IF;

    /* erwin Builtin Trigger */
    /* screen_sch  screen_sch_seat on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="screen_sch"
    CHILD_OWNER="", CHILD_TABLE="screen_sch_seat"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_10", FK_COLUMNS="screen_sch_code" */
    SELECT count(*) INTO NUMROWS
      FROM screen_sch
      WHERE
        /* %JoinFKPK(:%New,screen_sch," = "," AND") */
        :new.screen_sch_code = screen_sch.screen_sch_code;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert screen_sch_seat because screen_sch does not exist.'
      );
    END IF;


-- erwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_screen_sch_seat AFTER UPDATE ON screen_sch_seat for each row
-- erwin Builtin Trigger
-- UPDATE trigger on screen_sch_seat 
DECLARE NUMROWS INTEGER;
BEGIN
  /* erwin Builtin Trigger */
  /* seat  screen_sch_seat on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="00020a5f", PARENT_OWNER="", PARENT_TABLE="seat"
    CHILD_OWNER="", CHILD_TABLE="screen_sch_seat"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_11", FK_COLUMNS="seat_code" */
  SELECT count(*) INTO NUMROWS
    FROM seat
    WHERE
      /* %JoinFKPK(:%New,seat," = "," AND") */
      :new.seat_code = seat.seat_code;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update screen_sch_seat because seat does not exist.'
    );
  END IF;

  /* erwin Builtin Trigger */
  /* screen_sch  screen_sch_seat on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="screen_sch"
    CHILD_OWNER="", CHILD_TABLE="screen_sch_seat"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_10", FK_COLUMNS="screen_sch_code" */
  SELECT count(*) INTO NUMROWS
    FROM screen_sch
    WHERE
      /* %JoinFKPK(:%New,screen_sch," = "," AND") */
      :new.screen_sch_code = screen_sch.screen_sch_code;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update screen_sch_seat because screen_sch does not exist.'
    );
  END IF;


-- erwin Builtin Trigger
END;
/

