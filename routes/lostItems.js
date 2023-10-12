const express = require('express');
const router = express.Router();
const LostItem = require('../models/LostItem');

// Define controller methods for lost items

// Create a new lost item
router.post('/', (req, res) => {
  const { name, contact, location, description } = req.body;

  // Create a new LostItem document and save it to the database
  const lostItem = new LostItem({
    name,
    contact,
    location,
    description,
  });

  lostItem.save()
    .then((item) => res.json(item))
    .catch((error) => res.status(400).json({ error: error.message }));
});

// Get a list of all lost items
router.get('/', (req, res) => {
  LostItem.find()
    .then((items) => res.json(items))
    .catch((error) => res.status(400).json({ error: error.message }));
});

module.exports = router;
