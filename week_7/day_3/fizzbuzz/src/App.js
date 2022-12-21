import { useState, useEffect } from 'react';
import './App.css';

function App() {

  const [number, setNumber] = useState(0);
  const [fizzBuzz, setFizzBuzz] = useState('');
  const [somethingElse, setSomethingElse] = useState('');
  const [usrInput, setUsrInput] = useState('');

  useEffect(() => {
    setFizzBuzz(fizz(number));
    console.log('useEffect called');
  }, [number])

  const handleInc = () => {
    setNumber(number + 1);
  }

  const handleSomethingElse = (input) => {
    setSomethingElse(somethingElse.concat('a'));
  }

  const handleUsrInput = (event) => {
    setUsrInput(event.target.value);
  }

  const handleSubmit = () => {

  }

  const fizz = (num)  => {
    let str = '';
    if (num != 0 && num % 3 === 0) {
      str = str.concat('fizz')
    }
    if (num != 0 && num % 5 === 0) {
      str = str.concat('buzz')
    }
    if (str === '') {
      str = str.concat(num);
    }
    return str;
  }

  return (
    <div className="App">
      <button onClick={handleInc}>+</button>
      <br/>
      <p>Current number is {number}.</p>
      <p>{fizzBuzz}</p>
      <p>Something Else: {somethingElse}</p>
      <br/>
      <button onClick={handleSomethingElse}>SomethingElse</button>
      <br/>
      <form onSubmit={handleSubmit}>
        <label htmlFor='usrinput'>Guess next output: </label>
        <input
          type="text"
          id="usrinput"
          value={usrInput}
          onChange={handleUsrInput}
        />
        <input type="submit" value="Submit"/>
      </form>
    </div>
  );
}

export default App;
