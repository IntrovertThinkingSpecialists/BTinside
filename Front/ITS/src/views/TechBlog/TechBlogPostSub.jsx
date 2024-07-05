import React, { useState } from 'react';
import { useParams } from 'react-router-dom';
import { Container, Form, Button, Row, Col } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import RichTextEditor from '../../components/common/Tech-Post';
import { generateContent } from '../../api/contentApi';

const TechBlogPost = () => {
  const { id } = useParams();
  const [title, setTitle] = useState('');
  const [tags, setTags] = useState('');
  const [content, setContent] = useState('');
  const [loading, setLoading] = useState(false);

  const handleGenerateContent = async () => {
    setLoading(true);
    try {
      const generatedContent = await generateContent(title); // 주제로 제목을 사용
      setContent(generatedContent);
    } catch (error) {
      alert('글 생성에 실패했습니다. 다시 시도해주세요.');
    }
    setLoading(false);
  };

  return (
    <Container className="mt-4">
      <Form>
        <Form.Group controlId="formPostTitle">
          <Form.Label className="h1">제목을 입력하세요</Form.Label>
          <Form.Control
            type="text"
            placeholder="제목을 입력하세요"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
          />
        </Form.Group>

        <Form.Group controlId="formPostTags" className="mt-3">
          <Form.Label>태그를 입력하세요</Form.Label>
          <Form.Control
            type="text"
            placeholder="태그를 입력하세요"
            value={tags}
            onChange={(e) => setTags(e.target.value)}
          />
          <RichTextEditor />
        </Form.Group>

        <Form.Group controlId="formPostContent" className="mt-3">
          <Form.Label>당신의 이야기를 적어보세요...</Form.Label>
          <Form.Control
            as="textarea"
            rows={10}
            placeholder="당신의 이야기를 적어보세요..."
            value={content}
            onChange={(e) => setContent(e.target.value)}
          />
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
            <Button
              variant="primary"
              onClick={handleGenerateContent}
              disabled={loading}
            >
              {loading ? '생성 중...' : '글 생성'}
            </Button>
          </Col>
        </Row>
      </Form>
    </Container>
  );
};

export default TechBlogPost;
