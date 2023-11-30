import React from "react";
import { observer } from "mobx-react-lite";
import { Button, Box } from "@mui/material";
const CategoryView = observer(
  ({
    list,
    selectedCategory,
    setSelectedCategory,
    selectedDetailCategory,
    setSelectedDetailCategory,
  }) => {
    return (
      <>
        <Box
          component="form"
          sx={{ "& > :not(style)": { m: 1, width: "25ch" } }}
          noValidate
          autoComplete="off"
        >
          <Button
            variant="contained"
            size="large"
            onClick={() => console.log("sibal")}
          >
            카테고리 삽입
          </Button>
        </Box>
      </>
    );
  }
);

export default CategoryView;
