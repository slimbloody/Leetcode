UPDATE salary
SET sex = CASE
  WHEN sex = 'm' THEN 'f'
  WHEN sex = 'f' THEN 'm'
END
;

-- SET sex = CASE
--   WHEN sex = 'm' THEN 'f'
--   WHEN sex = 'f' THEN 'm'
--   ELSE NULL
-- END

-- IF search_condition THEN
--     statement_list
-- [ELSEIF search_condition THEN]
--     statement_list ...
-- [ELSE
--     statement_list]
-- END IF

UPDATE salary SET sex = IF(sex='m', 'f', 'm');

UPDATE salary SET sex = (CASE WHEN sex = "m" THEN "f" ELSE "m" END);

