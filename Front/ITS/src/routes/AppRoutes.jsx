import React from "react";
import {Routes, Route} from 'react-router-dom';
import Home from '../views/home/Homepage'
import DailyBlogPost from "../views/DailyBlog/DailyBlogPost";
import DailyBlogList from "../views/DailyBlog/DailyBlogList";
import TechBlogPost from "../views/TechBlog/TechBlogPost";
import TechBlogList from "../views/TechBlog/TechBlogList";
import TechPage from "../views/home/TechPage";


const AppRoutes = () =>{
    return(
        <Routes>
         <Route path="/" element={<Home />} />
         <Route path="/tech" element={<TechPage />} />
         <Route path="/daily-blog/post" element={<DailyBlogPost />} />
            <Route path="/daily-blog/list" element={<DailyBlogList />} />
            <Route path="/tech-blog/post" element={<TechBlogPost />} />
            <Route path="/tech-blog/list" element={<TechBlogList />} />
        </Routes>
    );
};
export default AppRoutes;