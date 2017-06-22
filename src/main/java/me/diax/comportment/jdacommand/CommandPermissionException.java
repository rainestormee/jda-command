package me.diax.comportment.jdacommand;

/**
 * Created by Akio08 on 22/06/2017.
 */
public class CommandPermissionException extends Exception {

    public CommandPermissionException(){
        super("You don't have enough permission to execute this command");
    }
}
