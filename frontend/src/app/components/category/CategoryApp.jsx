import CategoryContainer from "./container/CategoryContainer";
import { ContainerStyle } from "app/utils/Container";
import { SimpleCard } from "app/layouts";

const CategoryApp = () => {
  return (
    <ContainerStyle>
      <SimpleCard title="카테고리 목록">
        <CategoryContainer />
      </SimpleCard>
    </ContainerStyle>
  );
};

export default CategoryApp;
