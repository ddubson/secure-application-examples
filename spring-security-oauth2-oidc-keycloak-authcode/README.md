# OAuth 2.0 and OpenID Connect example

|OAuth Actor|Name|Port|
|---|---|---|
|Resource Owner|Registered User of ToDo Application|NA|
|Client|ToDo Client (React App)|3000|
|Resource Server|ToDo Resource Server|9000|
|Authorization Server|Keycloak|8080/auth|

![OAuth Authorization Code Flow Ref](https://www.baeldung.com/wp-content/uploads/2020/08/AuthCodeFlowSequenceDiagram-1-768x632.png)

## Requirements

- **Keycloak 12 up and runnning - [Install and launch docs](./docs/keycloak-setup.md)

## Footnotes and Reference Material

- [Creating a simple Spring MVC app](https://spring.io/guides/gs/serving-web-content/)
- [Keycloak with Spring Boot](https://www.baeldung.com/spring-boot-keycloak)
- [OAuth 2.0 Resource Server with Spring Boot and Keycloak](https://www.baeldung.com/spring-security-oauth-resource-server)