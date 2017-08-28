DROP TABLE IF EXISTS t_business;


CREATE TABLE `t_business` (
`row_id`  VARCHAR (35) NOT NULL COMMENT 'rowid',
`code`  VARCHAR (35) NULL COMMENT '代码',
`name`  VARCHAR (35) NULL COMMENT '名称',
`desc` VARCHAR (35) NULL COMMENT '描述',
`desp` VARCHAR (35) NULL COMMENT '说明',
`version` varchar(35) null comment '版本',
`status` varchar(35) null comment '状态',
`create_user` VARCHAR (35) NULL COMMENT '创建人',
`create_user_name` VARCHAR (35) NULL COMMENT '创建人名称',
`create_time` VARCHAR (35) NULL COMMENT '创建时间',
`modify_user` VARCHAR (35) NULL COMMENT '修改人',
`modify_user_name` VARCHAR (35) NULL COMMENT '修改人名称',
`modify_time` VARCHAR (35) NULL COMMENT '修改时间',
PRIMARY KEY (`row_id`)
)
;

