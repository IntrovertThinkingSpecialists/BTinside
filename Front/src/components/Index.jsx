import React from 'react';

const Index = () => {
  return (
    <div style={{ textAlign: 'center' }}>
      <div style={{ textAlign: 'end' }}>
        <button>프로필</button>
        <button>사이트 변경</button>
      </div>

      <h3>제목</h3>
      <div style={{ border: '1px solid #ccc', padding: '10px', width: '200px', margin: '0 auto' }}>
        본문내용
        <br />
        <button>❤</button>
        <button>💬</button>
      </div>

      <br />

      <img
        src='https://mblogthumb-phinf.pstatic.net/MjAyMDExMDFfMTIx/MDAxNjA0MjI5MTA4NzI3.yzCwf1e6qzFEThrElCICUzSLLlwmWPZBt2h_o4BCWccg.JeNepf4eBECV-hiBNC0mkeyRRpA8dh79Hf9fscBFadUg.JPEG.gambasg/%EC%9C%A0%ED%8A%9C%EB%B8%8C_%EA%B8%B0%EB%B3%B8%ED%94%84%EB%A1%9C%ED%95%84_BG.jpg?type=w400'
        style={{ width: '20px' }}
      />
      <text>댓글 내용</text>
      <button>❤</button>
      <button>💬</button>
    </div>
  );
};

export default Index;
