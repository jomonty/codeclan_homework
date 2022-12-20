import React, { useState } from 'react';
import FilmReleasesHeader from '../components/FilmReleasesHeader';
import FilmReleasesList from '../components/FilmReleasesList';
import FilmReleasesFooter from '../components/FilmReleasesFooter';

const FilmReleasesBox = () => {

    const [releaseList, setReleaseList] = useState(
        [
            {
              id: 1,
              name: "Spider-Man: Into the Spider-Verse",
              url: "https://www.imdb.com/title/tt4633694/?ref_=rlm"
            },
            {
              id: 2,
              name: "Life Itself",
              url: "https://www.imdb.com/title/tt5989218/?ref_=rlm"
            },
            {
              id: 3,
              name: "Mary Queen of Scots",
              url: "https://www.imdb.com/title/tt2328900/?ref_=rlm"
            },
            {
              id: 4,
              name: "The Lego Movie 2: The Second Part", url: "https://www.imdb.com/title/tt3513498/?ref_=rlm"
            },
            {
              id: 5,
              name: "Captain Marvel",
              url: "https://www.imdb.com/title/tt4154664/?ref_=rlm"
            }
          ]
    );



    return (
        <div id="film-release-box">
            <FilmReleasesHeader />
            <FilmReleasesList releaseList={releaseList}/>
            <FilmReleasesFooter />
        </div>
    )
}

export default FilmReleasesBox;