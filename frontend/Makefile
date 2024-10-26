NPM=npm

run:
	$(NPM) run dev

generate:
	npx openapi-generator-cli generate \
		-i ../openapi.yml \
		-g typescript-fetch \
		-o src/openapi
