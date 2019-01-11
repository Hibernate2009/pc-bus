CREATE TABLE [dbo].[opentext_card_delivery](
	[uuid] [varchar](50) NOT NULL,
	[queue] [varchar](255) NOT NULL,
	[context] [varchar](max) NOT NULL,
	[time] [datetime] NOT NULL,
	[send_status] [numeric](1, 0)
)