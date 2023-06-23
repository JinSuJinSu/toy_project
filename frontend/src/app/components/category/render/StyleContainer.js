import { styled } from "@mui/material";

export const StyleContainer = styled("div")(({ theme }) => ({
  margin: "30px",
  [theme.breakpoints.down("sm")]: {
    margin: "16px",
  },
  "& .breadcrumb": {
    marginBottom: "30px",
    [theme.breakpoints.down("sm")]: {
      marginBottom: "16px",
    },
  },
}));

export const modalStyle = {
  position: "absolute",
  top: "20%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: 400,
  bgcolor: "background.paper",
  border: "2px solid #000",
  boxShadow: 24,
  p: 4,
};

export const DropdownMenu = styled("div")({
  position: "relative",
  display: "inline-block",
});

export const DropdownContent = styled("div")(({ theme }) => ({
  display: "none",
  position: "absolute",
  right: 0,
  backgroundColor: "#f9f9f9",
  minWidth: "160px",
  boxShadow: "0px 8px 16px 0px rgba(0,0,0,0.2)",
  zIndex: 1,
}));

export const DropdownItem = styled("a")(({ theme }) => ({
  color: "black",
  padding: "12px 16px",
  textDecoration: "none",
  display: "block",
}));
