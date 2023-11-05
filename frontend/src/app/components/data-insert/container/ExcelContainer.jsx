import React from "react";
import { useState, useContext, useEffect } from "react";
import { UserContext } from "app/contexts/UserContext";
import { columns } from "../render/ExcelTableHeader";
import ExcelTableView from "../view/ExcelTableView";
import ExcelInsertContainer from "./ExcelInsertContainer";
import { observer } from "mobx-react-lite";
import * as XLSX from "xlsx";
import { Input } from "@mui/material";

const ExcelContainer = observer(() => {
  const height = 400;
  const pagingList = [5, 10, 20];
  const [pageSize, setPageSize] = React.useState(5);
  const [rows, setRows] = useState([]);

  const fileInput = React.createRef();
  const fileReader = new FileReader();

  const readExcel = (file) => {
    const promise = new Promise((resolve, reject) => {
      fileReader.readAsArrayBuffer(file);

      fileReader.onload = (e) => {
        const bufferArray = e.target.result;
        const wb = XLSX.read(bufferArray, { type: "buffer" });
        const wsname = wb.SheetNames[0];
        const ws = wb.Sheets[wsname];
        const data = XLSX.utils.sheet_to_json(ws).slice(0, -1);
        resolve(data);
      };

      fileReader.onerror = (error) => {
        reject(error);
      };
    });
    promise.then((rowData) => {
      rowData.forEach((row) => {
        row.id = row.No;
      });
      rowData.forEach((row) => {
        console.log("데이터를 구하시오 : ", row);
      });
      setRows(rowData);
    });
  };

  const handleFileInput = (e) => {
    const file = e.target.files[0];
    readExcel(file);
  };

  return (
    <>
      <ExcelInsertContainer rows={rows} />
      <Input type="file" ref={fileInput} onChange={handleFileInput} />
      {/* <ul>
        {rows.map((item, index) => (
          <li key={index}>{JSON.stringify(item)}</li>
        ))}
      </ul> */}
      <ExcelTableView
        height={height}
        rows={rows}
        columns={columns}
        pageSize={pageSize}
        setPageSize={setPageSize}
        pagingList={pagingList}
      />
    </>
  );
});

export default ExcelContainer;
