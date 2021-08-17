# PaMedia API Test Project

**Installation Instructions**

This test project is written in Java using the Eclipse IDE 
It will require and IDE such as Eclipse (or Intellij) to run.

Download this project to an  Workspace folder on a local machine

In the Eclipse IDE

1.  From the File menu, select Import. The Select screen opens.
2.  Expand Maven and select Existing Maven Projects.
3.  Click Next.
4.  For Root Directory, click Browse and select the top-level project folder.
5.  Verify that the Projects list includes all subprojects and click Finish.


# To Run the API

This is a Maven project and may require a  "**Maven Update project"** to download the remote repositories.
The project is using TestNG framework, so to run the class **weather.java**, select the **testng.xml** file in the root of the project , right mouse click, and **Run as TestNG Suite**
 
## Tools / Framework

I chose to write this task in Java as a Maven Project, So it would be easy for a 3rd Party to import and use the same levels of software as I employed. 
I used RestAssured for the API its well supported and works well. I have used TestNG in the project as is a nice way of separating the tests, it also meant I could use ExtentReports, which gives a nice graphical display of test results. After running the test using the testng.xml a report is created under the directory "test-output"  in directory "Extentreports" 

## Scope of Project

I wrote what I believed to be the requirements for the project and to test some other features of the API to track a reported bug. I let for room for an enhanced project to pass parameters to the variables. To write any more testing of the API with the known information would have been too exhaustive.

I would have questioned the Product Owner for more information on what data they were expecting back from the API , so the test could have been more refined . I would have pressed the Customer a little more on what the Bug was with evidence there is an issue.  

## What I could do differently

This test would have been better using a BDD Cucumber framework , so the Dates / Locations could have been passed as Parameters from the Feature file,  thus not requiring a code change to update Date & Location parameters, Also various scenarios could have been run in the same execution.  
This framework would have a feature file, Step Definitions, Page Object file , Hook file and a runner, so the code and project would be more granular and easier to maintain.
