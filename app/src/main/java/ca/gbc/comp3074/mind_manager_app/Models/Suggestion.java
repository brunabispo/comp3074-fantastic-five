package ca.gbc.comp3074.mind_manager_app.Models;

public class Suggestion {

    private int _id;
    private String mood;
    private String categoryName;
    private String suggestionName;
    private String youtubeLink;
    public Suggestion() {
    }

    public Suggestion(String mood, String categoryName, String suggestionName, String youtubeLink) {
        this.mood = mood;
        this.categoryName = categoryName;
        this.suggestionName = suggestionName;
        this.youtubeLink = youtubeLink;
    }

    public Suggestion(String categoryName) {
        this.categoryName = categoryName;
    }

    public Suggestion(int id, String mood, String categoryName, String suggestionName, String youtubeLink) {
        this._id = id;
        this.mood = mood;
        this.categoryName = categoryName;
        this.suggestionName = suggestionName;
        this.youtubeLink = youtubeLink;
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

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }
}