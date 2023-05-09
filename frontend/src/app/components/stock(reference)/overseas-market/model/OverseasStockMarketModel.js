import { numberFormat } from "app/utils/tableUtils";

export const numberLogic = (data) => {
  const newData = data;
  data.forEach((element) => {
    element.price = numberFormat(element.price);
    element.totalPrice = numberFormat(element.totalPrice);
  });

  return newData;
};
