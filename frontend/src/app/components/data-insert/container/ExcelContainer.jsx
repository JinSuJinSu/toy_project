import React from "react";
import { useState, useContext, useEffect } from "react";
import BasicTableView from "../view/BasicTableView";
import { UserContext } from "app/contexts/UserContext";
import { columns } from "../render/BasicTableHeader";
import AppStore from "AppStore";
import { observer } from "mobx-react-lite";

const ExcelContainer = observer(() => {
  const userId = useContext(UserContext);
  const height = 400;
  const pagingList = [5, 10, 20];
  const [pageSize, setPageSize] = React.useState(5);

  let startDate = new Date();
  startDate.setDate(new Date().getDate() - 7);
  const endDate = new Date();
  // 기본 조회는 오늘 기준 최대 7일 까지만

  const { BasicStore } = AppStore();

  useEffect(() => {
    BasicStore.showInfo(userId, startDate, endDate);
  }, []);

  return (
    <BasicTableView
      height={height}
      rows={BasicStore.rows}
      columns={columns}
      pageSize={pageSize}
      setPageSize={setPageSize}
      pagingList={pagingList}
    />
  );
});

export default ExcelContainer;
