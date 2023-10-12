import React, { Component } from 'react';

class SignUp extends Component {
  constructor() {
    super();
    this.state = {
      username: '',
      email: '',
      password: '',
    };
  }

  handleInputChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  }

  handleSignUp = () => {
    // Implement your sign-up logic here, e.g., making an API call to your backend
    const { username, email, password } = this.state;

    // Example: Send a POST request to your server
    fetch('/api/users/signup', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ username, email, password }),
    })
      .then((response) => response.json())
      .then((data) => {
        // Handle the response from the server, e.g., show a success message or handle errors
        console.log(data);
      })
      .catch((error) => {
        // Handle any errors that occur during the fetch
        console.error('Error:', error);
      });
  }

  render() {
    const { username, email, password } = this.state;

    return (
      <div>
        <h1>Sign Up</h1>
        <div>
          <label>Username</label>
          <input type="text" name="username" value={username} onChange={this.handleInputChange} />
        </div>
        <div>
          <label>Email</label>
          <input type="email" name="email" value={email} onChange={this.handleInputChange} />
        </div>
        <div>
          <label>Password</label>
          <input type="password" name="password" value={password} onChange={this.handleInputChange} />
        </div>
        <button onClick={this.handleSignUp}>Sign Up</button>
      </div>
    );
  }
}

export default SignUp;
