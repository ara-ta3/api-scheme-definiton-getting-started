import React, { useState } from "react";

import { useFetchUsers } from "./Hooks";

const App: React.FC = () => {
  const { users, loading, error, fetchUsers } = useFetchUsers();
  return (
    <div>
      <button onClick={fetchUsers}>Fetch Users</button>

      {loading && <p>Loading...</p>}
      {error && <p style={{ color: "red" }}>{error}</p>}

      <ul>
        {users.map((user) => <li key={user.id}>{user.name} ({user.email})</li>)}
      </ul>
    </div>
  );
};

export default App;
