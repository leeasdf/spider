CREATE TABLE `qcc_tender` (
	`id` bigint(20) primary key auto_increment NOT NULL COMMENT '主键',
	`title` varchar(255) COMMENT '描述',
	`pubdate` datetime COMMENT '发布时间',
	`province_name` varchar(255) COMMENT '所属区域',
	`channel_name` varchar(255) COMMENT '项目分类',
	`ent_name` varchar(255) COMMENT '关键字（公司名、社会统一信用代码、注册号）',
	`create_time` timestamp NULL COMMENT '创建时间',
	`update_time` timestamp NULL COMMENT '更新时间',
	`remark` varchar(300) COMMENT '备注',
	`version` int(10) COMMENT '版本号',
	`data_status` int(1) COMMENT '数据状态'
) COMMENT='企查查——企业招投标信息';