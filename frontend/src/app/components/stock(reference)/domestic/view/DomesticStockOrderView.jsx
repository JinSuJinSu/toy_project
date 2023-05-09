import * as React from 'react';
import {Button, Modal, ListItem, Typography, Box} from '@mui/material';
import { modalStyle } from '../render/StyleContainer';
import styled from '@emotion/styled';
import uuid from 'react-uuid';
// This method is created for cross-browser compatibility, if you don't
// need to support IE11, you can use Array.prototype.sort() directly

const DomesticStockOrderView = ({
  height,
  open,
  handleOpen,
  handleClose,
  orderList,
}) => {
  const MarginStyle = styled('mark')(({ theme }) => ({
    marginLeft: '2em',
  }));
  return (
    <>
      <MarginStyle>
        <Button
          variant="contained" 
          size="large"
          onClick={handleOpen}
          >
          주문목록
        </Button>
      </MarginStyle>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="order-title"
        aria-describedby="order-description"
      >
      <Box sx={modalStyle}>
          <Typography>현재까지 매수 주문한 목록</Typography>
          {orderList.map(order=>{
            console.log('주문 대령이요!!! : ',order)
            return(
            <ListItem key={uuid()}>
              매수 대기 : {order.name}
              <br/>
              주문 수량 : {order.count}
              <br/>
              주문 날짜 : {order.orderDate}
            </ListItem>
            )
          })}
        </Box>
      </Modal>
  </>
  );
}
export default DomesticStockOrderView;
