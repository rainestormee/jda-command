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

@file:JvmName("Main")
package me.diax.comportment.jdacommand.examples.kotlin

import me.diax.comportment.jdacommand.CommandHandler
import me.diax.comportment.jdacommand.examples.kotlin.commands.Echo
import me.diax.comportment.jdacommand.examples.kotlin.commands.Ping
import net.dv8tion.jda.core.AccountType
import net.dv8tion.jda.core.JDABuilder

/**
 * Created by Comportment at 17:46 on 16/05/17
 * https://github.com/Comportment | comportment@diax.me
 *
 * @author Comportment
 */
val handler = CommandHandler()

/**
 * Call on the instance of JDA and build it however you normally do, making sure to add your command listener and register your commands.
 * You can only register commands before building your JDA instances.
 *
 * @see CommandHandler#registerCommands(Set)
 * @see JDABuilder#addEventListener(Object...)
 * @see JDABuilder#buildBlocking()
 * @since 1.0.0
 */
fun main(args: Array<String>) {
    handler.registerCommands(Echo(), Ping())
    try {
        JDABuilder(AccountType.BOT).setToken("-token-").addEventListener(CommandListener(handler)).buildBlocking()
    } catch (ignored: Exception) {
    }
}