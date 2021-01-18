import React, {useEffect, useState} from "react";
import {User, UserManager} from "oidc-client";
import axios from "axios";
import {Accordion, AccordionTab} from "primereact/accordion";
import {Button} from "primereact/button";
import {Chip} from "primereact/chip";

type IdentityDetails = {
  id_token: string;
  username: string;
}

const Home: React.FC<{ oidc: UserManager }> = ({oidc}: { oidc: UserManager }) => {
  const [loggedIn, setLoggedIn] = useState(false);
  const [accordionIndex, setAccordionIndex] = useState<number>(0);
  const [identityDetails, setIdentityDetails] = useState<User | undefined>();

  useEffect(() => {
    oidc.getUser().then((user: User | null) => {
      if (user) {
        setLoggedIn(true);
        setIdentityDetails(user);

        console.log("User is logged in. ", user);
        axios.get('/todos', {
          baseURL: 'http://localhost:9000',
          headers: {'Authorization': 'Bearer ' + user.access_token}
        }).then((response: any) => {
          console.log("Retrieved todos, ", response);
        }).catch(console.error)
      } else {
        setLoggedIn(false);
        setIdentityDetails(undefined);
        console.log("User is logged out.");
      }
    }).catch(e => console.error("Failed to get user. ", e));
  }, [oidc]);

  const performLogin = () => {
    oidc.signinRedirect();
  }

  const performLogout = () => {
    oidc.signoutRedirect();
  }

  const renderUserDetails = () => (<>
      <Chip className="p-p-2 p-my-4" template={<>Username: {identityDetails?.profile.preferred_username}</>} />

      <Accordion className="p-mb-4" activeIndex={accordionIndex} onTabChange={(e) => setAccordionIndex(e.index)}>
        <AccordionTab header="OpenID Connect token">
          <code>
            {identityDetails?.id_token}
          </code>
        </AccordionTab>
        <AccordionTab header="OAuth 2.0 access token">
          <code>
            {identityDetails?.access_token}
          </code>
        </AccordionTab>
        <AccordionTab header="OAuth 2.0 access scopes">
          <ul>
            {identityDetails?.scopes.map(s => <li>{s}</li>)}
          </ul>
        </AccordionTab>
      </Accordion>

      <Button onClick={performLogout}>Log out</Button>
    </>
  )

  return (
    <div>
      <h1>Welcome to a secure app!</h1>
      <section>
        Keycloak Auth Server should be running at: http://localhost:8080/auth/
      </section>
      <section>
        {loggedIn && renderUserDetails()}
        {!loggedIn && <Button onClick={performLogin}>Log in</Button>}
      </section>
    </div>
  );
}

export default Home;