# Design/Code Review 1

## Project:  Choreography Builder

### Developer:  Oleksandra Ponomarova

### Reviewer:  Dan Miller

|Item |Considerations| Comments/Suggestions|
|--------|---------|---|
|||Reviewer comments and suggestions go here. Each item should have *at least* one "kudos" and two suggestions for improvement|
|**Problem Statement**|1. Accurately describes project purpose<br> 2. Is professional and free of typos, slang, etc.<br> 3. Fully explains the problem and the solution<br> 4. Is understandable by the average person|The Project Technologies/Techniques are very well documented with good detail.<br><br>  The project statement itself could have more detail.<br><br>  The grammer used in the project statement could be cleaned up. |
|**Design Documentation**|1. Navigation/flow through the application is logical and easy to use. <br>2. The order in which values are displayed are logical and easy to understand/use <br>3. The order in which the form fields entered are logical and easy to understand/use<br>4. All data discussed/documented (problem statement, flow, db design, etc.) is represented on the screens |Very nice use of the steps images when explaining a dance.<br><br>  The steps could be numbered so the user knows the order of the steps.<br><br> The flow diagram describes screens that aren't included with the actual screen designs.  May need to remove screens from the flow description that are no longer needed.|
|**Data model/Database**|1. Everything on the screens and problem statement/flow is represented in the model <br> 2. There is at least one 1-to-many relationship.<br> 3. The model represents good database design <br>|Nice use of multiple 1-to-many relationships in the database design.<br><br>|
|**Code**|1. Proper Maven project structure is used<br> 2. a .gitignore file for IntelliJ Java projects has been implemented <br> 3. There is not any redundant or copy/paste code in the JSPs or classes<br> 4. Classes are appropriately-sized (no monster classes)<br> Property files are used appropriately: no hard-coded values <br> 5. Logging statements are used rather than System.out.println and printStackTrace.<br> 6. There are appropriate unit tests/code coverages.| The code is very well organized and easy to follow.<br><br> Some of the variable names could be more descriptive.  For example the variable "o" in the equals method of the CustomSteps class.<br><br> The doPost method in the SearchStep class could possibly have methods called from the if statements for each type of request.












