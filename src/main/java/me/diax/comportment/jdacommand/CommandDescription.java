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

package me.diax.comportment.jdacommand;

import java.lang.annotation.*;

/**
 * Created by Comportment at 17:35 on 10/05/17
 * https://github.com/Comportment | comportment@diax.me
 *
 * This is for annotating classes which extend {@link Command}
 *
 * @author Comportment
 * @since 1.0.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CommandDescription {

    /**
     * This represents the name of the command which will be used for identification purposes.
     * @since 1.0.0
     */
    String name();

    /**
     * This represents an optional description of the command.
     *
     * @since 1.0.6
     */
    String description() default "";

    /**
     * This represents all of the keywords which can trigger the command. {@link #name()} will not be included unless put in here.
     * @since 1.0.0
     */
    String[] triggers();

    /**
     * The minimum amount of arguments the command must take.
     * @since 1.0.0
     */
    int args() default 0;

    /**
     * Any extra command attributes you might need.
     * @since 1.0.0
     */
    CommandAttribute[] attributes() default {};
}