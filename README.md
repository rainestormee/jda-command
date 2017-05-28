<h1>JDA-Command</h1>
<h5>Small, powerful and lightweight command library for JDA.</h5>

This command library was built to help people make amazing bots within JDA!
<br>
It uses maven for dependency management because I am an XML fanboy,<br>but I also find gradle cool and use it for some projects.
<br>
Thank you for the amazing people at JDA for inspiring the creation of this library,<br>go and check them out at <link>https://github.com/DV8FromTheWorld/JDA/</link> 

<h3>Examples:</h3>

This is a command which echoes the input of the user if their sentence begins with the bot's prefix and `echo`, `repeat` or `copy`.


If the input was `bot, echo hello!` the output would be `hello!` (If the prefix was `bot, `) 
```java
@CommandDescription(name = "Echo", triggers = {"echo", "repeat", "copy"}, 
    description = "This command echoes what you say!", 
args = 1)
public class Echo implements Command {

    @Override
    public void execute(Message message, String args) {
        message.getChannel().sendMessage(args).queue();
    }
}
```

For more detailed examples please see the example repository
<a href="https://github.com/Comportment/JDA-Command-Examples">here</a>.
<br>
<h3>Bots using JDA-Command:</h3><hr>
<p>Examples marked with a <b>*</b> may not be suitable for beginners.</p>
<ul>
    <li><a href = "https://github.com/Comportment/Diax">Diax</a> by Comportment#9489<b>*</b></li>
    <li><a href = "https://github.com/Comportment/JDASelfBot">JDASelfBot</a> by Comportment#9489</li>
</ul>

<h4>Use JDA-Command in your projects today!</h4>

The current promoted version is 1.0.7

<h5>Maven</h5>

```xml
<!--Repository for JDA-Command-->
<repository>
    <id>jitpack.io</id>
    <name>jitpack</name>
    <url>https://jitpack.io</url>
</repository>
<!--Repository for JDA-->
<repository>
    <id>jcenter</id>
    <name>jcenter-bintray</name>
    <url>http://jcenter.bintray.com</url>
</repository>
```

```xml
<!--Dependency for JDA-Command-->
<dependency>
   <groupId>com.github.Comportment</groupId>
   <artifactId>JDA-Command</artifactId>
   <version>1.0.7</version>
</dependency>
<!--Dependency for JDA-->
<dependency>
    <groupId>net.dv8tion</groupId>
    <artifactId>JDA</artifactId>
    <version>3.1.0_206</version>
</dependency>
```

<h5>Gradle</h5>

```gradle
repositories {
    //This repository is needed for JDA.
    jcenter()
    //Make sure this repository is last.
    maven { url 'https://jitpack.io' }
}

dependencies {
    //JDA-Command dependency
    compile 'com.github.Comportment:JDA-Command:1.0.7'
    //JDA dependency
    compile group: 'net.dv8tion', name: 'JDA', version: '3.1.0_206'
}
```
