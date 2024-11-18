package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();

    public SimpleGUIWithFileChooser(final Controller controller) {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        final JTextArea textArea = new JTextArea();
        canvas.add(textArea, BorderLayout.CENTER);
        
        final JButton saveButton = new JButton("Save");
        canvas.add(saveButton, BorderLayout.SOUTH);

        final JPanel canvas2 = new JPanel();
        canvas2.setLayout(new BorderLayout());
        frame.add(canvas2,BorderLayout.NORTH);

        final JTextArea textArea2 = new JTextArea();
        canvas2.add(textArea2, BorderLayout.CENTER);
        textArea2.setEditable(false); // rendo il JTextField non modificabile
        textArea2.setText(controller.getCurrentPath());

        final JButton browseButton = new JButton("Browse...");
        canvas2.add(browseButton, BorderLayout.LINE_END);

        canvas.add(canvas2, BorderLayout.NORTH);
        /*
         * Hendlers
         */
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    controller.saveString(textArea.getText());
                } catch (IOException e) {
                     JOptionPane.showMessageDialog(null, e.getMessage(), "An error occurred", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });

        browseButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    controller.setCurrentFile(fileChooser.getSelectedFile());
                    textArea2.setText(fileChooser.getSelectedFile().getAbsolutePath());
                } else if (result == JFileChooser.CANCEL_OPTION) {
                    // non faccio nulla
                } else {
                    JOptionPane.showMessageDialog(frame, result, "error", JOptionPane.ERROR_MESSAGE);
                }
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


    public static void main(String[] args) {
        final SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser(new Controller());
        gui.display();
    }
    
}
