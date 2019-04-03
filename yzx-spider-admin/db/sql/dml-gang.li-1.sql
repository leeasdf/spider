-- 数据解析
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    VALUES ('0', '数据解析',NULL, NULL, '0', 'menu', '7');
-- 按钮父菜单ID
set @mainMenu = @@identity;

-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @mainMenu, '信用湖南',NULL, NULL, '0', 'menu', '7';

-- 按钮父菜单ID
set @parentId = @@identity;
-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '重大税收违法案件公告信息', 'dataparser/credithunantaxcontravention', NULL, '1', 'config', '1';

set @menuId = @@identity;
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '查看', null, 'dataparser:credithunantaxcontravention:list,dataparser:credithunantaxcontravention:info', '2', null, '0';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId,'新增', null, 'dataparser:credithunantaxcontravention:save', '2', null, '1';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId,'修改', null, 'dataparser:credithunantaxcontravention:update', '2', null, '2';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '删除', null, 'dataparser:credithunantaxcontravention:delete', '2', null, '3';
    INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '人工重试', null, 'dataparser:credithunantaxcontravention:reset', '2', null, '6';

-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '年度纳税信用A级纳税人名单', 'dataparser/credithunantaxa', NULL, '1', 'config', '0';

set @menuId = @@identity;
-- 菜单对应按钮SQL

INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '查看', null, 'dataparser:credithunantaxa:list,dataparser:credithunantaxa:info', '2', null, '0';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '新增', null, 'dataparser:credithunantaxa:save', '2', null, '1';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '修改', null, 'dataparser:credithunantaxa:update', '2', null, '2';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '删除', null, 'dataparser:credithunantaxa:delete', '2', null, '3';
    INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '人工重试', null, 'dataparser:credithunantaxa:reset', '2', null, '6';

-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '双公示-行政处罚列表', 'dataparser/credithunanadministrativepenalty', NULL, '1', 'config', '2';

set @menuId = @@identity;
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '查看', null, 'dataparser:credithunanadministrativepenalty:list,dataparser:credithunanadministrativepenalty:info', '2', null, '0';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '新增', null, 'dataparser:credithunanadministrativepenalty:save', '2', null, '1';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '修改', null, 'dataparser:credithunanadministrativepenalty:update', '2', null, '2';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '删除', null, 'dataparser:credithunanadministrativepenalty:delete', '2', null, '3';
        INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '人工重试', null, 'dataparser:credithunanadministrativepenalty:reset', '2', null, '6';


-- --------------------------------------add by zhengliang.zhu------------------------------------------------------------

-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '非正常户公告信息', 'dataparser/credithunanabnormalnotice', NULL, '1', 'config', '3';

set @menuId = @@identity;
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @menuId, '查看', null, 'dataparser:credithunanabnormalnotice:list,dataparser:credithunanabnormalnotice:info', '2', null, '0';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @menuId, '新增', null, 'dataparser:credithunanabnormalnotice:save', '2', null, '1';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @menuId, '修改', null, 'dataparser:credithunanabnormalnotice:update', '2', null, '2';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @menuId, '删除', null, 'dataparser:credithunanabnormalnotice:delete', '2', null, '3';
    INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '人工重试', null, 'dataparser:credithunanabnormalnotice:reset', '2', null, '6';

-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '双公示-行政许可列表', 'dataparser/credithunanadministrativelicensing', NULL, '1', 'config', '4';

set @menuId = @@identity;
-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @menuId, '查看', null, 'dataparser:credithunanadministrativelicensing:list,dataparser:credithunanadministrativelicensing:info', '2', null, '0';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @menuId, '新增', null, 'dataparser:credithunanadministrativelicensing:save', '2', null, '1';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @menuId, '修改', null, 'dataparser:credithunanadministrativelicensing:update', '2', null, '2';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @menuId, '删除', null, 'dataparser:credithunanadministrativelicensing:delete', '2', null, '3';
  INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '人工重试', null, 'dataparser:credithunanadministrativelicensing:reset', '2', null, '6';

-- --------------------------------------------------------------------------------------------------

-- 信用中国
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @mainMenu, '信用中国',NULL, NULL, '0', 'menu', '6';
-- 按钮父菜单ID
set @parentId = @@identity;
-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '信用中国-基本信息', 'dataparser/creditchinabaseinfo', NULL, '1', 'config', '6';

-- 按钮父菜单ID
set @menuId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '查看', null, 'dataparser:creditchinabaseinfo:list,dataparser:creditchinabaseinfo:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '新增', null, 'dataparser:creditchinabaseinfo:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '修改', null, 'dataparser:creditchinabaseinfo:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '删除', null, 'dataparser:creditchinabaseinfo:delete', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '人工重试', null, 'dataparser:creditchinabaseinfo:reset', '2', null, '6';

-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '信用中国-行政许可', 'dataparser/creditchinapubpermission', NULL, '1', 'config', '6';

-- 按钮父菜单ID
set @menuId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '查看', null, 'dataparser:creditchinapubpermission:list,dataparser:creditchinapubpermission:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '新增', null, 'dataparser:creditchinapubpermission:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '修改', null, 'dataparser:creditchinapubpermission:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '删除', null, 'dataparser:creditchinapubpermission:delete', '2', null, '6';

-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '信用中国-行政处罚', 'dataparser/creditchinapubpenalty', NULL, '1', 'config', '6';

-- 按钮父菜单ID
set @menuId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '查看', null, 'dataparser:creditchinapubpenalty:list,dataparser:creditchinapubpenalty:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '新增', null, 'dataparser:creditchinapubpenalty:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '修改', null, 'dataparser:creditchinapubpenalty:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '删除', null, 'dataparser:creditchinapubpenalty:delete', '2', null, '6';

    -- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
     SELECT @parentId, '信用中国-守信红名单-税务局', 'dataparser/creditchinahonestytax', NULL, '1', 'config', '6';

-- 按钮父菜单ID
set @menuId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '查看', null, 'dataparser:creditchinahonestytax:list,dataparser:creditchinahonestytax:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '新增', null, 'dataparser:creditchinahonestytax:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '修改', null, 'dataparser:creditchinahonestytax:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '删除', null, 'dataparser:creditchinahonestytax:delete', '2', null, '6';

    -- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '信用中国-重点关注名单-证监会', 'dataparser/creditchinafocuspenalty', NULL, '1', 'config', '6';

-- 按钮父菜单ID
set @menuId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '查看', null, 'dataparser:creditchinafocuspenalty:list,dataparser:creditchinafocuspenalty:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '新增', null, 'dataparser:creditchinafocuspenalty:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '修改', null, 'dataparser:creditchinafocuspenalty:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '删除', null, 'dataparser:creditchinafocuspenalty:delete', '2', null, '6';

-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '信用中国-重点关注名单-工商总局', 'dataparser/creditchinafocusgszj', NULL, '1', 'config', '6';

-- 按钮父菜单ID
set @menuId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '查看', null, 'dataparser:creditchinafocusgszj:list,dataparser:creditchinafocusgszj:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '新增', null, 'dataparser:creditchinafocusgszj:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '修改', null, 'dataparser:creditchinafocusgszj:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '删除', null, 'dataparser:creditchinafocusgszj:delete', '2', null, '6';

-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
   SELECT @parentId, '信用中国-黑名单-最高法', 'dataparser/creditchinablacklaw', NULL, '1', 'config', '6';

-- 按钮父菜单ID
set @menuId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '查看', null, 'dataparser:creditchinablacklaw:list,dataparser:creditchinablacklaw:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '新增', null, 'dataparser:creditchinablacklaw:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '修改', null, 'dataparser:creditchinablacklaw:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @menuId, '删除', null, 'dataparser:creditchinablacklaw:delete', '2', null, '6';

-- 配置表 和配置记录表 都不展示  展示没意义 也不能随便修改
-- -- 菜单SQL
-- INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
--     SELECT @parentId, '信用中国-信用类型配置信息', 'dataparser/creditchinacredittype', NULL, '1', 'config', '6');
--
-- -- 按钮父菜单ID
-- set @menuId = @@identity;
--
-- -- 菜单对应按钮SQL
-- INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
--     SELECT @menuId, '查看', null, 'dataparser:creditchinacredittype:list,dataparser:creditchinacredittype:info', '2', null, '6';
-- INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
--     SELECT @menuId, '新增', null, 'dataparser:creditchinacredittype:save', '2', null, '6';
-- INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
--     SELECT @menuId, '修改', null, 'dataparser:creditchinacredittype:update', '2', null, '6';
-- INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
--     SELECT @menuId, '删除', null, 'dataparser:creditchinacredittype:delete', '2', null, '6';















