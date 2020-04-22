CREATE TABLE trainers(
  id INTEGER,
  name VARCHAR(100) NOT NULL,
  level SMALLINT NOT NULL DEFAULT 1,
  PRIMARY KEY (id)
);

CREATE TABLE pokemon(
  id INTEGER,
  name VARCHAR(20) NOT NULL,
  number SMALLINT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE wild_pokemon(
  id INTEGER,
  combat_power SMALLINT NOT NULL DEFAULT 0,
  pokemon_id INTEGER NOT NULL,
  trainer_id INTEGER,
  PRIMARY KEY (id),
  FOREIGN KEY (pokemon_id) REFERENCES pokemon (id)
    ON DELETE CASCADE,
  FOREIGN KEY (trainer_id) REFERENCES trainers (id)
    ON DELETE SET NULL
);