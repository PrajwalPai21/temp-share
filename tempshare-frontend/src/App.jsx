import { BrowserRouter, Routes, Route } from "react-router-dom";

import Testing from "./pages/Testing";
import Navbar from "./components/Navbar";

const App = () => {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/testing" element={<Testing />}></Route>
      </Routes>
    </BrowserRouter>
  );
};

export default App;
