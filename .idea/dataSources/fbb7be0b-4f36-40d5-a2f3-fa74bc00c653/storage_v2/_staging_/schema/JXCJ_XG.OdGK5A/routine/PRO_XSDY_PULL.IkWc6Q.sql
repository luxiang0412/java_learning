CREATE PROCEDURE pro_xsdy_pull IS --该存储过程主要用于拉取学生党员数据
  BEGIN
    DELETE FROM t_lxby_xsdy;
    INSERT INTO t_lxby_xsdy
      SELECT *
      FROM t_xsdy@DANGYUANLINK;

    UPDATE t_lxby_xsdy t
    SET t.xb = '01'
    WHERE t.xb = '1'; --性别代码切换
    UPDATE t_lxby_xsdy t
    SET t.xb = '02'
    WHERE t.xb = '2'; --性别代码切换

    COMMIT;
    EXCEPTION
    WHEN OTHERS THEN
    ROLLBACK;
  END pro_xsdy_pull;


/

