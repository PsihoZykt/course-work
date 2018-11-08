CREATE TABLE battle (
  id            BIGSERIAL NOT NULL,
  date          TIMESTAMP,
  pokemon_name1 VARCHAR(255),
  pokemon_name2 VARCHAR(255),
  PRIMARY KEY (id)
);
CREATE TABLE bet (
  id           BIGSERIAL NOT NULL,
  bet          INT4,
  bet_date     TIMESTAMP,
  coef         INT4,
  pokemon_name VARCHAR(255),
  bs_id        INT8,
  user_id      INT8,
  PRIMARY KEY (id)
);
CREATE TABLE bet_history (
  id         BIGSERIAL NOT NULL,
  is_success BOOLEAN,
  bet_id     INT8,
  PRIMARY KEY (id)
);
CREATE TABLE rating (
  id      BIGSERIAL NOT NULL,
  rating  INT4,
  user_id INT8,
  PRIMARY KEY (id)
);
CREATE TABLE shop (
  id            BIGSERIAL NOT NULL,
  amount        INT4,
  product_name  VARCHAR(255),
  product_price INT4,
  PRIMARY KEY (id)
);
CREATE TABLE shop_history (
  id         BIGSERIAL NOT NULL,
  date       TIMESTAMP,
  product_id INT8,
  user_id    INT8,
  PRIMARY KEY (id)
);
CREATE TABLE user_role (
  user_id INT8 NOT NULL,
  roles   VARCHAR(255)
);
CREATE TABLE users (
  id                BIGSERIAL NOT NULL,
  favourite_pokemon VARCHAR(255),
  money             INT4,
  activation_code   VARCHAR(255),
  active            BOOLEAN,
  bet_amount        INT4,
  bet_win_procent   INT4,
  birth_date        VARCHAR(255),
  email             VARCHAR(255),
  gender            VARCHAR(255),
  is_banned         BOOLEAN,
  password          VARCHAR(255),
  password_confirm  VARCHAR(255),
  rating            INT4,
  registration_date TIMESTAMP,
  username          VARCHAR(255),
  PRIMARY KEY (id)
);
ALTER TABLE IF EXISTS rating
  ADD CONSTRAINT rating_user_fk UNIQUE (user_id);
ALTER TABLE IF EXISTS shop
  ADD CONSTRAINT UK_36ljaybfvplnqp15uuxt6x2j4 UNIQUE (product_name);
ALTER TABLE IF EXISTS users
  ADD CONSTRAINT UK_6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email);
ALTER TABLE IF EXISTS users
  ADD CONSTRAINT UK_r43af9ap4edm43mmtq01oddj6 UNIQUE (username);
ALTER TABLE IF EXISTS bet
  ADD CONSTRAINT FKpyyina41c6indn0pwqeeju754 FOREIGN KEY (bs_id) REFERENCES battle;
ALTER TABLE IF EXISTS bet
  ADD CONSTRAINT FKq5rv2e6soot2iosewr8r4i235 FOREIGN KEY (user_id) REFERENCES users;
ALTER TABLE IF EXISTS bet_history
  ADD CONSTRAINT FKhfrw99jm316cvvrcwy9pbhodp FOREIGN KEY (bet_id) REFERENCES bet;
ALTER TABLE IF EXISTS rating
  ADD CONSTRAINT FKf68lgbsbxl310n0jifwpfqgfh FOREIGN KEY (user_id) REFERENCES users;
ALTER TABLE IF EXISTS shop_history
  ADD CONSTRAINT FKnpqt13h3tjn3vngkf2jsr9a71 FOREIGN KEY (product_id) REFERENCES shop;
ALTER TABLE IF EXISTS shop_history
  ADD CONSTRAINT FKo2q5vmi2dnj8ro1pald59mrwf FOREIGN KEY (user_id) REFERENCES users;
ALTER TABLE IF EXISTS user_role
  ADD CONSTRAINT FKj345gk1bovqvfame88rcx7yyx FOREIGN KEY (user_id) REFERENCES users;