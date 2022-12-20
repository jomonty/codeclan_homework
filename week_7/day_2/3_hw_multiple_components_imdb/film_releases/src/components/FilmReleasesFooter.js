import React from 'react';

const FilmReleasesFooter = () => {
    return (
        <div id="film-release-box-footer">
        <a 
            href="https://www.imdb.com/calendar/?region=gb" 
            target="_blank"
            rel="noreferrer">
            <span>View more upcoming releases {'>>'}</span>
        </a>
        </div>
    )
}

export default FilmReleasesFooter;