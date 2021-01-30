KEYCLOAK_COMMAND :=""
KEYCLOAK_ADD_USER_COMMAND :=""
RESOURCE_SERVER_START_COMMAND :=""

ifeq ($(OS),Windows_NT)
	KEYCLOAK_COMMAND=cmd.exe /k $(KEYCLOAK_PATH)\bin\standalone.bat
	KEYCLOAK_ADD_USER_COMMAND=cmd.exe /k $(KEYCLOAK_PATH)\bin\add-user.bat
	RESOURCE_SERVER_START_COMMAND=gradlew.bat :todo-resource-server:bootRun
else
	KEYCLOAK_COMMAND=sh $(KEYCLOAK_PATH)/bin/standalone.sh
	KEYCLOAK_ADD_USER_COMMAND=sh $(KEYCLOAK_PATH)/bin/add-user.sh
	RESOURCE_SERVER_START_COMMAND=sh gradlew :todo-resource-server:bootRun
endif

define env_var_check
	@echo "Verifying $1 var is set..."
	@: $(if $(value $1),,$(error $1 is not set. The task cannot continue))
endef

all-env-var-check: ## Ensure all required environment variables are present
	$(call env_var_check,KEYCLOAK_PATH)
	@echo "Ensure env vars are set in the environment"

start-todo-resource-server:
	$(RESOURCE_SERVER_START_COMMAND)

start-todo-client:
	@pushd todo-client && yarn install && yarn start

clean:
	@sh gradlew clean

start-auth-server: all-env-var-check
	$(KEYCLOAK_COMMAND)

add-kc-user: all-env-var-check
	$(KEYCLOAK_ADD_USER_COMMAND)

start:
	@echo "Choose and narrow down what you'd like to start."
	@echo "- start-todo-client"
	@echo "- start-todo-resource-server"
	@echo "- start-auth-server"
	@echo "---"
