CREATE TABLE `qcc_copyright` (
	`id` bigint(20) primary key auto_increment NOT NULL COMMENT '主键',
	`category` varchar(255) COMMENT '分类号',
	`publish_date` datetime COMMENT '发布日期',
	`version_no` int COMMENT '版本号',
	`register_no` varchar(255) COMMENT '登记号',
	`register_aper_date` datetime COMMENT '登记批准日期',
	`name` varchar(255) COMMENT '软件全称',
	`short_name` varchar(255) COMMENT '软件简称',
	`owner` varchar(255) COMMENT '软件著作权人',
	`ent_name` varchar(255) COMMENT '关键字(公司名或keyNo)',
	`create_time` timestamp NULL COMMENT '创建时间',
	`update_time` timestamp NULL COMMENT '更新时间',
	`remark` varchar(300) COMMENT '备注',
	`version` int(10) COMMENT '版本号',
	`data_status` int(1) COMMENT '数据状态'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企查查API-软件著作权';


-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    VALUES ('1', '企查查API-软件著作权', 'qichacha/qcccopyright', NULL, '1', 'config', '6');

-- 按钮父菜单ID
set @parentId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '查看', null, 'qichacha:qcccopyright:list,qichacha:qcccopyright:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '新增', null, 'qichacha:qcccopyright:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '修改', null, 'qichacha:qcccopyright:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '删除', null, 'qichacha:qcccopyright:delete', '2', null, '6';
