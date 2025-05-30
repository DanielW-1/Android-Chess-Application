package com.example.mychess;

import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class KingPiece {
    private final List<List<ImageButton>> board;
    private final List<String> blackPieces;
    private final List<String> whitePieces;
    private final ImageButton king;
    private final int letterIndex;
    private final int numberIndex;

    public KingPiece(ImageButton king, int letterIndex, int numberIndex) {
        board = ChessBoardFragment.getBoard();
        blackPieces = BoardManager.getBlackPieces();
        whitePieces = BoardManager.getWhitePieces();
        this.king = king;
        this.letterIndex = letterIndex;
        this.numberIndex = numberIndex;
    }

    public List<ImageButton> getPossibleMoves(){
        List<ImageButton> possibleMoves = new ArrayList<>();

        if (king.getTag().equals("white_king") || king.getTag().equals("black_king")) {
            if (letterIndex + 1 <= 7){
                if (board.get(letterIndex + 1).get(numberIndex).getTag().equals("empty")) {
                        possibleMoves.add(board.get(letterIndex + 1).get(numberIndex));
                }
            }
            if (letterIndex + 1 <= 7 && numberIndex + 1 <= 7){
                if (board.get(letterIndex + 1).get(numberIndex + 1).getTag().equals("empty")) {
                        possibleMoves.add(board.get(letterIndex + 1).get(numberIndex + 1));
                }
            }
            if (numberIndex + 1 <= 7){
                if (board.get(letterIndex).get(numberIndex + 1).getTag().equals("empty")) {
                        possibleMoves.add(board.get(letterIndex).get(numberIndex + 1));
                }
            }
            if (letterIndex - 1 >= 0) {
                if (board.get(letterIndex - 1).get(numberIndex).getTag().equals("empty")) {
                        possibleMoves.add(board.get(letterIndex - 1).get(numberIndex));
                }
            }
            if (numberIndex - 1 >= 0){
                if (board.get(letterIndex).get(numberIndex - 1).getTag().equals("empty")) {
                        possibleMoves.add(board.get(letterIndex).get(numberIndex - 1));
                }

            }
            if (letterIndex - 1 >= 0 && numberIndex - 1 >= 0){
                if (board.get(letterIndex - 1).get(numberIndex - 1).getTag().equals("empty")){
                        possibleMoves.add(board.get(letterIndex - 1).get(numberIndex - 1));
                }
            }
            if (letterIndex + 1 <= 7 && numberIndex - 1 >= 0){
                if (board.get(letterIndex + 1).get(numberIndex - 1).getTag().equals("empty")) {
                        possibleMoves.add(board.get(letterIndex + 1).get(numberIndex - 1));
                }

            }
            if (letterIndex - 1 >= 0 && numberIndex + 1 <= 7){
                if (board.get(letterIndex - 1).get(numberIndex + 1).getTag().equals("empty")) {
                        possibleMoves.add(board.get(letterIndex - 1).get(numberIndex + 1));
                }
            }
        }
        return possibleMoves;
    }


    public List<ImageButton> getPossibleTakes(){
        List<ImageButton> possibleTakes = new ArrayList<>();

        if (king.getTag().equals("white_king") || king.getTag().equals("black_king")) {
            if (letterIndex + 1 <= 7){
                if (!board.get(letterIndex + 1).get(numberIndex).getTag().equals("empty")){
                    if (blackPieces.contains(board.get(letterIndex + 1).get(numberIndex).getTag().toString()) && king.getTag().equals("white_king")){
                        possibleTakes.add(board.get(letterIndex + 1).get(numberIndex));
                    }
                    else if (whitePieces.contains(board.get(letterIndex + 1).get(numberIndex).getTag().toString()) && king.getTag().equals("black_king")){
                        possibleTakes.add(board.get(letterIndex + 1).get(numberIndex));
                    }
                }
            }
            if (letterIndex + 1 <= 7 && numberIndex + 1 <= 7){
                if (!board.get(letterIndex + 1).get(numberIndex + 1).getTag().equals("empty")){
                    if (blackPieces.contains(board.get(letterIndex + 1).get(numberIndex + 1).getTag().toString()) && king.getTag().equals("white_king")){
                        possibleTakes.add(board.get(letterIndex + 1).get(numberIndex + 1));
                    }
                    else if (whitePieces.contains(board.get(letterIndex + 1).get(numberIndex + 1).getTag().toString()) && king.getTag().equals("black_king")){
                        possibleTakes.add(board.get(letterIndex + 1).get(numberIndex + 1));
                    }
                }

            }
            if (numberIndex + 1 <= 7){
                if (!board.get(letterIndex).get(numberIndex + 1).getTag().equals("empty")){
                    if (blackPieces.contains(board.get(letterIndex).get(numberIndex + 1).getTag().toString()) && king.getTag().equals("white_king")){
                        possibleTakes.add(board.get(letterIndex).get(numberIndex + 1));
                    }
                    else if (whitePieces.contains(board.get(letterIndex).get(numberIndex + 1).getTag().toString()) && king.getTag().equals("black_king")){
                        possibleTakes.add(board.get(letterIndex).get(numberIndex + 1));
                    }
                }
            }
            if (letterIndex - 1 >= 0){
                if (!board.get(letterIndex - 1).get(numberIndex).getTag().equals("empty")){
                    if (blackPieces.contains(board.get(letterIndex - 1).get(numberIndex).getTag().toString()) && king.getTag().equals("white_king")){
                        possibleTakes.add(board.get(letterIndex - 1).get(numberIndex));
                    }
                    else if (whitePieces.contains(board.get(letterIndex - 1).get(numberIndex).getTag().toString()) && king.getTag().equals("black_king")){
                        possibleTakes.add(board.get(letterIndex - 1).get(numberIndex));
                    }
                }
            }
            if (numberIndex - 1 >= 0){
                if (!board.get(letterIndex).get(numberIndex - 1).getTag().equals("empty")){
                    if (blackPieces.contains(board.get(letterIndex).get(numberIndex - 1).getTag().toString()) && king.getTag().equals("white_king")){
                        possibleTakes.add(board.get(letterIndex).get(numberIndex - 1));
                    }
                    else if (whitePieces.contains(board.get(letterIndex).get(numberIndex - 1).getTag().toString()) && king.getTag().equals("black_king")){
                        possibleTakes.add(board.get(letterIndex).get(numberIndex - 1));
                    }
                }

            }
            if (letterIndex - 1 >= 0 && numberIndex - 1 >= 0){
                if (!board.get(letterIndex - 1).get(numberIndex - 1).getTag().equals("empty")){
                    if (blackPieces.contains(board.get(letterIndex - 1).get(numberIndex - 1).getTag().toString()) && king.getTag().equals("white_king")){
                        possibleTakes.add(board.get(letterIndex - 1).get(numberIndex - 1));
                    }
                    else if (whitePieces.contains(board.get(letterIndex - 1).get(numberIndex - 1).getTag().toString()) && king.getTag().equals("black_king")){
                        possibleTakes.add(board.get(letterIndex - 1).get(numberIndex - 1));
                    }
                }

            }
            if (letterIndex + 1 <= 7 && numberIndex - 1 >= 0){
                if (!board.get(letterIndex + 1).get(numberIndex - 1).getTag().equals("empty")){
                    if (blackPieces.contains(board.get(letterIndex + 1).get(numberIndex +-1).getTag().toString()) && king.getTag().equals("white_king")){
                        possibleTakes.add(board.get(letterIndex + 1).get(numberIndex - 1));
                    }
                    else if (whitePieces.contains(board.get(letterIndex + 1).get(numberIndex - 1).getTag().toString()) && king.getTag().equals("black_king")){
                        possibleTakes.add(board.get(letterIndex + 1).get(numberIndex - 1));
                    }
                }

            }
            if (letterIndex - 1 >= 0 && numberIndex + 1 <= 7){
                if (!board.get(letterIndex - 1).get(numberIndex + 1).getTag().equals("empty")){
                    if (blackPieces.contains(board.get(letterIndex - 1).get(numberIndex + 1).getTag().toString()) && king.getTag().equals("white_king")){
                        possibleTakes.add(board.get(letterIndex - 1).get(numberIndex + 1));
                    }
                    else if (whitePieces.contains(board.get(letterIndex - 1).get(numberIndex + 1).getTag().toString()) && king.getTag().equals("black_king")){
                        possibleTakes.add(board.get(letterIndex - 1).get(numberIndex + 1));
                    }
                }
            }
        }
        return possibleTakes;
    }

    public List<ImageButton> getProtectedPieces() {
        List<ImageButton> protectedPieces = new ArrayList<>();

        if (king.getTag().equals("white_king") || king.getTag().equals("black_king")) {
            if (letterIndex + 1 <= 7) {
                if (!board.get(letterIndex + 1).get(numberIndex).getTag().equals("empty")) {
                    if (blackPieces.contains(board.get(letterIndex + 1).get(numberIndex).getTag().toString()) && king.getTag().equals("black_king")) {
                        protectedPieces.add(board.get(letterIndex + 1).get(numberIndex));
                    } else if (whitePieces.contains(board.get(letterIndex + 1).get(numberIndex).getTag().toString()) && king.getTag().equals("white_king")) {
                        protectedPieces.add(board.get(letterIndex + 1).get(numberIndex));
                    }
                }
            }
            if (letterIndex + 1 <= 7 && numberIndex + 1 <= 7) {
                if (!board.get(letterIndex + 1).get(numberIndex + 1).getTag().equals("empty")) {
                    if (blackPieces.contains(board.get(letterIndex + 1).get(numberIndex + 1).getTag().toString()) && king.getTag().equals("black_king")) {
                        protectedPieces.add(board.get(letterIndex + 1).get(numberIndex + 1));
                    } else if (whitePieces.contains(board.get(letterIndex + 1).get(numberIndex + 1).getTag().toString()) && king.getTag().equals("white_king")) {
                        protectedPieces.add(board.get(letterIndex + 1).get(numberIndex + 1));
                    }
                }

            }
            if (numberIndex + 1 <= 7) {
                if (!board.get(letterIndex).get(numberIndex + 1).getTag().equals("empty")) {
                    if (blackPieces.contains(board.get(letterIndex).get(numberIndex + 1).getTag().toString()) && king.getTag().equals("black_king")) {
                        protectedPieces.add(board.get(letterIndex).get(numberIndex + 1));
                    } else if (whitePieces.contains(board.get(letterIndex).get(numberIndex + 1).getTag().toString()) && king.getTag().equals("white_king")) {
                        protectedPieces.add(board.get(letterIndex).get(numberIndex + 1));
                    }
                }
            }
            if (letterIndex - 1 >= 0) {
                if (!board.get(letterIndex - 1).get(numberIndex).getTag().equals("empty"))
                    if (blackPieces.contains(board.get(letterIndex - 1).get(numberIndex).getTag().toString()) && king.getTag().equals("black_king")) {
                        protectedPieces.add(board.get(letterIndex - 1).get(numberIndex));
                    } else if (whitePieces.contains(board.get(letterIndex - 1).get(numberIndex).getTag().toString()) && king.getTag().equals("white_king")) {
                        protectedPieces.add(board.get(letterIndex - 1).get(numberIndex));
                    }
            }

            if (numberIndex - 1 >= 0) {
                if (!board.get(letterIndex).get(numberIndex - 1).getTag().equals("empty")) {
                    if (blackPieces.contains(board.get(letterIndex).get(numberIndex - 1).getTag().toString()) && king.getTag().equals("black_king")) {
                        protectedPieces.add(board.get(letterIndex).get(numberIndex - 1));
                    } else if (whitePieces.contains(board.get(letterIndex).get(numberIndex - 1).getTag().toString()) && king.getTag().equals("white_king")) {
                        protectedPieces.add(board.get(letterIndex).get(numberIndex - 1));
                    }
                }

            }
            if (letterIndex - 1 >= 0 && numberIndex - 1 >= 0) {
                if (!board.get(letterIndex - 1).get(numberIndex - 1).getTag().equals("empty")) {
                    if (blackPieces.contains(board.get(letterIndex - 1).get(numberIndex - 1).getTag().toString()) && king.getTag().equals("black_king")) {
                        protectedPieces.add(board.get(letterIndex - 1).get(numberIndex - 1));
                    } else if (whitePieces.contains(board.get(letterIndex - 1).get(numberIndex - 1).getTag().toString()) && king.getTag().equals("white_king")) {
                        protectedPieces.add(board.get(letterIndex - 1).get(numberIndex - 1));
                    }
                }

            }
            if (letterIndex + 1 <= 7 && numberIndex - 1 >= 0) {
                if (!board.get(letterIndex + 1).get(numberIndex - 1).getTag().equals("empty")) {
                    if (blackPieces.contains(board.get(letterIndex + 1).get(numberIndex + -1).getTag().toString()) && king.getTag().equals("black_king")) {
                        protectedPieces.add(board.get(letterIndex + 1).get(numberIndex - 1));
                    } else if (whitePieces.contains(board.get(letterIndex + 1).get(numberIndex - 1).getTag().toString()) && king.getTag().equals("white_king")) {
                        protectedPieces.add(board.get(letterIndex + 1).get(numberIndex - 1));
                    }
                }

            }
            if (letterIndex - 1 >= 0 && numberIndex + 1 <= 7) {
                if (!board.get(letterIndex - 1).get(numberIndex + 1).getTag().equals("empty")) {
                    if (blackPieces.contains(board.get(letterIndex - 1).get(numberIndex + 1).getTag().toString()) && king.getTag().equals("black_king")) {
                        protectedPieces.add(board.get(letterIndex - 1).get(numberIndex + 1));
                    } else if (whitePieces.contains(board.get(letterIndex - 1).get(numberIndex + 1).getTag().toString()) && king.getTag().equals("white_king")) {
                        protectedPieces.add(board.get(letterIndex - 1).get(numberIndex + 1));
                    }
                }
            }
        }
        return protectedPieces;
    }
}

