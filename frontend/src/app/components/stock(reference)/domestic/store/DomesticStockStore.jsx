import axios from 'axios';
import { observable, runInAction } from 'mobx';
import { numberLogic } from '../model/DomesticStockModel';

const DomesticStockStore = observable({
  rows : [],
  orderList : [],

  showDomesticStock(text='ALL') {
    axios.get(`/api/stock/domestic/${text}`)
    .then((response) => {
      runInAction(()=>{
      this.rows = numberLogic(response.data);
    })
  })
  },
  
  // 주식시장 주문 현황 조회
  showOrder(userId) {
    axios.get(`/api/stock/domestic/order/${userId}`)
    .then((response) => {
      runInAction(()=>{
      this.orderList = response.data;
    })
  })
  }
});

export { DomesticStockStore };
