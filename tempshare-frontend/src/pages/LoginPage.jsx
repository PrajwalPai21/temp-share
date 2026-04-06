import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function LoginPage() {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    email: "",
    password: "",
  });

  const [showPassword, setShowPassowrd] = useState(false);
  const [message, setMessage] = useState("");
  const [loading, setLoading] = useState(false);

  const validateFunc = () => {
    if (!formData.email) {
      setMessage("Email is Required");
      return false;
    }
    const emailRegex = /\S+@\S+\.\S+/;
    if (!emailRegex.test(formData.email)) {
      setMessage("Please enter a valid email");
      return false;
    }

    if (!formData.password) {
      setMessage("Password is required");
      return false;
    }
    return true;
  };

  const handleSubmitFunc = async (e) => {
    e.preventDefault();
    if (!validateFunc()) return;
    setLoading(true);

    try {
      const response = await fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          email: formData.email,
          password: formData.password,
        }),
      });
      const resultText = await response.text(); //backend response
      // backend currently returns strings like "You have Logged in" or "Wrong password"
      if (response.ok) {
        if (resultText.toLowerCase().includes("logged in")) {
          setMessage("Login Successful - redirecting...");
          // A small DELAYY
          setTimeout(() => {
            navigate("/dashboard");
          }, 600);
        } else {
          setMessage(resultText);
        }
      } else {
        setMessage(resultText || "Login Failed");
      }
    } catch (err) {
      setMessage("Network error - please try again");
    } finally {
      setLoading(false);
    }
  };
  return (
    <div className="min-h-screen bg-gray-100 flex items-center justify-center">
      <div className="bg-white p-8 rounded-2xl shadow-xl w-full max-w-md">
        <h1 className="text-3xl font-bold text-center mb-6">Login</h1>

        {message && (
          <div
            className={`mb-4 text-center font-medium ${
              message.toLowerCase().includes("success") ||
              message.toLowerCase().includes("logged")
                ? "text-green-600"
                : "text-red-600"
            }`}
          >
            {message}
          </div>
        )}

        <form onSubmit={handleSubmitFunc} className="space-y-4">
          <div>
            <label className="block mb-1 font-medium">Email</label>
            <input
              type="email"
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
            <div className="relative">
              <input
                type={showPassword ? "text" : "password"}
                className="w-full p-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 pr-10"
                placeholder="Enter your password"
                value={formData.password}
                onChange={(e) =>
                  setFormData({ ...formData, password: e.target.value })
                }
                required
              />
              <button
                type="button"
                onClick={() => setShowPassword((s) => !s)}
                className="absolute right-2 top-1/2 -translate-y-1/2 text-sm text-gray-600"
                aria-label={showPassword ? "Hide password" : "Show password"}
              >
                {showPassword ? "Hide" : "Show"}
              </button>
            </div>
          </div>

          <button
            type="submit"
            disabled={loading}
            className={`w-full ${
              loading
                ? "bg-gray-400 cursor-not-allowed"
                : "bg-blue-600 hover:bg-blue-700"
            } text-white p-2 rounded-lg transition`}
          >
            {loading ? "Signing in..." : "Login"}
          </button>
        </form>

        <p className="text-center text-sm mt-4">
          Don't have an account?{" "}
          <Link to="/signup" className="text-blue-600 underline">
            Sign Up
          </Link>
        </p>
      </div>
    </div>
  );
}
