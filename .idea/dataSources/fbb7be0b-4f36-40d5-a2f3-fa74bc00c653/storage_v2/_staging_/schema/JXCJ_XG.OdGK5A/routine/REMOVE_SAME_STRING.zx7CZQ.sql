CREATE FUNCTION remove_same_string(oldStr VARCHAR2, sign VARCHAR2)
  RETURN VARCHAR2 IS

  /****************************************************
  ** Oracle去掉重复字符串
  ** 函数名称：RemoveSameStr
  ** 参    数：【名称】         【类型 】      【说明】
  **           oldStr           varchar2       要处理的字符串
  **           sign             varchar2       字符串分隔符
  ** 返 回 值：Result           varchar2       不包含重复子串的记录
  ****************************************************/
  str          VARCHAR2(2000);
  currentIndex NUMBER;
  startIndex   NUMBER;
  endIndex     NUMBER;

  TYPE STR_TYPE IS TABLE OF VARCHAR2(30) INDEX BY BINARY_INTEGER;
  arr          STR_TYPE;
  Result       VARCHAR2(1000);
  BEGIN
    -- 空字符串
    IF oldStr IS NULL
    THEN
      RETURN ('');
    END IF;

    --字符串太长
    IF length(oldStr) > 2000
    THEN
      RETURN (oldStr);
    END IF;
    str := oldStr;

    currentIndex := 0;
    startIndex := 0;

    LOOP
      currentIndex := currentIndex + 1;
      endIndex := instr(str, sign, 1, currentIndex);
      IF (endIndex <= 0)
      THEN
        EXIT;
      END IF;

      arr(currentIndex) := trim(substr(str, startIndex + 1, endIndex - startIndex - 1));
      startIndex := endIndex;
    END LOOP;

    --取最后一个字符串:
    arr(currentIndex) := substr(str, startIndex + 1, length(str));

    --去掉重复出现的字符串:
    FOR i IN 1 .. currentIndex - 1 LOOP
      FOR j IN i + 1 .. currentIndex LOOP
        IF arr(i) = arr(j)
        THEN
          arr(j) := '';
        END IF;
      END LOOP;
    END LOOP;

    str := '';
    FOR i IN 1 .. currentIndex LOOP
      IF arr(i) IS NOT NULL
      THEN
        str := str || sign || arr(i);
        --数组置空:
        arr(i) := '';
      END IF;
    END LOOP;

    --去掉前面的标识符:
    Result := substr(str, 2, length(str));

    RETURN (Result);
  END remove_same_string;


/

