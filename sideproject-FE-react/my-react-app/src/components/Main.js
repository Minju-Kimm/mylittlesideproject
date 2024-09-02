import React from "react";
import Logout from "./LogoutPage";

const Main = () => {
  return (
    <div>
      <h1>메인 페이지입니다.</h1>
      <p>이 페이지에서 로그아웃할 수 있습니다.</p>
      {/* 로그아웃 버튼 */}
      <Logout />
    </div>
  );
};

export default Main;
