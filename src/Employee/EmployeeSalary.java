package Employee;

 
abstract class Employee {
	
	protected int empId;
	protected String empName;
	protected int total_leaves;
	protected double total_salary;
	
	
	abstract void calculate_balance_leaves();
	
	abstract boolean avail_leave(int no_of_leaves, char type_of_leave);
	
	abstract void calculate_salary();
}


class PermanentEmp extends Employee{
	
 	int paid_leave; 
 	int sick_leave;
 	int casual_leave;
 	
	double basic;
	double hra;
	double pfa;
	
	public PermanentEmp(int empId, String empName, double basic, int paid_leave, int sick_leave, int casual_leave) 
	{
		this.empId=empId;
		this.empName=empName;
		this.basic = basic;
		this.paid_leave=paid_leave;
		this.sick_leave=sick_leave;
		this.casual_leave= casual_leave;
		total_leaves= paid_leave + sick_leave + casual_leave; 
		hra = 0.5 * basic;
		pfa = 0.12 * basic;
	}
		
	
 	void print_leave_details()
	{
 		System.out.println("Total leaves left: " + total_leaves);
 		System.out.println("Paid Leaves left: " + paid_leave);
 		System.out.println("Sick Leaves left: " + sick_leave);
 		System.out.println("Casual Leaves left: "+ casual_leave);
 	
	}
 	
	void calculate_balance_leaves() 
	{
 		int balance_leaves = paid_leave + sick_leave + casual_leave;
 		System.out.println("Total leaves left: " + balance_leaves);
	}
 	
	boolean avail_leave(int no_of_leaves, char type_of_leave) 
	{
		int balance_leaves =  paid_leave + sick_leave + casual_leave;
		
		if((balance_leaves >= no_of_leaves) && (paid_leave>= no_of_leaves) && (sick_leave >=no_of_leaves) && (casual_leave>= no_of_leaves) && ((type_of_leave == 'p') || (type_of_leave == 's') || (type_of_leave == 'c')) )
		{			
			if( type_of_leave == 'p')
			{
				paid_leave = paid_leave - no_of_leaves;
				total_leaves = total_leaves - no_of_leaves;
				System.out.println("Total leaves left: " + total_leaves);
		 		System.out.println("Paid Leaves left: " + paid_leave);
				
		    }
			else if( type_of_leave == 's')
			{
				sick_leave = sick_leave - no_of_leaves;
				total_leaves = total_leaves - no_of_leaves;
				System.out.println("Total leaves left: " + total_leaves);
		 		System.out.println("Sick Leaves left: " + sick_leave);
		    }
			else if( type_of_leave == 'c')
			{
				casual_leave = casual_leave - no_of_leaves;
				total_leaves = total_leaves - no_of_leaves;
				System.out.println("Total leaves left: " + total_leaves);
		 		System.out.println("Casual Leaves left: " + paid_leave);
		    }
			 
		return true;
		}
		else
		{
			System.out.println("No leaves granted");
			return false;
		}
	}
	
	  
	void calculate_salary()
	{
		this.total_salary = basic +hra - pfa;	
		System.out.println("Total Salary of " + empName + " is: " + total_salary);
	}

}

class TemporaryEmp extends Employee{
	
	public TemporaryEmp(int empId, String empName, double total_salary, int total_leaves) 
	{
		this.empId=empId;
		this.empName=empName;
		this.total_salary=total_salary;
        this.total_leaves=total_leaves;
	}
	
 	void calculate_balance_leaves() 
	{
 		 System.out.println("Total leaves left: " + total_leaves);
	}
 	
	boolean avail_leave(int no_of_leaves, char type_of_leave) 
	{
 		
		if(total_leaves >= no_of_leaves)
		{			
			total_leaves = total_leaves - no_of_leaves;
			return true;
		}
		else
		{
			System.out.println("No leaves granted");
			return false;
		}
	}
	
	  
	void calculate_salary()
	{
		this.total_salary = total_salary;
		System.out.println("Total Salary of " + empName + " is: " + total_salary);

	}
}




public class EmployeeSalary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Permanent Employee Details");
		System.out.println("--------------------------");

		PermanentEmp permanentEmployee =new PermanentEmp(1,"Praveen", 40000, 5, 6, 7);
		permanentEmployee.calculate_salary();
		permanentEmployee.avail_leave(2, 'p');
		
		System.out.println();
		permanentEmployee.avail_leave(14, 'p');
		System.out.println();
		
		permanentEmployee.print_leave_details();
		permanentEmployee.calculate_balance_leaves();
		
		System.out.println();
		 
		System.out.println("Temporary Employee Details");
		System.out.println("--------------------------");
		TemporaryEmp temporaryEmployee = new TemporaryEmp(2, "Ramesh", 30000, 10);
		temporaryEmployee.calculate_salary();
		temporaryEmployee.calculate_balance_leaves();
		System.out.println();
		
		temporaryEmployee.avail_leave(5, 'p');
		temporaryEmployee.calculate_balance_leaves();
	}

}
