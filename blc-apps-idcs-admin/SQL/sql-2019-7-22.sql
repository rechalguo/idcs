--验证类型
create table IC_CONF_CKTYPE
(
  ck_id   VARCHAR2(2) not null,
  ck_name VARCHAR2(100) not null
);
-- Add comments to the table 
comment on table IC_CONF_CKTYPE
  is '验证用户方式';
-- Add comments to the columns 
comment on column IC_CONF_CKTYPE.ck_id
  is 'id';
comment on column IC_CONF_CKTYPE.ck_name
  is '名称';
alter table IC_CONF_CKTYPE
  add constraint PK_CK_ID primary key (CK_ID);

--初始化数据
INSERT INTO IC_CONF_CKTYPE (CK_ID, CK_NAME) VALUES ('1', 'IDNAME');
INSERT INTO IC_CONF_CKTYPE (CK_ID, CK_NAME) VALUES ('2', 'IDNAME+CBE');
INSERT INTO IC_CONF_CKTYPE (CK_ID, CK_NAME) VALUES ('3', 'IDNAME+CBE+BILLNO');
INSERT INTO IC_CONF_CKTYPE (CK_ID, CK_NAME) VALUES ('4', 'IDNAME+CBE+BILL');
COMMIT;  

--在相关表添加外键
alter table IC_USER
  add constraint FK_CKTYPE foreign key (U_TYPE)
  references IC_CONF_CKTYPE (CK_ID)
  
  
-- Create table 调用模式
create table IC_CONF_REQTYPE
(
  r_id   varchar2(1) not null,
  r_name varchar2(100) not null
)
;
alter table IC_CONF_REQTYPE
  add constraint PK_RID primary key (R_ID);
-- Add comments to the table 
comment on table IC_CONF_REQTYPE
  is '请求类型配置表';
-- Add comments to the columns 
comment on column IC_CONF_REQTYPE.r_id
  is 'ID';
comment on column IC_CONF_REQTYPE.r_name
  is '1.直调 2.混调';
  
--初始化数据
INSERT INTO IC_CONF_REQTYPE(R_ID, R_NAME) VALUES ('1', '直调');
INSERT INTO IC_CONF_REQTYPE(R_ID, R_NAME) VALUES ('2', '混调');
COMMIT;

--在相关表添加外键
alter table IC_USER
  add constraint FK_REQ_T foreign key (REQ_TYPE)
  references IC_CONF_REQTYPE (R_ID);
  
  
--机构
ALTER TABLE IC_COMPANY ADD (CREATE_TIME DATE);
ALTER TABLE IC_COMPANY ADD (ACTIVED VARCHAR2(3));
COMMENT ON COLUMN IC_COMPANY.CREATE_TIME IS '注册时间';
COMMENT ON COLUMN IC_COMPANY.actived IS '是否可用，可选值 OFF/ON';

--sequence
CREATE SEQUENCE SEQ_IDCS
START WITH 4
INCREMENT BY 1
MINVALUE 1 MAXVALUE 99999999999
NOCYCLE CACHE 10;


--汇总数据表
create table IC_INFO_UP
(
  report_date VARCHAR2(7) not null,
  user_id     VARCHAR2(50) not null,
  user_name   VARCHAR2(50),
  data_src    VARCHAR2(50) not null,
  r_name      VARCHAR2(100),
  cnt         NUMBER default 0 not null
);
-- Add comments to the table 
comment on table IC_INFO_UP
  is '接口调用汇总信息';
-- Add comments to the columns 
comment on column IC_INFO_UP.report_date
  is '月份';
comment on column IC_INFO_UP.user_id
  is '用户';
comment on column IC_INFO_UP.user_name
  is '用户名';
comment on column IC_INFO_UP.data_src
  is '数据源（接口id）';
comment on column IC_INFO_UP.r_name
  is '数据源名字';
comment on column IC_INFO_UP.cnt
  is '调用量';
-- Create/Recreate indexes 
create index IDX_IF_UP on IC_INFO_UP (REPORT_DATE);