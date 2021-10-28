/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import Player.Player;

/**
 *
 * @author sebcandau
 */
public class Pawn {

    private final char pawnChar;
    private final Player owner;

    /**
     * Constructor of a pawn from information entered in parameters.
     *
     * @param c the character representing the pawn
     * @param player the player who owns the pawn
     */
    public Pawn(char c, Player player) {
        this.pawnChar = c;
        this.owner = player;
    }

    /**
     * useful for getting the owner of a pawn.
     *
     * @return the owner of a pawn
     */
    public Player getOwner() {
        return this.owner;
    }

    public char getPawnChar() {
        return this.pawnChar;
    }

    /**
     * Transform the character representing the pawn into a String.
     *
     * @return a String
     */
    @Override
    public String toString() {
        return Character.toString(this.pawnChar);
    }
}
