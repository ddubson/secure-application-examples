define env_var_check
	@echo "Verifying $1 var is set..."
	@: $(if $(value $1),,$(error $1 is not set. The task cannot continue))
endef

all-env-var-check: ## Ensure all required environment variables are present
	$(call env_var_check,KEYCLOAK_PATH)
	@echo "Ensure env vars are set in the environment"

start-client:
	@sh gradlew :todo-client:bootRun

build-client:
	@sh gradlew :todo-client:build

start-auth-server: all-env-var-check
	cmd.exe /k $(KEYCLOAK_PATH)\bin\standalone.bat

add-kc-user: all-env-var-check
	cmd.exe /k $(KEYCLOAK_PATH)\bin\add-user.bat
