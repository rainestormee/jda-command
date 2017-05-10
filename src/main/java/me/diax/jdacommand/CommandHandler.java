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

import net.dv8tion.jda.core.entities.Message;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Comportment at 17:43 on 10/05/17
 * https://github.com/Comportment | comportment@diax.me
 *
 * @author Comportment
 */
public class CommandHandler {

    private static Set<Command> commands = new HashSet<>();

    public static void registerCommands(Command... commands) {
        Collections.addAll(CommandHandler.commands, commands);
    }

    public static Command findCommand(String trigger) {
        return commands.stream().filter(cd -> Arrays.asList(cd.getDescription().triggers()).contains(trigger)).findFirst().orElse(null);
    }

    public static void execute(Command command, Message message, String args) {
        CommandDescription cd = command.getClass().getAnnotation(CommandDescription.class);
        if (cd == null) return;
        args = args.trim();
        if (cd.args() > args.split(" ").length) return;
        try {
            command.execute(message, args);
        } catch (Exception e) {
            throw new ExecutionException("Could not execute " + cd.name() + " due to an exception.\nHere is the stack trace:", e);
        }
    }
}