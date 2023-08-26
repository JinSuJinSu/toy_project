import axios from "axios";
import { observable, runInAction } from "mobx";
import { addDropDown } from "../model/CategoryModel";
import { toJS } from "mobx";

const CategoryStore = observable({
  list: [],

  // 카테고리 목록 조회
  showCategory(userId) {
    // Original date string
    axios.get(`/api/category/${userId}`).then((response) => {
      console.log("axios 통신");
      runInAction(() => {
        const groupedData = response.data.reduce((acc, item) => {
          // console.log("acc", acc);
          // console.log("item", item);
          if (!acc[item.categoryName]) {
            acc[item.categoryName] = {};
          }
          if (!acc[item.categoryName][item.detailCategoryName]) {
            acc[item.categoryName][item.detailCategoryName] = [];
          }
          acc[item.categoryName][item.detailCategoryName].push(
            item.paymentData
          );
          return acc;
        }, {});
        console.log("그루핑된 값 : ", groupedData);
        this.list = groupedData;
      });
    });
  },

  changeDropDown(index) {
    this.list[index].isClosed = !this.list[index].isClosed;
  },
});

export { CategoryStore };
