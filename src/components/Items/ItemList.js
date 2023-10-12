import React, { Component } from 'react';
import ItemCard from './ItemCard';

class ItemList extends Component {
  constructor() {
    super();
    this.state = {
      items: [], // The list of lost or found items fetched from the backend
    };
  }

  componentDidMount() {
    // Fetch the list of lost and found items from your backend
    fetch('/api/items')
      .then((response) => response.json())
      .then((data) => {
        this.setState({ items: data });
      })
      .catch((error) => {
        console.error('Error fetching items:', error);
      });
  }

  render() {
    const { items } = this.state;

    return (
      <div className="item-list">
        <h1>Lost and Found Items</h1>
        <div className="item-cards">
          {items.map((item) => (
            <ItemCard key={item.id} item={item} />
          ))}
        </div>
      </div>
    );
  }
}

export default ItemList;
