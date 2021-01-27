# Keycloak Setup

## Installation

[Keycloak install docs](https://www.keycloak.org/docs/latest/server_installation/#installation)

The Keycloak server is now running at: `127.0.0.1:8080/auth`
The underlying JBoss host server is at: `127.0.0.1`

## Setting up a PostgreSQL connection

[Keycloak database setup](https://www.keycloak.org/docs/latest/server_installation/#_database)

PostgreSQL driver jar: https://search.maven.org/artifact/org.postgresql/postgresql/42.2.18/jar

When configuring the local standalone instance, for PostgreSQL username and password, use: `keycloaksa`

## Creating a default client

- Create an admin user
    - User: `keycloaksa`, password: `keycloaksa`
- Create a new realm
    - Realm name: `secure_application_realm` (exact)
- Create a new client for the application
    - Client ID: `todo_app`
    - Client Protocol: `openid-connect`
    - Root URL: `http://localhost:3000`
- Create client scopes
    - `todo_read`
    - `todo_write`
- Update todo_app client with both client scopes added above

## Connecting via sample app

Environment variable `KEYCLOAK_PATH` is required to be present on the PATH.

e.g. `KEYCLOAK_PATH=C:\Keycloak-12.0.1`

Operate via Makefile with following targets:

`make start-auth-server` - start local instance of Keycloak
`make add-kc-user` - add a Keycloak admin user

