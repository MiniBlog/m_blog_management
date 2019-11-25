create function sequence(p_seq_id VARCHAR(20)) returns VARCHAR(20)
BEGIN
    DECLARE r_next_value VARCHAR(20);

    UPDATE
        t_mb_sequence
    SET
        current_value = CASE
                            WHEN IFNULL(date_value, '') <> '' AND DATE_FORMAT(SYSDATE(), '%y%m%d') = date_value THEN current_value + increment_value
                            WHEN IFNULL(date_value, '') <> '' AND DATE_FORMAT(SYSDATE(), '%y%m%d') <> date_value THEN current_value_init
                            WHEN IFNULL(date_value, '') = '' THEN current_value + increment_value END,
        date_value = CASE
                         WHEN IFNULL(date_value, '') <> '' THEN DATE_FORMAT(SYSDATE(), '%y%m%d')
                         WHEN IFNULL(date_value, '') = '' THEN NULL END
    WHERE
            seq_id = p_seq_id;

    SELECT
        CONCAT(IFNULL(prefix_value,''),IFNULL(date_value,''),IFNULL(LPAD(current_value, current_value_length, 0),''))
    INTO
        r_next_value
    FROM
        t_mb_sequence
    WHERE
            seq_id = p_seq_id;

    RETURN r_next_value;
END;