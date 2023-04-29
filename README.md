# VITAmin

<img width="135" alt="vitamin" src="https://user-images.githubusercontent.com/1328659/230636403-2a967e16-dc8b-457a-91d4-59524d2f3ae6.png">

A desktop application for organizing an aggregate of tax return information for users involved in helping and handling 
tax returns for clients.

The user is able to upload Excel/.csv files containing client tax return information into a database where the information
can be filtered by different criteria, making data viewing and collecting efficient and streamlined.

## Prerequisites
Users will need to have Java Development Kit (JDK) 18 or later installed in their computer to run the application. 
To check what version of Java is currently installed, in a Command Prompt (Windows) or Terminal (Mac) window, enter:

<code> java --version </code>

If you do not have Java installed in your computer, you can go to https://www.oracle.com/java/technologies/downloads/, which lists
the different download options depending on what operating system your computer runs on.
Follow the instructions of the desired option to download Java to your computer.


## Usage
The program contains a Java Archive (JAR) file that contains all 
the necessary libraries to run the application without needing to open the project in 
an Integrated Development Environment (IDE). The JAR file will be available to download *releases*
section of the GitHub page. Once downloaded, it is recommended that you move the JAR file to your desired
location before launching it.
To launch the software, simply double-click on the JAR file. If it is your first time launching the software,
a new database name *VITAmin.db* will be created in the same directory the JAR file is located. **Make sure to keep the JAR file and the db file in the same location at all times.**
Otherwise, the software will not be able to access the database. That said, if you ever need to make a new empty database, simply delete or move the current database to a different directory
and re-launch the software.
### Upload Screen
Once the application is opened, the user will be directed to an upload screen where users can upload the Excel/.csv files containing user tax return information.
The screen includes:
* a button to open a file explorer that allows the user to select an Excel/.csv file to upload.
* a text field containing the file path of the Excel/.csv file that will be uploaded.
* a text field where the user inputs the tax year attributed to the Excel/.csv file.
* a choice box where the user selects if the Excel/.csv file contents are Federal return information, State return information, or if neither are applicable.

Once all the fields are filled out, the user can then select the upload button to upload the Excel/.csv file contents to the application's database.
The user can then select next to move to the screen containing the filter results.

### Filter Result Screen
The filter screen displays the results of the filters applied to the data in the database. At first, there will not be any 
data displayed as no filters will be applied yet to the data. To apply filters to the data, the user can select the 
'Filter' button, which directs the user to the filter selection screen, where filters can be selected and applied to the data.

To return to the upload screen, the user can select the 'Back to Home' button.
### Filter Selection Screen
The filter selection screen allows the user to select different filters to apply to the data in order to view different queries of data 
from the database. As of right now, aggregate searches (e.g. sum of AGI for a client who filed in Arkansas, sorting clients based on 
location or tax return type, etc.) and custom searches have not yet been implemented for the filter, though it is planned for future versions.
### Updates
If a new version of the software releases, you can download it from the *releases* section of the GitHub page. If the description of the release indicates that the database schema was not changed, 
you can move the new JAR file to the same directory as your current database and continue using your current data. Make sure to delete or override your current JAR file.