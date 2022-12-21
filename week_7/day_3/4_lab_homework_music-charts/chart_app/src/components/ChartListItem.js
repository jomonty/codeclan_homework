
const ChartListItem = ({ song, index }) => {

    // const songNode = () => {
    //     console.log(song);
    //     console.log(song["im:name"].label)
    // }

    return (
        <div className="chart-list-item">
            {/* <p>This is a chart list item.</p> */}

            <img src={song["im:image"][2].label} alt=""/>
            
            <p>Chart position: {index + 1}</p>
            <p>Name: {song["im:name"].label}</p>
            <p>Artist: {song["im:artist"].label}</p>
            <p><a href={song.link[1].attributes.href}>Preview</a></p>
            <div>
                <audio controlsList="nodownload" controls>
                <source src={song.link[1].attributes.href} type="audio/mpeg" />
                </audio>
            </div>
            
        </div>
    )
}

export default ChartListItem;