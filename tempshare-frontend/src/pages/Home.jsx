import React from "react";
import { Link } from "react-router-dom";
export const Home = () => {
  return (
    <div className="min-h-screen bg-gray-100">
      <section className="text-center py-20">
        <h1 className="text-4xl md:text-5xl font-bold text-blue-600">
          Welcome to TempShare
        </h1>

        <p className="mt-4 text-lg text-gray-700 max-w-2xl mx-auto">
          Upload and share files instantly using secure temporary links. Fast,
          simple, and perfect for quick sharing.
        </p>

        <div className="mt-6 flex justify-center gap-4">
          <Link
            to="/signup"
            className="bg-blue-600 text-white px-6 py-3 rounded-lg hover:bg-blue-700 transition"
          >
            Get Started
          </Link>

          <Link
            to="/dashboard"
            className="bg-blue-200 text-gray-700 px-6 py-3 rounded-lg hover:bg-gray-300 transition"
          >
            Share Files
          </Link>
        </div>
      </section>

      <section className="py-16 bg-white">
        <h2 className="text-3xl font-bold text-center mb-10">Why TempShare?</h2>

        <div className="max-w-5xl mx-auto grid md:grid-cols-3 gap-8 px-6">
          <div className="p-6 bg-gray-100 rounded-xl shadow">
            <h3 className="text-xl font-semibold mb-2">⚡ Instant Sharing</h3>
            <p>
              No account required — upload and get a sharable link in seconds.
            </p>
          </div>

          <div className="p-6 bg-gray-100 rounded-xl shadow">
            <h3 className="text-xl font-semibold mb-2">🔒 Secure</h3>
            <p>Your files are protected and stored temporarily for safety.</p>
          </div>

          <div className="p-6 bg-gray-100 rounded-xl shadow">
            <h3 className="text-xl font-semibold mb-2">⏳ Temporary Storage</h3>
            <p>Files automatically expire and get deleted after a set time.</p>
          </div>
        </div>
      </section>

      <section className="py-16 bg-gray-100">
        <h2 className="text-3xl font-bold text-center mb-10">How It Works</h2>

        <div className="max-w-4xl mx-auto grid md:grid-cols-3 gap-10 px-6">
          <div className="text-center">
            <div className="text-4xl">📁</div>
            <h3 className="text-xl font-semibold mt-3">1. Upload</h3>
            <p className="text-gray-600">Choose any file from your device.</p>
          </div>

          <div className="text-center">
            <div className="text-4xl">🔗</div>
            <h3 className="text-xl font-semibold mt-3">2. Get Link</h3>
            <p className="text-gray-600">
              We instantly generate a unique share link.
            </p>
          </div>

          <div className="text-center">
            <div className="text-4xl">⬇️</div>
            <h3 className="text-xl font-semibold mt-3">3. Share</h3>
            <p className="text-gray-600">
              Anyone with the link can download the file.
            </p>
          </div>
        </div>
      </section>

      <footer className="text-center py-6 bg-white text-gray-600 mt-8">
        © 2025 TempShare — Built by Prajwal Pai
      </footer>
    </div>
  );
};
