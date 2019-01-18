package com.nonexistentware.igor.demoquiz.DbHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nonexistentware.igor.demoquiz.Model.Category;
import com.nonexistentware.igor.demoquiz.Model.Question;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteAssetHelper {

    private static final String DB_NAME = "EDMTQuiz2019.db";
    private static final int DB_VER = 1;

    private static DbHelper instance;

    public static synchronized DbHelper getInstance(Context context) {
        if (instance == null)
            instance = new DbHelper(context);
        return instance;
    }

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    public List<Category> getAllCategories() {
        SQLiteDatabase db = instance.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Category", null);
        List<Category> categories = new ArrayList<>();
        if (cursor.moveToNext()) {
            while (!cursor.isAfterLast()) {
                Category category = new Category(cursor.getInt(cursor.getColumnIndex("ID")),
                        cursor.getString(cursor.getColumnIndex("Name")),
                        cursor.getString(cursor.getColumnIndex("Image")));
                categories.add(category);
                cursor.moveToNext();
            }
        }

        cursor.close();
        db.close();

        return categories;
    }

    public List<Question> getQuestionCategory(int category) {
        SQLiteDatabase db = instance.getWritableDatabase();
        Cursor cursor = db.rawQuery(String.format("SELECT * FROM Question WHERE CategoryID = %d ORDER BY RANDOM() LIMIT 30", category), null);
        List<Question> questions = new ArrayList<>();
        if (cursor.moveToNext()) {
            while (!cursor.isAfterLast()) {
                Question question = new Question(cursor.getInt(cursor.getColumnIndex("ID")),
                        cursor.getString(cursor.getColumnIndex("QuestionText")),
                        cursor.getString(cursor.getColumnIndex("QuestionImage")),
                        cursor.getString(cursor.getColumnIndex("AnswerA")),
                        cursor.getString(cursor.getColumnIndex("AnswerB")),
                        cursor.getString(cursor.getColumnIndex("AnswerC")),
                        cursor.getString(cursor.getColumnIndex("AnswerD")),
                        cursor.getString(cursor.getColumnIndex("CorrectAnswer")),
                        cursor.getInt(cursor.getColumnIndex("IsImageQuestion")),
                        cursor.getInt(cursor.getColumnIndex("CategoryID")));
                questions.add(question);
                cursor.moveToNext();
            }
        }

        cursor.close();
        db.close();

        return questions;
    }
}
