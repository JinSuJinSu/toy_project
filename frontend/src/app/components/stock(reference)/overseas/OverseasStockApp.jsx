import SimpleCard from 'app/layouts/SimpleCard';
import OverseasStockSearchContainer from './container/OverseasStockSearchContainer';
import OverseasStockTableContainer from './container/OverseasStockTableContainer';
import { StyleContainer } from './render/StyleContainer';

const OverseasStockApp = () => {
  return (
    <StyleContainer>
      <SimpleCard title="해외주식 재산현황">
        <OverseasStockSearchContainer/>
        <OverseasStockTableContainer/>
      </SimpleCard>
    </StyleContainer>
  );
};

export default OverseasStockApp;
