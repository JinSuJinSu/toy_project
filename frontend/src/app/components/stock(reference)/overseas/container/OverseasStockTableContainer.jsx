import React from 'react';
import { useEffect } from 'react';
import { observer } from 'mobx-react-lite';
import AppStore from 'AppStore';
import { columns } from '../render/OverseasStockTableHeader';
import OverseasStockTableView from '../view/OverseasStockTableView';

const OverseasStockTableContainer = observer(() => {

  const [pageSize, setPageSize] = React.useState(5);
  const height = 400;
  const pagingList = [5, 10, 20];
  
  const { OverseasStockStore } = AppStore();

  useEffect(() => {
    OverseasStockStore.showOverseasStock();
  }, []);

  return (
    <OverseasStockTableView
      height={height}
      rows={OverseasStockStore.rows}
      columns={columns}
      pageSize={pageSize}
      setPageSize={setPageSize}
      pagingList={pagingList}
    />
  );
});

export default OverseasStockTableContainer;
