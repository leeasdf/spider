DROP TABLE IF EXISTS `rpt_tn_basic_info`;
CREATE TABLE `rpt_tn_basic_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
  `reg_no` varchar(80) DEFAULT NULL COMMENT '工商注册号',
  `ent_type` varchar(120) DEFAULT NULL COMMENT '公司类型',
  `industry_phy_name` varchar(80) DEFAULT NULL COMMENT '行业',
  `ide_num` varchar(20) DEFAULT NULL COMMENT '纳税人识别号',
  `cre_code` varchar(20) DEFAULT NULL COMMENT '统一信用代码',
  `eng_name` varchar(120) DEFAULT NULL COMMENT '英文名称',
  `org_code` varchar(12) DEFAULT NULL COMMENT '组织机构代码',
  `reg_authority` varchar(300) DEFAULT NULL COMMENT '登记机关',
  `ope_period` varchar(40) DEFAULT NULL COMMENT '营业期限',
  `app_date` varchar(10) DEFAULT NULL COMMENT '核准日期',
  `reg_address` varchar(300) DEFAULT NULL COMMENT '注册地址',
  `bus_scope` varchar(2500) DEFAULT NULL COMMENT '经营范围',
  `cmp_name` varchar(200) DEFAULT NULL COMMENT '公司名称',
  `reg_time` varchar(10) DEFAULT NULL COMMENT '注册时间',
  `legal_person` varchar(70) DEFAULT NULL COMMENT '法人姓名',
  `reg_cap` varchar(60) DEFAULT NULL COMMENT '注册资本',
  `status` varchar(60) DEFAULT NULL COMMENT '公司状态',
  
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='工商基本信息';

DROP TABLE IF EXISTS `rpt_tn_branches`;
CREATE TABLE `rpt_tn_branches` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业（机构）名称',
  
  `reg_time` varchar(20) DEFAULT NULL COMMENT '注册时间',
  `legal_person` varchar(200) DEFAULT NULL COMMENT '被投资法定代表人',
  `cmp_name` varchar(200) DEFAULT NULL COMMENT '公司名',
  `status` varchar(60) DEFAULT NULL COMMENT '经营状态',
  
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='分支机构';


DROP TABLE IF EXISTS `rpt_tn_change`;
CREATE TABLE `rpt_tn_change` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
  `change_date` varchar(15) DEFAULT NULL COMMENT '案号',
  `change_after` varchar(9000) DEFAULT NULL COMMENT '变更后',
  `change_item` varchar(600) DEFAULT NULL COMMENT '变更项',
  `change_before` varchar(9000) DEFAULT NULL COMMENT '变更前',
  
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企业变更记录';

DROP TABLE IF EXISTS `rpt_tn_invest`;
CREATE TABLE `rpt_tn_invest` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业（机构）名称',
  
  `reg_time` varchar(10) DEFAULT NULL COMMENT '注册时间',
  `legal_person` varchar(200) DEFAULT NULL COMMENT '被投资法定代表人',
  `inv_amount` varchar(40) DEFAULT NULL COMMENT '投资数额',
  `cmp_name` varchar(200) DEFAULT NULL COMMENT '公司名',
  `inv_ratio` varchar(40) DEFAULT NULL COMMENT '投资占比',
  `status` varchar(50) DEFAULT NULL COMMENT '经营状态',
  `reg_cap` varchar(120) DEFAULT NULL COMMENT '注册资本',
  
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='对外投资';

DROP TABLE IF EXISTS `rpt_tn_lawsuit`;
CREATE TABLE `rpt_tn_lawsuit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
  `date` varchar(80) DEFAULT NULL COMMENT '日期',
  `referee` varchar(1000) DEFAULT NULL COMMENT '裁判文书',
  `reason` varchar(100) DEFAULT NULL COMMENT '案由',
  `identity` varchar(1000) DEFAULT NULL COMMENT '案件身份',
  `case_num` varchar(180) DEFAULT NULL COMMENT '案件号',
  `plaintiff` varchar(800) DEFAULT NULL COMMENT '-',
  `defendant` varchar(800) DEFAULT NULL COMMENT '-',
  
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='法律诉讼信息';


DROP TABLE IF EXISTS `rpt_tn_patent`;
CREATE TABLE `rpt_tn_patent` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
  `app_date` varchar(10) DEFAULT NULL COMMENT '申请公布日期',
  `name` varchar(200) DEFAULT NULL COMMENT '专利名称',
  `app_num` varchar(120) DEFAULT NULL COMMENT '申请号',
  `app_pub_num` varchar(20) DEFAULT NULL COMMENT '申请公开号',
  `app_type` varchar(20) DEFAULT NULL COMMENT '专利类型',
  
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='专利信息';

DROP TABLE IF EXISTS `rpt_tn_penalties`;
CREATE TABLE `rpt_tn_penalties` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
  `decision_date` varchar(10) DEFAULT NULL COMMENT '决定日期',
  `punish_number` varchar(100) DEFAULT NULL COMMENT '决定文书号',
  `type` varchar(3000) DEFAULT NULL COMMENT '类型',
  `department_name` varchar(120) DEFAULT NULL COMMENT '决定机关',
  `content` varchar(2000) DEFAULT NULL COMMENT '处罚内容',
  `area_name` varchar(20) DEFAULT NULL COMMENT '地域',
  `punishment_name` varchar(220) DEFAULT NULL COMMENT '处罚名称',
  
  `reg_num` varchar(500) DEFAULT NULL COMMENT '注册号',
  `name` varchar(500) DEFAULT NULL COMMENT '处罚公司名称',
  `publish_date` varchar(30) DEFAULT NULL COMMENT '发布日期',
  `base` varchar(30) DEFAULT NULL COMMENT '地点',
  
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='行政处罚信息';

DROP TABLE IF EXISTS `rpt_tn_person`;
CREATE TABLE `rpt_tn_person` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `job` varchar(80) DEFAULT NULL COMMENT '职务',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='主要人员';




DROP TABLE IF EXISTS `rpt_tn_shareholders`;
CREATE TABLE `rpt_tn_shareholders` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业（机构）名称',
  
  `name` varchar(120) DEFAULT NULL COMMENT '姓名',
  `fun_ratio` varchar(25) DEFAULT NULL COMMENT '出资比例',
  `sub_funding` varchar(120) DEFAULT NULL COMMENT '认缴出资',
  `amount_date` varchar(20) DEFAULT NULL COMMENT '出资时间',
  
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='股东信息';


DROP TABLE IF EXISTS `rpt_tn_software_right`;
CREATE TABLE `rpt_tn_software_right` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
  `app_date` varchar(10) DEFAULT NULL COMMENT '批准日期',
  `fullname` varchar(200) DEFAULT NULL COMMENT '软件全称',
  `simple_name` varchar(100) DEFAULT NULL COMMENT '软件简称',
  `regnum` varchar(15) DEFAULT NULL COMMENT '登记号',
  `catnum` varchar(15) DEFAULT NULL COMMENT '分类号',
  `version` varchar(18) DEFAULT NULL COMMENT '版本号',
  `author` varchar(1000) DEFAULT NULL COMMENT '著作详情信息',
  
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='软件著作权信息';

DROP TABLE IF EXISTS `rpt_tn_software_right_author`;
CREATE TABLE `rpt_tn_software_right_author` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_ame` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
  `fullname` varchar(200) DEFAULT NULL COMMENT '软件全称',
  `simplename` varchar(100) DEFAULT NULL COMMENT '软件简称',
  `regnum` varchar(15) DEFAULT NULL COMMENT '登记号',
  `catnum` varchar(15) DEFAULT NULL COMMENT '分类号',
  `version` varchar(18) DEFAULT NULL COMMENT '版本号',
  
  `author_nationality` varchar(1000) DEFAULT NULL COMMENT '著作权人(国籍)',
  `publishtime` varchar(10) DEFAULT NULL COMMENT '首次发表日期',
  `regtime` varchar(10) DEFAULT NULL COMMENT '登记日期',
  
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='软件著作人详情信息';

DROP TABLE IF EXISTS `rpt_tn_trademark`;
CREATE TABLE `rpt_tn_trademark` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
  `app_date` varchar(10) DEFAULT NULL COMMENT '申请日期',
  `name` varchar(200) DEFAULT NULL COMMENT '商标名称',
  `app_num` varchar(60) DEFAULT NULL COMMENT '注册号',
  `category` varchar(50) DEFAULT NULL COMMENT '类别',
  `process_status` varchar(100) DEFAULT NULL COMMENT '流程状态',
  
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='商标信息';

DROP TABLE IF EXISTS `rpt_tn_works_right`;
CREATE TABLE `rpt_tn_works_right` (
	`enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  `title` varchar(200) DEFAULT NULL COMMENT '作品名称',
  `regnum` varchar(50) DEFAULT NULL COMMENT '登记号',
  `category` varchar(60) DEFAULT NULL COMMENT '类别',
  `finish_date` varchar(10) DEFAULT NULL COMMENT '创作完成日期',
  `regtime` varchar(10) DEFAULT NULL COMMENT '登记日期',
  `publishtime` varchar(10) DEFAULT NULL COMMENT '首次发布日期',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='作品著作权信息';


DROP TABLE IF EXISTS `rpt_tn_owing_tax`;
CREATE TABLE `rpt_tn_owing_tax` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
	`public_date` varchar(10) DEFAULT NULL COMMENT '发布日期',
	`tax_no` varchar(20) DEFAULT NULL COMMENT '纳税人识别号',
	`owe_tax_type` varchar(120) DEFAULT NULL COMMENT '欠税税种',
	`current_owe_tax_amount` varchar(50) DEFAULT NULL COMMENT '当前发生的欠税额',
	`own_tax_balance` varchar(50) DEFAULT NULL COMMENT '欠税余额',
	`tax_depart` varchar(50) DEFAULT NULL COMMENT '税务机关',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='欠税信息';

DROP TABLE IF EXISTS `rpt_tn_dishonest`;
CREATE TABLE `rpt_tn_dishonest` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
  `regdate` varchar(10) DEFAULT NULL COMMENT '立案日期',
  `casecode` varchar(50) DEFAULT NULL COMMENT '案号',
  `courtname` varchar(80) DEFAULT NULL COMMENT ' 执行法院',
  `performance` varchar(20) DEFAULT NULL COMMENT '履行状态',
  `gistid` varchar(120) DEFAULT NULL COMMENT '执行依据文号',

  `date` VARCHAR(20) DEFAULT NULL COMMENT '立案日期',
`type` VARCHAR(10) DEFAULT NULL COMMENT '失信人类型',
`result` VARCHAR(1000) DEFAULT NULL COMMENT '执行法院结果',
`iname` VARCHAR(120) DEFAULT NULL COMMENT '名称',
`businessentity` VARCHAR(50) DEFAULT NULL COMMENT '法定代表人',
`areaname` VARCHAR(15) DEFAULT NULL COMMENT '省份',
`cardnum` VARCHAR(25) DEFAULT NULL COMMENT '身份证号/组织机构代码',
`publishdate` VARCHAR(10) DEFAULT NULL COMMENT '发布时间',
`gistunit` VARCHAR(80) DEFAULT NULL COMMENT '做出执行依据单位',
`duty` VARCHAR(3000) DEFAULT NULL COMMENT '法律生效文书确定的义务',
`disrupttypename` VARCHAR(120) DEFAULT NULL COMMENT '失信被执行人为具体情形',


  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='失信人信息';

DROP TABLE IF EXISTS `rpt_tn_illegal`;
CREATE TABLE `rpt_tn_illegal` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
	`date` varchar(10) DEFAULT NULL COMMENT '列入日期',
	`reason` varchar(100) DEFAULT NULL COMMENT '列入原因',
	`agency` varchar(200) DEFAULT NULL COMMENT '决定机关',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='严重违法信息';


DROP TABLE IF EXISTS `rpt_tn_abnormal`;
CREATE TABLE `rpt_tn_abnormal` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
  `date` varchar(10) DEFAULT NULL COMMENT '列入日期',
  `reason` varchar(300) DEFAULT NULL COMMENT '列入原因',
  `agency` varchar(200) DEFAULT NULL COMMENT '决定机关',
  `remove_date` varchar(10) DEFAULT NULL COMMENT '移除日期',
  `remove_reason` varchar(300) DEFAULT NULL COMMENT '移除原因',
  `remove_agency` varchar(200) DEFAULT NULL COMMENT '移除机关',
  
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='经营异常信息';

DROP TABLE IF EXISTS `rpt_tn_zhixing`;
CREATE TABLE `rpt_tn_zhixing` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
	`date` varchar(10) DEFAULT NULL COMMENT '立案日期',
	`target` varchar(30) DEFAULT NULL COMMENT '执行标的',
	`case_no` varchar(50) DEFAULT NULL COMMENT '案号',
	`court` varchar(60) DEFAULT NULL COMMENT '执行法院',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='被执行人信息';

DROP TABLE IF EXISTS `rpt_tn_court_notice`;
CREATE TABLE `rpt_tn_court_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
  `publishdate` varchar(10) DEFAULT NULL COMMENT '公告日期',
  `party1` varchar(800) DEFAULT NULL COMMENT '上诉方',
  `party2` varchar(800) DEFAULT NULL COMMENT ' 被诉方',
  `bltntypename` varchar(40) DEFAULT NULL COMMENT '公告类型',
  `courtcode` varchar(80) DEFAULT NULL COMMENT '法院',
  `content` varchar(4000) DEFAULT NULL COMMENT '公告内容',

	`announce_id` varchar(15) DEFAULT NULL COMMENT '天眼查法院公告ID',
	`reason` varchar(4000) DEFAULT NULL COMMENT '公告内容',
	`bltnno` varchar(20) DEFAULT NULL COMMENT '公告编号',
	`bltnstate` varchar(10) DEFAULT NULL COMMENT '公告状态',
	`judgephone` varchar(40) DEFAULT NULL COMMENT '被诉方联系号码',
	`dealgradename` varchar(300) DEFAULT NULL COMMENT '被诉方名称',
	`dealgrade` varchar(300) DEFAULT NULL COMMENT '被诉方',
	`province` varchar(15) DEFAULT NULL COMMENT '省份',
	`bltntype` varchar(10) DEFAULT NULL COMMENT '公告类型',
	`showtxtdate` varchar(4000) DEFAULT NULL COMMENT '展示文本日期',
	`tmpsaversn` varchar(3000) DEFAULT NULL COMMENT '临时存储序号',
	`publishpage` varchar(30) DEFAULT NULL COMMENT '公告页',
	`party2Str` varchar(2000) DEFAULT NULL COMMENT '被诉方字符串',
	`tyc_id` varchar(100) DEFAULT NULL COMMENT 'tycId',
	`judge` varchar(100) DEFAULT NULL COMMENT '判决人',
	`party1Str` varchar(500) DEFAULT NULL COMMENT '上诉方字符串',
	
	`caseno` varchar(80) DEFAULT NULL COMMENT '-',
	`courtflag` varchar(50) DEFAULT NULL COMMENT '-',
	`customno` varchar(100) DEFAULT NULL COMMENT '-',
	`mobilephone` varchar(100) DEFAULT NULL COMMENT '-',
	`company_list` varchar(500) DEFAULT NULL COMMENT '-',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='法院公告信息';

DROP TABLE IF EXISTS `rpt_tn_announcementcourt`;
CREATE TABLE `rpt_tn_announcementcourt` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
	`start_date` varchar(20) DEFAULT NULL COMMENT '开庭日期',
	`plaintiff` varchar(500) DEFAULT NULL COMMENT '原告/上诉人',
	`defendant` varchar(800) DEFAULT NULL COMMENT '被告/被上诉人',
	`case_reason` varchar(800) DEFAULT NULL COMMENT '案由',
	
	`court` varchar(200) DEFAULT NULL COMMENT '法院',
	`courtroom` varchar(100) DEFAULT NULL COMMENT '法庭',
	`case_no` varchar(60) DEFAULT NULL COMMENT '案号',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='开庭公告';


DROP TABLE IF EXISTS `rpt_tn_icp`;
CREATE TABLE `rpt_tn_icp` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
	`unit_properties` varchar(100) DEFAULT NULL COMMENT '单位性质',
	`approve_date` varchar(50) DEFAULT NULL COMMENT '审核时间',
	`domain_name` varchar(100) DEFAULT NULL COMMENT '域名',
	`regnum` varchar(200) DEFAULT NULL COMMENT '网站名称',
	`record_no` varchar(200) DEFAULT NULL COMMENT '备案号',
	`homepage` varchar(500) DEFAULT NULL COMMENT '网站首页',
	`status` varchar(30) DEFAULT NULL COMMENT '状态',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='网站备案信息';


DROP TABLE IF EXISTS `rpt_tn_check`;
CREATE TABLE `rpt_tn_check` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
	`date` varchar(20) DEFAULT NULL COMMENT '日期',
	`result` varchar(1000) DEFAULT NULL COMMENT '结果',
	`agency` varchar(100) DEFAULT NULL COMMENT '检查实施机关',
	`type` varchar(20) DEFAULT NULL COMMENT '类型',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='抽查检查信息';


DROP TABLE IF EXISTS `rpt_tn_tax_credit`;
CREATE TABLE `rpt_tn_tax_credit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
	`tax_level` varchar(2) DEFAULT NULL COMMENT '纳税评级',
	`tax_no` varchar(50) DEFAULT NULL COMMENT '纳税人识别号',
	`agency` varchar(200) DEFAULT NULL COMMENT '评价单位',
	`type` varchar(15) DEFAULT NULL COMMENT '类别',
	`years` varchar(15) DEFAULT NULL COMMENT '年份',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='税务评级信息';


DROP TABLE IF EXISTS `rpt_tn_bid`;
CREATE TABLE `rpt_tn_bid` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
	`purchaser` varchar(200) DEFAULT NULL COMMENT '采购人',
	`title` varchar(600) DEFAULT NULL COMMENT '标题',
	`publish_date` varchar(10) DEFAULT NULL COMMENT '发布时间',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='招投标信息';

DROP TABLE IF EXISTS `rpt_tn_equity`;
CREATE TABLE `rpt_tn_equity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  
	`equity_amount` varchar(40) DEFAULT NULL COMMENT '出质金额',
	`put_date` varchar(10) DEFAULT NULL COMMENT '公告时间',
	`publish_date` varchar(10) DEFAULT NULL COMMENT '发布时间',
	`pledgor_str` varchar(200) DEFAULT NULL COMMENT '质权人网址页',
	`reg_date` varchar(10) DEFAULT NULL COMMENT '申请时间',
	`state` varchar(10) DEFAULT NULL COMMENT '状态',
	`certif_number` varchar(15) DEFAULT NULL COMMENT '质权人号码',
	`reg_number` varchar(60) DEFAULT NULL COMMENT '登记编号',
	`pledgee` varchar(150) DEFAULT NULL COMMENT '质权人',
	`company_list` varchar(200) DEFAULT NULL COMMENT '企业列表',
	`pledgee_list` varchar(150) DEFAULT NULL COMMENT '质权人列表',
	`pledgor_list` varchar(150) DEFAULT NULL COMMENT '出质人列表',
	`pledgor` varchar(100) DEFAULT NULL COMMENT '出质人',
	`certif_number_r` varchar(20) DEFAULT NULL COMMENT '出质人证件号码',
	`pledgeeStr` varchar(200) DEFAULT NULL COMMENT '出质人王志业',
	
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='股权质押信息';

DROP TABLE IF EXISTS `rpt_tn_import_export`;
CREATE TABLE `rpt_tn_import_export` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',

	`industry_category` varchar(80) DEFAULT NULL COMMENT '行业种类',
	`annual_report` varchar(30) DEFAULT NULL COMMENT '年报情况',
	`status` varchar(10) DEFAULT NULL COMMENT '海关注销标识',
	`administrative_division` varchar(50) DEFAULT NULL COMMENT '行政区划',
	`management_category` varchar(50) DEFAULT NULL COMMENT '经营类别',
	`customs_registered_address` varchar(30) DEFAULT NULL COMMENT '注册海关',
	`validity_date` varchar(10) DEFAULT NULL COMMENT '报关有效期',
	`economic_division` varchar(50) DEFAULT NULL COMMENT '经济区划',
	`record_date` varchar(10) DEFAULT NULL COMMENT '注册日期',
	`cr_code` varchar(10) DEFAULT NULL COMMENT '海关注册号',
	`special_trade_area` varchar(30) DEFAULT NULL COMMENT '特殊贸易区域',
	`types` varchar(100) DEFAULT NULL COMMENT '跨境贸易电子商务类型',
		
	`credit_rating` varchar(300) DEFAULT NULL COMMENT '信用登记',
	`sanction` varchar(1000) DEFAULT NULL COMMENT 'sanction',
	
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='进出口信息';

DROP TABLE IF EXISTS `tyc_page_record`;
CREATE TABLE `tyc_page_record` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `biz_id` varchar(1000) DEFAULT NULL COMMENT '业务ID',
  `enterprise_id` INT(11) DEFAULT NULL COMMENT '企业主键',
  `ent_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  `data_type` INT(11) NOT NULL COMMENT '翻页类型',
  `page_total` INT(11) NOT NULL COMMENT '翻页总条数',
  `page_num` INT(11) NOT NULL COMMENT '翻页页码数',
  `status` VARCHAR(15) NULL COMMENT '状态',
  `create_time` TIMESTAMP NULL COMMENT '创建时间',
  `update_time` TIMESTAMP NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT '天眼查分页记录表';

-- api日志表
DROP TABLE IF EXISTS `api_log`;
CREATE TABLE `api_log` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `biz_id` VARCHAR(100) NOT NULL COMMENT '业务ID',
  `req_info` VARCHAR(1000) NOT NULL COMMENT '请求信息',
  `req_id` VARCHAR(100) NOT NULL COMMENT '请求ID',
  `channel_type` VARCHAR(30) NOT NULL COMMENT '通道类型',
  `resp_info` varchar(8000) NULL COMMENT '返回信息',
  `resp_code` VARCHAR(15) NULL COMMENT '返回码',
  `resp_message` VARCHAR(500) NULL COMMENT '返回信息',
  `status` VARCHAR(15) NULL COMMENT '状态',
  `create_time` TIMESTAMP NULL COMMENT '创建时间',
  `update_time` TIMESTAMP NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT 'API日志表';


/*
DROP TABLE IF EXISTS `tyc_task_record`;
CREATE TABLE `tyc_task_record` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `biz_id` varchar(1000) DEFAULT NULL COMMENT '业务ID',  
  `task_type` varchar(100) DEFAULT NULL COMMENT '企业名称',
  
  `data_type` INT(11) NOT NULL COMMENT '翻页类型',
  `page_total` INT(11) NOT NULL COMMENT '翻页总条数',
  `page_num` INT(11) NOT NULL COMMENT '翻页页码数',
  `status` VARCHAR(15) NULL COMMENT '状态',
  `create_time` TIMESTAMP NULL COMMENT '创建时间',
  `update_time` TIMESTAMP NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT '天眼查任务记录表';
*/

ALTER TABLE high_tech_zone_enterprise_info MODIFY enterprise_name VARCHAR(200) DEFAULT NULL COMMENT '企业名称';
alter table `high_tech_zone_enterprise_info` add `reg_time` varchar(30) COMMENT '注册时间';
alter table `high_tech_zone_enterprise_info` add `tyc_enterpriseId` varchar(30) COMMENT '天眼查企业ID';
alter table `high_tech_zone_enterprise_info` add `legal_person_name` varchar(300) COMMENT '企业法人';
alter table `high_tech_zone_enterprise_info` add `status` varchar(100) COMMENT '企业状态';
alter table `high_tech_zone_enterprise_info` add `data_source` varchar(300) COMMENT '数据来源';
alter table `high_tech_zone_enterprise_info` add `web_site` varchar(100) COMMENT '官网网址';
alter table `high_tech_zone_enterprise_info` add `address` varchar(100) COMMENT '地址';
alter table `high_tech_zone_enterprise_info` add `phones` varchar(200) COMMENT '联系电话列表';
alter table `high_tech_zone_enterprise_info` add `email` varchar(100) COMMENT '电子邮箱';
alter table `high_tech_zone_enterprise_info` add `content` varchar(3000) COMMENT '简介';
alter table `high_tech_zone_enterprise_info` add `rename_flag` varchar(2) COMMENT '更名标识';
alter table `high_tech_zone_enterprise_info` add `old_name` varchar(500) COMMENT '历史名称';
ALTER TABLE `high_tech_zone_enterprise_info` ADD `remark` VARCHAR(500) COMMENT '备注';
ALTER TABLE `high_tech_zone_enterprise_info` ADD COLUMN `tyc_update_time` VARCHAR(20) DEFAULT NULL COMMENT '出资时间';


CREATE UNIQUE INDEX ent_base_ent_name ON high_tech_zone_enterprise_info(enterprise_name);
CREATE UNIQUE INDEX rpt_basic_ent_name ON rpt_tn_basic_info(ent_name); 
