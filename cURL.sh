#!/usr/bin/env bash

curl -X POST \
  https://serene-forest-12202.herokuapp.com/auth/signin \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: ed5cf66d-f2f2-4b09-811a-eefa116fd143' \
  -H 'cache-control: no-cache' \
  -d '{

	"username":"admin",
	"password":"admin@123"
}'

curl -X POST \
  https://serene-forest-12202.herokuapp.com/auth/signup \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 5af7b363-63b3-403c-915c-5aefe5d3cb62' \
  -H 'cache-control: no-cache' \
  -d '{
	"username":"administrator",
	"emailId":"administrator@gmail.com",
	"password":"admin@123",
	"confirmPassword":"admin@123"
}'

curl -X GET \
  'https://serene-forest-12202.herokuapp.com/api/bank/ABHYUDAYA%20COOPERATIVE%20BANK%20LIMITED/branches/MUMBAI?limit=5&offset=6' \
  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTU2NTAyMjE1NCwiZXhwIjoxNTY1MDIyMTU1fQ.X7fASB0nEb3TtCWQLdEeKOBapbj2AkTsms3s8OqcAyApra' \
  -H 'Postman-Token: 15c5a343-b725-4fb9-bfa4-3e74fce0dbee' \
  -H 'cache-control: no-cache'


curl -X GET \
  https://serene-forest-12202.herokuapp.com/api/bank/branch/ABHY0065007 \
  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTU2NDc2ODQ1MSwiZXhwIjoxNTY1MjAwNDUxfQ.Zn3zjZ9v6k2Vqat_QgWwK3T_nfTzPs_vVcSJIz6eS1o' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 5e701b8a-9247-45db-9c29-0fe84ad258b4' \
  -H 'cache-control: no-cache'


