--注意分区名与当前日期
/*
 * 
 * 
 * 手工更新下面日期和分区名
 * 
 * 
 */

--创建当前月分区 tableName: IC_CACHE/IC_INFO/IC_W_INFO
ALTER TABLE IC_CACHE SPLIT PARTITION P_MAX
  AT( TO_DATE('2019-5-1 00:00:00','YYYY-MM-DD HH24:MI:SS') )
  INTO(PARTITION P_201904,PARTITION P_MAX);
ALTER TABLE IC_INFO SPLIT PARTITION P_MAX
  AT( TO_DATE('2019-5-1 00:00:00','YYYY-MM-DD HH24:MI:SS') )
  INTO(PARTITION P_201904,PARTITION P_MAX);
ALTER TABLE IC_W_INFO SPLIT PARTITION P_MAX
  AT( TO_DATE('2019-5-1 00:00:00','YYYY-MM-DD HH24:MI:SS') )
  INTO(PARTITION P_201904,PARTITION P_MAX);

--初始化分区表自动维护配置
--t_part_up 和 t_part_low 要替换成上面的分区名
insert into IC_CONF_TB (tb_name, schema_name, t_leavel, t_leavel_inter, t_part_up, t_part_low, t_part_add, t_part_drop, t_actived, last_modify_date)
values ('IC_INFO', 'IDCS', 'M', 1, 'P_201904', 'P_201904', '1', '0', '1', to_date('31-03-2019', 'dd-mm-yyyy'));
insert into IC_CONF_TB (tb_name, schema_name, t_leavel, t_leavel_inter, t_part_up, t_part_low, t_part_add, t_part_drop, t_actived, last_modify_date)
values ('IC_W_INFO', 'IDCS', 'M', 1, 'P_201904', 'P_201904', '1', '0', '1', to_date('31-03-2019', 'dd-mm-yyyy'));
insert into IC_CONF_TB (tb_name, schema_name, t_leavel, t_leavel_inter, t_part_up, t_part_low, t_part_add, t_part_drop, t_actived, last_modify_date)
values ('IC_CACHE', 'IDCS', 'M', 1, 'P_201904', 'P_201904', '1', '1', '1', to_date('31-03-2019', 'dd-mm-yyyy'));
insert into IC_CONF_TB (tb_name, schema_name, t_leavel, t_leavel_inter, t_part_up, t_part_low, t_part_add, t_part_drop, t_actived, last_modify_date)
values ('IC_INFO_TEST', 'IDCS', 'M', 1, 'P_201812', 'P_201812', '1', '1', '0', to_date('09-12-2018', 'dd-mm-yyyy'));
commit;


ALTER TABLE IC_CACHE DROP PARTITION P_201912;
ALTER TABLE IC_CACHE DROP PARTITION P_201901;
ALTER TABLE IC_INFO DROP PARTITION P_201812;
ALTER TABLE IC_INFO DROP PARTITION P_201901;
ALTER TABLE IC_W_INFO DROP PARTITION P_201812;
ALTER TABLE IC_W_INFO DROP PARTITION P_201901;