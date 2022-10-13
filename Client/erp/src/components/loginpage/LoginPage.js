import React, { StrictMode, useEffect, useState } from "react";
import "./LoginPage.css";
import loginImage from "../../images/loginImage.png";
import { loginRequest } from "../../api/apirequest";
import { checkRequest } from "../../api/apirequest";
import { useSelector, useDispatch } from "react-redux";
import { authenticationSliceAction } from "../../redux/authenticationstore";

const LoginPage = () => {
  const isAuthenticated = useSelector(
    (state) => state.authticationSlice.isAuthenticated
  );
  const dispatch = useDispatch();

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
      loginRequest(enteredEmployeeId, enteredPassword)
        .then((response) => {
          console.log(" Response ", response);
          localStorage.setItem("key", response.data.jwtToken);
          dispatch(authenticationSliceAction.login());
          console.log(" Value ", isAuthenticated);
        })
        .catch((err) => {
          console.log(" Error ", err);
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

  const checkFunction = () => {
    checkRequest();
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

              <button onClick={checkFunction}>Check </button>
              <a className="link-tag"> Forgot Password?</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default LoginPage;
