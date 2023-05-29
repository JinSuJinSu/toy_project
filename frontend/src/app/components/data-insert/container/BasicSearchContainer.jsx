import React from "react";
import { useState, useContext } from "react";
import BasicSearchView from "../view/BasicSearchView";
import { BasicStore } from "../store/BasicStore";
import { UserContext } from "app/contexts/UserContext";

const BasicSearchContainer = () => {
  const userId = useContext(UserContext);
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date());

  const onSearch = () => {
    BasicStore.showInfo(userId, startDate, endDate);
  };

  return (
    <BasicSearchView
      startDate={startDate}
      setStartDate={setStartDate}
      endDate={endDate}
      setEndDate={setEndDate}
      onSearch={onSearch}
    />
  );
};

export default BasicSearchContainer;
