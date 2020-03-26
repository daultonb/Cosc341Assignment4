package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;


public class MyProfile extends AppCompatActivity {
    ImageView viewImage;
    Button b;
    EditText major;
    EditText school;
    EditText hometown;
    EditText bio;
    TextView username;
    Button btn;
    boolean editing = false;

//test comment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);
        Intent myin = getIntent();
        String line = myin.getStringExtra("userinfo");
        String usernamestr = line.substring(0, line.indexOf(","));
        line = line.substring(line.indexOf(",") + 1, line.length());
        String passwordstr = line.substring(0, line.indexOf(","));
        line = line.substring(line.indexOf(",") + 1, line.length());
        String schoolstr = line.substring(0, line.indexOf(","));
        line = line.substring(line.indexOf(",") + 1, line.length());
        String hometownstr = line.substring(0, line.indexOf(","));
        line = line.substring(line.indexOf(",") + 1, line.length());
        String majorstr = line.substring(0, line.indexOf(","));
        line = line.substring(line.indexOf(",") + 1, line.length());
        String biostr = line.substring(0, line.length());

        username = findViewById(R.id.name);
        username.setText(usernamestr);
        major = findViewById(R.id.major1);
        major.setText(majorstr);
        school = findViewById(R.id.school1);
        school.setText(schoolstr);
        hometown = findViewById(R.id.hometown1);
        hometown.setText(hometownstr);
        bio = findViewById(R.id.bio1);
        bio.setText(biostr);
        btn = findViewById(R.id.editprofile);
    }

    public void EditProfile(View v){
        if (!editing){
            major.setEnabled(true);
            school.setEnabled(true);
            hometown.setEnabled(true);
            bio.setEnabled(true);


            major.setTextColor(Color.BLACK);
            school.setTextColor(Color.BLACK);
            hometown.setTextColor(Color.BLACK);
            bio.setTextColor(Color.BLACK);
            btn.setText("Submit");
            btn.setBackgroundColor(Color.GREEN);
            btn.setTextColor(Color.BLACK);
            editing = true;
        }
        else
        {
            major.setEnabled(false);
            school.setEnabled(false);
            hometown.setEnabled(false);
            bio.setEnabled(false);
            major.setTextColor(Color.GRAY);
            school.setTextColor(Color.GRAY);
            hometown.setTextColor(Color.GRAY);
            bio.setTextColor(Color.GRAY);
            btn.setText("Edit Profile");
            btn.setBackgroundColor(Color.LTGRAY);
            btn.setTextColor(Color.BLACK);
            editing = false;
        }

    }

    public void selectImage(View v) {
        b = (Button)v;
        switch(b.getId()){
            case R.id.btn1:
                viewImage = findViewById(R.id.pic1);
                break;
            case R.id.btn2:
                viewImage = findViewById(R.id.pic2);
                break;
            case R.id.btn3:
                viewImage = findViewById(R.id.pic3);
                break;
            case R.id.btn4:
                viewImage = findViewById(R.id.pic4);
                break;
            case R.id.btn5:
                viewImage = findViewById(R.id.pic5);
                break;
            case R.id.btn6:
                viewImage = findViewById(R.id.pic6);
                break;
            default:
                viewImage = findViewById(R.id.pic1);
                break;
        }
        final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(MyProfile.this);
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo"))
                {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                    startActivityForResult(intent, 1);
                }
                else if (options[item].equals("Choose from Gallery"))
                {
                    Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);
                }
                else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {
                    Bitmap bitmap;
                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(),
                            bitmapOptions);
                    viewImage.setImageBitmap(bitmap);
                    String path = android.os.Environment
                            .getExternalStorageDirectory()
                            + File.separator
                            + "Phoenix" + File.separator + "default";
                    f.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    try {
                        outFile = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.PNG, 85, outFile);
                        outFile.flush();
                        outFile.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == 2) {
                Uri selectedImage = data.getData();
                String[] filePath = { MediaStore.Images.Media.DATA };
                Cursor c = getContentResolver().query(selectedImage,filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
                Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
                Log.w("path of image from gallery......******************.........", picturePath+"");
                viewImage.setImageBitmap(thumbnail);
            }
        }
    }

    public void goToSwiping(View v){
        Intent intent = new Intent(this, Swiping.class);
        startActivity(intent);
        }

    public void goToMessages (View v){
        Intent intent = new Intent(this, Connections.class);
        startActivity(intent);
    }

}
