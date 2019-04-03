ALTER TABLE `high_tech_zone_enterprise_info` ADD `score` VARCHAR(10) COMMENT '天眼查得分';
ALTER TABLE `high_tech_zone_enterprise_info` ADD `version` INTEGER(10) default 0 COMMENT '版本号';

ALTER TABLE `high_tech_zone_enterprise_info` ADD `old_enterprise_id` INTEGER(11) default 0 COMMENT '旧企业ID';
ALTER TABLE `high_tech_zone_enterprise_info` ADD `new_name`  varchar(500) DEFAULT NULL COMMENT '新企业名称';
ALTER TABLE `high_tech_zone_enterprise_info` ADD `new_enterprise_id` INTEGER(11) default 0 COMMENT '新企业ID';
ALTER TABLE `high_tech_zone_enterprise_info` ADD `tag_list`  varchar(500) DEFAULT NULL COMMENT '标签列表';
ALTER TABLE `high_tech_zone_enterprise_info` ADD `history_list`  varchar(500) DEFAULT NULL COMMENT '曾用名列表';


ALTER TABLE `rpt_tn_person` ADD `url`  varchar(500) DEFAULT NULL COMMENT '天眼查地址';

ALTER TABLE `rpt_tn_shareholders` ADD `url`  VARCHAR(500) DEFAULT NULL COMMENT '天眼查地址';
ALTER TABLE `rpt_tn_shareholders` ADD `is_max`  VARCHAR(10) DEFAULT NULL COMMENT '是否大股东';

ALTER TABLE `rpt_tn_invest` ADD `url`  VARCHAR(500) DEFAULT NULL COMMENT '天眼查地址';
ALTER TABLE `rpt_tn_branches` ADD `url`  VARCHAR(500) DEFAULT NULL COMMENT '天眼查企业地址';

ALTER TABLE `rpt_tn_basic_info` ADD `version` INTEGER(10) default 0 COMMENT '版本号';
ALTER TABLE `rpt_tn_announcementcourt` ADD `a_id`  VARCHAR(50) DEFAULT NULL COMMENT '';
ALTER TABLE `rpt_tn_announcementcourt` ADD `search_type`  VARCHAR(50) DEFAULT NULL COMMENT '搜索类别';
ALTER TABLE `rpt_tn_announcementcourt` ADD `litigant`  VARCHAR(100) DEFAULT NULL COMMENT '';
ALTER TABLE `rpt_tn_announcementcourt` ADD `type`  VARCHAR(50) DEFAULT NULL COMMENT '';
ALTER TABLE `rpt_tn_announcementcourt` ADD `conn_list`  VARCHAR(1000) DEFAULT NULL COMMENT '';
ALTER TABLE `rpt_tn_announcementcourt` ADD `contractors`  VARCHAR(200) DEFAULT NULL COMMENT '';
ALTER TABLE `rpt_tn_announcementcourt` ADD `event_time`  VARCHAR(100) DEFAULT NULL COMMENT '';

ALTER TABLE `rpt_tn_court_notice` ADD `cn_id`  VARCHAR(50) DEFAULT NULL COMMENT '';


CREATE TABLE `rpt_tn_judicial_aid` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  `executed_person` varchar(10) DEFAULT NULL COMMENT '被执行人',
  `equity_amount_other` varchar(30) DEFAULT NULL COMMENT '股权数额',
  `executive_court` varchar(50) DEFAULT NULL COMMENT '执行法院',
  `execute_notice_num` varchar(60) DEFAULT NULL COMMENT '执行通知文号',
  `executed_person_type` varchar(60) DEFAULT NULL COMMENT '类型|状态',
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9068 DEFAULT CHARSET=utf8 COMMENT='企业-司法协助信息';


ALTER TABLE `rpt_tn_penalties` ADD `legal_person_name`  VARCHAR(50) DEFAULT NULL COMMENT '法人姓名';

ALTER TABLE `rpt_tn_equity` ADD `base`  VARCHAR(100) DEFAULT NULL COMMENT '';
ALTER TABLE `rpt_tn_equity` ADD `pledgee_str`  VARCHAR(500) DEFAULT NULL COMMENT '';


CREATE TABLE `rpt_tn_mortgage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  `equity_amount` varchar(10) DEFAULT NULL COMMENT '',
  `put_date` varchar(30) DEFAULT NULL COMMENT '',
  `pledgor_str` varchar(50) DEFAULT NULL COMMENT '',
  `reg_date` varchar(500) DEFAULT NULL COMMENT '',
  `state` varchar(500) DEFAULT NULL COMMENT '',
  `certif_number` varchar(500) DEFAULT NULL COMMENT '',
  `reg_number` varchar(500) DEFAULT NULL COMMENT '',
  `pledgee` varchar(500) DEFAULT NULL COMMENT '',
  `company_list` varchar(500) DEFAULT NULL COMMENT '',
  `pledgee_list` varchar(500) DEFAULT NULL COMMENT '',
  `pledgor_list` varchar(500) DEFAULT NULL COMMENT '',
  `base` varchar(500) DEFAULT NULL COMMENT '',
  `pledgor` varchar(500) DEFAULT NULL COMMENT '',
  `certif_number_r` varchar(500) DEFAULT NULL COMMENT '',
  `pledgee_str` varchar(500) DEFAULT NULL COMMENT '',
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企业-动产抵押信息';



CREATE TABLE `rpt_tn_certificate` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  `type` varchar(10) DEFAULT NULL COMMENT '证书类型',
  `cert_no` varchar(30) DEFAULT NULL COMMENT '证书编号',
  `publish_date` varchar(50) DEFAULT NULL COMMENT '发证日期',
  `deadline_date` varchar(500) DEFAULT NULL COMMENT '截止日期',
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企业-资质证书信息';


CREATE TABLE `rpt_tn_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
  `name` varchar(500) DEFAULT NULL COMMENT '产品名称',
  `shortName` varchar(500) DEFAULT NULL COMMENT '产品简称',
  `type` varchar(500) DEFAULT NULL COMMENT '产品分类',
  `zone` varchar(500) DEFAULT NULL COMMENT '领域',
  
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企业-产品信息';




CREATE TABLE `rpt_tn_bond` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  `b_id` varchar(10) DEFAULT NULL COMMENT '',
  `bond_name` varchar(30) DEFAULT NULL COMMENT '',
  `bond_num` varchar(50) DEFAULT NULL COMMENT '',
  `publisher_name` varchar(500) DEFAULT NULL COMMENT '',
  `bond_type` varchar(500) DEFAULT NULL COMMENT '',
  `publish_time` varchar(500) DEFAULT NULL COMMENT '',
  `publish_expire_time` varchar(500) DEFAULT NULL COMMENT '',
  `bond_time_limit` varchar(500) DEFAULT NULL COMMENT '',
  `bond_trade_time` varchar(500) DEFAULT NULL COMMENT '',
  `cal_interest_type` varchar(500) DEFAULT NULL COMMENT '',
  `bond_stop_time` varchar(500) DEFAULT NULL COMMENT '',
  `credit_rating_gov` varchar(500) DEFAULT NULL COMMENT '',
  `debt_rating` varchar(500) DEFAULT NULL COMMENT '',
  `face_value` varchar(500) DEFAULT NULL COMMENT '',
  `ref_interest_rate` varchar(500) DEFAULT NULL COMMENT '',
  
  `face_interest_rate` varchar(500) DEFAULT NULL COMMENT '',
  `real_issued_quantity` varchar(500) DEFAULT NULL COMMENT '',
  `plan_issued_quantity` varchar(500) DEFAULT NULL COMMENT '',
  `issued_price` varchar(500) DEFAULT NULL COMMENT '',
  `interest_diff` varchar(500) DEFAULT NULL COMMENT '',
  `pay_interest_hZ` varchar(500) DEFAULT NULL COMMENT '',
  `start_cal_interest_time` varchar(500) DEFAULT NULL COMMENT '',
  `exe_right_type` varchar(500) DEFAULT NULL COMMENT '',
  `exe_right_time` varchar(500) DEFAULT NULL COMMENT '',
  `escrow_agent` varchar(500) DEFAULT NULL COMMENT '',
  `flow_range` varchar(500) DEFAULT NULL COMMENT '',
  `remark` varchar(500) DEFAULT NULL COMMENT '',
  `tip` varchar(500) DEFAULT NULL COMMENT '',
  `b_create_time` varchar(500) DEFAULT NULL COMMENT '',
  `b_update_time` varchar(500) DEFAULT NULL COMMENT '',
  `is_delete` varchar(500) DEFAULT NULL COMMENT '',
  
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企业-债券信息';



CREATE TABLE `rpt_tn_purchaseland` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
  `pl_id` varchar(10) DEFAULT NULL COMMENT '',
  `admin_region` varchar(30) DEFAULT NULL COMMENT '',
  `elec_supervisor_no` varchar(50) DEFAULT NULL COMMENT '',
  `signed_date` varchar(500) DEFAULT NULL COMMENT '',
  `total_area` varchar(500) DEFAULT NULL COMMENT '',
  `location` varchar(500) DEFAULT NULL COMMENT '',
  `assignee` varchar(500) DEFAULT NULL COMMENT '',
  `parent_company` varchar(500) DEFAULT NULL COMMENT '',
  `purpose` varchar(500) DEFAULT NULL COMMENT '',
  `supply_way` varchar(500) DEFAULT NULL COMMENT '',
  `min_volume` varchar(500) DEFAULT NULL COMMENT '',
  `max_volume` varchar(500) DEFAULT NULL COMMENT '',
  `deal_price` varchar(500) DEFAULT NULL COMMENT '',
  `start_time` varchar(500) DEFAULT NULL COMMENT '',
  `link_url` varchar(500) DEFAULT NULL COMMENT '',
  `end_time` varchar(500) DEFAULT NULL COMMENT '',
  `pl_create_time` varchar(50) NULL DEFAULT NULL COMMENT '创建时间',
  `pl_update_time` varchar(50) NULL DEFAULT NULL COMMENT '修改时间',
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企业-购地信息';


CREATE TABLE `rpt_tn_licensing_xyzg` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
  `validity_time` varchar(50) DEFAULT NULL COMMENT '',
  `licence_number` varchar(50) DEFAULT NULL COMMENT '',
  `department` varchar(50) DEFAULT NULL COMMENT '',
  `licence_content` varchar(500) DEFAULT NULL COMMENT '',
  `end_date` varchar(500) DEFAULT NULL COMMENT '',
  `audi_type` varchar(500) DEFAULT NULL COMMENT '',
  `decision_date` varchar(500) DEFAULT NULL COMMENT '',
  `legal_person_name` varchar(500) DEFAULT NULL COMMENT '',
  `cid` varchar(500) DEFAULT NULL COMMENT '',
  `local_code` varchar(500) DEFAULT NULL COMMENT '',
  `legal_person_id` varchar(500) DEFAULT NULL COMMENT '',
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企业-行政处罚[信用中国]';

ALTER TABLE rpt_tn_icp ADD `site_name` VARCHAR(200) DEFAULT NULL COMMENT '网站名称';