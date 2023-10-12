const LostItem = require('../models/LostItem');

// Create a new lost item
exports.createLostItem = async (req, res) => {
  try {
    const { name, contact, location, description } = req.body;

    // Create a new lost item instance based on the Mongoose model
    const newLostItem = new LostItem({
      name,
      contact,
      location,
      description,
      // Add any other fields as needed
    });

    // Save the new lost item to the database
    const savedLostItem = await newLostItem.save();

    res.status(201).json(savedLostItem);
  } catch (error) {
    res.status(400).json({ error: error.message });
  }
};

// Get a list of all lost items
exports.getLostItems = async (req, res) => {
  try {
    // Retrieve all lost items from the database
    const lostItems = await LostItem.find();

    res.status(200).json(lostItems);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
};
