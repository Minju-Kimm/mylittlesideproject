// src/components/LoginButton.js
import React from "react";

const LoginButton = ({ provider, onClick }) => {
  return <button onClick={onClick}>{provider}로 로그인</button>;
};

export default LoginButton;
