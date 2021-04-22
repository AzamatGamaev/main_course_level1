package core.domain;

public final class MatrixCoordinate {

    private final int row;
    private final int column;

    public MatrixCoordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
