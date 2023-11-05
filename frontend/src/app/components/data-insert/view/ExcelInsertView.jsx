import React from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";

const ExcelInsertView = ({ insertData }) => {
  return (
    <>
      <Box
        component="form"
        sx={{ "& > :not(style)": { m: 1, width: "25ch" } }}
        noValidate
        autoComplete="off"
      >
        <Button variant="contained" size="large" onClick={insertData}>
          데이터 삽입
        </Button>
      </Box>
    </>
  );
};

export default ExcelInsertView;
