import axios from 'axios';

const API_URL = 'http://localhost:8082/api/generateContent'; // 백엔드 API URL

export const generateContent = async (topic) => {
    try {
        const response = await axios.post(API_URL, { topic });
        return response.data.content;
    } catch (error) {
        console.error('Error generating content:', error);
        throw error;
    }
};

// OpenAI API 호출 함수
export const generateContentFromOpenAI = async (topic) => {
    const OPENAI_API_KEY = process.env.REACT_APP_OPENAI_API_KEY;
    const response = await axios.post('https://api.openai.com/v1/engines/davinci-codex/completions', {
        prompt: `Generate a blog post outline about ${topic}`,
        max_tokens: 150
    }, {
        headers: {
            'Authorization': `Bearer ${OPENAI_API_KEY}`
        }
    });

    return response.data.choices[0].text;
};
