import React from 'react';
import styled from 'styled-components';
import NewsItem from './NewsItem';

const NewsListUL = styled.ul`
    display: flex;
    flex-direction: column;
    gap: 16px;
    background-color: antiquewhite;
    list-style-type: none;
    padding-top: 0.5em;
    padding-bottom: 3em;
`
const NewsListItemLI = styled.li`
    padding: 0.5em;
    margin: auto;
    background-color: beige;
    width: 80%;
    text-align: left;
`

const NewsList = ( {newsToRender} ) => {

    const newsItemNodes = newsToRender.map((newsItemDetail, index) => {
        return (
            <NewsListItemLI key={index}>
                <NewsItem newsItemDetail={ newsItemDetail } />
            </NewsListItemLI>
        )
    });

    return (
        <NewsListUL>
            {newsItemNodes}
        </NewsListUL>
    )
};

export default NewsList;