import React from "react";
import { useState } from "react";
const Contact = () => {
  const [formData, setFormData] = useState({
    nameSub: "",
    emailSub: "",
    messageSub: "",
  });

  // const [submitted, setSubmitted] = useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();

    // Fonrt end validation
    if (!formData.nameSub || !formData.emailSub || !formData.messageSub) {
      alert("Please fill in all fields");
      return;
    }

    alert("Message Submitted Front End for now");

    setFormData({
      nameSub: "",
      emailSub: "",
      messageSub: "",
    });
  };

  return (
    <div className="min-h-screen bg-gray-100 flex justify-center px-4">
      <div className="bg-white p-8 rounded-xl shadow-md w-full max-w-xl mt-20">
        <h1 className="text-3xl font-bold text-center text-blue-600 mb-6">
          Contact Me
        </h1>
        <form onSubmit={handleSubmit} className="space-y-4">
          <div>
            <label className="block mb-1 font-medium">Your Name</label>
            <input
              type="text"
              className="w-full p-2 border rounded"
              value={formData.nameSub}
              onChange={(e) =>
                setFormData({ ...formData, nameSub: e.target.value })
              }
              placeholder="Enter your name"
            />
          </div>
          {/* Email */}
          <div>
            <label className="block mb-1 font-medium">Email Id</label>
            <input
              type="email"
              className="w-full p-2 border rounded"
              value={formData.emailSub}
              onChange={(e) =>
                setFormData({ ...formData, emailSub: e.target.value })
              }
              placeholder="Enter your Email ID"
            />
          </div>
          {/* make the text area a bit bigger */}
          <div>
            <label className="block mb-1 font-medium">Your Thoughts</label>
            <textarea
              // type="text" OPTIONAL
              className="w-full p-2 border rounded h-32"
              value={formData.messageSub}
              onChange={(e) =>
                setFormData({ ...formData, messageSub: e.target.value })
              }
              placeholder="What do you have in mind?"
            ></textarea>
          </div>

          <button
            type="submit"
            className="w-full bg-blue-600 text-white p-2 rounded hover:bg-blue-700"
          >
            Send Message
          </button>
        </form>
      </div>
    </div>
  );
};

export default Contact;
