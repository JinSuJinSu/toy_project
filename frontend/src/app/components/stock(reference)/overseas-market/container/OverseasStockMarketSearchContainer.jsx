import React from 'react';
import { useState } from 'react';
import OverseasStockMarketSearchView from '../view/OverseasStockMarketSearchView';
import { OverseasStockMarketStore } from '../store/OverseasStockMarketStore';

const OverseasStockMarketSearchContainer = () => {
  const [searchValue, setSearchValue] = useState('');

  const handleChange = event => {
    setSearchValue(event.target.value);
  }

  const onSearch = () =>{
    OverseasStockMarketStore.showOverseasStockMarket(searchValue)
  }

  const inputSearch = (event) => {
    if (event.key === 'Enter'){
      event.preventDefault();
      onSearch();
    }
  }

  return (
    <OverseasStockMarketSearchView
    searchValue={searchValue}
    handleChange={handleChange}
    onSearch={onSearch}
    inputSearch={inputSearch}
    />
  )
};

export default OverseasStockMarketSearchContainer;
