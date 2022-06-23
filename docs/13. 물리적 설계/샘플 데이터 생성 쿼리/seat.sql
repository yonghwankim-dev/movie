DECLARE
seat_code Number := 1;
BEGIN
    FOR theater_code IN 1..1001
    LOOP
        FOR seat_row IN 0..8
        LOOP
            FOR seat_col IN 1..17
            LOOP
                insert into seat (seat_code, seat_row, seat_col, theater_code)
                values('SEAT' || seat_code, CHR(ASCII('A') + seat_row), seat_col, 'TH' || theater_code);
                seat_code := seat_code + 1;
            END LOOP;
        END LOOP;
    END LOOP;
END;