CREATE PROCEDURE DELETE_CANDIDATE

@id int

AS


BEGIN

    delete from stagiaires where 
	id = @id
END;

