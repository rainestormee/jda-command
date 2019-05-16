<h1>JDA-Command</h1>
<h5>Small, powerful and lightweight command library for JDA.</h5>

This command library was built to help people make amazing bots within JDA!
<br>
It uses maven for dependency management because I am an XML fangirl,<br>but I also find gradle cool and use it for some projects.
<br>
Thank you for the amazing people at JDA for inspiring the creation of this library,<br>go and check them out at <link>https://github.com/DV8FromTheWorld/JDA/</link> 
<br>
<br>
READ THE DOCS : <a href="https://rainestormee.github.io/jda-command/docs">https://rainestormee.github.io/jda-command/docs</a>
<br>
<h3>Examples:</h3>
https://github.com/Nekos-life/neko-bot-jda - Neko-Bot JDA (@IAmTails) <br />

Command Example!

This is a command which echoes the input of the user if their sentence begins with the bot's prefix and `echo`, `repeat` or `copy`.


If the input was `bot, echo hello!` the output would be `hello!` (If the prefix was `bot, `) 
```java
import com.github.rainestormee.jdacommand.AbstractCommand;
import com.github.rainestormee.jdacommand.CommandAttribute;
import com.github.rainestormee.jdacommand.CommandDescription;
import net.dv8tion.jda.core.entities.Message;

@CommandDescription(
        name = "echo",
        triggers = {"echo", "repeat", "copy"},
        description = "This command echoes what you say!",
        attributes = {@CommandAttribute(key = "args", value = "1")}
)
public class HelpCommand implements AbstractCommand<Message> {

    @Override
    public void execute(Message message, String args) {
        message.getChannel().sendMessage(args).queue();
    }
}

```

<br>
<h4>Use JDA-Command in your projects today!</h4>

The current promoted version is 1.1.3

<h5>Maven</h5>

```xml
<repository>
    <id>jitpack.io</id>
    <name>jitpack</name>
    <url>https://jitpack.io</url>
</repository>
```

```xml
<!--Dependency for JDA-Command-->
<dependency>
   <groupId>com.github.rainestormee</groupId>
   <artifactId>JDA-Command</artifactId>
   <version>1.1.3</version>
</dependency>
```

<h5>Gradle</h5>

```gradle
repositories {
    //Make sure this repository is last.
    maven { url 'https://jitpack.io' }
}

dependencies {
    //JDA-Command dependency
    compile 'com.github.rainestormee:JDA-Command:1.1.3'
}
```
