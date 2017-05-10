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

import me.diax.jdacommand.commands.Echo;
import me.diax.jdacommand.commands.Ping;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

/**
 * Created by Comportment at 18:07 on 10/05/17
 * https://github.com/Comportment | comportment@diax.me
 *
 * @author Comportment
 */
public class Main {

    /**
     * We call on the real main to avoid static abuse.
     */
    public static void main(String[] args) {
        new Main().main();
    }

    /**
     * Call on the instance of JDA and build it however you normally do, making sure to add your command listener and register your commands.
     * You can register commands before or after building your JDA instances.
     *
     * @see CommandHandler#registerCommands(Command...)
     * @see JDABuilder#addEventListener(Object...)
     * @see JDABuilder#buildBlocking()
     */
    private void main() {
        try {
            JDA jda = new JDABuilder(AccountType.BOT).setToken("-token-").addEventListener(new CommandListener()).buildBlocking();
        } catch (LoginException|InterruptedException|RateLimitedException ignored) {}
        CommandHandler.registerCommands(new Ping(), new Echo());
    }
}