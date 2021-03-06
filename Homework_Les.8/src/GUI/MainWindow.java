package GUI;

import GUI.components.StatusBar;
import GUI.dialog.Configurable;
import GUI.dialog.impl.Configuration;
import core.GameService;
import core.domain.MatrixCoordinate;
import core.enums.DotType;
import core.impl.GameServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainWindow extends JFrame {

    public static final String DOT_EMPTY = "*";
    private static final int TXT_SIZE = 32;
    private StatusBar statusBar;
    private DotType playerType;
    private GameService gameService;
    private JButton[][] buttons;


    public MainWindow() {
        setTitle("Крестики нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        statusBar = new StatusBar();
        statusBar.setMessage("Ожидание хода игрока...");

        Configurable configurable = new Configuration(this);
        int mapSize = configurable.getMapSize();
        int dotsToWin = configurable.getDotsToWin();
        playerType = configurable.getPlayerType();

        gameService = new GameServiceImpl(mapSize, dotsToWin, playerType);

        setLayout(new BorderLayout());
        add(createGridButtons(mapSize));
        add(statusBar, BorderLayout.SOUTH);

        setVisible(true);
    }


    private JPanel createGridButtons(int mapSize) {
        JPanel gridPanel = new JPanel(new GridLayout(mapSize, mapSize));

        buttons = new JButton[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                JButton button = new JButton(DOT_EMPTY);
                button.setFont(new Font(button.getFont().getName(), button.getFont().getStyle(), TXT_SIZE));
                button.putClientProperty("INDEX_ROW", i);
                button.putClientProperty("INDEX_COLUMN", j);
                button.addActionListener(getButtonListener());

                buttons[i][j] = button;
                gridPanel.add(button);
            }
        }

        return gridPanel;
    }

    private ActionListener getButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doHumanTurn((JButton) e.getSource());

                if (isGameContinue(playerType) && isGameContinue(DotType.getEnemyType(playerType))) {
                    doAiTurn();
                } else {
                    finishGame();
                }
            }
        };
    }

    private void finishGame() {
        if (gameService.isMapFull() & !(gameService.checkWin(playerType) | gameService.checkWin(DotType.getEnemyType(playerType))))
        {
            statusBar.setMessage("Игра окончена! Ходов больше нет...");
        } else if (gameService.checkWin(DotType.getEnemyType(playerType))) {statusBar.setMessage("Вы проиграли.(");}
        else statusBar.setMessage("Вы выиграли!");
        disableAllButtons();
    }


    private void disableAllButtons() {
        for (JButton[] button : buttons) {
            for (int j = 0; j < buttons.length; j++) {
                button[j].setEnabled(false);
            }
        }
    }


    private boolean isGameContinue(DotType dotType) {
        return !gameService.checkWin(dotType) && !gameService.isMapFull();
    }


    private void doAiTurn() {
        statusBar.setMessage("Ход компьютера...");

        MatrixCoordinate coordinate = gameService.aiTurn();
        JButton aiSelectedButton = buttons[coordinate.getRow()][coordinate.getColumn()];

        disableButtonWithMark(aiSelectedButton, DotType.getEnemyType(playerType));
        statusBar.setMessage("Ход игрока...");

        if (!isGameContinue(DotType.getEnemyType(playerType))) {
            finishGame();
        }
    }


    private void doHumanTurn(JButton selectedButton) {
        int rowIndex = (int) selectedButton.getClientProperty("INDEX_ROW");
        int columnIndex = (int) selectedButton.getClientProperty("INDEX_COLUMN");

        gameService.humanTurn(rowIndex, columnIndex);

        disableButtonWithMark(selectedButton, playerType);
    }


    private void disableButtonWithMark(JButton button, DotType dotType) {
        button.setEnabled(false);
        button.setText(dotType.toString());
    }

}
