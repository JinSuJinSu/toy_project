import { tableHeaderFlex } from "app/utils/tableUtils";

let columns = [
  {
    field: "id",
    headerName: "No",
  },
  {
    field: "거래일시",
    headerName: "거래일시",
  },
  {
    field: "거래내용",
    headerName: "거래내용",
  },
  {
    field: "입금",
    headerName: "입금",
  },
  {
    field: "출금",
    headerName: "출금",
  },
];

tableHeaderFlex(columns);
export { columns };
