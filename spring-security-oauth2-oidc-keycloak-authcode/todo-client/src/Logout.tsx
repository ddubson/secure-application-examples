import React from "react";
import {useHistory} from "react-router-dom";
import {Button} from "primereact/button";

const Logout: React.FC = () => {
  const history = useHistory();

  const goHome = () => {
    history.push("/")
  }

  return (
    <div>
      <h2>Logged out!</h2>
      <Button onClick={goHome}>Go Home.</Button>
    </div>
  );
}

export default Logout;