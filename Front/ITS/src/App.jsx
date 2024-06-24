import React from 'react';
import {BrowserRouter as Router} from 'react-router-dom'
import AppRoutes  from './routes/AppRoutes';
import Header from './components/common/Header';

function App() {
  return (
    <div className="App">
       <Router>
        <Header />
        <AppRoutes />
      </Router>
    </div>
  );
}

export default App;
