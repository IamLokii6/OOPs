import React, { Component } from 'react';

class Logout extends Component {
  handleLogout = () => {
    // Simulate a logout action by removing the JWT token
    localStorage.removeItem('userToken');

    // Redirect to the sign-in page
    window.location.href = '/signin';
  }

  render() {
    return (
      <div>
        <h1>Logged Out</h1>
        <button onClick={this.handleLogout}>Log Out</button>
      </div>
    );
  }
}

export default Logout;
