import React, { useState } from 'react';
import { generateContentFromOpenAI } from '../../openaiService';

const ContentGenerator = () => {
    const [topic, setTopic] = useState('');
    const [content, setContent] = useState('');

    const handleGenerate = async () => {
        try {
            const generatedContent = await generateContentFromOpenAI(topic);
            setContent(generatedContent);
        } catch (error) {
            console.error('Error generating content:', error);
        }
    };

    return (
        <div>
            <h1>Content Generator</h1>
            <input
                type="text"
                value={topic}
                onChange={(e) => setTopic(e.target.value)}
                placeholder="Enter a topic"
            />
            <button onClick={handleGenerate}>Generate Content</button>
            {content && (
                <div>
                    <h2>Generated Content</h2>
                    <p>{content}</p>
                </div>
            )}
        </div>
    );
};

export default ContentGenerator;
