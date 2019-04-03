CREATE TABLE `qcc_basic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ent_name` varchar(500) NOT NULL DEFAULT '' COMMENT '公司名称',
  `no` varchar(500) NOT NULL DEFAULT '' COMMENT '注册号',
  `belong_org` varchar(500) NOT NULL DEFAULT '' COMMENT '登记机关',
  `oper_name` varchar(500) NOT NULL DEFAULT '' COMMENT '法人',
  `start_date` varchar(500) NOT NULL DEFAULT '' COMMENT '成功日期',
  `end_date` varchar(500) NOT NULL DEFAULT '' COMMENT '吊销日期',
  `status` varchar(500) NOT NULL DEFAULT '' COMMENT '状态',
  `province` varchar(500) NOT NULL DEFAULT '' COMMENT '省份',
  `updated_date` varchar(500) NOT NULL DEFAULT '' COMMENT '更新日期',
  `credit_code` varchar(500) NOT NULL DEFAULT '' COMMENT '信用代码',
  `regist_capi` varchar(500) NOT NULL DEFAULT '' COMMENT '注册资本',
  `econ_kind` varchar(500) NOT NULL DEFAULT '' COMMENT '类型',
  `address` varchar(500) NOT NULL DEFAULT '' COMMENT '地址',
  `scope` varchar(500) NOT NULL DEFAULT '' COMMENT '营业范围',
  `term_start` varchar(500) NOT NULL DEFAULT '' COMMENT '营业期限始',
  `team_end` varchar(500) NOT NULL DEFAULT '' COMMENT '营业期限至',
  `check_date` varchar(500) NOT NULL DEFAULT '' COMMENT '发照日期',
  `org_no` varchar(500) NOT NULL DEFAULT '' COMMENT '组织机构代码',
  `is_on_stock` varchar(500) NOT NULL DEFAULT '' COMMENT '是否上市',
  `stock_number` varchar(500) NOT NULL DEFAULT '' COMMENT '证券号',
  `stock_type` varchar(500) NOT NULL DEFAULT '' COMMENT '证券类型',
  `image_url` varchar(500) NOT NULL DEFAULT '' COMMENT 'Logo地址',
  `data_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creator` varchar(500) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `updater` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企查查接口数据-企业关键字精确获取详细信息(Full)-基本信息';

CREATE TABLE `qcc_basic_permission_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ent_name` varchar(500) NOT NULL DEFAULT '' COMMENT '公司名称',
  `credit_code` varchar(500) NOT NULL DEFAULT '' COMMENT '信用代码',
  `name` varchar(500) NOT NULL DEFAULT '' COMMENT '项目名',
  `province` varchar(500) NOT NULL DEFAULT '' COMMENT '地域',
  `liandate` varchar(500) NOT NULL DEFAULT '' COMMENT '决定日期',
  `case_no` varchar(500) NOT NULL DEFAULT '' COMMENT '决定文书号',
  `data_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creator` varchar(500) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `updater` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企查查接口数据-企业关键字精确获取详细信息(Full)-行政许可【信用中国】';

CREATE TABLE `qcc_basic_penalty` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ent_name` varchar(500) NOT NULL DEFAULT '' COMMENT '公司名称',
  `credit_code` varchar(500) NOT NULL DEFAULT '' COMMENT '信用代码',
  `name` varchar(500) NOT NULL DEFAULT '' COMMENT '项目名',
  `doc_no` varchar(500) NOT NULL DEFAULT '' COMMENT '行政处罚决定书文号',
  `penalty_type` varchar(500) NOT NULL DEFAULT '' COMMENT '违法行为类型',
  `office_name` varchar(500) NOT NULL DEFAULT '' COMMENT '行政处罚决定机关名称',
  `content` varchar(500) NOT NULL DEFAULT '' COMMENT '行政处罚内容',
  `penalty_date` varchar(500) NOT NULL DEFAULT '' COMMENT '作出行政处罚决定日期',
  `public_date` varchar(500) NOT NULL DEFAULT '' COMMENT '作出行政公示日期',
  `remark` varchar(500) NOT NULL DEFAULT '' COMMENT '备注',
  `data_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creator` varchar(500) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `updater` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企查查接口数据-企业关键字精确获取详细信息(Full)-行政处罚';

CREATE TABLE `qcc_basic_shixin_items` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ent_name` varchar(500) NOT NULL DEFAULT '' COMMENT '公司名称',
  `credit_code` varchar(500) NOT NULL DEFAULT '' COMMENT '信用代码',
  `liandate` varchar(500) NOT NULL DEFAULT '' COMMENT '立案日期',
  `anno` varchar(500) NOT NULL DEFAULT '' COMMENT '立案文书号',
  `orgno` varchar(500) NOT NULL DEFAULT '' COMMENT '组织机构代码',
  `executeno` varchar(500) NOT NULL DEFAULT '' COMMENT '执行依据文号',
  `publicdate` varchar(500) NOT NULL DEFAULT '' COMMENT '发布时间',
  `executestatus` varchar(500) NOT NULL DEFAULT '' COMMENT '被执行人的履行情况',
  `actionremark` varchar(500) NOT NULL DEFAULT '' COMMENT '行为备注',
  `executegov` varchar(500) NOT NULL DEFAULT '' COMMENT '执行法院',
  `data_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creator` varchar(500) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `updater` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企查查接口数据-企业关键字精确获取详细信息(Full)-失信';

CREATE TABLE `qcc_basic_zhixing_items` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ent_name` varchar(500) NOT NULL DEFAULT '' COMMENT '公司名称',
  `credit_code` varchar(500) NOT NULL DEFAULT '' COMMENT '信用代码',
  `sourceid` varchar(500) NOT NULL DEFAULT '' COMMENT '官网系统ID',
  `liandate` varchar(500) NOT NULL DEFAULT '' COMMENT '立案时间',
  `anno` varchar(500) NOT NULL DEFAULT '' COMMENT '立案号',
  `execute_gov` varchar(500) NOT NULL DEFAULT '' COMMENT '执行法院',
  `biaodi` varchar(500) NOT NULL DEFAULT '' COMMENT '标地',
  `status` varchar(500) NOT NULL DEFAULT '' COMMENT '状态',
  `party_card_num` varchar(500) NOT NULL DEFAULT '' COMMENT '身份证号码/组织机构代码',
  `data_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creator` varchar(500) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `updater` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企查查接口数据-企业关键字精确获取详细信息(Full)-执行';

CREATE TABLE `qcc_basic_m_pledge` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ent_name` varchar(500) NOT NULL DEFAULT '' COMMENT '公司名称',
  `credit_code` varchar(500) NOT NULL DEFAULT '' COMMENT '信用代码',
  `register_no` varchar(500) NOT NULL DEFAULT '' COMMENT '登记编号',
  `register_date` varchar(500) NOT NULL DEFAULT '' COMMENT '登记时间',
  `public_date` varchar(500) NOT NULL DEFAULT '' COMMENT '公示时间',
  `register_office` varchar(500) NOT NULL DEFAULT '' COMMENT '登记机关',
  `debt_secured_amount` varchar(500) NOT NULL DEFAULT '' COMMENT '被担保债权数额',
  `status` varchar(500) NOT NULL DEFAULT '' COMMENT '状态',
  `data_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creator` varchar(500) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `updater` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企查查接口数据-企业关键字精确获取详细信息(Full)-动产抵押';

CREATE TABLE `qcc_basic_liquidation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ent_name` varchar(500) NOT NULL DEFAULT '' COMMENT '公司名称',
  `credit_code` varchar(500) NOT NULL DEFAULT '' COMMENT '信用代码',
  `leader` varchar(500) NOT NULL DEFAULT '' COMMENT '清算组负责人',
  `member` varchar(500) NOT NULL DEFAULT '' COMMENT '清算组成员',
  `data_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creator` varchar(500) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `updater` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企查查接口数据-企业关键字精确获取详细信息(Full)-清算';

CREATE TABLE `qcc_basic_pledge` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ent_name` varchar(500) NOT NULL DEFAULT '' COMMENT '公司名称',
  `credit_code` varchar(500) NOT NULL DEFAULT '' COMMENT '信用代码',
  `regist_no` varchar(500) NOT NULL DEFAULT '' COMMENT '质权登记编号',
  `pledgor` varchar(500) NOT NULL DEFAULT '' COMMENT '出质人',
  `pledgor_no` varchar(500) NOT NULL DEFAULT '' COMMENT '出质人证照编号',
  `pledgee` varchar(500) NOT NULL DEFAULT '' COMMENT '质权人',
  `pledgee_no` varchar(500) NOT NULL DEFAULT '' COMMENT '质权人证照编号',
  `pledged_amount` varchar(500) NOT NULL DEFAULT '' COMMENT '出质股权数额',
  `reg_date` varchar(500) NOT NULL DEFAULT '' COMMENT '股权出质设立登记日期',
  `public_date` varchar(500) NOT NULL DEFAULT '' COMMENT '公示时间',
  `status` varchar(500) NOT NULL DEFAULT '' COMMENT '出质状态',
  `data_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creator` varchar(500) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `updater` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企查查接口数据-企业关键字精确获取详细信息(Full)-股权出质';

CREATE TABLE `qcc_basic_spot_check` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ent_name` varchar(500) NOT NULL DEFAULT '' COMMENT '公司名称',
  `credit_code` varchar(500) NOT NULL DEFAULT '' COMMENT '信用代码',
  `no` varchar(500) NOT NULL DEFAULT '' COMMENT '登记编号',
  `executive_org` varchar(500) NOT NULL DEFAULT '' COMMENT '检查实施机关',
  `type` varchar(500) NOT NULL DEFAULT '' COMMENT '类型',
  `date` varchar(500) NOT NULL DEFAULT '' COMMENT '日期',
  `consequence` varchar(500) NOT NULL DEFAULT '' COMMENT '结果',
  `remark` varchar(500) NOT NULL DEFAULT '' COMMENT '备注',
  `data_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creator` varchar(500) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `updater` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企查查接口数据-企业关键字精确获取详细信息(Full)-抽查检查';

CREATE TABLE `qcc_basic_company_tax_credit_items` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ent_name` varchar(500) NOT NULL DEFAULT '' COMMENT '公司名称',
  `credit_code` varchar(500) NOT NULL DEFAULT '' COMMENT '信用代码',
  `no` varchar(500) NOT NULL DEFAULT '' COMMENT '纳税人识别号',
  `year` varchar(500) NOT NULL DEFAULT '' COMMENT '评价年度',
  `level`  varchar(500) NOT NULL DEFAULT '' COMMENT '信用等级',
  `data_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creator` varchar(500) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `updater` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企查查接口数据-企业关键字精确获取详细信息(Full)-纳税信用等级';

CREATE TABLE `qcc_basic_company_products` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ent_name` varchar(500) NOT NULL DEFAULT '' COMMENT '公司名称',
  `credit_code` varchar(500) NOT NULL DEFAULT '' COMMENT '信用代码',
  `link` varchar(500) NOT NULL DEFAULT '' COMMENT '企业的关联链接',
  `image_url` varchar(500) NOT NULL DEFAULT '' COMMENT '产品的图片',
  `name` varchar(500) NOT NULL DEFAULT '' COMMENT '产品名称',
  `domain` varchar(500) NOT NULL DEFAULT '' COMMENT '产品领域',
  `tags` varchar(500) NOT NULL DEFAULT '' COMMENT '产品标签',
  `description` varchar(500) NOT NULL DEFAULT '' COMMENT '产品描述',
  `category` varchar(500) NOT NULL DEFAULT '' COMMENT '产品类型',
  `data_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creator` varchar(500) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `updater` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企查查接口数据-企业关键字精确获取详细信息(Full)-公司产品';

CREATE TABLE `qcc_basic_permission_eciInfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ent_name` varchar(500) NOT NULL DEFAULT '' COMMENT '公司名称',
  `credit_code` varchar(500) NOT NULL DEFAULT '' COMMENT '信用代码',
  `licens_doc_no` varchar(500) NOT NULL DEFAULT '' COMMENT '许可文件编号',
  `licens_doc_name` varchar(500) NOT NULL DEFAULT '' COMMENT '许可文件名称',
  `validity_from` varchar(500) NOT NULL DEFAULT '' COMMENT '有效期自',
  `validity_to` varchar(500) NOT NULL DEFAULT '' COMMENT '有效期至',
  `licens_office` varchar(500) NOT NULL DEFAULT '' COMMENT '许可机关',
  `licens_content` varchar(500) NOT NULL DEFAULT '' COMMENT '许可内容',
  `data_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creator` varchar(500) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `updater` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企查查接口数据-企业关键字精确获取详细信息(Full)-行政许可【工商局】';

CREATE TABLE `qcc_basic_penalty_credit_china` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ent_name` varchar(500) NOT NULL DEFAULT '' COMMENT '公司名称',
  `credit_code` varchar(500) NOT NULL DEFAULT '' COMMENT '信用代码',
  `case_no` varchar(500) NOT NULL DEFAULT '' COMMENT '决定文书号',
  `liandate` varchar(500) NOT NULL DEFAULT '' COMMENT '决定日期',
  `province` varchar(500) NOT NULL DEFAULT '' COMMENT '地域',
  `owner_name` varchar(500) NOT NULL DEFAULT '' COMMENT '所属人',
  `case_reason` varchar(500) NOT NULL DEFAULT '' COMMENT '处罚事由',
  `data_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creator` varchar(500) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `updater` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企查查接口数据-企业关键字精确获取详细信息(Full)-行政处罚【信用中国';

CREATE TABLE `qcc_basic_partners` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ent_name` varchar(500) NOT NULL DEFAULT '' COMMENT '公司名称',
  `credit_code` varchar(500) NOT NULL DEFAULT '' COMMENT '信用代码',
  `stock_name` varchar(500) NOT NULL DEFAULT '' COMMENT '投资人',
  `stock_type` varchar(500) NOT NULL DEFAULT '' COMMENT '投资人类型',
  `stock_percent` varchar(500) NOT NULL DEFAULT '' COMMENT '出资比例',
  `should_capi` varchar(500) NOT NULL DEFAULT '' COMMENT '认缴出资额',
  `shoud_date` varchar(500) NOT NULL DEFAULT '' COMMENT '认缴出资时间',
  `invest_type` varchar(500) NOT NULL DEFAULT '' COMMENT '认出资方式',
  `invest_name` varchar(500) NOT NULL DEFAULT '' COMMENT '实出资方式',
  `real_capi` varchar(500) NOT NULL DEFAULT '' COMMENT '实缴出资额',
  `capi_date` varchar(500) NOT NULL DEFAULT '' COMMENT '实缴时间',
  `data_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creator` varchar(500) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `updater` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企查查接口数据-企业关键字精确获取详细信息(Full)-投资人及出资信息';

CREATE TABLE `qcc_basic_employees` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ent_name` varchar(500) NOT NULL DEFAULT '' COMMENT '公司名称',
  `credit_code` varchar(500) NOT NULL DEFAULT '' COMMENT '信用代码',
  `name` varchar(500) NOT NULL DEFAULT '' COMMENT '名称',
  `job` varchar(500) NOT NULL DEFAULT '' COMMENT '职位',
  `data_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creator` varchar(500) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `updater` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企查查接口数据-企业关键字精确获取详细信息(Full)-主要人员';

CREATE TABLE `qcc_basic_branches` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ent_name` varchar(500) NOT NULL DEFAULT '' COMMENT '公司名称',
  `credit_code` varchar(500) NOT NULL DEFAULT '' COMMENT '信用代码',
  `name` varchar(500) NOT NULL DEFAULT '' COMMENT '分支机构名称',
  `reg_no` varchar(500) NOT NULL DEFAULT '' COMMENT '注册号或社会统一信用代码（存在社会统一信用代码显示社会统一信用代码，否则显示注册号）',
  `belong_org` varchar(500) NOT NULL DEFAULT '' COMMENT '登记机关',
  `oper_name` varchar(500) NOT NULL DEFAULT '' COMMENT '法人姓名（保留字段，目前为空）',
  `data_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creator` varchar(500) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `updater` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企查查接口数据-企业关键字精确获取详细信息(Full)-分支机构';

CREATE TABLE `qcc_basic_change_records` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ent_name` varchar(500) NOT NULL DEFAULT '' COMMENT '公司名称',
  `credit_code` varchar(500) NOT NULL DEFAULT '' COMMENT '信用代码',
  `project_name` varchar(500) NOT NULL DEFAULT '' COMMENT '变更事项',
  `before_content` varchar(500) NOT NULL DEFAULT '' COMMENT '变更前内容',
  `after_content` varchar(500) NOT NULL DEFAULT '' COMMENT '变更后内容',
  `change_date` varchar(500) NOT NULL DEFAULT '' COMMENT '变更日期',
  `data_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creator` varchar(500) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `updater` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企查查接口数据-企业关键字精确获取详细信息(Full)-变更信息';

CREATE TABLE `qcc_basic_contact_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ent_name` varchar(500) NOT NULL DEFAULT '' COMMENT '公司名称',
  `credit_code` varchar(500) NOT NULL DEFAULT '' COMMENT '信用代码',
  `web_site` varchar(500) NOT NULL DEFAULT '' COMMENT '网址名称/地址，数组格式',
  `phone_number` varchar(500) NOT NULL DEFAULT '' COMMENT '联系电话',
  `email` varchar(500) NOT NULL DEFAULT '' COMMENT '邮箱',
  `data_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creator` varchar(500) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `updater` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企查查接口数据-企业关键字精确获取详细信息(Full)-联系信息';

CREATE TABLE `qcc_basic_industry` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ent_name` varchar(500) NOT NULL DEFAULT '' COMMENT '公司名称',
  `credit_code` varchar(500) NOT NULL DEFAULT '' COMMENT '信用代码',
  `industry_code` varchar(500) NOT NULL DEFAULT '' COMMENT '行业门类code',
  `industry` varchar(500) NOT NULL DEFAULT '' COMMENT '行业门类描述',
  `sub_industry_code` varchar(500) NOT NULL DEFAULT '' COMMENT '行业大类code',
  `sub_industry` varchar(500) NOT NULL DEFAULT '' COMMENT '行业大类描述',
  `middle_category_code` varchar(500) NOT NULL DEFAULT '' COMMENT '行业中类code',
  `middle_category` varchar(500) NOT NULL DEFAULT '' COMMENT '行业中类描述',
  `small_category_code` varchar(500) NOT NULL DEFAULT '' COMMENT '行业小类code',
  `small_category` varchar(500) NOT NULL DEFAULT '' COMMENT '行业小类描述',
  `data_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creator` varchar(500) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `updater` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企查查接口数据-企业关键字精确获取详细信息(Full)-行业分类数据';

CREATE TABLE `qcc_basic_original_name` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ent_name` varchar(500) NOT NULL DEFAULT '' COMMENT '公司名称',
  `credit_code` varchar(500) NOT NULL DEFAULT '' COMMENT '信用代码',
  `name`varchar(500) NOT NULL DEFAULT '' COMMENT '名称',
  `change_date`varchar(500) NOT NULL DEFAULT '' COMMENT '变更日期',
  `data_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creator` varchar(500) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `updater` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企查查接口数据-企业关键字精确获取详细信息(Full)-曾用名';

CREATE TABLE `qcc_basic_exceptions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ent_name` varchar(500) NOT NULL DEFAULT '' COMMENT '公司名称',
  `credit_code` varchar(500) NOT NULL DEFAULT '' COMMENT '信用代码',
  `add_reason`varchar(500) NOT NULL DEFAULT '' COMMENT '列入经营异常名录原因',
  `add_date`varchar(500) NOT NULL DEFAULT '' COMMENT '列入日期',
  `romove_reason`varchar(500) NOT NULL DEFAULT '' COMMENT '移出经营异常名录原因',
  `remove_date`varchar(500) NOT NULL DEFAULT '' COMMENT '移出日期',
  `decision_office`varchar(500) NOT NULL DEFAULT '' COMMENT '作出决定机关',
  `remove_decision_office`varchar(500) NOT NULL DEFAULT '' COMMENT '移除决定机关',
  `data_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creator` varchar(500) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `updater` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企查查接口数据-企业关键字精确获取详细信息(Full)-经营异常';



