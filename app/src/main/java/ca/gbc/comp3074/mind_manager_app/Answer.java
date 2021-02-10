package ca.gbc.comp3074.mind_manager_app;

public class Answer{
    String text;
    int boredRating;
    int energeticRating;
    int happyRating;
    int sadRating;
    int tiredRating;

    public Answer() {
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


