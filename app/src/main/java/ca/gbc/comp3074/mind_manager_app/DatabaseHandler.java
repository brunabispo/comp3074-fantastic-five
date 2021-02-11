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
    private static final String TABLE_USERS = "users";
    private static final String KEY_ID = "id";
    private static final String KEY_ROLE = "role";
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_PASSWORD = "password";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_ROLE + " TEXT," + KEY_USER_NAME + " TEXT," +
                KEY_FIRST_NAME + " TEXT," + KEY_PASSWORD + " TEXT" + ")";
        String ADD_ADMIN = "INSERT INTO " + TABLE_USERS + " VALUES('0', 'admin', 'benjeff', 'Ben', '123_Ben');";
        db.execSQL(CREATE_USERS_TABLE);
        db.execSQL(ADD_ADMIN);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
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
    User getUser(String userName) {
        SQLiteDatabase db = this.getReadableDatabase();
        User userExist = null;
        Cursor cursor = db.query(TABLE_USERS, new String[] { KEY_ID, KEY_ROLE,
                        KEY_USER_NAME, KEY_FIRST_NAME, KEY_PASSWORD }, KEY_USER_NAME + "=?",
                new String[] { String.valueOf(userName) }, null, null, null, null);
        try{
        while(cursor.moveToNext())
        {
            if(cursor.isFirst())
            {
                userExist = new User(Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
            }
        }}
        finally
        {
            if(cursor!= null)
            {
                cursor.close();
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