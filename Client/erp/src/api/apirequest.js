import axios from "axios";

export const loginRequest = (enteredUserName, enteredPassword) => {
  console.log(" Inside Login Request ");
  return axios.post(`${process.env.REACT_APP_BASE_URL}api/v1/auth/login`, {
    userName: enteredUserName,
    password: enteredPassword,
  });
};
