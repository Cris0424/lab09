package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();

    /**
     * builds a new {@link SimpleGUI}.
     * @param controller for controller istance
     */
    public SimpleGUI(final Controller controller) {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTextField textField = new JTextField();
        canvas.add(textField, BorderLayout.NORTH);

        final JTextArea textArea = new JTextArea();
        canvas.add(textArea, BorderLayout.CENTER);

        final JPanel canvas2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        canvas.add(canvas2, BorderLayout.SOUTH);

        final JButton printButton = new JButton("print");
        canvas2.add(printButton, BorderLayout.SOUTH);

        final JButton historyButton = new JButton("show history");
        canvas2.add(historyButton, BorderLayout.SOUTH);

        /*
         * Handlers
         */
        printButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setNextStringToPrint(textField.getText());
                System.out.println(controller.getNextStringToPrint()); // NOPMD
                controller.printCurrentString();
            }
        });

        historyButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                String memoryString = "";
                for (final String iString : controller.getHistoryStringPrinted()) {
                    memoryString = memoryString.concat(" " + iString);
                }
                textArea.setText(memoryString);
            }
        });
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();

        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    /**
     * 
     * @param args
     */
    public static void main(final String[] args) {
        final SimpleGUI gui = new SimpleGUI(new SimpleController());
        gui.display();
    }
}
