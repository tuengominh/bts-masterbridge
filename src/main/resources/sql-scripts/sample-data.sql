CREATE TABLE courses (
  id INT AUTO_INCREMENT PRIMARY KEY,
  country VARCHAR(50) NOT NULL,
  field VARCHAR(100),
);

insert into courses (country, field) values
    ('spain', 'big data'),
    ('germany', 'creative technology');

