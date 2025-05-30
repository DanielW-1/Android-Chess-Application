package com.example.mychess;

import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class QueenPiece {
    private final List<List<ImageButton>> board;
    private final List<String> blackPieces;
    private final List<String> whitePieces;
    private final ImageButton queen;
    private final int letterIndex;
    private final int numberIndex;

    public QueenPiece(ImageButton queen, int letterIndex, int numberIndex) {
        board = ChessBoardFragment.getBoard();
        blackPieces = BoardManager.getBlackPieces();
        whitePieces = BoardManager.getWhitePieces();
        this.queen = queen;
        this.letterIndex = letterIndex;
        this.numberIndex = numberIndex;
    }

    public List<ImageButton> getPossibleMoves() {
        List<ImageButton> possibleMoves = new ArrayList<>();
        if (queen.getTag().equals("white_queen") || queen.getTag().equals("black_queen")) {

            for (int i = letterIndex + 1; i <= 7; i++) {
                if (board.get(i).get(numberIndex).getTag().equals("empty")){
                    possibleMoves.add(board.get(i).get(numberIndex));
                }
                else break;
            }
            for (int i = letterIndex - 1; i >= 0; i--) {
                if (board.get(i).get(numberIndex).getTag().equals("empty")){
                    possibleMoves.add(board.get(i).get(numberIndex));
                }
                else break;

            }
            for (int i = numberIndex + 1; i <= 7; i++) {
                if (board.get(letterIndex).get(i).getTag().equals("empty")){
                    possibleMoves.add(board.get(letterIndex).get(i));
                }
                else break;

            }
            for (int i = numberIndex - 1; i >= 0; i--) {
                if (board.get(letterIndex).get(i).getTag().equals("empty")){
                    possibleMoves.add(board.get(letterIndex).get(i));
                }
                else break;
            }

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

        for (int i = letterIndex + 1; i <= 7; i++) {
            if (blackPieces.contains(board.get(i).get(numberIndex).getTag().toString()) && queen.getTag().equals("white_queen")){
                possibleTakes.add(board.get(i).get(numberIndex));
                break;
            }
            else if (whitePieces.contains(board.get(i).get(numberIndex).getTag().toString()) && queen.getTag().equals("black_queen")){
                possibleTakes.add(board.get(i).get(numberIndex));
                break;
            }
            else if (whitePieces.contains(board.get(i).get(numberIndex).getTag().toString()) && queen.getTag().equals("white_queen")){
                break;
            }
            else if (blackPieces.contains(board.get(i).get(numberIndex).getTag().toString()) && queen.getTag().equals("black_queen")){
                break;
            }
        }

        for (int i = letterIndex - 1; i >= 0; i--) {
            if (blackPieces.contains(board.get(i).get(numberIndex).getTag().toString()) && queen.getTag().equals("white_queen")){
                possibleTakes.add(board.get(i).get(numberIndex));
                break;
            }
            else if (whitePieces.contains(board.get(i).get(numberIndex).getTag().toString()) && queen.getTag().equals("black_queen")){
                possibleTakes.add(board.get(i).get(numberIndex));
                break;
            }
            else if (whitePieces.contains(board.get(i).get(numberIndex).getTag().toString()) && queen.getTag().equals("white_queen")){
                break;
            }
            else if (blackPieces.contains(board.get(i).get(numberIndex).getTag().toString()) && queen.getTag().equals("black_queen")){
                break;
            }

        }
        for (int i = numberIndex + 1; i <= 7; i++) {
            if (blackPieces.contains(board.get(letterIndex).get(i).getTag().toString()) && queen.getTag().equals("white_queen")){
                possibleTakes.add(board.get(letterIndex).get(i));
                break;
            }
            else if (whitePieces.contains(board.get(letterIndex).get(i).getTag().toString()) && queen.getTag().equals("black_queen")){
                possibleTakes.add(board.get(letterIndex).get(i));
                break;
            }
            else if (whitePieces.contains(board.get(letterIndex).get(i).getTag().toString()) && queen.getTag().equals("white_queen")){
                break;
            }
            else if (blackPieces.contains(board.get(letterIndex).get(i).getTag().toString()) && queen.getTag().equals("black_queen")){
                break;
            }

        }
        for (int i = numberIndex - 1; i >= 0; i--) {
            if (blackPieces.contains(board.get(letterIndex).get(i).getTag().toString()) && queen.getTag().equals("white_queen")){
                possibleTakes.add(board.get(letterIndex).get(i));
                break;
            }
            else if (whitePieces.contains(board.get(letterIndex).get(i).getTag().toString()) && queen.getTag().equals("black_queen")){
                possibleTakes.add(board.get(letterIndex).get(i));
                break;
            }
            else if (whitePieces.contains(board.get(letterIndex).get(i).getTag().toString()) && queen.getTag().equals("white_queen")){
                break;
            }
            else if (blackPieces.contains(board.get(letterIndex).get(i).getTag().toString()) && queen.getTag().equals("black_queen")){
                break;
            }
        }

        int j = numberIndex + 1;
        for (int i = letterIndex + 1; i <= 7; i++){
            if (j <= 7){
                if (queen.getTag().equals("white_queen") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                    possibleTakes.add(board.get(i).get(j));
                    break;
                }
                else if (queen.getTag().equals("black_queen") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                    possibleTakes.add(board.get(i).get(j));
                    break;
                }
                else if (queen.getTag().equals("white_queen") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                    break;
                }
                else if (queen.getTag().equals("black_queen") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                    break;
                }
                j++;
            }
        }
        j = numberIndex - 1;
        for (int i = letterIndex + 1; i <= 7; i++){
            if (j >= 0) {
                if (queen.getTag().equals("white_queen") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                    possibleTakes.add(board.get(i).get(j));
                    break;
                }
                else if (queen.getTag().equals("black_queen") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                    possibleTakes.add(board.get(i).get(j));
                    break;
                }
                else if (queen.getTag().equals("white_queen") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                    break;
                }
                else if (queen.getTag().equals("black_queen") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                    break;
                }
                j--;
            }
        }
        j = numberIndex + 1;
        for (int i = letterIndex - 1; i >= 0; i--){
            if (j <= 7){
                if (queen.getTag().equals("white_queen") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                    possibleTakes.add(board.get(i).get(j));
                    break;
                }
                else if (queen.getTag().equals("black_queen") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                    possibleTakes.add(board.get(i).get(j));
                    break;
                }
                else if (queen.getTag().equals("white_queen") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                    break;
                }
                else if (queen.getTag().equals("black_queen") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                    break;
                }
                j++;
            }
        }
        j = numberIndex - 1;
        for (int i = letterIndex - 1; i >= 0; i--){
            if (j >= 0) {
                if (queen.getTag().equals("white_queen") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                    possibleTakes.add(board.get(i).get(j));
                    break;
                }
                else if (queen.getTag().equals("black_queen") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                    possibleTakes.add(board.get(i).get(j));
                    break;
                }
                else if (queen.getTag().equals("white_queen") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                    break;
                }
                else if (queen.getTag().equals("black_queen") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                    break;
                }
                j--;
            }
        }
        return possibleTakes;
    }

    public List<ImageButton> getProtectedPieces() {
        List<ImageButton> protectedPieces = new ArrayList<>();

        for (int i = letterIndex + 1; i <= 7; i++) {
            if (blackPieces.contains(board.get(i).get(numberIndex).getTag().toString()) && queen.getTag().equals("white_queen")){
                break;
            }
            else if (whitePieces.contains(board.get(i).get(numberIndex).getTag().toString()) && queen.getTag().equals("black_queen")){
                break;
            }
            else if (whitePieces.contains(board.get(i).get(numberIndex).getTag().toString()) && queen.getTag().equals("white_queen")){
                protectedPieces.add(board.get(i).get(numberIndex));
                break;
            }
            else if (blackPieces.contains(board.get(i).get(numberIndex).getTag().toString()) && queen.getTag().equals("black_queen")){
                protectedPieces.add(board.get(i).get(numberIndex));
                break;
            }
        }

        for (int i = letterIndex - 1; i >= 0; i--) {
            if (blackPieces.contains(board.get(i).get(numberIndex).getTag().toString()) && queen.getTag().equals("white_queen")){
                break;
            }
            else if (whitePieces.contains(board.get(i).get(numberIndex).getTag().toString()) && queen.getTag().equals("black_queen")){
                break;
            }
            else if (whitePieces.contains(board.get(i).get(numberIndex).getTag().toString()) && queen.getTag().equals("white_queen")){
                protectedPieces.add(board.get(i).get(numberIndex));
                break;
            }
            else if (blackPieces.contains(board.get(i).get(numberIndex).getTag().toString()) && queen.getTag().equals("black_queen")){
                protectedPieces.add(board.get(i).get(numberIndex));
                break;
            }

        }
        for (int i = numberIndex + 1; i <= 7; i++) {
            if (blackPieces.contains(board.get(letterIndex).get(i).getTag().toString()) && queen.getTag().equals("white_queen")){
                break;
            }
            else if (whitePieces.contains(board.get(letterIndex).get(i).getTag().toString()) && queen.getTag().equals("black_queen")){
                break;
            }
            else if (whitePieces.contains(board.get(letterIndex).get(i).getTag().toString()) && queen.getTag().equals("white_queen")){
                protectedPieces.add(board.get(letterIndex).get(i));
                break;
            }
            else if (blackPieces.contains(board.get(letterIndex).get(i).getTag().toString()) && queen.getTag().equals("black_queen")){
                protectedPieces.add(board.get(letterIndex).get(i));
                break;
            }

        }
        for (int i = numberIndex - 1; i >= 0; i--) {
            if (blackPieces.contains(board.get(letterIndex).get(i).getTag().toString()) && queen.getTag().equals("white_queen")){
                break;
            }
            else if (whitePieces.contains(board.get(letterIndex).get(i).getTag().toString()) && queen.getTag().equals("black_queen")){
                break;
            }
            else if (whitePieces.contains(board.get(letterIndex).get(i).getTag().toString()) && queen.getTag().equals("white_queen")){
                protectedPieces.add(board.get(letterIndex).get(i));
                break;
            }
            else if (blackPieces.contains(board.get(letterIndex).get(i).getTag().toString()) && queen.getTag().equals("black_queen")){
                protectedPieces.add(board.get(letterIndex).get(i));
                break;
            }
        }

        int j = numberIndex + 1;
        for (int i = letterIndex + 1; i <= 7; i++){
            if (j <= 7){
                if (queen.getTag().equals("white_queen") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                    break;
                }
                else if (queen.getTag().equals("black_queen") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                    break;
                }
                else if (queen.getTag().equals("white_queen") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                    protectedPieces.add(board.get(i).get(j));
                    break;
                }
                else if (queen.getTag().equals("black_queen") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                    protectedPieces.add(board.get(i).get(j));
                    break;
                }
                j++;
            }
        }
        j = numberIndex - 1;
        for (int i = letterIndex + 1; i <= 7; i++){
            if (j >= 0) {
                if (queen.getTag().equals("white_queen") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                    break;
                }
                else if (queen.getTag().equals("black_queen") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                    break;
                }
                else if (queen.getTag().equals("white_queen") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                    protectedPieces.add(board.get(i).get(j));
                    break;
                }
                else if (queen.getTag().equals("black_queen") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                    protectedPieces.add(board.get(i).get(j));
                    break;
                }
                j--;
            }
        }
        j = numberIndex + 1;
        for (int i = letterIndex - 1; i >= 0; i--){
            if (j <= 7){
                if (queen.getTag().equals("white_queen") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                    break;
                }
                else if (queen.getTag().equals("black_queen") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                    break;
                }
                else if (queen.getTag().equals("white_queen") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                    protectedPieces.add(board.get(i).get(j));
                    break;
                }
                else if (queen.getTag().equals("black_queen") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                    protectedPieces.add(board.get(i).get(j));
                    break;
                }
                j++;
            }
        }
        j = numberIndex - 1;
        for (int i = letterIndex - 1; i >= 0; i--){
            if (j >= 0) {
                if (queen.getTag().equals("white_queen") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                    break;
                }
                else if (queen.getTag().equals("black_queen") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                    break;
                }
                else if (queen.getTag().equals("white_queen") && whitePieces.contains(board.get(i).get(j).getTag().toString())){
                    protectedPieces.add(board.get(i).get(j));
                    break;
                }
                else if (queen.getTag().equals("black_queen") && blackPieces.contains(board.get(i).get(j).getTag().toString())){
                    protectedPieces.add(board.get(i).get(j));
                    break;
                }
                j--;
            }
        }
        return protectedPieces;
    }
}
