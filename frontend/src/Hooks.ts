import { useState } from "react";
import { Configuration, DefaultApi } from "./openapi";

interface User {
    id: number;
    name: string;
    email: string;
};

const apiClient = new DefaultApi(
    new Configuration(
        {
            basePath: "http://localhost:8080"
        }
    )
);

export const useFetchUsers = () => {
    const [users, setUsers] = useState<User[]>([]);
    const [loading, setLoading] = useState<boolean>(false);
    const [error, setError] = useState<string | null>(null);

    const fetchUsers = async () => {
        setLoading(true);
        setError(null);

        try {
            const users = await apiClient.apiUsersGet();
            setUsers(users);
        } catch (err) {
            setError((err as Error).message);
        } finally {
            setLoading(false);
        }
    };

    return { users, loading, error, fetchUsers };
};

