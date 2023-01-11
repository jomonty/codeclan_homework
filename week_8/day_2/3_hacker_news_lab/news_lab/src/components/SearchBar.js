import React from 'react';
import styled from 'styled-components';

const SearchDiv = styled.div`
    background-color: white;
    min-height: 8vh;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    font-size: calc(10px + 2vmin);
    color: white;
`

const SearchBox = styled.input`
    width: 80%;
    height: 2rem;
    font-size: 1.25rem;
`

const SearchBar = ({ searchTerm, handleSearchTermUpdate }) => {

    return (
        <SearchDiv>
            <SearchBox 
                type="text" 
                // id="input-text-filter-box"
                placeholder="Search..."
                value={searchTerm} 
                onChange={handleSearchTermUpdate}
            />
        </SearchDiv>
    )
};

export default SearchBar;