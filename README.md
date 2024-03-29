# Java New Features

Repo to keep some examples of new features (from Java 8 until last version).

## Useful Links

[OpenJDK code](https://github.com/openjdk/jdk)  
[Java SE Subscription](https://www.oracle.com/java/java-se-subscription/)  
[JEP 12](https://openjdk.org/jeps/12) - Preview Features  
[JEP 3](https://openjdk.org/jeps/3) - JDK Release Process  
[JEP draft](https://openjdk.org/jeps/8300604) - Preview Features: A Look Back, and A Look Ahead  
[JEP 438](https://openjdk.org/jeps/438) - Vector API (Fifth Incubator)  
[JEP 448](https://openjdk.org/jeps/448) - Vector API (Sixth Incubator)  
[How to run the Java Incubator Module from the Command Line and IntelliJ IDEA](https://foojay.io/today/how-to-run-the-java-incubator-module-from-the-command-line-and-intellij-idea/)  
[Learn how to write fast Java code with the Vector API - JEP Café episode 18](https://www.youtube.com/watch?v=42My8Yfzwbg)  
[Java Microbenchmark Harness (JMH)](https://github.com/openjdk/jmh)  
[Microbenchmarking with Java](https://www.baeldung.com/java-microbenchmark-harness)  
[Java JMH Benchmark Tutorial](https://mkyong.com/java/java-jmh-benchmark-tutorial/)  

## Useful Commands

```
Command to compile using a incubator feature:
~/IdeaProjects/java-new-features/src/main/java$ javac -d ~/IdeaProjects/java-new-features/out --add-modules jdk.incubator.vector me/bruno/santana/incubator/VectorApiDemo.java 

Command to execute using a incubator feature:
~/IdeaProjects/java-new-features/out$ java --add-modules jdk.incubator.vector me.bruno.santana.incubator.VectorApiDemo

Compile using a incubator feature and informing classpath:
~/IdeaProjects/java-new-features/src/main/java$ javac -d ~/IdeaProjects/java-new-features/out -cp .:/home/bruno/.m2/repository/org/openjdk/jmh/jmh-core/1.35/jmh-core-1.35.jar:/home/bruno/.m2/repository/org/openjdk/jmh/jmh-generator-annprocess/1.35/jmh-generator-annprocess-1.35.jar:/home/bruno/.m2/repository/net/sf/jopt-simple/jopt-simple/5.0.4/jopt-simple-5.0.4.jar --add-modules jdk.incubator.vector me/bruno/santana/incubator/VectorApiDemo.java

Execute using a incubator feature and informing classpath:
~/IdeaProjects/java-new-features/out$ java -cp .:/home/bruno/.m2/repository/org/openjdk/jmh/jmh-core/1.35/jmh-core-1.35.jar:/home/bruno/.m2/repository/org/openjdk/jmh/jmh-generator-annprocess/1.35/jmh-generator-annprocess-1.35.jar:/home/bruno/.m2/repository/net/sf/jopt-simple/jopt-simple/5.0.4/jopt-simple-5.0.4.jar --add-modules jdk.incubator.vector me.bruno.santana.incubator.VectorApiDemo
```
