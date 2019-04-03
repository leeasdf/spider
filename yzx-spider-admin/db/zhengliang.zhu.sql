DROP TABLE IF EXISTS `credithunan_administrative_licensing`;
CREATE TABLE `credithunan_administrative_licensing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `case_name` varchar(512) DEFAULT NULL COMMENT '案件名称',
  `case_no` varchar(200) DEFAULT NULL COMMENT '行政许可决定书文号',
  `case_object` varchar(200) DEFAULT NULL COMMENT '行政相对人名称',
  `legal_representative` varchar(12) DEFAULT NULL COMMENT '法定代表人（或单位负责人）',
  `law_enforcing_department` varchar(50) DEFAULT NULL COMMENT '执法部门',
  `licensing_date` timestamp NULL DEFAULT NULL COMMENT '作出行政许可的日期',
  `content` text COMMENT '行政许可决定书（全文或摘要）',
  `publish_time` timestamp NULL DEFAULT NULL COMMENT '发布日期',
  `spider_id` bigint(20) DEFAULT NULL COMMENT '爬虫表数据记录id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注，若记录有变对应将原来的spiderid存入以便于追踪轨迹 如：123，345 由原来spider表的123，和345 两条更新过来这个记录对于表三条记录中spiderid对应最新的',
  `version` int(10) DEFAULT NULL COMMENT '版本号',
  `data_status` int(1) DEFAULT NULL COMMENT '数据状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='双公示-行政许可列表';

DROP TABLE IF EXISTS `credithunan_abnormal_notice`;
CREATE TABLE `credithunan_abnormal_notice` (
  `id` bigint(20) primary key auto_increment NOT NULL COMMENT '主键',
  `taxpayer` varchar(200) COMMENT '纳税人名称',
  `organize_code` varchar(100) COMMENT '组织机构代码',
  `legal_representative` varchar(128) COMMENT '法定代表人',
  `identity_card` varchar(20) COMMENT '身份证号码',
  `tax_authority` varchar(200) COMMENT '主管税务机关',
  `declaration_date` timestamp NULL COMMENT '公告日期',
  `affirm_date` timestamp NULL COMMENT '非正常户认定日期',
  `business_address` varchar(128) COMMENT '生产经营地址',
  `infomation_name` varchar(50) COMMENT '信息名称',
  `source` varchar(50) COMMENT '数据来源',
  `infomation_type` varchar(50) COMMENT '信息类型',
  `source_time` timestamp NULL COMMENT '信息资源更新时间',
  `spider_id` bigint COMMENT '爬虫表数据记录id',
  `create_time` timestamp NULL COMMENT '创建时间',
  `update_time` timestamp NULL COMMENT '更新时间',
  `remark` varchar(200) COMMENT '备注，若记录有变对应将原来的spiderid存入以便于追踪轨迹 如：123，345 由原来spider表的123，和345 两条更新过来这个记录对于表三条记录中spiderid对应最新的',
  `version` int(10) COMMENT '版本号',
  `data_status` int(1) COMMENT '数据状态'
) ENGINE=`InnoDB` CHARACTER SET utf8 COMMENT='非正常户公告信息';

-- 2018.11.12添加
delete from credithunan_abnormal_notice;
delete from spider_raw_data where type=4;
alter table credithunan_abnormal_notice modify declaration_date varchar(32) COMMENT '公告日期';
alter table credithunan_abnormal_notice modify affirm_date varchar(32) COMMENT '非正常户认定日期';

-- 2018.12.24添加
DROP TABLE IF EXISTS `qcc_trade_mark`;
CREATE TABLE `qcc_trade_mark` (
  `id` bigint(20) primary key auto_increment NOT NULL COMMENT '主键',
  `ent_name` varchar(64) DEFAULT NULL COMMENT '企业名称',
  `credit_code` varchar(64) DEFAULT NULL COMMENT '信用代码',
  `reg_no` varchar(64) DEFAULT NULL COMMENT '注册号',
  `name` varchar(128) DEFAULT NULL COMMENT '商标名',
  `category_id` int(11) DEFAULT NULL COMMENT '类别号',
  `category` varchar(32) DEFAULT NULL COMMENT '类别',
  `person` varchar(32) DEFAULT NULL COMMENT '申请人',
  `has_image` boolean DEFAULT NULL COMMENT '是否有图片',
  `flow` varchar(32) DEFAULT NULL COMMENT '商标续展',
  `image_url` varchar(1024) COMMENT '图片地址',
  `flow_status` varchar(32) NULL DEFAULT NULL COMMENT '流程状态代码',
  `flow_status_desc` varchar(32) DEFAULT NULL COMMENT '流程状态描述',
  `app_date` varchar(32) DEFAULT NULL COMMENT '申请日期',
  `status` varchar(16) DEFAULT NULL COMMENT '商标状态',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `version` varchar(16) DEFAULT NULL COMMENT '版本号',
  `data_status` int(1) DEFAULT NULL COMMENT '数据状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企查查-商标查询表';

-- 2019.2.18添加
DROP TABLE IF EXISTS `qcc_serious_violation`;
CREATE TABLE `qcc_serious_violation` (
  `id` bigint(20) primary key auto_increment NOT NULL COMMENT '主键',
  `ent_name` varchar(64) DEFAULT NULL COMMENT '企业名称',
  `credit_code` varchar(64) DEFAULT NULL COMMENT '信用代码',
  `type` varchar(64) DEFAULT NULL COMMENT '类型',
  `add_reason` varchar(512) DEFAULT NULL COMMENT '列入原因',
  `add_date` varchar(64) DEFAULT NULL COMMENT '列入时间',
  `add_office` varchar(64) DEFAULT NULL COMMENT '列入决定机关',
  `remove_reason` varchar(512) DEFAULT NULL COMMENT '移除原因',
  `remove_date` varchar(64) DEFAULT NULL COMMENT '移除时间',
  `remove_office` varchar(64) DEFAULT NULL COMMENT '移除决定机关',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `version` varchar(16) DEFAULT NULL COMMENT '版本号',
  `data_status` int(1) DEFAULT NULL COMMENT '数据状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企查查-严重违法信息表';
