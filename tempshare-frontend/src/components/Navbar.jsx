import React, { useState } from "react";
import { Link, useLocation } from "react-router-dom";
//useLocation - This hook returns the current location object.
// This can be useful if you'd like to perform some side effect whenever the
// current location changes.
//Link - A <Link> is an element that lets the user navigate to another page by clicking or tapping on it.
// In react-router-dom, a <Link> renders an accessible <a> element with a real href that points to the resource it's linking to.
// This means that things like right-clicking a <Link> work as you'd expect.

const Navbar = () => {
  const [menuOpen, setMenuOpen] = useState(false);
  const locationHook = useLocation();

  const isActive = (path) =>
    locationHook.pathname === path
      ? "text-blue-600 font-semibold underline" //This highlights the current page in nav bar
      : "text-gray-700";

  return (
    <nav className="w-full bg-white shadow-mg fixed top-0 left-0 z-50 rounded ">
      <div className="max-w-5xl mx-auto flex justify-between items-center py-3 px-6">
        <Link to="/" className="text-2xl font-bold text-blue-600">
          TempShare
        </Link>

        <Link className={isActive("/all-users")} to="/all-users">
          (Admin Only) All Users
        </Link>

        <div className="hidden md:flex space-x-8 text-sm items-center">
          <Link className={isActive("/dashboard")} to="/dashboard">
            Dashboard
          </Link>

          <Link className={isActive("/contact")} to="/contact">
            Contact Me
          </Link>

          <Link className={isActive("/signup")} to="/signup">
            Sign Up
          </Link>

          <Link
            className="bg-blue-600 text-white px-4 py-2 rounded hover:bg-bllue-700 transition"
            to="/login"
          >
            Login
          </Link>
        </div>
        <button
          className="md:hidden text-2xl"
          onClick={() => setMenuOpen(!menuOpen)}
        >
          ☰
        </button>
      </div>
      {/* Mobile menu for mobile */}
      {menuOpen && (
        <div className="md:hidden bg-white shadow-md px-6 py-3 space-y-4">
          <Link
            className={isActive("/dashboard")}
            to="/dashboard"
            onClick={() => setMenuOpen(false)}
          >
            Dashboard
          </Link>
          <Link
            className={isActive("/signup")}
            to="/signup"
            onClick={() => setMenuOpen(false)}
          >
            Sign Up
          </Link>
          <Link
            className="bg-blue-600 text-white px-4 py-2 block w-fit rounded hover:bg-blue-700 transition"
            to="/login"
            onClick={() => setMenuOpen(false)}
          >
            Login
          </Link>
        </div>
      )}
    </nav>
  );
};

export default Navbar;

/* 

Previous Code Just in Case
<nav className="w-full bg-white shadow-md fixed top-0 left-0 z-50">
      <div className="max-w-5xl mx-auto flex justify-between items-center py-3 px-6">
        
      </div>
      <Link to="/" className="text-xl font-semibold text-blue-600">
        PaiShare
      </Link>
      <div className="space-x-6 text-sm font-medium">
        <Link to="/dashboard" className="hover:text-blue-600">
          Dashboard
        </Link>

        <Link to="/signup" className="hover:text-blue-600">
          Sign Up
        </Link>

        <Link
          to="/login"
          className="bg-blue-600 text-white px-4 py-1.5 rounded hover:bg-blue-700 transition"
        >
          Login
        </Link>
      </div>
    </nav>
*/
