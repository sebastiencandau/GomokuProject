/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import Player.Player;

/**
 * A simple box
 *
 * @author sebcandau
 */
public class Box {

    private final int numBoxRow;
    private final int numBoxColumn;
    private Pawn content;

    /**
     * The constructor of an non-empty box.
     *
     * @param numBoxRow
     * @param numBoxColumn
     * @param content
     */
    public Box(int numBoxRow, int numBoxColumn, Pawn content) {
        this.numBoxRow = numBoxRow;
        this.numBoxColumn = numBoxColumn;
        this.content = content;
    }

    /**
     * @return the row of an box
     */
    public int getRow() {
        return this.numBoxRow;
    }

    /**
     * @return the column of an box
     */
    public int getColumn() {
        return this.numBoxColumn;
    }

    /**
     * @return the owner of a box
     */
    public Player boxPawnOwner() {
        return this.content.getOwner();
    }

    /**
     * @return the pawn of a box
     */
    public Pawn getContent() {
        return this.content;
    }

    /**
     * Add a pawn to our box.
     *
     * @param pawn to add to the box
     */
    public void setPawn(Pawn pawn) {
        this.content = pawn;
    }

    /**
     * @return if the box is empty or not.
     */
    public boolean isEmpty() {
        return this.content.getPawnChar() == ' ';
    }

    /**
     * @return true if the box is not empty.
     */
    public boolean isNotEmpty() {
        return this.content.getPawnChar() != ' ';
    }

    /**
     * @return true if the coordinates entered in parameters are on the board.
     */
    public boolean isOnBoard() {
        boolean isOnBoard;
        if (this.numBoxRow >= 0 && this.numBoxRow < 20
                && this.numBoxColumn >= 0 && this.numBoxColumn < 20) {
            isOnBoard = true;
        } else {
            isOnBoard = false;
        }
        return isOnBoard;
    }

    /**
     * @return the representation in String of an empty box and a filled box.
     */
    @Override
    public String toString() {
            return "| " + this.content.toString() + " ";
        }
}
