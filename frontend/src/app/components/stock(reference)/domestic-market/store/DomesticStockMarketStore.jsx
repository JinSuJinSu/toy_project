import axios from 'axios';
import { observable, runInAction } from 'mobx';
import { numberLogic } from '../model/DomesticStockMarketModel';

const DomesticStockMarketStore = observable({
  rows : [],

  // 주식시장 현황 조회
  showDomesticStockMarket(text="") {
    axios.get(`/api/stock/domestic/market?text=${text}`)
    .then((response) => {
      runInAction(()=>{
      this.rows = numberLogic(response.data);
    })
  })
  },

  // 주식시장 주식 삽입
  InsertStockMarket(data) {
    axios.post(`/api/stock/domestic/market`,data)
    .then((response) => {
      console.log(response);
    })
  },

  // 주식시장 주식 주문(매수)
  OrderStock(data) {
    axios.post(`/api/stock/domestic/order`,data)
    .then((response) => {
      console.log(response);
    })
  },
})

export { DomesticStockMarketStore };
