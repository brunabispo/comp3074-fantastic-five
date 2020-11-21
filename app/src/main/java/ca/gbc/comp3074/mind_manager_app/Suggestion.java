package ca.gbc.comp3074.mind_manager_app;

public class Suggestion {

    private String categotyName;
    private String suggestionName;

    public Suggestion(String categotyName, String suggestionName) {
        this.categotyName = categotyName;
        this.suggestionName = suggestionName;
    }

    public String getCategotyName() {
        return categotyName;
    }

    public void setCategotyName(String categotyName) {
        this.categotyName = categotyName;
    }

    public String getSuggestionName() {
        return suggestionName;
    }

    public void setSuggestionName(String suggestionName) {
        this.suggestionName = suggestionName;
    }
}
