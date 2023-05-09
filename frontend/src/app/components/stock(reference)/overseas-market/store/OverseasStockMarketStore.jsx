import axios from 'axios';
import { observable, runInAction } from 'mobx';
import { numberLogic } from '../model/OverseasStockMarketModel';

const OverseasStockMarketStore = observable({
  rows : [],
  showOverseasStockMarket(text="") {
    axios.get(`/api/stock/overseas/market?text=${text}`)
    .then((response) => {
      runInAction(()=>{
      this.rows = numberLogic(response.data);
    })
  })
  },
});

export { OverseasStockMarketStore };
