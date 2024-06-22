import React from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css';

const CalendarDate = () => {
  const timeOptions = [
    '00:00', '01:00', '02:00', '03:00', '04:00', '05:00', '06:00', '07:00',
    '08:00', '09:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00',
    '16:00', '17:00', '18:00', '19:00', '20:00', '21:00', '22:00', '23:00'
  ];
  
  return (
    <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
      <div style={{ textAlign: 'left', marginRight: '10px' }}>
        <img
          src="https://w7.pngwing.com/pngs/384/868/png-transparent-person-profile-avatar-user-basic-ui-icon.png"
          style={{ width: '20px' }}
          alt="avatar"
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
        <Calendar />
        <span>일정표</span>
        <select className="time">
          <option value="time">시간</option>
          {timeOptions.map((time, index) => (
            <option key={index} value={time}>{time}</option>
          ))}
        </select>
        <span>일정 내용</span>
        <button>추가</button>
        <button>삭제</button>
      </div>
    </div>
  );
};

export default CalendarDate;
