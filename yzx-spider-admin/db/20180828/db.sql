-- 更改主键类型
ALTER TABLE api_log MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE credit_code_tmp MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE cs_sfgw_aic_contact MODIFY zjid BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE cs_sfgw_aic_e_jyycmlxx MODIFY zjid BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE cs_sfgw_aic_infoetail MODIFY zjid BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE cs_sfgw_aic_infofinance MODIFY zjid BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE cs_sfgw_aic_investordocument MODIFY zjid BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE cs_sfgw_ds_abnormalusernotice MODIFY zjid BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE cs_sfgw_ds_overduenohandletax MODIFY zjid BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE cs_sfgw_ds_rentcredita MODIFY zjid BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE cs_sfgw_ds_rentownedtaxofperson MODIFY zjid BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE cs_sfgw_hbt_ccproductionaudit MODIFY zjid BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE cs_sfgw_hbt_epinformation MODIFY zjid BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE cs_sfgw_hbt_license MODIFY zjid BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE cs_sfgw_hbt_penalties MODIFY zjid BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE cs_sfgw_hbt_sjzx_gx_xzcf MODIFY zjid BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE cs_sfgw_tax_annualgrade MODIFY zjid BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE cs_sfgw_tax_basic MODIFY zjid BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE cs_sfgw_tax_information MODIFY zjid BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE cs_sfgw_tax_taxofnopayed MODIFY zjid BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_changsha_tax_default_info MODIFY tax_default_info_id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_changsha_tax_default_info_bak MODIFY tax_default_info_id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_drainage_cost MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_drainage_owe_fee MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_environment_protect MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_high_tech_black_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_high_tech_faith_lose MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_high_tech_industrial_estate MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_high_tech_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_high_tech_land_ledger MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_high_tech_merchants MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_high_tech_project_approval MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_high_tech_project_declare MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_high_tech_punish_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_high_tech_verify_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_hunan_state_tax_info MODIFY hunan_state_tax_id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_illegal_punish_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_industrial_output MODIFY industrial_output_id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_local_tax_credit_info MODIFY local_tax_id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_state_tax_credit_info MODIFY state_tax_id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_tax_info MODIFY tax_info_id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ent_wellknown_trademark MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE enterprise_arrearage MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE enterprise_incubator_room MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE enterprise_qualification MODIFY enterprise_qualification_id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE enterprise_water_electricity MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE high_tech_zone_enterprise_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE high_tech_zone_enterprise_info_copy MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE hn_enterprise_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ori_administrative_penalty MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ori_enterprise_business_base_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ori_enterprise_operating_exception MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ori_enterprise_tax_owing MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ori_enterprise_tax_taxpayer MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ori_environmental_penalty MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ori_national_tax_base MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE ori_national_tax_credit_a MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_alter_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_base_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_case_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_cblack_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_copyright_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_entinv_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_filiation_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_frinv_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_frposition_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_legalbad_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_litigation_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_opex_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_patents_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_person_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_plitigation_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_shareholder_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tax_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tcxy_company_copyright MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tcxy_company_software_copyright MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tcxy_patent_base MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_abnormal MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_announcementcourt MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_basic_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_bid MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_bond MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_branches MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_busrole MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_certificate MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_change MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_check MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_court_notice MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_dishonest MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_ent_person_cmpany MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_equity MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_icp MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_illegal MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_import_export MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_invest MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_judicial_aid MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_lawsuit MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_licensing_xyzg MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_mortgage MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_owing_tax MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_patent MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_penalties MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_person MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_product MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_purchaseland MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_report MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_shareholders MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_software_right MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_software_right_author MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_tax_credit MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_trademark MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_works_right MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_tn_zhixing MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE rpt_trademark_info MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE tyc_page_record MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE xylg_dsj_city_tax_owing MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
ALTER TABLE xylg_taxpayer_credit_result MODIFY id BIGINT(20) COMMENT '主键' NOT NULL;
-- enterprise_id
ALTER TABLE rpt_tn_basic_info MODIFY enterprise_id BIGINT(20) COMMENT '企业id';
ALTER TABLE rpt_tn_bid MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_judicial_aid MODIFY enterprise_id BIGINT(20) COMMENT '主键' NOT NULL;

ALTER TABLE rpt_alter_info MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_base_info MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_case_info MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_cblack_info MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_copyright_info MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_entinv_info MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_filiation_info MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_frinv_info MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_frposition_info MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_legalbad_info MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_litigation_info MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_opex_info MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_patents_info MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_person_info MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_plitigation_info MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_shareholder_info MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tax_info MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;

ALTER TABLE rpt_tn_abnormal MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_announcementcourt MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_basic_info MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;

ALTER TABLE rpt_tn_bond MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_branches MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;

ALTER TABLE rpt_tn_certificate MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_change MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_check MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_court_notice MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_dishonest MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;

ALTER TABLE rpt_tn_equity MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_icp MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_illegal MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_import_export MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_invest MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;

ALTER TABLE rpt_tn_lawsuit MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_licensing_xyzg MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_mortgage MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_owing_tax MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_patent MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_penalties MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_person MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_product MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_purchaseland MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_report MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_shareholders MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_software_right MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_software_right_author MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_tax_credit MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_trademark MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_works_right MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_tn_zhixing MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
ALTER TABLE rpt_trademark_info MODIFY enterprise_id BIGINT(20) COMMENT '企业主键' ;
-- 增加字段
ALTER TABLE sys_user_token ADD COLUMN app_id VARCHAR(100) NOT NULL COMMENT '应用id';
ALTER TABLE sys_user_token ADD COLUMN `status` INT(1) NOT NULL COMMENT 'token状态';
ALTER TABLE sys_user_token ADD COLUMN `token_id` VARCHAR(100) NOT NULL COMMENT 'token的id';
--
ALTER TABLE rpt_tn_patent ADD `type` VARCHAR(20) DEFAULT NULL COMMENT '专利类型';

CREATE TABLE `sys_user_api_token` (
  `user_id` BIGINT(20) NOT NULL,
  `app_id` VARCHAR(100) NOT NULL COMMENT '应用id',
  `app_name` VARCHAR(100) NOT NULL COMMENT '应用名称',
  `token` VARCHAR(100) NOT NULL COMMENT 'token',
  `expire_time` DATETIME DEFAULT NULL COMMENT '过期时间',
  `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  `status` INT(1) DEFAULT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '用户平台token表';

CREATE TABLE `sys_api_menu` (
  `api_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'API接口ID' ,
  `api_url` VARCHAR(100) NOT NULL COMMENT 'api访问地址',
  `api_desc` VARCHAR(100) NOT NULL COMMENT 'api接口描述',
  `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  `status` INT(1) DEFAULT NULL COMMENT '状态',
    PRIMARY KEY (`api_id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT 'api菜单表';

CREATE TABLE `sys_app_api` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID' ,
  `app_id` VARCHAR(100) NOT NULL COMMENT '应用id',
  `api_id` int(10) NOT NULL COMMENT '接口id',

  `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  `status` INT(1) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '应用接口对照表';

-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    VALUES ('1', 'app管理', 'api/sysuserapitoken', NULL, '1', 'config', '6');

-- 按钮父菜单ID
set @parentId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '查看', null, 'api:sysuserapitoken:list,api:sysuserapitoken:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '新增', null, 'api:sysuserapitoken:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '修改', null, 'api:sysuserapitoken:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '删除', null, 'api:sysuserapitoken:delete', '2', null, '6';
    

-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    VALUES ('1', 'api菜单', 'api/sysapimenu', NULL, '1', 'config', '6');

-- 按钮父菜单ID
set @parentId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '查看', null, 'api:sysapimenu:list,api:sysapimenu:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '新增', null, 'api:sysapimenu:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '修改', null, 'api:sysapimenu:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '删除', null, 'api:sysapimenu:delete', '2', null, '6';

    
    ALTER TABLE high_tech_zone_enterprise_info ADD FULLTEXT INDEX `fulltext_enterprise_name`(`enterprise_name`) WITH PARSER ngram;
    
    
    
UPDATE rpt_tn_abnormal r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_announcementcourt r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_basic_info r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_bid r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_bond r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;

UPDATE rpt_tn_branches r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
-- update rpt_tn_busrole r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_certificate r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_change r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.name;
UPDATE rpt_tn_check r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;

UPDATE rpt_tn_court_notice r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_dishonest r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
-- update rpt_tn_ent_person_cmpany r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_equity r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_icp r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;

UPDATE rpt_tn_illegal r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_import_export r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_invest r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_judicial_aid r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_lawsuit r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;

UPDATE rpt_tn_licensing_xyzg r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_mortgage r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_owing_tax r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_patent r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_penalties r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;

UPDATE rpt_tn_person r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_product r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_purchaseland r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_report r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_shareholders r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;

UPDATE rpt_tn_software_right r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
-- update rpt_tn_software_right_author r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_tax_credit r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_trademark r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
UPDATE rpt_tn_works_right r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;

UPDATE `rpt_tn_zhixing` r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;