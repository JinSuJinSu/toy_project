import { tableHeaderFlex } from "app/utils/tableUtils";

let columns = [
  {
    field: "id",
    headerName: "No",
  },
  {
    field: "creationDate",
    headerName: "거래일시",
  },
  {
    field: "dataCode",
    headerName: "거래종류",
  },
  {
    field: "content",
    headerName: "거래내용",
  },
  {
    field: "amount",
    headerName: "거래금액",
  },
  {
    field: "category",
    headerName: "카테고리",
  },
];

tableHeaderFlex(columns);
export { columns };
