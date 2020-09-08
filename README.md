# Java Junior Developer Training Course.
88 hours training + 32 hours work project = 120 hr.

---

# Introduction to Java and Java Technology (*1* hour theory / *including 0.5* hour practice)
- Introduction to Java. Benefits.
- JDK, JVM.
- Java 2 (Java EE / SE / ME) 
- Tools: java, javac, javadoc

## Lab: Installing JDK, Tuning Environmental Variables
- Install JDK from [Oracle website](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- Set $JAVA_HOME and $PATH

### DoD
```
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
```
Hello, world!
```

---

# Development infrastructure: Git (1.5/0.5)
- Intro GIT
- Repos
- Commits
- Shortly about branches, conflicts and merges

## Lab: Setting Up Git
- Install [Git](https://git-scm.com/download/win) and in case of Windows [TortoiseGit](https://tortoisegit.org)
- Create account at [Github](http://github.com/): _teamXX_
- Fork this [repo](https://github.com/eugene-krivosheyev/java-junior) to your account
- Clone your fork repo locally
- Update README.md locally to your teammates names
- Commit and push initial commit
```
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
- Install [Maven](https://maven.apache.org/download.cgi)
- Set $M2_HOME
- Analyse our project: *tree* and *pom.xml*
- Move your old codebase to this project
- Make it build
- Take your last app under version control and push it

### DoD
```
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
- Download and install [IDEA](https://www.jetbrains.com/idea/?fromMenu) with trial corporate license
- Open our maven project
- Change <artifactId> in pom.xml to _teamXX_
- Build project with maven from IDEA
- Push

### DoD
- Trainer can see your team in pom.xml

---

# Java Syntax for Procedure Style (10/4)

## Comments
- Singe and multi-line
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

## Method’strategy parameters and Overloading
- As local variables
- Method overloading

## Primitives
- Primitive variable declaration and initialization
- Primitive types
- Primitive types literal values
- Primitive types casting
- Types Overflow and solution with [BigInteger](http://pr0java.blogspot.com/2015/05/biginteger-bigdecimal_70.html)
- FP precision loss and solution with [BigDecimal](http://dmilvdv.narod.ru/Translate/MISC/how_to_use_java_bigdecimal.html)

## References
- Reference types in Java
- Reference variables declaration and initialization
- Heap and stack
- Garbage collector

## Strings
- String type
- String literal values
- Interning
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
- Arithmetic type promotions
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
- Multi-dimension arrays

## Varargs
- Declaration
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

---

# Procedure style recap (1/0)
- Subject of procedural design
- Reuse
- Procedure generalization
- Inner quality attributes
- Metrics: cyclomatic complexity

---

# OOAD recap (4/1)
- Programming styles and paradigms
- Procedure style vs OOAD
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

# Refactoring with IDEA (1/0)
- Intro to Refactoring
- Basic Refactorings Matrix
- Wrap method / Sprout method

---

# Java Syntax for OOP (12/4)

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

## Instatiation
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

## Course Project Iteration 06: OOD Logger Library reached
- FR: presentation changes and sink changes
- Refactor to Polymorphic Commands and Appenders

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style
- Documented public API

---

# OOD Principles and Patterns (4/2)

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

# Unit testing with JUnit (6/3)
- Assertions in Java
- Testing scopes
- Unit tests
- Structure of unit test
- Tests and contract
- JUnit
- Hamcrest and FEST-assert
- Test doubles types
- Mockito
- Types of coverage (including permutation)
- Intro to TDD

## Course Project Iteration 08: Coverage with _Unit_ Tests
- Cover current components with _unit_ tests
- State what code covered

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style
- Documented public API
- Unit tests coverage ≥ 50%
- Permutation coverage ≥ 30%  

---

# Intro to Functional Style (6/3)
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
- Unit tests coverage ≥ 50%
- Permutation coverage ≥ 30%
- Introduced Observer for supportability

## Functional style
- Closures in java
- Lambdas
- Functional Interfaces
- Functional style: state, function composition, declarative, immutability

## Course Project Iteration 10: Introducing Filters
- FR: As developer I want filter my messages

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style
- Documented public API
- Unit tests coverage ≥ 50%
- Permutation coverage ≥ 30%
- Introduced lambdas for filtering messages

---

# Error handling with exceptions (4/2)
- Comparison of the exception mechanism to the traditional error-handling mechanism
- Types of exceptions, their handling
- Standard Java exceptions
- Designing exceptions type system

## Course Project Iteration 11: Introducing Exceptions
- FR: As developer I want strict contracts and error handling

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style
- Documented public API
- Unit tests coverage ≥ 70%
- Permutation coverage ≥ 50%
- Introduced checked exceptions for errors and alternate scenarios

---

# Generics (2/0.5)
- Generics as design style
- Type safety
- Generic classes
- Generic methods

## Demo: Type safety for sorting with anonymous implementation of comparator

---

# Work Project. Session 1 (8/8)

## Given
- PM
- Analyst
- Product'strategy FRs and NFRs
- System'strategy internal NFRs
- CI server
- Sonar server

## When
- Teams formed
- Every team'strategy git repo visible to PM and is identifiable
- Teams deliver product with two iterations

## Then
- PM and Business Customers accept product with two demo sessions

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
```
log("1", "2");
assertMessageEquals("3")
```

### DoD
- All given specifications runs are green
- Code reuse and minimum code duplication
- Code style
- Documented public API
- Unit tests coverage ≥ 70%

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

# IO (8/3)
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
- Unit tests coverage ≥ 70%

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
- Unit tests coverage ≥ 70%
- System tests for remote log server

---

# Multi-threading in Java (8/3)
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
- Unit tests coverage ≥ 70%
- System tests for remote log server

## [Server IO Design Patterns](https://www.dre.vanderbilt.edu/~schmidt/PDF/OOCP-tutorial4.pdf)
- Connector/Acceptor
- Proxy
- Pro-actor
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
- Unit tests coverage ≥ 70%
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

# JDBC API (6/2)
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
- Unit tests coverage ≥ 70%
- System test for DB

---

# Performance tuning and optimization in Java (3/1)
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

# Work Project. Session 2 (24/24)

## Given
- PM
- Analyst
- Product'strategy FRs and NFRs
- System'strategy internal NFRs
- CI server
- Sonar server
- Teams formed
- Every team'strategy git repo visible to PM and is identifiable

## When
- Teams deliver product with six iterations

## Then
- PM and Business Customers accept product with six demo sessions

---
