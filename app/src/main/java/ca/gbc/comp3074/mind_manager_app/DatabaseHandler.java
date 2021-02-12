package ca.gbc.comp3074.mind_manager_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
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
    private static final String KEY_ANSWER1 = "answer1";
    private static final String KEY_ANSWER2 = "answer2";
    private static final String KEY_ANSWER3 = "answer3";
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
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_QUESTION_TEXT + " TEXT," + KEY_ANSWER1 + " TEXT," + KEY_ANSWER2 + " TEXT,"+ KEY_ANSWER3 + " TEXT" + ")";

    private static final String CREATE_SUGGESTIONS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_SUGGESTIONS + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_MOOD + " TEXT," + KEY_CATEGORY + " TEXT," + KEY_SUGGESTION + " TEXT" + ")";

    private static final String CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_USERS + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_ROLE + " TEXT," + KEY_USER_NAME + " TEXT," +
            KEY_FIRST_NAME + " TEXT," + KEY_PASSWORD + " TEXT" + ")";

    //Create starting rows
    //Add questions
    private static final String ADD_Q1 = "INSERT INTO " + TABLE_QUESTIONS + " VALUES('0', 'Do I feel like I want to be alone right now?', 'Yes', 'No', 'I`m fine either way');";
    private static final String ADD_Q2 = "INSERT INTO " + TABLE_QUESTIONS + " VALUES('1', 'Did someone get on my nerves today?', 'Yes', 'No', 'A little bit');";
    private static final String ADD_Q3 = "INSERT INTO " + TABLE_QUESTIONS + " VALUES('2', 'I am full of energy.', 'Yes', 'No', 'I feel like I could literally bounce off the walls');";
    private static final String ADD_Q4 = "INSERT INTO " + TABLE_QUESTIONS + " VALUES('3', 'I feel like going outside.', 'Yes', 'No', 'Yes, but I`m lazy');";

    //Calmer Suggestions
    private static final String ADD_SUGG_CALMER1 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('0', 'Calmer', 'Music', 'Lemon Tree - Fools Garden');";
    private static final String ADD_SUGG_CALMER2 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('1', 'Calmer', 'Sport', 'Yoga');";
    private static final String ADD_SUGG_CALMER3 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('2', 'Calmer', 'Outdoors', 'Go for fishing');";
    private static final String ADD_SUGG_CALMER4 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('3', 'Calmer', 'Games', 'Bubble shooter');";
    private static final String ADD_SUGG_CALMER5 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('4', 'Calmer', 'Reading', 'Of all bodily functions that could be contagious, thank God it`s THE YAWN - Unknown');";
    private static final String ADD_SUGG_CALMER6 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('5', 'Calmer', 'Music', 'Lost & Found - MacKenzie Bourg');";
    private static final String ADD_SUGG_CALMER7 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('6', 'Calmer', 'Sport', 'Swimming');";
    private static final String ADD_SUGG_CALMER8 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('7', 'Calmer', 'Outdoors', 'Ride a Bike');";
    private static final String ADD_SUGG_CALMER9 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('8', 'Calmer', 'Games', 'Tetris');";

    //Energetic Suggestions
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

    //Happier Suggestions
    private static final String ADD_SUGG_HAPPIER1 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('19', 'Happier', 'Music', 'I Feel Good - James Brown');";
    private static final String ADD_SUGG_HAPPIER2 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('20', 'Happier', 'Sport', 'Paint-Ball');";
    private static final String ADD_SUGG_HAPPIER3 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('21', 'Happier', 'Outdoors', 'Meet with friends');";
    private static final String ADD_SUGG_HAPPIER4 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('22', 'Happier', 'Games', 'Fortnight');";
    private static final String ADD_SUGG_HAPPIER5 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('23', 'Happier', 'Reading', 'Diary of a Wimpy Kid');";
    private static final String ADD_SUGG_HAPPIER6 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('24', 'Happier', 'Music', 'Who`s Laughing Now - Ava Max');";
    private static final String ADD_SUGG_HAPPIER7 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('25', 'Happier', 'Sport', 'Laser Tag');";
    private static final String ADD_SUGG_HAPPIER8 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('26', 'Happier', 'Outdoors', 'Go to the park');";
    private static final String ADD_SUGG_HAPPIER9 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('27', 'Happier', 'Games', 'UNO');";
    private static final String ADD_SUGG_HAPPIER10 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('28', 'Happier', 'Reading', 'Happiness is a direction, not a place.');";

    //Moody Suggestions
    private static final String ADD_SUGG_MOODY1 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('29', 'Moody', 'Music', 'Summertime Sadness - Lana Del Rey');";
    private static final String ADD_SUGG_MOODY2 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('30', 'Moody', 'Sport', 'Walk in park');";
    private static final String ADD_SUGG_MOODY3 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('31', 'Moody', 'Outdoors', 'Go outside and buy something for yourself');";
    private static final String ADD_SUGG_MOODY4 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('32', 'Moody', 'Games', 'Chess');";
    private static final String ADD_SUGG_MOODY5 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('33', 'Moody', 'Reading', 'There are two sides on every coin,\nThe heads and the tails.\nSo must it be with all in this life,\nDuality and perfect balance, all entails.');";
    private static final String ADD_SUGG_MOODY6 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('34', 'Moody', 'Music', 'Exile - Taylor Swift');";
    private static final String ADD_SUGG_MOODY7 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('35', 'Moody', 'Sport', 'Swimming');";
    private static final String ADD_SUGG_MOODY8 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('36', 'Moody', 'Outdoors', 'Walk in the park');";
    private static final String ADD_SUGG_MOODY9 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('37', 'Moody', 'Games', 'The Sims');";
    private static final String ADD_SUGG_MOODY10 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('38', 'Moody', 'Reading', 'The Fault in Our Starts - John Green');";

    //Relaxed Suggestions
    private static final String ADD_SUGG_RELAXED1 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('39', 'Relaxed', 'Music', 'Weightless - Macaroni Uniony');";
    private static final String ADD_SUGG_RELAXED2 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('40', 'Relaxed', 'Sport', 'None');";
    private static final String ADD_SUGG_RELAXED3 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('41', 'Relaxed', 'Outdoors', 'Massage therapy');";
    private static final String ADD_SUGG_RELAXED4 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('42', 'Relaxed', 'Games', 'Monopoly One');";
    private static final String ADD_SUGG_RELAXED5 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('43', 'Relaxed', 'Reading', 'Time says “Let there be”\nevery moment and instantly\nthere is space and the radiance\nof each bright galaxy.');";
    private static final String ADD_SUGG_RELAXED6 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('44', 'Relaxed', 'Music', 'Broken Hands of Mine - Joe Brooks');";
    private static final String ADD_SUGG_RELAXED7 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('45', 'Relaxed', 'Sport', 'Yoga');";
    private static final String ADD_SUGG_RELAXED8 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('46', 'Relaxed', 'Outdoors', 'Sit on a bench in the park');";
    private static final String ADD_SUGG_RELAXED9 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('47', 'Relaxed', 'Games', 'Bubble Shooter');";
    private static final String ADD_SUGG_RELAXED10 = "INSERT INTO " + TABLE_SUGGESTIONS + " VALUES('48', 'Relaxed', 'Reading', 'Well God knows my feet, they aching\nAnd I`ve got a mountains ahead to climb\nOne way at a time\nI will try\nTo let these broken hands of mine\nGive me strength, be my light... - Broken Hands of Mine');";

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

        db.execSQL(ADD_SUGG_HAPPIER1);
        db.execSQL(ADD_SUGG_HAPPIER2);
        db.execSQL(ADD_SUGG_HAPPIER3);
        db.execSQL(ADD_SUGG_HAPPIER4);
        db.execSQL(ADD_SUGG_HAPPIER5);
        db.execSQL(ADD_SUGG_HAPPIER6);
        db.execSQL(ADD_SUGG_HAPPIER7);
        db.execSQL(ADD_SUGG_HAPPIER8);
        db.execSQL(ADD_SUGG_HAPPIER9);
        db.execSQL(ADD_SUGG_HAPPIER10);

        db.execSQL(ADD_SUGG_MOODY1);
        db.execSQL(ADD_SUGG_MOODY2);
        db.execSQL(ADD_SUGG_MOODY3);
        db.execSQL(ADD_SUGG_MOODY4);
        db.execSQL(ADD_SUGG_MOODY5);
        db.execSQL(ADD_SUGG_MOODY6);
        db.execSQL(ADD_SUGG_MOODY7);
        db.execSQL(ADD_SUGG_MOODY8);
        db.execSQL(ADD_SUGG_MOODY9);
        db.execSQL(ADD_SUGG_MOODY10);

        db.execSQL(ADD_SUGG_RELAXED1);
        db.execSQL(ADD_SUGG_RELAXED2);
        db.execSQL(ADD_SUGG_RELAXED3);
        db.execSQL(ADD_SUGG_RELAXED4);
        db.execSQL(ADD_SUGG_RELAXED5);
        db.execSQL(ADD_SUGG_RELAXED6);
        db.execSQL(ADD_SUGG_RELAXED7);
        db.execSQL(ADD_SUGG_RELAXED8);
        db.execSQL(ADD_SUGG_RELAXED9);
        db.execSQL(ADD_SUGG_RELAXED10);

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

    // code to get the single suggestion
    Question getQuestion() {
        SQLiteDatabase db = this.getReadableDatabase();
        Question questionExist = null;
        try (Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_QUESTIONS +
                " ORDER BY RANDOM() LIMIT 1", null);) {
            while (cursor.moveToNext()) {
                if (cursor.isFirst()) {
                    questionExist = new Question(Integer.parseInt(cursor.getString(0)),
                            cursor.getString(1), cursor.getString(2),
                            cursor.getString(3), cursor.getString(4));
                }
            }
        }
        // return user
        return questionExist;
    }

    // code to get the single suggestion
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
        // return suggestion
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