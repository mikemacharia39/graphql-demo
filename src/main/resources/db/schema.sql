CREATE TABLE student (
	id BIGINT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(50) NOT NULL,
	lastName VARCHAR(50) NOT NULL,
    dob DATETIME(6) NOT NULL,
    address VARCHAR(50) DEFAULT NULL,
    deleted TINYINT(1) DEFAULT 0,
    dateCreated DATETIME(6) DEFAULT NULL,
    dateModified timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE course (
	id BIGINT NOT NULL AUTO_INCREMENT,
    code VARCHAR(50) NOT NULL,
	name VARCHAR(50) NOT NULL,
	deleted TINYINT(1) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE student_course (
	id BIGINT NOT NULL AUTO_INCREMENT,
    student_id BIGINT NOT NULL,
	course_id BIGINT NOT NULL,
    active TINYINT(1) DEFAULT 1,
    dateCreated DATETIME(6) DEFAULT NULL,
    dateModified timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    FOREIGN KEY (student_id)
      REFERENCES student(id),
    FOREIGN KEY (course_id)
      REFERENCES course(id)
) ENGINE=InnoDB;


INSERT INTO course (`code`,`name`) VALUES
('CCC-001', 'Introduction to programming'),
('CCC-002', 'Introduction to Calculus 1'),
('HIV-003', 'HIV and AIDS'),
('CCC-004', 'Physics'),
('CCC-005', 'Digital Logics'),
('CCC-006', 'Database and storage'),
('CCC-007', 'Discrete Mathematics'),
('CCC-008', 'Programming Basics'),
('CCC-009', 'Introduction to C++'),
('CCC-0010', 'Mathematics and Basics'),
('CCC-0011', 'Probability I'),
('CCC-0012', 'Probability II');