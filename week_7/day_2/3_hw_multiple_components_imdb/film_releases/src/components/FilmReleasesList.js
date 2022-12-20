import React from 'react';
import FilmReleasesSingle from './FilmReleaseSingle';

const FilmReleasesList = ({ releaseList }) => {

    const filmNodes = releaseList.map((film) => {
        return (
            <li class="film-release-box-single-film">
                <FilmReleasesSingle 
                    key={film.id} 
                    url={film.url} 
                    name={film.name} />
            </li>
        );
    });

    return (
        <div id="film-release-box-list">
            <ul>
                {filmNodes}
            </ul>
        </div>
    )
}

export default FilmReleasesList;