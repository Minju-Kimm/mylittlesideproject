// src/components/Home.js
import React from "react";
import LoginButton from "./LoginButton";

const Home = () => {
  const handleLogin = (provider) => {
    window.location.href = `http://localhost:8080/oauth2/authorization/${provider}`;
  };

  return (
    <div>
      <h1>로그인 페이지</h1>
      <LoginButton provider="google" onClick={() => handleLogin("google")} />
      <LoginButton provider="naver" onClick={() => handleLogin("naver")} />
      <LoginButton provider="kakao" onClick={() => handleLogin("kakao")} />
    </div>
  );
};

export default Home;
