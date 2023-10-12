const express = require('express');
const router = express.Router();
const FoundItem = require('../models/FoundItem');

// Define controller methods for found items

// Create a new found item
router.post('/', (req, res) => {
  const { name, contact, location, description } = req.body;

  // Create a new FoundItem document and save it to the database
  const foundItem = new FoundItem({
    name,
    contact,
    location,
    description,
  });

  foundItem.save()
    .then((item) => res.json(item))
    .catch((error) => res.status(400).json({ error: error.message }));
});

// Get a list of all found items
router.get('/', (req, res) => {
  FoundItem.find()
    .then((items) => res.json(items))
    .catch((error) => res.status(400).json({ error: error.message }));
});

module.exports = router;
