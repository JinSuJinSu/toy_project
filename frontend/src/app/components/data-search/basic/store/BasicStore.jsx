import axios from "axios";
import { observable, runInAction } from "mobx";
import { toJS } from "mobx";
import { dateTimeLogic } from "../model/BasicModel";

const BasicStore = observable({
  rows: [
    {
      id: 1,
      creationDate: "2022-12-12",
      dataCode: "몰라",
      content: "글쎼",
      amount: 1000,
      category: "카타타",
    },
    {
      id: 2,
      creationDate: "2022-12-12",
      dataCode: "몰라",
      content: "글쎼",
      amount: 1000,
      category: "카타타",
    },
    {
      id: 3,
      creationDate: "2022-12-12",
      dataCode: "몰라",
      content: "글쎼",
      amount: 1000,
      category: "카타타",
    },
    {
      id: 4,
      creationDate: "2022-12-12",
      dataCode: "몰라",
      content: "글쎼",
      amount: 1000,
      category: "카타타",
    },
    {
      id: 5,
      creationDate: "2022-12-12",
      dataCode: "몰라",
      content: "글쎼",
      amount: 1000,
      category: "카타타",
    },
    {
      id: 6,
      creationDate: "2022-12-12",
      dataCode: "몰라",
      content: "글쎼",
      amount: 1000,
      category: "카타타",
    },
    {
      id: 7,
      creationDate: "2022-12-12",
      dataCode: "몰라",
      content: "글쎼",
      amount: 1000,
      category: "카타타",
    },
    {
      id: 8,
      creationDate: "2022-12-12",
      dataCode: "몰라",
      content: "글쎼",
      amount: 1000,
      category: "카타타",
    },
    {
      id: 9,
      creationDate: "2022-12-12",
      dataCode: "몰라",
      content: "글쎼",
      amount: 1000,
      category: "카타타",
    },
    {
      id: 10,
      creationDate: "2022-12-12",
      dataCode: "몰라",
      content: "글쎼",
      amount: 1000,
      category: "카타타",
    },
  ],
  orderList: [],

  // 거래내역서 날짜별 조회(임시 사용)
  showInfo(userId) {
    console.log("로그 출력");
  },

  // 단위테스트용 임시
  sendDate(startDate, endDate) {
    // Original date string
    let formatedStartDate = dateTimeLogic(startDate);
    let formatedEndDate = dateTimeLogic(endDate);
    return axios.get(`/api/test/${formatedStartDate}/${formatedEndDate}`);
  },

  // 거래내역서 날짜별 조회
  // showInfo(userId) {
  //   axios.get(`/api/stock/domestic/order/${userId}`).then((response) => {
  //     runInAction(() => {
  //       this.orderList = response.data;
  //     });
  //   });
  // },
});

export { BasicStore };
