# CJ_Session5Assignment3

Create an class Employee with following properties and functions
Properties:
int empId
String empName int total_leaves double total_salary

Methods:
void calculate_balance_leaves(); boolean
avail_leave(int no_of_leaves, char type_of_leave); void calculate_salary();
Create two subclasses PermanentEmp and TemporaryEmp that extend Employee class with following properties and functions
PermanentEmp
Properties:
int paid_leave, sick_leave, casual_leave
double basic, hra,pfa
Methods: void print_leave_details() override void calculate_balance_leaves() override boolean avail_leave(int no_of_leaves, char type_of_leave) override void calculate_salary()
TemporaryEmp
No new properties
Methods: override void calculate_balance_leaves() override boolean avail_leave(int no_of_leaves, char type_of_leave) override void calculate_salary()

Expected Output
Write a program that will compute an Employee's salary and manage their leave details.
Note:
 
Pf = 12% of basic hra
= 50% of basic
total_sal = basic + hra – pf
