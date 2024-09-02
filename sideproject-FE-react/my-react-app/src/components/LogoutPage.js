import React from "react";

const Logout = () => {
  const handleLogout = async () => {
    try {
      const response = await fetch("http://localhost:8080/api/user/logout", {
        method: "GET",
        credentials: "include", // 쿠키와 함께 요청을 보낼 때 사용
      });
      if (response.ok) {
        alert(
          "로그아웃에 성공하였습니다. 축하할 일인가요? 일단 축하드립니다. ㅎㅎ"
        );
        window.location.href = "http://localhost:3000"; // 로그아웃 후 메인 페이지로 리다이렉트
      } else {
        alert("로그아웃에 실패하였습니다.");
      }
    } catch (error) {
      console.error("Error:", error);
      alert("로그아웃 중 오류가 발생했습니다.");
    }
  };

  return <button onClick={handleLogout}>Logout</button>;
};

export default Logout;
