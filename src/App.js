import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import SignUp from './components/Auth/SignUp';
import SignIn from './components/Auth/SignIn';
import LostItemForm from './components/LostItemForm';
import FoundItemForm from './components/FoundItemForm';
import ItemList from './components/Items/ItemList';
import ItemCard from './components/Items/ItemCard';
import Logout from './components/Auth/Logout';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/signup" element={<SignUp />} />
        <Route path="/signin" element={<SignIn />} />
        <Route path="/lost-item" element={<LostItemForm />} />
        <Route path="/found-item" element={<FoundItemForm />} />
        <Route path="/items" element={<ItemList />} />
        <Route path="/item/:itemId" element={<ItemCard />} />
        <Route path="/logout" element={<Logout />} />
      </Routes>
    </Router>
  );
}

export default App;
