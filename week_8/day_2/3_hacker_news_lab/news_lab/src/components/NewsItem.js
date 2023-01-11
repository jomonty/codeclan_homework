import React from 'react';
import styled from 'styled-components';

const NewsLink = styled.a`
    text-decoration: none;
    color: black;

    &:hover {
        text-decoration: underline;
    }
`



const NewsItem = ({ newsItemDetail }) => {
    return (
        <>
            <h4>
                <NewsLink 
                    href={newsItemDetail.url} 
                    target="_blank" 
                    className="news-link"
                    rel="noreferrer">
                    { newsItemDetail.title }
                </NewsLink>
            </h4>
            <p>Posted by { newsItemDetail.by }</p>
        </>
    )
};

export default NewsItem;