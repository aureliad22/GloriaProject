ALTER PROCEDURE MODIFY_CANDIDATE

@id int,
@nom nvarchar,
@prenom nvarchar,
@email nvarchar,
@login nvarchar,
@password nvarchar

AS


BEGIN

    UPDATE stagiaires

SET nom = @nom,
	prenom = @prenom,
	email =@email,
	login=@login,
	password=@password
  
WHERE id = @id
	
END;
