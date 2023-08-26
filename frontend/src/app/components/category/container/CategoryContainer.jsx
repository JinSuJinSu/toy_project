import React from "react";
import { useEffect, useContext, useState } from "react";
import CategoryView from "../view/CategoryView";
import { CategoryStore } from "../store/CategoryStore";
import { UserContext } from "app/contexts/UserContext";
import { toJS } from "mobx";
import { observer } from "mobx-react-lite";
import { Button } from "@mui/material";

const CategoryContainer = observer(() => {
  const userId = useContext(UserContext);
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [selectedDetailCategory, setSelectedDetailCategory] = useState(null);

  useEffect(() => {
    CategoryStore.showCategory(userId);
  }, [userId]);

  const handleChange = (index) => {
    CategoryStore.changeDropDown(index);
  };

  return (
    <CategoryView
      handleChange={handleChange}
      list={CategoryStore.list}
      selectedCategory={selectedCategory}
      setSelectedCategory={setSelectedCategory}
      selectedDetailCategory={selectedDetailCategory}
      setSelectedDetailCategory={setSelectedDetailCategory}
    />
  );
});

export default CategoryContainer;
