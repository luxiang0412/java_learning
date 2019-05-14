CREATE PROCEDURE pro_insert_major IS


  CURSOR cur IS

    SELECT
      t.code,

      t.caption,

      t.captionshort,

      t.mnemonic,

      t.departmentcode,

      t.treecode,

      t.status,

      t.gradelist,

      t.owerignorexk,

      t.engcaption

    FROM t_tmp_major t;

  v_str            VARCHAR2(100);

  v_res_str        VARCHAR2(100);

  v_current        VARCHAR2(100);

  t_code           VARCHAR2(100);

  t_caption        VARCHAR2(100);

  t_captionshort   VARCHAR2(100);

  t_mnemonic       VARCHAR2(100);

  t_departmentcode VARCHAR2(100);

  t_treecode       VARCHAR2(100);

  t_status         VARCHAR2(100);

  t_gradelist      VARCHAR2(100);

  t_pwerigonorexk  VARCHAR2(100);

  t_engcaption     VARCHAR2(100);

  BEGIN

    OPEN cur;

    LOOP

      FETCH cur

      INTO t_code, t_caption, t_captionshort, t_mnemonic, t_departmentcode, t_treecode, t_status, t_gradelist, t_pwerigonorexk, t_engcaption;

      EXIT WHEN cur%NOTFOUND;


      IF substr(t_gradelist, 1, 1) = '|'
      THEN

        t_gradelist := substr(t_gradelist, 2, length(t_gradelist));

      END IF;

      v_str := t_gradelist;


      v_res_str := '';


      v_current := '';


      LOOP


        EXIT WHEN v_str IS NULL;


        SPLIT_STRING_SP(v_str, v_res_str, v_current, '|');


        v_str := v_res_str;


        INSERT INTO t_xsxx_majorinformation_main

        (id,

         name,

         create_date,

         modify_date,

         orders,

         academy_id,

         major_year,

         major_categories_code,

         charge_category,

         status,

         introduce)

        VALUES

          (t_xsxx_classinformation_seq.nextval,

            t_caption,

            sysdate,

            sysdate,

            '',

            t_departmentcode,

            v_current,

            t_code,

            '',

            0,

            t_engcaption);


      END LOOP;


    END LOOP;

    CLOSE cur;

    COMMIT;

    EXCEPTION

    WHEN OTHERS THEN

    ROLLBACK;

  END pro_insert_major;


/

