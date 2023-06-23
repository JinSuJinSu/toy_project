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
const CategoryView = observer(({ list, handleChange }) => {
  return (
    <DropdownMenu>
      {list.map((element, index) => {
        return (
          <>
            {element.content}
            <FontAwesomeIcon
              key={element.id}
              icon={element.isClosed ? faCaretRight : faCaretDown}
              style={{ fontSize: "24px", cursor: "pointer" }}
              onClick={() => handleChange(index)}
            />
            {!element.isClosed
              ? element.detailList.map((detailElement) => {
                  return <li>{detailElement.content}</li>;
                })
              : ""}
            <br />
            <br />
            <br />
          </>
        );
      })}
      <DropdownContent>
        <DropdownItem href="#">Link 1</DropdownItem>
        <DropdownItem href="#">Link 2</DropdownItem>
        <DropdownItem href="#">Link 3</DropdownItem>
      </DropdownContent>
    </DropdownMenu>
  );
});

export default CategoryView;
