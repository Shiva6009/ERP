import axios from "axios";

export const AuthenticationRequest = (enteredUserName, enteredPassword) => {
  return axios.post(`${process.env.REACT_APP_BASE_URL}/api/v1/auth/login`, {
    userName: enteredUserName,
    password: enteredPassword,
  });
};

export const loginRequest = () => {
  return axios.post(`${process.env.REACT_APP_BASE_URL}/api/v2/login`, {
    userId: 1,
  });
};

export const logoutRequest = () => {
  return axios.post(`${process.env.REACT_APP_BASE_URL}/api/v2/logout`, {
    userId: 1,
    reason : null
  });
};
