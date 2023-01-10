import React from 'react';

const NewsItem = ({ newsItemDetail }) => {
    return (
        <>
            <h4>
                <a 
                    href={newsItemDetail.url} 
                    target="_blank" 
                    className="news-link"
                    rel="noreferrer">
                    { newsItemDetail.title }
                </a>
            </h4>
            <p>Posted by { newsItemDetail.by }</p>
        </>
    )
};

export default NewsItem;