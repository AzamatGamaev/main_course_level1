package core;


import core.domain.MatrixCoordinate;
import core.enums.DotType;


public interface GameService {

    MatrixCoordinate aiTurn();

    void humanTurn(int rowIndex, int columnIndex);

    boolean checkWin(DotType dotType);

    boolean isMapFull();
}
