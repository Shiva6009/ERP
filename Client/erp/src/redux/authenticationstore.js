import { configureStore, createSlice } from "@reduxjs/toolkit";

const initialState = {
  isAuthenticated: false,
};

const authenticationSlice = createSlice({
  name: "authentication",
  initialState,
  reducers: {
    login(state) {
      state.isAuthenticated = !state.isAuthenticated;
    },
    logout(state) {
      state.isAuthenticated = !state.isAuthenticated;
    },
  },
});

export const authenticationSliceAction = authenticationSlice.actions;

const store = configureStore({
  reducer: {
    authticationSlice: authenticationSlice.reducer,
  },
});

export default store;
