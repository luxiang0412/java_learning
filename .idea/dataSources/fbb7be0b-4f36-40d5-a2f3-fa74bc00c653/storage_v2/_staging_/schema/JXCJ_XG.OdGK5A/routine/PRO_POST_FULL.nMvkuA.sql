CREATE PROCEDURE pro_post_full IS
  BEGIN
    UPDATE t_qgzx_post_info t
    SET t.post_state = 2
    WHERE t.id IN
          (SELECT t1.ID
           FROM POST_INFO t1
           WHERE t1.recruit_num <= t1.ylq) AND t.post_state = 1;
    COMMIT;
    EXCEPTION
    WHEN OTHERS THEN
    ROLLBACK;
  END pro_post_full;


/

