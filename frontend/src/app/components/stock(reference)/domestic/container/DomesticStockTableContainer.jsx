import React from 'react';
import { useEffect } from 'react';
import { observer } from 'mobx-react-lite';
import AppStore from 'AppStore';
import { columns } from '../render/DomesticStockTableHeader';
import DomesticStockTableView from '../view/DomesticStockTableView';

const DomesticStockTableContainer = observer(() => {

  const [pageSize, setPageSize] = React.useState(5);
  const height = 400;
  const pagingList = [5, 10, 20];
  
  const { DomesticStockStore } = AppStore();

  useEffect(() => {
    DomesticStockStore.showDomesticStock();
  }, []);

  return (
    <DomesticStockTableView
      height={height}
      rows={DomesticStockStore.rows}
      columns={columns}
      pageSize={pageSize}
      setPageSize={setPageSize}
      pagingList={pagingList}
    />
  );
});

export default DomesticStockTableContainer;
