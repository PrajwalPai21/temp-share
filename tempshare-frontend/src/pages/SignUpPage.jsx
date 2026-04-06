import React, { useState } from "react";

const SignUpPage = () => {
  const [formData, setFormData] = useState({
    fullName: "",
    email: "",
    password: "",
    confirmPassword: "",
  });

  const [message, setMessage] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    //validatoin part
    if (!formData.fullName || !formData.email || !formData.password) {
      setMessage("All fields are necessary.");
      return;
    }

    if (formData.password.length < 6) {
      setMessage("Password must be atleast 6 characters.");
      return;
    }

    if (formData.password !== formData.confirmPassword) {
      setMessage("Passwords do not match.");
      return;
    }

    const emailRegex = /\S+@\S+\.\S/;
    if (!emailRegex.test(formData.email)) {
      setMessage("Invalid Email Format");
      return;
    }

    // data to send to the backend
    const dataToSend = {
      fullName: formData.fullName,
      email: formData.email,
      password: formData.password,
    };
    try {
      const response = await fetch("http://localhost:8080/auth/signup", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(dataToSend),
      });

      const result = await response.text(); //backend returns plain text
      setMessage(result);
      //Make this green
      if (result === "You have successfully sign up!") {
        setFormData({
          fullName: "",
          email: "",
          password: "",
          confirmPassword: "",
        });
      }
    } catch (error) {
      setMessage("Something went wrong. Try again ");
    }
  };
  return (
    <div className="min-h-screen bg-gray-100 flex items-center justify-center">
      <div className="bg-white p-8 rounded-2xl shadow-xl w-full max-w-md">
        <h1 className="text-3xl fond-bold text-center mb-6">Create Account</h1>

        {/* a backend messgae */}
        {message && (
          <p className="text-center text-red-600 font-semibold mb-3">
            {message}
          </p>
        )}

        <form className="space-y-4" onSubmit={handleSubmit}>
          <div>
            <label className="block mb-1 font-medium">Full Name</label>
            <input
              type="text"
              className="w-full p-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
              placeholder="Enter your name"
              value={formData.fullName}
              onChange={(e) =>
                setFormData({ ...formData, fullName: e.target.value })
              }
              required
            />
          </div>

          <div>
            <label className="block mb-1 font-medium">Email</label>
            <input
              type="text"
              className="w-full p-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
              placeholder="Enter your email"
              value={formData.email}
              onChange={(e) =>
                setFormData({ ...formData, email: e.target.value })
              }
              required
            />
          </div>

          <div>
            <label className="block mb-1 font-medium">Password</label>
            <input
              type="password"
              className="w-full p-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
              placeholder="Create a password"
              value={formData.password}
              onChange={(e) =>
                setFormData({ ...formData, password: e.target.value })
              }
              required
            />
          </div>
          <div>
            <label className="block mb-1 font-medium">Confirm Password</label>
            <input
              type="password"
              className="w-full p-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
              placeholder="Re-Enter  your password"
              value={formData.confirmPassword}
              onChange={(e) =>
                setFormData({ ...formData, confirmPassword: e.target.value })
              }
              required
            ></input>
          </div>
          <button
            type="submit"
            className="w-full bg-blue-600 text-white p-2 rounded-lg hover:bg-blue-700 transition"
          >
            Sign Up
          </button>
        </form>

        <p className="text-center text-sm mt-4">
          Already have an account?{" "}
          <a href="/" className="text-blue-600 underline">
            Login
          </a>
        </p>
      </div>
    </div>
  );
};

export default SignUpPage;
