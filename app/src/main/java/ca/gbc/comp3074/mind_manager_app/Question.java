package ca.gbc.comp3074.mind_manager_app;

import java.util.ArrayList;
import java.util.List;

public class Question{
    private int _id;
    private String questionText;
    private ArrayList<Answer> answers;

    public Question(int _id, String questionText, ArrayList<Answer> answers) {
        this._id = _id;
        this.questionText = questionText;
        this.answers = answers;
    }

    public int getID() {
        return _id;
    }

    public void setID(int _id) {
        this._id = _id;
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
