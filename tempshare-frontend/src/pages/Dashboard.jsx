import React, { useState } from "react";

const Dashboard = () => {
  const [selectedFile, setSelectedFile] = useState(null);
  const [uploadedFile, setUploadedFile] = useState(null);
  const [message, setMessage] = useState("");
  const [loading, setLoading] = useState(false);

  // Handle upload button click
  const handleUpload = async () => {
    if (!selectedFile) {
      setMessage("Please select a file first.");
      return;
    }

    setLoading(true);
    setMessage("");

    // FormData is REQUIRED for file upload
    const formData = new FormData();
    formData.append("file", selectedFile);

    try {
      const response = await fetch("http://localhost:8080/files/upload", {
        method: "POST",
        body: formData, // DO NOT set Content-Type manually
      });

      if (!response.ok) {
        throw new Error("Upload failed");
      }

      const result = await response.json(); // backend returns JSON
      setUploadedFile(result);
      setMessage("File uploaded successfully!");
      setSelectedFile(null);
    } catch (error) {
      setMessage("Upload failed. Try again.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="min-h-screen bg-gray-100 px-6 py-10 mt-10">
      <h1 className="text-3xl font-bold mb-8 text-center text-blue-600">
        Upload & Share Files
      </h1>

      {/* Upload Box */}
      <div className="max-w-xl mx-auto bg-white shadow-lg rounded-2xl p-8">
        <h2 className="text-xl font-semibold mb-4">Select a file</h2>

        <input
          type="file"
          className="w-full mb-4"
          onChange={(e) => setSelectedFile(e.target.files[0])}
        />

        <button
          onClick={handleUpload}
          disabled={loading}
          className={`w-full py-2 rounded-lg text-white transition ${
            loading
              ? "bg-gray-400 cursor-not-allowed"
              : "bg-blue-600 hover:bg-blue-700"
          }`}
        >
          {loading ? "Uploading..." : "Upload File"}
        </button>

        {message && (
          <p className="mt-4 text-center font-medium text-gray-700">
            {message}
          </p>
        )}
      </div>

      {/* Uploaded File Info */}
      {uploadedFile && (
        <div className="max-w-xl mx-auto mt-8 bg-white shadow rounded-2xl p-6">
          <h2 className="text-lg font-semibold mb-3 text-green-600">
            File Ready to Share 🎉
          </h2>

          <p className="text-gray-700">
            <strong>Name:</strong> {uploadedFile.originalName}
          </p>

          <p className="text-gray-700">
            <strong>Size:</strong> {(uploadedFile.size / 1024).toFixed(2)} KB
          </p>

          <p className="mt-3">
            <strong>Download Link:</strong>
          </p>

          <a
            href={uploadedFile.downloadUrl}
            target="_blank"
            rel="noopener noreferrer"
            className="text-blue-600 underline break-all"
          >
            {uploadedFile.downloadUrl}
          </a>
        </div>
      )}
    </div>
  );
};

export default Dashboard;
