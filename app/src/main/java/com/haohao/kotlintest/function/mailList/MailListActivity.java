

package com.haohao.kotlintest.function.mailList;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.haohao.kotlintest.R;
import com.haohao.kotlintest.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

/**
 * 获取联系人列表 通讯录   动态权限申请 getContentResolver 内容提供者
 */
public class MailListActivity extends AppCompatActivity {

    private ArrayAdapter<String> mAdapter;
    private List<String> mContactsList = new ArrayList<>();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_list);
        context = this;

        ListView listView = findViewById(R.id.list_view);
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mContactsList);
        listView.setAdapter(mAdapter);


        Button button = findViewById(R.id.btn_mail_list);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MailListActivity.this,new String[]{Manifest.permission.READ_CONTACTS},1);
                }else {
                    readContacts();
                }
            }
        });
    }

    private void readContacts(){
        try (Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, null)) {
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    mContactsList.add(displayName + "\n" + number);
                }
                mAdapter.notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==1){
            if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                readContacts();
            }else {
                ToastUtils.INSTANCE.showShort(context,"you denied the permission");
            }
        }
    }
}
