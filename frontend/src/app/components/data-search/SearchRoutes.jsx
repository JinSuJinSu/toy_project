import Loadable from "app/layouts/Loadable";
import { lazy } from "react";

const BasicApp = Loadable(lazy(() => import("./basic/BasicApp")));
const ChartApp = Loadable(lazy(() => import("./chart/ChartApp")));

const SearchRoutes = [
  {
    path: "/income-spending/table",
    element: <BasicApp />,
  },
  {
    path: "/income-spending/chart",
    element: <ChartApp />,
  },
];

export default SearchRoutes;
