import React from 'react';

const Mypage = () => {
  return (
    <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
      <div style={{ textAlign: 'left', marginRight: '10px' }}>
        <img
          src="https://w7.pngwing.com/pngs/384/868/png-transparent-person-profile-avatar-user-basic-ui-icon.png"
          style={{ width: '20px' }}
        />
        <br />
        <span>닉네임</span>
        <br />
        <button>정보수정</button>
        <br />
        <button>글쓰기</button>
        <br />
        <span>카테고리</span>
        <br />
        <button>일정</button>
        <br />
        <button>사이트 변경</button>
      </div>
      <div style={{ textAlign: 'center', marginLeft: '10px', minWidth: '200px' }}>
        <p>카테고리</p>
        <span>글 제목</span>
        <div style={{ textAlign: 'end' }}>
          <button>수정</button>
          <button>삭제</button>
        </div>
        <div style={{ border: '1px solid #ccc', padding: '10px', width: '200px', margin: '0 auto' }}>
          본문내용
          <br />
          <button>❤</button>
          <button>💬</button>
        </div>
        <br />

        <img
          src="https://w7.pngwing.com/pngs/384/868/png-transparent-person-profile-avatar-user-basic-ui-icon.png"
          style={{ width: '20px' }}
        />
        <text>댓글 내용</text>
        <button>❤</button>
        <button>💬</button>
        <button>댓글삭제</button>
      </div>
    </div>
  );
};

export default Mypage;
