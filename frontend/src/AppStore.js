import { BasicStore } from "app/components/data-search/basic/store/BasicStore";
import { ExcelStore } from "app/components/data-insert/store/ExcelStore";
const AppStore = () => {
  return {
    BasicStore,
    ExcelStore,
  };
};

export default AppStore;
