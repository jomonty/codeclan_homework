import { useState, useEffect } from 'react';

import Header from '../components/Header';
import ChartList from '../components/ChartList';
import Footer from '../components/Footer';

const ChartContainer = () => {

    const [chartData, setChartData] = useState([]);
    

    useEffect(() => {
        getChartData();
    }, [])

    const getChartData = () => {
        fetch("https://itunes.apple.com/gb/rss/topsongs/limit=20/json")
        .then(res => res.json())
        // .then(chartData => console.log(chartData.feed.entry))
        .then(chartData => setChartData(chartData.feed.entry))
        // .then(console.log(chartData))
    }

    return (
        <div id="chart-container">
            <Header />
            <ChartList chartData={chartData}/>
            <Footer />
        </div>
    )
}

export default ChartContainer;