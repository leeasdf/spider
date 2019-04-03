CREATE TABLE `credithunan_tax_contravention` (
	`id` bigint(20) primary key auto_increment NOT NULL COMMENT '主键',
	`taxpayer` varchar(200) COMMENT '纳税人名称',
	`taxpayer_no` varchar(20) COMMENT '纳税人识别号',
	`credit_code` varchar(20) COMMENT '社会信用统一代码',
	`register_address` varchar(50) COMMENT '注册地址',
	`legal` varchar(20) COMMENT '法定代表人',
	`certification_no` varchar(18) COMMENT '身份证号',
	`check_unit` varchar(200) COMMENT '实施检查单位',
	`declaration_date` DATETIME NULL COMMENT '公告日期',
	`infomation_name` varchar(50) COMMENT '信息名称',
	`source` varchar(50) COMMENT '数据来源',
	`infomation_type` varchar(50) COMMENT '信息类型',
	`source_time` DATETIME NULL COMMENT '信息资源更新时间',
	`spider_id` bigint COMMENT '爬虫表数据记录id',
	`create_time` timestamp NULL COMMENT '创建时间',
	`update_time` timestamp NULL COMMENT '更新时间',
	`remark` varchar(200) COMMENT '备注，若记录有变对应将原来的spiderid存入以便于追踪轨迹 如：123，345 由原来spider表的123，和345 两条更新过来这个记录对于表三条记录中spiderid对应最新的',
	`version` int(10) COMMENT '版本号',
	`data_status` int(1) COMMENT '数据状态'
) ENGINE=`InnoDB` CHARACTER SET utf8  COMMENT='重大税收违法案件公告信息';

CREATE TABLE `credithunan_tax_A` (
	`id` bigint(20) primary key auto_increment NOT NULL COMMENT '主键',
	`taxpayer` varchar(200) COMMENT '纳税人名称',
	`taxpayer_no` varchar(20) COMMENT '纳税人识别号',
	`org_code` varchar(12) COMMENT	'组织机构代码',
	`responsible_person`varchar(20) COMMENT	'负责人',
	`tax_authorities` varchar(50)	COMMENT	'主管税务机关',
	`credit_level` varchar(4) COMMENT '信用等级',
	`year`	varchar(4) COMMENT '评价年度',
	`tax_type`	varchar(20) COMMENT '税务类型：国税/地税',
	`infomation_name` varchar(50) COMMENT '信息名称',
	`source` varchar(50) COMMENT '数据来源',
	`infomation_type` varchar(50) COMMENT '信息类型',
	`source_time` DATETIME NULL COMMENT '信息资源更新时间(网站更新 表头)',
	`tax_update_time` DATETIME NULL COMMENT '更新时间(信用等级 表中)',
	`spider_id` bigint COMMENT '爬虫表数据记录id',
	`create_time` timestamp NULL COMMENT '创建时间',
	`update_time` timestamp NULL COMMENT '更新时间',
	`remark` varchar(200) COMMENT '备注，若记录有变对应将原来的spiderid存入以便于追踪轨迹 如：123，345 由原来spider表的123，和345 两条更新过来这个记录对于表三条记录中spiderid对应最新的',
	`version` int(10) COMMENT '版本号',
	`data_status` int(1) COMMENT '数据状态'
) ENGINE=`InnoDB` CHARACTER SET utf8  COMMENT='年度纳税信用A级纳税人名单';



CREATE TABLE `credithunan_administrative_penalty` (
	`id` bigint(20) primary key auto_increment NOT NULL COMMENT '主键',
	`case_name` varchar(200) COMMENT '案件名称',
	`case_no` varchar(200) COMMENT '行政处罚决定书文号',
	`case_object` varchar(200) COMMENT '行政相对人名称',
	`representative` varchar(12) COMMENT	'法定代表人（或单位负责人）',
	`low_department`varchar(50) COMMENT'执法部门',
	`punishment_date` DATETIME NULL COMMENT	'作出行政处罚的日期',
	`content` text COMMENT '行政处罚决定书（全文或摘要）',
	`issue_date` DATETIME NULL COMMENT	'发布日期',

	`spider_id` bigint COMMENT '爬虫表数据记录id',
	`create_time` timestamp NULL COMMENT '创建时间',
	`update_time` timestamp NULL COMMENT '更新时间',
	`remark` varchar(200) COMMENT '备注，若记录有变对应将原来的spiderid存入以便于追踪轨迹 如：123，345 由原来spider表的123，和345 两条更新过来这个记录对于表三条记录中spiderid对应最新的',
	`version` int(10) COMMENT '版本号',
	`data_status` int(1) COMMENT '数据状态'
) ENGINE=`InnoDB` CHARACTER SET utf8  COMMENT='双公示-行政处罚列表';


CREATE TABLE `creditchina_base_info` (
	`id` bigint(20) primary key auto_increment NOT NULL COMMENT '主键',

	`credit_code` varchar(20) COMMENT '信用代码',
	`ent_name` varchar(50) COMMENT '企业名称',
	`dom` varchar(255) COMMENT '企业地址',
	`enttype` varchar(255) COMMENT '企业类型',
	`esdate` DATETIME NULL COMMENT '成立日期',
	`legal` varchar(50) COMMENT '法人代表',
	`organization_code` varchar(255) COMMENT '组织机构代码',
	`regcap` decimal(12,4) COMMENT '注册资本',
	`regno` varchar(30) COMMENT '工商注册号',
	`regorg` varchar(255) COMMENT '登记机关',
	`revdate` DATETIME NULL COMMENT '修订日期',
	`validTime` DATETIME NULL COMMENT '有效时间',
	`tax_code` varchar(255) COMMENT '税号',
	`apprdate` DATETIME NULL,
	`area` varchar(255),
	`bad_count` int,
	`candate` DATETIME NULL,
	`cf_count` int,
	`dishonesty_count` int,
	`entstatus` int,
	`good_count` int,
	`idCard` varchar(255),
	`opfrom` varchar(255),
	`opscope` varchar(255),
	`opto` varchar(255),
	`other_count` int,
	`rank` int,
	`solr_status` int,
	`source` int,
	`sys_update_time` DATETIME NULL,
	`xk_count` int,

	`spider_id` bigint COMMENT '爬虫表数据记录id',
	`create_time` timestamp NULL COMMENT '创建时间',
	`update_time` timestamp NULL COMMENT '更新时间',
	`remark` varchar(200) COMMENT '备注',
	`data_status` int(1) COMMENT '数据状态'
) ENGINE=`InnoDB` CHARACTER SET utf8  COMMENT='信用中国-基本信息';



CREATE TABLE `creditchina_pub_permission` (
	`id` bigint(20) primary key auto_increment NOT NULL COMMENT '主键',

	`area_code` varchar(255),
	`file_id` varchar(255),
	`finger_print` varchar(255),
	`pv` varchar(255),
	`role_id` varchar(255),
	`subject_id` varchar(255),
	`upload_date` varchar(255),
	`xk_bz` varchar(255),
	`xk_dfbm` varchar(255) COMMENT '地方编码',
	`xk_fr` varchar(255) DEFAULT '' COMMENT '法人代表人姓名',
	`xk_jdrq` DATETIME NULL COMMENT '许可决定日期',
	`xk_jzq` DATETIME NULL COMMENT '许可截止日期',
	`xk_nr` text DEFAULT NULL COMMENT '内容许可',
	`xk_sjc` DATETIME NULL COMMENT '数据更新时间',
	`xk_splb` varchar(255) COMMENT '审核类型',
	`xk_wsh` varchar(255) COMMENT '行政许可决定书文号',
	`xk_xdr` varchar(255) COMMENT '企业名称',
	`xk_xdr_gsdj` varchar(255),
	`xk_xdr_sfz` varchar(255),
	`xk_xdr_shxym` varchar(255),
	`xk_xdr_swdj` varchar(255),
	`xk_xdr_zdm` varchar(255),
	`xk_xmmc` varchar(255),
	`xk_xzbm` varchar(255),
	`xk_xzjg` varchar(255) COMMENT '许可机关',
	`xk_yxq` varchar(255),
	`xk_zt` varchar(255),

	`spider_id` bigint COMMENT '爬虫表数据记录id',
	`create_time` timestamp NULL COMMENT '创建时间',
	`update_time` timestamp NULL COMMENT '更新时间',
	`remark` varchar(200) COMMENT '备注',
	`data_status` int(1) COMMENT '数据状态'
) ENGINE=`InnoDB` CHARACTER SET utf8  COMMENT='信用中国-行政许可';


CREATE TABLE `creditchina_pub_penalty` (
	`id` bigint(20) primary key auto_increment NOT NULL COMMENT '主键',

	`area_code` varchar(255),
	`cf_bz` varchar(255),
	`cf_cflb1` varchar(255) COMMENT '处罚类别',
	`cf_cflb2` varchar(255),
	`cf_cfmc` varchar(255) COMMENT '处罚名称',
	`cf_dfbm` varchar(255),
	`cf_fr` varchar(255) COMMENT '法人代表人姓名',
	`cf_jdrq` DATETIME NULL COMMENT '处罚决定日期',
	`cf_jg` text COMMENT '处罚结果',
	`cf_qx` varchar(255),
	`cf_sjc` DATETIME NULL COMMENT '数据更新时间',
	`cf_sy` text COMMENT '处罚事由',
	`cf_wsh` varchar(255) COMMENT '决定书文号',
	`cf_xdr_gsdj` varchar(255),
	`cf_xdr_mc` varchar(255),
	`cf_xdr_sfz` varchar(255),
	`cf_xdr_shxym` varchar(255),
	`cf_xdr_swdj` varchar(255),
	`cf_xdr_zdm` varchar(255),
	`cf_xzbm` varchar(255),
	`cf_xzjg` varchar(255) COMMENT '处罚机关',
	`cf_yj` varchar(1000) COMMENT '处罚依据',
	`cf_zt` varchar(255),
	`file_id` varchar(255),
	`finger_print` varchar(255),
	`pv` varchar(255),
	`role_id` varchar(255),
	`subject_id` varchar(255),
	`upload_date` varchar(255),

	`spider_id` bigint COMMENT '爬虫表数据记录id',
	`create_time` timestamp NULL COMMENT '创建时间',
	`update_time` timestamp NULL COMMENT '更新时间',
	`remark` varchar(200) COMMENT '备注',
	`data_status` int(1) COMMENT '数据状态'
) ENGINE=`InnoDB` CHARACTER SET utf8  COMMENT='信用中国-行政处罚';

-- 此表数据是通过脚本初始化的先定义一张表后在此表配置好路由解析时通过此表获得应用的表名存库并记录路由信息
CREATE TABLE `creditchina_credit_type` (
	`id` bigint(20) primary key auto_increment NOT NULL COMMENT '主键',

	`credit_type` varchar(255) COMMENT '类型 (2:honesty-守信红名单,4:focus-重点关注名单,8:black-黑名单)',
	`source` varchar(255) COMMENT '数据来源 有不同的来源数据类型不一样,在不同的表中',
	`table_name` varchar(255) COMMENT '对应的表名',
	`entity_name` varchar(255) COMMENT '对应的实体名',

	`create_time` timestamp NULL COMMENT '创建时间',
	`update_time` timestamp NULL COMMENT '更新时间',
	`remark` varchar(200) COMMENT '备注',
	`data_status` int(1) COMMENT '数据状态'
) ENGINE=`InnoDB` CHARACTER SET utf8  COMMENT='信用中国-信用类型中间表(路由表)';

CREATE TABLE `creditchina_credit_type_record` (
	`id` bigint(20) primary key auto_increment NOT NULL COMMENT '主键',

	`credit_type` varchar(255) COMMENT '类型 (2:honesty-守信红名单,4:focus-重点关注名单,8:black-黑名单)',
	`source` varchar(255) COMMENT '数据来源 有不同的来源数据类型不一样,在不同的表中',
	`table_name` varchar(255) COMMENT '对应的表名',
	`entity_name` varchar(255) COMMENT '对应的实体名',
	`ent_name` varchar(255) COMMENT '企业名称',

	`credit_type_id` bigint COMMENT '路由Id',
	`spider_id` bigint COMMENT '爬虫表数据记录id',
	`table_id` bigint(20) COMMENT '对应的表主键id',
	`create_time` timestamp NULL COMMENT '创建时间',
	`update_time` timestamp NULL COMMENT '更新时间',
	`remark` varchar(200) COMMENT '备注',
	`data_status` int(1) COMMENT '数据状态'
) ENGINE=`InnoDB` CHARACTER SET utf8  COMMENT='信用中国-信用类型中间表(路由记录表)';

CREATE TABLE `creditchina_honesty_tax` (
	`id` bigint(20) primary key auto_increment NOT NULL COMMENT '主键',

	`no` varchar(255) COMMENT '序号',
	`source` varchar(255) COMMENT '数据来源',
	`type` varchar(255) COMMENT '数据类别',
	`file_name` varchar(255) COMMENT '文件名',
	`last_update_time` DATETIME NULL COMMENT '最新更新日期',
	`tax_name` varchar(255) COMMENT '纳税人名称',
	`year` int(4) COMMENT '评价年度',

	`spider_id` bigint COMMENT '爬虫表数据记录id',
	`create_time` timestamp NULL COMMENT '创建时间',
	`update_time` timestamp NULL COMMENT '更新时间',
	`remark` varchar(200) COMMENT '备注',
	`data_status` int(1) COMMENT '数据状态'
) ENGINE=`InnoDB` CHARACTER SET utf8  COMMENT='信用中国-守信红名单-税务局';


CREATE TABLE `creditchina_focus_penalty` (
	`id` bigint(20) primary key auto_increment NOT NULL COMMENT '主键',

	`punishment_date` DATETIME NULL COMMENT '处罚处理日期',
	`punishment_object` varchar(255) COMMENT '处罚对象名称',
	`punishment_depart` varchar(255) COMMENT '实际处罚部门',
	`punishment_organ` varchar(255) COMMENT '处罚机关',
	`type` varchar(255) COMMENT '数据类别',
	`punishment_name` varchar(255) COMMENT '处罚处理名称',
	`last_update_time` DATETIME NULL COMMENT '最新更新日期',
	`penalty_decision` varchar(255) COMMENT '处罚决定书ID',
	`source` varchar(255) COMMENT '数据来源',
	`information_type` varchar(255) COMMENT '信息类型',
	`punishment_content` text COMMENT '处罚处理内容',
	`punishment_type` varchar(255) COMMENT '处罚处理种类',

	`create_time` timestamp NULL COMMENT '创建时间',
	`update_time` timestamp NULL COMMENT '更新时间',
	`remark` varchar(200) COMMENT '备注',
	`data_status` int(1) COMMENT '数据状态'
) ENGINE=`InnoDB` CHARACTER SET utf8  COMMENT='信用中国-重点关注名单-证监会';


CREATE TABLE `creditchina_black_law` (
	`id` bigint(20) primary key auto_increment NOT NULL COMMENT '主键',

	`type` varchar(255) COMMENT '数据类别',
	`source` varchar(255) COMMENT '数据来源',
	`case_no` varchar(255) COMMENT '案号',
	`dishonest_name` varchar(255) COMMENT '失信被执行人名称',
	`enterprise_legal` varchar(255) COMMENT '企业法人姓名',
	`court` varchar(255) COMMENT '执行法院',
	`area` varchar(255) COMMENT '地域名称',
	`basis_number` varchar(255) COMMENT '执行依据文号',
	`execution_basis` varchar(255) COMMENT '作出执行依据单位',
	`law_duty` TEXT COMMENT '法律生效文书确定的义务',
	`performance` varchar(255) COMMENT '被执行人的履行情况',
	`situation` varchar(1000) COMMENT '失信被执行人具体情形',
	`published` DATETIME NULL COMMENT '发布时间',
	`filing_time` DATETIME NULL COMMENT '立案时间',
	`fulfilled_part` varchar(255) COMMENT '已履行部分',
	`unfulfilled_part` varchar(255) COMMENT '未履行部分',
	`last_update_time` DATETIME NULL COMMENT '最新更新日期',

	`create_time` timestamp NULL COMMENT '创建时间',
	`update_time` timestamp NULL COMMENT '更新时间',
	`remark` varchar(200) COMMENT '备注',
	`data_status` int(1) COMMENT '数据状态'
) ENGINE=`InnoDB` CHARACTER SET utf8  COMMENT='信用中国-黑名单-最高法';


CREATE TABLE `creditchina_focus_gszj` (
	`id` bigint(20) primary key auto_increment NOT NULL COMMENT '主键',

	`type` varchar(255) COMMENT '数据类别',
	`source` varchar(255) COMMENT '数据来源',
	`reg_no` varchar(255) COMMENT '注册号',
	`legal` varchar(255) COMMENT '法定代表人',
	`reason` varchar(1000) COMMENT '列入经营异常名录原因类型名称',
	`enterprise_name` varchar(255) COMMENT '企业名称',
	`establish_date` datetime COMMENT '设立日期',
	`decision_organ` varchar(255) COMMENT '列入决定机关名称',
	`last_update_time` DATETIME NULL COMMENT '最新更新日期',

	`create_time` timestamp NULL COMMENT '创建时间',
	`update_time` timestamp NULL COMMENT '更新时间',
	`remark` varchar(200) COMMENT '备注',
	`data_status` int(1) COMMENT '数据状态'
) ENGINE=`InnoDB` CHARACTER SET utf8  COMMENT='信用中国-重点关注名单-工商总局';

BEGIN;
INSERT INTO `creditchina_credit_type` VALUES
	('1', '2', '税务局', 'creditchina_honesty_tax', 'CreditchinaHonestyTaxEntity', '2018-10-15 18:22:32', null, '表必须放在xin.tianchuang.modules.dataparser.entity包下', '1'),
	('2', '4', '证监会', 'creditchina_focus_penalty', 'CreditchinaFocusPenaltyEntity', '2018-10-16 15:34:13', null, null, '1'),
	('3', '8', '最高法', 'creditchina_black_law', 'CreditchinaBlackLawEntity', '2018-10-16 15:35:05', null, null, '1'),
	('4', '4', '工商总局', 'creditchina_focus_gszj', 'CreditchinaFocusGszjEntity', '2018-10-17 10:39:52', null, null, '1');
COMMIT;