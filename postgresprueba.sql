CREATE TABLE IF NOT EXISTS User_info (
    id_user_info SERIAL PRIMARY KEY,
    firstname VARCHAR,
    lastname_p VARCHAR,
    lastname_m VARCHAR,
    rut INT,
    mail VARCHAR,
    pass VARCHAR,
    birthdate DATE
);
CREATE TABLE IF NOT EXISTS Leadership (
    id_leadership SERIAL PRIMARY KEY,
    id_analyzer INT NOT NULL,
    id_academicunit INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Clientpriority (
    id_clientpriority SERIAL PRIMARY KEY,
    clientpriority_name VARCHAR
);

CREATE TABLE IF NOT EXISTS Analyzer (
    id_analyzer SERIAL PRIMARY KEY,
    id_user_info INT,
    id_academicunit INT NOT NULL,
    FOREIGN KEY (id_user_info) REFERENCES User_info (id_user_info)
);

CREATE TABLE IF NOT EXISTS Academicunit (
    id_academicunit SERIAL PRIMARY KEY,
    id_analyzer INT NOT NULL,
    id_leadership INT NOT NULL,
    FOREIGN KEY (id_analyzer) REFERENCES Analyzer (id_analyzer),
    FOREIGN KEY (id_leadership) REFERENCES Leadership (id_leadership)
);


CREATE TABLE IF NOT EXISTS Externalclient (
    id_externalclient SERIAL PRIMARY KEY,
    id_clientpriority INT NOT NULL,
    clientpriority_name VARCHAR,
    id_user_info INT,
    FOREIGN KEY (id_clientpriority) REFERENCES Clientpriority (id_clientpriority),
    FOREIGN KEY (id_user_info) REFERENCES User_info (id_user_info)
);

CREATE TABLE IF NOT EXISTS Internalclient (
    id_internalclient SERIAL PRIMARY KEY,
    id_clientpriority INT NOT NULL,
    clientpriority_name VARCHAR,
    id_user_info INT,
    FOREIGN KEY (id_clientpriority) REFERENCES Clientpriority (id_clientpriority),
    FOREIGN KEY (id_user_info) REFERENCES User_info (id_user_info)
);

CREATE TABLE IF NOT EXISTS Ticket (
    id_ticket SERIAL PRIMARY KEY,
    ticket_creation DATE,
    ticket_limit DATE,
    description VARCHAR,
    id_ticketcategory INT,
    id_ticketrating INT,
    id_ticketpriority INT,
    id_ticketstate INT,
    id_ticketcomentary INT,
    id_ticketdocument INT,
    id_tickethistory INT,
    id_ticketreport INT,
    id_analyzer INT,
    id_leadership INT,
    id_externalclient INT,
    id_internalclient INT,
    id_academicunit INT,
    FOREIGN KEY (id_analyzer) REFERENCES Analyzer (id_analyzer),
    FOREIGN KEY (id_leadership) REFERENCES Leadership (id_leadership),
    FOREIGN KEY (id_externalclient) REFERENCES Externalclient (id_externalclient),
    FOREIGN KEY (id_internalclient) REFERENCES Internalclient (id_internalclient),
    FOREIGN KEY (id_academicunit) REFERENCES Academicunit (id_academicunit)
);

CREATE TABLE IF NOT EXISTS Ticketcategory (
    id_ticketcategory SERIAL PRIMARY KEY,
    id_ticket INT NOT NULL,
    category_name VARCHAR,
    FOREIGN KEY (id_ticket) REFERENCES Ticket (id_ticket)
);

CREATE TABLE IF NOT EXISTS Ticketcomentary (
    id_ticketcomentary SERIAL PRIMARY KEY,
    id_ticket INT NOT NULL,
    comentary VARCHAR,
    creation_comentary_date DATE,
    creation_comentary_hour TIME,
    FOREIGN KEY (id_ticket) REFERENCES Ticket (id_ticket)
);

CREATE TABLE IF NOT EXISTS Ticketdocument (
    id_ticketdocument SERIAL PRIMARY KEY,
    id_ticket INT NOT NULL,
    document_description VARCHAR,
    FOREIGN KEY (id_ticket) REFERENCES Ticket (id_ticket)
);

CREATE TABLE IF NOT EXISTS Tickethistory (
    id_tickethistory SERIAL PRIMARY KEY,
    id_ticket INT NOT NULL,
    FOREIGN KEY (id_ticket) REFERENCES Ticket (id_ticket)
);

CREATE TABLE IF NOT EXISTS Ticketpriority (
    id_ticketpriority SERIAL PRIMARY KEY,
    id_ticket INT NOT NULL,
    priority_level INT,
    FOREIGN KEY (id_ticket) REFERENCES Ticket (id_ticket)
);

CREATE TABLE IF NOT EXISTS Ticketrating (
    id_ticketrating SERIAL PRIMARY KEY,
    id_ticket INT NOT NULL,
    rating INT,
    rating_description VARCHAR,
    FOREIGN KEY (id_ticket) REFERENCES Ticket (id_ticket)
);

CREATE TABLE IF NOT EXISTS Ticketreport (
    id_ticketreport SERIAL PRIMARY KEY,
    id_ticket INT NOT NULL,
    ticket_answer VARCHAR,
    answer_date DATE,
    FOREIGN KEY (id_ticket) REFERENCES Ticket (id_ticket)
);

CREATE TABLE IF NOT EXISTS Ticketstate (
    id_ticketstate SERIAL PRIMARY KEY,
    id_ticket INT NOT NULL,
    state_name VARCHAR,
    FOREIGN KEY (id_ticket) REFERENCES Ticket (id_ticket)
);
