# Simple Scientific Calculator

README Updated on 12 Oct-2018, 4:30 AM IST.

A code to check that if a scientific expression is valid or not. 
If it is found to be a valid expression than the expression is solved and result is printed as output. 
If it is foound that the expression doesn't match mathematical constraints, it is referred to as an Invalid Expression. 


The code has been tested with the types of input as mentioned in testCases.txt file under the code directory. 

This project currently handles most of the scenarios but still some improvements will be done for testing extreme boundary conditions and programatically complex expressions. 
Many more test cases will be tested and code will be updated over the course of time, taking in account more of scientific calculation operands. 

Currently the operands which are taken into consideration are 
'(', ')', '*', '/', '+', '-', '^'

The numerical value can be an integer in between the range 0-9. 

One example of Valid test case is 
7+6*5^2+3-4/2

One example of InValid test case is (extra bracket in the end)
(8*5/8)-(3/1)-5)

To solve the expression B.O.D.M.A.S rule is applied

User first pass the number of test cases (say 5) against which the code will be tested. 
User than passses as many number of scientific expressions (in this case 5) on which a check for a Valid/Invalid expression will be performed.
If found valid, calculations are performed as told earlier. 

Divide by zero is conisdered to be a special case. 
If expression stands valid and has a divide by zero condition, "Infinity" is displayed as output result. 
