/*
 Navicat Premium Data Transfer

 Source Server         : 194.0.19.247
 Source Server Type    : SQL Server
 Source Server Version : 14003465
 Source Host           : 194.0.19.247:1433
 Source Catalog        : demo_news
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 14003465
 File Encoding         : 65001

 Date: 24/01/2024 16:24:31
*/


-- ----------------------------
-- Table structure for news
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[news]') AND type IN ('U'))
	DROP TABLE [dbo].[news]
GO

CREATE TABLE [dbo].[news] (
  [id] bigint  IDENTITY(1,1) NOT NULL,
  [title] varchar(256) COLLATE Chinese_PRC_CI_AS  NULL,
  [news_content] varchar(4096) COLLATE Chinese_PRC_CI_AS  NULL,
  [publisher] varchar(64) COLLATE Chinese_PRC_CI_AS  NULL,
  [gmt_create] datetime DEFAULT (getdate()) NULL,
  [gmt_modify] datetime  NULL
)
GO

ALTER TABLE [dbo].[news] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of news
-- ----------------------------
SET IDENTITY_INSERT [dbo].[news] ON
GO

INSERT INTO [dbo].[news] ([id], [title], [news_content], [publisher], [gmt_create], [gmt_modify]) VALUES (N'1', N'我是标题', N'我是内容', N'我是发布者', N'2022-11-29 00:00:00.000', NULL)
GO

INSERT INTO [dbo].[news] ([id], [title], [news_content], [publisher], [gmt_create], [gmt_modify]) VALUES (N'2', N'SqlServer数据库中文乱码问题解决方法', N'排序规则的后半部份即后缀 含义：
　　_BIN 二进制排序
　　_CI(CS) 是否区分大小写，CI不区分，CS区分
　　_AI(AS) 是否区分重音，AI不区分，AS区分　　　
　　_KI(KS) 是否区分假名类型,KI不区分，KS区分　
_WI(WS) 是否区分宽度WI不区分，WS区分　
区分大小写:如果想让比较将大写字母和小写字母视为不等，请选择该选项。
区分重音:如果想让重音和非重音字母视为不等，请选择该选项。如果选择该选项，
比较还将重音不同的字母视为不等。
区分假名:如果想让比较将片假名和平假名日语音节视为不等，请选择该选项。
区分宽度:如果想让比较将半角字符和全角字符视为不等，请选择该选项

sqlserver 建库指定utf-8 修改库为utf-8编码

CREATE DATABASE paas COLLATE Chinese_PRC_CI_AS
GO
ALTER DATABASE paas COLLATE Chinese_PRC_CI_AS
GO

让ASP和MS SQL SERVER支持UTF-8编码存储多国语言文字

近日在ASP+MS SQL存储UTF-8编码内容的时候，出现乱码的情况，经过查询发现要使SQL SERVER支持UTF-8编码格式，必须做一些修改才可以。', N'张三', NULL, NULL)
GO

INSERT INTO [dbo].[news] ([id], [title], [news_content], [publisher], [gmt_create], [gmt_modify]) VALUES (N'3', N'DBUtils - 快速指南', N'Apache Commons DBUtils - Overview

Apache Commons DbUtils库是一个非常小的类集，旨在简化JDBC调用处理而不会造成资源泄漏，并且代码更清晰。 由于JDBC资源清理非常繁琐且容易出错，因此DBUtils类有助于抽象出锅炉板代码，以便开发人员只关注与数据库相关的操作。
使用DBUtils的优点

    No Resource Leakage - DBUtils类确保不会发生资源泄漏。

    Clean & Clear code - DBUtils类提供干净，清晰的代码来执行数据库操作，而无需编写任何清理或资源泄漏防护代码。

    Bean Mapping - DBUtils类支持从结果集自动填充javabeans。 

DBUtils设计原则

    Small - DBUtils库的大小非常小，类较少，因此易于理解和使用。

    Transparent - DBUtils库在幕后工作量不大。 它只需要查询和执行。

    Fast - DBUtils库类不会创建许多后台对象，并且在数据库操作执行方面非常快。 ', N'李四', N'2022-11-29 09:58:02.000', NULL)
GO

INSERT INTO [dbo].[news] ([id], [title], [news_content], [publisher], [gmt_create], [gmt_modify]) VALUES (N'4', N'世上只有一种英雄主义，就是在认清生活真相之后依然热爱生活', N'“世上只有一种英雄主义，就是认清生活的真相之后依然热爱生活。”

很多人都曾被这句话鼓舞过，特别是在长大之后，我们慢慢发现“生活的真相”其实就是，总会有这样那样的“坏事”发生，但还是得咬紧牙关迎难而上。

一路披荆斩棘、披星戴月，虽然辛苦，但却在这个过程里变得更加勇敢和坚强。', N'拉拉', N'2022-11-29 10:00:43.000', N'2024-01-24 15:35:19.463')
GO

INSERT INTO [dbo].[news] ([id], [title], [news_content], [publisher], [gmt_create], [gmt_modify]) VALUES (N'5', N'关于七天定理', N'我养了一缸鱼，每个星期天我会给他们喂高蛋白的丰年虾，加快他们的生长。有一天，其中一只很聪明的鱼，这里就管科学家鱼吧，他发现了一个规律：这个环境每隔七天就有非常好的食物降临。于是在一次食物降临后，它预测七个日夜之后会有另外一次，并告诉所有其他的鱼。结果它的预言成真了！所有的鱼都非常高兴他们认识了这个规律。经过好几个星期，他们都观察到了这个现象，给予发现这个现象的科学家鱼以崇高的敬意，并把它定义为“七天定理”，是这个环境最重要的定理之一。

我听到鱼群们关于七天定理的交谈。

我笑了。', N'soso', N'2022-11-29 10:01:59.000', NULL)
GO

INSERT INTO [dbo].[news] ([id], [title], [news_content], [publisher], [gmt_create], [gmt_modify]) VALUES (N'6', N'如何做到少混日子', N'混日子，是一件再容易不过的事。
我们很容易在不知不觉中把时间给浪费了。
只有少数人，能够较为高效地活着，收获颇丰。
怎样才能做到少混日子、多有产出呢？
有一点非常重要，那就是加大你的反省密度。
如果你能在一天之内多反省几次，就可以及时调整自己的行为和状态，让自己迅速改进。
一旦养成了勤反省的习惯，你会活得更认真，进步更快。
当然，一开始你可能很容易会忘记“要反省”这件事，怎么办呢？', N'haha', N'2022-11-29 10:02:39.000', NULL)
GO

INSERT INTO [dbo].[news] ([id], [title], [news_content], [publisher], [gmt_create], [gmt_modify]) VALUES (N'7', N'电车难题', N'它是伦理学领域最为知名的思想实验之一，内容大致是：一个疯子把五个无辜的人绑在电车轨道上，一辆失控的电车朝他们驶来，且马上就要辗过他们。幸运的是，你可以拉一个拉杆，让电车开到另一条轨道上。但是还有一个问题，那个疯子在那另一条轨道上也绑了一个人。想想这个情况，你应该拉拉杆吗？', N'123', N'2022-11-29 10:05:54.000', NULL)
GO

INSERT INTO [dbo].[news] ([id], [title], [news_content], [publisher], [gmt_create], [gmt_modify]) VALUES (N'8', N'空地上的奶牛', N'认知领域中一个重要的思想实验就是“空地上的奶牛”。实验是这样的，一个农民担心自己获奖的奶牛走丢了。一个送奶工来到农场后，他让农民不要担心，因为他看到那头奶牛就在附近。虽然农民很愿意相信送奶工，但他还是自己去看了下，他看到了熟悉的黑白相间条纹，为自己的奶牛在那里感到很满意。过了一会，送奶工到那里再次进行了确认。那头奶牛确实在那里，但它躲在了树林里，而且有一大张黑白相间的纸缠绕在了一棵树上，显然，农民把这张纸错当成自己的奶牛了。问题于是来了， 就算奶牛一直在那里，但农民说自己知道那头奶牛在那里时是否正确？', N'123', N'2022-11-29 10:06:33.000', NULL)
GO

INSERT INTO [dbo].[news] ([id], [title], [news_content], [publisher], [gmt_create], [gmt_modify]) VALUES (N'9', N'定时炸弹', N'如果你关注近几年的政治时事，或看过动作电影，那么你对“定时炸弹”实验肯定很熟悉。它要求你想象有一个炸弹或其他大规模杀伤性武器藏在你的城市中，并且倒计时马上将归零。城市里有一个知情者，他知道炸弹的埋藏点。你会使用酷刑来让他吐出情报吗？', N'123', N'2022-11-29 10:07:07.000', NULL)
GO

INSERT INTO [dbo].[news] ([id], [title], [news_content], [publisher], [gmt_create], [gmt_modify]) VALUES (N'10', N'爱因斯坦的光线', N'很少有人知道爱因斯坦著名的狭义相对论是受到他16岁时一个思想实验的启发。在他的著作《自述注记》中，爱因斯坦回忆道他当时幻想在宇宙中追逐一道光线。他说如果他能够以光速在光线旁边运动，那么他应该能够看到光线在空间内呈现为“不断振荡但停滞着的电磁场”。对于爱因斯坦，这个思想实验证明了对于他作为一个富有想象力的观察者，”在有相同定律和一个相对于地球静止观察者的情况下，任何事都有可能发生。”', N'123', N'2022-11-29 10:07:50.000', NULL)
GO

INSERT INTO [dbo].[news] ([id], [title], [news_content], [publisher], [gmt_create], [gmt_modify]) VALUES (N'11', N'特修斯之船', N'史上最为古老的思想实验之一便是被称为忒修斯之船的悖论。这个实验最早出自普鲁塔克的记载。它描述了一艘可以在海上航行几百年的船，这归功于不断的维修和部件的替换。只要一块木板腐烂了，它就会被替换掉，以此类推，直到所有的部件都不再是最初的那些。问题是，最终产生的这艘船还是原来的忒修斯之船，还是一艘完全不同的新船？如果不是原来的船了，那么从什么时候开始它不再是原来的船了？哲学家Thomas Hobbes后来对此进行了更深刻的探讨：如果有人用忒修斯之船上取下来的老部件来重新建造一艘新的船，那么两艘船中哪艘才是真正的忒修斯之船？', N'123', N'2022-11-29 10:08:10.000', NULL)
GO

INSERT INTO [dbo].[news] ([id], [title], [news_content], [publisher], [gmt_create], [gmt_modify]) VALUES (N'12', N'伽利略的重力实验', N'史上最早的思想实验之一，由物理和天文学家伽利略进行实验。为了反驳亚里士多德的自由落体速度取决于物体质量的理论，伽利略设计了一个简单的思想实验：根据亚里士多德的逻辑，如果一个较轻的物体和一个较重的物体绑在一起后从塔上扔下去，那么教重的物体会下落的比较快，且两个物体间的绳子会被拉紧。这时较轻的物体会对较重的物体产生一个拽力，使得重物的下落速度变慢。但是，伽利略认为两个物体绑在一起后的重量应比其中任意一个物体都大，那么一起下落的速度应该是最快的。于是他用这个矛盾证明了亚里士多德理论是错误的。', N'伽利略', N'2022-11-29 10:08:38.000', N'2024-01-24 15:33:48.060')
GO

INSERT INTO [dbo].[news] ([id], [title], [news_content], [publisher], [gmt_create], [gmt_modify]) VALUES (N'30', N'柏拉图的洞穴寓言', N'柏拉图的洞穴寓言是他在《理想国》一书中提出的一个哲学思想实验。在这个实验中，柏拉图让我们想象一个场景：一群从小被锁在一个地下洞穴里的人，他们的四肢和脖子都被束缚，只能看到洞穴墙壁上的影子。这些影子是由洞穴背后的火光投射的，火光将洞穴外的事物映射到洞壁上。由于这些人从出生起就只能看到这些影子，他们把这些影子当作是真实的世界。

柏拉图接着描述了这样一个情景：假如有一个囚犯被释放了，他第一次走出洞穴，看到了真实的世界。一开始，他会被强烈的光线刺痛眼睛，无法看清真实的事物。但随着时间的推移，他的眼睛逐渐适应了光线，开始认识到影子背后的真实世界。这个囚犯认识到，他以前所认为的真实世界其实只是影子的世界，而非真实的世界。

最后，这个囚犯回到洞穴，试图向其他囚犯解释他所看到的真实世界。然而，那些仍然被束缚在洞穴里的人无法理解他的话，反而认为他疯了。

柏拉图的洞穴寓言试图说明，我们对现实世界的认识是有限的，我们所看到的世界可能只是真实世界的一种映射。这个思想实验鼓励人们去质疑现有的知识和观念，追求更高的真理和智慧。同时，它也提醒我们，当我们试图向他人传授我们所学到的新知识时，可能会遇到难以克服的障碍。', N'哈哈', N'2024-01-24 15:34:40.060', N'2024-01-24 15:39:00.497')
GO

SET IDENTITY_INSERT [dbo].[news] OFF
GO


-- ----------------------------
-- Primary Key structure for table news
-- ----------------------------
ALTER TABLE [dbo].[news] ADD CONSTRAINT [PK_news] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

