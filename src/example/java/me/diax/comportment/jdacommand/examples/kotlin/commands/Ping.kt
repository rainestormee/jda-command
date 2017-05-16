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

package me.diax.comportment.jdacommand.examples.kotlin.commands

import me.diax.comportment.jdacommand.Command
import me.diax.comportment.jdacommand.CommandAttribute
import me.diax.comportment.jdacommand.CommandDescription
import net.dv8tion.jda.core.entities.Message
import java.time.temporal.ChronoUnit

/**
 * Created by Comportment at 17:30 on 16/05/17
 * https://github.com/Comportment | comportment@diax.me
 *
 * @author Comportment
 */
@CommandDescription(name = "Ping", triggers = arrayOf("ping", "pong"), attributes = arrayOf(CommandAttribute(key = "guildOnly")))
class Ping : Command {

    /**
     * This command sends the bot's ping to the channel the message was sent in.
     */
    override fun execute(message: Message, args: String) {
        message.channel.sendMessage("Pinging...").queue {
            pinging ->
            pinging.editMessage("Ping: ${message.creationTime.until(pinging.creationTime, ChronoUnit.MILLIS)}ms").queue()
        }
    }
}