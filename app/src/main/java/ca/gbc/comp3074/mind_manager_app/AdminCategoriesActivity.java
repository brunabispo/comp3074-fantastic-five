package ca.gbc.comp3074.mind_manager_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_categories);

        Button btnViewCategoryOne = findViewById(R.id.btnAdminViewCategoryOne);
        Button btnViewCategoryTwo = findViewById(R.id.btnAdminViewCategoryTwo);
        Button btnViewCategoryThree = findViewById(R.id.btnAdminViewCategoryThree);
        Button btnAddNewCategory = findViewById(R.id.btnAddCategory);
        Button btnLogout = findViewById(R.id.btnLogoutAdminCategories);

        btnViewCategoryOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionOne();
            }
        });

        btnViewCategoryTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionTwo();
            }
        });

        btnViewCategoryThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionThree();
            }
        });

        btnAddNewCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewCategory();
            }
        });
    }

    private void openQuestionOne(){

    }

    private void openQuestionTwo(){

    }

    private void openQuestionThree(){

    }

    private void openNewCategory(){

    }

}
