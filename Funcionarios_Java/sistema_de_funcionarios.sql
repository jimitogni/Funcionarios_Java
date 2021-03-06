USE [sistema_de_funcionarios]
GO
/****** Object:  Table [dbo].[cargos]    Script Date: 16/07/2019 22:40:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[cargos](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nome] [varchar](50) NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[funcionarios]    Script Date: 16/07/2019 22:40:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[funcionarios](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nome] [varchar](50) NOT NULL,
	[sobrenome] [varchar](50) NOT NULL,
	[dataNascimento] [varchar](50) NOT NULL,
	[email] [varchar](50) NULL,
	[cargo] [int] NOT NULL,
	[salario] [money] NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
