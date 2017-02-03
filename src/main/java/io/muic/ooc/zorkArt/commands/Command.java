package io.muic.ooc.zorkArt.commands;

import io.muic.ooc.zorkArt.item.Player;

/**
 * Created by ice on 2/1/17.
 */
public interface Command {
    void apply(Player player, String arg);
}
