
-- DDL De las nuevas estructuras

-- Crear tabla MONEDA 
CREATE TABLE Moneda( 
	Id SERIAL PRIMARY KEY,
	Moneda VARCHAR(50) NOT NULL, 
	Sigla VARCHAR(3) NOT NULL,
	Imagen BYTEA);

-- Crear indice para MONEDA ordenado por NOMBRE
CREATE UNIQUE INDEX ixMoneda_moneda
	ON Moneda(moneda);
	
-- Agregar columna IdMoneda a la tabla Pais como clave foranea
ALTER TABLE Pais
ADD COLUMN IdMoneda INTEGER,
ADD CONSTRAINT fkPais_IdMoneda FOREIGN KEY (IdMoneda) REFERENCES Moneda(Id);

-- Agregar columna Mapa para almacenar imagenes/archivos binarios
ALTER TABLE Pais
ADD COLUMN Mapa BYTEA;

-- Agregar columna Bandera para almacenar imagenes/archivos binarias
ALTER TABLE Pais
ADD COLUMN Bandera BYTEA;

-- DML para la conservacion de los datos en la nueva estructura normalizada

-- Insertar las monedas actuales en la nueva tabla Moneda, dejando la sigla default '---' (Ya que no contamos con la sigla en PAIS)
INSERT INTO Moneda (Moneda, Sigla)
SELECT DISTINCT Moneda, '---' FROM Pais;

-- Llevamos los nuevos id de Moneda a el campo de la relacion foranea entre Pais y Moneda 
UPDATE Pais
SET IdMoneda = Moneda.Id
FROM Moneda
WHERE Pais.Moneda = Moneda.Moneda;

-- Eliminar la columna Moneda de la tabla Pais para finalizar la normalizacion
ALTER TABLE Pais
DROP COLUMN Moneda;

