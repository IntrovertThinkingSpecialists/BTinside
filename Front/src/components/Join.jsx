import React from 'react';

const Join = () => {
  return (
    <div>
      <h1>회원가입</h1>
      <span>아이디</span>
      <input type='text' />
      <button>중복체크</button>
      <br />

      <span>비밀번호</span>
      <input type="password" />
      <br />

      <span>비밀번호 재확인</span>
      <input type="password" />
      <br />

      <span>이름</span>
      <input type="text" />
      <br />

      <span>핸드폰 번호</span>
      <input type="text" />
      <br />

      <div>
        <span>이메일</span>
        <input type="text" /> @
        <select className="box">
          <option value="type">직접 입력</option>
          <option value="naver.com">naver.com</option>
          <option value="google.com">google.com</option>
          <option value="hanmail.net">hanmail.net</option>
        </select>
      </div>

      <button>회원가입</button>
    </div>
  )
}

export default Join;
