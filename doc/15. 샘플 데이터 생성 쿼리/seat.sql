DECLARE
seat_code Number := 1;
seat_col Number := 1;
seat_row Number := 0;

BEGIN
    FOR Theater IN 1..9
    LOOP
        seat_row := 0;
        seat_col := 1;
            
        FOR seat IN 1..156
        LOOP
            insert into seat values('SEAT'||seat_code, CHR(ASCII('A')+seat_row), seat_col, 'TH'||Theater);
            seat_code := seat_code + 1;
            seat_row := seat_row + 1;
            seat_col := seat_col + 1;
                
            IF seat_row=9 THEN
                seat_row := 0;
            END IF;
                
            IF seat_col=18 THEN
                seat_col := 1;
            END IF;
        END LOOP;
    END LOOP;
END;