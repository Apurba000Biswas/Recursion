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
if we call the method with argument "4"

	doubleMnM(4)

<div align="center">
  <img src ="Image/mnm_simulation.png" width ="700">
</div>
	
Final out put will be "8"

#### [Doubling M&M sollution Link](https://github.com/Apurba000Biswas/Recursion/blob/master/src/practise_set_1/RecursionProb.java)

### Example: Towers of Hanoi

The Towers of Hanoi puzzle asks the player to move a stack of disks from one peg to another, moving one peg at a time
  - A dsik can not ever sit on a larger disk
Write a recursive function "moveDiscs" with three parameters
  - Number of disks, start peg, end peg

That moves that many discs from start peg to end peg

<div align="center">
  <img src ="Image/tower_of_hanoi.png" width ="700">
</div>

#### Solution:
##### Step 1:
<div align="center">
  <img src ="Image/ts_1.png" width ="700">
</div>

##### Step 2:

<div align="center">
  <img src ="Image/ts_2.png" width ="700">
</div>

##### Step 3:

<div align="center">
  <img src ="Image/ts_3.png" width ="700">
</div>

##### [Towers of Hanoi Sollution Link](https://github.com/Apurba000Biswas/Recursion/blob/master/src/practise_set_1/RecursionProb.java)

## Fractals:
A self- similar mathematical set that can  often be drawn as a reccuring graphical pattern.

##### Example: 


1. CantorSet:

<div align="center">
  <img src ="Image/fractals_ex_1.gif" width ="800">
</div>

#### [CantorSet sollution](https://github.com/Apurba000Biswas/fractals/blob/master/src/fract_recursion.cpp)

2. Sierpinski triangle: 

<div align="center">
  <img src ="Image/sierp-det.gif" width ="500">
</div>

3. Koch snowflake : 

<div align="center">
  <img src ="Image/koch_snowflake.png" width ="500">
</div>

4. Mandlebrot set: 

<div align="center">
  <img src ="Image/mandle_brot.jpg" width ="500">
</div>

### Aplication Using recursion [Boggle](https://github.com/Apurba000Biswas/Boggle)

Acknowledgement
-----------------

Stanford(CS-106B) : http://stanford.edu/class/archive/cs/cs106b/cs106b.1184/index.shtml
