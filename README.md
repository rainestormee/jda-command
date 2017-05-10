#JDA-Command
#####Small but powerful command library for JDA.

This command library was built to help people make amazing bots within JDA!

It uses maven for dependency management because I am an XML fanboy, but I also find gradle cool and use it for some projects.

Thank you for the amazing people at JDA for inspiring the creation of this library, go check them out at <link>https://github.com/DV8FromTheWorld/JDA/</link> 

### Examples:

This is a command which echoes the input of the user if their sentence begins with the bot's prefix and `echo`, `repeat` or `copy`.


If the input was `bot, echo hello!` the output would be `hello!` (If the prefix was `bot, `) 
```java
@CommandDescription(name = "Echo", triggers = {"echo", "repeat", "copy"}, args = 1)
public class Echo implements Command {

    @Override
    public void execute(Message message, String args) {
        message.getChannel().sendMessage(args).queue();
    }
}
```

For more detailed examples please see the example package located at `src/example/java/me.diax.jdacommand`

### Bots using JDA-Command:
> Coming soon!

#### Use JDA-Command in your projects today!

#####Maven

```xml
<!--Dependency for JDA-Command-->
<dependency>
   <groupId>com.github.Comportment</groupId>
   <artifactId>JDA-Command</artifactId>
   <version>1.0.0</version>
</dependency>

<!--Repository for JDA-Command-->
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

#####Gradle
```gradle
dependencies {
    compile 'com.github.Comportment:JDA-Command:1.0.0'
}

repositories {
    //Make sure this repository is last.
    maven { url 'https://jitpack.io' }
}
```