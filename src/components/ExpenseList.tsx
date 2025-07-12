import type { Expense } from "../model/Expense";

interface props {
    expenses: Expense[]
}
const ExpenseList = ({expenses}: props) => {
    return  <div>
        <table border={1}>
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Amount</th>
                    <th>Category</th>
                    <th>note</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
                {expenses.map(expense => <tr key={expense.expenseId}>
                    <td>{expense.name}</td>
                    <td>{expense.amount}</td>
                    <td>{expense.category}</td>
                    <td>{expense.note}</td>
                    <td>{expense.date}</td>
                </tr>)}
            </tbody>
        </table>
    </div>  
}

export default ExpenseList