import React from 'react';
import { useState } from 'react';
import DomesticStockSearchView from '../view/DomesticStockSearchView';
import { DomesticStockStore } from '../store/DomesticStockStore';

const DomesticStockSearchContainer = () => {
  const [searchValue, setSearchValue] = useState('');

  const handleChange = event => {
    setSearchValue(event.target.value);
  }

  const onSearch = () =>{
    const searchText = searchValue === '' ? 'ALL' : searchValue
    DomesticStockStore.showDomesticStock(searchText)
  }

  const inputSearch = (event) => {
    if (event.key === 'Enter'){
      event.preventDefault();
      onSearch();
    }
  }

  return (
    <DomesticStockSearchView
    searchValue={searchValue}
    handleChange={handleChange}
    onSearch={onSearch}
    inputSearch={inputSearch}
    />
  )
};

export default DomesticStockSearchContainer;
