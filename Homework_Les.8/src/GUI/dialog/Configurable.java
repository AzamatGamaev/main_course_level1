package GUI.dialog;

import core.enums.DotType;


public interface Configurable {

    DotType getPlayerType();

    int getMapSize();

    int getDotsToWin();
}
