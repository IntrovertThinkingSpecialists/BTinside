import React, { useState } from 'react';
import axios from 'axios';

const SubscriptionForm = () => {
  const [email, setEmail] = useState('');
  const [token, setToken] = useState('');
  const [userId, setUserId] = useState('');
  const [subscriptionType, setSubscriptionType] = useState('');

  const handleSubmit = async (event) => {
    event.preventDefault();

    const payload = {
      email,
      token,
      userId,
      subscriptionType
    };

    try {
      const response = await axios.post('/api/subscription/subscribe', payload);
      console.log('Subscription successful:', response.data);
    } catch (error) {
      console.error('Error subscribing:', error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Email:</label>
        <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
      </div>
      <div>
        <label>Token:</label>
        <input type="text" value={token} onChange={(e) => setToken(e.target.value)} required />
      </div>
      <div>
        <label>User ID:</label>
        <input type="text" value={userId} onChange={(e) => setUserId(e.target.value)} required />
      </div>
      <div>
        <label>Subscription Type:</label>
        <select value={subscriptionType} onChange={(e) => setSubscriptionType(e.target.value)} required>
          <option value="basic">Basic</option>
          <option value="platinum">Platinum</option>
          <option value="vip">VIP</option>
        </select>
      </div>
      <button type="submit">Subscribe</button>
    </form>
  );
};

export default SubscriptionForm;
