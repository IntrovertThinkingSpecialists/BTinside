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
