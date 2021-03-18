package ca.gbc.comp3074.mind_manager_app;

public class BookInfo {


    // creating string, int and array list
    // variables for our book details
    private String title;
    //  private ArrayList<String> authors;


    // creating getter and setter methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


//
//    public ArrayList<String> getAuthors() {
//        return authors;
//    }
//
//    public void setAuthors(ArrayList<String> authors) {
//        this.authors = authors;
//    }


    // creating a constructor class for our BookInfo
    public BookInfo(String title) {
        this.title = title;
        //this.authors = authors;

    }

}
