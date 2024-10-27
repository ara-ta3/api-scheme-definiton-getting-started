SBT=sbt
.PHONY: build

sbt:
	$(SBT) 

build:
	$(SBT) compile

run:
	$(SBT) run

curl/get:
	curl localhost:8080/api/users

curl/post:
	curl -X POST localhost:8080/api/users -d '{"name": "${name}", "email": "${email}"}' -H "Content-Type: application/json"


generate:
	$(SBT) openapi/openApiGenerate

