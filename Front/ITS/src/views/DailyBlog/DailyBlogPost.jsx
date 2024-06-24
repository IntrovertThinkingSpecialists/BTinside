import React from 'react';
import { useParams } from 'react-router-dom';
import { Container, Form, Button, Row, Col } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import RichTextEditor from '../../components/common/Tech-Post';

const DailyBlogPost = () => {
  let { id } = useParams();

  return (
    <Container className="mt-4">
      <Form>
        <Form.Group controlId="formPostTitle">
          <Form.Label className="h1">제목을 입력하세요</Form.Label>
          <Form.Control type="text" placeholder="제목을 입력하세요" />
        </Form.Group>

        <Form.Group controlId="formPostTags" className="mt-3">
          <Form.Label>태그를 입력하세요</Form.Label>
          <Form.Control type="text" placeholder="태그를 입력하세요" />
          <RichTextEditor />
        </Form.Group>

        <Form.Group controlId="formPostContent" className="mt-3">
          <Form.Label>당신의 이야기를 적어보세요...</Form.Label>
          <Form.Control as="textarea" rows={10} placeholder="당신의 이야기를 적어보세요..." />
        </Form.Group>

        <Row className="mt-4">
          <Col>
            <Button variant="secondary" href="/tech">
              나가기
            </Button>
          </Col>
          <Col className="text-right">
            <Button variant="secondary" className="mr-2">
              임시저장
            </Button>
            <Button variant="success">
              출간하기
            </Button>
          </Col>
        </Row>
      </Form>
    </Container>
  );
};

export default DailyBlogPost;
