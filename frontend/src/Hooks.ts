import { useState } from "react";

interface User {
    id: number;
    name: string;
    email: string;
};

export const useFetchUsers = () => {
  const [users, setUsers] = useState<User[]>([]);
  const [loading, setLoading] = useState<boolean>(false);
  const [error, setError] = useState<string | null>(null);

  const fetchUsers = async () => {
    setLoading(true);
    setError(null);

    try {
      setUsers([
        {
          id: 1,
          name: "hoge",
          email: "hoge@hoge.com",
        },
      ]);
    } catch (err) {
      setError((err as Error).message);
    } finally {
      setLoading(false);
    }
  };

  return { users, loading, error, fetchUsers };
};

