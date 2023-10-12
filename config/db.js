const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const path = require('path');

const app = express();
const port = process.env.PORT || 5000;

// Connect to MongoDB (configure your connection URL)
mongoose.connect('mongodb://localhost:27017/lost_and_found', { useNewUrlParser: true, useUnifiedTopology: true })
  .then(() => console.log('MongoDB connected'))
  .catch(err => console.error(err));

app.use(bodyParser.json());

// API Routes
const lostItemsRoute = require('./routes/lostItems');
const foundItemsRoute = require('./routes/foundItems');

app.use('/api/lost-items', lostItemsRoute);
app.use('/api/found-items', foundItemsRoute);

// Serve static assets if in production (for deployment)
if (process.env.NODE_ENV === 'production') {
  // Set a static folder
  app.use(express.static('client/build'));

  app.get('*', (req, res) => {
    res.sendFile(path.resolve(__dirname, 'client', 'build', 'index.html'));
  });
}

app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
