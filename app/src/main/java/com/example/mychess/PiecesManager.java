package com.example.mychess;

import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PiecesManager {

    private List<String> whitePieces;
    private List<String> blackPieces;
    private final List<List<ImageButton>> board;
    private final char [] letterConversion = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

    public PiecesManager(){
        this.whitePieces = BoardManager.getWhitePieces();
        this.blackPieces = BoardManager.getBlackPieces();
        this.board = ChessBoardFragment.getBoard();

    }

    public List<ImageButton> getProtectedPieces(ImageButton button, int letterIndex, int numberIndex) {
        if (button.getTag().equals("white_rook") || button.getTag().equals("black_rook")) {
            RookPiece rook = new RookPiece(button, letterIndex, numberIndex);
            return rook.getProtectedPieces();
        }
        else if (button.getTag().equals("black_bishop") || button.getTag().equals("white_bishop")) {
            BishopPiece bishop = new BishopPiece(button, letterIndex, numberIndex);
            return bishop.getProtectedPieces();
        }
        else if (button.getTag().equals("white_knight") || button.getTag().equals("black_knight")) {
            KnightPiece knight = new KnightPiece(button, letterIndex, numberIndex);
            return knight.getProtectedPieces();
        }
        else if (button.getTag().equals("black_king") || button.getTag().equals("white_king")) {
            KingPiece kingPiece = new KingPiece(button, letterIndex, numberIndex);
            return kingPiece.getProtectedPieces();
        }
        else if (button.getTag().equals("white_queen") || button.getTag().equals("black_queen")) {
            QueenPiece queen = new QueenPiece(button, letterIndex, numberIndex);
            return queen.getProtectedPieces();
        }
        else if (button.getTag().equals("black_pawn") || button.getTag().equals("white_pawn")) {
            PawnPiece pawn = new PawnPiece(button, letterIndex, numberIndex);
            return pawn.getProtectedPieces();
        }
        else return null;
    }

    public List<ImageButton> getFilteredPossibleMoves(ImageButton button, int letterIndex, int numberIndex) {
        List<ImageButton> filteredPossibleMoves;
        if (button.getTag().equals("white_rook") || button.getTag().equals("black_rook")) {
            RookPiece rook = new RookPiece(button, letterIndex, numberIndex);
            filteredPossibleMoves = new ArrayList<>(filterPossibleMoves(button.getTag().toString(), rook.getPossibleMoves(), letterIndex, numberIndex));
            return filteredPossibleMoves;
        }
        else if (button.getTag().equals("black_bishop") || button.getTag().equals("white_bishop")) {
            BishopPiece bishop = new BishopPiece(button, letterIndex, numberIndex);
            filteredPossibleMoves = new ArrayList<>(filterPossibleMoves(button.getTag().toString(), bishop.getPossibleMoves(), letterIndex, numberIndex));
            return filteredPossibleMoves;
        }
        else if (button.getTag().equals("white_knight") || button.getTag().equals("black_knight")) {
            KnightPiece knight = new KnightPiece(button, letterIndex, numberIndex);
            filteredPossibleMoves = new ArrayList<>(filterPossibleMoves(button.getTag().toString(), knight.getPossibleMoves(), letterIndex, numberIndex));
            return filteredPossibleMoves;
        }
        else if (button.getTag().equals("black_king") || button.getTag().equals("white_king")) {
            KingPiece king = new KingPiece(button, letterIndex, numberIndex);
            filteredPossibleMoves = new ArrayList<>(filterPossibleMoves(button.getTag().toString(), king.getPossibleMoves(), letterIndex, numberIndex));
            return filteredPossibleMoves;
        }
        else if (button.getTag().equals("white_queen") || button.getTag().equals("black_queen")) {
            QueenPiece queen = new QueenPiece(button, letterIndex, numberIndex);
            filteredPossibleMoves = new ArrayList<>(filterPossibleMoves(button.getTag().toString(), queen.getPossibleMoves(), letterIndex, numberIndex));
            return filteredPossibleMoves;
        }
        else if (button.getTag().equals("black_pawn") || button.getTag().equals("white_pawn")) {
            PawnPiece pawn = new PawnPiece(button, letterIndex, numberIndex);
            filteredPossibleMoves = new ArrayList<>(filterPossibleMoves(button.getTag().toString(), pawn.getPossibleMoves(), letterIndex, numberIndex));
            return filteredPossibleMoves;
        }
        else return null;
    }
    public List<ImageButton> getFilteredPossibleTakes(ImageButton button, int letterIndex, int numberIndex) {
        List<ImageButton> filteredPossibleTakes;
        if (button.getTag().equals("white_rook") || button.getTag().equals("black_rook")) {
            RookPiece rook = new RookPiece(button, letterIndex, numberIndex);
            filteredPossibleTakes = new ArrayList<>(filterPossibleTakes(button.getTag().toString(), rook.getPossibleTakes(), letterIndex, numberIndex));
            return filteredPossibleTakes;
        }
        else if (button.getTag().equals("black_bishop") || button.getTag().equals("white_bishop")) {
            BishopPiece bishop = new BishopPiece(button, letterIndex, numberIndex);
            filteredPossibleTakes = new ArrayList<>(filterPossibleTakes(button.getTag().toString(), bishop.getPossibleTakes(), letterIndex, numberIndex));
            return filteredPossibleTakes;
        }
        else if (button.getTag().equals("white_knight") || button.getTag().equals("black_knight")) {
            KnightPiece knight = new KnightPiece(button, letterIndex, numberIndex);
            filteredPossibleTakes = new ArrayList<>(filterPossibleTakes(button.getTag().toString(), knight.getPossibleTakes(), letterIndex, numberIndex));
            return filteredPossibleTakes;
        }
        else if (button.getTag().equals("black_king") || button.getTag().equals("white_king")) {
            KingPiece king = new KingPiece(button, letterIndex, numberIndex);
            filteredPossibleTakes = new ArrayList<>(filterPossibleTakes(button.getTag().toString(), king.getPossibleTakes(), letterIndex, numberIndex));
            return filteredPossibleTakes;
        }
        else if (button.getTag().equals("white_queen") || button.getTag().equals("black_queen")) {
            QueenPiece queen = new QueenPiece(button, letterIndex, numberIndex);
            filteredPossibleTakes = new ArrayList<>(filterPossibleTakes(button.getTag().toString(), queen.getPossibleTakes(), letterIndex, numberIndex));
            return filteredPossibleTakes;
        }
        else if (button.getTag().equals("black_pawn") || button.getTag().equals("white_pawn")) {
            PawnPiece pawn = new PawnPiece(button, letterIndex, numberIndex);
            filteredPossibleTakes = new ArrayList<>(filterPossibleTakes(button.getTag().toString(), pawn.getPossibleTakes(), letterIndex, numberIndex));
            return filteredPossibleTakes;
        }
        else return null;
    }
    public List<ImageButton> getPawnThreatenedSquares(String player){
        List<ImageButton> threatenedSquares = new ArrayList<>();
        if (board != null){
            for (List<ImageButton> column : board){
                for (ImageButton but : column){
                    if (player.equals("white")){
                        if (but.getTag().toString().equals("black_pawn")){
                            PawnPiece pawn = new PawnPiece(but, BoardManager.getLetterIndex(but), BoardManager.getNumberIndex(but));
                            List<ImageButton> pawnThreatenedSquares = pawn.getThreatenedEmptySquares();
                            for (ImageButton square : pawnThreatenedSquares){
                                if (!threatenedSquares.contains(square)){
                                    threatenedSquares.add(square);
                                }
                            }
                        }
                    }
                    if (player.equals("black")){
                        if (but.getTag().toString().equals("white_pawn")){
                            PawnPiece pawn = new PawnPiece(but, BoardManager.getLetterIndex(but), BoardManager.getNumberIndex(but));
                            List<ImageButton> pawnThreatenedSquares = pawn.getThreatenedEmptySquares();
                            for (ImageButton square : pawnThreatenedSquares){
                                if (!threatenedSquares.contains(square)){
                                    threatenedSquares.add(square);
                                }
                            }
                        }
                    }
                }
            }
        }
        return threatenedSquares;
    }

    public List<ImageButton> getAllPossibleTakes(String player) {
        List<ImageButton> possibleTakes = new ArrayList<>();
        if (player.equals("black")){
            for (List<ImageButton> column : board){
                for (ImageButton button : column){
                    if (blackPieces.contains(button.getTag().toString())){
                        List<ImageButton> piecePossibleTakes = new ArrayList<>(getPossibleTakes(button, BoardManager.getLetterIndex(button), BoardManager.getNumberIndex(button)));
                        piecePossibleTakes.removeIf(possibleTakes::contains);
                        possibleTakes.addAll(piecePossibleTakes);
                    }
                }
            }
        }
        else if (player.equals("white")){
            for (List<ImageButton> column : board){
                for (ImageButton button : column){
                    if (whitePieces.contains(button.getTag().toString())){
                        List<ImageButton> piecePossibleTakes = new ArrayList<>(getPossibleTakes(button, BoardManager.getLetterIndex(button), BoardManager.getNumberIndex(button)));
                        piecePossibleTakes.removeIf(possibleTakes::contains);
                        possibleTakes.addAll(piecePossibleTakes);
                    }
                }
            }
        }
        return possibleTakes;
    }

    private List<ImageButton> getPossibleTakes(ImageButton button, int letterIndex, int numberIndex) {
        if (button.getTag().equals("white_rook") || button.getTag().equals("black_rook")) {
            RookPiece rook = new RookPiece(button, letterIndex, numberIndex);
            return rook.getPossibleTakes();
        }
        else if (button.getTag().equals("black_bishop") || button.getTag().equals("white_bishop")) {
            BishopPiece bishop = new BishopPiece(button, letterIndex, numberIndex);
            return bishop.getPossibleTakes();
        }
        else if (button.getTag().equals("white_knight") || button.getTag().equals("black_knight")) {
            KnightPiece knight = new KnightPiece(button, letterIndex, numberIndex);
            return knight.getPossibleTakes();
        }
        else if (button.getTag().equals("black_king") || button.getTag().equals("white_king")) {
            KingPiece king = new KingPiece(button, letterIndex, numberIndex);
            return king.getPossibleTakes();
        }
        else if (button.getTag().equals("white_queen") || button.getTag().equals("black_queen")) {
            QueenPiece queen = new QueenPiece(button, letterIndex, numberIndex);
            return queen.getPossibleTakes();
        }
        else if (button.getTag().equals("black_pawn") || button.getTag().equals("white_pawn")) {
            PawnPiece pawn = new PawnPiece(button, letterIndex, numberIndex);
            return pawn.getPossibleTakes();
        }
        else return null;
    }

    public List<ImageButton> getAllProtectedPieces(String player) {
        List<ImageButton> allProtectedPieces = new ArrayList<>();
        for (List<ImageButton> column : board) {
            for (ImageButton button : column){
                int letterIndex =   BoardManager.getLetterIndex(button);
                int numberIndex = BoardManager.getNumberIndex(button);
                if (player.equals("black")){
                    if (button.getTag().equals("black_rook")) {
                        RookPiece rook = new RookPiece(button, letterIndex, numberIndex);
                        List<ImageButton> protectedPieces = new ArrayList<>(rook.getProtectedPieces());
                        for (ImageButton protectedPiece : protectedPieces){
                            if (!allProtectedPieces.contains(protectedPiece)){
                                allProtectedPieces.add(protectedPiece);
                            }
                        }
                    }
                    else if (button.getTag().equals("black_bishop")) {
                        BishopPiece bishop = new BishopPiece(button, letterIndex, numberIndex);
                        List<ImageButton> protectedPieces = new ArrayList<>(bishop.getProtectedPieces());
                        for (ImageButton protectedPiece : protectedPieces){
                            if (!allProtectedPieces.contains(protectedPiece)){
                                allProtectedPieces.add(protectedPiece);
                            }
                        }
                    }
                    else if (button.getTag().equals("black_knight")) {
                        KnightPiece knight = new KnightPiece(button, letterIndex, numberIndex);
                        List<ImageButton> protectedPieces = new ArrayList<>(knight.getProtectedPieces());
                        for (ImageButton protectedPiece : protectedPieces){
                            if (!allProtectedPieces.contains(protectedPiece)){
                                allProtectedPieces.add(protectedPiece);
                            }
                        }
                    }
                    else if (button.getTag().equals("black_king")) {
                        KingPiece king = new KingPiece(button, letterIndex, numberIndex);
                        List<ImageButton> protectedPieces = new ArrayList<>(king.getProtectedPieces());
                        for (ImageButton protectedPiece : protectedPieces){
                            if (!allProtectedPieces.contains(protectedPiece)){
                                allProtectedPieces.add(protectedPiece);
                            }
                        }
                    }
                    else if (button.getTag().equals("black_queen")) {
                        QueenPiece queen = new QueenPiece(button, letterIndex, numberIndex);
                        List<ImageButton> protectedPieces = new ArrayList<>(queen.getProtectedPieces());
                        for (ImageButton protectedPiece : protectedPieces){
                            if (!allProtectedPieces.contains(protectedPiece)){
                                allProtectedPieces.add(protectedPiece);
                            }
                        }
                    }
                    else if (button.getTag().equals("black_pawn")) {
                        PawnPiece pawn = new PawnPiece(button, letterIndex, numberIndex);
                        List<ImageButton> protectedPieces = new ArrayList<>(pawn.getProtectedPieces());
                        for (ImageButton protectedPiece : protectedPieces){
                            if (!allProtectedPieces.contains(protectedPiece)){
                                allProtectedPieces.add(protectedPiece);
                            }
                        }
                    }
                }
                else if (player.equals("white")){
                    if (button.getTag().equals("white_rook")) {
                        RookPiece rook = new RookPiece(button, letterIndex, numberIndex);
                        List<ImageButton> protectedPieces = new ArrayList<>(rook.getProtectedPieces());
                        for (ImageButton protectedPiece : protectedPieces){
                            if (!allProtectedPieces.contains(protectedPiece)){
                                allProtectedPieces.add(protectedPiece);
                            }
                        }
                        protectedPieces.addAll(rook.getProtectedPieces());
                    }
                    else if (button.getTag().equals("white_bishop")) {
                        BishopPiece bishop = new BishopPiece(button, letterIndex, numberIndex);
                        List<ImageButton> protectedPieces = new ArrayList<>(bishop.getProtectedPieces());
                        for (ImageButton protectedPiece : protectedPieces){
                            if (!allProtectedPieces.contains(protectedPiece)){
                                allProtectedPieces.add(protectedPiece);
                            }
                        }
                    }
                    else if (button.getTag().equals("white_knight")) {
                        KnightPiece knight = new KnightPiece(button, letterIndex, numberIndex);
                        List<ImageButton> protectedPieces = new ArrayList<>(knight.getProtectedPieces());
                        for (ImageButton protectedPiece : protectedPieces){
                            if (!allProtectedPieces.contains(protectedPiece)){
                                allProtectedPieces.add(protectedPiece);
                            }
                        }
                    }
                    else if (button.getTag().equals("white_king")) {
                        KingPiece king = new KingPiece(button, letterIndex, numberIndex);
                        List<ImageButton> protectedPieces = new ArrayList<>(king.getProtectedPieces());
                        for (ImageButton protectedPiece : protectedPieces){
                            if (!allProtectedPieces.contains(protectedPiece)){
                                allProtectedPieces.add(protectedPiece);
                            }
                        }
                    }
                    else if (button.getTag().equals("white_queen")) {
                        QueenPiece queen = new QueenPiece(button, letterIndex, numberIndex);
                        List<ImageButton> protectedPieces = new ArrayList<>(queen.getProtectedPieces());
                        for (ImageButton protectedPiece : protectedPieces){
                            if (!allProtectedPieces.contains(protectedPiece)){
                                allProtectedPieces.add(protectedPiece);
                            }
                        }
                    }
                    else if (button.getTag().equals("white_pawn")) {
                        PawnPiece pawn = new PawnPiece(button, letterIndex, numberIndex);
                        List<ImageButton> protectedPieces = new ArrayList<>(pawn.getProtectedPieces());
                        for (ImageButton protectedPiece : protectedPieces){
                            if (!allProtectedPieces.contains(protectedPiece)){
                                allProtectedPieces.add(protectedPiece);
                            }
                        }
                        protectedPieces.addAll(pawn.getProtectedPieces());
                    }
                }
            }
        }
        return allProtectedPieces;
    }

    public List<ImageButton> getAllFilteredPossibleMoves(String player) {
        List<ImageButton> possibleMoves = new ArrayList<>();
        if (player.equals("black")){
            for (List<ImageButton> column : board){
                for (ImageButton button : column){
                    if (blackPieces.contains(button.getTag().toString())){
                        possibleMoves.addAll(getFilteredPossibleMoves(button, BoardManager.getLetterIndex(button), BoardManager.getNumberIndex(button)));
                    }
                }
            }
        }
        else if (player.equals("white")){
            for (List<ImageButton> column : board){
                for (ImageButton button : column){
                    if (whitePieces.contains(button.getTag().toString())){
                        possibleMoves.addAll(getFilteredPossibleTakes(button, BoardManager.getLetterIndex(button), BoardManager.getNumberIndex(button)));
                    }
                }
            }
        }
        return possibleMoves;
    }

    private List<ImageButton> getPossibleMoves(ImageButton button, int letterIndex, int numberIndex) {
        if (button.getTag().equals("white_rook") || button.getTag().equals("black_rook")) {
            RookPiece rook = new RookPiece(button, letterIndex, numberIndex);
            return rook.getPossibleMoves();
        }
        else if (button.getTag().equals("black_bishop") || button.getTag().equals("white_bishop")) {
            BishopPiece bishop = new BishopPiece(button, letterIndex, numberIndex);
            return bishop.getPossibleMoves();
        }
        else if (button.getTag().equals("white_knight") || button.getTag().equals("black_knight")) {
            KnightPiece knight = new KnightPiece(button, letterIndex, numberIndex);
            return knight.getPossibleMoves();
        }
        else if (button.getTag().equals("black_king") || button.getTag().equals("white_king")) {
            KingPiece king = new KingPiece(button, letterIndex, numberIndex);
            return king.getPossibleMoves();
        }
        else if (button.getTag().equals("white_queen") || button.getTag().equals("black_queen")) {
            QueenPiece queen = new QueenPiece(button, letterIndex, numberIndex);
            return queen.getPossibleMoves();
        }
        else if (button.getTag().equals("black_pawn") || button.getTag().equals("white_pawn")) {
            PawnPiece pawn = new PawnPiece(button, letterIndex, numberIndex);
            return pawn.getPossibleMoves();
        }
        else return null;


    }


    private List<ImageButton> filterPossibleMoves(String tag, List<ImageButton> possibleMoves, int letterIndex, int numberIndex) {
        List<ImageButton> finalPossibleMoves = new ArrayList<>(possibleMoves);
        if (tag.equals("white_king") || tag.equals("black_king")) {
            List<ImageButton> possibleThreats = new ArrayList<>();
            List<ImageButton> pawnThreatenedSquares = new ArrayList<>();
            if (tag.equals("white_king")) {
                pawnThreatenedSquares.addAll(getPawnThreatenedSquares("white"));
            } else {
                pawnThreatenedSquares.addAll(getPawnThreatenedSquares("black"));
            }

            for (List<ImageButton> column : board) {
                for (ImageButton but : column) {
                    if (tag.equals("white_king")) {
                        if (blackPieces.contains(but.getTag().toString())) {
                            if (!but.getTag().toString().equals("black_pawn")) {
                                possibleThreats.addAll(getPossibleMoves(but, BoardManager.getLetterIndex(but), BoardManager.getNumberIndex(but)));
                            }
                        }
                    } else {
                        if (whitePieces.contains(but.getTag().toString())) {
                            if (!but.getTag().toString().equals("white_pawn")) {
                                possibleThreats.addAll(getPossibleMoves(but, BoardManager.getLetterIndex(but), BoardManager.getNumberIndex(but)));
                            }
                        }
                    }
                }
            }
            for (ImageButton square : pawnThreatenedSquares) {
                if (!possibleThreats.contains(square)) {
                    possibleThreats.add(square);
                }
            }
            finalPossibleMoves.removeIf(possibleThreats::contains);
        }

        else {
            finalPossibleMoves = new ArrayList<>(fixIfPinned(tag, finalPossibleMoves, letterIndex, numberIndex));
        }
        return finalPossibleMoves;
    }

    private List<ImageButton> filterPossibleTakes(String tag, List<ImageButton> possibleTakes, int firstClickButtonLetterIndex, int firstClickButtonNumberIndex) {
        List<ImageButton> finalPossibleTakes = new ArrayList<>(possibleTakes);

        if (tag.equals("white_king") || tag.equals("black_king")){
            ImageButton king = BoardManager.getSquareAtLocation(letterConversion[firstClickButtonLetterIndex], firstClickButtonNumberIndex);
            List<ImageButton> allEnemyProtectedPieces;
            if (blackPieces.contains(tag)){
                allEnemyProtectedPieces = new ArrayList<>(getAllProtectedPieces("white"));
            }
            else {
                allEnemyProtectedPieces = new ArrayList<>(getAllProtectedPieces("black"));
            }
            finalPossibleTakes.removeIf(allEnemyProtectedPieces::contains);
        }
        else {
            finalPossibleTakes = new ArrayList<>(fixIfPinned(tag, possibleTakes, firstClickButtonLetterIndex, firstClickButtonNumberIndex));
        }
        return finalPossibleTakes;
    }

    private List<ImageButton> fixIfPinned(String tag, List<ImageButton> possibleMovesOrTakes, int letterIndex, int numberIndex) {
        int kingLetterIndex = 0;
        int kingNumberIndex = 0;

        if (whitePieces.contains(tag)){
            kingLetterIndex = BoardManager.getKingLetterIndexLocation("white");
            kingNumberIndex = BoardManager.getKingNumberIndexLocation("white");
        }
        else if (blackPieces.contains(tag)){
            kingLetterIndex = BoardManager.getKingLetterIndexLocation("black");
            kingNumberIndex = BoardManager.getKingNumberIndexLocation("black");
        }

        List<ImageButton> finalPossibleMovesOrTakes = new ArrayList<>(possibleMovesOrTakes);
        ImageButton button = BoardManager.getSquareAtLocation(letterConversion[letterIndex], numberIndex);
        ImageButton king = BoardManager.getSquareAtLocation(letterConversion[kingLetterIndex], kingNumberIndex);

        for(ImageButton possibleMove : possibleMovesOrTakes){
            String possibleMoveTag = possibleMove.getTag().toString();
            possibleMove.setTag(button.getTag().toString());
            button.setTag("empty");
            List<ImageButton> enemyPossibleTakes = new ArrayList<>();

            if (whitePieces.contains(tag)){
                enemyPossibleTakes.addAll(getAllPossibleTakes("black"));
            }
            else {
                enemyPossibleTakes.addAll(getAllPossibleTakes("white"));
            }
            if (enemyPossibleTakes.contains(king)){
                finalPossibleMovesOrTakes.remove(possibleMove);
            }
            button.setTag(possibleMove.getTag().toString());
            possibleMove.setTag(possibleMoveTag);
        }
        return finalPossibleMovesOrTakes;
    }

    public List<ImageButton> getAllFilteredPossibleTakes(String player) {
        List<ImageButton> possibleTakes = new ArrayList<>();
        if (player.equals("black")){
            for (List<ImageButton> column : board){
                for (ImageButton button : column){
                    if (blackPieces.contains(button.getTag().toString())){
                        List<ImageButton> piecePossibleTakes = new ArrayList<>(getFilteredPossibleTakes(button, BoardManager.getLetterIndex(button), BoardManager.getNumberIndex(button)));
                        piecePossibleTakes.removeIf(possibleTakes::contains);
                        possibleTakes.addAll(piecePossibleTakes);
                    }
                }
            }
        }
        else if (player.equals("white")){
            for (List<ImageButton> column : board){
                for (ImageButton button : column){
                    if (whitePieces.contains(button.getTag().toString())){
                        List<ImageButton> piecePossibleTakes = new ArrayList<>(getFilteredPossibleTakes(button, BoardManager.getLetterIndex(button), BoardManager.getNumberIndex(button)));
                        piecePossibleTakes.removeIf(possibleTakes::contains);
                        possibleTakes.addAll(piecePossibleTakes);
                    }
                }
            }
        }
        return possibleTakes;
    }
}
