import React, { useState, useEffect } from 'react';
import './App.css';
import Header from './components/Header';
import SearchBar from './components/SearchBar';
import NewsList from './components/NewsList';

function App() {

  const [ newsItems, setNewsItems ] = useState(null);
  const [ newsItemsDetail, setNewsItemsDetail ] = useState([]);
  const [ searchTerm, setSearchTerm ] = useState('');
  const [ newsToRender, setNewsToRender ] = useState([]);

  useEffect(() => {
    fetch( 'https://hacker-news.firebaseio.com/v0/topstories.json' )
      .then(res => res.json())
      .then(data => setNewsItems(data))
  },[]);

  useEffect(() => {
    if (newsItems != null) {
      const newsItemPromises = newsItems.slice(0,50)
        .map(newsItem => {
         return `https://hacker-news.firebaseio.com/v0/item/${newsItem}.json`
        })
        .map(url => fetch(url).then(res => res.json()))

      Promise.all(newsItemPromises)
        .then(data => {
          setNewsItemsDetail(data);
          setNewsToRender(data);
      });
    }
  },[newsItems]);

  const handleSearchTermUpdate = (event) => {
    setSearchTerm(event.target.value);
  }

  useEffect(() => {
    const updatedNewsToRender = newsItemsDetail.filter(newsItem => {
      return newsItem.title.toLowerCase().includes(searchTerm.toLowerCase())
    });
    setNewsToRender(updatedNewsToRender);
  },[searchTerm, newsItemsDetail])
   
  return (
    <div className="App">
      <Header />
      <SearchBar searchTerm={searchTerm} handleSearchTermUpdate={handleSearchTermUpdate}/>
      <NewsList newsToRender={ newsToRender }/>
    </div>
  ); 
}

export default App;
