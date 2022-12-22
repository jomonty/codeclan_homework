import PokedexGenOptionItem from './PokedexGenOptionItem';

const PokedexGenSelector = ({ allGenNames, genSelected, handleGenInput }) => {

    const optionNodes = allGenNames.map((gen, index ) => {
        return (
            <PokedexGenOptionItem key={index} index={index} gen={gen} />
        )
    })

    const handleChange = (event) => {
        event.preventDefault();
        handleGenInput(event.target.value)
    }

    return (
        <div id="pokedex-gen-selector">
            <select defaultValue={genSelected} onChange={handleChange}>
                <option value="-1">Pick a Generation</option>
                {optionNodes}
            </select>
        </div>
    )
}

export default PokedexGenSelector;