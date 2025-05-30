package com.example.mychess;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class BoardManager implements View.OnClickListener{

    private static List<List<ImageButton>> board = new ArrayList<>();
    private static final List<String> whitePieces = new ArrayList<>();
    private static final List<String> blackPieces = new ArrayList<>();
    private final PiecesManager piecesManager = new PiecesManager();
    private ImageButton firstClickButton = null;
    private boolean whiteIsInCheck = false;
    private boolean blackIsInCheck = false;
    private int firstClickButtonLetterIndex = 0;
    private int firstClickButtonNumberIndex = 0;
    private Context context;
    private boolean whiteWins = false;
    private boolean blackWins = false;

    private static final char [] letterConversion = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    private boolean whitePlays = true;

    int numberBoardPosition = 0;
    char letterBoardPosition;
    int letterIndex = 0;
    int numberIndex = 0;



    public BoardManager(Context context){
        board = ChessBoardFragment.getBoard();
        this.context = context;

        setEmptySquaresDrawable();

        separateWhiteAndBlackPieces();

        setOnClickListeners();

    }

    public static List<String> getBlackPieces() {
        return blackPieces;
    }

    public static List<String> getWhitePieces() {
        return whitePieces;
    }


    private void separateWhiteAndBlackPieces() {

        whitePieces.add("white_knight");
        whitePieces.add("white_bishop");
        whitePieces.add("white_rook");
        whitePieces.add("white_queen");
        whitePieces.add("white_king");
        whitePieces.add("white_pawn");

        blackPieces.add("black_knight");
        blackPieces.add("black_bishop");
        blackPieces.add("black_rook");
        blackPieces.add("black_queen");
        blackPieces.add("black_king");
        blackPieces.add("black_pawn");

    }


    private void setEmptySquaresDrawable() {

        for (List<ImageButton> letter : board) {
            for (ImageButton but : letter){
                if (but.getDrawable() == null){
                    but.setImageResource(R.drawable.empty);
                    but.setTag("empty");
                }
            }
        }
    }


    private void setOnClickListeners() {
        for(List<ImageButton> letter : board) {
            for(ImageButton button : letter){
                button.setOnClickListener(this);
            }
        }
    }


    @Override
    public void onClick(View v) {
        ImageButton button = (ImageButton) v;
        setButtonPosition(button);

        if (isFirstClick(button)) {
            emptyGreySquares();
            firstClickEvaluator(button);
        }

        else if (isSecondClick(button)){
            secondClickEvaluator(button);
        }
    }


    private boolean isFirstClick(ImageButton button) {

        if (whitePlays){
            return whitePieces.contains(button.getTag().toString());
        }
        else {
            return blackPieces.contains(button.getTag().toString());
        }
    }


    private boolean isSecondClick(ImageButton button) {

        if (firstClickButton == null){
            return false;
        }
        if (button.getTag().equals("grey_circle")){
            return true;
        }
        List<ImageButton> possibleTakes = new ArrayList<>(piecesManager.getFilteredPossibleTakes(firstClickButton, firstClickButtonLetterIndex, firstClickButtonNumberIndex));

        if (!possibleTakes.isEmpty()){
            for (ImageButton but : possibleTakes){
                if (button == but){
                    return true;
                }
            }
        }
        return false;
    }


    private void setButtonPosition (ImageButton button){

        letterIndex = 0;
        for (List<ImageButton> letter : board) {
            for (ImageButton but : letter){
                if (button == but){
                    numberBoardPosition = letter.indexOf(but) + 1;
                    letterIndex = board.indexOf(letter);
                    numberIndex = numberBoardPosition - 1;
                }
            }
        }
        letterBoardPosition = letterConversion[letterIndex];
    }
    public static int getLetterIndex (ImageButton button){
        int letIndex = 0;
        for (List<ImageButton> letter : board) {
            for (ImageButton but : letter){
                if (button == but){
                    letIndex = board.indexOf(letter);
                }
            }
        }
        return letIndex;
    }
    public static int getNumberIndex (ImageButton button){
        int numIndex = 0;
        for (List<ImageButton> letter : board) {
            for (ImageButton but : letter){
                if (button == but){
                    numIndex =  letter.indexOf(but);
                }
            }
        }
        return numIndex;
    }


    private void firstClickEvaluator(ImageButton button) {
        firstClickButton = button;
        firstClickButtonLetterIndex = getLetterIndex(firstClickButton);
        firstClickButtonNumberIndex = getNumberIndex(firstClickButton);
        List<ImageButton> possibleMoves = new ArrayList<>(piecesManager.getFilteredPossibleMoves(button, letterIndex, numberIndex));
        if (!possibleMoves.isEmpty()){
            for (ImageButton possibleMove : possibleMoves){
                if (possibleMove.getTag().toString().equals("empty")){
                    possibleMove.setImageResource(R.drawable.grey_circle);
                    possibleMove.setTag("grey_circle");
                }
            }
        }
    }

    private boolean isInCheck() {

        int whiteKingLetterIndex = getKingLetterIndexLocation("white");
        int blackKingLetterIndex = getKingLetterIndexLocation("black");
        int whiteKingNumberIndex = getKingNumberIndexLocation("white");
        int blackKingNumberIndex = getKingNumberIndexLocation("black");

        ImageButton whiteKing = getSquareAtLocation(letterConversion[whiteKingLetterIndex], whiteKingNumberIndex);
        ImageButton blackKing = getSquareAtLocation(letterConversion[blackKingLetterIndex], blackKingNumberIndex);

        List<ImageButton> allWhitePossibleTakes = new ArrayList<>(piecesManager.getAllFilteredPossibleTakes("white"));
        List<ImageButton> allBlackPossibleTakes = new ArrayList<>(piecesManager.getAllFilteredPossibleTakes("black"));
        if (allWhitePossibleTakes.contains(blackKing)){
            Toast.makeText(context, "Black is in check!", Toast.LENGTH_LONG).show();
            blackIsInCheck = true;
            return true;
        }
        if (allBlackPossibleTakes.contains(whiteKing)){
            Toast.makeText(context, "White is in check", Toast.LENGTH_LONG).show();
            whiteIsInCheck = true;
            return true;
        }
        return false;
    }


    public static int  getKingLetterIndexLocation(String player) {
        if (player.equals("white")){
            for (List<ImageButton> column : board){
                for (ImageButton but : column){
                    if (but.getTag().toString().equals("white_king")){
                        return getLetterIndex(but);
                    }
                }
            }
        }
        else {
            for (List<ImageButton> column : board){
                for (ImageButton but : column){
                    if (but.getTag().toString().equals("black_king")){
                        return getLetterIndex(but);
                    }
                }
            }
        }
        return 0;
    }

    public static int  getKingNumberIndexLocation(String player) {
        if (player.equals("white")){
            for (List<ImageButton> column : board){
                for (ImageButton but : column){
                    if (but.getTag().toString().equals("white_king")){
                        return getNumberIndex(but);
                    }
                }
            }
        }
        else {
            for (List<ImageButton> column : board){
                for (ImageButton but : column){
                    if (but.getTag().toString().equals("black_king")){
                        return getNumberIndex(but);
                    }
                }
            }
        }
        return 0;
    }

    private void endGame() {
        if (whiteWins){
            Toast.makeText(context, "Checkmate! White Wins!", Toast.LENGTH_LONG).show();
        }
        else if (blackWins){
            Toast.makeText(context, "Checkmate! Black Wins!", Toast.LENGTH_LONG).show();
        }
        resetBoard();
        whiteWins = false;
        blackWins = false;
        whitePlays = true;
    }

    private void resetBoard() {
        board.get(0).get(0).setImageResource(R.drawable.white_rook);
        board.get(0).get(0).setTag("white_rook");
        board.get(1).get(0).setImageResource(R.drawable.white_knight);
        board.get(1).get(0).setTag("white_knight");
        board.get(2).get(0).setImageResource(R.drawable.white_bishop);
        board.get(2).get(0).setTag("white_bishop");
        board.get(3).get(0).setImageResource(R.drawable.white_queen);
        board.get(3).get(0).setTag("white_queen");
        board.get(4).get(0).setImageResource(R.drawable.white_king);
        board.get(4).get(0).setTag("white_king");
        board.get(5).get(0).setImageResource(R.drawable.white_bishop);
        board.get(5).get(0).setTag("white_bishop");
        board.get(6).get(0).setImageResource(R.drawable.white_knight);
        board.get(6).get(0).setTag("white_knight");
        board.get(7).get(0).setImageResource(R.drawable.white_rook);
        board.get(7).get(0).setTag("white_rook");
        for (List<ImageButton> column : board){
            column.get(1).setImageResource(R.drawable.white_pawn);
            column.get(1).setTag("white_pawn");
        }
        board.get(0).get(7).setImageResource(R.drawable.black_rook);
        board.get(0).get(7).setTag("black_rook");
        board.get(1).get(7).setImageResource(R.drawable.black_knight);
        board.get(1).get(7).setTag("black_knight");
        board.get(2).get(7).setImageResource(R.drawable.black_bishop);
        board.get(2).get(7).setTag("black_bishop");
        board.get(3).get(7).setImageResource(R.drawable.black_queen);
        board.get(3).get(7).setTag("black_queen");
        board.get(4).get(7).setImageResource(R.drawable.black_king);
        board.get(4).get(7).setTag("black_king");
        board.get(5).get(7).setImageResource(R.drawable.black_bishop);
        board.get(5).get(7).setTag("black_bishop");
        board.get(6).get(7).setImageResource(R.drawable.black_knight);
        board.get(6).get(7).setTag("black_knight");
        board.get(7).get(7).setImageResource(R.drawable.black_rook);
        board.get(7).get(7).setTag("black_rook");
        for (List<ImageButton> column : board){
            column.get(6).setImageResource(R.drawable.black_pawn);
            column.get(6).setTag("black_pawn");
        }
        for (List<ImageButton> column : board){
            column.get(2).setImageResource(R.drawable.empty);
            column.get(2).setTag("empty");
            column.get(3).setImageResource(R.drawable.empty);
            column.get(3).setTag("empty");
            column.get(4).setImageResource(R.drawable.empty);
            column.get(4).setTag("empty");
            column.get(5).setImageResource(R.drawable.empty);
            column.get(5).setTag("empty");
        }
    }

    private boolean isCheckMate() {
        if (whiteIsInCheck){
            int kingLetterIndex = getKingLetterIndexLocation("white");
            int kingNumberIndex = getKingNumberIndexLocation("white");

            ImageButton king = getSquareAtLocation(letterConversion[kingLetterIndex], kingNumberIndex);
            List<ImageButton> possibleMovesAndTakes = new ArrayList<>(piecesManager.getAllFilteredPossibleMoves("white"));
            possibleMovesAndTakes.addAll(piecesManager.getAllFilteredPossibleTakes("white"));
            if (possibleMovesAndTakes.isEmpty()){
                blackWins = true;
                return true;
            }
            else {
                blackWins = false;
                return false;
            }
        }
        else if (blackIsInCheck){
            int kingLetterIndex = getKingLetterIndexLocation("black");
            int kingNumberIndex = getKingNumberIndexLocation("black");

            ImageButton king = getSquareAtLocation(letterConversion[kingLetterIndex], kingNumberIndex);
            List<ImageButton> possibleMovesAndTakes = new ArrayList<>(piecesManager.getAllFilteredPossibleMoves("black"));
            possibleMovesAndTakes.addAll(piecesManager.getAllFilteredPossibleTakes("black"));

            if (possibleMovesAndTakes.isEmpty()){
                whiteWins = true;
                return true;
            }
            else {
                whiteWins = false;
                return false;
            }
        }
       return false;
    }


    private void secondClickEvaluator(ImageButton button) {

        button.setImageDrawable(firstClickButton.getDrawable());
        button.setTag(firstClickButton.getTag().toString());

        firstClickButton.setImageResource(R.drawable.empty);
        firstClickButton.setTag("empty");

        endTurn();


    }

    private void endTurn() {
        setEmptySquaresDrawable();
        emptyGreySquares();
        whitePlays = !whitePlays;
        firstClickButton = null;
        if (isInCheck()){
            if (isCheckMate()){
                endGame();
            }
        }
        blackIsInCheck = false;
        whiteIsInCheck = false;
    }


    private void emptyGreySquares() {
        for (List<ImageButton> letter : board) {
            for (ImageButton square : letter) {
                if (square.getTag().equals("grey_circle")){
                    square.setImageResource(R.drawable.empty);
                    square.setTag("empty");
                }
            }
        }
    }


    public static ImageButton getSquareAtLocation(char letter, int number) {
        int i;
       for (i = 0; i < letterConversion.length; i++) {
           if (letter == letterConversion[i]){
               break;
           }
       }
        return board.get(i).get(number);
    }
}