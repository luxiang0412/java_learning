CREATE PROCEDURE RECOVER_TEM_ROOM_2 AS
  CURSOR c IS (SELECT
                 ID,
                 ROOM_INFO_ID,
                 NEW_STATUS
               FROM
                 T_SG_RECYCLE_LOG t
               WHERE
                 t.VAILD = 0
                 AND t.TMP_END_TIME < SYSDATE);
  BEGIN
    FOR var IN c LOOP
      UPDATE T_SG_ROOM_INFO
      SET IS_ENABLE    = var.NEW_STATUS,
        TMP_START_TIME = NULL,
        TMP_END_TIME   = NULL,
        PURPOSE        = NULL
      WHERE
        ID = var.ROOM_INFO_ID;

      UPDATE T_SG_RECYCLE_LOG
      SET VAILD = 1
      WHERE ID = var.ID;
    END LOOP;
    COMMIT;
    EXCEPTION
    WHEN OTHERS THEN
    ROLLBACK;
  END;
/

