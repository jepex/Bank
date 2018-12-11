CREATE TABLE IF NOT EXISTS bank (
  cardNumber varchar (32) NOT NULL,
  sum varchar(16) DEFAULT '0',

 
  PRIMARY KEY (cardNumber)
);