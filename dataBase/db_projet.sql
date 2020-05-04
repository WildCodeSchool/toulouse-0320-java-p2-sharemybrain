#------------------------------------------------------------

#        Script MySQL.

#------------------------------------------------------------

​

​

#------------------------------------------------------------

# Table: skill

#------------------------------------------------------------

​

CREATE TABLE skill(

        id_skill Int  Auto_increment  NOT NULL ,

        name     Text NOT NULL

	,CONSTRAINT skill_PK PRIMARY KEY (id_skill)

)ENGINE=InnoDB;

​

​

#------------------------------------------------------------

# Table: avatar

#------------------------------------------------------------

​

CREATE TABLE avatar(

        id_avatar Int  Auto_increment  NOT NULL ,
        url      Text NOT NULL
	,CONSTRAINT avatar_PK PRIMARY KEY (id_avatar)

)ENGINE=InnoDB;

​

​

#------------------------------------------------------------

# Table: user

#------------------------------------------------------------

​

CREATE TABLE user(

        id_user   Int  Auto_increment  NOT NULL ,

        username Varchar (50) NOT NULL ,

        email     Varchar (50) NOT NULL ,

        password  Varchar (255) NOT NULL ,

        id_avatar Int NOT NULL ,

        id_skill  Int

	,CONSTRAINT user_PK PRIMARY KEY (id_user)

​

	,CONSTRAINT user_avatar_FK FOREIGN KEY (id_avatar) REFERENCES avatar(id_avatar)

	,CONSTRAINT user_skill0_FK FOREIGN KEY (id_skill) REFERENCES skill(id_skill)

)ENGINE=InnoDB;

​

​

#------------------------------------------------------------

# Table: question

#------------------------------------------------------------

​

CREATE TABLE question(

        id_question Int  Auto_increment  NOT NULL ,

        title       Text NOT NULL ,

        description Text NOT NULL ,

        date        Date NOT NULL ,

        id_user     Int NOT NULL ,

        id_skill    Int NOT NULL

	,CONSTRAINT question_PK PRIMARY KEY (id_question)

​

	,CONSTRAINT question_user_FK FOREIGN KEY (id_user) REFERENCES user(id_user)

	,CONSTRAINT question_skill0_FK FOREIGN KEY (id_skill) REFERENCES skill(id_skill)

)ENGINE=InnoDB;

​

​

#------------------------------------------------------------

# Table: answer

#------------------------------------------------------------

​

CREATE TABLE answer(

        id_answer int Auto_increment NOT NULL ,

        id_question Int NOT NULL ,

        id_user     Int NOT NULL ,

        description Text NOT NULL ,

        date        Date NOT NULL

	,CONSTRAINT answer_PK PRIMARY KEY (id_answer)

​

	,CONSTRAINT answer_question_FK FOREIGN KEY (id_question) REFERENCES question(id_question)

	,CONSTRAINT answer_user0_FK FOREIGN KEY (id_user) REFERENCES user(id_user)

)ENGINE=InnoDB;

​