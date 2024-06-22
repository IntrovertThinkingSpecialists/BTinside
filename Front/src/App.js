import './App.css';

import React from 'react';

import Login from './components/Login';
import Join from './components/Join';
import Index from './components/Index';
import Mypage from './components/Mypage';
import Write from './components/Write';
import Update from './components/Update';
import CalendarDate from './components/CalendarDate';

function App() {
  return (
    <div className='App'>
      <Login></Login>
      <hr/>
      <Join></Join>
      <hr/>
      <Index></Index>
      <hr/>
      <Mypage></Mypage>
      <hr/>
      <Write></Write>
      <hr/>
      <Update></Update>
      <hr/>
      <CalendarDate></CalendarDate>
    </div>
  );
}

export default App;
