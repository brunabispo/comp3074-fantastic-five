package ca.gbc.comp3074.mind_manager_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mindManager";

    // Table Names
    private static final String TABLE_ANSWERS = "answers";
    private static final String TABLE_QUESTIONS = "questions";
    private static final String TABLE_SUGGESTIONS = "suggestions";
    private static final String TABLE_USERS = "users";

    private static final String KEY_ID = "id";

    // ANSWERS Table - column names
    private static final String KEY_ANSWER_TEXT = "answer_text";
    private static final String KEY_BORED = "bored_rating";
    private static final String KEY_ENERGETIC = "energetic_rating";
    private static final String KEY_HAPPY = "happy_rating";
    private static final String KEY_SAD = "sad_rating";
    private static final String KEY_TIRED = "tired_rating";

    // QUESTIONS Table - column names
    private static final String KEY_QUESTION_TEXT = "question_text";
    //private static final String KEY_ANSWER = "user_name";
    //private ArrayList<Answer> answers;

    // SUGGESTIONS Table - column names
    private static final String KEY_MOOD = "mood";
    private static final String KEY_CATEGORY = "category_name";
    private static final String KEY_SUGGESTION = "suggestion_name";

    // USERS Table - column names
    private static final String KEY_ROLE = "role";
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_PASSWORD = "password";

    //Create tables
    private static final String CREATE_ANSWERS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_ANSWERS + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_ANSWER_TEXT + " TEXT," + KEY_BORED + " TEXT," +
            KEY_ENERGETIC + " TEXT," + KEY_HAPPY + " TEXT," + KEY_SAD + " TEXT," + KEY_TIRED + " TEXT" + ")";

    private static final String CREATE_QUESTIONS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTIONS + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_QUESTION_TEXT + " TEXT" + ")";

    private static final String CREATE_SUGGESTIONS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_SUGGESTIONS + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_MOOD + " TEXT," + KEY_CATEGORY + " TEXT," + KEY_SUGGESTION + " TEXT" + ")";

    private static final String CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_USERS + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_ROLE + " TEXT," + KEY_USER_NAME + " TEXT," +
            KEY_FIRST_NAME + " TEXT," + KEY_PASSWORD + " TEXT" + ")";

    //Create starting rows
    //Add questions
    private static final String ADD_Q1 = "INSERT INTO " + TABLE_QUESTIONS + " VALUES('0', 'Do I feel like I want to be alone right now?');";
    private static final String ADD_Q2 = "INSERT INTO " + TABLE_QUESTIONS + " VALUES('1', 'Did someone get on my nerves today?');";
    private static final String ADD_Q3 = "INSERT INTO " + TABLE_QUESTIONS + " VALUES('2', 'I am full of energy.');";
    private static final String ADD_Q4 = "INSERT INTO " + TABLE_QUESTIONS + " VALUES('3', 'I feel like going outside.');";

    //add Calmer Suggestions
    private static final String ADD_SUGG_CALMER1 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('0', 'Calmer', 'Music', 'Lemon Tree - Fools Garden');";
    private static final String ADD_SUGG_CALMER2 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('1', 'Calmer', 'Sport', 'Yoga');";
    private static final String ADD_SUGG_CALMER3 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('2', 'Calmer', 'Outdoors', 'Go for fishing');";
    private static final String ADD_SUGG_CALMER4 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('3', 'Calmer', 'Games', 'Bubble shooter');";
    private static final String ADD_SUGG_CALMER5 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('4', 'Calmer', 'Reading', 'Of all bodily functions that could be contagious, thank God it is THE YAWN - Unknown');";
    private static final String ADD_SUGG_CALMER6 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('5', 'Calmer', 'Music', 'Lost & Found - MacKenzie Bourg');";
    private static final String ADD_SUGG_CALMER7 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('6', 'Calmer', 'Sport', 'Swimming');";
    private static final String ADD_SUGG_CALMER8 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('7', 'Calmer', 'Outdoors', 'Ride a Bike');";
    private static final String ADD_SUGG_CALMER9 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('8', 'Calmer', 'Games', 'Tetris');";

    private static final String ADD_SUGG_ENERGETIC1 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('9', 'Energetic', 'Music', 'Play Hard - David Guetta');";
    private static final String ADD_SUGG_ENERGETIC2 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('10', 'Energetic', 'Sport', 'Lazer-Tag');";
    private static final String ADD_SUGG_ENERGETIC3 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('11', 'Energetic', 'Outdoors', 'Go for a Run');";
    private static final String ADD_SUGG_ENERGETIC4 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('12', 'Energetic', 'Games', 'Just Dance');";
    private static final String ADD_SUGG_ENERGETIC5 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('13', 'Energetic', 'Reading', 'Hunger Games');";
    private static final String ADD_SUGG_ENERGETIC6 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('14', 'Energetic', 'Music', 'Don`t Say Goodbye - Alok');";
    private static final String ADD_SUGG_ENERGETIC7 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('15', 'Energetic', 'Sport', 'Running');";
    private static final String ADD_SUGG_ENERGETIC8 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('16', 'Energetic', 'Outdoors', 'Paint-ball');";
    private static final String ADD_SUGG_ENERGETIC9 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('17', 'Energetic', 'Games', 'Hide and Seek');";
    private static final String ADD_SUGG_ENERGETIC10 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('18', 'Energetic', 'Reading', 'Harry Potter and The Goblet of Fire');";

    private static final String ADD_ADMIN = "INSERT INTO " + TABLE_USERS + " VALUES('0', 'admin', 'benjeff', 'Ben', '123_Ben');";
    private static final String ADD_USER = "INSERT INTO " + TABLE_USERS + " VALUES('1', 'user', 'evgeniya', 'Evgeniya', '123_Ben');";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ANSWERS_TABLE);
        db.execSQL(CREATE_QUESTIONS_TABLE);
        db.execSQL(CREATE_SUGGESTIONS_TABLE);
        db.execSQL(CREATE_USERS_TABLE);

        db.execSQL(ADD_Q1);
        db.execSQL(ADD_Q2);
        db.execSQL(ADD_Q3);
        db.execSQL(ADD_Q4);

        db.execSQL(ADD_SUGG_CALMER1);
        db.execSQL(ADD_SUGG_CALMER2);
        db.execSQL(ADD_SUGG_CALMER3);
        db.execSQL(ADD_SUGG_CALMER4);
        db.execSQL(ADD_SUGG_CALMER5);
        db.execSQL(ADD_SUGG_CALMER6);
        db.execSQL(ADD_SUGG_CALMER7);
        db.execSQL(ADD_SUGG_CALMER8);
        db.execSQL(ADD_SUGG_CALMER9);

        db.execSQL(ADD_SUGG_ENERGETIC1);
        db.execSQL(ADD_SUGG_ENERGETIC2);
        db.execSQL(ADD_SUGG_ENERGETIC3);
        db.execSQL(ADD_SUGG_ENERGETIC4);
        db.execSQL(ADD_SUGG_ENERGETIC5);
        db.execSQL(ADD_SUGG_ENERGETIC6);
        db.execSQL(ADD_SUGG_ENERGETIC7);
        db.execSQL(ADD_SUGG_ENERGETIC8);
        db.execSQL(ADD_SUGG_ENERGETIC9);
        db.execSQL(ADD_SUGG_ENERGETIC10);

        db.execSQL(ADD_ADMIN);
        db.execSQL(ADD_USER);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANSWERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUGGESTIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        // Create tables again
        onCreate(db);
    }

    // code to add the new user
    void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ROLE, user.getRole()); // User Role
        values.put(KEY_USER_NAME, user.getUserName()); // UserName
        values.put(KEY_FIRST_NAME, user.getFirstName()); // First Name
        values.put(KEY_PASSWORD, user.getPassword()); // Password

        // Inserting Row
        db.insert(TABLE_USERS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    // code to get the single user
    Suggestion getSuggestion(String mood, String category) {
        SQLiteDatabase db = this.getReadableDatabase();
        Suggestion suggestionExist = null;
        try (Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_SUGGESTIONS + " WHERE " +
                KEY_MOOD + " IN ('" + mood + "') " + " AND " + KEY_CATEGORY + " IN ('" + category +
                "') ORDER BY RANDOM() LIMIT 1", null);) {
            while (cursor.moveToNext()) {
                if (cursor.isFirst()) {
                    suggestionExist = new Suggestion(Integer.parseInt(cursor.getString(0)),
                            cursor.getString(1), cursor.getString(2), cursor.getString(3));
                }
            }
        }
        // return user
        return suggestionExist;
    }

    // code to get the single user
    User getUser(String userName) {
        SQLiteDatabase db = this.getReadableDatabase();
        User userExist = null;
        try (Cursor cursor = db.query(TABLE_USERS, new String[]{KEY_ID, KEY_ROLE,
                        KEY_USER_NAME, KEY_FIRST_NAME, KEY_PASSWORD}, KEY_USER_NAME + "=?",
                new String[]{String.valueOf(userName)}, null, null, null, null)) {
            while (cursor.moveToNext()) {
                if (cursor.isFirst()) {
                    userExist = new User(Integer.parseInt(cursor.getString(0)),
                            cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
                }
            }
        }
        // return user
        return userExist;
    }

    // code to get all users in a list view
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<User>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_USERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setID(Integer.parseInt(cursor.getString(0)));
                user.setRole(cursor.getString(1));
                user.setUserName(cursor.getString(2));
                user.setFirstName(cursor.getString(3));
                user.setPassword(cursor.getString(4));
                // Adding user to list
                userList.add(user);
            } while (cursor.moveToNext());
        }

        // return user list
        return userList;
    }

    // code to update the single user
    public int updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ROLE, user.getRole());
        values.put(KEY_USER_NAME, user.getUserName());
        values.put(KEY_FIRST_NAME, user.getFirstName());
        values.put(KEY_PASSWORD, user.getPassword());

        // updating row
        return db.update(TABLE_USERS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(user.getID()) });
    }

    // Deleting single user
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, KEY_ID + " = ?",
                new String[] { String.valueOf(user.getID()) });
        db.close();
    }

    // Getting users Count
    public int getUsersCount() {
        String countQuery = "SELECT  * FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
}