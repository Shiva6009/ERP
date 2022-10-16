import React from "react";
import { createSlice } from "@reduxjs/toolkit";

const initalValue = {
  isAuthenticated: false,
  userId : 0
};

export const authenticationSlice = createSlice({
  name: "authenticationSlice",
  initialState: initalValue,
  reducers: {
    login: (state , action) => {
      state.isAuthenticated = !state.isAuthenticated;
      state.userId = action.payload
    },
    logout: (state , action) => {
      state.isAuthenticated = !state.isAuthenticated;
      state.userId = 0
    },
  },
});

export const authenticationSliceActions = authenticationSlice.actions

