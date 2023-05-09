import React from "react";
import { useState, useContext, useEffect } from "react";
import BasicSearchView from "../view/BasicSearchView";
import { BasicStore } from "../store/BasicStore";

const BasicSearchContainer = () => {
  const date = new Date();
  date.setDate(date.getDate() - 7); // 기본 조회는 오늘 기준 최대 7일 까지만
  const [startDate, setStartDate] = useState(date);
  const [endDate, setEndDate] = useState(new Date());
  const onSearch = () => {
    BasicStore.sendDate(startDate, endDate);
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
