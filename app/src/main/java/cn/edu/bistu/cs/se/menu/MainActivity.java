package cn.edu.bistu.cs.se.menu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        TextView textNam=(TextView)findViewById(R.id.textNam);
        registerForContextMenu(textNam);  //注册上下文菜单
        TextView textClas=(TextView)findViewById(R.id.textClas);
        registerForContextMenu(textClas);//注册上下文菜单

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){  //处理选项菜单单击事件
            case R.id.action_settings:
                Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_optm1:
                Toast.makeText(this, "OptionMenu1", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {//创建上下文菜单
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contnetmenu, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {//实现上下文菜单选择事件
        switch (item.getItemId()) {
            case R.id.ctntmenu1:
                Toast.makeText(this, "ContentMenu1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ctntmenu2:
                Toast.makeText(this, "ContentMenu2", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
    public void showPopMenu(View v){
        PopupMenu popm = new PopupMenu(this, v);
        popm.setOnMenuItemClickListener(this);
        popm.inflate(R.menu.popmenu);
        popm.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) { //实现弹出菜单
        switch (item.getItemId()) {
            case R.id.pop_menu1:
                Toast.makeText(this, "PopMenu1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pop_menu2:
                Toast.makeText(this, "PopMenu2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pop_menu3:
                Toast.makeText(this, "PopMenu3", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}
