import React, { useState } from 'react';
import { Container, Row, Col, Card, Button } from 'react-bootstrap';
import InfiniteScroll from 'react-infinite-scroll-component';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useNavigate } from 'react-router-dom';
import '../../assets/styles/TechPage.scss';



const TechPage = () => {
  const [items, setItems] = useState(Array.from({ length: 12 }));

  const navigate = useNavigate();
  const fetchMoreData = () => {
    setTimeout(() => {
      setItems(items.concat(Array.from({ length: 12 })));
    }, 1500);
  };

  return (
    <Container className="techpage mt-4">
      <h1 className="tech-title">Tech Blog</h1>
      <Button variant="primary" onClick={() => navigate('/tech-blog/post')} className="write-btn">
        글쓰기
      </Button>
      <InfiniteScroll
        dataLength={items.length}
        next={fetchMoreData}
        hasMore={true}
        loader={<h4>Loading...</h4>}
      >
        <Row>
          {items.map((_, index) => (
            <Col key={index} md={4} className="mb-4">
              <Card>
                <Card.Img variant="top" src={`path_to_image${index}`} />
                <Card.Body>
                  <Card.Title>Post Title {index + 1}</Card.Title>
                  <Card.Text>Post excerpt {index + 1}...</Card.Text>
                </Card.Body>
              </Card>
            </Col>
          ))}
        </Row>
      </InfiniteScroll>
    </Container>
  );
};

export default TechPage;
