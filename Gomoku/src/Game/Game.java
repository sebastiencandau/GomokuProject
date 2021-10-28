/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Board.Board;
import InputOutput.Input;
import Player.Player;
import java.util.Scanner;

/**
 * A simple game.
 *
 * @author sebcandau
 */
public class Game {

    private final Player player1;
    private final Player player2;
    private final Board board;
    private Player currentPlayer;

    /**
     * The constructor of the game.
     */
    public Game() {
        this.board = new Board();
        this.player1 = new Player(1, 'x');
        this.player2 = new Player(2, 'o');
        this.currentPlayer = player1;

    }

    /**
     * The gomoku menu: The player must to choose the gamemod.
     */
    public void Menu() {
        System.out.println("Hello, welcome to Super Gomoku !");
        System.out.println("Please choose a game mode : ");
        System.out.println("1. -> two player modes");
        System.out.print("2. -> One player versus AI");
        System.out.println("");
        Scanner scan = new Scanner(System.in);
        int mode = Input.readIn(scan);
        //modeVerification(mode);
        if (mode == 1) {
            startTwoPlayers();
        } else {
            StartOnePlayer();
        }
    }

    /**
     * The course of the game's events when the mode one is chosen.
     */
    public void startTwoPlayers() {

        Scanner scan = new Scanner(System.in);
        while (true) {
            printBoard();
            System.out.println("");
            System.out.print("Player " + this.currentPlayer.getPawn().toString() + " choose a row : ");
            int inputRow = Input.readIn(scan);
            verification(inputRow);
            System.out.print("Player " + this.currentPlayer.getPawn().toString() + " choose a column : ");
            int inputColumn = Input.readIn(scan);
            verification(inputColumn);
            this.board.setCasePawn(inputColumn, inputRow, this.currentPlayer.getPawn());
            if (board.haveError) {
                board.haveError = false;
                startTwoPlayers();
            }
            if (board.haveWinner() == true) {
                printBoard();
                System.out.println("");
                System.out.println("The player " + this.currentPlayer.getPawn().toString() + " win !");
                break;
            }

            swapPlayer();
        }
        System.out.println("fin");

    }

    /**
     * The course of the game's events when the mode two is chosen.
     */
    public void StartOnePlayer() {
        System.out.println("You are the player one. you play first");
        Scanner scan = new Scanner(System.in);
        AI ia = new AI(player2);
        while (true) {
            printBoard();
            System.out.println("");
            System.out.print("Player x choose a row : ");
            int inputRow = Input.readIn(scan);
            System.out.print("Player x choose a column : ");
            int inputColumn = Input.readIn(scan);
            this.board.setCasePawn(inputColumn, inputRow, this.currentPlayer.getPawn());
            if (board.haveError) {
                board.haveError = false;
                StartOnePlayer();
            }
            if (board.haveWinner() == true) {
                printBoard();
                System.out.println("");
                System.out.println("The player " + this.currentPlayer.getPawn().toString() + " win !");
                break;
            }
            ia.AIPlay(inputRow, inputColumn, board, 1);
            if (board.haveWinner() == true) {
                System.out.println("");
                System.out.println("The player IA win !");
                printBoard();
                break;
            }
        }
    }

    private void swapPlayer() {
        if (this.currentPlayer.getId() == this.player1.getId()) {
            this.currentPlayer = this.player2;
        } else {
            this.currentPlayer = this.player1;
        }
    }

    private void printBoard() {
        board.showBoard();
    }

    private void verification(int input) {
        if (input < 0 || input >= 20) {
            System.err.println("Error -> Please choose a valid number");
            startTwoPlayers();
        } else if (Integer.toString(input).isEmpty()) {
            System.err.println("Error -> Please choose a valid number");
        }

    }

    private void modeVerification(int input) {
        if (input != 1 || input != 2) {
            System.err.println("Error -> Please choose a valid mode");
            Menu();
        }
    }

}
