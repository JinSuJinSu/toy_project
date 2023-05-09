import React from 'react';
import { useEffect } from 'react';
import { observer } from 'mobx-react-lite';
import AppStore from 'AppStore';
import { columns } from '../render/OverseasStockMarketTableHeader';
import OverseasStockMarketTableView from '../view/OverseasStockMarketTableView';

const OverseasStockMarketTableContainer = observer(() => {

  const [pageSize, setPageSize] = React.useState(5);
  const height = 400;
  const pagingList = [5, 10, 20];
  
  const { OverseasStockMarketStore } = AppStore();

  useEffect(() => {
    OverseasStockMarketStore.showOverseasStockMarket();
  }, []);

  return (
    <OverseasStockMarketTableView
      height={height}
      rows={OverseasStockMarketStore.rows}
      columns={columns}
      pageSize={pageSize}
      setPageSize={setPageSize}
      pagingList={pagingList}
    />
  );
});

export default OverseasStockMarketTableContainer;
