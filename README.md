# Stock Market Logger

Logger takes and log data from a stock exchange and stores them for later use.

## Installation
1. MySQL setup

```SQL
UPDATE mysql.user SET Password=PASSWORD('') WHERE User='root';
CREATE testDB;
USE testDB;

CREATE TABLE stockHistory(
	name VARCHAR(30),
	price DOUBLE,
    	priceTime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY );

```

## Usage

An online web app

=A picture of the interface=

## Technologies
* Tomacat 9.0
* JAVA 13
* JSTL
* JDBC

## Contributing
Any suggestions or improvements are welcomed.

## License
---