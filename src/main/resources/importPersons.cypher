using periodic commit 5000
LOAD CSV with headers FROM "file:///persons.csv" AS line
create (p:Person)
set p += line
set p.age = toInteger(line.age)
set p.weight = toFloat(line.weight)
set p.height = toFloat(line.height)