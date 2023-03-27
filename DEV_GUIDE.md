# Page for Developers and Contributors
This page is designated for those who are new to the project and are planning on
adding new features, fixing bugs, or just want to take a look. This is a work in 
progress for including information that will help developers get acquainted with the 
project.

## Table of Contents
<!-- TOC -->
* [Project Structure](#project-structure)
  * [Project](#project)
  * [Modules](#modules)
  * [Libraries](#libraries)
  * [Facets](#facets)
  * [Artifacts](#artifacts)
  * [Global Libraries, SDKs, and Problems](#global-libraries-sdks-and-problems)
* [The Packages and Files](#the-packages-and-files)
  * [src](#src)
    * [VITAmin](#VITAmin)
    * [model](#model)
    * [parsing](#parsing)
    * [SQLite](#sqlite)
  * [module-info.java](#module-infojava)
  * [resources](#resources)
  * [test](#test)
<!-- TOC -->

## Project Structure
Taking a look at the structure of this JavaFX project, one can go to **File -> Project Structure** or
**(Ctrl + Alt + Shift + S)** to see how the project is set up, such as how libraries are included in the module, 
which folders are resources and source folders, and more.

### Project
The Project tab contains the project name, the Software Development Kit (SDK, or in Java's case JDK), the language level, 
and the compiler output. The most important part is the JDK, which as of right now is version 19. A JDK contains the tools 
and libraries which are combined with Java Runtime Environment (JRE) and Java Virtual Machine (JVM). The JRE is responsible 
for integrating software plugins, jar files, and libraries necessary for source code to run. The JVM is a tool that allows 
Java code to be converted to machine language and execute on top of the host operating system. In short, the JDK is what 
allows the code to compile and run.

In combination with JavaFX, **if the JavaFX components are compiled with one JDK version, and later on are attempted to 
run using a different JDK version, there will be a version mismatch and the program will fail to run.**

To aid in fixing this issue, you can check your Environment Variables on your computer. 
Check if your *JAVA_HOME* variable exists and contains the path to the correct JDK version. 
It would also be helpful to put the JDK in your *Path* variables as well.

The compiler output designates where the compiled parts of the program will be located, such as the classes and databases.

### Modules
The Modules Tab contains the modules associated with the project, which in this case is just VITAmin. A module 
is a set of packages that declares which parts form an API accessible to other modules while other parts are internal and 
encapsulated. In the Sources tab, the Source, Resource, and Excluded folders are marked. Source folders are the parts of the 
project that are compiled. Resource folders contain resources such as images, XML files, and text files. Excluded folders 
are parts of the project that the IDE partially ignores, as they do not have a reason to be changed by the user. Excluded folders 
are generally parts of the project that the background software and IDE make changes to after the project is compiled and ran. 
Test folders contain test files.

The Paths tab contains information on where the compiler output is outputted to, which in this case is the out/production folder. 
This tab is not used much for anything else.

The Dependencies tab is important as it contains the libraries that the module depends on to compile and run. In this tab are 
the libraries needed for functions and classes in the module to work. The project can contain libraries but if the libraries 
are not marked to be bundled with the module, the module will not be able to locate the libraries, so the module will not 
compile without them. 

**Libraries can be added in the Global Libraries tab. By right-clicking a library, you can select Add to Module and select in which 
module to bundle it.*

### Libraries
The Library tab contains local and module libraries that only exist in the current project. Global libraries only need to be 
defined once. 

### Facets
Facets are not used in the project currently so there is no need to worry about it.

### Artifacts
Artifacts, on the other hand, are used in the project. Artifacts are responsible for the .jar file of the project. A .jar 
file is a Java executable that contains all the parts necessary to run the project outside an IDE. To create a .jar file: 
* Click the <code>+</code> at the top and select <code>JAR -> From modules with dependencies...</code>.
* Select <code>Launcher</code> as the Main class (unless the class for directly launching the program has changed. It is the class that extends Application but
in this case, a separate class was made to call <code>main()</code> from UploadScreenLauncher).
* Select <code>resources</code> as the destination for the <code>META-INF/MANIFEST.MF</code> destination.
* In the Toolbar at the top of Intellij, select <code>Build -> Build Artifacts -> <module_name>:jar -> Build</code>.

The .jar file will appear in the <code>out/artifacts/<module_name>_jar</code> folder. To run, double-click the .jar file 
or open a Terminal and run <code> java -jar <path_to_jar></code>.

### Global Libraries, SDKs, and Problems
As mentioned before, the Global Libraries tab contains libraries that are defined once and work across multiple projects.
The SDK tab contains the SDKs that have been used in the project. The Problems tab contains problems that show up if 
classpaths are broken, if libraries are exported to modules incorrectly, and other problems relating to how the resources of 
the project interact with each other.

## The Packages and Files
This section contains the information about the packages and files within the project. Starting at the top level, the <code>.idea</code> folder is managed by Intellij and 
handles local project set up. If this folder is deleted, one can reopen the project in an Intellij window and expect it to 
come back. The <code>out</code> and <code>target</code> folders are seldom edited by the user except in extremely niche cases. The <code>.iml</code> folder contains
information about the modules of the project, such as the source folders and libraries included.

### src
The <code>src</code> folder contains everything that the developer will edit. At its top level is the <code>main</code>, 
<code>test</code>, and the database for the user. **FOR DEVELOPERS, IF ACTUAL USER DATA IS BEING TESTED, MUST USE DATABASE 
OUTSIDE THE PROJECT.**

Within the <code>main</code> folder contains the <code>java</code> and <code>resources</code> folder. The <code>java</code>
folder contains all the packages that are the back-end of the project. These packages work together to create the processes that
allow the program to carry out the functions for the program to parse data, load files to the database, and control how the 
screens function. The <code>resources</code> folder contains the XML files that contain the screens that the user will be interacting with.
It also contains the <code>META-INF/MANIFEST.MF</code> file that contains base info for whenever a .jar file is created for 
the project. 

#### VITAmin

<code>VITAmin</code> contains the code for launching the program and the controllers for how the screens
function. The program's main class is the Launcher class, which just runs the main() function inside the UploadScreenLauncher 
class due to some problems with how the class extended the Application class from JavaFX's application package. The UploadScreenLauncher
creates a stage that looks in the resource folder for the UploadScreen FXML file and loads the FXML file. Each 'Launcher' 
class creates and launches a stage for its associated FXML file.

Each FXML file has a Pane with a field marked <code>fx:controller</code> that specifies what controller is used to control the 
FXML's functionality. For example, the UploadController class is the controller for the UploadScreen FXML file. UploadController 
contains all the functions that allow the buttons to work and fields to mark certain columns in the database. It also 
contains the functionality for loading a file path into the file field that will be parsed, as well as the function to parse 
the loaded file and inserting the parsed information into the database.

#### model

The model package contains the structure for the different parts of the database so that the developer as well as the different 
packages can interact more efficiently with information from the database. Model contains the different classes for Client, 
Demographic, Question, Return Data, and the Tax Year. Each class contains attributes that correspond with different columns 
within each of the tables that the classes represent. 
DataObject allows a connection to be made between the database and the 
project so that data can be grabbed from the database and outputted to the FXML files or used by different packages to 
be modified and displayed in the application.

DataBase is perhaps one of the most important classes in the model package. DataBase contains all the insertion and 
search functions for the database. Without it, no information would be able to be inserted, updated, or searched for. 
All the insertion functions are called when a file is uploaded to the application, though it does not mean that each function 
is always going to do something, as some files do not contain any information that pertain to other tables in the database. 
DataBase also initializes a database if one does not exist in the user's program.

#### parsing

The parsing package contains only a single class that is responsible for parsing data from an Excel/.csv file. Since the 
data that is included within the files are not marked for type or lack standardization with how each file is different, 
the parser must take into account all possibilities of data types and fields that the files can contain (which are specified
from the Internal Revenue Service (IRS) uses as well). The DataBase class 
utilizes the parser package as it needs the reformatted data and the standardized headers made by the parser to insert 
data into the database. 

#### SQLite

The SQLite package contains the base information for connecting to the database. It contains the path to the database (which 
can be changed if the database is moved to an exterior location) as well as the path to the test database that is contained in the 
test folder. SQLite package also executes queries so that information can be retrieved from the database and used in 
other packages. The DB class in SQLite connects and disconnects from the specified database using a Java Database Connectivity
(JDBC) library, which allows connection in Java with a SQLite database. It is important to note that whenever a database 
is connected to using the <code>connect()</code> function, whenever the function is done using the database, the connection 
must be disconnected using the <code>disconnect()</code> function. SQLite does not allow multiple connections into a 
database at the same time, otherwise data corruption could occur.

### module-info.java

The module-info file is important in terms of the entire project as it makes the project modular. Making the project modular
makes it so that libraries can be pointed to from the module and compiled with said libraries and used by other programs 
efficiently, as well as the creation of executables without the need of manually adding needed libraries. This file marks 
what libraries are required by the module which are then used when the project is opened and exported. The file also contains 
the name of the module, though there can be issues with a module name mismatch with the name of the module in this file 
and the name of the module in the Module tab of the Project Structure.

### resources
The resources folder, as mentioned before, contains XML files for the project. These files display the images for the 
user interface. The resources folder also contains the MANIFEST.MF file that contains information on the version number 
of the .jar file that is built for this project's artifact and the name of the .jar file.

### test
Test is where the test files are located. Using JUnit5, one can create tests to see if the functions that they create 
work properly before deployment. Though the test files are in early development, it still proves useful when checking 
what works. The FileParser class has the most updated test cases but the test data that the tests are compared against 
must be updated so that the test data accounts for all scenarios, can be used for all developers, and does not contain 
any actual user information.