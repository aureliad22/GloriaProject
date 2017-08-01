CREATE PROCEDURE ADD_CANDIDATE

@nom nvarchar,
@prenom nvarchar,
@email nvarchar,
@login nvarchar,
@password nvarchar,
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
