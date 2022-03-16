
DECLARE
/* theater_code_num : theater_code column의 정수부분*/
theater_code_num NUMBER := 1;

BEGIN
    FOR Cinema IN 1..33
    LOOP
        FOR Theater IN 1..7
        LOOP
            insert into theater values('theater_'||theater_code_num, Theater||'관', 156, 'cinema_'||Cinema);
            theater_code_num := theater_code_num + 1;
        END LOOP;
    END LOOP;
END;
