package ca.gbc.comp3074.mind_manager_app;

public class Question{

    private int _id;
    private String questionText;
    private String answer1;
    private String answer2;
    private String answer3;
    //private ArrayList<Answer> answers;

    public Question() {
    }

    public Question(String questionText, String answer1, String answer2, String answer3) {
        this.questionText = questionText;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
    }

    public Question(int id, String questionText, String answer1, String answer2, String answer3) {
        this._id = id;
        this.questionText = questionText;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
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

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    /*public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }*/
}