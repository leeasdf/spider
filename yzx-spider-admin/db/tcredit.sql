-- 处理开始
-- 接口
DROP TABLE IF EXISTS `tc_rpt_base_info`;
CREATE TABLE `tc_rpt_base_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `entname` varchar(100) DEFAULT NULL COMMENT '企业名称',
  `regno` varchar(100) DEFAULT NULL COMMENT '注册号',
  `oriregno` varchar(100) DEFAULT NULL COMMENT '原注册号',
  `frname` varchar(100) DEFAULT NULL COMMENT '法定代表人姓名',
  `regcap` varchar(100) DEFAULT NULL COMMENT '注册资本',
  `reccap` varchar(100) DEFAULT NULL COMMENT '实收资本(万元)',
  `regcapcur` varchar(100) DEFAULT NULL COMMENT '币种',
  `entstatus` varchar(100) DEFAULT NULL COMMENT '经营状态',
  `enttype` varchar(100) DEFAULT NULL COMMENT '企业(机构)类型',
  `esdate` varchar(100) DEFAULT NULL COMMENT '开业日期',
  `opfrom` varchar(100) DEFAULT NULL COMMENT '经营期限自',
  `opto` varchar(100) DEFAULT NULL COMMENT '经营期限至',
  `dom` varchar(100) DEFAULT NULL COMMENT '住址',
  `regorg` varchar(100) DEFAULT NULL COMMENT '登记机关',
  `abuitem` varchar(1000) DEFAULT NULL COMMENT '许可经营项目',
  `cbuitem` varchar(1000) DEFAULT NULL COMMENT '一般经营项目',
  `opscope` varchar(2000) DEFAULT NULL COMMENT '经营(业务)范围',
  `opscoandform` varchar(2000) DEFAULT NULL COMMENT '经营(业务)范围及方式',
  `ancheyear` varchar(100) DEFAULT NULL COMMENT '最后年检年度',
  `changedate` varchar(100) DEFAULT NULL COMMENT '变更日期',
  `candate` varchar(100) DEFAULT NULL COMMENT '注销日期',
  `revdate` varchar(100) DEFAULT NULL COMMENT '吊销日期',
  `anchedate` varchar(100) DEFAULT NULL COMMENT '最后年检日期',
  `industryphycode` varchar(100) DEFAULT NULL COMMENT '行业门类代码',
  `industryphyname` varchar(100) DEFAULT NULL COMMENT '行业门类名称',
  `industrycocode` varchar(100) DEFAULT NULL COMMENT '国民经济行业代码',
  `industryconame` varchar(100) DEFAULT NULL COMMENT '国民经济行业名称',
  `creditcode` varchar(100) DEFAULT NULL COMMENT '信用代码',
  `regorgprovince` varchar(100) DEFAULT NULL COMMENT '注册机构所在省份',
  `tel` varchar(100) DEFAULT NULL COMMENT '电话',
  `empnum` varchar(100) DEFAULT NULL COMMENT '员工人数',
  `industryphyall` varchar(100) DEFAULT NULL COMMENT '',
  `industrycoall` varchar(100) DEFAULT NULL COMMENT '',
  `entnameeng` varchar(100) DEFAULT NULL COMMENT '',
  `regorgcode` varchar(100) DEFAULT NULL COMMENT '组织机构代码',
  `zsopscope` varchar(100) DEFAULT NULL COMMENT '',
  `domdistrict` varchar(100) DEFAULT NULL COMMENT '',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_企业工商信息';

DROP TABLE IF EXISTS `tc_rpt_shareholder_info`;
CREATE TABLE `tc_rpt_shareholder_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `shaname` varchar(100) DEFAULT NULL COMMENT '股东名称',
  `subconam` varchar(200) DEFAULT NULL COMMENT '认缴出资额(万元)',
  `regcapcur` varchar(30) DEFAULT NULL COMMENT '认缴出资币种',
  `conform` varchar(200) DEFAULT NULL COMMENT '出资方式',
  `fundedratio` varchar(200) DEFAULT NULL COMMENT '出资比例',
  `condate` varchar(20) DEFAULT NULL COMMENT '出资日期',
  `country` varchar(100) DEFAULT NULL COMMENT '国别',
  `invamount` varchar(30) DEFAULT NULL COMMENT '股东总数量',
  `invsumfundedratio` varchar(100) DEFAULT NULL COMMENT '股东出资比例总和',
  `sumconam` varchar(30) DEFAULT NULL COMMENT '任职出资额总和(万元)',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_股东信息';

DROP TABLE IF EXISTS `tc_rpt_person_info`;
CREATE TABLE `tc_rpt_person_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `pername` varchar(100) DEFAULT NULL COMMENT '姓名',
  `position` varchar(100) DEFAULT NULL COMMENT '职位',
  `sex` varchar(20) DEFAULT NULL COMMENT '性别',
  `personamount` varchar(30) DEFAULT NULL COMMENT '总人数',
  `natdate` varchar(20) DEFAULT NULL COMMENT '',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_高管信息(收费)';

DROP TABLE IF EXISTS `tc_rpt_manager_info`;
CREATE TABLE `tc_rpt_manager_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `pername` varchar(100) DEFAULT NULL COMMENT '姓名',
  `position` varchar(100) DEFAULT NULL COMMENT '职位',
  `sex` varchar(20) DEFAULT NULL COMMENT '性别',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_高管信息(免费)';

DROP TABLE IF EXISTS `tc_rpt_frinv_info`;
CREATE TABLE `tc_rpt_frinv_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `name` varchar(200) DEFAULT NULL COMMENT '法定代表人姓名',
  `entname` varchar(200) DEFAULT NULL COMMENT '企业(机构)名称',
  `regno` varchar(200) DEFAULT NULL COMMENT '注册号',
  `enttype` varchar(200) DEFAULT NULL COMMENT '企业(机构)类型',
  `regcap` varchar(200) DEFAULT NULL COMMENT '注册资本(万元)',
  `regcapcur` varchar(200) DEFAULT NULL COMMENT '注册资本币种',
  `entstatus` varchar(200) DEFAULT NULL COMMENT '企业状态',
  `candate` varchar(200) DEFAULT NULL COMMENT '注销日期',
  `revdate` varchar(200) DEFAULT NULL COMMENT '吊销日期',
  `regorg` varchar(200) DEFAULT NULL COMMENT '登记机关',
  `subconam` varchar(200) DEFAULT NULL COMMENT '认缴出资额(万元)',
  `currency` varchar(200) DEFAULT NULL COMMENT '认缴出资币种',
  `conform` varchar(200) DEFAULT NULL COMMENT '出资方式',
  `fundedratio` varchar(200) DEFAULT NULL COMMENT '出资比例',
  `esdate` varchar(200) DEFAULT NULL COMMENT '开业日期',
  `regorgcode` varchar(200) DEFAULT NULL COMMENT '注册机构编码',
  `pinvamount` varchar(200) DEFAULT NULL COMMENT '',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='法人对外投资信息';

DROP TABLE IF EXISTS `tc_rpt_frposition_info`;
CREATE TABLE `tc_rpt_frposition_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `name` varchar(200) DEFAULT NULL COMMENT '法定代表人姓名',
  `entname` varchar(200) DEFAULT NULL COMMENT '企业(机构)名称',
  `regno` varchar(200) DEFAULT NULL COMMENT '注册号',
  `enttype` varchar(200) DEFAULT NULL COMMENT '企业(机构)类型',
  `regcap` varchar(200) DEFAULT NULL COMMENT '注册资本(万元)',
  `regcapcur` varchar(200) DEFAULT NULL COMMENT '注册资本币种',
  `entstatus` varchar(200) DEFAULT NULL COMMENT '企业状态',
  `candate` varchar(200) DEFAULT NULL COMMENT '注销日期',
  `revdate` varchar(200) DEFAULT NULL COMMENT '吊销日期',
  `regorg` varchar(200) DEFAULT NULL COMMENT '登记机关',
  `position` varchar(200) DEFAULT NULL COMMENT '职务',
  `lerepsign` varchar(200) DEFAULT NULL COMMENT '是否法定代表人',
  `esdate` varchar(200) DEFAULT NULL COMMENT '开业日期',
	`regorgcode` varchar(200) DEFAULT NULL COMMENT '注册机构编码',
  `ppvamount` varchar(200) DEFAULT NULL COMMENT '',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='法人在外其他企业任职信息';

DROP TABLE IF EXISTS `tc_rpt_entinv_info`;
CREATE TABLE `tc_rpt_entinv_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `entname` varchar(200) DEFAULT NULL COMMENT '企业(机构)名称',
  `regno` varchar(200) DEFAULT NULL COMMENT '注册号',
  `enttype` varchar(200) DEFAULT NULL COMMENT '企业(机构)类型',
  `regcap` varchar(200) DEFAULT NULL COMMENT '注册资本(万元)',
  `regcapcur` varchar(200) DEFAULT NULL COMMENT '注册资本币种',
  `entstatus` varchar(200) DEFAULT NULL COMMENT '企业状态',
  `candate` varchar(200) DEFAULT NULL COMMENT '注销日期',
  `revdate` varchar(200) DEFAULT NULL COMMENT '吊销日期',
  `regorg` varchar(200) DEFAULT NULL COMMENT '登记机关',
  `subconam` varchar(200) DEFAULT NULL COMMENT '认缴出资额(万元)',
  `congrocur` varchar(200) DEFAULT NULL COMMENT '认缴出资币种',
  `conform` varchar(200) DEFAULT NULL COMMENT '出资方式',
  `fundedratio` varchar(200) DEFAULT NULL COMMENT '出资比例',
  `binvvamount` varchar(200) DEFAULT NULL COMMENT '企业总数量',
  `name` varchar(200) DEFAULT NULL COMMENT '法定代表人姓名',
  `regorgcode` varchar(200) DEFAULT NULL COMMENT '注册机构编码',
  `esdate` varchar(200) DEFAULT NULL COMMENT '',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_企业对外投资信息';

DROP TABLE IF EXISTS `tc_rpt_alter_info`;
CREATE TABLE `tc_rpt_alter_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `altdate` varchar(200) DEFAULT NULL COMMENT '变更日期',
  `altitem` varchar(1000) DEFAULT NULL COMMENT '变更项',
  `altbe` varchar(5000) DEFAULT NULL COMMENT '变更前',
  `altaf` varchar(5000) DEFAULT NULL COMMENT '变更后',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_企业工商变更信息';

DROP TABLE IF EXISTS `tc_rpt_filiation_info`;
CREATE TABLE `tc_rpt_filiation_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `brname` varchar(100) DEFAULT NULL COMMENT '分支机构名称',
  `brregno` varchar(100) DEFAULT NULL COMMENT '分支机构企业注册号',
  `brprincipal` varchar(100) DEFAULT NULL COMMENT '分支机构负责人',
  `cbuitem` varchar(100) DEFAULT NULL COMMENT '一般经营项目',
  `braddr` varchar(200) DEFAULT NULL COMMENT '分支机构地址',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_企业分支机构';

DROP TABLE IF EXISTS `tc_rpt_sharesimpawn_info`;
CREATE TABLE `tc_rpt_sharesimpawn_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `imporg` varchar(100) DEFAULT NULL COMMENT '质权人姓名',
  `imporgtype` varchar(100) DEFAULT NULL COMMENT '出质人类别',
  `impam` varchar(100) DEFAULT NULL COMMENT '出质金额（万元）',
  `imponrecdate` varchar(100) DEFAULT NULL COMMENT '出质备案日期',
  `impexaeep` varchar(100) DEFAULT NULL COMMENT '出质审批部门',
  `impsandate` varchar(100) DEFAULT NULL COMMENT '出质批准日期',
  `impto` varchar(100) DEFAULT NULL COMMENT '出质截至日期',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_股权出质历史信息';

DROP TABLE IF EXISTS `tc_rpt_mordetail_info`;
CREATE TABLE `tc_rpt_mordetail_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `imporg` varchar(100) DEFAULT NULL COMMENT '质权人姓名',
  `imporgtype` varchar(100) DEFAULT NULL COMMENT '出质人类别',
  `impam` varchar(100) DEFAULT NULL COMMENT '出质金额（万元）',
  `imponrecdate` varchar(100) DEFAULT NULL COMMENT '出质备案日期',
  `impexaeep` varchar(100) DEFAULT NULL COMMENT '出质审批部门',
  `impsandate` varchar(100) DEFAULT NULL COMMENT '出质批准日期',
  `impto` varchar(100) DEFAULT NULL COMMENT '出质截至日期',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_动产抵押物信息';

DROP TABLE IF EXISTS `tc_rpt_morguainfo_info`;
CREATE TABLE `tc_rpt_morguainfo_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `morreg_id` varchar(100) DEFAULT NULL COMMENT '抵押ID',
  `guaname` varchar(100) DEFAULT NULL COMMENT '抵押物名称',
  `quan` varchar(100) DEFAULT NULL COMMENT '数量',
  `value` varchar(100) DEFAULT NULL COMMENT '价值(万元)',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_动产抵押物信息';

DROP TABLE IF EXISTS `tc_rpt_punishbreak_info`;
CREATE TABLE `tc_rpt_punishbreak_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `casecode` varchar(100) DEFAULT NULL COMMENT '案号',
  `inameclean` varchar(100) DEFAULT NULL COMMENT '被执行人姓名/名称',
  `type` varchar(100) DEFAULT NULL COMMENT '失信人类型',
  `sexyclean` varchar(100) DEFAULT NULL COMMENT '性别',
  `ageclean` varchar(100) DEFAULT NULL COMMENT '年龄',
  `cardnum` varchar(100) DEFAULT NULL COMMENT '身份证号码/工商注册号',
  `ysfzd` varchar(100) DEFAULT NULL COMMENT '身份证原始发证地',
  `businessentity` varchar(100) DEFAULT NULL COMMENT '法定代表人/负责人姓名',
  `regdateclean` varchar(100) DEFAULT NULL COMMENT '立案时间',
  `publishdateclean` varchar(100) DEFAULT NULL COMMENT '公布时间',
  `courtname` varchar(100) DEFAULT NULL COMMENT '执行法院',
  `areanameclean` varchar(100) DEFAULT NULL COMMENT '省份',
  `gistid` varchar(100) DEFAULT NULL COMMENT '执行依据文号',
  `gistunit` varchar(100) DEFAULT NULL COMMENT '做出执行依据单位',
  `duty` varchar(100) DEFAULT NULL COMMENT '生效法律文书确定的义务',
  `disrupttypename` varchar(100) DEFAULT NULL COMMENT '失信被执行人行为具体情形',
  `performance` varchar(100) DEFAULT NULL COMMENT '被执行人的履行情况',
  `performedpart` varchar(100) DEFAULT NULL COMMENT '已履行',
  `unperformpart` varchar(100) DEFAULT NULL COMMENT '未履行',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_失信人信息';


DROP TABLE IF EXISTS `tc_rpt_punished_info`;
CREATE TABLE `tc_rpt_punished_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `casecode` varchar(100) DEFAULT NULL COMMENT '案号',
  `inameclean` varchar(100) DEFAULT NULL COMMENT '被执行人姓名/名称',
  `cardnum` varchar(100) DEFAULT NULL COMMENT '身份证号码/工商注册号',
  `sexyclean` varchar(100) DEFAULT NULL COMMENT '性别',
  `ageclean` varchar(100) DEFAULT NULL COMMENT '年龄',
  `areanameclean` varchar(100) DEFAULT NULL COMMENT '省份',
  `ysfzd` varchar(100) DEFAULT NULL COMMENT '身份证原始发证地',
  `courtname` varchar(100) DEFAULT NULL COMMENT '执行法院',
  `regdateclean` varchar(100) DEFAULT NULL COMMENT '立案时间',
  `casestate` varchar(100) DEFAULT NULL COMMENT '案件状态',
  `execmoney` varchar(100) DEFAULT NULL COMMENT '执行标的（元）',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_被执行人信息';

DROP TABLE IF EXISTS `tc_rpt_liquidation_info`;
CREATE TABLE `tc_rpt_liquidation_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `ligentity` varchar(100) DEFAULT NULL COMMENT '清算责任人',
  `ligprincipal` varchar(100) DEFAULT NULL COMMENT '清算负责人',
  `liqmen` varchar(100) DEFAULT NULL COMMENT '清算组成员',
  `ligst` varchar(100) DEFAULT NULL COMMENT '清算完结情况',
  `ligenddate` varchar(100) DEFAULT NULL COMMENT '清算完结日期',
  `debttranee` varchar(100) DEFAULT NULL COMMENT '债务承接人',
  `claimtranee` varchar(100) DEFAULT NULL COMMENT '债权承接人',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_清算信息';

DROP TABLE IF EXISTS `tc_rpt_case_info`;
CREATE TABLE `tc_rpt_case_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `casetime` varchar(100) DEFAULT NULL COMMENT '案发时间',
  `casereason` varchar(100) DEFAULT NULL COMMENT '案由',
  `caseval` varchar(100) DEFAULT NULL COMMENT '案值',
  `casetype` varchar(100) DEFAULT NULL COMMENT '案件类型',
  `exesort` varchar(100) DEFAULT NULL COMMENT '执行类别',
  `caseresult` varchar(100) DEFAULT NULL COMMENT '案件结果',
  `pendecno` varchar(100) DEFAULT NULL COMMENT '处罚决定文书',
  `pendecissdate` varchar(100) DEFAULT NULL COMMENT '处罚决定书签发日期',
  `penauth` varchar(100) DEFAULT NULL COMMENT '作出行政处罚决定机关名称',
  `illegfact` varchar(100) DEFAULT NULL COMMENT '主要违法事实',
  `penbasis` varchar(100) DEFAULT NULL COMMENT '处罚依据',
  `pentype` varchar(100) DEFAULT NULL COMMENT '处罚种类',
  `penresult` varchar(100) DEFAULT NULL COMMENT '处罚结果',
  `penam` varchar(100) DEFAULT NULL COMMENT '处罚金额',
  `penexest` varchar(100) DEFAULT NULL COMMENT '处罚执行情况',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_行政处罚信息';


DROP TABLE IF EXISTS `tc_rpt_sharesfrost_info`;
CREATE TABLE `tc_rpt_sharesfrost_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `frodocno` varchar(100) DEFAULT NULL COMMENT '冻结文号',
  `froauth` varchar(100) DEFAULT NULL COMMENT '冻结机关',
  `frofrom` varchar(100) DEFAULT NULL COMMENT '冻结起始日期',
  `froto` varchar(100) DEFAULT NULL COMMENT '冻结截至日期',
  `froam` varchar(100) DEFAULT NULL COMMENT '冻结金额（万元）',
  `thawauth` varchar(100) DEFAULT NULL COMMENT '解冻机关',
  `thawdocno` varchar(100) DEFAULT NULL COMMENT '解冻文号',
  `thawdate` varchar(100) DEFAULT NULL COMMENT '解冻日期',
  `thawcomment` varchar(100) DEFAULT NULL COMMENT ' 解冻说明',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_股权冻结历史信息';


DROP TABLE IF EXISTS `tc_rpt_reposer_info`;
CREATE TABLE `tc_rpt_reposer_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `ryname` varchar(100) DEFAULT NULL COMMENT '查询人姓名',
  `entname` varchar(100) DEFAULT NULL COMMENT '企业(机构)名称',
  `regno` varchar(100) DEFAULT NULL COMMENT '注册号',
  `enttype` varchar(100) DEFAULT NULL COMMENT '企业(机构)类型',
  `regcap` varchar(100) DEFAULT NULL COMMENT '注册资本(万元)',
  `regcapcur` varchar(100) DEFAULT NULL COMMENT '注册资本币种',
  `entstatus` varchar(100) DEFAULT NULL COMMENT '企业状态',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_企业法人信息';

DROP TABLE IF EXISTS `tc_rpt_rypossha_info`;
CREATE TABLE `tc_rpt_rypossha_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `ryname` varchar(100) DEFAULT NULL COMMENT '查询人姓名',
  `entname` varchar(100) DEFAULT NULL COMMENT '企业(机构)名称',
  `regno` varchar(100) DEFAULT NULL COMMENT '注册号',
  `enttype` varchar(100) DEFAULT NULL COMMENT '企业(机构)类型',
  `regcap` varchar(100) DEFAULT NULL COMMENT '注册资本(万元)',
  `regcapcur` varchar(100) DEFAULT NULL COMMENT '注册资本币种',
  `entstatus` varchar(100) DEFAULT NULL COMMENT '企业状态',
  `subconam` varchar(100) DEFAULT NULL COMMENT '认缴出资额(万元)',
  `currency` varchar(100) DEFAULT NULL COMMENT '认缴出资币种',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_企业股东信息';


DROP TABLE IF EXISTS `tc_rpt_ryposper_info`;
CREATE TABLE `tc_rpt_ryposper_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `ryname` varchar(100) DEFAULT NULL COMMENT '查询⼈姓名',
  `entname` varchar(100) DEFAULT NULL COMMENT '企业(机构)名称',
  `regno` varchar(100) DEFAULT NULL COMMENT '注册号',
  `enttype` varchar(100) DEFAULT NULL COMMENT '企业(机构)类型',
  `regcap` varchar(100) DEFAULT NULL COMMENT '注册资本(万元)',
  `regcapcur` varchar(100) DEFAULT NULL COMMENT '注册资本币种',
  `entstatus` varchar(100) DEFAULT NULL COMMENT '企业状态',
  `position` varchar(100) DEFAULT NULL COMMENT '职务',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_企业主要管理人员信息';

DROP TABLE IF EXISTS `tc_rpt_tax_info`;
CREATE TABLE `tc_rpt_tax_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '信用报告ID',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `year` varchar(10) DEFAULT NULL COMMENT '所属年度',
  `org_code` varchar(50) DEFAULT NULL COMMENT '机构代码',
  `ename` varchar(100) DEFAULT NULL COMMENT '机构代码',
  `oper_revenue` varchar(50) DEFAULT NULL COMMENT '营业收入',
  `main_oper_revenue` varchar(50) DEFAULT NULL COMMENT '主营业务收入',
  `other_oper_revenue` varchar(50) DEFAULT NULL COMMENT '其他业务收入',
  `oper_cost` varchar(50) DEFAULT NULL COMMENT '营业成本',
  `main_oper_cost` varchar(50) DEFAULT NULL COMMENT '主营业务成本',
  `other_oper_cost` varchar(50) DEFAULT NULL COMMENT '其他业务成本',
  `busi_tax_surcharges` varchar(50) DEFAULT NULL COMMENT '营业税金及附加信息',
  `admin_expense` varchar(50) DEFAULT NULL COMMENT '管理费用',
  `oper_expense` varchar(50) DEFAULT NULL COMMENT '销售费用',
  `finance_expense` varchar(50) DEFAULT NULL COMMENT '财务费用',
  `assets_loss` varchar(50) DEFAULT NULL COMMENT '财产减值损失',
  `oper_profit` varchar(50) DEFAULT NULL COMMENT '营业利润',
  `non_busi_income` varchar(50) DEFAULT NULL COMMENT '营业外收入',
  `non_busi_expense` varchar(50) DEFAULT NULL COMMENT '营业外支出',
  `total_profit_loss` varchar(50) DEFAULT NULL COMMENT '利润（亏损）总额',
  `pers_income_tax` varchar(50) DEFAULT NULL COMMENT '所得税',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_企业税收信息';

DROP TABLE IF EXISTS `tc_rpt_copyright_info`;
CREATE TABLE `tc_rpt_copyright_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `full_name` varchar(200) DEFAULT NULL COMMENT '软件全称',
  `version` varchar(20) DEFAULT NULL COMMENT '版本号',
  `register_code` varchar(100) DEFAULT NULL COMMENT '登记号',
  `classify_code` varchar(100) DEFAULT NULL COMMENT '分类号',
  `register_date` varchar(30) DEFAULT NULL COMMENT '申请时间',
  `short_name` varchar(100) DEFAULT NULL COMMENT '软件简称',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_企业知识产权_著作权信息';

DROP TABLE IF EXISTS `tc_rpt_trademark_info`;
CREATE TABLE `tc_rpt_trademark_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `name` varchar(500) DEFAULT NULL comment '商标名称',
  `category` varchar(200) DEFAULT NULL comment '商标类型',
  `register_num` varchar(100) DEFAULT NULL COMMENT '注册号',
  `status` varchar(1000) DEFAULT NULL COMMENT '商标状态',
  `apply_date` varchar(30) DEFAULT NULL COMMENT '申请时间',
  `is_share` varchar(100) DEFAULT NULL COMMENT '是否共有',

  `company_id` varchar(100) DEFAULT NULL comment 'API企业ID',
  `publish` varchar(100) DEFAULT NULL comment '',
  `img` varchar(100) DEFAULT NULL comment '',
  `launch_date` varchar(100) DEFAULT NULL comment '注册公告日期',
  `launch_num` varchar(100) DEFAULT NULL comment '注册公告期号',
  `applicant_cn_name` varchar(100) DEFAULT NULL comment '申请人名称(中)',
  `applicant_en_name` varchar(100) DEFAULT NULL comment '申请人名称(英)',
  `address` varchar(100) DEFAULT NULL comment '申请人地址',
  `url` varchar(100) DEFAULT NULL comment '商标查看地址',
  `agent_org` varchar(100) DEFAULT NULL comment '代理人名称',
  `limit_start` varchar(100) DEFAULT NULL comment '专利权期限开始日期',
  `limit_end` varchar(100) DEFAULT NULL comment '专利权期限截止日期',
  `init_verify_date` varchar(100) DEFAULT NULL comment '初审公告日期',
  `init_verify_num` varchar(100) DEFAULT NULL comment '初审公告期号',
  `product_list` varchar(500) DEFAULT NULL comment '商品服务列表',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_企业知识产权_商标信息';

DROP TABLE IF EXISTS `tc_rpt_patents_info`;
CREATE TABLE `tc_rpt_patents_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
 	`enterprise_id` int(11) DEFAULT NULL COMMENT '企业ID',

  `title` varchar(100) DEFAULT NULL COMMENT '专利名称',
  `type` varchar(20) DEFAULT NULL COMMENT '专利类型',
  `patent_number` varchar(100) DEFAULT NULL COMMENT '申请号',
  `pub_num` varchar(100) DEFAULT NULL COMMENT '公布号',
  `apply_date` varchar(30) DEFAULT NULL COMMENT '申请时间',
  `pub_date` varchar(100) DEFAULT NULL COMMENT '发布日期',
  `summary` varchar(2000) DEFAULT NULL COMMENT '摘要',

  `company_id` varchar(100) DEFAULT NULL comment 'API企业ID',
  `main_class_code` varchar(100) DEFAULT NULL comment '主分类号',
  `class_code` varchar(100) DEFAULT NULL comment '分类号',
  `designer` varchar(100) DEFAULT NULL comment '发明人',
  `address` varchar(100) DEFAULT NULL comment '地址',
  `applicant` varchar(100) DEFAULT NULL comment '申请者',
  `agent_org` varchar(100) DEFAULT NULL comment '专利代理机构',
  `agent` varchar(100) DEFAULT NULL comment '代理机构',
  `intel_pub` varchar(100) DEFAULT NULL comment '国际公布',
  `intel_apply` varchar(100) DEFAULT NULL comment '国际申请',
  `into_china_date` varchar(100) DEFAULT NULL comment '进⼊国家⽇期',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_企业知识产权_专利信息';

DROP TABLE IF EXISTS `tc_rpt_person_bad_info`;
CREATE TABLE `tc_rpt_person_bad_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',

  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `idcard` varchar(100) DEFAULT NULL COMMENT '身份证号码',
  `case_source` varchar(500) DEFAULT NULL COMMENT '案发来源',
  `case_time` varchar(500) DEFAULT NULL COMMENT '案发时间',
  `case_type` varchar(500) DEFAULT NULL COMMENT '案件类型',
  `crime_type` varchar(500) DEFAULT NULL COMMENT '涉案类型',
  
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='天创_个人不良信息';

DROP TABLE IF EXISTS `tc_rpt_litigation_statistics`;
CREATE TABLE `tc_rpt_litigation_statistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `key_id` int(11) DEFAULT NULL COMMENT '企业ID/个人ID',

	`type` varchar(100) DEFAULT NULL COMMENT '涉诉类型 1-企业 2-个人',
	`key1` varchar(100) DEFAULT NULL COMMENT '企业全称/姓名',
	`key2` varchar(100) DEFAULT NULL COMMENT '企业组织结构代码/身份证号码',
  `totalCount` varchar(100) DEFAULT NULL COMMENT '所有信息数量',
  `totalPageNum` varchar(10) DEFAULT NULL COMMENT '所有信息总页码数',
  `pageNo` varchar(100) DEFAULT NULL COMMENT '当前页码数',
  `range` varchar(100) DEFAULT NULL comment '每页数量',
  `cpwsCount` varchar(100) DEFAULT NULL COMMENT '信息数量',
  `cpwsPageNum` varchar(100) DEFAULT NULL COMMENT '信息总页码数',
  `ktggCount` varchar(100) DEFAULT NULL COMMENT '开庭公告信息数量',
  `ktggPageNum` varchar(100) DEFAULT NULL COMMENT '开庭公告信息总页码数',
  `zxggCount` varchar(100) DEFAULT NULL COMMENT '执⾏公告信息数量',
  `zxggPageNum` varchar(200) DEFAULT NULL COMMENT '执行公告信息总页码数',
  `sxggCount` varchar(100) DEFAULT NULL COMMENT '失信公告信息数量',
  `sxggPageNum` varchar(100) DEFAULT NULL COMMENT '失信公告信息总页码数',
  `fyggCount` varchar(100) DEFAULT NULL COMMENT '法院公告信息数量',
  `fyggPageNum` varchar(100) DEFAULT NULL COMMENT '法院公告信息总页码数',
  `wdhmdCount` varchar(100) DEFAULT NULL COMMENT '网贷黑名单信息数量',
  `wdhmdPageNum` varchar(100) DEFAULT NULL COMMENT '网贷黑名单信息总页码数',
  `ajlcCount` varchar(100) DEFAULT NULL COMMENT '案件流程信息数量',
  `ajlcPageNum` varchar(100) DEFAULT NULL COMMENT '案件流程信息总页码数',
  
  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_企业涉诉信息总表';

DROP TABLE IF EXISTS `tc_rpt_litigation_info`;
CREATE TABLE `tc_rpt_litigation_info`(
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	
	`statistics_id` int(11) DEFAULT NULL COMMENT '统计ID',
	`return_id` varchar(20) DEFAULT NULL COMMENT '返回ID',
	`data_type` varchar(10) DEFAULT NULL COMMENT 'cpws裁判文书/ktgg开庭公告/zxgg执行公告/sxgg失信公告/fygg法院公告/wdhmd网贷黑名单/bgt曝光台',
	`title` varchar(100) DEFAULT NULL COMMENT '标题',
	`body` varchar(100) DEFAULT NULL COMMENT '内容',
	`sort_time` varchar(100) DEFAULT NULL COMMENT '审结时间/开庭时间/立案时间/发布时间/贷款时间',
	`court` varchar(100) DEFAULT NULL COMMENT '法院名称',
	`pname` varchar(100) DEFAULT NULL COMMENT '被执人姓名/当事人/姓名',
	`caseNo` varchar(100) DEFAULT NULL COMMENT '案号(裁判文书)',

  `creator` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updater` int(11) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `data_state` int(1) DEFAULT NULL COMMENT '数据状态：1-正常 0-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='天创_企业/个人涉诉信息详情表';
-- 处理完成




-- api日志表
DROP TABLE IF EXISTS `api_log`;
CREATE TABLE `api_log` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `biz_id` VARCHAR(100) NOT NULL COMMENT '业务ID',
  `req_info` VARCHAR(8000) NOT NULL COMMENT '请求信息',
  `req_id` VARCHAR(100) NOT NULL COMMENT '请求ID',
  `channel_type` VARCHAR(30) NOT NULL COMMENT '通道类型',
  `resp_info` text NULL COMMENT '返回信息',
  `resp_code` VARCHAR(15) NULL COMMENT '返回码',
  `resp_message` VARCHAR(500) NULL COMMENT '返回信息',
  `status` VARCHAR(15) NULL COMMENT '状态',
  `create_time` TIMESTAMP NULL COMMENT '创建时间',
  `update_time` TIMESTAMP NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT 'API日志表';



DROP TABLE IF EXISTS `industry_commerce_info`;
CREATE TABLE `industry_commerce_info` (
  `id` INT(15) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
 -- 公司信息
  `enterprise_name` VARCHAR(200) NULL COMMENT '企业名称',
  `fr_name` VARCHAR(100) NULL COMMENT '法定代表人',
  `credit_code` VARCHAR(20) NULL COMMENT '统一社会信用代码',
  `reg_cap` VARCHAR(30) NULL COMMENT '注册资本',
  `reg_cap_cur` VARCHAR(15) NULL COMMENT '注册币种',

  `es_date` VARCHAR(15) NULL COMMENT '成立日期(YYYY-MM-DD)',
  `approve_date` VARCHAR(15) NULL COMMENT '核准日期(YYYY-MM-DD)',
  `open_from` VARCHAR(15) NULL COMMENT '营业期限自(YYYY-MM-DD)',
  `open_to` VARCHAR(15) NULL COMMENT '营业期限至(YYYY-MM-DD)',
  `reg_organzation` varchar(100) DEFAULT NULL COMMENT '登记机关',

  `enterprise_type` VARCHAR(60) NULL COMMENT '企业(机构)类型',
  `enterprise_status` VARCHAR(60) NULL COMMENT '登记状态(在营、注销、吊销、其他)',
  `cancel_date` VARCHAR(100) NULL COMMENT '注销日期',
  `revoke_date` VARCHAR(100) NULL COMMENT '吊销日期',
  `address` VARCHAR(200) NULL COMMENT '地址',

  `operate_scope` VARCHAR(1000) NULL COMMENT '经营范围',
  `operate_scope_and_form` VARCHAR(1000) NULL COMMENT '经营(业务)范围及方式',
  `abu_item` VARCHAR(1000) NULL COMMENT '许可经营项目',
  `cbu_item` VARCHAR(1000) NULL COMMENT '一般经营项目',
	-- 其他
  `tax_no` VARCHAR(100) NULL COMMENT '纳税人识别号',

  `organzation_no` VARCHAR(20) NULL COMMENT '组织机构代码',
  `reg_no` VARCHAR(20) NULL COMMENT '工商注册号',
  `ori_reg_no` VARCHAR(20) NULL COMMENT '工商注册号(旧)',
  `phone` VARCHAR(100) NULL COMMENT '联系电话(多个)',
  `english_name` VARCHAR(100) NULL COMMENT '英文名',
  `old_name` VARCHAR(100) NULL COMMENT '曾用名(多个)',

  `email` VARCHAR(100) NULL COMMENT '邮箱',
  `website` VARCHAR(100) NULL COMMENT '网址',
  `city` VARCHAR(100) NULL COMMENT '所在省份',
  `summary` VARCHAR(100) NULL COMMENT '简介',
  `logo` VARCHAR(100) NULL COMMENT '企业logo',

  `is_high_tech` VARCHAR(100) NULL COMMENT '是否高新企业',
  `is_listed` VARCHAR(100) NULL COMMENT '是否上市',
  `stock_exchange` VARCHAR(100) NULL COMMENT '上市证券交易所',
  `stock_code` VARCHAR(100) NULL COMMENT '股票代码',
  `stock_short_name` VARCHAR(100) NULL COMMENT '股票简称',

  `score` VARCHAR(100) NULL COMMENT '企业评分',
  `snapshot_url` VARCHAR(100) NULL COMMENT '工商官网快照',
  --
  `change_date` varchar(100) DEFAULT NULL COMMENT '变更日期(YYYY-MM-DD)',
  `anche_year` varchar(100) DEFAULT NULL COMMENT '最后年检年度',
  `anche_date` varchar(100) DEFAULT NULL COMMENT '最后年检日期',

  `industry_phy_code` varchar(100) DEFAULT NULL COMMENT '行业门类代码',
  `industry_phy_name` varchar(100) DEFAULT NULL COMMENT '行业门类名称',
  `industry_co_code` varchar(100) DEFAULT NULL COMMENT '国民经济行业代码',
  `industry_co_name` varchar(100) DEFAULT NULL COMMENT '国民经济行业名称',

  `create_time` TIMESTAMP NULL COMMENT '创建时间',
  `update_time` TIMESTAMP NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT '企业_工商信息表';
