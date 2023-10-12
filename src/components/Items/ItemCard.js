import React from 'react';

const ItemCard = ({ item }) => {
  return (
    <div className="item-card">
      <h3>{item.name}</h3>
      <p>Contact: {item.contact}</p>
      <p>Location: {item.location}</p>
      <p>Description: {item.description}</p>
    </div>
  );
};

export default ItemCard;
