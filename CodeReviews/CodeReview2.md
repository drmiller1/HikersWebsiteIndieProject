# Design/Code Review 1

## Project: MHW Veterans Hunters Helping

### Developer: Kyle Maitland

### Reviewer: Dan Miller

|Item |Considerations| Comments/Suggestions|
|--------|---------|---|
|||Reviewer comments and suggestions go here. Each item should have *at least* one "kudos" and two suggestions for improvement|
|**Problem Statement**|1. Accurately describes project purpose<br> 2. Is professional and free of typos, slang, etc.<br> 3. Fully explains the problem and the solution<br> 4. Is understandable by the average person|Nice job writing the problem statement in a way that even a person who doesn't play the game can understand what your project is trying to accomplish.<br><br> More detail could be added to help the reader understand more about the game itself, including more examples of how a veteran can help a novice.<br><br> Reread the problem statement looking for gramatical errors. |
|**Design Documentation**|1. Navigation/flow through the application is logical and easy to use. <br>2. The order in which values are displayed are logical and easy to understand/use <br>3. The order in which the form fields entered are logical and easy to understand/use<br>4. All data discussed/documented (problem statement, flow, db design, etc.) is represented on the screens |Nice job on the design screens. I like the use of the twitter feed for communication between users.<br><br> The screens look like they have a good flow and are understandable for a veteran, but I'm wondering if more detail could be added for the novice.<br><br>  |
|**Data model/Database**|1. Everything on the screens and problem statement/flow is represented in the model <br> 2. There is at least one 1-to-many relationship.<br> 3. The model represents good database design <br>|The database design model is steup well and I like the use of the create/drop/insert sql.<br><br> The one to many relationships on the data model could be more clear.<br><br> Are all of the tables with id/name needed or could they be combined into one table? |
|**Code**|1. Proper Maven project structure is used<br> 2. a .gitignore file for IntelliJ Java projects has been implemented <br> 3. There is not any redundant or copy/paste code in the JSPs or classes<br> 4. Classes are appropriately-sized (no monster classes)<br> Property files are used appropriately: no hard-coded values <br> 5. Logging statements are used rather than System.out.println and printStackTrace.<br> 6. There are appropriate unit tests/code coverages.|Good start on the .jsp's. Also, the hibernate classes are well organized.<br><br> A log folder could be created to hold all of the logging statements.<br><br> At some point the junit tests will need to be created for all of the unit tests and code coverages. |












