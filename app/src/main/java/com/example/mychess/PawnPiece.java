package com.example.mychess;

import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class PawnPiece {
    private final List<List<ImageButton>> board;
    private final List<String> blackPieces;
    private final List<String> whitePieces;
    private final ImageButton pawn;
    private final int letterIndex;
    private final int numberIndex;


    public PawnPiece(ImageButton pawn, int letterIndex, int numberIndex) {
        board = ChessBoardFragment.getBoard();
        blackPieces = BoardManager.getBlackPieces();
        whitePieces = BoardManager.getWhitePieces();
        this.pawn = pawn;
        this.letterIndex = letterIndex;
        this.numberIndex = numberIndex;
    }

    public List<ImageButton> getPossibleMoves() {
        List<ImageButton> possibleMoves = new ArrayList<>();

        if (pawn.getTag().equals("white_pawn")) {
            if (board.get(letterIndex).get(numberIndex + 1).getTag().equals("empty")) {
                possibleMoves.add(board.get(letterIndex).get(numberIndex + 1));

                if (numberIndex == 1) {
                    if (board.get(letterIndex).get(numberIndex + 2).getTag().equals("empty")) {
                        possibleMoves.add(board.get(letterIndex).get(numberIndex + 2));
                    }
                }
            }
        }
        else if (pawn.getTag().equals("black_pawn")){
            if (board.get(letterIndex).get(numberIndex - 1).getTag().equals("empty")) {
                possibleMoves.add(board.get(letterIndex).get(numberIndex - 1));

                if (numberIndex == 6) {
                    if (board.get(letterIndex).get(numberIndex - 2).getTag().equals("empty")) {
                        possibleMoves.add(board.get(letterIndex).get(numberIndex - 2));
                    }
                }
            }
        }
        return possibleMoves;
    }

    public List<ImageButton> getPossibleTakes() {
        List<ImageButton> possibleTakes = new ArrayList<>();

        if (pawn.getTag().equals("white_pawn")){
            if (letterIndex - 1 >= 0 && numberIndex + 1 <= 7) {
                if (blackPieces.contains(board.get(letterIndex - 1).get(numberIndex + 1).getTag().toString())) {
                    possibleTakes.add(board.get(letterIndex - 1).get(numberIndex + 1));
                }
            }
            if (letterIndex + 1 <= 7 && numberIndex + 1 <= 7) {
                if (blackPieces.contains(board.get(letterIndex + 1).get(numberIndex + 1).getTag().toString())) {
                    possibleTakes.add(board.get(letterIndex + 1).get(numberIndex + 1));
                }
            }
        }
        else if (pawn.getTag().equals("black_pawn")){
            if (letterIndex - 1 >= 0 && numberIndex - 1 >= 0) {
                if (whitePieces.contains(board.get(letterIndex - 1).get(numberIndex - 1).getTag().toString())) {
                    possibleTakes.add(board.get(letterIndex - 1).get(numberIndex - 1));
                }
            }
            if (letterIndex + 1 <= 7 && numberIndex - 1 >= 0) {
                if (whitePieces.contains(board.get(letterIndex + 1).get(numberIndex - 1).getTag().toString())) {
                    possibleTakes.add(board.get(letterIndex + 1).get(numberIndex - 1));
                }
            }
        }
        return possibleTakes;
    }

    public List<ImageButton> getProtectedPieces() {
        List<ImageButton> protectedPieces = new ArrayList<>();
        if (pawn.getTag().equals("black_pawn")){
            if (letterIndex - 1 >= 0 && numberIndex - 1 >= 0) {
                if (blackPieces.contains(board.get(letterIndex - 1).get(numberIndex - 1).getTag().toString())) {
                    protectedPieces.add(board.get(letterIndex - 1).get(numberIndex - 1));
                }
            }
            if (letterIndex + 1 <= 7 && numberIndex - 1 >= 0) {
                if (blackPieces.contains(board.get(letterIndex + 1).get(numberIndex - 1).getTag().toString())) {
                    protectedPieces.add(board.get(letterIndex + 1).get(numberIndex - 1));
                }
            }
        }
        else if (pawn.getTag().equals("white_pawn")){
            if (letterIndex + 1 <= 7 && numberIndex + 1 <= 7) {
                if (whitePieces.contains(board.get(letterIndex + 1).get(numberIndex + 1).getTag().toString())) {
                    protectedPieces.add(board.get(letterIndex + 1).get(numberIndex + 1));
                }
            }
            if (letterIndex - 1 >= 0 && numberIndex + 1 <= 7) {
                if (whitePieces.contains(board.get(letterIndex - 1).get(numberIndex + 1).getTag().toString())) {
                    protectedPieces.add(board.get(letterIndex - 1).get(numberIndex + 1));
                }
            }
        }
        return protectedPieces;
    }

    public List<ImageButton> getThreatenedEmptySquares() {
        List<ImageButton> threatenedSquares = new ArrayList<>();
        if (pawn.getTag().equals("white_pawn")) {
            if (letterIndex - 1 >= 0 && numberIndex + 1 <= 7) {
                if (board.get(letterIndex - 1).get(numberIndex + 1).getTag().toString().equals("empty")) {
                    threatenedSquares.add(board.get(letterIndex - 1).get(numberIndex + 1));
                }
            } else if (letterIndex + 1 <= 7 && numberIndex + 1 <= 7) {
                if (board.get(letterIndex + 1).get(numberIndex + 1).getTag().toString().equals("empty")) {
                    threatenedSquares.add(board.get(letterIndex + 1).get(numberIndex + 1));
                }
            }
        }
        else if (pawn.getTag().equals("black_pawn")) {
            if (letterIndex - 1 >= 0 && numberIndex - 1 >= 0) {
                if (board.get(letterIndex - 1).get(numberIndex - 1).getTag().toString().equals("empty")) {
                    threatenedSquares.add(board.get(letterIndex - 1).get(numberIndex - 1));
                }
            }
            if (letterIndex + 1 <= 7 && numberIndex - 1 >= 0) {
                if (board.get(letterIndex + 1).get(numberIndex - 1).getTag().toString().equals("empty")) {
                    threatenedSquares.add(board.get(letterIndex + 1).get(numberIndex - 1));
                }
            }
        }
        return threatenedSquares;
    }
}
