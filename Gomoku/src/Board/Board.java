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
public class Board {

    /**
     * Our gomoku grid made up of Boxes.
     */
    public Box[][] grid;
    public boolean haveError = false;

    //CONSTRUCTOR
    /**
     * The constructor of the game board.
     */
    public Board() {
        Player board = new Player(0, ' ');
        Pawn emptyBox = new Pawn(' ', board);
        this.grid = new Box[25][25];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                this.grid[i][j] = new Box(i, j, emptyBox);
            }
        }
    }

    /**
     * When a player plays on a box, the pawn assigned to the player is added to
     * the box.
     *
     * @param row of the grid
     * @param column of the grid
     * @param pawn assigned to a player
     */
    public void setCasePawn(int row, int column, Pawn pawn) {
        if (grid[column][row].isEmpty()) {
            this.grid[column][row].setPawn(pawn);
        } else {
            System.err.println("Error -> Please choose an empty box.");
            this.haveError = true;
        }
    }

    /**
     * method of determining whether there is a winner or not.
     * @return true if we have a winner, false if not 
     */
    public boolean haveWinner() {
        boolean havewinner = false;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (grid[i][j].isNotEmpty()) {
                    if (haveFiveSameNeighbors(i, j, 0) == 5) {
                        return true;
                    }
                }
            }
        }
        return havewinner;
    }

    /**
     * A recursive method verifying that each neighbor of a box entered as a
     * parameter has the same content as its neighbor box.
     *
     * @param row of designated box
     * @param column of designated box
     * @param i a counter
     * @return the number of times passed through the loop
     */
    public int haveFiveSameNeighbors(int row, int column, int i) {
        if (i < 5) {
            if (grid[row + i][column].isOnBoard()) {
                if (grid[row + i][column].boxPawnOwner() == grid[row][column].boxPawnOwner()) {
                    i = haveFiveSameNeighbors(row, column, i + 1);
                    haveFiveSameNeighbors(row, column, i + 1);
                }
            }
            if (grid[row][column + i].isOnBoard()) {
                if (grid[row][column + i].boxPawnOwner() == grid[row][column].boxPawnOwner()) {
                    i = haveFiveSameNeighbors(row, column, i + 1);
                    haveFiveSameNeighbors(row, column, i + 1);
                }
            }
            if (grid[row + i][column + i].isOnBoard()) {
                if (grid[row + i][column + i].boxPawnOwner() == grid[row][column].boxPawnOwner()) {
                    i = haveFiveSameNeighbors(row, column, i + 1);
                    haveFiveSameNeighbors(row, column, i + 1);
                }
            }
            if (row + i >= 0 && column - i >= 0) {
                if (grid[row + i][column - i].boxPawnOwner() == grid[row][column].boxPawnOwner()) {
                    haveFiveSameNeighbors(row, column, i + 1);
                    i = haveFiveSameNeighbors(row, column, i + 1);
                }
            }
        }

        return i;
    }

    /**
     * Method allowing the construction of a game board
     */
    public void showBoard() {
        System.out.print("    0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19\n");
        System.out.print("  ");
        for (int i = 0; i < 20; i++) {
            System.out.print("+---");
        }
        System.out.print("+");
        for (int j = 0; j < 20; j++) {
            System.out.println("");
            if (j < 10) {
                System.out.print(j + " ");
            } else {
                System.out.print(j);
            }
            for (int i = 0; i < 20; i++) {
                System.out.print(grid[j][i].toString());
            }
            System.out.print("|");
            System.out.println("");
            System.out.print("  ");
            for (int i = 0; i < 20; i++) {
                System.out.print("+---");
            }
            System.out.print("+");
        }
    }
}
