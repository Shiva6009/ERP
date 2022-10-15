import React from "react";
import { createSlice } from "@reduxjs/toolkit";

const initalValue = {
  isAuthenticated: false,
};

export const authenticationSlice = createSlice({
  name: "authenticationSlice",
  initialState: initalValue,
  reducers: {
    login: (state) => {
      state.isAuthenticated = !state.isAuthenticated;
    },
    logout: (state) => {
      state.isAuthenticated = !state.isAuthenticated;
    },
  },
});

export const authenticationSliceActions = authenticationSlice.actions

