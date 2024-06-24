import React from 'react'

const Write = () => {
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
         <select className="kategory">
          <option value="kate">카테고리</option>
        </select>
        <span>글 제목</span>
        <div style={{ textAlign: 'end' }}>
          <button>저장</button>
          <button>발행</button>
        </div>
        <div style={{ border: '1px solid #ccc', padding: '10px', width: '200px', margin: '0 auto' }}> <button>기능</button>
          본문내용
        </div>
        <br />
      </div>
    </div>
  )
}

export default Write