import { tableHeaderFlex } from "app/utils/tableUtils";

let columns = [
  {
    field: "id",
    headerName: "No",
  },
  {
    field: "transactionDate",
    headerName: "거래일시",
  },
  {
    field: "content",
    headerName: "거래내용",
  },
  {
    field: "deposit",
    headerName: "입금",
  },
  {
    field: "withdraw",
    headerName: "출금",
  },
];

tableHeaderFlex(columns);
export { columns };
