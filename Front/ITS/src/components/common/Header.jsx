import React, { useState, useEffect } from 'react';
import { Navbar, Nav, Button, Form, FormControl, Modal } from 'react-bootstrap';
import { useNavigate, useLocation } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../../assets/styles/Header.scss';

const Header = () => {
  const [show, setShow] = useState(false);
  const [navbarBg, setNavbarBg] = useState('#0f9d58'); // 기본 배경색을 초록색으로 설정
  const navigate = useNavigate();
  const location = useLocation();

  useEffect(() => {
    if (location.pathname === '/tech') {
      setNavbarBg('#343a40'); // 어두운 색
    } else {
      setNavbarBg('#0f9d58'); // 초록색
    }
  }, [location.pathname]);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  const handleLogin = (event) => {
    event.preventDefault();
    const email = event.target.elements.email.value;
    if (email.startsWith('D')) {
      navigate('/');
    } else if (email.startsWith('T')) {
      navigate('/tech');
    }
  };

  return (
    <>
      <Navbar style={{ backgroundColor: navbarBg }} expand="lg">
        <Navbar.Brand href="/" style={{ color: '#fff' }}>BTinside</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="mr-auto">
            <Nav.Link href="/" style={{ color: '#fff' }}>Home</Nav.Link>
            <Nav.Link href="/tech" style={{ color: '#fff' }}>Tech</Nav.Link>
          </Nav>
          <Form className="d-flex mr-sm-2">
            <FormControl type="text" placeholder="Search" className="mr-sm-2" />
            <Button variant="outline-light">Search</Button>
          </Form>
          <Button variant="primary" onClick={handleShow} className="mr-2">
            Login
          </Button>
          <Button variant="outline-light">
            <i className="fas fa-bell"></i>
          </Button>
        </Navbar.Collapse>
      </Navbar>

      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>로그인</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form onSubmit={handleLogin}>
            <Form.Group controlId="formBasicEmail">
              <Form.Label>이메일로 로그인</Form.Label>
              <Form.Control type="email" placeholder="이메일을 입력하세요." name="email" />
            </Form.Group>
            <Button variant="primary" type="submit" className="mt-2">
              로그인
            </Button>
            <div className="mt-3">
              <Form.Label>소셜 계정으로 로그인</Form.Label>
              <div>
                <Button variant="outline-dark" className="mr-2">
                  <i className="fab fa-github"></i> GitHub
                </Button>
                <Button variant="outline-danger" className="mr-2">
                  <i className="fab fa-google"></i> Google
                </Button>
                <Button variant="outline-primary">
                  <i className="fab fa-naver"></i> Naver
                </Button>
              </div>
            </div>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            닫기
          </Button>
          <Button variant="link">회원가입</Button>
        </Modal.Footer>
      </Modal>
    </>
  );
};

export default Header;
