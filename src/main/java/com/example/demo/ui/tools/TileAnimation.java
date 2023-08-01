package com.example.demo.ui.tools;

import com.example.demo.model.Tile;
import javafx.animation.AnimationTimer;

import java.util.ArrayList;

/**
 * This class the interactive animation of Tiles on a 1024 game board.
 * Since it is a utility class, it doesn't include a constructor.
 */
public class TileAnimation extends AnimationTimer {
    private final int SPACING = 5;

    @Override
    public void handle(long now) {
        ArrayList<Tile> tiles = BoardBuilder.getTiles();

        for(int i = 0; i < tiles.size(); i++) {
            Tile cur = tiles.get(i);

            if(cur.getLayoutX() + cur.getTranslateX() < 10) {
                cur.slide.stop();
                cur.setTranslateX(10 - cur.getLayoutX());
            } else if(cur.getLayoutX() + cur.getTranslateX() + cur.getLength() > 225) {
                cur.slide.stop();
                cur.setTranslateX(225 - cur.getLayoutX() - cur.getLength());
            }

//                cur.setTranslateX(10 - cur.getLayoutX());
//            } else if (i > 0){
//                Tile other = tiles.get(i - 1);
//                double tileDistance = cur.getLayoutX() - other.getLayoutX() + cur.getLength();
//                if(tileDistance < SPACING) {
//                    cur.slide.stop();
//                    break;
//                }
//            }
        }
    }
}
