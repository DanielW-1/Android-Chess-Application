package com.example.mychess;

import android.os.Bundle;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChessBoardFragment extends Fragment{

    ImageButton A1, A2, A3, A4, A5, A6, A7, A8;
    ImageButton B1, B2, B3, B4, B5, B6, B7, B8;
    ImageButton C1, C2, C3, C4, C5, C6, C7, C8;
    ImageButton D1, D2, D3, D4, D5, D6, D7, D8;
    ImageButton E1, E2, E3, E4, E5, E6, E7, E8;
    ImageButton F1, F2, F3, F4, F5, F6, F7, F8;
    ImageButton G1, G2, G3, G4, G5, G6, G7, G8;
    ImageButton H1, H2, H3, H4, H5, H6, H7, H8;
    View view;
    static List<List<ImageButton>> letters = new ArrayList<>();

    public ChessBoardFragment() {
        // required public empty constructor
    }

    public static List<List<ImageButton>> getBoard() {
        return letters;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_chess_board, container, false);

        assignButtons();

        ImageButton[] A_Array = new ImageButton[]{A1, A2, A3, A4, A5, A6, A7, A8};
        ImageButton[] B_Array = new ImageButton[]{B1, B2, B3, B4, B5, B6, B7, B8};
        ImageButton[] C_Array = new ImageButton[]{C1, C2, C3, C4, C5, C6, C7, C8};
        ImageButton[] D_Array = new ImageButton[]{D1, D2, D3, D4, D5, D6, D7, D8};
        ImageButton[] E_Array = new ImageButton[]{E1, E2, E3, E4, E5, E6, E7, E8};
        ImageButton[] F_Array = new ImageButton[]{F1, F2, F3, F4, F5, F6, F7, F8};
        ImageButton[] G_Array = new ImageButton[]{G1, G2, G3, G4, G5, G6, G7, G8};
        ImageButton[] H_Array = new ImageButton[]{H1, H2, H3, H4, H5, H6, H7, H8};

        letters.add(Arrays.asList(A_Array));
        letters.add(Arrays.asList(B_Array));
        letters.add(Arrays.asList(C_Array));
        letters.add(Arrays.asList(D_Array));
        letters.add(Arrays.asList(E_Array));
        letters.add(Arrays.asList(F_Array));
        letters.add(Arrays.asList(G_Array));
        letters.add(Arrays.asList(H_Array));

        BoardManager chessMoveEvaluator = new BoardManager(this.getContext());
        return view;
    }








    private void assignButtons() {

        A1 = view.findViewById(R.id.buttonA1); B1 = view.findViewById(R.id.buttonB1); C1 = view.findViewById(R.id.buttonC1);
        A2 = view.findViewById(R.id.buttonA2); B2 = view.findViewById(R.id.buttonB2); C2 = view.findViewById(R.id.buttonC2);
        A3 = view.findViewById(R.id.buttonA3); B3 = view.findViewById(R.id.buttonB3); C3 = view.findViewById(R.id.buttonC3);
        A4 = view.findViewById(R.id.buttonA4); B4 = view.findViewById(R.id.buttonB4); C4 = view.findViewById(R.id.buttonC4);
        A5 = view.findViewById(R.id.buttonA5); B5 = view.findViewById(R.id.buttonB5); C5 = view.findViewById(R.id.buttonC5);
        A6 = view.findViewById(R.id.buttonA6); B6 = view.findViewById(R.id.buttonB6); C6 = view.findViewById(R.id.buttonC6);
        A7 = view.findViewById(R.id.buttonA7); B7 = view.findViewById(R.id.buttonB7); C7 = view.findViewById(R.id.buttonC7);
        A8 = view.findViewById(R.id.buttonA8); B8 = view.findViewById(R.id.buttonB8); C8 = view.findViewById(R.id.buttonC8);

        D1 = view.findViewById(R.id.buttonD1); E1 = view.findViewById(R.id.buttonE1); F1 = view.findViewById(R.id.buttonF1);
        D2 = view.findViewById(R.id.buttonD2); E2 = view.findViewById(R.id.buttonE2); F2 = view.findViewById(R.id.buttonF2);
        D3 = view.findViewById(R.id.buttonD3); E3 = view.findViewById(R.id.buttonE3); F3 = view.findViewById(R.id.buttonF3);
        D4 = view.findViewById(R.id.buttonD4); E4 = view.findViewById(R.id.buttonE4); F4 = view.findViewById(R.id.buttonF4);
        D5 = view.findViewById(R.id.buttonD5); E5 = view.findViewById(R.id.buttonE5); F5 = view.findViewById(R.id.buttonF5);
        D6 = view.findViewById(R.id.buttonD6); E6 = view.findViewById(R.id.buttonE6); F6 = view.findViewById(R.id.buttonF6);
        D7 = view.findViewById(R.id.buttonD7); E7 = view.findViewById(R.id.buttonE7); F7 = view.findViewById(R.id.buttonF7);
        D8 = view.findViewById(R.id.buttonD8); E8 = view.findViewById(R.id.buttonE8); F8 = view.findViewById(R.id.buttonF8);

        G1 = view.findViewById(R.id.buttonG1); H1 = view.findViewById(R.id.buttonH1);
        G2 = view.findViewById(R.id.buttonG2); H2 = view.findViewById(R.id.buttonH2);
        G3 = view.findViewById(R.id.buttonG3); H3 = view.findViewById(R.id.buttonH3);
        G4 = view.findViewById(R.id.buttonG4); H4 = view.findViewById(R.id.buttonH4);
        G5 = view.findViewById(R.id.buttonG5); H5 = view.findViewById(R.id.buttonH5);
        G6 = view.findViewById(R.id.buttonG6); H6 = view.findViewById(R.id.buttonH6);
        G7 = view.findViewById(R.id.buttonG7); H7 = view.findViewById(R.id.buttonH7);
        G8 = view.findViewById(R.id.buttonG8); H8 = view.findViewById(R.id.buttonH8);

    }
}