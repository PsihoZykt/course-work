insert into users(id, favourite_pokemon, money, bet_amount, birth_date, email,
                  gender , rating,  username, password, active)
values (1, 'charmander', 9999, 100 , '1999-26-01',
        'psihozykt@gmail.com' , 'male', 9999,   'admin', 'admin',  true);
insert into user_role(user_id, roles)
values(1, 'USER'), (1, 'ADMIN');
