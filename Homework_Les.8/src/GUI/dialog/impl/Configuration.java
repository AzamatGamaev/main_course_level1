package GUI.dialog.impl;

import GUI.dialog.Configurable;
import core.enums.DotType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Configuration extends JDialog implements Configurable {

    public static final int MARGIN_VALUE = 5;
    public DotType playerType = DotType.X;
    public int mapSize = 3;
    public int dotsToWin = 4;

    public Configuration(JFrame parentFrame) {
        super(parentFrame, "Конфигурация игры", true);

        setBounds(300, 300, 800, 170);

        JTextField mapSizeTextField = new JTextField(String.valueOf(mapSize));
        JTextField dotsSizeTextField = new JTextField(String.valueOf(dotsToWin));
        JPanel commonPanel = getConfigurationPanel(mapSizeTextField, dotsSizeTextField);
        JButton applyButton = createApplyButton(mapSizeTextField,dotsSizeTextField);

        setLayout(new BorderLayout());
        add(commonPanel, BorderLayout.CENTER);
        add(applyButton, BorderLayout.SOUTH);

        commonPanel.setBorder(BorderFactory.createEmptyBorder(MARGIN_VALUE, MARGIN_VALUE, MARGIN_VALUE, MARGIN_VALUE));
        setVisible(true);
    }


    private JPanel getConfigurationPanel(JTextField mapSizeTextField, JTextField dotsSizeTextField) {
        int gridSize = 2;
        int horizontalGap = 10;
        int verticalGap = 10;

        JPanel commonPanel = new JPanel(new GridLayout(gridSize, gridSize, horizontalGap, verticalGap));
        commonPanel.add(new JLabel("Выберите за кого вы будете играть?"));
        commonPanel.add(new JLabel("Укажите размер игрового поля"));
        commonPanel.add(new JLabel("Укажите количество фишек для выигрыша"));
        commonPanel.add(createChoiceButtonPanel());
        commonPanel.add(mapSizeTextField);
        commonPanel.add(dotsSizeTextField);

        return commonPanel;
    }


    private JButton createApplyButton(JTextField mapSizeTextField, JTextField dotsSizeTextField) {
        JButton applyButton = new JButton("Принять");

        WindowEvent closeEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapSize = Integer.parseInt(mapSizeTextField.getText());
                dotsToWin = Integer.parseInt(dotsSizeTextField.getText());
                dispatchEvent(closeEvent);

            }
        });
        return applyButton;
    }


    private JPanel createChoiceButtonPanel() {
        JRadioButton xButtonChoice = getRadioButton("X", DotType.X, true);
        JRadioButton oButtonChoice = getRadioButton("O", DotType.O, false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(xButtonChoice);
        buttonPanel.add(oButtonChoice);

        // Для того, чтобы компонент RadioButton работал корректно. Все кнопки данного типа надо объединить в группу
        ButtonGroup group = new ButtonGroup();
        group.add(xButtonChoice);
        group.add(oButtonChoice);

        return buttonPanel;
    }


    private JRadioButton getRadioButton(String text, DotType buttonDotType, boolean selected) {
        JRadioButton choiceBtn = new JRadioButton(text, selected);
        choiceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerType = buttonDotType;
            }
        });

        return choiceBtn;
    }


    @Override
    public DotType getPlayerType() {
        return playerType;
    }


    @Override
    public int getMapSize() {
        return mapSize;
    }


    @Override
    public int getDotsToWin() {
        return dotsToWin;
    }

}
