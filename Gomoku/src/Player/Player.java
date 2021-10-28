/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import Board.Pawn;

/**
 * A simple player.
 *
 * @author sebcandau
 */
public class Player {

    private final int id;
    private final Pawn pawn;

    /**
     * A Player's constructor assigning him a pawn and an id.
     *
     * @param playerId : the id of a player
     * @param c : the character of the pawn of the player
     */
    public Player(int playerId, char c) {
        this.id = playerId;
        this.pawn = new Pawn(c, this);

    }

    /**
     * @return the id of a player
     */
    public int getId() {
        return this.id;
    }

    /**
     * @return the pawn of a player
     */
    public Pawn getPawn() {
        return this.pawn;
    }

}
