import React, { useEffect, useState } from "react";
import "./LoginPage.css";
import loginImage from "../../images/loginImage.png";
import axios from "axios";
import { AuthenticationRequest } from "../../api/apirequest";
import { useDispatch, useSelector } from "react-redux";
import { authenticationSliceActions } from "../../redux/autheticationSlice";

const LoginPage = () => {


  // Usage of Dispatch and Selector
  const isAuthenticated = useSelector(
    (state) => state.authSlice.isAuthenticated
  );
  const dispatch = useDispatch();

  // Internal State
  const [enteredEmployeeId, setEnteredEmployeeId] = useState(null);
  const [enteredPassword, setEnteredPassword] = useState(null);
  const [errors, setErrors] = useState({
    employeeiderror: "",
    passworderror: "",
  });

  // Handler Methods
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

      // Calling Springboot API
      AuthenticationRequest(enteredEmployeeId, enteredPassword)
        .then((response) => {
          console.log(" Response ", response);
          dispatch(authenticationSliceActions.login());
          localStorage.setItem("key", response.data.jwtToken);
        })
        .catch((error) => {
          console.log(" Error ", error);
        });
    }
  };
  useEffect(() => {
    console.log(" Env Variable ", isAuthenticated);
  }, [isAuthenticated]);

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
