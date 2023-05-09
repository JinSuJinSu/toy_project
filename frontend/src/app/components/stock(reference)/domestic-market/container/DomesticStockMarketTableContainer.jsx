import React from 'react';
import { useEffect, useContext } from 'react';
import { observer } from 'mobx-react-lite';
import AppStore from 'AppStore';
import { columns } from '../render/DomesticStockMarketTableHeader';
import { useState } from 'react';
import DomesticStockMarketTableView from '../view/DomesticStockMarketTableView';
import { UserContext } from 'app/contexts/UserContext';

const DomesticStockMarketTableContainer = observer(() => {

  const [pageSize, setPageSize] = useState(5);

  const height = 400;
  const pagingList = [5, 10, 20];

  const [open, setOpen] = React.useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);
  const userId = useContext(UserContext);

  const [formValues, setFormValues] = useState({
      name:"",
      count:"",
      userId:userId
  });

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setFormValues({ ...formValues, [name]: value });
    
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    DomesticStockMarketStore.OrderStock(formValues);
    handleClose();
    DomesticStockMarketStore.showDomesticStockMarket();
  }

  const { DomesticStockMarketStore } = AppStore();

  useEffect(() => {
    DomesticStockMarketStore.showDomesticStockMarket();
  }, []);

  return (
    <DomesticStockMarketTableView
      height={height}
      rows={DomesticStockMarketStore.rows}
      columns={columns}
      pageSize={pageSize}
      setPageSize={setPageSize}
      pagingList={pagingList}
      open={open}
      handleOpen={handleOpen}
      handleClose={handleClose}
      handleInputChange={handleInputChange}
      handleSubmit={handleSubmit}
    />
  );
});

export default DomesticStockMarketTableContainer;
