import { useEffect, useState } from "react";
import axios from "axios";

const App = () => {
  const [users, setUsers] = useState([]);
  useEffect(() => {
    axios
      .get("http://localhost:8080/api/users")
      .then((res) => setUsers(res.data))
      .catch((err) => console.error(err));
  }, []);

  return <pre>{JSON.stringify(users, null, 2)}</pre>;
};

export default App;
