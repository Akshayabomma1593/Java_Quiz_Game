
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.list;
import javax.swing.Timer;

public class QuizGame {
    private JFrame frame;
    private JLabel questionLabel;
    private JRadioButton[] options;
    private ButtonGroup optionGroup;
    private JButton nextButton;
    private List<Question> questions;
    private int currentIndex = 0, score = 0;
    private Timer timer;
    private int timeLeft = 15;

    public QuizGame() {
        questions = QuestionLoader.loadQuestions("gk_questions_550_final.csv");
        frame = new JFrame("General Knowledge Quiz Game");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        questionLabel = new JLabel("Question");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(questionLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(4, 1));
        options = new JRadioButton[4];
        optionGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            optionGroup.add(options[i]);
            centerPanel.add(options[i]);
        }
        frame.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        nextButton = new JButton("Next");
        bottomPanel.add(nextButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        nextButton.addActionListener(e -> checkAnswer());

        loadQuestion();

        frame.setVisible(true);
    }

    private void loadQuestion() {
        if (currentIndex >= questions.size()) {
            showResult();
            return;
        }
        Question q = questions.get(currentIndex);
        questionLabel.setText("Q" + (currentIndex + 1) + ": " + q.question);
        options[0].setText(q.option1);
        options[1].setText(q.option2);
        options[2].setText(q.option3);
        options[3].setText(q.option4);
        optionGroup.clearSelection();

        // Reset and start the timer
        if (timer != null) timer.stop();
        timeLeft = 15;
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                timeLeft--;
                nextButton.setText("Next (" + timeLeft + "s)");
                if (timeLeft <= 0) {
                    timer.stop();
                    checkAnswer();  // auto move
                }
            }
        });
        timer.start();
    }

    private void checkAnswer() {
        if (timer != null) timer.stop();
        String selected = null;
        for (JRadioButton option : options) {
            if (option.isSelected()) {
                selected = option.getText();
                break;
            }
        }
        if (selected != null && questions.get(currentIndex).isCorrect(selected)) {
            score++;
        }
        currentIndex++;
        nextButton.setText("Next");
        loadQuestion();
    }

    private void showResult() {
        frame.getContentPane().removeAll();
        JLabel resultLabel = new JLabel("Your score: " + score + "/" + questions.size(), JLabel.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
        JButton retryButton = new JButton("Retry");

        retryButton.addActionListener(e -> {
            currentIndex = 0;
            score = 0;
            questions = QuestionLoader.loadQuestions("gk_questions_550_final.csv");
            frame.getContentPane().removeAll();
            frame.setLayout(new BorderLayout());
            frame.add(questionLabel, BorderLayout.NORTH);

            JPanel centerPanel = new JPanel(new GridLayout(4, 1));
            for (int i = 0; i < 4; i++) {
                centerPanel.add(options[i]);
            }
            frame.add(centerPanel, BorderLayout.CENTER);

            JPanel bottomPanel = new JPanel();
            bottomPanel.add(nextButton);
            frame.add(bottomPanel, BorderLayout.SOUTH);
            frame.revalidate();
            frame.repaint();
            loadQuestion();
        });

        frame.setLayout(new BorderLayout());
        frame.add(resultLabel, BorderLayout.CENTER);
        frame.add(retryButton, BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args) {
        new QuizGame();
    }
}
