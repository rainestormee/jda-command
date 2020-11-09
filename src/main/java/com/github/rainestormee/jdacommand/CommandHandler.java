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

package com.github.rainestormee.jdacommand;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * The {@link CommandHandler} which deals with the registered {@link AbstractCommand}s.
 *
 * @author Raine
 * @since 1.0.0
 */
public class CommandHandler<T> {

    /**
     * A set of all of the commands that this {@link CommandHandler} has registered.
     *
     * @see #getCommands()
     * @since 1.0.0
     */
    private final Set<AbstractCommand<T>> commands = new HashSet<>();

    /**
     * A method to register {@link AbstractCommand}s with this {@link CommandHandler}.
     *
     * @param commands The {@link AbstractCommand}s to register.
     * @see #registerCommand(AbstractCommand)
     * @since 1.0.0
     */
    public void registerCommands(Set<AbstractCommand<T>> commands) {
        this.commands.addAll(commands);
    }

    /**
     * A method to register {@link AbstractCommand}s with this {@link CommandHandler}.
     *
     * @param commands The {@link AbstractCommand}s to register.
     * @see #registerCommand(AbstractCommand)
     * @see #registerCommands(Set)
     * @since 1.0.1
     */
    @SafeVarargs
    public final void registerCommands(AbstractCommand<T>... commands) {
        Collections.addAll(this.commands, commands);
    }

    /**
     * A method to register a {@link AbstractCommand} with this {@link CommandHandler}.
     *
     * @param command The {@link AbstractCommand} to register.
     * @see #registerCommands(Set)
     * @since 1.0.1
     */
    public void registerCommand(AbstractCommand<T> command) {
        this.registerCommands(command);
    }

    /**
     * A method to unregister {@link AbstractCommand}s with this {@link CommandHandler}.
     *
     * @param commands The commands to unregister.
     * @see #unregisterCommand(AbstractCommand)
     * @see #unregisterCommands(Set)
     * @since 1.0.1
     */
    public void unregisterCommands(Set<AbstractCommand<T>> commands) {
        this.commands.removeAll(commands);
    }

    /**
     * A method to unregister {@link AbstractCommand}s with this {@link CommandHandler}.
     *
     * @param commands The commands to unregister.
     * @see #unregisterCommand(AbstractCommand)
     * @see #unregisterCommands(Set)
     * @since 1.0.1
     */
    @SafeVarargs
    public final void unregisterCommands(AbstractCommand<T>... commands) {
        this.commands.removeAll(Arrays.asList(commands));
    }

    /**
     * A method to unregister a {@link AbstractCommand} with this {@link CommandHandler}.
     *
     * @param command The command to unregister.
     * @see #unregisterCommands(Set)
     * @see #unregisterCommands(AbstractCommand...)
     * @since 1.0.1
     */
    public void unregisterCommand(AbstractCommand<T> command) {
        this.unregisterCommands(command);
    }

    /**
     * A method to get all of the {@link AbstractCommand}s registered with this {@link CommandHandler}
     *
     * @return All of the commands registered with this command handler.
     * @since 1.0.1
     */
    public Set<AbstractCommand<T>> getCommands() {
        return commands;
    }

    /**
     * Method which attempts to find a {@link AbstractCommand} from the given trigger
     *
     * @param trigger The trigger of the command to find.
     * @return The {@link AbstractCommand} that was found, sometimes <code>null</code>
     * @since 1.0.0
     */
    public AbstractCommand<T> findCommand(String trigger) {
        return commands.stream().filter(cd -> Arrays.asList(cd.getDescription().triggers()).contains(trigger)).findFirst().orElse(null);
    }

    /**
     * Method which attempts to execute the given {@link AbstractCommand}.
     *
     * @param command The {@link AbstractCommand} to execute.
     * @param message The {@link T} which triggered the command.
     * @param args    The arguments of the command.
     * @since 1.0.0
     */
    public void execute(AbstractCommand<T> command, T message, Object... args) {
        CommandDescription cd = command.getDescription();
        if (cd == null)
            return;

        command.execute(message, args);
    }

    /**
     * A method which calls {@link #findCommand(String)}, and then {@link #execute(AbstractCommand, T, Object...)} if the found {@link AbstractCommand} is not <code>null</code>
     *
     * @param trigger The trigger of the command.
     * @param message The {@link T} which triggered the command.
     * @param args    The args of the command.
     * @see #findCommand(String)
     * @see #execute(AbstractCommand, T, Object...)
     * @since 1.0.1
     */
    public void findAndExecute(String trigger, T message, String args) {
        AbstractCommand<T> command = this.findCommand(trigger);
        if (command == null || command.getDescription() == null)
            return;
        this.execute(command, message, args, trigger);
    }
}
