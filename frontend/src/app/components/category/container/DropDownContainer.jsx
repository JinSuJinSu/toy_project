import React from "react";
import { useState } from "react";
import { Button } from "@mui/material";

const DropDownContainer = ({ title, children }) => {
  const [isOpen, setIsOpen] = useState(false);
  const [selectedCategory, setSelectedCategory] = useState(null);

  return (
    <>
      <Button
        onClick={() => {
          setIsOpen(!isOpen);
          setSelectedCategory(selectedCategory === title ? null : title);
        }}
      >
        {title}
      </Button>
      {isOpen && children}
    </>
  );
};

export default DropDownContainer;
