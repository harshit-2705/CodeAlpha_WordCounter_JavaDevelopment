import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterApp extends JFrame {

    private JTextArea textArea;
    private JLabel resultLabel;

    public WordCounterApp() {
        setTitle("Word Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JButton countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });

        resultLabel = new JLabel("Word count will be displayed here.");

        mainPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        mainPanel.add(countButton, BorderLayout.SOUTH);
        add(mainPanel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);
    }

    private void countWords() {
        String text = textArea.getText();
        String[] words = text.split("\\s+"); // Split the text into words using space as a separator
        int wordCount = words.length;
        resultLabel.setText("Word count: " + wordCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WordCounterApp wordCounterApp = new WordCounterApp();
                wordCounterApp.setVisible(true);
            }
        });
    }
}