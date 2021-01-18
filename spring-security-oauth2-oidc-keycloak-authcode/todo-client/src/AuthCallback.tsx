import React, {useEffect} from "react";
import {useHistory} from "react-router-dom";
import {UserManager} from "oidc-client";

const AuthCallback: React.FC = () => {
  const history = useHistory();

  useEffect(() => {
    new UserManager({response_mode: "query"})
      .signinRedirectCallback()
      .then(() => {
        history.push("/");
      }).catch(e => {
      console.error(e);
    });
  });

  return (<div>Redirecting...</div>)
}

export default AuthCallback;