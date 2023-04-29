package com.aab.arkansasassetbuilders;

/**
 * This module is used for creating the JAR file for the client.
 * The main application class extends from JavaFX's Application
 * class, which causes problems when building a JAR and using
 * the main file as the main class.
 */
public class Launcher {
    public static void main(String[] args) {
        // Replace "Main" with the name of the class that extends Application
        // See https://stackoverflow.com/a/52654791/3956070 for explanation
        //searchAndFilterControler.main(args);
        UploadScreenLauncher.main(args);
    }
}
