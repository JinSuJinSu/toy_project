import SimpleCard from "app/layouts/SimpleCard";
import { ContainerStyle } from "app/utils/Container";
import BasicContainer from "./container/BasicContainer";
import BasicSearchContainer from "./container/BasicSearchContainer";

const BasicApp = () => {
  return (
    <ContainerStyle>
      <SimpleCard title="기본 조회">
        <BasicSearchContainer />
        <BasicContainer />
      </SimpleCard>
    </ContainerStyle>
  );
};

export default BasicApp;
