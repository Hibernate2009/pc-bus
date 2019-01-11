USE [fuse_test]
GO
/****** Object:  StoredProcedure [dbo].[getContractData]    Script Date: 08/23/2018 16:50:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE procedure [dbo].[get_opentext_card_delivery](@p_num_rows integer) as
begin

	declare @OutputTabel table (uuid [varchar](50))

	update top (@p_num_rows)
	  obm
	set
	  obm.send_status = 1
	output
	  INSERTED.uuid INTO @OutputTabel(uuid)
	from
	  dbo.opentext_card_delivery obm
	where
	  obm.send_status = 0


	SELECT * FROM dbo.opentext_card_delivery opd where opd.uuid in (select uuid from @OutputTabel);

end