import { tableHeaderFlex } from "app/utils/tableUtils";

let columns = [
  {
    field: "id",
    headerName: "id",
  },
  {
    field: "name",
    headerName: "주식항목",
  },
  {
    field: "price",
    headerName: "주당가격",
  },
  {
    field: "count",
    headerName: "현재수량",
  },
  {
    field: "totalPrice",
    headerName: "총가격",
  },
  {
    field: "moneyUnit",
    headerName: "돈단위",
  },
];

tableHeaderFlex(columns);
export { columns };
