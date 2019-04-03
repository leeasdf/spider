-- truncate table  high_tech_zone_enterprise_info;
-- 企业列表
INSERT INTO `high_tech_zone_enterprise_info` (`enterprise_name`, `organization_code`, `business_license_no`, `tax_no`, `esDate`, `regCap`, `entryDate`, `createtime`, `credit_code`, `industry_type`, `update_time`, `data_state`)
SELECT `enterprise_name`,`organization_code`,`business_license_no`,`tax_no`,reg_time AS `esDate`,reg_cap AS `regCap`, NULL AS `entryDate`,`createtime`,`credit_code`,`industry_type`,`update_time`,`data_state`
FROM tpark_cs_dev.`high_tech_zone_enterprise_info`
WHERE province='广东' and remark='第一批' AND data_state = 1;

-- 企业基本信息
-- truncate table  rpt_base_info;
INSERT INTO `rpt_base_info`(`mem_id`, `enterprise_id`, `entname`, `regno`, `oriregno`, `frname`, `regcap`, `reccap`, `regcapcur`, `entstatus`, `enttype`, `esdate`, `opfrom`, `opto`, `dom`, `regorg`, `abuitem`, `cbuitem`, `opscope`, `opscoandform`, `ancheyear`, `changedate`, `candate`, `revdate`, `anchedate`, `industryphycode`, `industryphyname`, `industrycocode`, `industryconame`, `create_time`)
SELECT NULL AS `mem_id`, NULL AS `enterprise_id`, ent_name AS  `entname`, reg_no AS `regno`,
NULL AS `oriregno`,  legal_person AS `frname`,  reg_cap AS `regcap`, paid_cap AS `reccap`, NULL AS `regcapcur`, 
`status` AS `entstatus`, ent_type AS `enttype`, NULL AS `esdate`, LEFT(ope_period,LOCATE('至', ope_period)-1) AS `opfrom`,NULL AS `opto`, reg_address AS `dom`,
reg_authority  AS `regorg`, NULL AS `abuitem`, NULL AS `cbuitem`,bus_scope AS `opscope`,NULL AS `opscoandform`,NULL AS `ancheyear`,NULL AS `changedate`,NULL AS `candate`, NULL AS `revdate`,
NULL AS `anchedate`, NULL AS `industryphycode`,industry_phy_name AS `industryphyname`, NULL AS `industrycocode`,NULL AS `industryconame`,`create_time`
FROM tpark_cs_dev.`rpt_tn_basic_info` AS rpt_base_info
WHERE enterprise_id IN (SELECT id FROM tpark_cs_dev.`high_tech_zone_enterprise_info` WHERE province='广东' and remark='第一批' AND data_state = 1);

UPDATE rpt_base_info r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.entname;

-- 企业变更信息
-- truncate table  rpt_alter_info;
-- ALTER TABLE rpt_alter_info ADD enterprise_name VARCHAR(200) COMMENT '企业名称';
-- delete from rpt_alter_info where mem_id is null ;
INSERT INTO rpt_alter_info(`mem_id`, `enterprise_id`, `enterprise_name`,  `altdate`, `altitem`, `altbe`, `altaf`, `creator`, `create_time`, `updater`, `update_time`, `data_state`)
SELECT   NULL AS `mem_id`, NULL AS `enterprise_id`, `name` as `enterprise_name`,
  change_date AS `altdate`, change_item AS `altitem`, change_before AS `altbe`, change_after AS `altaf`,
  NULL AS `creator`, `create_time`, NULL AS `updater`, NULL AS `update_time`, '1' AS `data_state`
  FROM tpark_cs_dev.`rpt_tn_change` AS rpt_alter_info
  WHERE enterprise_id IN (SELECT id FROM tpark_cs_dev.`high_tech_zone_enterprise_info` WHERE province='广东' and remark='第一批' AND data_state = 1);
  
  UPDATE rpt_alter_info r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.enterprise_name;
  -- 软件著作权
  -- truncate table  rpt_copyright_info;
  -- ALTER TABLE rpt_copyright_info ADD enterprise_name VARCHAR(200) COMMENT '企业名称';
  -- delete from rpt_copyright_info where mem_id is null ;
  INSERT INTO rpt_copyright_info(`mem_id`, `enterprise_id`,  `enterprise_name` ,`full_name`, `version`, `register_code`, `classify_code`, `register_date`, `short_name`, `creator`, `create_time`, `updater`, `update_time`, `data_state`) 
  SELECT   NULL AS `mem_id`, NULL AS `enterprise_id`, ent_name as enterprise_name, fullname AS `full_name`, `version`,
  regnum AS `register_code`, catnum AS `classify_code`, app_date AS `register_date`, simple_name AS `short_name`,
  NULL AS `creator`, `create_time`, NULL AS `updater`, `update_time`, '1' AS `data_state`
  FROM tpark_cs_dev.`rpt_tn_software_right` AS `rpt_copyright_info`
  WHERE enterprise_id IN (SELECT id FROM tpark_cs_dev.`high_tech_zone_enterprise_info` WHERE province='广东' and remark='第一批' AND data_state = 1);
  
  -- UPDATE rpt_copyright_info r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.enterprise_name;
  -- 行政处罚
  -- truncate table  rpt_case_info;
  -- ALTER TABLE rpt_case_info ADD enterprise_name VARCHAR(200) COMMENT '企业名称';
   -- delete from rpt_case_info where memid is null ;
   INSERT INTO `rpt_case_info`(`memId`, `enterprise_id`, enterprise_name,`casetime`, `casereason`, `caseval`, `casetype`, `exesort`, `caseresult`, `pendecno`, `pendecissdate`, `penauth`, `illegfact`, `penbasis`, `pentype`, `penresult`, `penam`, `penexest`, `creator`, `create_time`, `updater`, `update_time`, `data_state`)
  SELECT NULL AS `memId`, NULL AS `enterprise_id`,ent_name as enterprise_name, publish_date AS `casetime` ,NULL AS `casereason`,NULL AS `caseval`,NULL AS `casetype`, NULL AS `exesort`,NULL AS `caseresult`,
punish_number AS `pendecno`,decision_date AS `pendecissdate`, department_name AS `penauth`,NULL AS `illegfact`,punishment_name AS `penbasis`,NULL AS `pentype`, NULL AS `penresult`,NULL AS `penam`,NULL AS `penexest`,
NULL AS `creator`, `create_time`, NULL AS `updater`, `update_time`, '1' AS `data_state`
FROM tpark_cs_dev.`rpt_tn_penalties` AS `rpt_case_info`
WHERE enterprise_id IN (SELECT id FROM tpark_cs_dev.`high_tech_zone_enterprise_info` WHERE province='广东' and remark='第一批' AND data_state = 1);

-- UPDATE rpt_case_info r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.enterprise_name;
-- 商标信息
-- truncate table  rpt_trademark_info;
-- ALTER TABLE rpt_trademark_info ADD ent_name VARCHAR(200) COMMENT '企业名称';
  -- delete from rpt_trademark_info where mem_id is null ;
INSERT INTO rpt_trademark_info(`mem_id`, `enterprise_id`, ent_name,`name`, `register_num`, `apply_date`, `status`, `creator`, `create_time`, `updater`, `update_time`, `data_state`)
SELECT   NULL AS `mem_id`, NULL AS `enterprise_id`, ent_name,
`name`, app_num AS register_num, app_date AS apply_date, process_status AS `status`,
NULL AS `creator`, `create_time`, NULL AS `updater`, `update_time`, '1' AS `data_state`
FROM tpark_cs_dev.`rpt_tn_trademark` AS `rpt_trademark_info`
WHERE enterprise_id IN (SELECT id FROM tpark_cs_dev.`high_tech_zone_enterprise_info` WHERE province='广东' and remark='第一批' AND data_state = 1);

UPDATE rpt_trademark_info r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
-- 股东信息
-- truncate table  rpt_shareholder_info;
-- ALTER TABLE rpt_shareholder_info ADD ent_name VARCHAR(200) COMMENT '企业名称';
  -- delete from rpt_shareholder_info where mem_id is null ;
INSERT INTO rpt_shareholder_info(`mem_id`, `enterprise_id`, ent_name, `shaname`, `fundedratio`, `subconam`, `condate`, `creator`, `create_time`, `updater`, `update_time`, `data_state`)
SELECT   NULL AS `mem_id`, NULL AS `enterprise_id`, ent_name,
`name` AS shaname, fun_ratio AS fundedratio , sub_funding AS subconam , amount_date AS condate,
NULL AS `creator`, `create_time`, NULL AS `updater`, NULL AS `update_time`, '1' AS `data_state`
FROM tpark_cs_dev.`rpt_tn_shareholders` AS `rpt_shareholder_info`
WHERE enterprise_id IN (SELECT id FROM tpark_cs_dev.`high_tech_zone_enterprise_info` WHERE province='广东' and remark='第一批' AND data_state = 1);

UPDATE rpt_shareholder_info r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
-- 高管信息
-- truncate table  rpt_person_info;
-- ALTER TABLE rpt_person_info ADD ent_name VARCHAR(200) COMMENT '企业名称';
  -- delete from rpt_person_info where mem_id is null ;
INSERT INTO rpt_person_info(`mem_id`, `enterprise_id`, ent_name,`creator`, `create_time`, `updater`, `update_time`, `data_state`, `pername`, `position`, `sex`, `personamount`)
SELECT   NULL AS `mem_id`, NULL AS `enterprise_id`, ent_name,
NULL AS `creator`, `create_time`, NULL AS `updater`, NULL AS `update_time`, '1' AS `data_state`,
`name` AS pername, `job` AS `position`, NULL AS sex, NULL AS personamount
FROM tpark_cs_dev.`rpt_tn_person` AS `rpt_person_info`
WHERE enterprise_id IN (SELECT id FROM tpark_cs_dev.`high_tech_zone_enterprise_info` WHERE province='广东' and remark='第一批' AND data_state = 1);

UPDATE rpt_person_info r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
-- 专利信息
-- truncate table  rpt_patents_info;
-- ALTER TABLE rpt_patents_info ADD ent_name VARCHAR(200) COMMENT '企业名称';
  -- delete from rpt_patents_info where mem_id is null ;

INSERT INTO rpt_patents_info(`mem_id`, `enterprise_id`, ent_name,`creator`, `create_time`, `updater`, `update_time`, `data_state`, `pub_date`, `title`, `patent_number`, `pub_num`, `type`)
SELECT   NULL AS `mem_id`, NULL AS `enterprise_id`, ent_name,
NULL AS `creator`, `create_time`, NULL AS `updater`, NULL AS `update_time`, '1' AS `data_state`,
app_date AS pub_date, `name` AS title , app_num AS patent_number , app_pub_num AS pub_num, `type` 
FROM tpark_cs_dev.`rpt_tn_patent` AS `rpt_patents_info`
WHERE enterprise_id IN (SELECT id FROM tpark_cs_dev.`high_tech_zone_enterprise_info` WHERE province='广东' and remark='第一批' AND data_state = 1);

UPDATE rpt_patents_info r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;

-- 经营异常
-- truncate table  rpt_opex_info;
-- ALTER TABLE rpt_opex_info ADD ent_name VARCHAR(200) COMMENT '企业名称';
  -- delete from rpt_opex_info where mem_id is null ;
INSERT INTO rpt_opex_info(`mem_id`, `enterprise_id`, ent_name,`creator`, `create_time`, `updater`, `update_time`, `data_state`, `on_date`, `org_name`, `on_reason`, `out_date`, `out_reason`)
SELECT   NULL AS `mem_id`, NULL AS `enterprise_id`,ent_name,
NULL AS `creator`, `create_time`, NULL AS `updater`, NULL AS `update_time`, '1' AS `data_state`,
`date` AS on_date, `agency` AS org_name , reason AS on_reason , remove_date AS out_date, remove_reason AS out_reason
FROM tpark_cs_dev.`rpt_tn_abnormal` AS rpt_opex_info
WHERE enterprise_id IN (SELECT id FROM tpark_cs_dev.`high_tech_zone_enterprise_info` WHERE province='广东' and remark='第一批' AND data_state = 1);

-- UPDATE rpt_opex_info r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
-- 分支机构
-- truncate table  rpt_filiation_info;
-- ALTER TABLE rpt_filiation_info ADD ent_name VARCHAR(200) COMMENT '企业名称';
  -- delete from rpt_filiation_info where mem_id is null ;
INSERT INTO rpt_filiation_info(`mem_id`, `enterprise_id`, ent_name,`creator`, `create_time`, `updater`, `update_time`, `data_state`, `brname`, `brprincipal`)
SELECT   NULL AS `mem_id`, NULL AS `enterprise_id`, ent_name,
NULL AS `creator`, `create_time`, NULL AS `updater`, NULL AS `update_time`, '1' AS `data_state`,
cmp_name AS brname, legal_person AS brprincipal 
FROM tpark_cs_dev.`rpt_tn_branches` AS `rpt_filiation_info`
WHERE enterprise_id IN (SELECT id FROM tpark_cs_dev.`high_tech_zone_enterprise_info` WHERE province='广东' and remark='第一批' AND data_state = 1);

-- UPDATE rpt_filiation_info r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
-- 对外投资
-- truncate table  rpt_frinv_info;
-- ALTER TABLE rpt_frinv_info ADD ent_name VARCHAR(200) COMMENT '企业名称';
  -- delete from rpt_frinv_info where mem_id is null ;
INSERT INTO rpt_frinv_info(`mem_id`, `enterprise_id`, ent_name,`creator`, `create_time`, `updater`, `update_time`, `data_state`, `name`, `regcap`, `esdate`, `entname`, `fundedratio`, `entstatus`)
SELECT   NULL AS `mem_id`, NULL AS `enterprise_id`, ent_name,
NULL AS `creator`, `create_time`, NULL AS `updater`, NULL AS `update_time`, '1' AS `data_state`,
legal_person AS `name`, inv_amount AS regcap, reg_time AS esdate, cmp_name AS entname, inv_ratio AS fundedratio, `status` AS entstatus
FROM tpark_cs_dev.`rpt_tn_invest` AS `rpt_frinv_info`
WHERE enterprise_id IN (SELECT id FROM tpark_cs_dev.`high_tech_zone_enterprise_info` WHERE province='广东' and remark='第一批' AND data_state = 1);

-- UPDATE rpt_frinv_info r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;
-- 被执行人信息
-- truncate table  rpt_litigation_info;
-- ALTER TABLE rpt_litigation_info ADD ent_name VARCHAR(200) COMMENT '企业名称';
  -- delete from rpt_litigation_info where mem_id is null ;

INSERT INTO rpt_litigation_info(`mem_id`, `enterprise_id`, ent_name,`creator`, `create_time`, `updater`, `update_time`, `data_state`, `sort_time`, `exec_money`, `case_no`, `court`)
SELECT   NULL AS `mem_id`, NULL AS `enterprise_id`, ent_name,
NULL AS `creator`, `create_time`, NULL AS `updater`, NULL AS `update_time`, '1' AS `data_state`,
`date` AS sort_time, target AS exec_money, case_no, court
FROM tpark_cs_dev.`rpt_tn_zhixing` AS `rpt_litigation_info`
WHERE enterprise_id IN (SELECT id FROM tpark_cs_dev.`high_tech_zone_enterprise_info` WHERE province='广东' and remark='第一批' AND data_state = 1);

UPDATE rpt_litigation_info r ,high_tech_zone_enterprise_info h SET r.enterprise_id = h.id WHERE h.enterprise_name = r.ent_name;