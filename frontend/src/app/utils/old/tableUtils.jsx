import { Box } from "@mui/system";
import { DataGrid } from "@mui/x-data-grid";

export const tableHeaderFlex = (headerColumns) => {
  headerColumns.forEach((element) => (element.flex = 1));
};

export const TableDataGrid = (
  {height,
    rows,
    columns,
    pageSize,
    setPageSize,
    pagingList}) => {
  return (
    <Box sx={{ height: height, width: "100%" }}>
      <DataGrid
        rows={rows}
        columns={columns}
        pageSize={pageSize}
        onPageSizeChange={(pageSize) => setPageSize(pageSize)}
        rowsPerPageOptions={pagingList}
        checkboxSelection
        disableSelectionOnClick
        experimentalFeatures={{ newEditingApi: true }}
      />
    </Box>
  );
};
