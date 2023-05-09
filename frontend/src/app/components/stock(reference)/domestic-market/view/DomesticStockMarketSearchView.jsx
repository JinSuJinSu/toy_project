import React from 'react'
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';

const DomesticStockMarketSearchView = ({
  handleChange,
  searchValue,
  onSearch,
  inputSearch
}) => {

  return (
    <>
      <Box
      component="form"
      sx={{'& > :not(style)': { m: 1, width: '25ch' }}}
      noValidate
      autoComplete="off"
      >
        <TextField 
        id="outlined-basic" 
        label="Outlined" 
        variant="outlined"
        onChange={handleChange}
        value={searchValue}
        onKeyDown={inputSearch}
        />
    </Box>
    <Button variant="contained" size="large"
      onClick={onSearch}>조회</Button>
  </>
  )
}

export default DomesticStockMarketSearchView