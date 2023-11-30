import { numberFormat } from "app/utils/tableUtils";

export const numberLogic = (data) => {
  const newData = data;
  data.forEach((element) => {
    element.price = numberFormat(element.price);
    element.totalPrice = numberFormat(element.totalPrice);
  });
  return newData;
};

export const dateTimeLogic = (dateTime) => {
  // Original date string
  let date = new Date(dateTime);
  // Format the Date object to a string in the desired format
  // Note: getMonth() returns 0-based month, hence the +1
  let formateDate = `${date.getFullYear()}-${(
    "0" +
    (date.getMonth() + 1)
  ).slice(-2)}-${("0" + date.getDate()).slice(-2)}`;
  // console.log(formateDate); // Output: 2023-05-02
  // // console.log(formateDate); // Output: 2023-05-02
  return formateDate;
};

export const checkCategory = (dataList) => {
  let returnList = dataList;
  returnList.forEach((data) => {
    console.log("man!!!");
    // if (data.categoryName === null || data.categoryName === undefined) {
    if ((data.categoryName ?? "") === "") {
      console.log("ememememem");
      data.categoryName = "없음";
    }
  });
  return returnList;
};

// let formateDate = `${date.getFullYear()}-${(
//   "0" +
//   (date.getMonth() + 1)
// ).slice(-2)}-${("0" + date.getDate()).slice(-2)} ${(
//   "0" + date.getHours()
// ).slice(-2)}:${("0" + date.getMinutes()).slice(-2)}:${(
//   "0" + date.getSeconds()
// ).slice(-2)}`;
// console.log(formateDate); // Output: 2023-05-02 18:40:56
