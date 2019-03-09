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