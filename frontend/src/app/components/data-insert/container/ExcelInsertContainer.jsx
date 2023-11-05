import React from "react";
import { useState, useContext } from "react";
import ExcelInsertView from "../view/ExcelInsertView";
import AppStore from "AppStore";
import { UserContext } from "app/contexts/UserContext";

const ExcelInsertContainer = ({ rows }) => {
  const userId = useContext(UserContext);
  const { ExcelStore } = AppStore();

  const insertData = () => {
    console.log("삽입해야 하는 데이터 :", rows);
    ExcelStore.insertData(userId, rows);
  };

  return <ExcelInsertView insertData={insertData} />;
};

export default ExcelInsertContainer;
