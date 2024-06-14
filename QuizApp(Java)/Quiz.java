
/**
 * Quiz
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Quiz {
    private ArrayList<Question> questions;
    private int score;
    private int currentQuestionIndex;

    private JFrame frame;
    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup optionsGroup;
    private JButton nextButton;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        currentQuestionIndex = 0;

        // Setup GUI components
        frame = new JFrame("Quiz Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        questionLabel = new JLabel("Question", SwingConstants.CENTER);
        frame.add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1));
        optionButtons = new JRadioButton[4];
        optionsGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionsGroup.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }
        frame.add(optionsPanel, BorderLayout.CENTER);

        nextButton = new JButton("Next");
        nextButton.addActionListener(new NextButtonListener());
        frame.add(nextButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.addQuestion(new Question("What is the capital of France?",
                new String[] { "Paris", "London", "Berlin", "Madrid" }, 0));
        quiz.addQuestion(new Question("What is 2 + 2?",
                new String[] { "3", "4", "5", "6" }, 1));
        quiz.start();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void start() {
        showQuestion();
        frame.setVisible(true);
    }

    private void showQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            questionLabel.setText(currentQuestion.getQuestionText());
            String[] options = currentQuestion.getOptions();
            for (int i = 0; i < options.length; i++) {
                optionButtons[i].setText(options[i]);
                optionButtons[i].setSelected(false);
            }
        } else {
            showResult();
        }
    }

    private void showResult() {
        questionLabel.setText("Your score: " + score + "/" + questions.size());
        for (JRadioButton button : optionButtons) {
            button.setVisible(false);
        }
        nextButton.setVisible(false);
    }

    private class NextButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            for (int i = 0; i < optionButtons.length; i++) {
                if (optionButtons[i].isSelected() && i == currentQuestion.getCorrectAnswerIndex()) {
                    score++;
                }
            }
            currentQuestionIndex++;
            showQuestion();
        }
    }

}