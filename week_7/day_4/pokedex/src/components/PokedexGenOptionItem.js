
const PokedexGenOptionItem = ({ gen, index}) => {


    return (
        <option value={gen.url}>{gen.display_name}</option>
    )
}

export default PokedexGenOptionItem;