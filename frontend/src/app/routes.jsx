import SearchRoutes from "./components/data-search/SearchRoutes";
import InsertRoutes from "./components/data-insert/InsertRoutes";
import CategoryRoutes from "./components/category/CategoryRoutes";
import { Navigate } from "react-router-dom";
import MatxLayout from "./layouts/MatxLayout/MatxLayout";

const routes = [
  {
    element: <MatxLayout />,
    children: [...SearchRoutes, ...InsertRoutes, ...CategoryRoutes],
  },
  { path: "/", element: <Navigate to="/income-spending/table" /> },
];

export default routes;
