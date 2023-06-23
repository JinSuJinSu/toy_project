import { numberFormat } from "app/utils/tableUtils";

export const addDropDown = (list) => {
  list.forEach((element) => (element.isClosed = true));
};
