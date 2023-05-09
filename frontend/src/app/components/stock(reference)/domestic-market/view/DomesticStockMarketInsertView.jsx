import React from 'react'
import { Button, Modal, Box, Typography, 
  FormControl, Input, InputLabel } from '@mui/material'
import { modalStyle } from '../render/StyleContainer'
import styled from '@emotion/styled';

const DomesticStockMarketInsertView = ({
  open,
  setOpen,
  handleOpen,
  handleClose,
  handleInputChange,
  handleSubmit
}) => {
  const MarginStyle = styled('mark')(({ theme }) => ({
  marginLeft: '2em',
}));
  return (
  <>
    <Button 
    variant="contained" 
    size="large"
    onClick={handleOpen}
    >
      항목추가
    </Button>
    <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={modalStyle}>
          <Typography id="modal-modal-description" sx={{ mt: 2 }}>
            <div>
              <InputLabel htmlFor="stock">주식 항목</InputLabel>
              <Input id="stock-name" name="name" onChange={handleInputChange} />
              <InputLabel htmlFor="stock-name">주당 가격</InputLabel>
              <Input id="stock-price" name="price" onChange={handleInputChange}/>
              <InputLabel htmlFor="stock-count">등록 개수</InputLabel>
              <Input id="stock-count" name="count" onChange={handleInputChange}/>
              <Button onClick={handleSubmit}></Button>
            </div>
          </Typography>
          
          <Button 
            variant="contained" 
            size="large"
            onClick={handleSubmit}
            >
              등록하기
          </Button>
          <MarginStyle>
            <Button 
              variant="contained" 
              size="large"
              onClick={handleClose}
              >
                닫기
            </Button>
          </MarginStyle>
        </Box>

    </Modal>
  </>
  )
}

export default DomesticStockMarketInsertView