
const PokedexListItem = ({ pokemon, handlePokemonSelect }) => {

    const handleClick = () => {
        handlePokemonSelect(pokemon)
    }

    return (
        <div className="pokedex-list-item" onClick={handleClick}>
            <img src={pokemon.img_url} alt={pokemon.name} className="pokedex-list-item-img"/>
            <p className="pokedex-list-item-txt">{pokemon.str_id} - {pokemon.name}</p>
        </div>
    )
}

export default PokedexListItem;