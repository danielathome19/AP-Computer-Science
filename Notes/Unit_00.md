# Unit 0 - Java Development Setup and Installation
Java is a popular **Object-Oriented Programming (OOP)** language that runs on a wide variety of platforms. It is commonly used for building web and mobile applications, as well as for developing desktop and server-side applications. Today, it is especially popular because it is easy to learn and transfer concepts to other programming languages, has a large and active community of developers, and continues to be used in enterprise applications due in part to it being cross-platform (i.e., usable on any operating system where the Java Runtime is installed) since it runs on a compatibility layer known as the **Java Virtual Machine (JVM)**. Before doing anything, you first need to install Java and a code editor of your choice.

To set up Java on your computer, you need to follow these steps:
1. Download and install the **Java Development Kit (JDK)**. The JDK is a software development kit that includes the tools you need to compile and run Java programs. You can download the JDK (not the Java Runtime Environment/JRE) from the Oracle website (https://www.oracle.com/java/technologies/javase-downloads.html) or from OpenJDK (https://openjdk.org/)
2. Once the download is complete, run the installer and follow the prompts to install the JDK
3. After the installation is complete, you need to set the PATH environment variable to include the directory where the JDK was installed, which is necessary to allow the **Java Compiler** (`javac`) and **Java Runtime** (`java`) to be found from any directory on your machine. First, run the command ``java -version` in your command line/terminal; if it runs successfully, you can skip the next two steps; otherwise (if you get an error like _"command not found"_), follow the next steps to properly setup the PATH variable for Java
4. To set the PATH environment variable on **Windows**, open the Control Panel, click on "System and Security," and then click on "System." From there, click on "Advanced system settings," and then click on the "Environment Variables" button. Under the "System variables" section, find the "Path" variable and click on "Edit." Add the path to the JDK bin directory to the end of the "Variable value" field, separated by a semicolon
5. To set the PATH environment variable on **macOS** or **Linux**, open your terminal and enter the following command:
```bash
export PATH=$PATH:/path/to/jdk/bin
```
Replace `/path/to/jdk/bin` with the actual path to the JDK bin directory on your machine.

Once you have Java set up, you can use it to write and run programs using your preferred development environment or text editor.

## Installing a Text Editor or Development Environment (IDE)
To start programming, you need some way to edit your code; either a **Text Editor** or **Integrated Development Environment (IDE)** — preferably some program with syntax highlighting to make it easy to read and write Java code.

To install a text editor or development environment for Java, you will need to follow these steps:
1. Download and install the JDK
2. Choose a text editor or development environment and install it
3. Set up your Java development environment. Follow the instructions provided by your text editor or development environment to set up your development environment, including specifying the location of the JDK and configuring any necessary project settings

Once you have completed these steps, you should be ready to start writing and running Java programs. Depending on your operating system, you can find many resources for installing Java specifically for your computer setup; note that while some operating systems include the **Java Runtime Environment (JRE)**, you still need the JDK as well. If you installed Java manually (not through an IDE), you can always run the following command in your terminal/command line to verify that Java has been installed properly: `java -version`

Two of the most popular software development programs for Java include:
* **IntelliJ (Community Edition is free):** https://www.jetbrains.com/idea/download/ — very useful since it will also install the **Java Development Kit** for you
* **Visual Studio Code:** https://code.visualstudio.com/download — you'll also likely want a few extensions like [**Code Runner**](https://marketplace.visualstudio.com/items?itemName=formulahendry.code-runner) and the [**Extension Pack for Java**](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

While not nearly as popular today, **Eclipse** (https://www.eclipse.org/downloads/) used to be one of the most used free Java editors for quite some time and still has a large following. Another free (archaic) Java IDE often used in schools is **BlueJ** (https://www.bluej.org/), though its interface is not quite as friendly. You can also use various online editors such as https://replit.com to make a new Java project and run the code instantly, which is a useful option for cloud or browser-based devices such as Chromebooks. If you're on a Unix-based operating system, check out **Nano**, **Vim**, **Emacs**, or **Neovim** for terminal-based code editors.

Once you have Java and an editor installed, make a new file in the project directory of your choice named **Hello.java** and paste in the following code:
```java
public class Hello {
  public static void main(String[] args) {
    System.out.println("Hello, world!");
  }
}
```
Find the **"Run"** button on your code editor to compile and run your program, or change the directory in your terminal to the folder you made the file in and run the command `java Hello.java` to execute your new program.

All Java programs follow this same set of steps:
1. Make a new file named `Your_Filename_Here.java` (name it whatever you want with the `.java` extension)
2. Type out the following code template (where `Your_Filename_Here` matches the **exact** filename minus the extension, case-sensitive):
```java
public class Your_Filename_Here {
  public static void main(String[] args) {
    
  }
}
```
3. Write some code in the blank lines between the `public static void main(String[] args) {` and the penultimate `}`
4. Run your program either with your editor's Run button or by typing `java YOUR_FILENAME_HERE.java` in the command line
5. Repeat!

You can find a brief tutorial on writing and running your first program at ----------. Note that many of the code examples provided are "snippets" of programs (i.e., parts of the code necessary to run a program) rather than every detail (such as the `public class` and `public static void main...` declarations). For all intents and purposes, assume that any code snippets may be ran by pasting them into a new program using the aforementioned template in the blank space in the middle. For example:

_To print out some text to the console, use `System.out.println("YOUR TEXT GOES HERE IN THE QUOTES");`, making sure each line ends with a semicolon `;`:_
```java
System.out.println("Hello, world!");
System.out.println("My name is NAME");
System.out.println("This is a simple Java program!");
```

This code could be ran in a Java file, named **PrintingTest.java** for example, by pasting the code snippet into our template as follows:
```java
public class PrintingTest {
  public static void main(String[] args) {
    System.out.println("Hello, world!");
    System.out.println("My name is NAME");
    System.out.println("This is a simple Java program!");
  }
}
```

Also note that whenever we enter a new set of curly-braces `{}`, we typically indent our code one tab-space (with the **Tab** key).

## Setting up Git and GitHub for Version Control
One of the best ways to organize programming portfolios and large software projects is using the **Git Version Control System (VCS)** (https://git-scm.com/) along with the website **GitHub** (https://github.com). Git is a version control system that allows you to track changes made to files and coordinate work on those files among multiple people and GitHub is a web-based hosting service for Git repositories that provides version control, collaboration, and project management features. There are many good online tutorials on setting up various text editors and IDEs with Git, but if you simply want to get started right away, you can check out the following video on using the web editor https://replit.com/ with GitHub: https://youtu.be/sTh6B-KyCjA

You can also check out the official documentation for [VS Code](https://code.visualstudio.com/docs/sourcecontrol/github) or [IntelliJ](https://www.jetbrains.com/help/idea/using-git-integration.html) to find steps on connecting to and/or sharing remote repositories.

In general, to set up Git and GitHub, you will need to follow these steps:
1. Install Git on your computer: You can download the latest version of Git from the official website (https://git-scm.com/) and follow the instructions to install it on your computer
2. Create a GitHub account: Go to the GitHub website (https://github.com/) and sign up for an account
3. Configure Git: After installing Git, you will need to configure it with your name and email address. This is important because every Git commit uses this information to identify you as the author. You can do this by running the following commands in your terminal:
```bash
git config --global user.name "Your Name"
git config --global user.email "your-email@example.com"
```
3. Create a new repository: A repository is a collection of files that are tracked by Git. To create a new repository on GitHub, click the "New" button on the top right of the dashboard. Enter a name for your repository and a short description, and then click the "Create repository" button
4. Clone the repository: Cloning is the process of creating a local copy of a remote repository on your computer. To clone your newly created repository, go to the repository page on GitHub and click the "Clone or download" button. Copy the URL of the repository, and then run the following command in your terminal:
```bash
git clone <repository-url>
```
This will create a new directory with the same name as the repository and download all the files from the repository into it

5. Make changes and commit: Now that you have a local copy of the repository, you can make changes to the files and commit them to the repository. To commit your changes, use the following commands:
```bash
git add <file>
git commit -m "Commit message"
```
The `git add` command stages the changes you have made to the file, and the `git commit` command records the changes and adds a message describing the changes

6. Push to GitHub: To upload your local commits to the remote repository on GitHub, use the following command:
```java
git push origin master
```
This will upload your commits to the **master** branch of the repository on GitHub.

These are the basic steps for setting up Git and GitHub for version control using the command line. You can find more information about using Git and GitHub in the official documentation.
