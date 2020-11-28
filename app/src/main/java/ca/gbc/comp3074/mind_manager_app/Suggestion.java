package ca.gbc.comp3074.mind_manager_app;

import io.realm.RealmObject;

public class Suggestion extends RealmObject {

    private String categoryName;
    private String suggestionName;

    public Suggestion(String categoryName, String suggestionName) {
        this.categoryName = categoryName;
        this.suggestionName = suggestionName;
    }

    public Suggestion() {
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
