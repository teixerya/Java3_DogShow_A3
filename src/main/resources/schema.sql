Create table SEC_USER
(
  userId           BIGINT NOT NULL Primary Key AUTO_INCREMENT,
  userName         VARCHAR(36) NOT NULL UNIQUE,
  encryptedPassword VARCHAR(128) NOT NULL,
  ENABLED           BIT NOT NULL 
) ;


create table SEC_ROLE
(
  roleId   BIGINT NOT NULL Primary Key AUTO_INCREMENT,
  roleName VARCHAR(30) NOT NULL UNIQUE
) ;


create table USER_ROLE
(
  ID      BIGINT NOT NULL Primary Key AUTO_INCREMENT,
  userId BIGINT NOT NULL,
  roleId BIGINT 

);

alter table USER_ROLE
  add constraint USER_ROLE_UK unique (userId, roleId);

alter table USER_ROLE
  add constraint USER_ROLE_FK1 foreign key (userId)
  references SEC_USER (userId);
 
alter table USER_ROLE
  add constraint USER_ROLE_FK2 foreign key (roleId)
  references SEC_ROLE (roleId);
  
  
  
create table BREED_TABLE (
breedId   INT NOT NULL Primary Key AUTO_INCREMENT,
breedName VARCHAR(30)
) ;





CREATE TABLE DOG_REGISTRY_TABLE (

      dogId INT NOT NULL Primary Key AUTO_INCREMENT,
      dogName VARCHAR(25),
      ownerName VARCHAR(50),
      breed VARCHAR(25),
      gender VARCHAR(30),
      classSpecialty VARCHAR(30));

  
  
      
      
CREATE TABLE contact_info (
id INT NOT NULL Primary Key AUTO_INCREMENT,
name VARCHAR(25), 
address VARCHAR(50), 
phoneNumber VARCHAR(25), 
email VARCHAR(30),
role VARCHAR(30));
  