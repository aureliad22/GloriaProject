USE [GloriaProject]
GO
/****** Object:  StoredProcedure [dbo].[RESEARCH_CANDIDATE]    Script Date: 01/08/2017 14:41:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE [dbo].[RESEARCH_CANDIDATE]


@nom nvarchar,
@prenom nvarchar,
@email nvarchar


AS


BEGIN

    SELECT * from stagiaires

where
	nom = @nom AND
	prenom = @prenom AND
	email = @email
	
	
END;