import Dashboard from "./pages/Dashboard";
import SignUpPage from "./pages/SignUpPage";
import LoginPage from "./pages/LoginPage.jsx";
import Contact from "./pages/Contact.jsx";
import { UsersPage } from "./pages/UsersPage.jsx";
import { Home } from "./pages/Home.jsx";
import { Routes, Route, BrowserRouter } from "react-router-dom";
import Navbar from "./components/Navbar.jsx";
function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <div className="">
        <Routes>
          <Route path="/login" element={<LoginPage />} />
          <Route path="/signup" element={<SignUpPage />} />
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/all-users" element={<UsersPage />} />
          <Route path="/" element={<Home />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}
export default App;
