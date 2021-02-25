package ca.gbc.comp3074.mind_manager_app;

public class Answer{

    private int _id;
    private int question_id;
    private String text;
    private int boredRating;
    private int energeticRating;
    private int happyRating;
    private int sadRating;
    private int tiredRating;

    public Answer(int id, int question_id, String text, int boredRating, int energeticRating, int happyRating, int sadRating, int tiredRating) {
        this._id = id;
        this.question_id = question_id;
        this.text = text;
        this.boredRating = boredRating;
        this.energeticRating = energeticRating;
        this.happyRating = happyRating;
        this.sadRating = sadRating;
        this.tiredRating = tiredRating;
    }

    public int getID() {
        return _id;
    }

    public void setID(int _id) {
        this._id = _id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getBoredRating() {
        return boredRating;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public void setBoredRating(int boredRating) {
        this.boredRating = boredRating;
    }

    public int getEnergeticRating() {
        return energeticRating;
    }

    public void setEnergeticRating(int energeticRating) {
        this.energeticRating = energeticRating;
    }

    public int getHappyRating() {
        return happyRating;
    }

    public void setHappyRating(int happyRating) {
        this.happyRating = happyRating;
    }

    public int getSadRating() {
        return sadRating;
    }

    public void setSadRating(int sadRating) {
        this.sadRating = sadRating;
    }

    public int getTiredRating() {
        return tiredRating;
    }

    public void setTiredRating(int tiredRating) {
        this.tiredRating = tiredRating;
    }
}