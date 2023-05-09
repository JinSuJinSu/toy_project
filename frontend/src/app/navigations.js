export const navigations = [
  { label: "가계부 프로그램", type: "label" },
  {
    name: "거래내역",
    icon: "trending_up",
    children: [
      {
        name: "기본(표)",
        path: "/income-spending/table",
        iconText: "E",
      },
      {
        name: "월별, 연도별(차트)",
        path: "/income-spending/chart",
        iconText: "E",
      },
    ],
  },
  {
    name: "거래내역서 삽입",
    icon: "trending_up",
    path: "/income-spending/insert",
    iconText: "E",
  },
  {
    name: "카테고리",
    icon: "trending_up",
    path: "/category",
    iconText: "E",
  },
];
