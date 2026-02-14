import { BrowserRouter, Routes, Route } from "react-router-dom";

import Testing from "./pages/Testing";
import Navigbar from "./components/Navigbar.jsx";
import Home from "./pages/Home";

const App = () => {
  return (
    <BrowserRouter>
      <Navigbar />
      <Routes>
        <Route path="/home" element={<Home />}></Route>
        <Route path="/testing" element={<Testing />}></Route>
      </Routes>
    </BrowserRouter>
  );
};

export default App;
