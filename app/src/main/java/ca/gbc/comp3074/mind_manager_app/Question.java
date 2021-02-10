package ca.gbc.comp3074.mind_manager_app;

import java.util.ArrayList;
import java.util.List;

public class Question{
    private String questionText;
    private ArrayList<Answer> answers;

    public Question() {
    }

    public Question(String questionText, ArrayList answers) {
        this.questionText = questionText;
        this.answers = answers;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }
}
