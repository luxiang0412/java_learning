CREATE FUNCTION ISNUMERIC(STR IN VARCHAR2)
  RETURN NUMBER IS

  BEGIN

    IF STR IS NULL
    THEN

      RETURN 0;

    ELSE

      IF REGEXP_LIKE(STR, '(^[+-]?\d{0,}\.?\d{0,}$)')
      THEN

        RETURN 1;

      ELSE

        RETURN 0;

      END IF;

    END IF;

  END ISNUMERIC;


/

