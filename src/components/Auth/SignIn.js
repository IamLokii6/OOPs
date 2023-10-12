import React, { Component } from 'react';

class SignIn extends Component {
  constructor() {
    super();
    this.state = {
      email: '',
      password: '',
    };
  }

  handleInputChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  }

  handleSignIn = () => {
    // Implement your sign-in logic here, e.g., making an API call to your backend
    const { email, password } = this.state;

    // Example: Send a POST request to your server
    fetch('/api/users/signin', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ email, password }),
    })
      .then((response) => response.json())
      .then((data) => {
        // Handle the response from the server, e.g., store user token or show an error message
        console.log(data);
      })
      .catch((error) => {
        // Handle any errors that occur during the fetch
        console.error('Error:', error);
      });
  }

  render() {
    const { email, password } = this.state;

    return (
      <div>
        <h1>Sign In</h1>
        <div>
          <label>Email</label>
          <input type="email" name="email" value={email} onChange={this.handleInputChange} />
        </div>
        <div>
          <label>Password</label>
          <input type="password" name="password" value={password} onChange={this.handleInputChange} />
        </div>
        <button onClick={this.handleSignIn}>Sign In</button>
      </div>
    );
  }
}

export default SignIn;
