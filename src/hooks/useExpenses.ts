import { useEffect, useState } from "react";
import type { Expense } from "../model/Expense";
import { getExpenses } from "../Services/expense-service";

const useExpenses = () => {

    const [expenses, setExpenses] = useState<Expense[]>([]);
    const [error, setError] = useState(null);
    const [isLoading, setLoader] = useState(false);

    useEffect(() => {
        setLoader(true);
        getExpenses()
          .then(response => {
            setExpenses(response.data);
          }) 
          .catch(error => setError(error.message))
          .finally(() => setLoader(false));

    },[]);
    return {expenses, error, isLoading};
}

export default useExpenses;
