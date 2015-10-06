
Программа подготовки Java Junior Developer  
80 hr. course + 24 hr. project = 104 hr.

---

# Introduction to Java and Java Technology (1/0.5) 
- Introduction to Java. Benefits. 
- JDK, JVM. 
- Java 2 (Java EE / SE / ME) 
- Tools: java, javac, javadoc

## Lab: Installing JDK, Tuning Environmental Variables
- Install JDK from http://www.oracle.com/technetwork/java/javase/downloads/index.html
- Set $JAVA_HOME and $PATH

### DoD
```java
$ javac -version
$ java -version
```

---

# Structure of Java-based applications (3/1)
- Classes and *.class files
- Java app definition
- Classloading
- Classpath
- Packages
- JARs

## Lab: developing simple java app
- Main and Printer classes
- Different packages
- One of them in JAR

### DoD
```java
$ Hello, world! 
```

---

# Development infrastructure: Git (1.5/0.5)
- Intro to GIT
- Repos
- Commits
- Shortly about branches, conflicts and merges

## Lab: Setting Up Git
- Install [Git] (https://git-scm.com/download/win) and in case of Windows [TortoiseGit] (https://tortoisegit.org)
- Create account at [Github] (http://github.com/): _teamXX_
- Fork this [repo] (https://github.com/eugene-krivosheyev/java-junior) to your account
- Clone your fork repo locally
- Update README.md locally to your teammates names
- Commit and push initial commit
```java
$ git add .
$ git commit -m “…”
$ git push
```

### DoD
- Trainer see all the forks in github
- Trainer can locate every teammate by its team repo

---

# Development infrastructure: Maven (1.5/0.5)
- Intro to Maven: build tool and dependency management
- Build lifecycle, goals
- Plugins
- pom.xml
- Dependencies and binary repositories

## Demo: Project Creating with Archetype Plugin

## Lab: Setting Up Maven
- Install [Maven] (https://maven.apache.org/download.cgi)
- Set $M2_HOME
- Analyse our project: *tree* and *pom.xml*
- Move your old codebase to this project
- Make it build
- Take your last app under version control and push it

### DoD
```java
$ ls teamXX
src README.md pom.xml

$ mvn clean verify
BUILD SUCCESS

$ git add .
$ git commit -m
$ git push
```

---

# JetBrains IDEA (1/0,5)
- Opening Maven projects
- Running java apps
- Running maven builds
- Debugging
- Hotkeys
- Git operations

## Lab: Installing, the first application compile, run, debugging
- Download and install [IDEA] (https://www.jetbrains.com/idea/?fromMenu) with trial corporate license
- Open our maven project
- Change <artifactId> in pom.xml to _teamXX_
- Build project with maven from IDEA
- Push

### DoD
- Trainer can see your team in pom.xml

---

# Java Syntax for Procedure Style (8/3)
- Intro to procedure style
- Java Dictionary for naming

## Class Method Declaration
- Return type
- Static modifier 
- Name
- Parameters
 
## Variable scopes
- Local variables
- Class variables and methods, static import
- Instance variables and methods: later

## Method’s parameters and Overloading
- As local variables
- Method overloading

## Primitives
- Primitive variable declaration and initialization
- Primitive types
- Primitive types literal values
- Primitive types casting
- Types Overflow

## References
- Reference types in Java
- Reference variables declaration and initialization
- Heap and stack
- Garbage collector

## Strings
- String type
- String literal values
- String concatenation

## Course Project Iteration 01: The Rise of Logger Library
- Read and analyse specification as tests for this iteration in *src/test*
- Uncomment specification cases
- Implement features needed

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style

## Operators
- Arithmetic
- Bitwise
- Logical (lazy and eager) 
- Compare and Ternary
- Object references and equality

## Controlling execution
- if/switch
- for/do/while/foreach

## Course Project Iteration 02: Logger Library
- Read and analyse specification as tests for this iteration in *src/test*
- Uncomment specification cases
- Implement features needed

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style

## Arrays
- Arrays declaration
- Array literals
- Multi-dimentional arrays

## Varargs
- Declaraion
- Using
- Constraints

## Course Project Iteration 03: Logger Library
- Read and analyse specification as tests for this iteration in *src/test*
- Uncomment specification cases
- Implement features needed

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style

---

# Java Syntax for OOP





