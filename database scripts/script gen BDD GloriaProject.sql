drop table sections_questions ;
drop table reponses_donnees ;
drop table reponses ;
drop table tests_sections ;
drop table questions_selectionnees ;
drop table sections ;
drop table themes_questions ;
drop table questions ;
drop table themes ;
drop table inscriptions ;
drop table tests ;
drop table formateurs;
drop table stagiaires;
drop table promotions;


create table promotions(
    id INT IDENTITY PRIMARY KEY,
    libelle nvarchar(200) NOT NULL
    )

create table stagiaires(
    id INT IDENTITY PRIMARY KEY,
    nom nvarchar(200),
    prenom nvarchar(200)  NOT NULL,
    email nvarchar(250)  NOT NULL,
    login nvarchar(100)  NOT NULL,
    password nvarchar(100)  NOT NULL,
    idPromotion int CONSTRAINT fk_promotion_stagiaire FOREIGN KEY REFERENCES promotions(id) 
)


create table formateurs(
    id INT IDENTITY PRIMARY KEY,
    nom nvarchar(200) NOT NULL,
    prenom nvarchar(200) NOT NULL,
    email nvarchar(250) NOT NULL,
    login nvarchar(100) NOT NULL,
    password nvarchar(100) NOT NULL,
    estResponsable BIT NOT NULL
)

create table tests(
    id INT IDENTITY PRIMARY KEY,
    libelle nvarchar(200) NOT NULL,
    seuilEnCoursAcquisition INT NOT NULL, --pourcentage de bonnes réponses,
    seuilAcquisition INT NOT NULL,
    idFormateur INT CONSTRAINT fk_test_formateur FOREIGN KEY REFERENCES formateurs(id)
    tempsPassage INT
)

create table inscriptions(
    idTest INT CONSTRAINT fk_inscriptions_tests FOREIGN KEY REFERENCES tests(id), 
    idStagiaire INT CONSTRAINT fk_inscriptions_stagiaires FOREIGN KEY REFERENCES stagiaires(id),
    idFormateur INT CONSTRAINT fk_inscriptions_formateurs FOREIGN KEY REFERENCES formateurs(id), 
    tempsRestant INT,
    CONSTRAINT pk_inscriptions PRIMARY KEY (idTest, idStagiaire)
)

create table themes(
    id INT IDENTITY PRIMARY KEY,
    libelle nvarchar(250) NOT NULL
)

create table questions(
    id INT IDENTITY PRIMARY KEY,
    enonce nvarchar(2000) NOT NULL,
    imageUri nvarchar(500),
    poids INT NOT NULL
)

create table themes_questions(
    idTheme INT CONSTRAINT fk_themes FOREIGN KEY REFERENCES themes(id),
    idQuestion INT CONSTRAINT fk_questions FOREIGN KEY REFERENCES questions(id),
    CONSTRAINT pk_themes_questions PRIMARY KEY (idTheme, idQuestion)
)

create table sections(
    id INT IDENTITY PRIMARY KEY,
    libelle nvarchar(250) NOT NULL
)

create table questions_selectionnees(
    idTest INT ,
    idStagiaire INT,
    idSection INT CONSTRAINT fk_sections_questions_selectionnees FOREIGN KEY REFERENCES sections(id),
    idQuestion INT CONSTRAINT fk_questions_questions_selectionnees FOREIGN KEY REFERENCES questions(id),
    CONSTRAINT pk_questions_selectionnees PRIMARY KEY(idTest, idStagiaire, idSection, idQuestion), 
    CONSTRAINT fk_questions_selectionnees_inscriptions FOREIGN KEY (idTest, idStagiaire) REFERENCES inscriptions(idTest, idStagiaire)
)

create table tests_sections(
    idTest INT CONSTRAINT fk_tests_tests_sections FOREIGN KEY REFERENCES tests(id),
    idSection INT CONSTRAINT fk_sections_tests_sections FOREIGN KEY REFERENCES sections(id),
    nbQuestions INT NOT NULL, 
    numSection INT NOT NULL,
    CONSTRAINT pk_tests_sections PRIMARY KEY(idTest, idSection)
)

create table reponses(
    id INT IDENTITY PRIMARY KEY,
    idQuestion INT CONSTRAINT fk_questions_repones FOREIGN KEY REFERENCES questions(id),
    enonce nvarchar(250) NOT NULL,
    estBonne BIT NOT NULL
)

create table reponses_donnees(
    idTest INT,
    idStagiaire INT,
    idSection INT,
    idQuestion INT,
    idReponse INT CONSTRAINT fk_reponses_donnees_reponses FOREIGN KEY REFERENCES reponses(id),
    CONSTRAINT pk_reponses_donnees PRIMARY KEY(idTest, idStagiaire, idSection, idQuestion, idReponse),
    CONSTRAINT fk_reponses_donnees_questions_selectionnees FOREIGN KEY (idTest, idStagiaire, idSection, idQuestion) REFERENCES questions_selectionnees(idTest, idStagiaire, idSection, idQuestion)

)

create table sections_questions(
    idSection INT CONSTRAINT fk_sections_sections_questions FOREIGN KEY REFERENCES sections(id),
    idQuestion INT CONSTRAINT fk_questions_sections_questions FOREIGN KEY REFERENCES questions(id),
    numQuestionDansSection INT NOT NULL,
    CONSTRAINT pk_sections_questions PRIMARY KEY(idSection, idQuestion)

)

