package com.example.mychess;

import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class BishopPiece {
    private final List<List<ImageButton>> board;
    private final List<String> blackPieces;
    private final List<String> whitePieces;
    private final ImageButton bishop;
    private final int letterIndex;
    private final int numberIndex;


    public BishopPiece(ImageButton bishop, int letterIndex, int numberIndex) {
        board = ChessBoardFragment.getBoard();
        blackPieces = BoardManager.getBlackPieces();
        whitePieces = BoardManager.getWhitePieces();
        this.bishop = bishop;
        this.letterIndex = letterIndex;
        this.numberIndex = numberIndex;
    }

    public List<ImageButton> getPossibleMoves() {
        List<ImageButton> possibleMoves = new ArrayList<>();
        if (bishop.getTag().equals("black_bishop") || bishop.getTag().equals("white_bishop")){
            int j = numberIndex + 1;
            for (int i = letterIndex + 1; i <= 7; i++){
                if (j <= 7){
                    if (board.get(i).get(j).getTag().equals("empty")){
                        possibleMoves.add(board.get(i).get(j));
                    }
                    else break;
                    j++;
                }
            }
            j = numberIndex - 1;
            for (int i = letterIndex + 1; i <= 7; i++){
                if (j >= 0) {
                    if (board.get(i).get(j).getTag().equals("empty")){
                        possibleMoves.add(board.get(i).get(j));
                    }
                    else break;
                    j--;
                }
            }
            j = numberIndex + 1;
            for (int i = letterIndex - 1; i >= 0; i--){
                if (j <= 7){
                    if (board.get(i).get(j).getTag().equals("empty")){
                        possibleMoves.add(board.get(i).get(j));
                    }
                    else break;
                    j++;
                }
            }
            j = numberIndex - 1;
            for (int i = letterIndex - 1; i >= 0; i--){
                if (j >= 0) {
                    if (board.get(i).get(j).getTag().equals("empty")){
                        possibleMoves.add(board.get(i).get(j));
                    }
                    else break;
                    j--;
                }
            }
        }
        return possibleMoves;
    }

    public List<ImageButton> getPossibleTakes() {
        List<ImageButton> possibleTakes = new ArrayList<>();

        if (bishop.getTag().equals("black_bishop") || bishop.getTag().equals("white_bishop")){
            int j = numberIndex + 1;
            for (int i = letterIndex + 1; i <= 7; i++){
                if (j <= 7){
                    if (bishop.getTag().equals("white_bishop") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                        possibleTakes.add(board.get(i).get(j));
                        break;
                    }
                    else if (bishop.getTag().equals("black_bishop") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                        possibleTakes.add(board.get(i).get(j));
                        break;
                    }
                    else if (bishop.getTag().equals("white_bishop") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                        break;
                    }
                    else if (bishop.getTag().equals("black_bishop") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                        break;
                    }
                    j++;
                }
            }
            j = numberIndex - 1;
            for (int i = letterIndex + 1; i <= 7; i++){
                if (j >= 0) {
                    if (bishop.getTag().equals("white_bishop") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                        possibleTakes.add(board.get(i).get(j));
                        break;
                    }
                    else if (bishop.getTag().equals("black_bishop") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                        possibleTakes.add(board.get(i).get(j));
                        break;
                    }
                    else if (bishop.getTag().equals("white_bishop") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                        break;
                    }
                    else if (bishop.getTag().equals("black_bishop") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                        break;
                    }
                    j--;
                }
            }
            j = numberIndex + 1;
            for (int i = letterIndex - 1; i >= 0; i--){
                if (j <= 7){
                    if (bishop.getTag().equals("white_bishop") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                        possibleTakes.add(board.get(i).get(j));
                        break;
                    }
                    else if (bishop.getTag().equals("black_bishop") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                        possibleTakes.add(board.get(i).get(j));
                        break;
                    }
                    else if (bishop.getTag().equals("white_bishop") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                        break;
                    }
                    else if (bishop.getTag().equals("black_bishop") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                        break;
                    }
                    j++;
                }
            }
            j = numberIndex - 1;
            for (int i = letterIndex - 1; i >= 0; i--){
                if (j >= 0) {
                    if (bishop.getTag().equals("white_bishop") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                        possibleTakes.add(board.get(i).get(j));
                        break;
                    }
                    else if (bishop.getTag().equals("black_bishop") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                        possibleTakes.add(board.get(i).get(j));
                        break;
                    }
                    else if (bishop.getTag().equals("white_bishop") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                        break;
                    }
                    else if (bishop.getTag().equals("black_bishop") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                        break;
                    }
                    j--;
                }
            }
        }
        return possibleTakes;
    }

    public List<ImageButton> getProtectedPieces() {
        List<ImageButton> protectedPieces = new ArrayList<>();
        if (bishop.getTag().equals("black_bishop") || bishop.getTag().equals("white_bishop")){
            int j = numberIndex + 1;
            for (int i = letterIndex + 1; i <= 7; i++){
                if (j <= 7){
                    if (bishop.getTag().equals("white_bishop") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                        break;
                    }
                    else if (bishop.getTag().equals("black_bishop") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                        break;
                    }
                    else if (bishop.getTag().equals("white_bishop") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                        protectedPieces.add(board.get(i).get(j));
                        break;
                    }
                    else if (bishop.getTag().equals("black_bishop") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                        protectedPieces.add(board.get(i).get(j));
                        break;
                    }
                    j++;
                }
            }
            j = numberIndex - 1;
            for (int i = letterIndex + 1; i <= 7; i++){
                if (j >= 0) {
                    if (bishop.getTag().equals("white_bishop") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                        break;
                    }
                    else if (bishop.getTag().equals("black_bishop") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                        break;
                    }
                    else if (bishop.getTag().equals("white_bishop") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                        protectedPieces.add(board.get(i).get(j));
                        break;
                    }
                    else if (bishop.getTag().equals("black_bishop") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                        protectedPieces.add(board.get(i).get(j));
                        break;
                    }
                    j--;
                }
            }
            j = numberIndex + 1;
            for (int i = letterIndex - 1; i >= 0; i--){
                if (j <= 7){
                    if (bishop.getTag().equals("white_bishop") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                        break;
                    }
                    else if (bishop.getTag().equals("black_bishop") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                        break;
                    }
                    else if (bishop.getTag().equals("white_bishop") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                        protectedPieces.add((board.get(i).get(j)));
                        break;
                    }
                    else if (bishop.getTag().equals("black_bishop") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                        protectedPieces.add(board.get(i).get(j));
                        break;
                    }
                    j++;
                }
            }
            j = numberIndex - 1;
            for (int i = letterIndex - 1; i >= 0; i--){
                if (j >= 0) {
                    if (bishop.getTag().equals("white_bishop") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                        break;
                    }
                    else if (bishop.getTag().equals("black_bishop") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                        break;
                    }
                    else if (bishop.getTag().equals("white_bishop") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                        protectedPieces.add(board.get(i).get(j));
                        break;
                    }
                    else if (bishop.getTag().equals("black_bishop") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                        protectedPieces.add(board.get(i).get(j));
                        break;
                    }
                    j--;
                }
            }
        }
        return protectedPieces;
    }
}
