CREATE TABLE IF NOT EXISTS yearbook (
  id bigserial,
  grade INT NOT NULL,
  school_name VARCHAR(45) NOT NULL,
  type VARCHAR(45) NOT NULL,
  is_photographed BOOLEAN NOT NULL,
  is_edited BOOLEAN NOT NULL,
  price int not null,
  PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS student (
  id bigserial,
  full_name VARCHAR(45) NOT NULL,
  tg_username VARCHAR(45),
  yearbook_id bigint NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_student_yearbook1
    FOREIGN KEY (yearbook_id)
    REFERENCES yearbook (id)
    ON DELETE cascade
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS parent_supervisor (
  id bigserial,
  name VARCHAR(45) NOT NULL,
  phone VARCHAR(45) NULL,
  yearbook_id bigint NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_parent_yearbook1
    FOREIGN KEY (yearbook_id)
    REFERENCES yearbook (id)
    ON DELETE cascade
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS photo (
  id bigserial,
  student_id INT,
  yearbook_id INT NOT NULL,
  file_path VARCHAR(45) NOT NULL,
  is_edited boolean NOT NULL,
  is_selected boolean NOT NULL,
  is_portrait boolean NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_photo_student1
    FOREIGN KEY (student_id)
    REFERENCES student (id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
  CONSTRAINT fk_photo_yearbook1
    FOREIGN KEY (yearbook_id)
    REFERENCES yearbook (id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);