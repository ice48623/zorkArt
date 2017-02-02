package io.muic.ooc.zorkArt;

/**
 * Created by ice on 2/1/17.
 */
public class ExitCommand implements Command {
    @Override
    public void apply(Player player, String arg) {
        System.exit(0);
    }
}
