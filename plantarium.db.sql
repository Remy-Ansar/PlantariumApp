DROP DATABASE IF EXISTS plantarium;

CREATE DATABASE plantarium;

USE plantarium;

CREATE TABLE Users (
    id_user INT UNSIGNED PRIMARY KEY auto_increment,
    email VARCHAR(255) NOT NULL UNIQUE,
    role ENUM('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER') NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME
);

CREATE TABLE User_infos (
    id_user_info INT UNSIGNED PRIMARY KEY auto_increment,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    profile_image_path VARCHAR(255),
    created_at DATETIME NOT NULL,
    updated_at DATETIME,
    user_id INT UNSIGNED
);

CREATE TABLE User_plants (
    id_user_plant INT UNSIGNED PRIMARY KEY auto_increment,
    created_at DATETIME NOT NULL,
    updated_at DATETIME,
    user_id INT UNSIGNED,
    plant_id INT UNSIGNED
);

CREATE TABLE Families (
    id_family INT UNSIGNED PRIMARY KEY auto_increment,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE Genus (
    id_genus INT UNSIGNED PRIMARY KEY auto_increment,
    name VARCHAR(255) NOT NULL,
    family_id INT UNSIGNED
);

CREATE TABLE Species (
    id_species INT UNSIGNED PRIMARY KEY auto_increment,
    name VARCHAR(255) NOT NULL,
    genus_id INT UNSIGNED
);

CREATE TABLE Categories (
    id_categorie INT UNSIGNED PRIMARY KEY auto_increment,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE Seasons (
    id_season INT UNSIGNED PRIMARY KEY auto_increment,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE Colors (
    id_color INT UNSIGNED PRIMARY KEY auto_increment,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE Weather (
    id_weather INT UNSIGNED PRIMARY KEY auto_increment,
    condition_name VARCHAR(100),
    condition_description VARCHAR(255),
    temperature DECIMAL(5,2),
    humidity INT,
    wind_speed DECIMAL(5,2),
    city VARCHAR(100),
    recorded_at DATETIME NOT NULL
);

CREATE TABLE Diseases (
    id_diseases INT UNSIGNED PRIMARY KEY auto_increment,
    name VARCHAR(150) NOT NULL UNIQUE,
    description VARCHAR(255),
    created_at DATETIME NOT NULL,
    updated_at DATETIME
);

CREATE TABLE Health_status (
    id_health_status INT UNSIGNED PRIMARY KEY auto_increment,
    status ENUM('En bonne sante', 'Malade', 'Morte') NOT NULL,
    recorded_at DATETIME NOT NULL,
    plant_detail_id INT UNSIGNED
);

CREATE TABLE Health_status_diseases (
    id_health_status_disease INT UNSIGNED PRIMARY KEY auto_increment,
    health_status_id INT UNSIGNED,
    disease_id INT UNSIGNED
);

CREATE TABLE Plants (
    id_plant INT UNSIGNED PRIMARY KEY auto_increment,
    name VARCHAR(255) NOT NULL UNIQUE,
    vernacular_name VARCHAR(255),
    created_at DATETIME NOT NULL,
    updated_at DATETIME,
    description TEXT,
    default_image_path VARCHAR(255),
    enable BOOLEAN,
    family_id INT UNSIGNED,
    genus_id INT UNSIGNED,
    species_id INT UNSIGNED
);

CREATE TABLE Watering (
    id_watering INT UNSIGNED PRIMARY KEY auto_increment,
    note TEXT,
    frequency INT,
    quantity DECIMAL(6,2),
    created_at DATETIME NOT NULL,
    updated_at DATETIME,
    plant_id INT UNSIGNED
);

CREATE TABLE Plant_categories (
    id_plant_category INT UNSIGNED PRIMARY KEY auto_increment,
    plant_id INT UNSIGNED,
    categorie_id INT UNSIGNED
);

CREATE TABLE Plant_seasons (
    id_plant_season INT UNSIGNED PRIMARY KEY auto_increment,
    plant_id INT UNSIGNED,
    season_id INT UNSIGNED
);

CREATE TABLE Plant_colors (
    id_plant_color INT UNSIGNED PRIMARY KEY auto_increment,
    plant_id INT UNSIGNED,
    color_id INT UNSIGNED
);

CREATE TABLE Warnings (
    id_warning INT UNSIGNED PRIMARY KEY auto_increment,
    name VARCHAR(50),
    description VARCHAR(255),
    reminder BOOLEAN,
    is_resolved BOOLEAN NOT NULL DEFAULT FALSE,
    due_date DATETIME,
    created_at DATETIME NOT NULL,
    updated_at DATETIME,
    plant_detail_id INT UNSIGNED,
    weather_id INT UNSIGNED
);

CREATE TABLE Plant_detail (
    id_plant_detail INT UNSIGNED PRIMARY KEY auto_increment,
    created_at DATETIME NOT NULL,
    updated_at DATETIME,
    nickname VARCHAR(255),
    personal_notes TEXT,
    user_image_path VARCHAR(255),
    location VARCHAR(255),
    user_plants_id INT UNSIGNED
);

CREATE TABLE Plant_detail_watering (
    id_plant_detail_watering INT UNSIGNED PRIMARY KEY auto_increment,
    created_at DATETIME NOT NULL,
    updated_at DATETIME,
    note TEXT,
    frequency INT,
    quantity DECIMAL(6,2),
    watering_id INT UNSIGNED,
    plant_detail_id INT UNSIGNED
);

CREATE TABLE Journal_entries (
    id_journal_entry INT UNSIGNED PRIMARY KEY auto_increment,
    title VARCHAR(255),
    entry_date DATETIME NOT NULL,
    content TEXT,
    plant_detail_id INT UNSIGNED
);

CREATE TABLE Watering_history (
    id_watering_history INT UNSIGNED PRIMARY KEY auto_increment,
    watered_at DATETIME NOT NULL,
    note TEXT,
    next_watering_date DATETIME,
    plant_detail_id INT UNSIGNED NOT NULL,
    plant_detail_watering_id INT UNSIGNED,
    weather_id INT UNSIGNED
);

ALTER TABLE User_infos
    ADD CONSTRAINT FK_UI_IdUser_Infos_ID_user FOREIGN KEY (user_id) REFERENCES Users (id_user);

ALTER TABLE User_plants
    ADD CONSTRAINT FK_UP_IdUser_ID_Plant_User FOREIGN KEY (user_id) REFERENCES Users (id_user);

ALTER TABLE User_plants
    ADD CONSTRAINT FK_UP_idPlant_ID_Plant_User FOREIGN KEY (plant_id) REFERENCES Plants (id_plant);

ALTER TABLE Genus
    ADD CONSTRAINT FK_G_idFamily_ID_Genus FOREIGN KEY (family_id) REFERENCES Families (id_family);

ALTER TABLE Species
    ADD CONSTRAINT FK_S_idGenus_ID_Species FOREIGN KEY (genus_id) REFERENCES Genus (id_genus);

ALTER TABLE Health_status
    ADD CONSTRAINT FK_HS_idPlant_detail_ID_Health_status FOREIGN KEY (plant_detail_id) REFERENCES Plant_detail (id_plant_detail);

ALTER TABLE Health_status_diseases
    ADD CONSTRAINT FK_HSD_idHealth_status_ID_Health_status_diseases FOREIGN KEY (health_status_id) REFERENCES Health_status (id_health_status);

ALTER TABLE Health_status_diseases
    ADD CONSTRAINT FK_HSD_idDisease_ID_Health_status_diseases FOREIGN KEY (disease_id) REFERENCES Diseases (id_diseases);

ALTER TABLE Plants
    ADD CONSTRAINT FK_P_idFamily_ID_Plant FOREIGN KEY (family_id) REFERENCES Families (id_family);

ALTER TABLE Plants
    ADD CONSTRAINT FK_P_idGenus_ID_Plant FOREIGN KEY (genus_id) REFERENCES Genus (id_genus);

ALTER TABLE Plants
    ADD CONSTRAINT FK_P_idSpecies_ID_Plant FOREIGN KEY (species_id) REFERENCES Species (id_species);

ALTER TABLE Watering
    ADD CONSTRAINT FK_Wa_idPlant_ID_Watering FOREIGN KEY (plant_id) REFERENCES Plants (id_plant);

ALTER TABLE Plant_categories
    ADD CONSTRAINT FK_PCA_idPlant_ID_Plant_categories FOREIGN KEY (plant_id) REFERENCES Plants (id_plant);

ALTER TABLE Plant_categories
    ADD CONSTRAINT FK_PCA_idCategorie_ID_Plant_categories FOREIGN KEY (categorie_id) REFERENCES Categories (id_categorie);

ALTER TABLE Plant_seasons
    ADD CONSTRAINT FK_PS_idPlant_ID_Plant_seasons FOREIGN KEY (plant_id) REFERENCES Plants (id_plant);

ALTER TABLE Plant_seasons
    ADD CONSTRAINT FK_PS_idSeason_ID_Plant_seasons FOREIGN KEY (season_id) REFERENCES Seasons (id_season);

ALTER TABLE Plant_colors
    ADD CONSTRAINT FK_PC_idPlant_ID_Plant_colors FOREIGN KEY (plant_id) REFERENCES Plants (id_plant);

ALTER TABLE Plant_colors
    ADD CONSTRAINT FK_PC_idColor_ID_Plant_colors FOREIGN KEY (color_id) REFERENCES Colors (id_color);

ALTER TABLE Warnings
    ADD CONSTRAINT FK_W_idPlant_detail_ID_Warning FOREIGN KEY (plant_detail_id) REFERENCES Plant_detail (id_plant_detail);

ALTER TABLE Warnings
    ADD CONSTRAINT FK_W_idWeather_ID_Warning FOREIGN KEY (weather_id) REFERENCES Weather (id_weather);

ALTER TABLE Plant_detail
    ADD CONSTRAINT FK_PD_idUser_Plants_ID_Plant_detail FOREIGN KEY (user_plants_id) REFERENCES User_plants (id_user_plant);


ALTER TABLE Plant_detail_watering
    ADD CONSTRAINT FK_PDW_idWatering_ID_Plant_detail_watering FOREIGN KEY (watering_id) REFERENCES Watering (id_watering);

ALTER TABLE Plant_detail_watering
    ADD CONSTRAINT FK_PDW_idPlant_detail_ID_Plant_detail_watering FOREIGN KEY (plant_detail_id) REFERENCES Plant_detail (id_plant_detail);

ALTER TABLE Journal_entries
    ADD CONSTRAINT FK_JE_idPlant_detail_ID_Journal_entries FOREIGN KEY (plant_detail_id) REFERENCES Plant_detail (id_plant_detail);

ALTER TABLE Watering_history
    ADD CONSTRAINT FK_WH_idPlant_detail_ID_Watering_history FOREIGN KEY (plant_detail_id) REFERENCES Plant_detail (id_plant_detail);

ALTER TABLE Watering_history
    ADD CONSTRAINT FK_WH_idPlant_detail_watering_ID_Watering_history FOREIGN KEY (plant_detail_watering_id) REFERENCES Plant_detail_watering (id_plant_detail_watering);

ALTER TABLE Watering_history
    ADD CONSTRAINT FK_WH_idWeather_ID_Watering_history FOREIGN KEY (weather_id) REFERENCES Weather (id_weather);
