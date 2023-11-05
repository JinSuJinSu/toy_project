import axios from "axios";
import { observable, runInAction } from "mobx";
import { toJS } from "mobx";
import { dateTimeLogic } from "../model/BasicModel";

const BasicStore = observable({
  rows: [],

  // 날짜별 거래내역서 데이터 조회
  showInfo(userId, startDate, endDate) {
    // Original date string
    let formatedStartDate = dateTimeLogic(startDate);
    let formatedEndDate = dateTimeLogic(endDate);
    axios
      .get(
        `/api/incomeSpending/${userId}/${formatedStartDate}/${formatedEndDate}`
      )
      .then((response) => {
        runInAction(() => {
          this.rows = response.data;
        });
      });
  },
});

export { BasicStore };
