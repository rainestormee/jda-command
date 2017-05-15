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

package me.diax.comportment.jdacommand.commands;

import me.diax.comportment.jdacommand.Command;
import me.diax.comportment.jdacommand.CommandAttribute;
import me.diax.comportment.jdacommand.CommandDescription;
import net.dv8tion.jda.core.entities.Message;

/**
 * Created by Comportment at 18:24 on 10/05/17
 * https://github.com/Comportment | comportment@diax.me
 * <p>
 * Represents an example command using JDA-Command.
 *
 * @author Comportment
 */
@CommandDescription(name = "Ping", triggers = {"ping", "pong"}, attributes = @CommandAttribute(key = "guildOnly"))
public class Ping implements Command {

    /**
     * This command simply sends a <p>Pong!</p> to the channel the command was executed in.
     */
    @Override
    public void execute(Message message, String args) {
        message.getChannel().sendMessage("Pong!").queue();
    }
}