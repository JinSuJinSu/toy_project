import React from 'react'
import DomesticStockMarketInsertView from '../view/DomesticStockMarketInsertView'
import { DomesticStockMarketStore } from '../store/DomesticStockMarketStore';
import { useState } from 'react';

const DomesticStockMarketInsertContainer = () => {

  const [open, setOpen] = React.useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  const [formValues, setFormValues] = useState({
      name:"",
      price:"",
      count:""
  });

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setFormValues({ ...formValues, [name]: value });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    DomesticStockMarketStore.InsertStockMarket(formValues);
  }


  return (
    <DomesticStockMarketInsertView
    open={open}
    setOpen={setOpen}
    handleOpen={handleOpen}
    handleClose={handleClose}
    handleInputChange={handleInputChange}
    handleSubmit={handleSubmit}
    />
  )
}

export default DomesticStockMarketInsertContainer;