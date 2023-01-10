import React from 'react';

const SearchBar = ({ searchTerm, handleSearchTermUpdate }) => {

    return (
        <div id="search-box">
            <input 
                type="text" 
                id="input-text-filter-box"
                placeholder="Search..."
                value={searchTerm} 
                onChange={handleSearchTermUpdate}
            />
        </div>
    )
};

export default SearchBar;