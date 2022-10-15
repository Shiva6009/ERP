import { configureStore } from "@reduxjs/toolkit";
import { authenticationSlice }  from "./autheticationSlice";

const store = configureStore({
  reducer: {
    authSlice: authenticationSlice.reducer
  },
});
export default store;
