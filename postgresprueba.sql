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

CREATE TABLE IF NOT EXISTS ClientPriority (
    id_clientPriority SERIAL PRIMARY KEY,
    clientPriority_name VARCHAR
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
    id_externalClient SERIAL PRIMARY KEY,
    id_clientPriority INT NOT NULL,
    clientPriority_name VARCHAR,
    id_user_info INT,
    FOREIGN KEY (id_clientPriority) REFERENCES ClientPriority (id_clientPriority),
    FOREIGN KEY (id_user_info) REFERENCES User_info (id_user_info)
);

CREATE TABLE IF NOT EXISTS Internalclient (
    id_internalClient SERIAL PRIMARY KEY,
    id_clientPriority INT NOT NULL,
    clientPriority_name VARCHAR,
    id_user_info INT,
    FOREIGN KEY (id_clientPriority) REFERENCES ClientPriority (id_clientPriority),
    FOREIGN KEY (id_user_info) REFERENCES User_info (id_user_info)
);

CREATE TABLE IF NOT EXISTS Ticket (
    id_ticket SERIAL PRIMARY KEY,
    ticket_creation DATE,
    ticket_limit DATE,
    description VARCHAR,
    id_ticketCategory INT,
    id_ticketrating INT,
    id_ticketPriority INT,
    id_ticketState INT,
    id_ticketComentary INT,
    id_ticketDocument INT,
    id_ticketHistory INT,
    id_ticketReport INT,
    id_analyzer INT,
    id_leadership INT,
    id_externalClient INT,
    id_internalClient INT,
    id_academicunit INT,
    FOREIGN KEY (id_analyzer) REFERENCES Analyzer (id_analyzer),
    FOREIGN KEY (id_leadership) REFERENCES Leadership (id_leadership),
    FOREIGN KEY (id_externalClient) REFERENCES Externalclient (id_externalClient),
    FOREIGN KEY (id_internalClient) REFERENCES Internalclient (id_internalClient),
    FOREIGN KEY (id_academicunit) REFERENCES Academicunit (id_academicunit)
);

CREATE TABLE IF NOT EXISTS TicketCategory (
    id_ticketCategory SERIAL PRIMARY KEY,
    id_ticket INT NOT NULL,
    Category_name VARCHAR,
    FOREIGN KEY (id_ticket) REFERENCES Ticket (id_ticket)
);

CREATE TABLE IF NOT EXISTS TicketComentary (
    id_ticketComentary SERIAL PRIMARY KEY,
    id_ticket INT NOT NULL,
    Comentary VARCHAR,
    creation_Comentary_date DATE,
    creation_Comentary_hour TIME,
    FOREIGN KEY (id_ticket) REFERENCES Ticket (id_ticket)
);

CREATE TABLE IF NOT EXISTS TicketDocument (
    id_ticketDocument SERIAL PRIMARY KEY,
    id_ticket INT NOT NULL,
    Document_description VARCHAR,
    FOREIGN KEY (id_ticket) REFERENCES Ticket (id_ticket)
);

CREATE TABLE IF NOT EXISTS TicketHistory (
    id_ticketHistory SERIAL PRIMARY KEY,
    id_ticket INT NOT NULL,
    FOREIGN KEY (id_ticket) REFERENCES Ticket (id_ticket)
);

CREATE TABLE IF NOT EXISTS TicketPriority (
    id_ticketPriority SERIAL PRIMARY KEY,
    id_ticket INT NOT NULL,
    Priority_level INT,
    FOREIGN KEY (id_ticket) REFERENCES Ticket (id_ticket)
);

CREATE TABLE IF NOT EXISTS Ticketrating (
    id_ticketrating SERIAL PRIMARY KEY,
    id_ticket INT NOT NULL,
    rating INT,
    rating_description VARCHAR,
    FOREIGN KEY (id_ticket) REFERENCES Ticket (id_ticket)
);

CREATE TABLE IF NOT EXISTS TicketReport (
    id_ticketReport SERIAL PRIMARY KEY,
    id_ticket INT NOT NULL,
    ticket_answer VARCHAR,
    answer_date DATE,
    FOREIGN KEY (id_ticket) REFERENCES Ticket (id_ticket)
);

CREATE TABLE IF NOT EXISTS TicketState (
    id_ticketState SERIAL PRIMARY KEY,
    id_ticket INT NOT NULL,
    State_name VARCHAR,
    FOREIGN KEY (id_ticket) REFERENCES Ticket (id_ticket)
);
