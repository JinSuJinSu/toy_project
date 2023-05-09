import { styled } from '@mui/material';
import SimpleCard from 'app/layouts/SimpleCard';
import DomesticStockMarketContainer from './container/DomesticStockMarketTableContainer';
import DomesticStockMarketInsertContainer from './container/DomesticStockMarketInsertContainer';
import DomesticStockMarketSearchContainer from './container/DomesticStockMarketSearchContainer';
import { StyleContainer } from './render/StyleContainer';

const MarginStyle = styled('mark')(({ theme }) => ({
  marginLeft: '2em',
}));

const DomesticStockMarketApp = () => {
  return (
    <StyleContainer>
      <SimpleCard title="국내주식시장">
        <DomesticStockMarketSearchContainer/>
          <MarginStyle>
            <DomesticStockMarketInsertContainer/>
          </MarginStyle>
            <DomesticStockMarketContainer/>
      </SimpleCard>
    </StyleContainer>
  );
};

export default DomesticStockMarketApp;
