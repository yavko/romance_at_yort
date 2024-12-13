# Romance at Yort
A romance visual novel created for an AP CS A project.

## Architechture
- written in java
- Built around our custom made Visual Novel engine
- `javax.swing` for ui
- Java2D `Graphics` for rendering the actual content

## Building
Dependencies needed: a JDK, probably at least version 8

Build with BlueJ :)

### Jar
```sh
# build everything
javac EntryPoint.java
javac utils/*
javac engine/Game.java

# required a working JDK
jar cvfm RomanceAtYort.jar manifest.txt assets/ audio/ *.class engine/*.class utils/*.class
```

## Usage
The main class executable is `EntryPoint`, you can run it with whatever JRE/JDK
