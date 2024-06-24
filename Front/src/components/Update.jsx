import React from 'react';

const Update = () => {
  return (
    <div>
      <h1>정보 수정</h1>
      <img
        src="https://w7.pngwing.com/pngs/384/868/png-transparent-person-profile-avatar-user-basic-ui-icon.png"
        style={{ width: '20px' }}
      />
      <button>변경</button>
      <button>삭제</button>
      <br />

      <div>
        <input type='text' placeholder='닉네임' />
        <button>중복확인</button>
      </div>
      <br />

      <div>
        <input type='text' placeholder='블로그 주소' />
        <button>중복확인</button>
      </div>
      <br />

      <div>
        <input type='text' placeholder='카테고리' />
        <button>추가</button>
      </div>
      <br />

      <div>
        <span>카테고리 목록</span>
        <button>수정</button>
        <button>삭제</button>
      </div>
      <br />

      <div>
        <span>계정 기본 값</span>
        <label>
          <input type="radio" value="blog" />
          일상
        </label>
        <label>
          <input type="radio" value="tistory" />
          작업
        </label>
      </div>
      <br />

      <button>완료</button>
      <button>취소</button>
    </div>
  );
};

export default Update;
