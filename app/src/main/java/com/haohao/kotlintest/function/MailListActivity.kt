package com.haohao.kotlintest.function

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.haohao.kotlintest.R
import com.haohao.kotlintest.util.ToastUtils.showShort
import java.util.*

/**
 * 获取联系人列表 通讯录   动态权限申请 getContentResolver 内容提供者
 */
class MailListActivity : AppCompatActivity() {
    private var mAdapter: ArrayAdapter<String>? = null
    private val mContactsList: MutableList<String> = ArrayList()
    private var context: Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mail_list)
        context = this
        val listView = findViewById<ListView>(R.id.list_view)
        mAdapter = ArrayAdapter(context!!, android.R.layout.simple_list_item_1, mContactsList)
        listView.adapter = mAdapter
        val button = findViewById<Button>(R.id.btn_mail_list)
        button.setOnClickListener {
            if (ContextCompat.checkSelfPermission(context as MailListActivity, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                //Android 原生动态权限请求
                ActivityCompat.requestPermissions(this@MailListActivity,
                        arrayOf(Manifest.permission.READ_CONTACTS), 1)
            } else {
                readContacts()
            }
        }
    }

    private fun readContacts() {
        try {
            contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                    null, null, null).use { cursor ->
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        // 通过内容提供者 获取通讯录应用的 数据
                        val displayName = cursor.getString(
                                cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                        val number = cursor.getString(
                                cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                        mContactsList.add(displayName + "\n" + number)
                    }
                    mAdapter!!.notifyDataSetChanged()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                readContacts()
            } else {
                showShort(context!!, "you denied the permission")
            }
        }
    }
}