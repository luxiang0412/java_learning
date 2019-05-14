CREATE PROCEDURE REVERT_ROOMS_STU_DORM(room_ids IN T_ROOMS_ARRAY,v_year IN NUMBER,v_grade IN NUMBER,v_college_id IN NUMBER) AS
-----------------------------------------------
----宿舍资源分配误操作还原住宿信息
----------------------------------------------
	--自定义数组类型
	--CREATE OR REPLACE TYPE T_ROOMS_ARRAY IS VARRAY(100) OF NUMBER;
	c sys_refcursor; --游标
	sql_str VARCHAR2(1000);--sql
	stu_dorm T_SG_STUDENT_DORM_INFO%rowtype;--定义一个object，基于t_sg_student_dorm_info
	is_exist_count number;--如果存在该学生id和该年份是否存在住宿信息
BEGIN
	sql_str :='SELECT
	* 
FROM
	(
SELECT
	t1.* 
FROM
	T_SG_STUDENT_DORM_INFO t1
	INNER JOIN T_ZS_STUDENT_INFO t2 ON t1.STUDENT_ID = t2.ID
	INNER JOIN T_XSXX_CLASSINFORMATION t3 ON t2.ADMIN_CLASS_ID = t3.id
	INNER JOIN T_BASE_ORGANIZATION t4 ON t4.id = t3.FACULTY_ID 
WHERE
	t1.year = '''||(v_year-1)||'''
	AND t2.GRADE = '''||v_grade||'''
	AND t4.ID = '||v_college_id||' ';
	IF room_ids.count>0 AND room_ids IS NOT NULL THEN
		sql_str := sql_str||'AND t1.ROOM_ID IN (';
		FOR var IN 1..room_ids.count loop
			IF var=room_ids.last then
				sql_str := sql_str||room_ids(var)||')';
			ELSE
				sql_str := sql_str||room_ids(var)||',';
			end if;
		END LOOP;
	END IF;
	sql_str := sql_str||') b1
WHERE
	NOT EXISTS (
SELECT
	* 
FROM
	T_SG_STUDENT_DORM_INFO b2 
WHERE
	b2.YEAR = '''||v_year||'''
	AND b1.STUDENT_ID = b2.STUDENT_ID 
	AND b2.LOUDONG_ID IS NOT NULL 
	)';
	--INSERT INTO TEST(ID)VALUES(sql_str);
	open c for sql_str;
	LOOP

		FETCH c INTO stu_dorm;
		EXIT WHEN c%NOTFOUND;
			SELECT COUNT(1) INTO is_exist_count FROM T_SG_STUDENT_DORM_INFO WHERE YEAR = v_year AND STUDENT_ID = stu_dorm.STUDENT_ID;

		IF is_exist_count = 0 THEN
			INSERT INTO T_SG_STUDENT_DORM_INFO(ID,CREATE_DATE,MODIFY_DATE,STUDENT_ID,ROOM_ID,year,REMARK,STATUS,LOUDONG_ID)VALUES(T_SG_STUDENT_DORM_INFO_SEQ.nextval,SYSDATE,SYSDATE,stu_dorm.student_id,stu_dorm.room_id,v_year,stu_dorm.remark,'0',stu_dorm.loudong_id);
		ELSE
			UPDATE T_SG_STUDENT_DORM_INFO SET LOUDONG_ID = stu_dorm.loudong_id ,ROOM_ID = stu_dorm.room_id WHERE year = v_year AND STUDENT_ID =  stu_dorm.STUDENT_ID;
		END IF;
	END LOOP;
	close c;
	commit;
exception
  when others then
  rollback;
END;


/

