package com.example.mychess;

import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class RookPiece {
    private final List<List<ImageButton>> board;
    private final List<String> blackPieces;
    private final List<String> whitePieces;
    private final ImageButton rook;
    private final int letterIndex;
    private final int numberIndex;

    public RookPiece(ImageButton rook, int letterIndex, int numberIndex) {
        board = ChessBoardFragment.getBoard();
        blackPieces = BoardManager.getBlackPieces();
        whitePieces = BoardManager.getWhitePieces();
        this.rook = rook;
        this.letterIndex = letterIndex;
        this.numberIndex = numberIndex;
    }

    public List<ImageButton> getPossibleMoves() {
        List<ImageButton> possibleMoves = new ArrayList<>();

        if (rook.getTag().equals("white_rook") || rook.getTag().equals("black_rook")) {
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

        }
        return possibleMoves;
    }

    public List<ImageButton> getPossibleTakes() {
        List<ImageButton> possibleTakes = new ArrayList<>();

        if (rook.getTag().equals("white_rook") || rook.getTag().equals("black_rook")) {
            for (int i = letterIndex + 1; i <= 7; i++) {
                if (blackPieces.contains(board.get(i).get(numberIndex).getTag().toString()) && rook.getTag().equals("white_rook")){
                    possibleTakes.add(board.get(i).get(numberIndex));
                    break;
                }
                else if (whitePieces.contains(board.get(i).get(numberIndex).getTag().toString()) && rook.getTag().equals("black_rook")){
                    possibleTakes.add(board.get(i).get(numberIndex));
                    break;
                }
                else if (whitePieces.contains(board.get(i).get(numberIndex).getTag().toString()) && rook.getTag().equals("white_rook")){
                    break;
                }
                else if (blackPieces.contains(board.get(i).get(numberIndex).getTag().toString()) && rook.getTag().equals("black_rook")){
                    break;
                }
            }

            for (int i = letterIndex - 1; i >= 0; i--) {
                if (blackPieces.contains(board.get(i).get(numberIndex).getTag().toString()) && rook.getTag().equals("white_rook")){
                    possibleTakes.add(board.get(i).get(numberIndex));
                    break;
                }
                else if (whitePieces.contains(board.get(i).get(numberIndex).getTag().toString()) && rook.getTag().equals("black_rook")){
                    possibleTakes.add(board.get(i).get(numberIndex));
                    break;
                }
                else if (whitePieces.contains(board.get(i).get(numberIndex).getTag().toString()) && rook.getTag().equals("white_rook")){
                    break;
                }
                else if (blackPieces.contains(board.get(i).get(numberIndex).getTag().toString()) && rook.getTag().equals("black_rook")){
                    break;
                }

            }
            for (int i = numberIndex + 1; i <= 7; i++) {
                if (blackPieces.contains(board.get(letterIndex).get(i).getTag().toString()) && rook.getTag().equals("white_rook")){
                    possibleTakes.add(board.get(letterIndex).get(i));
                    break;
                }
                else if (whitePieces.contains(board.get(letterIndex).get(i).getTag().toString()) && rook.getTag().equals("black_rook")){
                    possibleTakes.add(board.get(letterIndex).get(i));
                    break;
                }
                else if (whitePieces.contains(board.get(letterIndex).get(i).getTag().toString()) && rook.getTag().equals("white_rook")){
                    break;
                }
                else if (blackPieces.contains(board.get(letterIndex).get(i).getTag().toString()) && rook.getTag().equals("black_rook")){
                    break;
                }

            }
            for (int i = numberIndex - 1; i >= 0; i--) {
                if (blackPieces.contains(board.get(letterIndex).get(i).getTag().toString()) && rook.getTag().equals("white_rook")){
                    possibleTakes.add(board.get(letterIndex).get(i));
                    break;
                }
                else if (whitePieces.contains(board.get(letterIndex).get(i).getTag().toString()) && rook.getTag().equals("black_rook")){
                    possibleTakes.add(board.get(letterIndex).get(i));
                    break;
                }
                else if (whitePieces.contains(board.get(letterIndex).get(i).getTag().toString()) && rook.getTag().equals("white_rook")){
                    break;
                }
                else if (blackPieces.contains(board.get(letterIndex).get(i).getTag().toString()) && rook.getTag().equals("black_rook")){
                    break;
                }
            }
        }
        return possibleTakes;
    }

    public List<ImageButton> getProtectedPieces() {
        List<ImageButton> protectedPieces = new ArrayList<>();
        if (rook.getTag().equals("white_rook") || rook.getTag().equals("black_rook")) {
            for (int i = letterIndex + 1; i <= 7; i++) {
                if (blackPieces.contains(board.get(i).get(numberIndex).getTag().toString()) && rook.getTag().equals("white_rook")){
                    break;
                }
                else if (whitePieces.contains(board.get(i).get(numberIndex).getTag().toString()) && rook.getTag().equals("black_rook")){
                    break;
                }
                else if (whitePieces.contains(board.get(i).get(numberIndex).getTag().toString()) && rook.getTag().equals("white_rook")){
                    protectedPieces.add(board.get(i).get(numberIndex));
                    break;
                }
                else if (blackPieces.contains(board.get(i).get(numberIndex).getTag().toString()) && rook.getTag().equals("black_rook")){
                    protectedPieces.add(board.get(i).get(numberIndex));
                    break;
                }
            }

            for (int i = letterIndex - 1; i >= 0; i--) {
                if (blackPieces.contains(board.get(i).get(numberIndex).getTag().toString()) && rook.getTag().equals("white_rook")){
                    break;
                }
                else if (whitePieces.contains(board.get(i).get(numberIndex).getTag().toString()) && rook.getTag().equals("black_rook")){
                    break;
                }
                else if (whitePieces.contains(board.get(i).get(numberIndex).getTag().toString()) && rook.getTag().equals("white_rook")){
                    protectedPieces.add(board.get(i).get(numberIndex));
                    break;
                }
                else if (blackPieces.contains(board.get(i).get(numberIndex).getTag().toString()) && rook.getTag().equals("black_rook")){
                    protectedPieces.add(board.get(i).get(numberIndex));
                    break;
                }

            }
            for (int i = numberIndex + 1; i <= 7; i++) {
                if (blackPieces.contains(board.get(letterIndex).get(i).getTag().toString()) && rook.getTag().equals("white_rook")){
                    break;
                }
                else if (whitePieces.contains(board.get(letterIndex).get(i).getTag().toString()) && rook.getTag().equals("black_rook")){
                    break;
                }
                else if (whitePieces.contains(board.get(letterIndex).get(i).getTag().toString()) && rook.getTag().equals("white_rook")){
                    protectedPieces.add(board.get(letterIndex).get(i));
                    break;
                }
                else if (blackPieces.contains(board.get(letterIndex).get(i).getTag().toString()) && rook.getTag().equals("black_rook")){
                    protectedPieces.add(board.get(letterIndex).get(i));
                    break;
                }

            }
            for (int i = numberIndex - 1; i >= 0; i--) {
                if (blackPieces.contains(board.get(letterIndex).get(i).getTag().toString()) && rook.getTag().equals("white_rook")){
                    break;
                }
                else if (whitePieces.contains(board.get(letterIndex).get(i).getTag().toString()) && rook.getTag().equals("black_rook")){
                    break;
                }
                else if (whitePieces.contains(board.get(letterIndex).get(i).getTag().toString()) && rook.getTag().equals("white_rook")){
                    protectedPieces.add(board.get(letterIndex).get(i));
                    break;
                }
                else if (blackPieces.contains(board.get(letterIndex).get(i).getTag().toString()) && rook.getTag().equals("black_rook")){
                    protectedPieces.add(board.get(letterIndex).get(i));
                    break;
                }
            }
        }
        return protectedPieces;
    }
}
