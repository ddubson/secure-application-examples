import {UserManager} from "oidc-client";

const config = {
  authority: "http://localhost:8080/auth/realms/secure_application_realm",
  client_id: "todo_app",
  redirect_uri: "http://localhost:3000/callback",
  response_type: "code",
  scope: "openid profile roles",
  post_logout_redirect_uri: "http://localhost:3000/logout",
};

export const oidc = new UserManager(config);