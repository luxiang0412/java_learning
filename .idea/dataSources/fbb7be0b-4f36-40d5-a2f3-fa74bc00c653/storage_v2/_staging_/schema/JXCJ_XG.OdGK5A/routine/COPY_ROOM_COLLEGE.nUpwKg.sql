CREATE PROCEDURE COPY_ROOM_COLLEGE(v_year IN NUMBER) AS
  -----------------------------------------------
  ----中间表的年度复制,
  -----把除了毕业生和空的寝室全部复制到新的年份
  ----------------------------------------------
  --v_year为当前年份
  CURSOR c IS (SELECT *
               FROM (SELECT DISTINCT t1.*
                     FROM
                       T_SG_ROOM_COLLEGE t1
                       INNER JOIN T_SG_STUDENT_DORM_INFO t2 ON t1.ROOM_INFO_ID = t2.ROOM_ID
                                                               AND t1.YEAR = t2.YEAR
                       INNER JOIN T_ZS_STUDENT_INFO t3 ON t2.STUDENT_ID = t3.id
                     WHERE
                       t1.YEAR = v_year - 1
                       AND t3.GRADE IN (v_year - 1, v_year - 2, v_year - 3)));
  BEGIN
    FOR var IN c LOOP
      INSERT INTO T_SG_ROOM_COLLEGE (id, CREATE_DATE, MODIFY_DATE, YEAR, COLLEGE_ID, ROOM_INFO_ID, LOUDONG_INFO_ID, gender, GRADE)
      VALUES
        (T_SG_ROOM_COLLEGE_SEQ.nextval, sysdate, sysdate, v_year, var.college_id, var.ROOM_INFO_ID, var.LOUDONG_INFO_ID,
         var.gender, var.GRADE);
    END LOOP;
    COMMIT;
    EXCEPTION
    WHEN OTHERS THEN
    ROLLBACK;
  END;


/

