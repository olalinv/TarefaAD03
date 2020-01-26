-- PROVINCE
CREATE TABLE IF NOT EXISTS PROVINCE(
   PROVINCE_ID INTEGER PRIMARY KEY,
   NAME TEXT NOT NULL
);

-- STORE
CREATE TABLE IF NOT EXISTS STORE(
   STORE_ID INTEGER PRIMARY KEY,
   NAME TEXT NOT NULL,
   CITY TEXT NOT NULL,
   PROVINCE_ID INTEGER NOT NULL,
   FOREIGN KEY (PROVINCE_ID) 
      REFERENCES PROVINCE (PROVINCE_ID) 
         ON UPDATE CASCADE
         ON DELETE NO ACTION
);

-- PRODUCT
CREATE TABLE IF NOT EXISTS PRODUCT(
   PRODUCT_ID INTEGER PRIMARY KEY,
   NAME TEXT NOT NULL,
   PRICE REAL NOT NULL
);

-- EMPLOYEE
CREATE TABLE IF NOT EXISTS EMPLOYEE(
   EMPLOYEE_ID INTEGER PRIMARY KEY,
   NAME TEXT NOT NULL,
   SURNAME TEXT NOT NULL
);

-- CUSTOMER
CREATE TABLE IF NOT EXISTS CUSTOMER(
   CUSTOMER_ID INTEGER PRIMARY KEY,
   NAME TEXT NOT NULL,
   SURNAME TEXT NOT NULL,
   EMAIL TEXT NOT NULL
);

-- STORE->PRODUCT
CREATE TABLE IF NOT EXISTS STORE_PRODUCT(
   STORE_PRODUCT_ID INTEGER PRIMARY KEY,
   STORE_ID INTEGER NOT NULL,
   PRODUCT_ID INTEGER NOT NULL,
   PR_QUANTITY INTEGER NOT NULL,
   FOREIGN KEY (STORE_ID) 
      REFERENCES STORE (STORE_ID) 
         ON DELETE CASCADE 
         ON UPDATE NO ACTION,
   FOREIGN KEY (PRODUCT_ID) 
      REFERENCES PRODUCT (PRODUCT_ID) 
         ON UPDATE CASCADE
         ON DELETE CASCADE
);

-- STORE->EMPLOYEE
CREATE TABLE IF NOT EXISTS STORE_EMPLOYEE(
   STORE_EMPLOYEE_ID INTEGER PRIMARY KEY,
   STORE_ID INTEGER NOT NULL,
   EMPLOYEE_ID INTEGER NOT NULL,
   EM_HOURS INTEGER NOT NULL,
   FOREIGN KEY (STORE_ID) 
      REFERENCES STORE (STORE_ID) 
         ON DELETE CASCADE 
         ON UPDATE NO ACTION,
   FOREIGN KEY (EMPLOYEE_ID) 
      REFERENCES EMPLOYEE (EMPLOYEE_ID) 
         ON UPDATE CASCADE
         ON DELETE CASCADE
);