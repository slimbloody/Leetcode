select
  name, population, area
from
  world
where
  area > 300000 or population > 25000000
;

SELECT
    name, population, area
FROM
    world
WHERE
    area > 3000000
UNION
SELECT
    name, population, area
FROM
    world
WHERE
    population > 25000000
;
