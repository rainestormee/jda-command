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

/**
 * This represents a generic command.
 *
 * @author Raine
 * @since 1.0.0
 */
public interface AbstractCommand<T> extends Comparable<AbstractCommand<T>> {


    /**
     * Execute this command.
     *
     * @param object T is the object that is passed to this command
     * @param args The arguments from the command
     * @author Raine
     * @since 1.1.3
     */
    void execute(T object, Object... args);

    /**
     * Get the {@link CommandDescription} that annotates this {@link AbstractCommand}
     *
     * @return The {@link CommandDescription}
     * @author Raine
     * @since 1.1.3
     */
    default CommandDescription getDescription() {
        return getClass().getAnnotation(CommandDescription.class);
    }

    /**
     * Return the {@link CommandAttribute}s that are contained within the {@link CommandDescription} annotator
     *
     * @return The {@link CommandAttribute}s
     * @author Raine
     * @since 1.1.3
     */
    default CommandAttribute[] getAttributes() {
        return getDescription().attributes();
    }

    /**
     * Returns if the {@link CommandDescription} contains a {@link CommandAttribute} with the given key.
     *
     * @param key The key to check the {@link CommandAttribute} against.
     * @return If the relevant {@link CommandAttribute} exists
     * @author Raine
     * @since 1.1.3
     */
    default boolean hasAttribute(String key) {
        return Arrays.stream(getAttributes()).anyMatch(ca -> ca.key().equals(key));
    }

    /**
     * Returns the {@link String} that the given {@link CommandAttribute} contains.
     *
     * @param key The key to get the {@link CommandAttribute} of.
     * @return The relevant {@link String}
     * @author Raine
     * @since 1.1.3
     */
    default String getAttribute(String key) {
        return Arrays.stream(getAttributes()).filter(ca -> ca.key().equals(key)).findFirst().map(CommandAttribute::value).orElse(null);
    }

    @Override
    default int compareTo(AbstractCommand<T> that) {
        return this.getDescription().name().compareTo(that.getDescription().name());
    }
}