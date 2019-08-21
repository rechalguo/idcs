/**
1. 查看表空间
	select b.file_name 物理文件名,b.tablespace_name 表空间,b.bytes/1024/1024 大小M,(b.bytes-sum(nvl(a.bytes,0)))/1024/1024 已使用M,substr((b.bytes-sum(nvl(a.bytes,0)))/(b.bytes)*100,1,5) 利用率 from dba_free_space a,dba_data_files b where a.file_id=b.file_id group by b.tablespace_name,b.file_name,b.bytes order by b.tablespace_name  
2. 添加新的表空间
	CREATE TABLESPACE IDCS DATAFILE '/data/orabase/oradata/ndmwms/idcs_data001.dbf' size 4096M EXTENT MANAGEMENT local;
	
	扩展表空间
	alter tablespace IDCS add datafile '/data/orabase/oradata/ndmwms/idcs_data001.dbf' size 1024M autoextend on next 256m maxsize 10240m ;
	
3. 新建用户
	create user idcs identified by idcs_0417 default tablespace IDCS temporary tablespace temp ACCOUNT UNLOCK;
	注意用户密码过期情况
4. 权限
	 grant connect,resource to idcs;


select  convert(utl_raw.cast_to_varchar2(utl_encode.base64_decode(utl_raw.cast_to_raw(t.seq_no))),'ZHS16GBK','UTF8') from IC_CACHE t where t.seq_no = 'NDExMTIyMTk4MjAyMTM0MDEzOuWPsuiAgOWzsA=='
**/

-- 用户机构表
create table IC_COMPANY
(
  org_id   VARCHAR2(100) not null,
  org_name VARCHAR2(255) not null
);
-- Add comments to the columns 
comment on column IC_COMPANY.org_id
  is '用户的公司ID';
comment on column IC_COMPANY.org_name
  is '用户公司名称';
-- Create/Recreate primary, unique and foreign key constraints 
alter table IC_COMPANY
  add constraint PK_IC_COMID primary key (ORG_ID);

  
-- 用户表
create table IC_USER
(
  user_id         VARCHAR2(50) not null,
  user_name       VARCHAR2(50) not null,
  u_type          VARCHAR2(2) not null,
  u_password      VARCHAR2(50) not null,
  expired_date    DATE not null,
  create_date     DATE not null,
  private_key     CLOB,
  public_key      CLOB not null,
  pay_type        VARCHAR2(1),
  req_type        VARCHAR2(1) default 2 not null,
  private_key_api CLOB not null,
  public_key_api  CLOB,
  org_id          VARCHAR2(100) not null
);
-- Add comments to the table 
comment on table IC_USER
  is '数户表';
-- Add comments to the columns 
comment on column IC_USER.u_type
  is '1用户只提供身份证信息  2用户:验证电商代码 3用户:验证电商代码单号  4用户:验证电商代码单号单据';
comment on column IC_USER.public_key
  is '用户公钥，用来加密响应报文';
comment on column IC_USER.pay_type
  is '1预支付  2后支付  3免支付';
comment on column IC_USER.req_type
  is '1直调realtime 2混合调用 mixed';
comment on column IC_USER.private_key_api
  is '平台密钥，用来加签响应报文';
comment on column IC_USER.org_id
  is '账户公司配置表中的ID';
-- Create/Recreate primary, unique and foreign key constraints 
alter table IC_USER
  add constraint PK_IC_USER primary key (USER_ID);
alter table IC_USER
  add constraint FK_ORG_ID foreign key (ORG_ID)
  references IC_COMPANY (ORG_ID);
  
-- Create table
create table IC_CONF_TB
(
  tb_name          VARCHAR2(100) not null,
  schema_name      VARCHAR2(50) not null,
  t_leavel         VARCHAR2(1) not null,
  t_leavel_inter   NUMBER default 1 not null,
  t_part_up        VARCHAR2(50) not null,
  t_part_low       VARCHAR2(50),
  t_part_add       VARCHAR2(1) default 1 not null,
  t_part_drop      VARCHAR2(1) default 0 not null,
  t_actived        VARCHAR2(1) default 0 not null,
  last_modify_date DATE
);
-- Add comments to the table 
comment on table IC_CONF_TB
  is '分区表维护配置信息表,表必须是时间分区';
-- Add comments to the columns 
comment on column IC_CONF_TB.tb_name
  is '分区表名称';
comment on column IC_CONF_TB.schema_name
  is '表对应的用户名';
comment on column IC_CONF_TB.t_leavel
  is 'Y年   M月 D日  H时';
comment on column IC_CONF_TB.t_leavel_inter
  is '分区时间长度';
comment on column IC_CONF_TB.t_part_up
  is '最新分区名';
comment on column IC_CONF_TB.t_part_low
  is '最老分区名';
comment on column IC_CONF_TB.t_part_add
  is '1需要新增， 0不需要新增';
comment on column IC_CONF_TB.t_part_drop
  is '1需要删除， 0不需要删除';
comment on column IC_CONF_TB.t_actived
  is '1已激活，0未激活(不再自动维护)';
comment on column IC_CONF_TB.last_modify_date
  is '最后一次更新时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table IC_CONF_TB
  add constraint PK_IC_CONF_TB primary key (TB_NAME) ;
  
-- Create table
create table IC_INFO
(
  seq_no      VARCHAR2(64) not null,
  id_card     VARCHAR2(20) not null,
  id_name     VARCHAR2(50) not null,
  user_id     VARCHAR2(50) not null,
  ent_code    VARCHAR2(20),
  ent_name    VARCHAR2(500),
  bill_no     VARCHAR2(100),
  req_time    DATE not null,
  resp_time   DATE not null,
  check_time  DATE not null,
  req_src     VARCHAR2(1) not null,
  req_type    VARCHAR2(1) not null,
  pay_type    VARCHAR2(1),
  u_type      VARCHAR2(1) not null,
  data_src    VARCHAR2(1) not null,
  stat        VARCHAR2(2) not null,
  stat_msg    VARCHAR2(100),
  resp_msg    VARCHAR2(255),
  user_org_id VARCHAR2(100)
)
partition by range (REQ_TIME)
(
  partition P_201812 values less than (TO_DATE(' 2019-01-01 00:00:00', 'SYYYY-MM-DD HH24:MI:SS', 'NLS_CALENDAR=GREGORIAN')),
  partition P_201901 values less than (TO_DATE(' 2019-02-01 00:00:00', 'SYYYY-MM-DD HH24:MI:SS', 'NLS_CALENDAR=GREGORIAN')),
  partition P_MAX values less than (MAXVALUE)
);
-- Add comments to the table 
comment on table IC_INFO
  is '验证信息记录表';
-- Add comments to the columns 
comment on column IC_INFO.ent_code
  is '报文中的代码';
comment on column IC_INFO.ent_name
  is '从数据库中验证后补填的企业名，理论上为电商名';
comment on column IC_INFO.bill_no
  is '入驻企业主要是清单编号';
comment on column IC_INFO.req_time
  is '客户请求接口时间';
comment on column IC_INFO.resp_time
  is '接口响应客户时间';
comment on column IC_INFO.check_time
  is '接口验证时间';
comment on column IC_INFO.req_src
  is '1web/ 2api';
comment on column IC_INFO.req_type
  is '1接口直调(不检测本地缓存) 2混合调用';
comment on column IC_INFO.pay_type
  is '1预支付  2后支付 3免支付 和用户表中的配置保持一致';
comment on column IC_INFO.u_type
  is '1用户只提供身份证信息 2用户:验证电商代码 3用户:验证电商代码单号  4用户:验证电商代码单号单据';
comment on column IC_INFO.data_src
  is '1local 2remote';
comment on column IC_INFO.stat
  is '1一致 0不一致 2(-1)不存在 3未知道错误(请求成功，但报文解析错误) 9未验证(请求本身有错)';
comment on column IC_INFO.resp_msg
  is '远程接口的响应报文';
comment on column IC_INFO.user_org_id
  is '用户企业ID';
-- Create/Recreate indexes 
create index IDX_IC_IDCARD on IC_INFO (REQ_TIME, ID_CARD)
  local;
create index IDX_IC_INFO_SEQ on IC_INFO (SEQ_NO)
  local;
create index IDX_IC_REQ_U_ on IC_INFO (REQ_TIME, USER_ID)
  local; 

-- Create table
create table IC_CACHE
(
  seq_no      VARCHAR2(64) not null,
  create_time DATE not null,
  id_card     VARCHAR2(20) not null,
  id_name     VARCHAR2(50) not null
)
partition by range (CREATE_TIME)
(
  partition P_201912 values less than (TO_DATE(' 2019-01-01 00:00:00', 'SYYYY-MM-DD HH24:MI:SS', 'NLS_CALENDAR=GREGORIAN')),
  partition P_201901 values less than (TO_DATE(' 2019-02-01 00:00:00', 'SYYYY-MM-DD HH24:MI:SS', 'NLS_CALENDAR=GREGORIAN')),
  partition P_MAX values less than (MAXVALUE)
);
-- Add comments to the table 
comment on table IC_CACHE
  is '验证信息缓存表，只存储验证通过的记录';
-- Add comments to the columns 
comment on column IC_CACHE.seq_no
  is 'ID:NAME hashcode()';
-- Create/Recreate indexes 
create index IDX_IC_SEQ on IC_CACHE (SEQ_NO)
  local;
  
-- Create table
create table IC_W_FILES
(
  seq_no      VARCHAR2(64) not null,
  file_name   VARCHAR2(250) not null,
  user_id     VARCHAR2(50) not null,
  upload_time DATE not null,
  req_time    DATE,
  checked     INTEGER not null,
  batch_no    VARCHAR2(50) not null
);
-- Add comments to the table 
comment on table IC_W_FILES
  is 'web端上传的文件列表';
-- Add comments to the columns 
comment on column IC_W_FILES.checked
  is '0否 1是';
-- Create/Recreate indexes 
create index IDX_IWF_F on IC_W_FILES (UPLOAD_TIME, USER_ID, FILE_NAME);
-- Create/Recreate primary, unique and foreign key constraints 
alter table IC_W_FILES
  add constraint PK_IC_W_FILES primary key (SEQ_NO);
  
-- Create table
create table IC_W_INFO
(
  seq_no    VARCHAR2(64) not null,
  id_card   VARCHAR2(20) not null,
  id_name   VARCHAR2(50) not null,
  user_id   VARCHAR2(50) not null,
  ent_code  VARCHAR2(20),
  ent_name  VARCHAR2(500),
  bill_no   VARCHAR2(100),
  req_time  DATE,
  resp_time DATE,
  req_type  VARCHAR2(1) not null,
  pay_type  VARCHAR2(1),
  u_type    VARCHAR2(1) not null,
  f_seq_no  VARCHAR2(250) not null,
  stat      VARCHAR2(2) not null,
  stat_msg  VARCHAR2(100) not null
)
partition by range (REQ_TIME)
(
  partition P_201812 values less than (TO_DATE(' 2019-01-01 00:00:00', 'SYYYY-MM-DD HH24:MI:SS', 'NLS_CALENDAR=GREGORIAN')),
  partition P_201901 values less than (TO_DATE(' 2019-02-01 00:00:00', 'SYYYY-MM-DD HH24:MI:SS', 'NLS_CALENDAR=GREGORIAN')),
  partition P_MAX values less than (MAXVALUE)
);
-- Add comments to the table 
comment on table IC_W_INFO
  is 'WEB端 验证信息记录表';
-- Add comments to the columns 
comment on column IC_W_INFO.ent_code
  is '报文中的代码';
comment on column IC_W_INFO.ent_name
  is '从数据库中验证后补填的企业名，理论上为电商名';
comment on column IC_W_INFO.bill_no
  is '入驻企业主要是清单编号';
comment on column IC_W_INFO.req_type
  is '1接口直调(不检测本地缓存) 2混合调用';
comment on column IC_W_INFO.pay_type
  is '1预支付 2后支付 3免支付 和用户表中的配置保持一致';
comment on column IC_W_INFO.u_type
  is '11用户只提供身份证信息  2用户:验证电商代码 3用户:验证电商代码单号  4用户:验证电商代码单号单据';
comment on column IC_W_INFO.f_seq_no
  is 'IC_W_FILES表中的seq_no';
comment on column IC_W_INFO.stat
  is '1一致 0不一致 2(-1)不存在 3未知道错误(请求成功，但报文解析错误) 9未验证(请求本身有错)';
-- Create/Recreate indexes 
create index IDX_IW_INFO_SEQ on IC_W_INFO (SEQ_NO)
  local;
create index IDX_IW_UFSEQ on IC_W_INFO (USER_ID, F_SEQ_NO);


-- Create table
create table IC_INFO_TEST
(
  seq_no      VARCHAR2(64) not null,
  id_card     VARCHAR2(20) not null,
  id_name     VARCHAR2(50) not null,
  user_id     VARCHAR2(50) not null,
  ent_code    VARCHAR2(20),
  ent_name    VARCHAR2(500),
  bill_no     VARCHAR2(100),
  req_time    DATE not null,
  resp_time   DATE not null,
  check_time  DATE not null,
  req_src     VARCHAR2(1) not null,
  req_type    VARCHAR2(1) not null,
  pay_type    VARCHAR2(1),
  u_type      VARCHAR2(1) not null,
  data_src    VARCHAR2(1) not null,
  stat        VARCHAR2(2) not null,
  stat_msg    VARCHAR2(100),
  resp_msg    VARCHAR2(255),
  user_org_id VARCHAR2(100)
);
-- Add comments to the table 
comment on table IC_INFO_TEST
  is '验证信息记录表';
-- Add comments to the columns 
comment on column IC_INFO_TEST.ent_code
  is '报文中的代码';
comment on column IC_INFO_TEST.ent_name
  is '从数据库中验证后补填的企业名，理论上为电商名';
comment on column IC_INFO_TEST.bill_no
  is '入驻企业主要是清单编号';
comment on column IC_INFO_TEST.req_time
  is '客户请求接口时间';
comment on column IC_INFO_TEST.resp_time
  is '接口响应客户时间';
comment on column IC_INFO_TEST.check_time
  is '接口验证时间';
comment on column IC_INFO_TEST.req_src
  is '1web/ 2api';
comment on column IC_INFO_TEST.req_type
  is '1接口直调(不检测本地缓存) 2混合调用';
comment on column IC_INFO_TEST.pay_type
  is '1预支付 2后支付 3免支付 和用户表中的配置保持一致';
comment on column IC_INFO_TEST.u_type
  is '1用户只提供身份证信息  2用户:验证电商代码 3用户:验证电商代码单号  4用户:验证电商代码单号单据';
comment on column IC_INFO_TEST.data_src
  is '1local 2remote';
comment on column IC_INFO_TEST.stat
  is '1一致 0不一致 2(-1)不存在 3未知道错误(请求成功，但报文解析错误) 9未验证(请求本身有错)';
comment on column IC_INFO_TEST.resp_msg
  is '远程接口的响应报文';
comment on column IC_INFO_TEST.user_org_id
  is '用户企业ID';
-- Create/Recreate indexes 
create index IDX_IC_IDCARD_TEST on IC_INFO_TEST (REQ_TIME, ID_CARD);
create index IDX_IC_INFO_SEQ_TEST on IC_INFO_TEST (SEQ_NO);
create index IDX_IC_REQ_U_TEST on IC_INFO_TEST (REQ_TIME, USER_ID);

-- interface table
create table IC_REFERS
(
  seq_no        NUMBER not null,
  r_url         VARCHAR2(500) not null,
  r_user_key    VARCHAR2(2048) not null,
  r_time_out    NUMBER default 30,
  r_weight      NUMBER default 1,
  is_off        VARCHAR2(2) default 1 not null,
  expired_date  DATE,
  r_description VARCHAR2(500),
  class_name    VARCHAR2(500) not null,
  r_name        VARCHAR2(100) not null,
  r_id          VARCHAR2(50) not null,
  r_server_key  VARCHAR2(2048)
);
-- Add comments to the table 
comment on table IC_REFERS
  is '第三方接口配置表';
-- Add comments to the columns 
comment on column IC_REFERS.seq_no
  is '序列号主键';
comment on column IC_REFERS.r_url
  is '第三方接口地址';
comment on column IC_REFERS.r_user_key
  is '第三方接口的用户口令,如果是非对称加密此列为私钥';
comment on column IC_REFERS.r_time_out
  is '接口超时时间单位 s';
comment on column IC_REFERS.r_weight
  is '接口调用频率的权重，范围[1-10]';
comment on column IC_REFERS.is_off
  is '是否禁用 1:在用 0:禁用';
comment on column IC_REFERS.expired_date
  is '接口过期时间，与is_off是两回事,不会因为过期而修改is_off';
comment on column IC_REFERS.r_description
  is '接口描述';
comment on column IC_REFERS.class_name
  is '接口在系统中的实现类名(重写classloader动态通过上传jar来加载)';
comment on column IC_REFERS.r_name
  is '接口的显示名';
comment on column IC_REFERS.r_id
  is '接口的代码';
comment on column IC_REFERS.r_server_key
  is '只填写非对称加密方式下对方的公钥';
create unique index PK_R_ID on IC_REFERS (R_ID);
alter table IC_REFERS add constraint PK_R_SEQ primary key (SEQ_NO);
  
-- 用户接口关联表
create table IC_USER_REFERS
(
  r_user_id     VARCHAR2(50) not null,
  r_seq_no      NUMBER not null,
  r_weight      NUMBER default 1,
  r_is_expired  DATE,
  r_is_off      VARCHAR2(2) default 0 not null,
  r_description VARCHAR2(1000)
);
-- Add comments to the table 
comment on table IC_USER_REFERS
  is '用户接口关联表';
-- Add comments to the columns 
comment on column IC_USER_REFERS.r_user_id
  is '账号ID';
comment on column IC_USER_REFERS.r_seq_no
  is '接口SEQ_NO';
comment on column IC_USER_REFERS.r_weight
  is '用户调用接口时的权重[1-10]';
comment on column IC_USER_REFERS.r_is_expired
  is '用户接口过期时间';
comment on column IC_USER_REFERS.r_is_off
  is '用户接口是否被禁用';
comment on column IC_USER_REFERS.r_description
  is '接口使用描述';
  
create index IDX_U_R_US on IC_USER_REFERS (R_USER_ID, R_SEQ_NO);

--修改记录表中的验证数据来源列
ALTER TABLE IC_INFO MODIFY DATA_SRC VARCHAR2(50) ;
ALTER TABLE IC_INFO_TEST MODIFY DATA_SRC VARCHAR2(50) ;
ALTER TABLE IC_INFO MODIFY RESP_MSG VARCHAR2(1000) ;
ALTER TABLE IC_INFO_TEST MODIFY RESP_MSG VARCHAR2(1000) ;
--修改记录表中的注释
comment on column IC_INFO.DATA_SRC is '0错误 1LOCAL 其它参考ic_refers表中的ID值';
comment on column IC_INFO_TEST.DATA_SRC is '0错误 1LOCAL 其它参考ic_refers表中的ID值';
