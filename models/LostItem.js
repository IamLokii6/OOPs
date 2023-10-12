const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const lostItemSchema = new Schema({
  name: String,
  contact: String,
  location: String,
  description: String,
  // Add any other fields as needed
});

module.exports = mongoose.model('LostItem', lostItemSchema);
