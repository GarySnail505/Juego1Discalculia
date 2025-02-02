-- database: ../database/Juego1.db
DROP TABLE IF EXISTS Usuario;
DROP TABLE IF EXISTS Puntaje;


CREATE TABLE Usuario (
    IdUsuario INTEGER PRIMARY KEY AUTOINCREMENT
    ,NombreUsuario VARCHAR(50) UNIQUE NOT NULL
    ,Contrasena VARCHAR(100) NOT NULL
    ,Estado VARCHAR(1) DEFAULT ('A') CONSTRAINT verficador CHECK(Estado IN ('A','I')) 
    ,Fecha_creacion DATETIME DEFAULT (datetime('now','localtime'))
    ,Fecha_modificacion DATETIME
);

CREATE TABLE Puntaje (
    IdPuntaje INTEGER PRIMARY KEY AUTOINCREMENT
    ,IdUsuario INTEGER NOT NULL REFERENCES Usuario(IdUsuario)
    ,FechaJuego DATETIME
    ,Aciertos INTEGER DEFAULT 0
    ,Errores INTEGER DEFAULT 0
    
    ,Estado VARCHAR(1) DEFAULT ('A') CONSTRAINT verficador CHECK(Estado IN ('A','I')) 
    ,Fecha_creacion DATETIME DEFAULT (datetime('now','localtime'))
    ,Fecha_modificacion DATETIME
);