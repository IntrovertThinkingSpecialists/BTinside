import React from 'react';
import { Container, Row, Col, Card, ListGroup, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useNavigate } from 'react-router-dom';
import '../../assets/styles/Homepage1.scss';

// Importing images
import daily1 from '../../assets/images/일상1.jpeg';
import daily2 from '../../assets/images/일상2.jpeg';
import daily3 from '../../assets/images/일상3.jpeg';
import tech1 from '../../assets/images/기술1.jpeg';
import tech2 from '../../assets/images/기술2.jpeg';
import tech3 from '../../assets/images/기술3.png';
const Homepage = () => {
  const navigate = useNavigate();
  return (
    <Container className="homepage mt-4">
      <div className="header">
        <div className="logo">BTinside</div>
        <div className="actions">
          <Button className="search-btn" variant="link">Search</Button>
          <Button className="notification-btn" variant="link">
            <i className="fas fa-bell"></i>
          </Button>
        </div>
      </div>
      <div className="content">
        <div className="main-content">
          <Button variant="primary" onClick={() => navigate('/daily-blog/post')} className="mb-4">
            글쓰기
          </Button>
          <div className="highlight-cards">
            <Card>
              <Card.Img variant="top" src={daily1} />
              <Card.Body>
                <Card.Title>Highlight 1</Card.Title>
              </Card.Body>
            </Card>
            <Card>
              <Card.Img variant="top" src={daily2} />
              <Card.Body>
                <Card.Title>Highlight 2</Card.Title>
              </Card.Body>
            </Card>
            <Card>
              <Card.Img variant="top" src={daily3} />
              <Card.Body>
                <Card.Title>Highlight 3</Card.Title>
              </Card.Body>
            </Card>
          </div>
          <ListGroup className="post-list">
            <ListGroup.Item>
              <Card>
                <Card.Img variant="top" src={tech1} />
                <Card.Body>
                  <Card.Title>Post Title 1</Card.Title>
                  <Card.Text>Post excerpt 1...</Card.Text>
                  <Button variant="link">Read more</Button>
                </Card.Body>
              </Card>
            </ListGroup.Item>
            <ListGroup.Item>
              <Card>
                <Card.Img variant="top" src={tech2} />
                <Card.Body>
                  <Card.Title>Post Title 2</Card.Title>
                  <Card.Text>Post excerpt 2...</Card.Text>
                  <Button variant="link">Read more</Button>
                </Card.Body>
              </Card>
            </ListGroup.Item>
            <ListGroup.Item>
              <Card>
                <Card.Img variant="top" src={tech3} />
                <Card.Body>
                  <Card.Title>Post Title 3</Card.Title>
                  <Card.Text>Post excerpt 3...</Card.Text>
                  <Button variant="link">Read more</Button>
                </Card.Body>
              </Card>
            </ListGroup.Item>
          </ListGroup>
        </div>
        <div className="sidebar">
          <Card>
            <Card.Body>
              <Card.Title>Sidebar</Card.Title>
              <Card.Text>Sidebar content...</Card.Text>
            </Card.Body>
          </Card>
        </div>
      </div>
    </Container>
  );
};

export default Homepage;