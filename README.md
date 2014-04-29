Roman Numerals
=============

An application for converting Roman numbers into integers.  
The program takes a list of numbers to be converted as command line parameters.

The algorithm simply walks through the string to be converted from left to right  
and adds the current number to the sum if it's bigger or equal to the next number.  

If the next number is bigger we have to add to the sum the subtraction of the next  
and current numbers. We also have to increase the current number index by one to  
jump over the next number so that we don't add it into the sum again.  

If any unkown characters are found the algorithm will return -1.
