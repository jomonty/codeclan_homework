import React from 'react';
import NewsItem from './NewsItem';

const NewsList = ( {newsToRender} ) => {

    const newsItemNodes = newsToRender.map((newsItemDetail, index) => {
        return (
            <li key={index} className="news-list-item">
                <NewsItem newsItemDetail={ newsItemDetail } />
            </li>
        )
    });

    return (
        <ul id="news-list">
            {newsItemNodes}
        </ul>
    )
};

export default NewsList;