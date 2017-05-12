/*
 * Copyright 2017 Comportment | comportment@diax.me
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.diax.jdacommand;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by Comportment at 18:09 on 10/05/17
 * https://github.com/Comportment | comportment@diax.me
 *
 * @author Comportment
 */
public class CommandListener extends ListenerAdapter {

    private final String prefix = "!>";
    private final CommandHandler handler;
    
    public CommandListener(CommandHandler handler) {
        this.handler = handler;
    }

    /**
     * This gets the raw content of the message, checks if the message starts with the {@link #prefix} or if the author is a bot.
     * <br>
     * Then it trims the prefix out of the content and searches the first word to see if it matches a command trigger.
     * <br>
     * If a command is found, then the command is executed.
     *
     * @see CommandHandler#findCommand(String)
     * @see CommandHandler#execute(Command, Message, String)
     * @since 1.0.0
     * @apiNote Updated in 1.0.2 to include examples of how to use attributes.
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getRawContent();
        if (event.getAuthor().isBot() || !message.startsWith(prefix)) return;
        message = message.replaceFirst(prefix, "");
        String cmdName = message.split(" ")[0];
        Command command = handler.findCommand(cmdName.toLowerCase());
        if (command == null) return;
        if (!event.getChannelType().equals(ChannelType.TEXT) && !command.hasAttribute("guildOnly")) return;
        handler.execute(command, event.getMessage(), message.replaceFirst(cmdName, ""));
    }
}
