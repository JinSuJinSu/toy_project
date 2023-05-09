import React from 'react';
import { useState, useContext, useEffect } from 'react';
import DomesticStockOrderView from '../view/DomesticStockOrderView';
import { DomesticStockStore } from '../store/DomesticStockStore';
import { UserContext } from 'app/contexts/UserContext';

const DomesticStockOrderContainer = () => {

  const userId = useContext(UserContext);
  const height = 400;

  const [open, setOpen] = React.useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  useEffect(() => {
    DomesticStockStore.showOrder(userId);
  }, []);

  return (
    <DomesticStockOrderView
    orderList={DomesticStockStore.orderList}
    height={height}
    open={open}
    handleOpen={handleOpen}
    handleClose={handleClose}
    />
  )
};

export default DomesticStockOrderContainer;
