import React from 'react';
import styled from 'styled-components';

const HeaderDiv = styled.div`
    background-color: #282c34;
    min-height: 15vh;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    font-size: calc(10px + 2vmin);
    color: white;
`

const Header = () => {
    return (
        <HeaderDiv>
            <h1>Hacker News</h1>
        </HeaderDiv>
    )
};

export default Header;