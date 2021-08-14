insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Rick', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1); 
 
insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Summer', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Morty', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1); 

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Jessica', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1); 


insert into sec_role (roleName)
values ('ADMIN');
 
insert into sec_role (roleName)
values ('OWNER');

insert into sec_role (roleName)
values ('GUEST');
 
insert into user_role (userId, roleId)
values (1, 1);
 
insert into user_role (userId, roleId)
values (2, 2);

insert into user_role (userId, roleId)
values (3, 3);

insert into user_role (userId, roleId)
values (4, 1);
 
insert into user_role (userId, roleId)
values (4, 2);

insert into user_role (userId, roleId)
values (4, 3);



insert into breed_table (breedName)
values ('American Bully');
 
insert into breed_table (breedName)
values ('German Shepard');

insert into breed_table (breedName)
values ('Border Collie');

insert into breed_table (breedName)
values ('Golden Retriever');

insert into breed_table (breedName)
values ('French Bulldog');

insert into breed_table (breedName)
values ('Australian Shepard');

insert into breed_table (breedName)
values ('Labrador');

insert into breed_table (breedName)
values ('Dalmatian');

insert into breed_table (breedName)
values ('Weimaraner');

insert into breed_table (breedName)
values ('Rottweiler');


INSERT INTO DOG_REGISTRY_TABLE (dogName, ownerName, breed, gender, classSpecialty) VALUES
('Rocket', 'Owner Bart',  'American Bully',  'Female','Female Specialty'),
('Max', 'Owner Bart',  'German Shepard',  'Male','Male Class'),

('Cooper', 'Owner Rick',  'Border Collie',  'Male','Male Class'),
('Charly', 'Owner Rick',  'Golden Retriever',  'Female','Female Class'),

('Ted', 'Owner Jess',  'French Bulldog',  'Male','Male Class'),
('Bear', 'Owner Jess',  'Australian Shepard',  'Male','Male Class'),

('Milo', 'Owner Marty',  'Labrador',  'Male','Male Class'),
('Bentley', 'Owner Marty',  'Dalmatian',  'Female','Female Class'),

('Olly', 'Owner Morty',  'Weimaraner',  'Male','Male Specialty'),
('Boujee', 'Owner Wendy',  'Rottweiler',  'Female','Female Class'),


('Leo', 'Owner Pablo Escobar',  'American Bully',  'Female','Female Specialty'),
('Zeus', 'Owner Pablo Escobar',  'German Shepard',  'Male','Male Specialty'),

('Duke', 'Owner Pablo Escobar',  'Border Collie',  'Male','Male Specialty'),
('Diesel', 'Owner Pablo Escobar',  'Golden Retriever',  'Female','Female Specialty'),

('Dudly', 'Owner Gustavo',  'French Bulldog',  'Male','Male Specialty'),
('Ben', 'Owner Gustavo',  'Australian Shepard',  'Male','Male Specialty'),

('Louie', 'Owner Gustavo',  'Labrador',  'Male','Male Specialty'),
('Ruby', 'Owner Gustavo',  'Dalmatian',  'Female','Female Specialty'),

('Jax', 'Owner Gustavo',  'Weimaraner',  'Male','Male Specialty'),
('Kodak', 'Owner Gustavo',  'Rottweiler',  'Female','Female Specialty'),


('Buster', 'Owner Tata',  'American Bully',  'Female','Female Specialty'),
('Bubba', 'Owner Tata',  'German Shepard',  'Male','Male Class'),

('Ziggy', 'Owner Tata',  'Border Collie',  'Male','Male Class'),
('Zeze', 'Owner Tata',  'Golden Retriever',  'Female','Female Class'),

('Drake', 'Owner Judy',  'French Bulldog',  'Male','Male Class'),
('Bad Dog', 'Owner Judy',  'Australian Shepard',  'Male','Male Class'),

('Winston', 'Owner Judy',  'Labrador',  'Male','Male Class'),
('Come here boy', 'Owner Judy',  'Dalmatian',  'Female','Female Class'),

('Oliver', 'Owner Camilla',  'Weimaraner',  'Male','Male Specialty'),
('Marley', 'Owner Camilla',  'Rottweiler',  'Female','Female Class'),


('Ranger', 'Owner Tata',  'American Bully',  'Female','Female Specialty'),
('Dexter', 'Owner Tata',  'German Shepard',  'Male','Male Class'),

('Thor', 'Owner Tata',  'Border Collie',  'Male','Male Class'),
('Sub Zero', 'Owner Tata',  'Golden Retriever',  'Female','Female Class'),

('Drake', 'Owner Judy',  'French Bulldog',  'Male','Male Class'),
('Bad Dog', 'Owner Judy',  'Australian Shepard',  'Male','Male Class'),

('Clark', 'Owner Judy',  'Labrador',  'Male','Male Class'),
('Hold my beer', 'Owner Judy',  'Dalmatian',  'Female','Female Class'),

('Caro', 'Owner Camilla',  'Weimaraner',  'Male','Male Specialty'),
('Icecream', 'Owner Camilla',  'Rottweiler',  'Female','Female Class'),




('Jupiter', 'Owner Sal',  'Rottweiler',  'Female','Male Specialty');




INSERT INTO contact_info (name, address, phoneNumber, email, role) VALUES
('Bonnie', '3115 turnstone Crescent',  '9056088510',  'bonny@gmail.com','ROLE_ADMIN'),
('Ruby', '30 Summer Drive', '4168248910', 'backup@email.com','ROLE_MEMBER'),

('Rhode', 'Fender Boulevard', '6474640122', 'Equador@gmail.com','ROLE_GUEST');


