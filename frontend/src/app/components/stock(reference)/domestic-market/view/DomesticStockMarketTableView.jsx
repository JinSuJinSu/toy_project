import * as React from 'react';
import { Box } from '@mui/system';
import { Button, Modal, Input, InputLabel, Typography, Select, 
  FormControl, MenuItem, } from '@mui/material';
import { DataGrid } from '@mui/x-data-grid';
import styled from '@emotion/styled';
import { modalStyle } from '../render/StyleContainer';
import uuid from 'react-uuid'
// This method is created for cross-browser compatibility, if you don't
// need to support IE11, you can use Array.prototype.sort() directly

const DomesticStockMarketTableView = ({
  height,
  rows,
  columns,
  pageSize,
  setPageSize,
  pagingList,
  open,
  setOpen,
  handleOpen,
  handleClose,
  handleInputChange,
  handleSubmit,
  getRowNodeId
}) => {
  const MarginStyle = styled('mark')(({ theme }) => ({
    marginLeft: '2em',
  }));

  return (
    <Box sx={{ height: height, width: "100%" }}>
      <Button 
        variant="contained" 
        size="large"
        onClick={handleOpen}
        >
        주식주문
      </Button>
    <Modal
      open={open}
      onClose={handleClose}
      aria-labelledby="modal-modal-title"
      aria-describedby="modal-modal-description"
    >
      <Box sx={modalStyle}>
        <Typography id="modal-modal-description">
            주문할 주식 항목 선택 후 수량을 입력하세요
            <FormControl variant="standard" sx={{ m: 1, minWidth: 120 }}>
              <InputLabel id="standard-label">주식항목</InputLabel>
              </FormControl>
              <FormControl>
              <Select
                labelId="standard-label"
                id="standard"
                onChange={handleInputChange}
                name={"name"}
              >
                {rows.map(row=>{
                  return <MenuItem key={uuid()} 
                  value={row.name}>{row.name}</MenuItem>
                })}
                
              </Select>
              </FormControl>
            <FormControl>
              <Input id="stock-count" name="count" onChange={handleInputChange}/>
            </FormControl>
        </Typography>
        
          <Button 
            variant="contained" 
            size="large"
            onClick={handleSubmit}
            >
              주문완료
          </Button>
          <MarginStyle>
            <Button 
              variant="contained" 
              size="large"
              onClick={handleClose}
              >
                주문취소
            </Button>
          </MarginStyle>
        </Box>
    </Modal>
      <DataGrid
        rows={rows}
        columns={columns}
        pageSize={pageSize}
        onPageSizeChange={(pageSize) => setPageSize(pageSize)}
        rowsPerPageOptions={pagingList}
        disableSelectionOnClick
        experimentalFeatures={{ newEditingApi: true }}
      />
      </Box>
  );
}
export default DomesticStockMarketTableView;
