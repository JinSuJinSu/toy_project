import Loadable from 'app/layouts/Loadable';
import { lazy } from 'react';

const DomesticStockApp = Loadable(
  lazy(() => import('./domestic/DomesticStockApp'))
);
const DomesticStockMarketApp = Loadable(
  lazy(() => import('./domestic-market/DomesticStockMarketApp'))
);
const OverseasStockApp = Loadable(
  lazy(() => import('./overseas/OverseasStockApp'))
);
const OverseasStockMarketApp = Loadable(
  lazy(() => import('./overseas-market/OverseasStockMarketApp'))
);

const StockRoutes = [
  {
    path: '/stock/domestic',
    element: <DomesticStockApp />,
  },
  {
    path: '/stock/overseas',
    element: <OverseasStockApp />,
  },
  {
    path: '/stock/domestic/market',
    element: <DomesticStockMarketApp />,
  },
  {
    path: '/stock/overseas/market',
    element: <OverseasStockMarketApp />,
  },
];

export default StockRoutes;
