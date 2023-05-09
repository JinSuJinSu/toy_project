import React from 'react';
import { useState } from 'react';
import DomesticStockMarketSearchView from '../view/DomesticStockMarketSearchView';
import { DomesticStockMarketStore } from '../store/DomesticStockMarketStore';

const SearchContainer = () => {
  const [searchValue, setSearchValue] = useState('');

  const handleChange = event => {
    setSearchValue(event.target.value);
  }

  const onSearch = () =>{
    DomesticStockMarketStore.showDomesticStockMarket(searchValue)
  }

  const inputSearch = (event) => {
    if (event.key === 'Enter'){
      event.preventDefault();
      onSearch();
    }
  }

  return (
    <DomesticStockMarketSearchView
    searchValue={searchValue}
    handleChange={handleChange}
    onSearch={onSearch}
    inputSearch={inputSearch}
    />
  )
};

export default SearchContainer;
