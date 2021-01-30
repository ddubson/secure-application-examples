import React, {FormEvent, useEffect, useState} from "react";
import {User, UserManager} from "oidc-client";
import axios from "axios";
import {Accordion, AccordionTab} from "primereact/accordion";
import {Button} from "primereact/button";
import {Chip} from "primereact/chip";
import {InputText} from "primereact/inputtext";

type Todo = {
  text: string
};

const Home: React.FC<{ oidc: UserManager }> = ({oidc}: { oidc: UserManager }) => {
  const [accordionIndex, setAccordionIndex] = useState<number>(0);
  const [identityDetails, setIdentityDetails] = useState<User | undefined>();
  const [todos, setTodos] = useState<Todo[]>([]);
  const [newTodo, setNewTodo] = useState<string>("");

  useEffect(() => {
    oidc.getUser().then((user: User | null) => {
      if (user) {
        setIdentityDetails(user);

        console.log("User is logged in. ");
        axios.get('/todos', {
          baseURL: 'http://localhost:9000',
          headers: {'Authorization': 'Bearer ' + user.access_token}
        })
          .then((response: any) => response.data)
          .then((todos: Todo[]) => {
              setTodos(todos);
            }
          ).catch(console.error)
      } else {
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

  const onTodoChange = (e: FormEvent<HTMLInputElement>) => {
    setNewTodo((e.target as any).value);
  }

  const onAddTodo = (e: any) => {
    e.preventDefault();
    axios.post('/todos', {text: newTodo}, {
      baseURL: 'http://localhost:9000',
      headers: {
        'Authorization': 'Bearer ' + identityDetails?.access_token,
        'Content-Type': 'application/json'
      }
    })
      .then((response: any) => response.data)
      .then((todo: Todo) => {
          setTodos([...todos, todo]);
          setNewTodo("")
        }
      ).catch(console.error)
  }

  const renderUserDetails = () => (<>
      <section className={"p-row p-mb-4"}>
        <div>
          <Chip className="p-p-2 p-my-4" template={<>Username: {identityDetails?.profile.preferred_username}</>}/>
        </div>
        <div>
          <Button onClick={performLogout}>Log out</Button>
        </div>
      </section>

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
            {identityDetails?.scopes.map((s, i) => <li key={i}>{s}</li>)}
          </ul>
        </AccordionTab>
      </Accordion>

      <section className={"p-grid"}>
        <section className={"p-col"}>
          <h3>READ ACCESS</h3>
          <div>Todos (data from Resource Server):</div>
          <ul>
            {todos.map((todo, i) => <li key={i}>{todo.text}</li>)}
          </ul>
        </section>
        {identityDetails && <section className={"p-col p-mb-4"}>
          <h3>WRITE ACCESS</h3>
          <h1>Add a ToDo</h1>
          <div>
            <form onSubmit={onAddTodo}>
              <div><InputText id='todo' label='Type in a Todo' onChange={onTodoChange} value={newTodo}/>
                <Button type={"submit"}>Add ToDo</Button></div>
            </form>
          </div>
        </section>}
      </section>
    </>
  );

  return (
    <div>
      <h1>Welcome to a secure app!</h1>
      <section>
        Tweak and configure @ <a target={"_blank"} rel={"noreferrer"}
                                 href="http://localhost:8080/auth/admin/master/console/#/realms/secure_application_realm">Keycloak
        Server: secure_application_realm</a>
      </section>
      <section>
        {identityDetails && renderUserDetails()}
        {!identityDetails && <Button onClick={performLogin}>Log in</Button>}
      </section>
    </div>
  );
}

export default Home;