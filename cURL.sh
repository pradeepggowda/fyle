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
  'https://serene-forest-12202.herokuapp.com/api/bank/branches?name=ABHYUDAYA%20COOPERATIVE%20BANK%20LIMITED&city=MUMBAI?limit=5&offset=6' \
  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTU2NTAyMzU3MiwiZXhwIjoxNTY1NDU1NTcyfQ.DEdT5MU0Qi7e9Ghc1fqmm5twKAgO4N-nBPbBjtDbqjI' \
  -H 'Postman-Token: 15c5a343-b725-4fb9-bfa4-3e74fce0dbee' \
  -H 'cache-control: no-cache'


curl -X GET \
  https://serene-forest-12202.herokuapp.com/api/bank/branch/ABHY0065007 \
  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTU2NTAyMzU3MiwiZXhwIjoxNTY1NDU1NTcyfQ.DEdT5MU0Qi7e9Ghc1fqmm5twKAgO4N-nBPbBjtDbqjI' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 5e701b8a-9247-45db-9c29-0fe84ad258b4' \
  -H 'cache-control: no-cache'


