import { styled } from '@mui/material';
import SimpleCard from 'app/layouts/SimpleCard';
import OverseasStockMarketSearchContainer from './container/OverseasStockMarketSearchContainer';
import OverseasStockMarketTableContainer from './container/OverseasStockMarketTableContainer';
import OverseasStockMarketInsertContainer from './container/OverseasStockMarketInsertContainer';
import { StyleContainer } from './render/StyleContainer';

const MarginStyle = styled('mark')(({ theme }) => ({
  marginLeft: '2em',
}));

const OverseasStockMarketApp = () => {
  return (
    <StyleContainer>
      <SimpleCard title="해외주식시장">
          <OverseasStockMarketSearchContainer/>
          <MarginStyle>
            <OverseasStockMarketInsertContainer/>
          </MarginStyle>
        <OverseasStockMarketTableContainer/>
      </SimpleCard>
    </StyleContainer>
  );
};

export default OverseasStockMarketApp;
