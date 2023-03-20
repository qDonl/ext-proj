# 创建数据库
create database if not exists `school`;
use school;

# 创建用户并授权
create user if not exists school@'%' identified by 'school';
GRANT all ON school.* TO school;

drop table if exists `user`;
drop table if exists `consult`;
drop table if exists `consult_reply`;
drop table if exists `mental_evaluation`;
drop table if exists `mental_case`;
drop table if exists `mental_resource`;
drop table if exists `sys_anno`;
drop table if exists `msg_board`;


create table `user`
(
    `id`          bigint       not null primary key auto_increment comment '主键',
    `phone`       char(11)     not null default '' comment '手机号',
    `real_name`   varchar(32)  not null default '' comment '用户名',
    `password`    varchar(512) not null default '' comment '密码',
    `role`        tinyint(1)   not null default 0 comment '用户角色(0:学生;1:教师;3:管理员)',
    `create_time` datetime     not null default current_timestamp comment '创建时间',
    `create_by`   bigint       not null default 0 comment '创建人ID',
    `update_time` datetime     not null default current_timestamp on update current_timestamp comment '创建时间',
    `update_by`   bigint       not null default 0 comment '更新人ID',
    `is_deleted`  tinyint(1)   not null default 0 comment '是否被删除(0:未删除;1:已删除)'
) engine = 'InnoDB'
  charset = 'utf8mb4' comment = '用户';


create table `consult`
(
    `id`          bigint       not null primary key auto_increment comment '主键',
    `title`       varchar(128) not null default '' comment '咨询标题',
    `desc`        varchar(512) not null default '' comment '问题描述描述',
    `consultant`  varchar(32)  not null default '' comment '咨询者姓名',
    `create_time` datetime     not null default current_timestamp comment '创建时间',
    `create_by`   bigint       not null default 0 comment '创建人ID',
    `update_time` datetime     not null default current_timestamp on update current_timestamp comment '创建时间',
    `update_by`   bigint       not null default 0 comment '更新人ID',
    `is_deleted`  tinyint(1)   not null default 0 comment '是否被删除(0:未删除;1:已删除)'
) engine = 'InnoDB'
  charset = 'utf8mb4'
    comment '咨询';


create table `consult_reply`
(
    `id`            bigint        not null primary key auto_increment comment '主键',
    `consult_id`    bigint        not null default 0 comment '问题咨询ID',
    `reply_content` varchar(1024) not null default '' comment '回复内容',
    `replier`       varchar(32)   not null default '' comment '回复者',
    `create_time`   datetime      not null default current_timestamp comment '创建时间',
    `create_by`     bigint        not null default 0 comment '创建人ID',
    `update_time`   datetime      not null default current_timestamp on update current_timestamp comment '创建时间',
    `update_by`     bigint        not null default 0 comment '更新人ID',
    `is_deleted`    tinyint(1)    not null default 0 comment '是否被删除(0:未删除;1:已删除)'
) engine = 'InnoDB'
  charset = 'utf8mb4'
    comment '咨询回复';

create table `mental_evaluation`
(
    `id`          bigint       not null primary key auto_increment comment '主键',
    `title`       varchar(64)  not null default '' comment '心理测评地址名称',
    `url`         varchar(512) not null default '' comment '心理测评地址',
    `publisher`   varchar(32)  not null default '' comment '推荐者名字',
    `create_time` datetime     not null default current_timestamp comment '创建时间',
    `create_by`   bigint       not null default 0 comment '创建人ID',
    `update_time` datetime     not null default current_timestamp on update current_timestamp comment '创建时间',
    `update_by`   bigint       not null default 0 comment '更新人ID',
    `is_deleted`  tinyint(1)   not null default 0 comment '是否被删除(0:未删除;1:已删除)'
) engine = 'InnoDB'
  charset = 'utf8mb4'
    comment '心理测评地址';


create table `mental_case`
(
    `id`          bigint        not null primary key auto_increment comment '主键',
    `title`       varchar(64)   not null default '' comment '案例名称',
    `content`     varchar(1024) not null default '' comment '案例详情描述',
    `publisher`   varchar(32)   not null default '' comment '发布者',
    `create_time` datetime      not null default current_timestamp comment '创建时间',
    `create_by`   bigint        not null default 0 comment '创建人ID',
    `update_time` datetime      not null default current_timestamp on update current_timestamp comment '创建时间',
    `update_by`   bigint        not null default 0 comment '更新人ID',
    `is_deleted`  tinyint(1)    not null default 0 comment '是否被删除(0:未删除;1:已删除)'
) engine = 'InnoDB'
  charset = 'utf8mb4'
    comment '心理测试案例';

create table `mental_resource`
(
    `id`          bigint       not null primary key auto_increment comment '主键',
    `title`       varchar(64)  not null default '' comment '资源名称',
    `desc`        varchar(256) not null default '' comment '资源描述',
    `thumbnail`   varchar(32)  not null default '' comment '资源缩略图',
    `attachment`  varchar(32)  not null default '' comment '附件ID',
    `publisher`   varchar(32)  not null default '' comment '发布者',
    `create_time` datetime     not null default current_timestamp comment '创建时间',
    `create_by`   bigint       not null default 0 comment '创建人ID',
    `update_time` datetime     not null default current_timestamp on update current_timestamp comment '创建时间',
    `update_by`   bigint       not null default 0 comment '更新人ID',
    `is_deleted`  tinyint(1)   not null default 0 comment '是否被删除(0:未删除;1:已删除)'
) engine = 'InnoDB'
  charset = 'utf8mb4'
    comment '心理资源推荐';


create table `sys_anno`
(
    `id`          bigint       not null primary key auto_increment comment '主键',
    `content`     varchar(512) not null default '' comment '公告内容',
    `publisher`   varchar(32)  not null default '' comment '发布者',
    `create_time` datetime     not null default current_timestamp comment '创建时间',
    `create_by`   bigint       not null default 0 comment '创建人ID',
    `update_time` datetime     not null default current_timestamp on update current_timestamp comment '创建时间',
    `update_by`   bigint       not null default 0 comment '更新人ID',
    `is_deleted`  tinyint(1)   not null default 0 comment '是否被删除(0:未删除;1:已删除)'
) engine = 'InnoDB'
  charset = 'utf8mb4'
    comment '系统公告';


create table `msg_board`
(
    `id`          bigint       not null primary key auto_increment comment '主键',
    `content`     varchar(512) not null default '' comment '留言内容',
    `publisher`   varchar(32)  not null default '' comment '发布者',
    `create_time` datetime     not null default current_timestamp comment '创建时间',
    `create_by`   bigint       not null default 0 comment '创建人ID',
    `update_time` datetime     not null default current_timestamp on update current_timestamp comment '创建时间',
    `update_by`   bigint       not null default 0 comment '更新人ID',
    `is_deleted`  tinyint(1)   not null default 0 comment '是否被删除(0:未删除;1:已删除)'
) engine = 'InnoDB'
  charset = 'utf8mb4'
    comment '留言板';



alter table mental_evaluation
    add column `desc` varchar(500) not null default '' comment '描述信息';

alter table mental_resource
    modify column `thumbnail` varchar(512) not null default '' comment '缩略图地址';


