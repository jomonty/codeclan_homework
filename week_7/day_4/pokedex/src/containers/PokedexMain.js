import { useState, useEffect } from 'react';
import Header from '../components/Header';
import PokedexGenSelector from '../components/PokedexGenSelector';
import PokedexList from '../components/PokedexList';
import Footer from '../components/Footer';

const PokedexMain = () => {

    const [allGenNames, setAllGenNames] = useState([]);
    const [genSelected, setGenSelected] = useState('-1');
    const [genPokemon, setGenPokemon] = useState([]);
    const [pokemonSelected, setPokemonSelected] = useState([]);

    useEffect(() => {
        getAllGenNames()
    }, [])

    useEffect(() => {
        if (genSelected === '' || genSelected === '-1') {
            setGenPokemon([])
        } else {
            fetch(genSelected)
            .then(res => res.json())
            .then(data => data["pokemon_species"].map(entry => {
                entry["id"] = parseInt(entry.url.split('/').slice(-2,-1));
                entry.name = entry.name[0].toUpperCase() + entry.name.substring(1);
                entry["str_id"] = "#" + ("000" + entry.id).slice(-4);
                entry["img_url"] = `https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${entry.id}.png`
                return entry
            }))
            .then(array => {
                array.sort((a, b) => a.id - b.id);
                setGenPokemon(array);
            });
        }
    }, [genSelected])
    

    const getAllGenNames = () => {
        
        fetch("https://pokeapi.co/api/v2/generation/")
        .then(res => res.json())
        .then(data => {
            let results = data.results
            results = results.map(entry => {
                const splitURL= entry.url.split('/').slice(-3,-1);
                const str1 = splitURL[0][0].toUpperCase() + splitURL[0].substring(1);
                const display_name = `${str1} ${splitURL[1]}`
                entry["display_name"] = display_name
                return entry
            })
            setAllGenNames(results)
        })
    }

    const getSelectedPokemon = (pokemon) => {
        fetch(`https://pokeapi.co/api/v2/pokemon/${pokemon.id}/`)
        .then(res => res.json())
        .then(array => setPokemonSelected(array))
    }

    const handleGenInput = (genURL) => {
        setGenSelected(genURL);
    }

    const handlePokemonSelect = (pokemon) => {
        getSelectedPokemon(pokemon)
    }

    const handleReset = () => {
        setPokemonSelected([])
    }

    if (pokemonSelected.length === 0) {
        return (
            <div id="pokedex-main">
                <Header />
                <PokedexGenSelector allGenNames={allGenNames} genSelected={genSelected} handleGenInput={handleGenInput}/>
                <PokedexList genPokemon={genPokemon} handlePokemonSelect={handlePokemonSelect}/>
                <Footer />
            </div>
        )
    } else {
        return (
            <div id="pokedex-main">
                <Header />
                <button onClick={handleReset}>Back</button>
                <p>{pokemonSelected.name}</p>
                <Footer />
            </div>
        )
    }

    
}

export default PokedexMain;