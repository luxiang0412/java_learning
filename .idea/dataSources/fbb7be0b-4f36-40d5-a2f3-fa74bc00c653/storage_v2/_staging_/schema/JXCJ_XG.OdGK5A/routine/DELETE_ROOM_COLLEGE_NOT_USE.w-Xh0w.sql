CREATE PROCEDURE DELETE_ROOM_COLLEGE_NOT_USE(v_year IN NUMBER, v_college_id IN NUMBER, v_gender IN NUMBER) AS
  ----------------------------------------------------------------
  --从中间表删除没有使用的分配房间
  --Delete unused allocation rooms from the intermediate table
  -----------------------------------------------------------------
  BEGIN
    IF v_gender IS NULL
    THEN
      DELETE T_SG_ROOM_COLLEGE
      WHERE ID IN (SELECT b1.ID
                   FROM
                     T_SG_ROOM_COLLEGE b1
                     LEFT JOIN (
                                 SELECT DISTINCT t6.id room_id
                                 FROM
                                   T_SG_STUDENT_DORM_INFO t1
                                   INNER JOIN T_ZS_STUDENT_INFO t2 ON t1.STUDENT_ID = t2.id
                                   INNER JOIN T_XSXX_CLASSINFORMATION t3 ON t2.ADMIN_CLASS_ID = t3.id
                                   INNER JOIN T_BASE_ORGANIZATION t4 ON t4.id = t3.FACULTY_ID
                                   INNER JOIN T_SG_LOUDONG_INFO t5 ON t1.loudong_id = t5.id
                                   INNER JOIN T_SG_ROOM_INFO t6 ON t6.id = t1.room_id
                                 WHERE
                                   t4.ORG_TYPE = '1'
                                   AND NOT regexp_like(t4.NAME, '职业')
                                   AND t1.YEAR = v_year
                                   AND t2.SCHOOL_AREA IN ('1', '3')
                               ) b2 ON b1.ROOM_INFO_ID = b2.ROOM_ID
                   WHERE
                     b1.YEAR = v_year
                     AND b2.room_id IS NULL
                     AND b1.COLLEGE_ID = v_college_id);
    ELSE
      DELETE T_SG_ROOM_COLLEGE
      WHERE ID IN (SELECT b1.ID
                   FROM
                     T_SG_ROOM_COLLEGE b1
                     LEFT JOIN (
                                 SELECT DISTINCT t6.id room_id
                                 FROM
                                   T_SG_STUDENT_DORM_INFO t1
                                   INNER JOIN T_ZS_STUDENT_INFO t2 ON t1.STUDENT_ID = t2.id
                                   INNER JOIN T_XSXX_CLASSINFORMATION t3 ON t2.ADMIN_CLASS_ID = t3.id
                                   INNER JOIN T_BASE_ORGANIZATION t4 ON t4.id = t3.FACULTY_ID
                                   INNER JOIN T_SG_LOUDONG_INFO t5 ON t1.loudong_id = t5.id
                                   INNER JOIN T_SG_ROOM_INFO t6 ON t6.id = t1.room_id
                                 WHERE
                                   t4.ORG_TYPE = '1'
                                   AND NOT regexp_like(t4.NAME, '职业')
                                   AND t1.YEAR = v_year
                                   AND t2.SCHOOL_AREA IN ('1', '3')
                               ) b2 ON b1.ROOM_INFO_ID = b2.ROOM_ID
                   WHERE
                     b1.YEAR = v_year
                     AND b2.room_id IS NULL
                     AND b1.COLLEGE_ID = v_college_id
                     AND b1.GENDER = v_gender);
    END IF;
    COMMIT;
    EXCEPTION
    WHEN OTHERS THEN
    ROLLBACK;
  END;


/

