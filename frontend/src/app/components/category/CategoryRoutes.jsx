import Loadable from "app/layouts/Loadable";
import { lazy } from "react";

const CategoryApp = Loadable(lazy(() => import("./CategoryApp")));
const CategoryRoutes = [
  {
    path: "/category",
    element: <CategoryApp />,
  },
];

export default CategoryRoutes;
