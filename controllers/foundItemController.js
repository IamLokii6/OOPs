const FoundItem = require('../models/FoundItem');

// Create a new found item
exports.createFoundItem = async (req, res) => {
  try {
    const { name, contact, location, description } = req.body;

    // Create a new found item instance based on the Mongoose model
    const newFoundItem = new FoundItem({
      name,
      contact,
      location,
      description,
      // Add any other fields as needed
    });

    // Save the new found item to the database
    const savedFoundItem = await newFoundItem.save();

    res.status(201).json(savedFoundItem);
  } catch (error) {
    res.status(400).json({ error: error.message });
  }
};

// Get a list of all found items
exports.getFoundItems = async (req, res) => {
  try {
    // Retrieve all found items from the database
    const foundItems = await FoundItem.find();

    res.status(200).json(foundItems);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
};
