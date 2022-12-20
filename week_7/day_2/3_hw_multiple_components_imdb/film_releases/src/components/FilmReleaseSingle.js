import React from 'react';

const FilmReleasesSingle = ({ name, url }) => {
    return (
        <a href={url} target="_blank" rel="noreferrer">
            {name}
        </a>
    )
}

export default FilmReleasesSingle;