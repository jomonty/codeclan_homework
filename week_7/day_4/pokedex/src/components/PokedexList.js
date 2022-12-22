import PokedexListItem from './PokedexListItem';

const PokedexList = ({ genPokemon, handlePokemonSelect }) => {

    const pokeNodes = genPokemon.map((pokemon, index) => {
        return (
            <PokedexListItem 
                key={pokemon.id} 
                index={index} 
                pokemon={pokemon} 
                handlePokemonSelect={handlePokemonSelect}
            />
        )
    })

    return (
        <div id="pokedex-list">
            {pokeNodes}
        </div>
    )
}

export default PokedexList;