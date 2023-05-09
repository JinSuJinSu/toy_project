import Loadable from "app/layouts/Loadable";
import { lazy } from "react";

const InsertApp = Loadable(lazy(() => import("./InsertApp")));
const InsertRoutes = [
  {
    path: "/income-spending/insert",
    element: <InsertApp />,
  },
];

export default InsertRoutes;
