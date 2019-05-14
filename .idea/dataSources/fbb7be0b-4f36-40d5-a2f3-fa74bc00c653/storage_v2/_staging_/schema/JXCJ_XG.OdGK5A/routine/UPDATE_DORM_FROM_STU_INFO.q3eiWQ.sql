CREATE PROCEDURE UPDATE_DORM_FROM_STU_INFO AS
  --------------------------------------------------------------------把最新的住宿信息更新到学生信息
  --把最新的住宿信息更新到学生信息
  -------------------------------------------------------------------------
  v_year      NUMBER;
  v_year_0    NUMBER; --2018
  v_year_1    NUMBER; --2017
  v_year_2    NUMBER; --2016
  v_year_3    NUMBER; --2015
  stu_dorm_id NUMBER;
  stu_id      NUMBER;
  CURSOR c(v_year_0 NUMBER, v_year_1 NUMBER, v_year_2 NUMBER, v_year_3 NUMBER) IS (SELECT
                                                                                     STUDENT_ID,
                                                                                     student_dorm_id
                                                                                   FROM (SELECT
                                                                                           t1.ID STUDENT_ID,
                                                                                           t2.ID student_dorm_id
                                                                                         FROM
                                                                                           (
                                                                                             SELECT ID
                                                                                             FROM
                                                                                               T_ZS_STUDENT_INFO
                                                                                             WHERE
                                                                                               GRADE IN
                                                                                               (v_year_0, v_year_1, v_year_2, v_year_3)
                                                                                               AND
                                                                                               regexp_like(STUDENT_ID,
                                                                                                           '^0') AND
                                                                                               SCHOOL_AREA IN
                                                                                               ('1', '3')) t1
                                                                                           INNER JOIN (SELECT
                                                                                                         STUDENT_ID,
                                                                                                         ID
                                                                                                       FROM
                                                                                                         T_SG_STUDENT_DORM_INFO
                                                                                                       WHERE YEAR =
                                                                                                             v_year_0) t2
                                                                                             ON t1.ID = t2.STUDENT_ID));
  BEGIN
    SELECT DECODE(
               SIGN(SYSDATE - TO_DATE(TO_CHAR(SYSDATE, 'yyyy') || '-07-10', 'yyyy-MM-dd')), -1,
               TO_CHAR(SYSDATE, 'yyyy') - 1,
               0,
               TO_CHAR(SYSDATE, 'yyyy') - 1,
               1,
               TO_CHAR(SYSDATE, 'yyyy')
           ) YEAR
    INTO v_year
    FROM
      dual;
    v_year_0 := v_year;
    v_year_1 := v_year - 1;
    v_year_2 := v_year - 2;
    v_year_3 := v_year - 3;
    OPEN c(v_year_0, v_year_1, v_year_2, v_year_3);
    LOOP
      FETCH c INTO stu_id, stu_dorm_id;
      EXIT WHEN c%NOTFOUND;
      UPDATE T_ZS_STUDENT_INFO
      SET ZS_INFO_ID = stu_dorm_id, MODIFY_DATE = SYSDATE
      WHERE ID = stu_id;

    END LOOP;
    CLOSE c;
    COMMIT;
    EXCEPTION
    WHEN OTHERS THEN
    ROLLBACK;
  END;


/

