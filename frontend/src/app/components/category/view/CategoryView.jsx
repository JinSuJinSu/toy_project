import React from "react";
import {
  DropdownMenu,
  DropdownContent,
  DropdownItem,
} from "../render/StyleContainer";
import { faCaretDown, faCaretRight } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { observer } from "mobx-react-lite";
import { ListItem, ListItemText, List } from "@mui/material";
import DropDownContainer from "../container/DropDownContainer";
import { Button } from "@mui/material";
import { toJS } from "mobx";
const CategoryView = observer(
  ({
    list,
    selectedCategory,
    setSelectedCategory,
    selectedDetailCategory,
    setSelectedDetailCategory,
  }) => {
    return (
      <div>
        <div style={{ display: "flex", justifyContent: "space-between" }}>
          {Object.keys(list).map((categoryName) => (
            <Button
              key={categoryName}
              onClick={() => {
                setSelectedCategory(
                  selectedCategory === categoryName ? null : categoryName
                );
              }}
            >
              {categoryName}
            </Button>
          ))}
        </div>
        <div>
          {selectedCategory &&
            Object.keys(list[selectedCategory]).map((detailCategoryName) => (
              <Button
                key={detailCategoryName}
                onClick={() => {
                  setSelectedDetailCategory(
                    selectedDetailCategory === detailCategoryName
                      ? null
                      : detailCategoryName
                  );
                }}
              >
                {detailCategoryName}
              </Button>
            ))}
        </div>
        <div>
          {!!selectedCategory &&
            !!selectedDetailCategory &&
            !!list[selectedCategory][selectedDetailCategory] &&
            Object.keys(list[selectedCategory][selectedDetailCategory]).map(
              (paymentIndex) => (
                <ListItem key={paymentIndex}>
                  {list[selectedCategory][selectedDetailCategory][paymentIndex]}
                </ListItem>
              )
            )}
        </div>
      </div>
    );
  }
);

export default CategoryView;
