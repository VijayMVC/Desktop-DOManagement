CREATE DATABASE DOManagement
USE [DOManagement]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 5/26/2018 7:32:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[Account_ID] [int] IDENTITY(1,1) NOT NULL,
	[Account_FullName] [nvarchar](100) NOT NULL,
	[Account_Email] [nvarchar](100) NOT NULL,
	[Account_Mobile] [nvarchar](50) NOT NULL,
	[Account_UseName] [nvarchar](50) NOT NULL,
	[Account_Password] [nvarchar](50) NOT NULL,
	[Account_Type] [nvarchar](50) NOT NULL,
	[Account_Created] [date] NOT NULL,
	[Account_Status] [int] NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[Account_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CheckOut]    Script Date: 5/26/2018 7:32:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CheckOut](
	[CheckOut_ID] [int] IDENTITY(1,1) NOT NULL,
	[Student_ID] [int] NOT NULL,
	[Room_ID] [int] NOT NULL,
	[CheckOut_Status] [bit] NOT NULL,
 CONSTRAINT [PK_CheckOut] PRIMARY KEY CLUSTERED 
(
	[CheckOut_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Dom]    Script Date: 5/26/2018 7:32:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Dom](
	[Dom_ID] [int] IDENTITY(1,1) NOT NULL,
	[Dom_Name] [nvarchar](50) NOT NULL,
	[Dom_Acronym] [nvarchar](50) NULL,
	[Dom_Status] [int] NULL,
 CONSTRAINT [PK_Dom] PRIMARY KEY CLUSTERED 
(
	[Dom_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[EmailContent]    Script Date: 5/26/2018 7:32:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EmailContent](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Email_Id] [int] NULL,
	[Email_Subject] [nvarchar](200) NULL,
	[Email_Content] [nvarchar](3999) NULL,
	[Email_Note] [nvarchar](200) NULL,
 CONSTRAINT [PK_EmailContent] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[EmailInfo]    Script Date: 5/26/2018 7:32:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EmailInfo](
	[Email_ID] [int] IDENTITY(1,1) NOT NULL,
	[Email] [nvarchar](100) NULL,
	[Email_Password] [nvarchar](100) NULL,
	[Email_Rule] [nvarchar](50) NULL,
	[Email_Note] [nvarchar](250) NULL,
 CONSTRAINT [PK_EmailInfo] PRIMARY KEY CLUSTERED 
(
	[Email_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Room]    Script Date: 5/26/2018 7:32:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Room](
	[Room_ID] [int] IDENTITY(1,1) NOT NULL,
	[Dom_ID] [int] NOT NULL,
	[Room_RoomNumber] [nvarchar](50) NOT NULL,
	[Room_NumberStudent] [int] NULL,
	[Room_FreeSlot] [int] NULL,
	[Room_ElectricityNumberLastSemester] [int] NULL,
	[Room_ElectricityNumberThisSemester] [int] NULL,
	[Room_WaterNumberLastSemester] [int] NULL,
	[Room_WaterNumberThisSemester] [int] NULL,
	[Room_PayStatus] [bit] NULL,
	[Room_Status] [int] NULL,
	[Room_Type] [int] NULL,
 CONSTRAINT [PK_DomA] PRIMARY KEY CLUSTERED 
(
	[Room_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Students]    Script Date: 5/26/2018 7:32:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Students](
	[Student_ID] [int] IDENTITY(1,1) NOT NULL,
	[Room_ID] [int] NOT NULL,
	[Student_RollNumber] [nvarchar](100) NOT NULL,
	[Student_FullName] [nvarchar](50) NULL,
	[Student_Email] [nvarchar](50) NULL,
	[Student_Mobile] [nvarchar](50) NULL,
	[Student_Address] [nvarchar](200) NULL,
	[Student_Gender] [bit] NULL,
	[Student_StartDate] [date] NULL,
 CONSTRAINT [PK_Student] PRIMARY KEY CLUSTERED 
(
	[Student_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TransferRoom]    Script Date: 5/26/2018 7:32:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TransferRoom](
	[TransferRoom_ID] [int] IDENTITY(1,1) NOT NULL,
	[Student_ID] [int] NOT NULL,
	[Room_ID] [int] NOT NULL,
	[TransferRoom_Status] [bit] NOT NULL,
 CONSTRAINT [PK_TransferRoom] PRIMARY KEY CLUSTERED 
(
	[TransferRoom_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([Account_ID], [Account_FullName], [Account_Email], [Account_Mobile], [Account_UseName], [Account_Password], [Account_Type], [Account_Created], [Account_Status]) VALUES (4, N'Tuấn Anh', N'director@fpt.edu.vn', N'0976456888', N'staff001', N'123456', N'staff', CAST(N'2017-08-13' AS Date), 1)
INSERT [dbo].[Account] ([Account_ID], [Account_FullName], [Account_Email], [Account_Mobile], [Account_UseName], [Account_Password], [Account_Type], [Account_Created], [Account_Status]) VALUES (5, N'Nhật Lệ', N'admin@fpt.edu.vn', N'0169040796', N'admin', N'123456', N'admin', CAST(N'2017-08-15' AS Date), 1)
INSERT [dbo].[Account] ([Account_ID], [Account_FullName], [Account_Email], [Account_Mobile], [Account_UseName], [Account_Password], [Account_Type], [Account_Created], [Account_Status]) VALUES (17, N'Minh Linh', N'linhmse04422@fpt.edu.vn', N'0165222356', N'linhmse04422', N'123456', N'student', CAST(N'2017-08-21' AS Date), 1)
INSERT [dbo].[Account] ([Account_ID], [Account_FullName], [Account_Email], [Account_Mobile], [Account_UseName], [Account_Password], [Account_Type], [Account_Created], [Account_Status]) VALUES (19, N'Đinh Tuấn Anh', N'anhdtse03435@fpt.edu.vn', N'0973876107', N'anhdtse03435', N'123456', N'student', CAST(N'2017-08-22' AS Date), 1)
INSERT [dbo].[Account] ([Account_ID], [Account_FullName], [Account_Email], [Account_Mobile], [Account_UseName], [Account_Password], [Account_Type], [Account_Created], [Account_Status]) VALUES (20, N'Lệ Thu Giang', N'giangltsb05559@fpt.edu.vn', N'0978568952', N'giangltsb05559', N'12345678', N'student', CAST(N'2018-04-13' AS Date), 0)
INSERT [dbo].[Account] ([Account_ID], [Account_FullName], [Account_Email], [Account_Mobile], [Account_UseName], [Account_Password], [Account_Type], [Account_Created], [Account_Status]) VALUES (21, N'Sún Chó', N'suncho2511@fpt.edu.vn', N'0952569586', N'suncho2511', N'123456', N'admin', CAST(N'2018-04-18' AS Date), 1)
INSERT [dbo].[Account] ([Account_ID], [Account_FullName], [Account_Email], [Account_Mobile], [Account_UseName], [Account_Password], [Account_Type], [Account_Created], [Account_Status]) VALUES (22, N'Trương Minh Thu', N'thutmse04455@fpt.edu.vn', N'0987678888', N'thutmse04455', N'12345678', N'staff', CAST(N'2018-05-06' AS Date), 1)
SET IDENTITY_INSERT [dbo].[Account] OFF
SET IDENTITY_INSERT [dbo].[Dom] ON 

INSERT [dbo].[Dom] ([Dom_ID], [Dom_Name], [Dom_Acronym], [Dom_Status]) VALUES (1, N'Dom A', N'doma', 1)
INSERT [dbo].[Dom] ([Dom_ID], [Dom_Name], [Dom_Acronym], [Dom_Status]) VALUES (2, N'Dom B', N'domb', 1)
INSERT [dbo].[Dom] ([Dom_ID], [Dom_Name], [Dom_Acronym], [Dom_Status]) VALUES (3, N'Dom C', N'domc', 1)
INSERT [dbo].[Dom] ([Dom_ID], [Dom_Name], [Dom_Acronym], [Dom_Status]) VALUES (4, N'Dom D', N'domd', 1)
INSERT [dbo].[Dom] ([Dom_ID], [Dom_Name], [Dom_Acronym], [Dom_Status]) VALUES (5, N'Dom E', N'dome', 1)
SET IDENTITY_INSERT [dbo].[Dom] OFF
SET IDENTITY_INSERT [dbo].[EmailInfo] ON 

INSERT [dbo].[EmailInfo] ([Email_ID], [Email], [Email_Password], [Email_Rule], [Email_Note]) VALUES (1, N'suncho2511@gmail.com', N's25111211', N'ktx', NULL)
INSERT [dbo].[EmailInfo] ([Email_ID], [Email], [Email_Password], [Email_Rule], [Email_Note]) VALUES (2, N'tripnetsp@gmail.com', N's25111211', N'system', NULL)
INSERT [dbo].[EmailInfo] ([Email_ID], [Email], [Email_Password], [Email_Rule], [Email_Note]) VALUES (9, N'support.fpt@gmail.com', N'12345678', N'support', N'')
SET IDENTITY_INSERT [dbo].[EmailInfo] OFF
SET IDENTITY_INSERT [dbo].[Room] ON 

INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (1, 1, N'A101', 4, 4, 1900, 2000, 1000, 1500, 1, 2, 0)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (2, 1, N'A102', 4, 4, 950, 1050, 550, 700, 1, 1, 1)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (3, 1, N'A103', 3, 5, 300, 400, 129, 229, 1, 1, 1)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (4, 1, N'A104', 8, 0, 144, 211, 77, 123, 1, 1, 1)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (6, 1, N'A105', 6, 2, 280, 400, 123, 180, 1, 1, 0)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (7, 1, N'A106', 5, 3, 280, 400, 144, 200, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (8, 1, N'A107', 6, 2, 144, 280, 77, 123, 0, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (12, 1, N'A108', 7, 1, 144, 280, 77, 123, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (13, 1, N'A109', 8, 0, 144, 211, 56, 123, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (14, 1, N'A110', 7, 1, 144, 280, 88, 144, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (15, 1, N'A111', 6, 2, 122, 211, 56, 144, 0, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (16, 1, N'A112', 6, 2, 122, 211, 56, 144, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (17, 1, N'A113', 8, 0, 122, 280, 88, 123, 0, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (18, 1, N'A114', 5, 3, 122, 280, 88, 144, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (19, 1, N'A201', 8, 0, 122, 280, 88, 144, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (20, 1, N'A202', 7, 1, 211, 333, 123, 140, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (21, 1, N'A203', 6, 2, 167, 322, 44, 150, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (22, 1, N'A204', 5, 3, 131, 344, 65, 166, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (23, 1, N'A205', 4, 4, 143, 344, 44, 166, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (24, 1, N'A206', 3, 5, 122, 322, 89, 150, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (25, 1, N'A207', 3, 5, 167, 344, 97, 166, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (26, 1, N'A208', 5, 3, 131, 299, 44, 145, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (27, 1, N'A209', 4, 4, 122, 299, 65, 150, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (28, 1, N'A210', 3, 5, 143, 299, 44, 145, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (29, 1, N'A211', 4, 4, 167, 322, 97, 150, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (30, 1, N'A212', 4, 4, 122, 344, 65, 145, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (31, 1, N'A213', 4, 4, 143, 344, 89, 166, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (32, 1, N'A214', 7, 1, 122, 299, 97, 145, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (33, 1, N'A301', 2, 6, 143, 344, 97, 145, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (34, 1, N'A302', 5, 3, 143, 322, 89, 166, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (35, 1, N'A303', 4, 4, 167, 299, 97, 145, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (36, 1, N'A304', 1, 7, 131, 299, 97, 177, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (37, 1, N'A305', 3, 5, 131, 299, 89, 177, 0, 2, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (38, 1, N'A306', 5, 3, 143, 299, 97, 133, 0, 2, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (39, 1, N'A307', 2, 6, 131, 299, 65, 156, 0, 2, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (40, 1, N'A308', 2, 6, 122, 322, 89, 150, 1, 2, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (41, 1, N'A309', 0, 8, NULL, NULL, NULL, NULL, 1, 2, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (42, 1, N'A310', 0, 8, NULL, NULL, NULL, NULL, 1, 2, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (43, 1, N'A311', 0, 8, NULL, NULL, NULL, NULL, 1, 2, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (44, 1, N'A312', 0, 8, NULL, NULL, NULL, NULL, 1, 2, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (45, 1, N'A313', 0, 8, NULL, NULL, NULL, NULL, 1, 2, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (46, 1, N'A314', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (47, 1, N'A401', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (48, 1, N'A402', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (49, 1, N'A403', 0, 8, NULL, NULL, NULL, NULL, 0, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (50, 1, N'A404', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (51, 1, N'A405', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (52, 1, N'A406', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (53, 1, N'A407', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (54, 1, N'A408', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (55, 1, N'A409', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (56, 1, N'A410', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (57, 1, N'A411', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (58, 1, N'A412', 0, 8, NULL, NULL, NULL, NULL, 1, 0, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (59, 1, N'A413', 0, 8, NULL, NULL, NULL, NULL, 1, 2, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (60, 1, N'A414', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (61, 1, N'A501', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (62, 1, N'A502', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (63, 1, N'A503', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (64, 1, N'A504', 0, 8, NULL, NULL, NULL, NULL, 1, 0, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (65, 1, N'A505', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (66, 1, N'A506', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (67, 1, N'A507', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (68, 1, N'A508', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (69, 1, N'A509', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (70, 1, N'A510', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (71, 1, N'A511', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (72, 1, N'A512', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (73, 1, N'A513', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (74, 1, N'A514', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (75, 2, N'B101', 7, 1, 200, 200, 120, 120, 1, 2, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (76, 2, N'B102', 4, 4, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (77, 2, N'B103', 3, 5, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (78, 2, N'B104', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (79, 2, N'B105', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (80, 2, N'B106', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (81, 2, N'B107', 0, 8, NULL, NULL, NULL, NULL, 1, 2, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (82, 2, N'B108', 0, 8, NULL, NULL, NULL, NULL, 1, 2, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (83, 2, N'B109', 0, 8, NULL, NULL, NULL, NULL, 1, 0, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (84, 2, N'B110', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
INSERT [dbo].[Room] ([Room_ID], [Dom_ID], [Room_RoomNumber], [Room_NumberStudent], [Room_FreeSlot], [Room_ElectricityNumberLastSemester], [Room_ElectricityNumberThisSemester], [Room_WaterNumberLastSemester], [Room_WaterNumberThisSemester], [Room_PayStatus], [Room_Status], [Room_Type]) VALUES (87, 2, N'B111', 0, 8, NULL, NULL, NULL, NULL, 1, 1, NULL)
SET IDENTITY_INSERT [dbo].[Room] OFF
SET IDENTITY_INSERT [dbo].[Students] ON 

INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (1, 75, N'SE04455', N'Trần Mỹ Linh', N'linhtmse04455@fpt.edu.vn', N'0123666555', N'Hà Nội', 0, CAST(N'2017-08-22' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (11, 3, N'SE03435', N'Đinh Tuấn Anh', N'anhdtse03435@fpt.edu.vn', N'0973876107', N'Nghệ An', 1, CAST(N'2017-08-22' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (12, 3, N'SE04422', N'Minh Linh', N'linhmse04422@fpt.edu.vn', N'0165222356', N'HCM', 0, CAST(N'2018-04-15' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (13, 1, N'SE04456', N'Trần Minh Anh', N'anhtmse04456@fpt.edu.vn', N'0168963654', N'Thanh Hóa', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (14, 3, N'SE04457', N'Chu Anh', N'anhcse04457@fpt.edu.vn', N'0168963111', N'Thanh Hóa', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (15, 4, N'SE04454', N'Trương Nhật Lệ', N'letnse04454@fpt.edu.vn', N'0164257861', N'Hưng Yên', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (16, 1, N'SE03455', N'Hoàng Nhật Quang', N'quanghnse03455@fpt.edu.vn', N'0912342578', N'Hà Nội', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (17, 7, N'SE03456', N'Trịnh Đình Dũng', N'dungtdse03456@fpt.edu.vn', N'0923458127', N'Quảng Trị', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (18, 8, N'SE03457', N'Nguyễn Trinh', N'trinhnse03457@fpt.edu.vn', N'0945617285', N'Hải Dương', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (19, 12, N'SE03458', N'Nguyễn Thị Thảo', N'thaontse03458@fpt.edu.vn', N'0915423657', N'Huế', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (20, 13, N'SE03459', N'Hoàng Văn Lê', N'lehvse03459@fpt.edu.vn', N'0942587563', N'Hà Nội', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (21, 14, N'SE03460', N'Nguyễn Việt Hùng', N'hungnvse03460@fpt.edu.vn', N'0925741690', N'Hà Tây', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (22, 15, N'SE03461', N'Trương Duy Tân', N'tantdse03461@fpt.edu.vn', N'0925136478', N'Hưng Yên', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (23, 16, N'SE03462', N'Lê Văn Hà', N'halvse03462@fpt.edu.vn', N'0975124862', N'Hải Phòng', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (24, 17, N'SE03463', N'Trương Duy Mạnh', N'manhtdse03463@fpt.edu.vn', N'0942651270', N'Hà Giang', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (25, 18, N'SE03464', N'Nguyễn Anh Điệp', N'diepnase03464@fpt.edu.vn', N'0123457820', N'Hải Dương', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (26, 19, N'SE03465', N'Nguyễn Hậu', N'haunse03465@fpt.edu.vn', N'0167885249', N'Hải Phòng', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (27, 20, N'SE03466', N'Nguyễn Hậu', N'haunse03466@fpt.edu.vn', N'0931254710', N'Hà Nội', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (28, 4, N'SE03467', N'Phí Thị Giang', N'giangptse03467@fpt.edu.vn', N'0945781000', N'Hải Dương', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (29, 6, N'SE03468', N'Trịnh Phương Anh', N'anhtpse03468@fpt.edu.vn', N'0942157811', N'Huế', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (30, 7, N'SE03469', N'Đào Thị Giang', N'giangdtse03469@fpt.edu.vn', N'0941444520', N'Nghệ An', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (31, 8, N'SE03470', N'Trịnh Thị Mai', N'maittse03470@fpt.edu.vn', N'0912455542', N'Quảng Nam', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (32, 12, N'SE03471', N'Nguyễn Văn Toàn', N'toannvse03471@fpt.edu.vn', N'0913458242', N'Hà Giang', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (33, 13, N'SE03472', N'Trương Mạnh Quân', N'quantmse03472@fpt.edu.vn', N'0912451250', N'Hà Nội', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (34, 14, N'SE03473', N'Nguyễn Bích Phương', N'phuongnbse03473@fpt.edu.vn', N'0314522221', N'Nghệ An', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (35, 15, N'SE03474', N'Bùi Ánh Ngọc', N'ngocbase03474@fpt.edu.vn', N'0123452013', N'Hà Nam', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (36, 16, N'SE03475', N'Mai Thu Hà', N'hamtse03475@fpt.edu.vn', N'0942157820', N'Quảng Trị', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (37, 17, N'SE03476', N'Lê Văn Hậu', N'haulvse03476@fpt.edu.vn', N'0123000420', N'Huế', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (38, 18, N'SE03477', N'Lê Văn Hà', N'halvse03477@fpt.edu.vn', N'0364125555', N'Thanh Hóa', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (39, 19, N'SE03478', N'Đỗ Thu Trà', N'tradtse03478@fpt.edu.vn', N'0312457777', N'Sơn La', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (40, 20, N'SE03479', N'Vũ Văn Viên', N'vienvvse03479@fpt.edu.vn', N'0312422222', N'Hà Nội', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (41, 4, N'SE03480', N'Nguyễn Mạnh Đạt', N'datnmse03480@fpt.edu.vn', N'0911224557', N'Hà Giang', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (43, 7, N'SE03482', N'Vũ Thành Bôn', N'bonvtse03482@fpt.edu.vn', N'0911244457', N'Cao Bằng', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (44, 8, N'SE03483', N'Trịnh Văn Đại', N'daitvse03483@fpt.edu.vn', N'0999945820', N'Nam Định', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (45, 12, N'SE03484', N'Len Văn Hậu', N'haulvse03404@fpt.edu.vn', N'0314222475', N'Ninh Bình', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (46, 13, N'SE03485', N'Bùi Văn An', N'anbvse03485@fpt.edu.vn', N'0994555721', N'Hà Nội', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (47, 14, N'SE03486', N'Tạ Trung Hiếu', N'hieuttse03486@fpt.edu.vn', N'0932122458', N'Hải Phòng', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (48, 15, N'SE03487', N'Chu Quyết Tiến', N'tiencqse03487@fpt.edu.vn', N'0933644572', N'Hưng Yên', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (49, 16, N'SE03488', N'Bùi Quang Thiều', N'thieubqse03488@fpt.edu.vn', N'0911477523', N'Nam Định', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (50, 17, N'SE03489', N'Nguyễn Diệu Linh', N'linhndse03489@fpt.edu.vn', N'0912457534', N'Hà Nội', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (51, 18, N'SE03490', N'Nguyễn Gia Long', N'longngse03490@fpt.edu.vn', N'0312457575', N'Bắc Ninh', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (52, 19, N'SE03491', N'Đoàn Văn Dự', N'dudmse03491@fpt.edu.vn', N'0121224452', N'Quảng Nam', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (53, 20, N'SE03492', N'Nguyễn Kiều Diễm', N'diemnkse03492@fpt.edu.vn', N'0944755123', N'Hà Nội', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (54, 4, N'SE03493', N'Nguyễn Ánh Tuyết', N'tuyetnase03493@fpt.edu.vn', N'0996444475', N'Sơn Tây', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (55, 6, N'SB03494', N'Mai Thu Thủy', N'thuymtsb03494@fpt.edu.vn', N'0966648533', N'Lào Cai', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (56, 7, N'IA03495', N'Nguyễn Anh Dũng', N'dungnsia03495@fpt.edu.vn', N'0914557521', N'Hà Nội', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (57, 8, N'IA03496', N'Bùi Văn Hưng', N'hungbvia03496@fpt.edu.vn', N'0997878452', N'Hưng Yên', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (58, 12, N'SB03497', N'Phí Thị Trinh', N'trinhptsb03497@fpt.edu.vn', N'0912111552', N'Sơn Tây', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (59, 13, N'SE03498', N'Mai Gia Tú', N'tumgse03498@fpt.edu.vn', N'0944457788', N'Hà Giang', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (60, 14, N'SE03499', N'Hoàng Nhật Nam', N'namhnse03499@fpt.edu.vn', N'0942575783', N'Nam Định', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (61, 15, N'SE03500', N'Trần Văn Hậu', N'tranvhse03500@fpt.edu.vn', N'0912457638', N'Kiên Giang', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (62, 16, N'SE03501', N'Nguyễn Hậu', N'haunse0350@fpt.edu.vn', N'0966648833', N'Hòa Bình', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (63, 17, N'SE03502', N'Nguyễn Nhật Anh', N'anhnnse03502@fpt.edu.vn', N'0947884520', N'Hà Nam', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (64, 18, N'SE03503', N'Nguyễn Thị Nga', N'ngantse03503@fpt.edu.vn', N'0945778125', N'Hà Nội', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (65, 19, N'SE03504', N'Nguyễn Tuyết Trinh', N'trinhnt03504@fpt.edu.vn', N'0945785170', N'Nghệ An', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (66, 20, N'SE03505', N'Trương Ngọc Anh', N'anhtnse03505@fpt.edu.vn', N'0124754500', N'Nam Định', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (67, 4, N'SE03506', N'Nguyễn Hạnh', N'hanhnse03506@fpt.edu.vn', N'0912445752', N'Nghệ An', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (68, 6, N'SE03507', N'Nguyễn Thu Thảo', N'thaontse03507@fpt.edu.vn', N'0933641200', N'Nghệ An', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (69, 6, N'SE03508', N'Nguyễn Văn Hậu', N'haunvse03508@fpt.edu.vn', N'0964855820', N'Hà Giang', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (70, 6, N'SE03509', N'Hoàng Nhật Quang', N'quanghn03509@fpt.edu.vn', N'0945785120', N'Hà Nội', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (71, 77, N'SE03510', N'Nguyễn Anh Tú', N'tunase03510@fpt.edu.vn', N'0932000452', N'Thanh Hóa', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (72, 76, N'SE03511', N'Nguyễn Văn Hoàng', N'hoangnvse03511@fpt.edu.vn', N'0936488200', N'Hải Dương', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (73, 14, N'SE03512', N'Bùi Quang Hưng', N'hungbqse03512@fpt.edu.vn', N'0912420024', N'Sơn La', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (74, 12, N'SE03513', N'Nguyễn Quang Hưng', N'hungnqse03513@fpt.edu.vn', N'0933678801', N'Hà Nội', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (76, 18, N'SE03515', N'Nguyễn Ánh Tuyết', N'tuyetnase03515@fpt.edu.vn', N'0914475210', N'Hà Nội', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (77, 19, N'SE03516', N'Đào Thu Phương', N'phuongdtse03516@fpt.edu.vn', N'0922348004', N'Hà Nội', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (78, 19, N'SE03517', N'Đào Thị Bích Ngọc', N'ngọcdtbse03517@fpt.edu.vn', N'0985750044', N'Quảng Trị', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (79, 19, N'SE03518', N'Phùng Văn Bách', N'bachpvse03518@fpt.edu.vn', N'0822044204', N'Hà Nam', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (80, 16, N'SE03519', N'Cấn Việt Đoàn', N'doancvse03519@fpt.edu.vn', N'0912288888', N'Hà Nội', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (81, 77, N'SE03520', N'Trương Duy Nhân', N'nhantdse03520@fpt.edu.vn', N'0986630504', N'Đà Lạt', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (82, 75, N'SE03521', N'Nguyễn Công Thắng', N'thangncse03521@fpt.edu.vn', N'0980204582', N'Hà Nội', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (83, 75, N'SE03522', N'Nguyễn Hữu Trung', N'trungnhse03522@fpt.edu.vn', N'0985242020', N'Hải Dương', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (84, 75, N'SE03523', N'Phùng Mai Anh', N'anhpmse03523@fpt.edu.vn', N'0982422504', N'Quảng Trị', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (85, 76, N'SE03524', N'Nguyễn Việt An', N'annvse03524@fpt.edu.vn', N'0952250201', N'Nghệ An', 1, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (86, 76, N'SE03525', N'Hà Thị Mai', N'maihtse03525@fpt.edu.vn', N'0920157582', N'Nghệ An', 0, CAST(N'2017-08-20' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (93, 21, N'SB04475', N'Triệu Nhi', N'nhitsb04475@fpt.edu.vn', N'01787827425', N'Nghệ An', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (94, 23, N'SE04425', N'Trần Kiều Anh', N'anhtkse04479@fpt.edu.vn', N'01275725786', N'Hà Giang', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (95, 27, N'SE04421', N'Vũ Duy Xuân', N'xuanvdse04421@fpt.edu.vn', N'01677787482', N'Quảng Ninh', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (96, 21, N'SE04215', N'Kiều Hoàng Anh', N'anhkhse04215@fpt.edu.vn', N'0965773725', N'Hồ Chí Minh', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (97, 28, N'SB04122', N'Thiều Văn Minh', N'minhtvsb04122@fpt.edu.vn', N'0995752174', N'Sóc Trăng', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (98, 29, N'SE04572', N'Hoàng Minh Tiến', N'tientmse04572@fpt.edu.vn', N'01234526478', N'Nghệ An', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (99, 22, N'SB04378', N'Phan Văn Đoàn', N'doanpvsb04378@fpt.edu.vn', N'01238725148', N'Huế', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (100, 24, N'SE04288', N'Phan Thị Quỳnh', N'quynhptse04288@fpt.edu.vn', N'0965788721', N'Quảng Nam', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (101, 26, N'SB04721', N'Phùng Thị Ánh Nhi', N'nhiptasb04721@fpt.edu.vn', N'01275722186', N'Ninh Bình', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (102, 27, N'SE04352', N'Trần Thị Ánh Nguyệt', N'nguyetttase04352@fpt.edu.vn', N'01244653125', N'Hòa Bình', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (103, 25, N'SE04275', N'Ngô Văn Minh', N'minhnvse04275@fpt.edu.vn', N'01772725275', N'Hà Nội', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (104, 32, N'SE04311', N'Dinh Văn Ngọc', N'ngocdvse04311@fpt.edu.vn', N'01252723146', N'Lào Cai', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (105, 37, N'SE04401', N'Trần Quốc Huy', N'huytqse04401@fpt.edu.vn', N'01235567821', N'Ninh Thuận', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (106, 38, N'SB04405', N'Nguyễn Thị Thúy', N'thuytnsb04405@fpt.edu.vn', N'01786215782', N'Hải Phòng', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (107, 30, N'SB04408', N'Đỗ Duy Tân', N'tanddsb04408@fpt.edu.vn', N'01788215861', N'Đà Lạt', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (108, 32, N'SB04427', N'Lý Thị Trinh', N'trinhltsb04427@fpt.edu.vn', N'01677457777', N'Hải Phòng', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (109, 31, N'SE04482', N'Trần Thị Ly', N'lyttse04482@fpt.edu.vn', N'01655215178', N'Bắc Giang', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (110, 40, N'SE04491', N'Nguyễn Thị Huyền Trân', N'trannthse04491@fpt.edu.vn', N'01751217613', N'Đà Nẵng', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (111, 38, N'SE04722', N'Nguyễn Văn Dũng ', N'dungnvse04722@fpt.edu.vn', N'0112478214', N'Quảng Trị', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (112, 38, N'SE04872', N'Lương Văn Quyền', N'quyenlvse04872@fpt.edu.vn', N'0972754712', N'Quảng Bình', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (113, 29, N'SB04121', N'Ngô Quyền', N'quyennsb04121@fpt.edu.vn', N'0977762111', N'Ninh Thuận', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (114, 28, N'SE04444', N'Trần Thị Minh Anh', N'anhmttse04444@fpt.edu.vn', N'0978825114', N'Thanh Hóa', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (115, 39, N'SE04111', N'Tô Văn Hiền', N'hientvse04111@fpt.edu.vn', N'01271182188', N'Hà Tĩnh', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (116, 37, N'SE04421', N'Phan Ngọc Ánh Hiền', N'hienpnase04421@fpt.edu.vn', N'01182170311', N'Đà nẵng', 0, CAST(N'2017-08-21' AS Date))
GO
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (117, 21, N'SE04425', N'Lý Thị Minh Minh', N'minhltmse04425@fpt.edu.vn', N'01211182218', N'Ninh Bình', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (118, 35, N'SB04135', N'Trần hải Triều', N'trieuthsb04125@fpt.edu.vn', N'01114412214', N'Hải Phòng', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (119, 21, N'SB04411', N'Thiều Văn Quý', N'quytvsb04411@fpt.edu.vn', N'09771112314', N'Ninh Bình', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (120, 20, N'SE04221', N'Nhữ Thúy Hiền', N'hienntse04221@fpt.edu.vn', N'09821721152', N'Quảng Nam', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (121, 38, N'SE04417', N'Hồ Thị Linh', N'linhhtse04417@fpt.edu.vn', N'01222272211', N'Hà Nam', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (122, 27, N'SE04511', N'Vũ Hòa Hưng', N'hunghvse04451@fpt.edu.vn', N'01277721172', N'Nam Định', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (123, 32, N'SE04422', N'Ngô Văn Luyến', N'luyenvnse04422@fpt.edu.vn', N'01421115216', N'Hà Nam', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (124, 22, N'SB04778', N'Nhữ Thị Trinh', N'trinhntsb04778@fpt.edu.vn', N'01872241521', N'Ninh Thuận', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (125, 24, N'SB04127', N'Trương Văn Nam', N'truongvnsb04127@fpt.edu.vn', N'01972777421', N'Bến Tre', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (126, 31, N'SE04777', N'Triệu Văn Tý', N'tytvse04777@fpt.edu.vn', N'09724111234', N'Hồ Chí Minh', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (127, 32, N'SE04144', N'Lý Thị Quyên', N'quyenltse04144@fpt.edu.vn', N'09824445211', N'Nha Trang', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (128, 33, N'SE04221', N'Dương Quốc Đạt', N'datdqse04221@fpt.edu.vn', N'09888211472', N'Quy Nhơn', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (129, 34, N'SE04544', N'Dương Văn Quý', N'quydvse04544@fpt.edu.vn', N'0992142247', N'Đà Nẵng', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (130, 35, N'SE04479', N'Phan Thị Tú Uyên', N'uyenpttse04479@fpt.edu.vn', N'0965732480', N'Đà Nẵng', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (131, 36, N'SE04480', N'Lê Quốc Đạt', N'datlqse04480@fpt.edu.vn', N'09887744551', N'Hà Nội', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (132, 37, N'SE04481', N'Hoàng Thúy ', N'thuyhse04481@fpt.edu.vn', N'0992272142', N'Hải Phòng', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (133, 38, N'SE04482', N'Trần Thùy', N'thuytse04482@fpt.edu.vn', N'0915272421', N'Hà Nam', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (134, 39, N'SE04483', N'Trần Thúy Diệu', N'dieuttse04483@fpt.edu.vn', N'0971172271', N'Quảng Nam', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (135, 30, N'SE04484', N'Trần Hoàng Thùy', N'thuythse04484@fpt.edu.vn', N'01822224111', N'Quảng Ninh', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (136, 29, N'SE04485', N'Nhữ Thị Thùy Dung', N'dungnttse04485@fpt.edu.vn', N'01124421144', N'Quảng Ngãi', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (137, 28, N'SE04486', N'Trần Văn Trọng', N'trongtvse04486@fpt.edu.vn', N'01242235776', N'Hà Nam', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (138, 27, N'SE04487', N'Trần Kim Anh', N'anhtkse04487@fpt.edu.vn', N'01976542172', N'Đà Nẵng', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (139, 26, N'SE04488', N'Chu Thanh Hương', N'huongctse04488@fpt.edu.vn', N'09722457778', N'Bến Tre', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (140, 25, N'SE04489', N'Lý Thị Hương ', N'huongltse04489@fpt.edu.vn', N'09877452157', N'Đà Nẵng', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (141, 22, N'SE04117', N'Nguyễn Văn Minh', N'minhnvde04117@fpt.edu.vn', N'09120926703', N'Bình Phước', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (142, 4, N'SE04009', N'Lưu Minh Tú', N'tulmse04009@fpt.edu.vn', N'09982609722', N'Nam Định', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (144, 7, N'SE04001', N'Nguyễn Bá Kiên', N'kiennbse04001@fpt.edu.vn', N'09128128273', N'Cà Mau', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (145, 2, N'SE04035', N'Vũ Văn Ân', N'anvvse04035@fpt.edu.vn', N'09873918374', N'Quảng Ninh', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (146, 17, N'SE04089', N'Nguyễn Thịnh Cường', N'cuongntse04089@fpt.edu.vn', N'01672873249', N'Đà Lạt', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (147, 25, N'SE04382', N'Vũ Văn Cường', N'cuongvvse04382@fpt.edu.vn', N'09451893411', N'Bình Thuận', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (148, 13, N'SE04086', N'Đỗ Anh Tú', N'tudase04086@fpt.edu.vn', N'0913415151', N'Bến Tre', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (149, 35, N'SE04214', N'Cao Quốc Cường', N'cuongcqse04214@fpt.edu.vn', N'0958139841', N'Vĩnh Long', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (150, 34, N'SE04908', N'Tạ Quý', N'qtse040137@fpt.edu.vn', N'094871388186', N'Ninh Thuận', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (151, 32, N'SE04139', N'Nguyễn Văn Hiếu', N'hieunvse04139@fpt.edu.vn', N'0913412145', N'Thanh Hóa', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (152, 31, N'SE04091', N'Ngô Văn Đức', N'ducnvse04091@fpt.edu.vn', N'0932592421', N'Quảng Nam', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (153, 12, N'SE04184', N' Cao Đức Huy', N'huycdse04184@fpt.edu.vn', N'0942894242', N'Thanh Hóa', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (154, 4, N'SE04292', N'Bùi Quang huy', N'huybqse04292@fpt.edu.vn', N'0914971921', N'Đà Nẵng', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (156, 14, N'SE04110', N'Tạ Anh Minh', N'minhtaSE04110@fpt.edu.vn', N'0942974921', N'Phú Thọ', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (157, 8, N'SE04181', N'Nguyễn Vân Anh', N'anhnvSB04181@fpt.edu.vn', N'0983190312', N'Hà Nội', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (158, 32, N'SE04012', N'Nguyễn Bảo Ngọc', N'ngocnbse04001@fpt.edu.vn', N'09498310210', N'Ninh Thuận', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (159, 75, N'SE04031', N'Nguyễn Văn Viên', N'vienvse04031@fpt.edu.vn', N'09319901208', N'Quảng Ngãi', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (160, 34, N'SE04108', N'Đỗ Huyền Trang', N'trangdhse04108@fpt.edu.vn', N'0915915914', N'Huế', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (161, 23, N'SE04891', N'Đặng Phương thảo', N'thaodpse04891@fpt.edu.vn', N'0991795150', N'Quảng Ninh', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (162, 2, N'SB04814', N'Trần Thảo Mai', N'maittsb04814@fpt.edu.vn', N'0932974298', N'Huế', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (163, 31, N'SB04218', N'Trần Thanh Nga', N'ngattsb04218@fpt.edu.vn', N'0939739274', N'Quy Nhơn', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (164, 76, N'SE04315', N'Trần Huyền Anh', N'anhthse04315@fpt.edu.vn', N'0948178164', N'Huế', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (165, 23, N'SB04127', N'Đặng Quang Anh', N'anhdqse04453@fpt.edu.vn', N'09313641841', N'Quảng Ninh', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (166, 32, N'SE04917', N'Tăng Minh Đức', N'ductmse04917@fpt.edu.vn', N'03861468193', N'Thanh Hóa', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (167, 75, N'SB04531', N'Đỗ Huyền Anh', N'anhdhsb04531@fpt.edu.vn', N'09318481371', N'Hà Nội', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (168, 30, N'SE04652', N'Vũ Văn Dương', N'duongvvse04652@fpt.edu.vn', N'098173814316', N'Hà Nội', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (170, 30, N'SE04791', N'Dương Văn Minh', N'minhdvse04791@fpt.edu.vn', N'09386816334', N'Huế', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (171, 22, N'SE04971', N'Vũ Văn An', N'anvvse04971@fpt.edu.vn', N'09316491010', N'Thanh Hóa', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (172, 77, N'SE04998', N'Nguyễn Bình An', N'annbse04998@fpt.edu.vn', N'09135559917', N'Thanh Hóa', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (173, 26, N'SB04888', N'Ngô Thị Trang', N'trangntSB04888@fpt.edu.vn', N'092378264425', N'Huế', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (174, 34, N'SE04977', N'Ngô An Bình', N'binhnase04977@fpt.edu.vn', N'09317318645', N'Quản Nam', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (175, 23, N'SB04999', N'Nguyễn Vũ Vân', N'vannvsb04999@fpt.edu.vn', N'09274826385', N'Quảng Ninh', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (176, 75, N'SE04583', N'Vũ Việt Đức', N'ducvv04583@fpt.edu.vn', N'09146816481', N'Hà Nội', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (179, 1, N'SE04112', N'Nguyễn Thị My', N'myntse04112@fpt.edu.vn', N'01671485719', N'Thái nguyên', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (180, 13, N'SB04898', N'Đỗ Như Quỳnh', N'quynhdnsb04898@fpt.edu.vn', N'09284288429', N'Hà Nội ', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (181, 12, N'SE04333', N'Vũ Đức Hiếu', N'hieuvdse04333@fpt.edu.vn', N'09328742913', N'Hà Nội', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (182, 2, N'SE04444', N'Vũ Đức Việt', N'vietvdse04444@fpt.edu.vn', N'09175391941', N'Quảng ninh', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (183, 4, N'SE04821', N'Đỗ Đức Anh', N'anhddse04821@fpt.edu.vn', N'09579479991', N'Thái Nguyên', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (184, 6, N'SB04882', N'Nguyễn Thị Nhàn ', N'nhanntsb04882@fpt.edu.vn', N'09386382638', N'Vĩnh Long', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (185, 8, N'SE04888', N'Nguyễn Thị Hồng', N'hongntse04888@fpt.edu.vn', N'0926628321', N'Vinh', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (186, 13, N'SE04887', N'Nguyễn Thị Thơ', N'thonttse04887@fpt.edu.vn', N'09392793274', N'Hà Nội ', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (187, 20, N'SE04421', N'Lê Xuân Hòa', N'hoalxse04421@fpt.edu.vn', N'09386382684', N'Hà Nội', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (188, 21, N'SB04811', N'Nguyễn Vân Anh', N'anhnvsb04811@fpt.edu.vn', N'09382628638', N'Vinh', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (189, 13, N'SE04766', N'Đỗ Xuân Đức', N'ducdxse04766@fpt.edu.vn', N'09827167277', N'Hà Nội', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (190, 40, N'SB04004', N'Nguyễn Thị Ngọc', N'ngocntsb04004@fpt.edu.vn', N'09828169102', N'Đà Nẵng', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (191, 22, N'SE04008', N'Vũ Đức Phúc', N'phucvdse04222@fpt.edu.vn', N'093278268290', N'Thanh Hóa', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (193, 34, N'SB04888', N'Nguyễn Ngọc Vân', N'vannnsb04888@fpt.edu.vn', N'01673157131', N'Hà Nội', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (194, 2, N'SE04000', N'Đỗ Anh Quang', N'quangdase04000@fpt.edu.vn', N'012368361301', N'Đà Nẵng', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (196, 17, N'SB04999', N'Nguyễn Quang Anh', N'anhnqse04999@fpt.edu.vn', N'09739239274', N'Vĩnh Long', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (197, 16, N'SB04289', N'Nguyễn Thị Hà', N'hantsb04289@fpt.edu.vn', N'092927382748', N'Hà Nội', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (198, 19, N'SE04767', N'Vũ Quang ANh', N'anhvqse04767@fpt.edu.vn', N'09327428682', N'Huế', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (199, 20, N'SE04997', N'Nguyễn Văn Linh', N'Linhnvse04997@fpt.edu.vn', N'01236013831', N'Quảng Ninh', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (200, 21, N'SB04006', N'Phùng Mỹ Linh', N'LinhpmSB04006@fpt.edu.vn', N'09362637247', N'Hà Nội', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (201, 17, N'SE04555', N'Vũ Việt Đức', N'ducvvse04555@fpt.edu.vn', N'09328648233', N'Quảng Ngãi', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (202, 24, N'SB04667', N'Nguyễn Đức Nguyện', N'nguyenndsb04667@fpt.edu.vn', N'091387173194', N'Hà Nội', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (203, 26, N'SE04557', N'Nguyễn Viết Việt', N'Vietnvse04557@fpt.edu.vn', N'09167374119', N'Vĩnh Phúc', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (204, 29, N'SB04774', N'Bùi Văn Ân', N'anbvse04774@fpt.edu.vn', N'09328482746', N'Hà Nội ', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (205, 26, N'SB04731', N'Nguyễn Vũ Hoa', N'hoanvsb04731@fpt.edu.vn', N'01673184011', N'Huế', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (207, 33, N'SE04871', N'Nguyễn Văn Đông', N'dongnvse04871@fpt.edu.vn', N'09328284295', N'Hà Nội', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (208, 35, N'SB04999', N'Trịnh Văn Đức ', N'ductvsb04999@fpt.edu.vn', N'09327482482', N'Huế', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (209, 14, N'SE04879', N'Nguyễn Võ Minh', N'minhnvse04879@fpt.edu.vn', N'01673284826', N'Hà Nội', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (210, 15, N'SB04478', N'Đỗ Văn Anh', N'anhdvsb04478@fpt.edu.vn', N'093186481618', N'Vĩnh Long', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (211, 1, N'SE04739', N'Nguyễn Đức Nhật', N'nhatndse04739@fpt.edu.vn', N'016473913001', N'Hà Nội', 1, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (214, 15, N'SE04044', N'Vũ Giáng My', N'Myvgse04044@fpt.edu.vn', N'09138618490', N'Đà Nẵng', 0, CAST(N'2017-08-21' AS Date))
INSERT [dbo].[Students] ([Student_ID], [Room_ID], [Student_RollNumber], [Student_FullName], [Student_Email], [Student_Mobile], [Student_Address], [Student_Gender], [Student_StartDate]) VALUES (215, 17, N'SE04867', N'Đỗ Vũ Vinh', N'vinhdvse04867@fpt.edu.vn', N'09387491331', N'Quảng Ngãi', 1, CAST(N'2017-08-21' AS Date))
SET IDENTITY_INSERT [dbo].[Students] OFF
SET IDENTITY_INSERT [dbo].[TransferRoom] ON 

INSERT [dbo].[TransferRoom] ([TransferRoom_ID], [Student_ID], [Room_ID], [TransferRoom_Status]) VALUES (15, 12, 3, 1)
SET IDENTITY_INSERT [dbo].[TransferRoom] OFF
ALTER TABLE [dbo].[Account] ADD  CONSTRAINT [DF_Account_Account_Created]  DEFAULT (getdate()) FOR [Account_Created]
GO
ALTER TABLE [dbo].[Students] ADD  CONSTRAINT [DF_Students_Student_StartDate]  DEFAULT (getdate()) FOR [Student_StartDate]
GO
ALTER TABLE [dbo].[Room]  WITH CHECK ADD  CONSTRAINT [FK_Room_Dom] FOREIGN KEY([Dom_ID])
REFERENCES [dbo].[Dom] ([Dom_ID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Room] CHECK CONSTRAINT [FK_Room_Dom]
GO
ALTER TABLE [dbo].[Students]  WITH CHECK ADD  CONSTRAINT [FK_Students_Room] FOREIGN KEY([Room_ID])
REFERENCES [dbo].[Room] ([Room_ID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Students] CHECK CONSTRAINT [FK_Students_Room]
GO
/****** Object:  Trigger [dbo].[updateElectricityNumberThisSemester]    Script Date: 5/26/2018 7:32:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[updateElectricityNumberThisSemester]
ON [dbo].[Room]
FOR UPDATE 
AS 
IF UPDATE(Room_ElectricityNumberThisSemester)
BEGIN   
    DECLARE @roomId int = (SELECT Room_ID FROM INSERTED)
	DECLARE @electricityNumber int = (SELECT Room_ElectricityNumberThisSemester FROM DELETED) 
    UPDATE Room SET Room_ElectricityNumberLastSemester = @electricityNumber WHERE Room_ID=@roomId   
END
GO
ALTER TABLE [dbo].[Room] ENABLE TRIGGER [updateElectricityNumberThisSemester]
GO
/****** Object:  Trigger [dbo].[updateWaterNumberThisSemester]    Script Date: 5/26/2018 7:32:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[updateWaterNumberThisSemester]
ON [dbo].[Room]
FOR UPDATE 
AS 
IF UPDATE(Room_WaterNumberThisSemester)
BEGIN   
    DECLARE @roomId int = (SELECT Room_ID FROM INSERTED)
	DECLARE @waterNumber int = (SELECT Room_WaterNumberThisSemester FROM DELETED) 
    UPDATE Room SET Room_WaterNumberLastSemester = @waterNumber WHERE Room_ID=@roomId   
END
GO
ALTER TABLE [dbo].[Room] ENABLE TRIGGER [updateWaterNumberThisSemester]
GO
/****** Object:  Trigger [dbo].[deleteNumberStudents]    Script Date: 5/26/2018 7:32:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[deleteNumberStudents]
ON [dbo].[Students]
FOR DELETE 
AS 
BEGIN 
	DECLARE @roomIdOld int = (SELECT Room_ID FROM DELETED)  
	DECLARE @countOld int = (SELECT COUNT(Room_ID) FROM Students WHERE Room_ID = @roomIdOld)    
    UPDATE Room SET Room_NumberStudent = @countOld, Room_FreeSlot = (8-@countOld) WHERE Room_ID=@roomIdOld  
END
GO
ALTER TABLE [dbo].[Students] ENABLE TRIGGER [deleteNumberStudents]
GO
/****** Object:  Trigger [dbo].[insertNumberStudents]    Script Date: 5/26/2018 7:32:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[insertNumberStudents] 
ON [dbo].[Students] 
FOR INSERT 
AS 
BEGIN  	  
    DECLARE @roomId int = (SELECT Room_ID FROM INSERTED)
	DECLARE @count int = (SELECT COUNT(Room_ID) FROM Students WHERE Room_ID = @roomId)  
	DECLARE @studentId int = (SELECT Student_ID FROM INSERTED)   
    UPDATE Room SET Room_NumberStudent = @count, Room_FreeSlot = (8-@count) WHERE Room_ID=@roomId  
	UPDATE Students SET Student_StartDate = getdate() WHERE Student_ID=@studentId  
END
GO
ALTER TABLE [dbo].[Students] ENABLE TRIGGER [insertNumberStudents]
GO
/****** Object:  Trigger [dbo].[updateNumberStudents]    Script Date: 5/26/2018 7:32:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[updateNumberStudents] 
ON [dbo].[Students] 
FOR UPDATE 
AS 
IF UPDATE(Room_ID)
BEGIN 
	DECLARE @roomIdOld int = (SELECT Room_ID FROM DELETED)  
	DECLARE @countOld int = (SELECT COUNT(Room_ID) FROM Students WHERE Room_ID = @roomIdOld)    
    UPDATE Room SET Room_NumberStudent = @countOld, Room_FreeSlot = (8-@countOld) WHERE Room_ID=@roomIdOld  
	  
    DECLARE @roomId int = (SELECT Room_ID FROM INSERTED)
	DECLARE @count int = (SELECT COUNT(Room_ID) FROM Students WHERE Room_ID = @roomId) 
	DECLARE @studentId int = (SELECT Student_ID FROM INSERTED) 
    UPDATE Room SET Room_NumberStudent = @count, Room_FreeSlot = (8-@count) WHERE Room_ID=@roomId  
	UPDATE Students SET Student_StartDate = getdate() WHERE Student_ID=@studentId  
END
GO
ALTER TABLE [dbo].[Students] ENABLE TRIGGER [updateNumberStudents]
GO
