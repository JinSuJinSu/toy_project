import * as React from "react";
import { Box } from "@mui/system";
import { DataGrid } from "@mui/x-data-grid";
// This method is created for cross-browser compatibility, if you don't
// need to support IE11, you can use Array.prototype.sort() directly

const ExcelTableView = ({
  height,
  rows,
  columns,
  pageSize,
  setPageSize,
  pagingList,
}) => {
  console.log("데이터 : ", rows);
  return (
    <Box sx={{ height: height, width: "100%" }}>
      <DataGrid
        rows={rows}
        columns={columns}
        // pageSize={pageSize}
        // onPageSizeChange={(pageSize) => setPageSize(pageSize)}
        // rowsPerPageOptions={pagingList}
        initialState={{
          pagination: { paginationModel: { pageSize: 5 } },
        }}
        pageSizeOptions={[5, 10, 25]}
        disableSelectionOnClick
        experimentalFeatures={{ newEditingApi: true }}
      />
    </Box>
  );
};
export default ExcelTableView;
