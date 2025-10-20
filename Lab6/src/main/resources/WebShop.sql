-- WebShop MySQL schema (simplified for Lab6)
CREATE DATABASE IF NOT EXISTS WebShop;
USE WebShop;

DROP TABLE IF EXISTS Orderdetails;
DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS Products;
DROP TABLE IF EXISTS Accounts;
DROP TABLE IF EXISTS Categories;

CREATE TABLE Categories (
  id VARCHAR(50) NOT NULL PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE Accounts (
  username VARCHAR(50) NOT NULL PRIMARY KEY,
  password VARCHAR(255),
  fullname VARCHAR(100),
  email VARCHAR(100),
  photo VARCHAR(255),
  activated BOOLEAN,
  admin BOOLEAN
);

CREATE TABLE Products (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(200),
  image VARCHAR(255),
  price DOUBLE,
  Createdate DATE,
  available BOOLEAN,
  Categoryid VARCHAR(50),
  CONSTRAINT FK_Product_Category FOREIGN KEY (Categoryid) REFERENCES Categories(id) ON DELETE SET NULL
);

CREATE TABLE Orders (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  address VARCHAR(255),
  Createdate DATE,
  Username VARCHAR(50),
  CONSTRAINT FK_Order_Account FOREIGN KEY (Username) REFERENCES Accounts(username) ON DELETE SET NULL
);

CREATE TABLE Orderdetails (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  price DOUBLE,
  quantity INT,
  Productid INT,
  Orderid BIGINT,
  CONSTRAINT FK_OrderDetail_Product FOREIGN KEY (Productid) REFERENCES Products(id) ON DELETE SET NULL,
  CONSTRAINT FK_OrderDetail_Order FOREIGN KEY (Orderid) REFERENCES Orders(id) ON DELETE CASCADE
);

-- Insert sample categories
INSERT INTO Categories (id, name) VALUES ('C1','Phones'),('C2','Laptops'),('C3','Accessories');

-- Insert sample products
INSERT INTO Products (name, image, price, Createdate, available, Categoryid) VALUES
('iPhone 14','iphone14.jpg',799, '2023-01-01', true, 'C1'),
('Samsung Galaxy S23','s23.jpg',699,'2023-02-01', true, 'C1'),
('Dell XPS 13','xps13.jpg',999,'2023-03-01', true, 'C2'),
('USB-C Cable','cable.jpg',19,'2023-04-01', true, 'C3'),
('Wireless Mouse','mouse.jpg',25,'2023-05-01', true, 'C3');
