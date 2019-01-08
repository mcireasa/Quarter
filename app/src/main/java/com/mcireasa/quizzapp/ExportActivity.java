package com.mcireasa.quizzapp;

import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mcireasa.quizzapp.Model.Test;
import com.mcireasa.quizzapp.database.DatabaseRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportActivity extends AppCompatActivity {


    DatabaseRepository databaseRepository;


    @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_export);
   }

   public void onWriteToFileButtonClick(View view) {
      try {


          databaseRepository = new DatabaseRepository(getApplicationContext());
          databaseRepository.open();

          List<Test> listaTeste = databaseRepository.getTests();



         File testFile = new File(this.getExternalFilesDir(null), "Tests.csv");
         if (!testFile.exists())
            testFile.createNewFile();
         BufferedWriter writer = new BufferedWriter(new FileWriter(testFile, true /*append*/));


         for(int i=0;i<listaTeste.size(); i++){
             String line = listaTeste.get(i).getText() + "," +  listaTeste.get(i).getCode() + "\n";
             writer.write(line);
         }

         writer.close();

         MediaScannerConnection.scanFile(this,
                 new String[]{testFile.toString()},
                 null,
                 null);
      } catch (IOException e) {
         Log.e("ReadWriteFile", "Unable to write to the Tests.csv file.");
      }
      Log.v("ReadWriteFile", "Write to Tests.csv file.");
   }

   public void onReadFromFileButtonClick(View view) {
      String textToDisplay = "";
      TextView FileContentTextView = (TextView) findViewById(R.id.tv_file_content);

      File testFile = new File(this.getExternalFilesDir(null), "Tests.csv");
      if (testFile == null) {
         FileContentTextView.setText(textToDisplay);
         return;
      }

      StringBuilder stringBuilder = new StringBuilder();
      BufferedReader reader = null;
      try {
         reader = new BufferedReader(new FileReader(testFile));
         String line;

         while ((line = reader.readLine()) != null) {
            textToDisplay += line.toString();
            textToDisplay += "\n";
         }
         reader.close();
      } catch (Exception e) {
         Log.e("ReadWriteFile", "Unable to read the Tests.csv file.");
      }
      Log.v("ReadWriteFile", "Read from Tests.csv file.");

      FileContentTextView.setText(textToDisplay);
   }
}
