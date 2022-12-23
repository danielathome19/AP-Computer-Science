# Unit 0 - Java Development Setup and Installation
...


## Installing Java
...



## Installing a Text Editor or Development Environment (IDE)
...



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
