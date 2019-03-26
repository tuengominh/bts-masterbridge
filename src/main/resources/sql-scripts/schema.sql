CREATE TABLE courses (
  id INT AUTO_INCREMENT PRIMARY KEY,
  school_id INT,
  name VARCHAR(100) NOT NULL,
  country VARCHAR(50),
  city VARCHAR(50) NOT NULL,
  field VARCHAR(100) NOT NULL,
  tuition INT,
  attendance VARCHAR(20),
  duration VARCHAR(20),
  curriculum TEXT,
  image TEXT
);

insert into courses (name, country, city, field) values
    ('MBDS','spain', 'barcelona','big data solutions'),
    ('DCLead','denmark','copenhagen','creative technology');

