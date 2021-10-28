/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Board.Board;
import Player.Player;
import java.util.Random;

/**
 *
 * @author sebcandau
 */
public class AI {

    Player player;

    public AI(Player player) {
        this.player = player;
    }

    /**
     * An AI choosing a random action.
     * @param i the chosen row
     * @param j the chosen column
     * @param board the game board
     * @param min the minimum of options that can be chosen.
     */
    public void AIPlay(int i, int j, Board board, int min) {
        Random random = new Random();
        int max = 1 + random.nextInt(8);
        Random random2 = new Random();
        int nb;
        nb = min + random2.nextInt(max);
        if (nb == 1) {
            bottomBox(i, j, board);
        }
        
        if (nb == 2) {
            topBox(i, j, board);
        }
        if (nb == 3) {
            rightBox(i, j, board);
        }
        if (nb == 4) {
            leftBox(i, j, board);
        }
        if (nb == 5) {
            leftBottomDiag(i, j, board);
        }
        if (nb == 6) {
            rightBottomDiag(i, j, board);
        }
        if (nb == 7) {
            rightTopDiag(i, j, board);
        }
        if (nb == 8) {
            leftTopDiag(i, j, board);
        }
    }

    private void AIPlaysOnThisCase(int i, int j, Board board) {
        board.setCasePawn(j, i, this.player.getPawn());

    }

    private void bottomBox(int i, int j, Board board) {
        if (board.grid[i + 1][j].isOnBoard()) {
            if (board.grid[i + 1][j].isEmpty()) {
                AIPlaysOnThisCase(i + 1, j, board);

            } else {
                bottomBox(i + 1, j, board);
            }
        } else {
            AIPlay(i, j, board, 1);
        }
    }

    private void topBox(int i, int j, Board board) {
        if (i - 1 >= 0 && i - 1 < 20 && j >= 0 && j < 20) {
            if (board.grid[i - 1][j].isEmpty()) {
                AIPlaysOnThisCase(i - 1, j, board);

            } else {
                topBox(i - 1, j, board);
            }
        } else {
            AIPlay(i, j, board, 1);
        }
    }

    private void leftBox(int i, int j, Board board) {
        if (i >= 0 && i < 20 && j - 1 >= 0 && j - 1 < 20) {
            if (board.grid[i][j - 1].isEmpty()) {
                AIPlaysOnThisCase(i, j - 1, board);

            } else {
                topBox(i, j - 1, board);
            }
        } else {
            AIPlay(i, j, board, 1);
        }
    }

    private void rightBox(int i, int j, Board board) {
        if (board.grid[i][j + 1].isOnBoard()) {
            if (board.grid[i][j + 1].isEmpty()) {
                AIPlaysOnThisCase(i, j + 1, board);

            } else {
                topBox(i, j + 1, board);
            }
        } else {
            AIPlay(i, j, board, 1);
        }
    }

    private void rightBottomDiag(int i, int j, Board board) {
        if (i + 1 >= 0 && i + 1 < 20 && j + 1 >= 0 && j + 1 < 20) {
            if (board.grid[i + 1][j + 1].isEmpty()) {
                AIPlaysOnThisCase(i + 1, j + 1, board);

            } else {
                topBox(i + 1, j + 1, board);
            }
        } else {
            AIPlay(i, j, board, 1);
        }
    }

    private void leftBottomDiag(int i, int j, Board board) {
        if (i + 1 >= 0 && i + 1 < 20 && j - 1 >= 0 && j - 1 < 20) {
            if (board.grid[i + 1][j - 1].isEmpty()) {
                AIPlaysOnThisCase(i + 1, j - 1, board);

            } else {
                topBox(i + 1, j - 1, board);
            }
        } else {
            AIPlay(i, j, board, 1);
        }
    }

    private void rightTopDiag(int i, int j, Board board) {
        if (i - 1 >= 0 && i - 1 < 20 && j + 1 >= 0 && j + 1 < 20) {
            if (board.grid[i - 1][j + 1].isEmpty()) {
                AIPlaysOnThisCase(i - 1, j + 1, board);

            } else {
                topBox(i - 1, j + 1, board);
            }
        } else {
            AIPlay(i, j, board, 1);
        }
    }

    private void leftTopDiag(int i, int j, Board board) {
        if (i - 1 >= 0 && i - 1 < 20 && j - 1 >= 0 && j - 1 < 20) {
            if (board.grid[i - 1][j - 1].isEmpty()) {
                AIPlaysOnThisCase(i - 1, j - 1, board);

            } else {
                topBox(i - 1, j - 1, board);
            }
        } else {
            AIPlay(i, j, board, 1);
        }
    }

}
