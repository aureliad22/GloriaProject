USE [GloriaProject]
GO
/****** Object:  StoredProcedure [dbo].[RESEARCH_CANDIDATE]    Script Date: 01/08/2017 14:41:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE [dbo].[RESEARCH_CANDIDATE]


@nom nvarchar(200),
@prenom nvarchar(200),
@email nvarchar(250)


AS


BEGIN

    SELECT * from stagiaires

where
    nom = @nom OR
    prenom = @prenom OR
    email = @email
    
    
END;