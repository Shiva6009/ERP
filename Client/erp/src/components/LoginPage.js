import React, { useEffect, useState } from "react";
import "./LoginPage.css";
import loginImage from "../images/loginImage.png";
import axios from "axios";

const LoginPage = () => {
  const [enteredEmployeeId, setEnteredEmployeeId] = useState(null);
  const [enteredPassword, setEnteredPassword] = useState(null);

  const [errors, setErrors] = useState({
    employeeiderror: "",
    passworderror: "",
  });

  const loginButtonHandler = (event) => {
    setErrors(null);
    if (enteredEmployeeId == null) {
      setErrors((previousState) => ({
        ...previousState,
        employeeiderror: "Please enter Employee ID",
      }));
    } else if (enteredPassword == null) {
      setErrors((previousState) => ({
        ...previousState,
        passworderror: "Please enter Password",
      }));
    } else {
      event.preventDefault();
      axios
        .post("http://localhost:7070/ERP/loginverification", {
          userid: enteredEmployeeId,
          userpassword: enteredPassword,
        }
        )
        .then((response) => {
          if (response.status === 200 && response.data) {
            alert(" Success");
          } else {
            alert(" Failure");
          }
        })
        .catch((err) => {
          console.log(" Error ", err);
        });
    }
  };

  useEffect(() => {
    console.log(" FInal  Effect", errors);
  }, [errors]);

  const onChangeForEmployeeIdHandler = (event) => {
    setEnteredEmployeeId(event.target.value);
  };

  const onChnageForPasswordHandler = (event) => {
    setEnteredPassword(event.target.value);
  };

  return (
    <div className="landing-page">
      <div className="panel-div">
        <div className="wrapper-div">
          <div classNameName="image-bg">
            <img src={loginImage} />
          </div>
          <div className="content-bg">
            <div className="heading-group">
              <h2>Member Login</h2>
            </div>
            <div className="input-boxes-groups">
              <input
                type="text"
                onChange={onChangeForEmployeeIdHandler}
                placeholder="Employee ID "
              />
              {errors && <p>{errors.employeeiderror}</p>}
              <input
                type="text"
                onChange={onChnageForPasswordHandler}
                placeholder="Password"
              />
              {errors && <p>{errors.passworderror}</p>}
              <button onClick={loginButtonHandler} className="login-button">
                Log In
              </button>
              <a className="link-tag"> Forgot Password?</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default LoginPage;
