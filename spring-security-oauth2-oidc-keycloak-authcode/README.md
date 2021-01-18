# OAuth 2.0 and OpenID Connect example

|OAuth Actor|Name|Port|
|---|---|---|
|Resource Owner|Registered User of ToDo Application|NA|
|Client|ToDo Client (React App)|3000|
|Resource Server|ToDo Resource Server|9000|
|Authorization Server|Keycloak|8080/auth|

![OAuth Authorization Code Flow Ref](https://www.baeldung.com/wp-content/uploads/2020/08/AuthCodeFlowSequenceDiagram-1-768x632.png)

## Requirements

- **Keycloak 12.x**
  - [Keycloak installation docs](https://www.keycloak.org/docs/latest/server_installation/index.html)
  - Keycloak 12 default local path: `127.0.0.1:8080/auth`
  - Operators:
     - `make start-auth-server` - starts standalone server
     - `make add-kc-user` -  adds a JBoss user

## Keycloak Setup

- Create an admin user
- Create a new realm
- Create a new client for the ToDo application

## Footnotes and Reference Material

- [Creating a simple Spring MVC app](https://spring.io/guides/gs/serving-web-content/)
- [Keycloak with Spring Boot](https://www.baeldung.com/spring-boot-keycloak)
- [OAuth 2.0 Resource Server with Spring Boot and Keycloak](https://www.baeldung.com/spring-security-oauth-resource-server)