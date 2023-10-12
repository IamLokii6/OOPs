import React, { Component } from 'react';

class FoundItemForm extends Component {
  constructor() {
    super();
    this.state = {
      name: '',
      contact: '',
      location: '',
      description: '',
    };
  }

  handleInputChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  }

  handleFoundItemSubmit = () => {
    const { name, contact, location, description } = this.state;

    // Simulate found item submission by sending a POST request to the server
    fetch('/api/found-items', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ name, contact, location, description }),
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
    const { name, contact, location, description } = this.state;

    return (
      <div>
        <h1>Report Found Item</h1>
        <div>
          <label>Name</label>
          <input type="text" name="name" value={name} onChange={this.handleInputChange} />
        </div>
        <div>
          <label>Contact</label>
          <input type="text" name="contact" value={contact} onChange={this.handleInputChange} />
        </div>
        <div>
          <label>Location</label>
          <input type="text" name="location" value={location} onChange={this.handleInputChange} />
        </div>
        <div>
          <label>Description</label>
          <textarea name="description" value={description} onChange={this.handleInputChange} />
        </div>
        <button onClick={this.handleFoundItemSubmit}>Submit</button>
      </div>
    );
  }
}

export default FoundItemForm;
