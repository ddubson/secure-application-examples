import React from 'react';
import {BrowserRouter, Route} from 'react-router-dom';
import Home from "./Home";
import AuthCallback from "./AuthCallback";
import {oidc} from "./config";
import Logout from "./Logout";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Route exact path='/' render={() => <Home oidc={oidc}/>}/>
        <Route path='/callback' render={() => <AuthCallback/>}/>
        <Route exact path='/logout' render={() => <Logout/>}/>
      </BrowserRouter>
    </div>
  );
}

export default App;
