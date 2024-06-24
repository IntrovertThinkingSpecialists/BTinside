import React from 'react';
import { Link } from 'react-router-dom';

function Login() {
  return (
    <div>
      <h1>로그인</h1>

        <span>아이디</span>
        <input type='text'/>
        <br />
        
        <span>비밀번호</span>
        <input type='text'/>
      <br />
      <button>로그인</button>
      <button>회원가입</button>
      <hr style={{ width: '50%', margin: '20px auto' }}/>
      <p><button>카카오 로그인</button></p>
      <p><button>네이버 로그인</button></p>
    </div>
  )
}

export default Login;
