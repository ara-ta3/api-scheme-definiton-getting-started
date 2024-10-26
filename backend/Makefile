SBT=sbt
.PHONY: build

sbt:
	$(SBT) 

build:
	$(SBT) compile

run:
	$(SBT) run

curl:
	curl localhost:8080/api/users

generate:
	$(SBT) openapi/openApiGenerate
