package ca.gbc.comp3074.mind_manager_app;

import java.util.ArrayList;
import java.util.List;

public class Question{
    private int _id;
    private String questionText;
    private ArrayList<Answer> answers;
    private int iconIdView;
    private int iconIdDel;

    public Question(int id, String questionText, ArrayList<Answer> answers) {
        this._id = id;
        this.questionText = questionText;
        this.answers = answers;
    }

    public Question(int id, String questionText, int iconIdView, int iconIdDel) {
        this._id = id;
        this.questionText = questionText;
        this.iconIdView = iconIdView;
        this.iconIdDel = iconIdDel;
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

    public int getIconIdView() {
        return iconIdView;
    }

    public void setIconIdView(int iconIdView) {
        this.iconIdView = iconIdView;
    }

    public int getIconIdDel() {
        return iconIdDel;
    }

    public void setIconIdDel(int iconIdDel) {
        this.iconIdDel = iconIdDel;
    }
}
