
# Introduction
This Java app mimics Linux `grep` command which allows the user to search matching strings from files. The app was built to help master core Java before joining the trading app project. Technologies used to complete this project were the core java libraries, docker to containerize the application and Maven for project management.

# Quick Start
This app can be run using Github source code or [Docker](https://hub.docker.com/r/kennygosai/grep).

To start using Github source code:

    #In root folder run
    mvn install
    mvn clean compile package
    java -cp target/grep-1.0-SNAPSHOT.jar ca.jrvs.apps.grep.JavaGrepImp <REGEX PATTERN> <SEARCH PATH> <WRITE FILE PATH>

To start using Docker

    docker pull kennygosai/grep
    docker run --rm -v `pwd`/data:/data -v `pwd`/log:/log kennygosai/grep <REGEX PATTER> <SEARCH PATH> <WRITE FILE PATH>


## Pseudocode
When the `process()` function is called the code is doing:

    matchedLines = []
    for file in listFiles(rootDir)
      for line in readLines(file)
          if containsPattern(line)
            matchedLines.add(line)
    writeToFile(matchedLines)

## Performance Issue
The file iterates through each file and each line, which depending on the file can require a lot of memory. If the file sizes are too large this may cause an OutOfMemoryError. To fix this I implemented a version that utilizes streams. Streams offer better performance when processing large lists. Another fix could be to adjust the maximum heap size when running eg:

    java -Xms5m -Xmx20m -cp target/grep-1.0-SNAPSHOT.jar ca.jrvs.apps.grep.JavaGrepImp .*Romeo.*Juliet.* ./data ./out/grep.txt

# Test
Testing was done manually. Prepared sample data using `egrep -r {regex} {rootPath} > {outFile}` and then compared the output from the Java application. Used IDE breakpoints as well as `self4j` to debug any issues while testing.

# Deployment
The app was Dockerized for the ease of the user. First creating the Dockerfile and then building the Docker image and pushing it to DockerHub. The source code is hosted on Github.

# Improvement

1. Unit Testing: Creating unit testing will help speed up testing rather than the current method of manually. It will also make it easier to test features more frequently while developing.
2. More Customizability: Allow users to customize their search more in-depth. For example, adding a depth limit for searching or letting users use multiple regex patterns.
3. Convert to Streams: As mentioned above, looping through Lists is used throughout the project. Converting the return types of functions would also help with memory usage.