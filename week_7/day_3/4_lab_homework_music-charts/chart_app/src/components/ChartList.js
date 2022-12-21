import ChartListItem from './ChartListItem';

const ChartList = ({ chartData }) => {

    const chartSongs = chartData.map((song, index) => {
         return (
            <ChartListItem key={index} song={song} index={index} />
            // <ChartListItem />
         )
    })

    return (
        <div id="chart-list">
            {/* <p>This is the chart list.</p> */}
            {chartSongs}
            {/* <ChartListItem />
            <ChartListItem />
            <ChartListItem /> */}
        </div>
    )
}

export default ChartList;