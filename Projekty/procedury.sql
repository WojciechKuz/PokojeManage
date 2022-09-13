
 -- procedura usuwająca pracowników
CREATE DEFINER=`springuser`@`%` PROCEDURE `del_pracownicy`()
LANGUAGE SQL
NOT DETERMINISTIC
CONTAINS SQL
SQL SECURITY DEFINER
COMMENT ''
BEGIN
	DELETE
	FROM pracownicy
	WHERE TIMESTAMPDIFF(DAY, 'zatrudnienie_do', NOW()) < 1;
END
 -- zdarzenie
CREATE EVENT `del_event`
	ON SCHEDULE
		EVERY 1 HOUR
	ON COMPLETION NOT PRESERVE
	ENABLE
	COMMENT ''
	DO BEGIN
	CALL del_pracownicy();
END
