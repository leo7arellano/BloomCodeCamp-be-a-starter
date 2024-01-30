import { useState } from 'react'
import './App.css'
import axios from 'axios'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'

function App() {
  const [username, setUsername] = useState("")
  
  async function clickHandler() {
    const usernameText = document.getElementById("username");
    console.log(username);
  }

  return (
    <Router>
      <div className="container">
        <h1>Labs LMS</h1>
      <Routes>
        <Route 
          path="/login"
          element={
            <div>
              <h2>Login</h2>
              <h4>Username</h4>
              <input id="username" type="text"value={username} onChange={(e) => {setUsername(e.target.value)}}/>
              <br />
              <h4>Password</h4>
              <input id="psw" type="password" />
              <br />
              <button onClick={clickHandler}>Log in</button>
            </div>
          }
        />
        <Route
          path="/"
          element={
            <div>
              <p>Welcome to the assignment review app.</p>

            </div>
          }
        />
        <Route
          path="/submit-assignment"
          element={
            <div>
              <h3>Assignment #</h3>
              <select name="assignment-number" id="assignment-number">
                <option value="Assignment-1">Assignment 1</option>
                <option value="Assignment-2">Assignment 2</option>
                <option value="Assignment-3">Assignment 3</option>
              </select>
              <label htmlFor=""><h4>GitHub URL</h4></label>
              <input type="url" id="url" name="url"></input>
              <label htmlFor=""><h4>Branch</h4></label>
              <input type="text" id="branch" name="branch"></input>
              <br />
              <br />
              <button>Submit</button>
              <button><a href="/dashboard">Back to Dashboard</a></button>
            </div>
          }
        />
        <Route 
          path="/dashboard"
          element={
            <div>
              <h2>Learner Dashboard</h2>
              <button><a href="/submit-assignment">Submit New Assignment</a></button>
              <button><a href="/login">Log Out</a></button>
              <p>Welcome Learner</p>
            </div>
          }
        />

      </Routes>
      </div>
    </Router>
    
  )
}

export default App
