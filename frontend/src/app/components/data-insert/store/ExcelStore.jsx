import axios from "axios";
import { observable, runInAction } from "mobx";

const ExcelStore = observable({
  rows: [],

  // 데이터 전체 삽입
  insertData(userId, insertingData) {
    insertingData.forEach((element) => {
      element.userId = userId;
      if (element.withdraw > 0) {
        element.dataCode = "지출";
        element.amount = element.withdraw;
      }
      if (element.deposit > 0) {
        element.dataCode = "수입";
        element.amount = element.deposit;
      }
    });
    axios
      .post(`/api/incomeSpending/${userId}`, insertingData)
      .then((response) => {
        console.log(`데이터 삽입 완료 : ${response}`);
      });
  },
});

export { ExcelStore };
