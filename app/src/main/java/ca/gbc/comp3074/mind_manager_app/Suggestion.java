package ca.gbc.comp3074.mind_manager_app;

public class Suggestion {

    private int _id;
    private String mood;
    private String categoryName;
    private String suggestionName;

    public Suggestion() {
    }

    public Suggestion(String mood, String categoryName, String suggestionName) {
        this.mood = mood;
        this.categoryName = categoryName;
        this.suggestionName = suggestionName;
    }

    public Suggestion(int id, String mood, String categoryName, String suggestionName) {
        this._id = id;
        this.mood = mood;
        this.categoryName = categoryName;
        this.suggestionName = suggestionName;
    }

    public int getID() {
        return _id;
    }

    public void setID(int _id) {
        this._id = _id;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSuggestionName() {
        return suggestionName;
    }

    public void setSuggestionName(String suggestionName) {
        this.suggestionName = suggestionName;
    }
}