# JET Restaurant Interface

-----
<br>


<br>

## How to set up the test framework
1. **Clone the repository:** https://github.com/eoelliot1/JETInterface.git
2. Sync maven in pom.xml file.
3. Compile RestaurantInterface.java
4. Run RestaurantInterface.java in src directory
5. The program will ask you to "Enter a UK postcode..."
    You must type a UK postcode for example: CT1 2EH  and hit enter.
6. The program should return with corresponding results the postcode inputted.

<br>

## Assumptions:
- The assignment asked for rating 'as an number', so I assumed the rating was referring to the count field in ratings since they are usually integer numbers.
- By 'restaurant objects' I assumed it was referring to the restaurants field since that seemed to contain all the details that the assignment was looking for.
## Improvements:
- The program can be improved by considering cases of when user input for the postcode is incorrect. An example, would be validating the input using regex and sending an error messages if the postcode can't be validated as UK postcode. This will improve the robustness of the program
- The program could improve in how address data is displayed. Currently, it just prints the whole object however, it would be worth organising the output to make it more humanly interpretable.  
<br>
