insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Rick', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1); 
 
insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Summer', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Morty', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1); 

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Jessica', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1); 


insert into sec_role (roleName)
values ('ROLE_ADMIN');
 
insert into sec_role (roleName)
values ('ROLE_MEMBER');

insert into sec_role (roleName)
values ('ROLE_GUEST');
 
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
values ('BREED_AMERICAN_BULLY');
 
insert into breed_table (breedName)
values ('BREED_GERMAN_SHEPERD');

insert into breed_table (breedName)
values ('BREED_BORDERCOLLIE');

insert into breed_table (breedName)
values ('BREED_GOLDEN_RETREIVER');

insert into breed_table (breedName)
values ('BREED_FRENCH_BULLDOG');

insert into breed_table (breedName)
values ('BREED_AUSTRALIAN_SHEPPARD');

insert into breed_table (breedName)
values ('BREED_LABRADOR');

insert into breed_table (breedName)
values ('BREED_DALMATIAN');

insert into breed_table (breedName)
values ('BREED_WEIMARANER');

insert into breed_table (breedName)
values ('BREED_ ROTTWEILER');




INSERT INTO contact_info (name, address, phoneNumber, email, role) VALUES 
('Bonnie', '3115 turnstone Crescent',  '9056088510',  'bonny@gmail.com','ROLE_ADMIN'),
('Ruby', '30 Summer Drive', '4168248910', 'backup@email.com','ROLE_MEMBER'),

('Rhode', 'Fender Boulevard', '6474640122', 'Equador@gmail.com','ROLE_GUEST');

