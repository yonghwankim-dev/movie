DECLARE
mt_code Number := 1;
seat_code Number := 1;
type screen_time_array is varray(100) of timestamp;   /* 상영시간 배열 */
arr screen_time_array;

BEGIN
    select screen_time bulk collect into arr
    from dummy;
    
    FOR screen_code IN 1..28
    LOOP            
        FOR ticket IN 1..156
        LOOP
            insert into movie_ticket values('mt_'||mt_code, arr(screen_code), '선택가능', 'screen_'||screen_code, 'seat_'||seat_code);
            mt_code := mt_code + 1;
            seat_code := seat_code + 1;
        END LOOP;
    END LOOP;
END;