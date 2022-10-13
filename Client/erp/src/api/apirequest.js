import axios from "axios";

export const loginRequest = (enteredUserName, enteredPassword) => {
  return axios.post(`${process.env.REACT_APP_BASE_URL}/api/v1/auth/login`, {
    userName: enteredUserName,
    password: enteredPassword,
  });
};

export const checkRequest = () => {

  console.log(" Inside Check Request")
  axios
    .get(`${process.env.REACT_APP_BASE_URL}/api/v1/test`, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem("key")}`,
      },
    })
    .then((response) => {
      console.log(" Response", response);
    })
    .catch((error) => {
      console.log(" Error ", error);
    });
};
