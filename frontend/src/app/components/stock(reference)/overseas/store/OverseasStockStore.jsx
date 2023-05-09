import axios from 'axios';
import { observable, runInAction } from 'mobx';
import { numberLogic } from '../model/OverseasStockModel';

const OverseasStockStore = observable({
  rows : [],
  showOverseasStock(text='ALL') {
    axios.get(`/api/stock/overseas/${text}`)
    .then((response) => {
      runInAction(()=>{
      this.rows = numberLogic(response.data);
    })
  })
  },
});

export { OverseasStockStore };
