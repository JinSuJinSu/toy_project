import React from "react";
import { useEffect, useContext } from "react";
import CategoryView from "../view/CategoryView";
import { CategoryStore } from "../store/CategoryStore";
import { UserContext } from "app/contexts/UserContext";
import { toJS } from "mobx";
import { observer } from "mobx-react-lite";

const CategoryContainer = observer(() => {
  const userId = useContext(UserContext);

  useEffect(() => {
    CategoryStore.showCategory(userId);
  }, [CategoryStore.list]);

  const handleChange = (index) => {
    CategoryStore.changeDropDown(index);
  };

  return <CategoryView handleChange={handleChange} list={CategoryStore.list} />;
});

export default CategoryContainer;
