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
    field: "dataCode",
    headerName: "거래종류",
  },
  {
    field: "거래내용",
    headerName: "거래내용",
  },
  {
    field: "amount",
    headerName: "거래금액",
  },
];

tableHeaderFlex(columns);
export { columns };
