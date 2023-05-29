import React from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import LocalizationProvider from "@mui/lab/LocalizationProvider";
import AdapterDateFns from "@mui/lab/AdapterDateFns";
import DesktopDatePicker from "@mui/lab/DesktopDatePicker";

const BasicSearchView = ({
  startDate,
  setStartDate,
  endDate,
  setEndDate,
  onSearch,
}) => {
  return (
    <>
      <Box
        component="form"
        sx={{ "& > :not(style)": { m: 1, width: "25ch" } }}
        noValidate
        autoComplete="off"
      >
        <LocalizationProvider dateAdapter={AdapterDateFns}>
          <DesktopDatePicker
            label={"거래내역 시작일자"}
            value={startDate}
            inputFormat={"yyyy-MM-dd"}
            mask={"____-__-__"}
            onChange={(newDate) => {
              setStartDate(newDate);
            }}
            renderInput={(params) => <TextField {...params} />}
          />
          <DesktopDatePicker
            label={"거래내역 종료일자"}
            value={endDate}
            inputFormat={"yyyy-MM-dd"}
            mask={"____-__-__"}
            onChange={(newDate) => {
              setEndDate(newDate);
            }}
            renderInput={(params) => <TextField {...params} />}
          />
        </LocalizationProvider>
      </Box>
      <Button variant="contained" size="large" onClick={onSearch}>
        조회
      </Button>
    </>
  );
};

export default BasicSearchView;
