ALTER PROCEDURE MODIFY_CANDIDATE

@id int,
@nom nvarchar(200),
@prenom nvarchar(200),
@email nvarchar(250),
@login nvarchar(100),
@password nvarchar(100),
@idPromotion int

AS


BEGIN

    UPDATE stagiaires

SET nom = @nom,
    prenom = @prenom,
    email =@email,
    login=@login,
    password=@password,
    idPromotion = @idPromotion
  
WHERE id = @id
    
END;
