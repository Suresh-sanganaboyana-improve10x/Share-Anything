package com.example.shareanything;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.shareanything.databinding.ActivityShareBinding;

public class ShareActivity extends AppCompatActivity {

    private ActivityShareBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShareBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        handleShareFunctionality();
    }

    private void handleShareFunctionality() {
        binding.shareBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            EditText typeText = findViewById(R.id.type_txt);
            String str = typeText.getText().toString();
            String sub = "Your Subject";
            intent.putExtra(Intent.EXTRA_SUBJECT, sub);
            intent.putExtra(Intent.EXTRA_TEXT, str);
            startActivity(Intent.createChooser(intent, "Share Using"));
        });
    }
}