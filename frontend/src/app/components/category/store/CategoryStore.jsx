import axios from "axios";
import { observable, action } from "mobx";
import { addDropDown } from "../model/CategoryModel";
import { toJS } from "mobx";

const CategoryStore = observable({
  list: [
    {
      id: 1,
      content: "식비",
      detailList: [
        {
          content: "편의점",
        },
        {
          content: "분식집",
        },
      ],
    },
    {
      id: 2,
      content: "자기개발",
      detailList: [
        {
          content: "권투",
        },
        {
          content: "인터넷강의",
        },
      ],
    },
    {
      id: 3,
      content: "투자",
      detailList: [
        {
          content: "주식",
        },
        {
          content: "달러",
        },
      ],
    },
  ],

  // 카테고리 목록 조회
  showCategory: action(function (userId) {
    this.list.forEach((element) => (element.isClosed = true));
  }),

  changeDropDown(index) {
    this.list[index].isClosed = !this.list[index].isClosed;
  },
});

export { CategoryStore };
