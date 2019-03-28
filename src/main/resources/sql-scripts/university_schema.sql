CREATE TABLE courses (
  course_id INT AUTO_INCREMENT PRIMARY KEY,
  school_id INT,
  course_name VARCHAR(100) NOT NULL,
  country VARCHAR(50),
  city VARCHAR(50) NOT NULL,
  field VARCHAR(100) NOT NULL,
  tuition INT,
  attendance VARCHAR(20),
  duration VARCHAR(20),
  curriculum TEXT,
  image TEXT
);

CREATE TABLE schools (
  school_id INT AUTO_INCREMENT PRIMARY KEY,
  course_id INT,
  school_name VARCHAR(100) NOT NULL
);

CREATE TABLE fields (
  field VARCHAR(100) NOT NULL PRIMARY KEY,
  category VARCHAR(100)
);

CREATE TABLE categories (
  category VARCHAR(100) NOT NULL PRIMARY KEY
);