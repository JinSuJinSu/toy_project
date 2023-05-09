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
  ).slice(-2)}-${("0" + date.getDate()).slice(-2)} ${(
    "0" + date.getHours()
  ).slice(-2)}:${("0" + date.getMinutes()).slice(-2)}:${(
    "0" + date.getSeconds()
  ).slice(-2)}`;
  // console.log(formateDate); // Output: 2023-05-02 20:37:15
  return formateDate;
};
