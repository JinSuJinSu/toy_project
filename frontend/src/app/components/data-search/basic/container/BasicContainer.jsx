import React from "react";
import { useState, useContext, useEffect } from "react";
import BasicTableView from "../view/BasicTableView";
import { UserContext } from "app/contexts/UserContext";
import { columns } from "../render/BasicTableHeader";
import { toJS } from "mobx";
import AppStore from "AppStore";

const BasicContainer = () => {
  const userId = useContext(UserContext);
  const height = 400;
  const [pageSize, setPageSize] = React.useState(5);
  const pagingList = [5, 10, 20];

  const { BasicStore } = AppStore();

  useEffect(() => {
    BasicStore.showInfo(userId);
    console.log("결과값 : ", toJS(BasicStore.rows));
  }, []);

  return (
    <BasicTableView
      rows={BasicStore.rows}
      columns={columns}
      height={height}
      pageSize={pageSize}
      setPageSize={setPageSize}
      pagingList={pagingList}
    />
  );
};

export default BasicContainer;
