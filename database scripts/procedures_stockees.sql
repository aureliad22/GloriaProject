-- =============================================
-- Author:      Aurélia Delauné
-- Create date: 01/08/2017
-- Description: Stored procedure that returns 
-- =============================================
CREATE PROCEDURE AUTHENTICATE_CANDIDATE 
    -- Add the parameters for the stored procedure here
    @mail nvarchar,
    @login nvarchar,
    @password nvarchar
    
AS
BEGIN
    SELECT 
        id, 
        nom, 
        prenom, 
        email, 
        login, 
        idPromotion
    FROM
        stagiaires
    WHERE
        (email = @mail AND password = @password)
        OR
        (login = @login AND password = @password)
    RETURN
END

