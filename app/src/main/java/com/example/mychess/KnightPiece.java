package com.example.mychess;

import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class KnightPiece {
    private final List<List<ImageButton>> board;
    private final List<ImageButton> possibleMoves;
    private final List<String> blackPieces;
    private final List<String> whitePieces;
    private final ImageButton knight;
    private final int letterIndex;
    private final int numberIndex;

    public KnightPiece(ImageButton knight, int letterIndex, int numberIndex) {
        board = ChessBoardFragment.getBoard();
        blackPieces = BoardManager.getBlackPieces();
        whitePieces = BoardManager.getWhitePieces();
        possibleMoves = new ArrayList<>();
        this.knight = knight;
        this.letterIndex = letterIndex;
        this.numberIndex = numberIndex;
    }

    public List<ImageButton> getPossibleMoves(){

        if (knight.getTag().equals("white_knight") || knight.getTag().equals("black_knight")){
            if (letterIndex - 2 >= 0 && numberIndex + 1 <= 7){
                if (board.get(letterIndex - 2).get(numberIndex + 1).getTag().equals("empty")){
                    possibleMoves.add(board.get(letterIndex - 2).get(numberIndex + 1));
                }
            }
            if (letterIndex - 2 >= 0 && numberIndex - 1 >= 0){
                if (board.get(letterIndex - 2).get(numberIndex - 1).getTag().equals("empty")){
                    possibleMoves.add(board.get(letterIndex - 2).get(numberIndex - 1));
                }
            }
            if (letterIndex + 2 <= 7 && numberIndex + 1 <= 7){
                if (board.get(letterIndex + 2).get(numberIndex + 1).getTag().equals("empty")){
                    possibleMoves.add(board.get(letterIndex + 2).get(numberIndex + 1));
                }
            }
            if (letterIndex + 2 <= 7 && numberIndex - 1 >= 0){
                if (board.get(letterIndex + 2).get(numberIndex - 1).getTag().equals("empty")){
                    possibleMoves.add(board.get(letterIndex + 2).get(numberIndex - 1));
                }
            }
            if (letterIndex + 1 <= 7 && numberIndex - 2 >= 0){
                if (board.get(letterIndex +1).get(numberIndex - 2).getTag().equals("empty")){
                    possibleMoves.add(board.get(letterIndex + 1).get(numberIndex - 2));
                }
            }
            if (letterIndex - 1 >= 0 && numberIndex - 2 >= 0){
                if (board.get(letterIndex - 1).get(numberIndex - 2).getTag().equals("empty")){
                    possibleMoves.add(board.get(letterIndex - 1).get(numberIndex - 2));
                }
            }
            if (letterIndex + 1 <= 7 && numberIndex + 2 <= 7){
                if (board.get(letterIndex + 1).get(numberIndex + 2).getTag().equals("empty")){
                    possibleMoves.add(board.get(letterIndex + 1).get(numberIndex + 2));
                }
            }
            if (letterIndex - 1 >= 0 && numberIndex + 2 <= 7){
                if (board.get(letterIndex - 1).get(numberIndex + 2).getTag().equals("empty")){
                    possibleMoves.add(board.get(letterIndex - 1).get(numberIndex + 2));
                }
            }
        }
        return possibleMoves;
    }

    public List<ImageButton> getPossibleTakes(){
        List<ImageButton> possibleTakes = new ArrayList<>();
        if (knight.getTag().equals("white_knight") || knight.getTag().equals("black_knight")){
            if (letterIndex - 2 >= 0 && numberIndex + 1 <= 7){
                if (whitePieces.contains(board.get(letterIndex - 2).get(numberIndex + 1).getTag().toString())
                        && knight.getTag().equals("black_knight")){
                    possibleTakes.add(board.get(letterIndex - 2).get(numberIndex + 1));
                }
                else if (blackPieces.contains(board.get(letterIndex - 2).get(numberIndex + 1).getTag().toString())
                        && knight.getTag().equals("white_knight")){
                    possibleTakes.add(board.get(letterIndex - 2).get(numberIndex + 1));
                }
            }
            if (letterIndex - 2 >= 0 && numberIndex - 1 >= 0){
                if (whitePieces.contains(board.get(letterIndex - 2).get(numberIndex - 1).getTag().toString())
                        && knight.getTag().equals("black_knight")){
                    possibleTakes.add(board.get(letterIndex - 2).get(numberIndex - 1));
                }
                else if (blackPieces.contains(board.get(letterIndex - 2).get(numberIndex - 1).getTag().toString())
                        && knight.getTag().equals("white_knight")){
                    possibleTakes.add(board.get(letterIndex - 2).get(numberIndex - 1));
                }
            }
            if (letterIndex + 2 <= 7 && numberIndex + 1 <= 7){
                if (whitePieces.contains(board.get(letterIndex + 2).get(numberIndex + 1).getTag().toString())
                        && knight.getTag().equals("black_knight")){
                    possibleTakes.add(board.get(letterIndex + 2).get(numberIndex + 1));
                }
                else if (blackPieces.contains(board.get(letterIndex + 2).get(numberIndex + 1).getTag().toString())
                        && knight.getTag().equals("white_knight")){
                    possibleTakes.add(board.get(letterIndex + 2).get(numberIndex + 1));
                }
            }
            if (letterIndex + 2 <= 7 && numberIndex - 1 >= 0){
                if (whitePieces.contains(board.get(letterIndex + 2).get(numberIndex - 1).getTag().toString())
                        && knight.getTag().equals("black_knight")){
                    possibleTakes.add(board.get(letterIndex + 2).get(numberIndex - 1));
                }
                else if (blackPieces.contains(board.get(letterIndex + 2).get(numberIndex - 1).getTag().toString())
                        && knight.getTag().equals("white_knight")){
                    possibleTakes.add(board.get(letterIndex + 2).get(numberIndex - 1));
                }
            }
            if (letterIndex + 1 <= 7 && numberIndex - 2 >= 0){
                if (whitePieces.contains(board.get(letterIndex + 1).get(numberIndex - 2).getTag().toString())
                        && knight.getTag().equals("black_knight")){
                    possibleTakes.add(board.get(letterIndex + 1).get(numberIndex - 2));
                }
                else if (blackPieces.contains(board.get(letterIndex + 1).get(numberIndex - 2).getTag().toString())
                        && knight.getTag().equals("white_knight")){
                    possibleTakes.add(board.get(letterIndex + 1).get(numberIndex - 2));
                }
            }
            if (letterIndex - 1 >= 0 && numberIndex - 2 >= 0){
                if (whitePieces.contains(board.get(letterIndex - 1).get(numberIndex - 2).getTag().toString())
                        && knight.getTag().equals("black_knight")){
                    possibleTakes.add(board.get(letterIndex - 1).get(numberIndex - 2));
                }
                else if (blackPieces.contains(board.get(letterIndex - 1).get(numberIndex - 2).getTag().toString())
                        && knight.getTag().equals("white_knight")){
                    possibleTakes.add(board.get(letterIndex - 1).get(numberIndex - 2));
                }
            }
            if (letterIndex + 1 <= 7 && numberIndex + 2 <= 7){
                if (whitePieces.contains(board.get(letterIndex + 1).get(numberIndex + 2).getTag().toString())
                        && knight.getTag().equals("black_knight")){
                    possibleTakes.add(board.get(letterIndex + 1).get(numberIndex + 2));
                }
                else if (blackPieces.contains(board.get(letterIndex + 1).get(numberIndex + 2).getTag().toString())
                        && knight.getTag().equals("white_knight")){
                    possibleTakes.add(board.get(letterIndex + 1).get(numberIndex + 2));
                }
            }
            if (letterIndex - 1 >= 0 && numberIndex + 2 <= 7){
                if (whitePieces.contains(board.get(letterIndex - 1).get(numberIndex + 2).getTag().toString())
                        && knight.getTag().equals("black_knight")){
                    possibleTakes.add(board.get(letterIndex - 1).get(numberIndex + 2));
                }
                else if (blackPieces.contains(board.get(letterIndex - 1).get(numberIndex + 2).getTag().toString())
                        && knight.getTag().equals("white_knight")){
                    possibleTakes.add(board.get(letterIndex - 1).get(numberIndex + 2));
                }
            }
        }

        return possibleTakes;
    }

    public List<ImageButton> getProtectedPieces() {
        List<ImageButton> protectedPieces = new ArrayList<>();
        if (knight.getTag().equals("white_knight") || knight.getTag().equals("black_knight")){
            if (letterIndex - 2 >= 0 && numberIndex + 1 <= 7){
                if (whitePieces.contains(board.get(letterIndex - 2).get(numberIndex + 1).getTag().toString())
                        && knight.getTag().equals("white_knight")){
                    protectedPieces.add(board.get(letterIndex - 2).get(numberIndex + 1));
                }
                else if (blackPieces.contains(board.get(letterIndex - 2).get(numberIndex + 1).getTag().toString())
                        && knight.getTag().equals("black_knight")){
                    protectedPieces.add(board.get(letterIndex - 2).get(numberIndex + 1));
                }
            }
            if (letterIndex - 2 >= 0 && numberIndex - 1 >= 0){
                if (whitePieces.contains(board.get(letterIndex - 2).get(numberIndex - 1).getTag().toString())
                        && knight.getTag().equals("white_knight")){
                    protectedPieces.add(board.get(letterIndex - 2).get(numberIndex - 1));
                }
                else if (blackPieces.contains(board.get(letterIndex - 2).get(numberIndex - 1).getTag().toString())
                        && knight.getTag().equals("black_knight")){
                    protectedPieces.add(board.get(letterIndex - 2).get(numberIndex - 1));
                }
            }
            if (letterIndex + 2 <= 7 && numberIndex + 1 <= 7){
                if (whitePieces.contains(board.get(letterIndex + 2).get(numberIndex + 1).getTag().toString())
                        && knight.getTag().equals("white_knight")){
                    protectedPieces.add(board.get(letterIndex + 2).get(numberIndex + 1));
                }
                else if (blackPieces.contains(board.get(letterIndex + 2).get(numberIndex + 1).getTag().toString())
                        && knight.getTag().equals("black_knight")){
                    protectedPieces.add(board.get(letterIndex + 2).get(numberIndex + 1));
                }
            }
            if (letterIndex + 2 <= 7 && numberIndex - 1 >= 0){
                if (whitePieces.contains(board.get(letterIndex + 2).get(numberIndex - 1).getTag().toString())
                        && knight.getTag().equals("white_knight")){
                    protectedPieces.add(board.get(letterIndex + 2).get(numberIndex - 1));
                }
                else if (blackPieces.contains(board.get(letterIndex + 2).get(numberIndex - 1).getTag().toString())
                        && knight.getTag().equals("black_knight")){
                    protectedPieces.add(board.get(letterIndex + 2).get(numberIndex - 1));
                }
            }
            if (letterIndex + 1 <= 7 && numberIndex - 2 >= 0){
                if (whitePieces.contains(board.get(letterIndex + 1).get(numberIndex - 2).getTag().toString())
                        && knight.getTag().equals("white_knight")){
                    protectedPieces.add(board.get(letterIndex + 1).get(numberIndex - 2));
                }
                else if (blackPieces.contains(board.get(letterIndex + 1).get(numberIndex - 2).getTag().toString())
                        && knight.getTag().equals("black_knight")){
                    protectedPieces.add(board.get(letterIndex + 1).get(numberIndex - 2));
                }
            }
            if (letterIndex - 1 >= 0 && numberIndex - 2 >= 0){
                if (whitePieces.contains(board.get(letterIndex - 1).get(numberIndex - 2).getTag().toString())
                        && knight.getTag().equals("white_knight")){
                    protectedPieces.add(board.get(letterIndex - 1).get(numberIndex - 2));
                }
                else if (blackPieces.contains(board.get(letterIndex - 1).get(numberIndex - 2).getTag().toString())
                        && knight.getTag().equals("black_knight")){
                    protectedPieces.add(board.get(letterIndex - 1).get(numberIndex - 2));
                }
            }
            if (letterIndex + 1 <= 7 && numberIndex + 2 <= 7){
                if (whitePieces.contains(board.get(letterIndex + 1).get(numberIndex + 2).getTag().toString())
                        && knight.getTag().equals("white_knight")){
                    protectedPieces.add(board.get(letterIndex + 1).get(numberIndex + 2));
                }
                else if (blackPieces.contains(board.get(letterIndex + 1).get(numberIndex + 2).getTag().toString())
                        && knight.getTag().equals("black_knight")){
                    protectedPieces.add(board.get(letterIndex + 1).get(numberIndex + 2));
                }
            }
            if (letterIndex - 1 >= 0 && numberIndex + 2 <= 7){
                if (whitePieces.contains(board.get(letterIndex - 1).get(numberIndex + 2).getTag().toString())
                        && knight.getTag().equals("white_knight")){
                    protectedPieces.add(board.get(letterIndex - 1).get(numberIndex + 2));
                }
                else if (blackPieces.contains(board.get(letterIndex - 1).get(numberIndex + 2).getTag().toString())
                        && knight.getTag().equals("black_knight")){
                    protectedPieces.add(board.get(letterIndex - 1).get(numberIndex + 2));
                }
            }
        }
        return protectedPieces;
    }
}
