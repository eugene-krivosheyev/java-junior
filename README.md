
Программа подготовки Java Junior Developer  
64 hr. course + 16 hr. project = 80 hr.

---

# Introduction to Java and Java Technology (2/0.5) 
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

# Java App Outside as Black Box (3/1)
- Java Dictionary
- JCSC
- Classes and *.class files
- Order of class loading
- Classpath
- Java app definition
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

# Development infrastructure: Git (1/0.5)
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

# Development infrastructure: Maven (1/0.5)
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

# JetBrains IDEA (1/0.5)
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

# Procedure Style with Java (6/2)

## Comments
- Singe and multiline
- JavaDoc

## Procedure style
- Intro to procedure style
- Java Dictionary for naming

## Class Method Declaration
- Return type
- Static modifier 
- Name
- Parameters
- Static initializers
 
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
- Procedure Metrics: CC

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
- Documented public API

## Procedure style recap
- Subject of procedural design
- Reuse
- Procedure generalization
- Inner quality attributes
- Metrics: cyclomatic complexity

---

# OOAD recap (1/0.5)
- Programming styles and paradigms
- Procedure stype vs OOAD
- Classes and objects
- Inheritance and Delegation as code reuse styles
- Visibility as key for encapsulation
- Polymorphism as key for supportability
- Stateful and stateless design
- Metrics of OOAD: Coupling and Cohesion

## Demo: Logger Library Refactoring to OO-Design
- Example Appenders and Filters

## Discussion: OOAD benefits for _our_ Logger library and refactorings to do
- FR: presentation changes and sink changes
- Inner NFRs
- Refactorings to do
- Switch and polymorphism and OCP
- Command Design Pattern

---

# Refactoring with IDEA (0.5/0)
- Intro to Refactoring
- Basic Refactorings Matrix
- Wrap method / Sprout method

---

# Java Syntax for OOP (4/2)

## Final
- Final modifier semantics: 3

## Enums
- Enums emulation with class
- Switch recap 
- Smart Enum Pattern

## Course Project Iteration 04: Logger Library towards OO through Enums
- FR: presentation changes
- Refactor to Enums: Dumb Commands

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style
- Documented public API

## Encapsulation
- Encapsulation for packages
- Encapsulation for classes
- Access modifiers

## Inheritance
- Inheritance implementation
- Overriding methods
- Overriding constraints

## Instatiating
- Constructors
- Object Initializers
- Constructors with inheritance issue

## Course Project Iteration 05: Logger Library towards OO through Classes
- FR: presentation changes
- Introduce Facade Design Pattern
- Refactor to Smart Commands with classes

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style
- Documented public API

## Polymorphism
- Polymorphic collections
- Polymorphic arguments
- Polymorphic algorithms
- Type casting
- Abstract classes
- Template Method pattern
- Strategy/State patterns

## Interfaces
- Interface
- Implementation
- Multiple implementation
- Default modifiers for fields and methods
- Static and default (defender) methods

## Course Project Iteration 06: OO Logger Library reached
- FR: presentation changes and sink changes
- Refactor to Polymorphic Commands and Appenders

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style
- Documented public API

---

# OOD Principles and Patterns (2/1)

## OOAD Principles: SOLID
- SRP
- OCP and Abstraction leak issues
- LSP
- ISP
- DIP

## Creation Design Patterns
- Creator
- Factory
- DI

## Discussion: Logger Library Design meets principles and patterns
- What inner NFR issues do we have now
- What refactorings to do

## Course Project Iteration 07: Logger Library testability and supportability reached
- FR: presentation changes and sink changes
- Refactor to DI

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style
- Documented public API

---

# Unit testing with JUnit (2/1)
- Assertions in Java
- Testing scopes
- Unit tests
- Structure of unit test
- Tests and contract
- JUnit
- FEST-assert
- Test doublers
- Mockito
- Types of coverage
- Intro to TDD

## Course Project Iteration 08: Coverage with _Unit_ Tests
- Cover current components with _unit_ tests
- State what code covered

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style
- Documented public API
- Unit tests coverage >= 50%

---

# Intro to Functional Style (2/1)
- Nested Classes
- Inner classes
- Local classes
- Anonymous classes

## Course Project Iteration 09: Introduce Observer/Listener Design Pattern for Appenders extensibility
- Observer
- Implementation with Anonymous classes
- FR: As developer I want easily add new Appenders 

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style
- Documented public API
- Unit tests coverage >= 50%
- Introduced Observer for supportability

## Functional style
- Closures in java
- Lambdas
- Functional Interfaces
- Functional style: state, function composition, declarativity, immutability

## Course Project Iteration 10: Introducing Filters
- FR: As developer I want filter my messages

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style
- Documented public API
- Unit tests coverage >= 50%
- Introduced lambdas for filternig messages

---

# Error handling with exceptions (2/1)
- Comparison of the exception mechanism to the traditional error-handling mechanism
- Types of exceptions, their handling
- Standard Java exceptions

## Course Project Iteration 11: Introducing Exceptions
- FR: As developer I want strict contracts and error handling

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style
- Documented public API
- Unit tests coverage >= 70%
- Introduced checked exceptions for errors and alternate scenarios
 
---
 
# System library (6/2)
- System
- Math
- Object: hc and eq contract, toS
- String, its API. Immutability and interns. 
- StringBuffer, StringBuilder
- Wrapper classes
- Autoboxing

## Course Project Iteration 12: Logger Library Maturity Grown
- NFR: As a developer I want higher collection performance for messages through non-default eq and hc
- NRF: As a developer I want more polymorphism with toS for messages
- NFR: As a developer I want lower memory consumption through StringB*
- FR: As a developer I want business rules applied to all messages types
```java
log("1", "2");
assertMessageEquals("3")
```

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style
- Documented public API
- Unit tests coverage >= 70%

---

# Generics (1/0.5)
- Generics as design style
- Type safety
- Generic classes
- Generic methods

## Demo: Type safety for sorting with anonymous implementaion of comparator

---

# Collection API (4/1)
- Collection types and implementations
- Iteration over collections
- Comparable and Comparator
- Maps and implementations
- Utility classes Collections and Arrays
- Queues
- Stream API

## Course Project Iteration 13: Collections for code reuse
- Choose and state collection interfaces 
- Choose and state collection implementations
- Refactor legacy codebase to collections API

---

# IO (6/3)
- java.io.File
- RandomAccessFile
- Stream classes
- InputStreams and OutputStreams
- Stream chaining
- Readers and Writers

## Course Project Iteration 14: Logging to File. Finally!
- FR: As a developer I want messages logged to file as plain text

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style
- Documented public API
- Unit tests coverage >= 70%

## Serialization API
- Serialization API

## Networking with TCP/IP
- Network API
- Sockets and ServerSocket API
- Welcome to hell no.1! CAP theorem

## Course Project Iteration 15: Remote Logging
- FR: As a developer I want collect logs though many app instances and have centralized log
- Server App

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style
- Documented public API
- Unit tests coverage >= 70%
- System tests for remote log server

---

# Multithreading in Java (8/3)
- Thread definition
- Thread start: 3 options
- Thread management
- Thread states begin
- Priorities
- Daemons
- Thread API
- Blocking operations

## Course Project Iteration 16: Parallel LogServer App
- FR: As a developer I want more performance for server app
- NFR: File per Thread

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style
- Documented public API
- Unit tests coverage >= 70%
- System tests for remote log server

## [Server IO Design Patterns] (https://www.dre.vanderbilt.edu/~schmidt/PDF/OOCP-tutorial4.pdf)
- Connector/Acceptor
- Proxy
- Proactor
- Handler

### Discussion: what patterns do you invent?

## Concurrency
- Welcome to hell no.2! Concurrency.
- Thread safety and data race
- Thread synchronization
- synchronized section
- Lock API
- New thread states
- Collections thread safety
- wait() / notify()
- Deadlocks
- Intro to java.util.concurrent

## Course Project Iteration 17: Concurrent LogServer App
- FR: As a developer I want more and more performance for server app
- NFR: one file for threads
- NFR: less threads with non-blocking input
- Hints: available() and queues

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style
- Documented public API
- Unit tests coverage >= 70%
- Load test for remote log server

---

# Annotations and Reflection API intro (1/0)
- Annotations (0,5/0)
- Purpose of annotations
- Standard annotations
- Custom annotations
- Reflection API overview
- Class loaders
- Class introspection

---

# JDBC API (4/2)
- SQL recap: DDL and DML
- DB schema design
- Overview of JDBC API
- Driver types
- Connection to Derby
- Basic interfaces
- Retrieving data
- Transactions

## Course Project Iteration 18: Logging to database
- FR: As a developer I want log messages to DB

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style
- Documented public API
- Unit tests coverage >= 70%
- System test for DB

---

# [Performance tuning and optimization in Java] (2/1)
- JVM monitoring tool JVisualVM
- Heap structure
- GC types
- Profiling

## Course Project Iteration 19: Load testing and profiling
- Load test
- Profile with JVisualVM

### DoD
- Bottlenecks detected

---

# Flipcharts
- https://www.dropbox.com/sh/9gesjn5btwjrtqy/AABR0AqTleDg3b3U1Kl1yU5ha?dl=0

---

# Reading List
- http://tinyurl.com/skilltrek-reading-list
- http://bigocheatsheet.com
- https://habrahabr.ru/post/133981/

# Project CI
- Jenkins CI: http://52.90.99.224:8080/jenkins/
- Sonar Code Analysis Tool: http://52.90.99.224:9000
 

