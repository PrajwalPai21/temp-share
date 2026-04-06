import React, { useEffect, useState } from "react";

export const UsersPage = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/auth/all-users")
      .then((res) => res.json())
      .then((data) => setUsers(data))
      .catch(() => alert("Failed to Load Users (UsersPage.jsx)"));
  }, []);
  return (
    <div className="min-h-screen bg-gray-100 p-8">
      <h1 className="text-3xl font-bold text-center mb-6 mt-10">
        All Registered Users
      </h1>

      <div className="max-w-4xl mx-auto bg-white p-6 rounded-xl shadow-md">
        <table className="w-full border-collapse">
          <thead>
            <tr className="border-b bg-gray-200">
              <th className="p-3 text-left">ID</th>
              <th className="p-3 text-left">Full Name</th>
              <th className="p-3 text-left">Email</th>
              {/* Add Date joined aswell in the future */}
              <th className="p-3 text-left">Date Joined</th>
            </tr>
          </thead>
          <tbody>
            {users.length === 0 ? (
              <tr>
                <td colSpan="3" className="text-center p-4">
                  No Users found/exist
                </td>
              </tr>
            ) : (
              users.map((uKey) => (
                <tr key={uKey.id} className="border-b hover:bg-gray-100">
                  <td className="p-3">{uKey.id}</td>
                  <td className="p-3">{uKey.fullName}</td>
                  <td className="p-3">{uKey.email}</td>
                </tr>
              ))
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
};
