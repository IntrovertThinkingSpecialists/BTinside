import axios from 'axios';

const OPENAI_API_KEY = process.env.REACT_APP_OPENAI_API_KEY;

export const generateContentFromOpenAI = async (topic) => {
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
