import SimpleCard from "app/layouts/SimpleCard";
import { ContainerStyle } from "app/utils/Container";
import ExcelContainer from "./container/ExcelContainer";

const InsertApp = () => {
  return (
    <ContainerStyle>
      <SimpleCard title="엑셀 데이터">
        <ExcelContainer />
      </SimpleCard>
    </ContainerStyle>
  );
};

export default InsertApp;
