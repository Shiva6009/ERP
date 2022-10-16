import React from "react";
import { styles } from "./Button.module.css";

const Button = (props) => {
  return <button onClick={props.onclick}>{props.children}</button>;
};

export default Button;
