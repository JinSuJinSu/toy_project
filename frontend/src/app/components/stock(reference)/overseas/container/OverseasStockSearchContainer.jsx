import React from 'react';
import { useState } from 'react';
import OverseasStockSearchView from '../view/OverseasStockSearchView';
import { OverseasStockStore } from '../store/OverseasStockStore';

const OverseasStockSearchContainer = () => {
  const [searchValue, setSearchValue] = useState('');

  const handleChange = event => {
    setSearchValue(event.target.value);
  }

  const onSearch = () =>{
    const searchText = searchValue === '' ? 'ALL' : searchValue
    OverseasStockStore.showOverseasStock(searchText)
  }

  const inputSearch = (event) => {
    if (event.key === 'Enter'){
      event.preventDefault();
      onSearch();
    }
  }

  return (
    <OverseasStockSearchView
    searchValue={searchValue}
    handleChange={handleChange}
    onSearch={onSearch}
    inputSearch={inputSearch}
    />
  )
};

export default OverseasStockSearchContainer;
