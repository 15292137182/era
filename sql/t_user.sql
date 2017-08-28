drop TABLE IF EXISTS t_user;

CREATE TABLE `t_user` (
`row_id`  varchar(35) NOT NULL COMMENT 'rowId' ,
`name`  varchar(35) NULL COMMENT '名称' ,
`password`  varchar(35) NULL COMMENT '密码' ,
`version` varchar(35) null comment '版本',
`status` varchar(35) null comment '状态',
`create_time`  varchar(35) NULL COMMENT '创建时间' ,
`create_user`  varchar(35) NULL COMMENT '创建人' ,
`create_user_name`  varchar(35) NULL COMMENT '创建人名称' ,
`modify_user`  varchar(35) NULL COMMENT '修改人' ,
`modify_user_name`  varchar(35) NULL COMMENT '修改人名称' ,
`modify_time`  varchar(35) NULL COMMENT '修改时间' ,
PRIMARY KEY (`row_id`)
)
;