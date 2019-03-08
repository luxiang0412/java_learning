CREATE PROCEDURE test(v_college_id IN VARCHAR2, v_gender_code IN VARCHAR2, v_year IN VARCHAR2) AS

  sql_str      VARCHAR2(2000);
  TYPE MYCURSOR IS REF CURSOR;
  c            MYCURSOR;
  v_id         NUMBER;
  v_room_id    NUMBER;
  v_loudong_id NUMBER;
  v_no_use     NUMBER := 0;
  BEGIN
    sql_str := 'SELECT
	t1.ID,
	t1.ROOM_ID,
	t1.LOUDONG_ID 
FROM
	T_SG_STUDENT_DORM_INFO_BAK t1
	INNER JOIN T_SG_STUDENT_DORM_INFO t2 ON t1.ID = t2.ID
	INNER JOIN T_ZS_STUDENT_INFO t3 ON t3.ID = t1.STUDENT_ID
	INNER JOIN T_XSXX_CLASSINFORMATION t4 ON t3.ADMIN_CLASS_ID = t4.ID 
WHERE
	t1.YEAR = ''' || v_year || '''';
    IF v_gender_code IS NOT NULL
    THEN
      sql_str := sql_str || ' AND t3.GENDER = ''' || v_gender_code || ''' ';
    END IF;
    sql_str := sql_str || ' AND t4.FACULTY_ID = ' || v_college_id || '
	 AND t2.STATUS = 0 
	AND t2.LOUDONG_ID IS NULL 
	AND t1.LOUDONG_ID IS NOT NULL';
    --DBMS_OUTPUT.PUT_LINE(sql_str);
    OPEN c FOR sql_str;
    LOOP
      FETCH c INTO v_id, v_room_id, v_loudong_id;
      IF v_room_id IS NOT NULL
      THEN
        SELECT MAX((t3.BED_NUMBER - COUNT(1)))
        INTO v_no_use
        FROM
          T_SG_STUDENT_DORM_INFO t1
          INNER JOIN (SELECT
                        ID,
                        ROOM_TYPE_ID
                      FROM T_SG_ROOM_INFO
                      WHERE ID = v_room_id) t2 ON t1.ROOM_ID = t2.ID
          INNER JOIN T_SG_ROOM_TYPE t3 ON t2.ROOM_TYPE_ID = t3.ID
        WHERE
          t1.YEAR = v_year
        GROUP BY
          t3.BED_NUMBER;
      ELSE
        v_no_use := 1;
      END IF;
      EXIT WHEN c%NOTFOUND;
      --DBMS_OUTPUT.PUT_LINE(v_no_use);
      IF v_no_use > 0 OR v_no_use IS NULL
      THEN
        UPDATE T_SG_STUDENT_DORM_INFO
        SET ROOM_ID = v_room_id, loudong_id = v_loudong_id
        WHERE ID = v_id;
      END IF;
    END LOOP;
    CLOSE c;
    COMMIT;
    IF v_gender_code IS NULL
    THEN
      DELETE FROM T_SG_STUDENT_DORM_INFO_BAK
      WHERE ID IN (SELECT ID
                   FROM
                     T_SG_STUDENT_DORM_INFO_BAK t1
                   WHERE
                     t1.YEAR = v_year
                     AND EXISTS(
                         SELECT
                           b1.ID,
                           b1.ADMIN_CLASS_ID,
                           b2.FACULTY_ID
                         FROM
                           T_ZS_STUDENT_INFO b1
                           INNER JOIN T_XSXX_CLASSINFORMATION b2 ON b1.ADMIN_CLASS_ID = b2.ID
                         WHERE
                           b1.GRADE IN (v_year, v_year - 1, v_year - 2, v_year - 3)
                           AND b2.FACULTY_ID = v_college_id
                           AND t1.STUDENT_ID = b1.ID));
    ELSE
      DELETE FROM T_SG_STUDENT_DORM_INFO_BAK
      WHERE ID IN (SELECT ID
                   FROM
                     T_SG_STUDENT_DORM_INFO_BAK t1
                   WHERE
                     t1.YEAR = v_year
                     AND EXISTS(
                         SELECT
                           b1.ID,
                           b1.ADMIN_CLASS_ID,
                           b2.FACULTY_ID
                         FROM
                           T_ZS_STUDENT_INFO b1
                           INNER JOIN T_XSXX_CLASSINFORMATION b2 ON b1.ADMIN_CLASS_ID = b2.ID
                         WHERE
                           b1.GRADE IN (v_year, v_year - 1, v_year - 2, v_year - 3)
                           AND b1.GENDER = v_gender_code
                           AND b2.FACULTY_ID = v_college_id
                           AND t1.STUDENT_ID = b1.ID));
    END IF;
    EXCEPTION
    WHEN OTHERS THEN
    ROLLBACK;
  END;


/

