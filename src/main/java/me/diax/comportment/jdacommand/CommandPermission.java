package me.diax.comportment.jdacommand;

import net.dv8tion.jda.core.Permission;

/**
 * Created by Akio08 on 22/06/2017.
 */
public @interface CommandPermission {

    /**
     * This represents an Array of {@link Permission} that the {@link Command} which is annotated with this {@link CommandDescription} has.
     *
     * @return An array of {@link Permission}s, could be <code>null</code>.
     * @since 1.0.0
     */
    Permission[] permissions() default {};
}
