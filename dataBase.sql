select * from dba_data_files;
--/data/oracle/oradata/orcl/saleSystem01.dbf

create tablespace sale_system
datafile '/data/oracle/oradata/orcl/saleSystem01.dbf'
size 2G
autoextend on
next 50M maxsize unlimited ;


create temporary tablespace sale_system_temp
tempfile '/data/oracle/oradata/orcl/saleSystemTemp.dbf'
size 2G;

create user salesystem
identified by "salesystem"
default tablespace sale_system
temporary tablespace sale_system_temp;

grant connect to salesystem;
grant dba to salesystem;
grant unlimited tablespace to salesystem;

create table INFO_RESOURCE
(
  RESOURCE_ID   VARCHAR2(32) not null
    primary key,
  RESOURCE_NAME VARCHAR2(400),
  RESOURCE_PATH VARCHAR2(1000),
  METHOD_NAME   VARCHAR2(400),
  METHOD_PATH   VARCHAR2(1000)
)
  /

  comment on table INFO_RESOURCE is '访问资源表'
  /

  comment
          on column INFO_RESOURCE.RESOURCE_ID is '32位UUID主键'
  /

  comment
          on column INFO_RESOURCE.RESOURCE_NAME is '资源名称'
  /

  comment
          on column INFO_RESOURCE.RESOURCE_PATH is '资源路径'
  /

  comment
          on column INFO_RESOURCE.METHOD_NAME is '资源所对应的方法名'
  /

  comment
          on column INFO_RESOURCE.METHOD_PATH is '资源所对应的包路径'
  /

create table INFO_RESOURCE_ROLE
(
  ID          VARCHAR2(32) not null
    primary key,
  ROLE_ID     VARCHAR2(32),
  RESOURCE_ID VARCHAR2(32),
  UPDATE_TIME VARCHAR2(19)
)
  /

  comment on table INFO_RESOURCE_ROLE is '资源权限关联表'
  /

  comment
          on column INFO_RESOURCE_ROLE.ID is '32位UUID主键'
  /

  comment
          on column INFO_RESOURCE_ROLE.ROLE_ID is '权限ID'
  /

  comment
          on column INFO_RESOURCE_ROLE.RESOURCE_ID is '资源ID'
  /

  comment
          on column INFO_RESOURCE_ROLE.UPDATE_TIME is '更新时间'
  /

create table INFO_ROLE
(
  ROLE_ID   VARCHAR2(32) not null
    primary key,
  ROLE_NAME VARCHAR2(100),
  ROLE_TYPE VARCHAR2(100),
  USER_ID   VARCHAR2(32)
)
  /

  comment on table INFO_ROLE is '用户权限表'
  /

  comment
          on column INFO_ROLE.ROLE_ID is '32位UUID主键'
  /

  comment
          on column INFO_ROLE.ROLE_NAME is '权限名称'
  /

  comment
          on column INFO_ROLE.ROLE_TYPE is '权限类型'
  /

  comment
          on column INFO_ROLE.USER_ID is '用户主键id'
  /

create table INFO_USER
(
  ID        VARCHAR2(32) not null
    primary key,
  USER_ID   VARCHAR2(32),
  USER_NAME VARCHAR2(32),
  PASS_WORD VARCHAR2(100)
)
  /

  comment on table INFO_USER is '登陆用户基本信息表'
  /

  comment
          on column INFO_USER.ID is '32位UUID主键'
  /

  comment
          on column INFO_USER.USER_ID is '用户登陆ID'
  /

  comment
          on column INFO_USER.USER_NAME is '用户姓名'
  /

  comment
          on column INFO_USER.PASS_WORD is '用户登陆密码'
  /
  INSERT INTO INFO_ROLE
(
  ROLE_ID,
  ROLE_NAME,
  ROLE_TYPE,
  USER_ID
) VALUES
(
  '7CA29B9B9719A8EDE050007F01001354',
  '管理员',
  'admin',
  '7A9A69E2F0C0C817E050007F0100559B'
);
INSERT INTO INFO_USER (ID, USER_ID, USER_NAME, PASS_WORD)
VALUES ('7A9A69E2F0C0C817E050007F0100559B', 'admin', '管理员',
        '$2a$10$OM4Z.vMcIa8SEDpUyuzW5u9vpmsVE8Ad0xHd2sHRTBPk8J6bJWeOC');


