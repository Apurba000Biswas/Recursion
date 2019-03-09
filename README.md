# Recursion
Solving a problem using recursion depends on solving smaller occurences of the same problem
##### Key question : "How is this problem self-similiar?"

### Example: Double the M&M bowl
  - We Need to Double the M&M candies in a large bowl
  - We dont know exactly how many are in the bowl
  - We are not able to count, but many of us can work together
  - How do we do it?

<div align="center">
  <img src ="Image/mnm_candies.jpg" width ="400">
</div>

##### Psudo code:
 doubleMnMs(bowl):

 	if bowl is empty:

 		hand bowl back to previous persion. (Nothing to do!)
 	
 	else
 		
 		take One M&M out.
 		
 		hand bowl to next persion;tell them to double the M&M in it.
 		
 		when they hand the bowl back, put Two M&Ms in it
 		
 		hand bowl back to previous persion

### Recursive Programming:
Writting function that calls themselvs to solve problems that are recursive in nature
  - An equally powerfull substittute for iteration (loop)
  - Particularly well-suited to solving certain typese of problems
  - Many programming languages("functional" languages such as Scheme, ML, Haskel) use recursion exclusiely(no loops)

Every recursive algorithm involves atleast 2 cases
  - base case: (Stop case) A simple occurence that can be answered directly
  - recursive case: A more complex occurrence of the problem that can not be directly answered.

#### Double the M&M bowl Sollution

	private int doubleMnM(int bowl){
		if(bowl == 0){
			// base case
			return 0; // bowl is empty so pass it back
		}else{
			// recursive case
			bowl = doubleMnM(bowl-1); // pick one MnM then pass it to next
			return bowl + 2; // when bowl comes back put two MnM in it and then pass it back
		}
	}

#### Simulation
if we call the method with parameter "4"

	doubleMnM(4)

<div align="center">
  <img src ="Image/mnm_simulation.png" width ="800">
</div>
	
Final out put will be "8"