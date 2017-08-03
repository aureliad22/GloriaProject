CREATE PROCEDURE ADD_CANDIDATE

@nom nvarchar(200),
@prenom nvarchar(200),
@email nvarchar(250),
@login nvarchar(100),
@password nvarchar(100),
@idPromotion int
AS


BEGIN

    insert into stagiaires(nom, prenom, email, login, password, idPromotion) values (
	@nom,
	@prenom,
	@email,
	@login,
	@password,
	@idPromotion)

	return SCOPE_IDENTITY()
END;
