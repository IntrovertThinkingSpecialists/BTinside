import React, { useState } from 'react';
import { subscribeUser, getSubscription, cancelSubscription, updateSubscription } from '../api/subscriptionApi';

const SubscriptionForm = () => {
    const [userId, setUserId] = useState('');
    const [subscriptionType, setSubscriptionType] = useState('Basic');
    const [token, setToken] = useState('');  // 실제로는 결제 서비스에서 받은 토큰 사용
    const [email, setEmail] = useState('');
    const [subscription, setSubscription] = useState(null);
    const [error, setError] = useState('');

    const handleSubscribe = async () => {
        try {
            const result = await subscribeUser(userId, subscriptionType, token, email);
            setSubscription(result);
        } catch (error) {
            setError('Error subscribing user');
        }
    };

    const handleGetSubscription = async () => {
        try {
            const result = await getSubscription(userId);
            setSubscription(result);
        } catch (error) {
            setError('Error fetching subscription');
        }
    };

    const handleCancelSubscription = async () => {
        try {
            await cancelSubscription(userId);
            setSubscription(null);
        } catch (error) {
            setError('Error cancelling subscription');
        }
    };

    const handleUpdateSubscription = async () => {
        try {
            const result = await updateSubscription(userId, subscriptionType);
            setSubscription(result);
        } catch (error) {
            setError('Error updating subscription');
        }
    };

    return (
        <div>
            <h1>Subscription Management</h1>
            <div>
                <label>User ID:</label>
                <input type="text" value={userId} onChange={(e) => setUserId(e.target.value)} />
            </div>
            <div>
                <label>Email:</label>
                <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
            </div>
            <div>
                <label>Subscription Type:</label>
                <select value={subscriptionType} onChange={(e) => setSubscriptionType(e.target.value)}>
                    <option value="Basic">Basic</option>
                    <option value="Platinum">Platinum</option>
                    <option value="VIP">VIP</option>
                </select>
            </div>
            <div>
                <button onClick={handleSubscribe}>Subscribe</button>
                <button onClick={handleGetSubscription}>Get Subscription</button>
                <button onClick={handleCancelSubscription}>Cancel Subscription</button>
                <button onClick={handleUpdateSubscription}>Update Subscription</button>
            </div>
            {subscription && (
                <div>
                    <h2>Subscription Details</h2>
                    <p>Subscription ID: {subscription.subscriptionId}</p>
                    <p>Plan: {subscription.subscriptionPlan.planName}</p>
                    <p>Start Date: {new Date(subscription.startDate).toLocaleDateString()}</p>
                    <p>End Date: {new Date(subscription.endDate).toLocaleDateString()}</p>
                </div>
            )}
            {error && <p style={{ color: 'red' }}>{error}</p>}
        </div>
    );
};

export default SubscriptionForm;
