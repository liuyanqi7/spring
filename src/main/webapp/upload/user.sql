CREATE TABLE ShopUser
(
   uid                  INT NOT NULL,
   uname                VARCHAR(10),
   upass                VARCHAR(20),
   usex                 VARCHAR(5),
   uaddress             VARCHAR(50),
   birthday             TIMESTAMP,
   PRIMARY KEY (uid)
);
/*字段说明 uid 用户id*/
/*==============================================================*/
/* Table: board     字段说明     bid 板块id bname 板块name                                        */
/*==============================================================*/
CREATE TABLE board
(
   bid                  INT NOT NULL,
   bname                VARCHAR(50),
   PRIMARY KEY (bid)
);

/*==============================================================*/
/* Table: "order"        订单 外键uid 链接用户id                                        */
/*==============================================================*/
CREATE TABLE orders
(
   oid                  INT NOT NULL,
   uid                  INT,
   money                INT,
   TIME                 DATE,
   PRIMARY KEY (oid)
);

/*==============================================================*/
/* Table: orderbuy         订单下  uid链接用户表 oid链接订单表 sid链接shopimfor商品    数量和 价钱都是商品的                                */
/*==============================================================*/
CREATE TABLE orderbuy
(
   uid                  INT,
   oid                  INT,
   sid                  INT,
   obid                 INT,
   obnumber             INT,
   obmoney              FLOAT,
    PRIMARY KEY (obid)
);

/*==============================================================*/
/* Table: shopimfor                bid链接板块                             */
/*==============================================================*/
CREATE TABLE shopimfor
(
   sid                  INT NOT NULL,
   bid                  INT,
   sname                LONGTEXT,
   smoney               FLOAT,
   PRIMARY KEY (sid)
);

/*==============================================================*/
/* Table: shopnews                                              */
/*==============================================================*/
CREATE TABLE shopnews
(
   nid                  INT NOT NULL,
   ntitle               VARCHAR(20),
   ncontext             LONGTEXT,
   PRIMARY KEY (nid)
);
orderbuy

ALTER TABLE orders ADD CONSTRAINT FK_Relationship_2 FOREIGN KEY (uid)
      REFERENCES ShopUser (uid) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE orderbuy ADD CONSTRAINT FK_Relationship_3 FOREIGN KEY (uid)
      REFERENCES ShopUser (uid) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE orderbuy ADD CONSTRAINT FK_Relationship_4 FOREIGN KEY (oid)
      REFERENCES orders (oid) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE orderbuy ADD CONSTRAINT FK_Relationship_5 FOREIGN KEY (sid)
      REFERENCES shopimfor (sid) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE shopimfor ADD CONSTRAINT FK_Relationship_1 FOREIGN KEY (bid)
      REFERENCES board (bid) ON DELETE RESTRICT ON UPDATE RESTRICT;