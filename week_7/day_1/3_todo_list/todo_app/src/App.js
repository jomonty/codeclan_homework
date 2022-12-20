// import logo from './logo.svg';
import './App.css';
import React, { useState } from 'react';

function App() {

  const [toDos, setToDos] = useState([
    {item: "Buy Shopping", isComplete: false, priority: "high"},
    {item: "Clean Bathroom", isComplete: true, priority: "low"},
    {item: "Car's MOT", isComplete: false, priority: "low"}
  ]);

  const [newToDo, setNewToDo] = useState({
    item: "", isComplete: false, priority: ""
  });

  const todoNodes = toDos.map((toDo, index) => {
      return  <li key={index} className={toDo.isComplete ? `complete`:`priority-${toDo.priority}`}>
                <span>
                  {toDo.item}
                </span>
                {toDo.isComplete ? <span>Completed!</span> : <button className="button-done" onClick={() => handleComplete(index)}>Done!</button>}
              </li>
  });

  const handleTextInput = (event) => {
    setNewToDo({
      ...newToDo,
      item: event.target.value
    });
    // const copyNewToDo = {...newToDo};
    // copyNewToDo.item = event.target.value;
    // setNewToDo(copyNewToDo);
  };

  const handleRadioInput = (event) => {
    const copyNewToDo = {...newToDo};
    copyNewToDo.priority = event.target.value;
    setNewToDo(copyNewToDo);
  };

  const handleComplete = (indexToComplete) => {
    const toDosUpdate = toDos.map((toDo, index) => {
      if (index === indexToComplete) {
        const updatedToDo = {...toDo};
        updatedToDo.isComplete = true;
        return updatedToDo;
      };
      return toDo;
    })
    setToDos(toDosUpdate);
  }

  const saveNewItem = (event) => {
    event.preventDefault();
    setToDos([...toDos, newToDo]);
    // const toDosUpdate = [...toDos];
    // toDosUpdate.push(newToDo);
    // setToDos(toDosUpdate);
    setNewToDo({
      item: "", isComplete: false, priority: ""
    });
  }


  return (
    <div className="App">
      <h1>ToDo's</h1>
      <form onSubmit={saveNewItem} className="new-todo-form">
        <input type="text" value={newToDo.item} onChange={handleTextInput}/>
        <label htmlFor="high">High</label>
        <input type="radio" 
                id="high" 
                name="priority" 
                value="high"
                checked={(newToDo.priority === "high")}
                onChange={handleRadioInput}
                />
        <label htmlFor="low">Low</label>
        <input type="radio" 
                id="low" 
                name="priority" 
                value="low" 
                checked={(newToDo.priority === "low")}
                onChange={handleRadioInput}
                required
                />
        <input type="submit" value="Save Item"/>
      </form>
      <ul className="todo-list">
        {todoNodes}
      </ul>
    </div>
  );
}

export default App;
