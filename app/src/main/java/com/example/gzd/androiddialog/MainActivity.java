package com.example.gzd.androiddialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonNormal = (Button) findViewById(R.id.button_normal);
        Button buttonList = (Button) findViewById(R.id.button_list);
        Button buttonSingleChoice = (Button) findViewById(R.id.button_single_choice);
        Button buttonMultiChoice = (Button) findViewById(R.id.button_multi_choice);
        Button buttonProgress = (Button) findViewById(R.id.button_progress);
        Button buttonWaiting = (Button) findViewById(R.id.button_waiting);
        Button buttonCustomize = (Button) findViewById(R.id.button_customize);
        Button buttonInput = (Button) findViewById(R.id.button_input);
        Button buttonMultiBtn = (Button) findViewById(R.id.button_multi_btn);

        buttonNormal.setOnClickListener(this);
        buttonMultiBtn.setOnClickListener(this);
        buttonList.setOnClickListener(this);
        buttonSingleChoice.setOnClickListener(this);
        buttonMultiChoice.setOnClickListener(this);
        buttonProgress.setOnClickListener(this);
        buttonWaiting.setOnClickListener(this);
        buttonCustomize.setOnClickListener(this);
        buttonInput.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.button_normal:
                showNormalDialog();
                break;
            case R.id.button_multi_btn:
                showMultiBtnDialog();
                break;
            case R.id.button_list:
                showListDialog();
                break;
            case R.id.button_single_choice:
                showSingleChoiceDialog();
                break;
            case R.id.button_multi_choice:
                showMultiChoiceDialog();
                break;
            case R.id.button_input:
                showInputDialog();
                break;
            case R.id.button_progress:
                showProgressDialog();
                break;
            case R.id.button_waiting:
                showWaitingDialog();
                break;
            case R.id.button_customize:
                showCustomizeDialog();
                break;
            default:
                break;
        }
    }

    private void showInputDialog() {
        final EditText editText = new EditText(MainActivity.this);
        AlertDialog.Builder inputDialog = new AlertDialog.Builder(MainActivity.this);
        inputDialog.setTitle("我是一个输入Dialog").setView(editText);
        inputDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        }).show();
    }

    private void showNormalDialog(){
        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        final AlertDialog.Builder normalDialog = new AlertDialog.Builder(MainActivity.this);
        normalDialog.setIcon(R.drawable.icon_dialog);
        normalDialog.setTitle("我是一个普通Dialog").setMessage("你要点击哪一个按钮呢?");
        normalDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "你点击了确定", Toast.LENGTH_SHORT).show();
            }
        });
        normalDialog.setNegativeButton("关闭", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "你点击了关闭", Toast.LENGTH_SHORT).show();
            }
        });
        // 创建实例并显示
        normalDialog.show();
    }

    private void showMultiBtnDialog(){
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(MainActivity.this);
        normalDialog.setIcon(R.drawable.icon_dialog);
        normalDialog.setTitle("我是一个普通Dialog").setMessage("你要点击哪一个按钮呢?");
        /* setNeutralButton 设置中间的按钮
         * 若只需一个按钮，设置setPositiveButton 即可
         */
        normalDialog.setPositiveButton("按钮1", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "你点击了按钮1", Toast.LENGTH_SHORT).show();
            }
        });
        normalDialog.setNeutralButton("按钮2", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "你点击了按钮2", Toast.LENGTH_SHORT).show();
            }
        });
        normalDialog.setNegativeButton("按钮3", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "你点击了按钮3", Toast.LENGTH_SHORT).show();
            }
        });
        // 创建实例并显示
        normalDialog.show();
    }

private void showListDialog() {
    /* @create 创建实例时调用
     * @show 每次显示时调用
     */
    final String[] items = { "我是1","我是2","我是3","我是4" };
    AlertDialog.Builder listDialog = new AlertDialog.Builder(MainActivity.this){
        @Override
        public AlertDialog create() {
            items[0] = "我是No.1";
            return super.create();
        }

        @Override
        public AlertDialog show() {
            items[1] = "我是No.2";
            return super.show();
        }
    };
    listDialog.setTitle("我是一个列表Dialog");
    listDialog.setItems(items, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            // ...To-do
            //Toast.makeText(MainActivity.this, "你点击了" + items[which], Toast.LENGTH_SHORT).show();
        }
    });
    listDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
        public void onDismiss(DialogInterface dialog) {
            Toast.makeText(getApplicationContext(), "Dialog被销毁了", Toast.LENGTH_SHORT).show();
        }
    });
    listDialog.show();
}

    int yourChoice;
    private void showSingleChoiceDialog(){
        final String[] items = { "我是1","我是2","我是3","我是4" };
        yourChoice = -1;
        AlertDialog.Builder singleChoiceDialog = new AlertDialog.Builder(MainActivity.this);
        singleChoiceDialog.setTitle("我是一个单选Dialog");
        // 第二个参数是默认选项，此处设置为0
        singleChoiceDialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                yourChoice = which;
            }
        });
        singleChoiceDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (yourChoice != -1) {
                    Toast.makeText(MainActivity.this, "你选择了" + items[yourChoice], Toast.LENGTH_SHORT).show();
                }
            }
        });
        singleChoiceDialog.show();
    }

    ArrayList<Integer> yourChoices = new ArrayList<>();
    private void showMultiChoiceDialog() {
        final String[] items = { "我是1","我是2","我是3","我是4" };
        // 设置默认选中的选项，全为false默认均未选中
        final boolean initChoiceSets[]={false,false,false,false};
        yourChoices.clear();
        AlertDialog.Builder multiChoiceDialog = new AlertDialog.Builder(MainActivity.this);
        multiChoiceDialog.setTitle("我是一个多选Dialog");
        multiChoiceDialog.setMultiChoiceItems(items, initChoiceSets, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    yourChoices.add(which);
                } else {
                    yourChoices.remove(which);
                }
            }
        });
        multiChoiceDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int size = yourChoices.size();
                String str = "";
                for (int i = 0; i < size; i++) {
                    str += items[yourChoices.get(i)] + " ";
                }
                Toast.makeText(MainActivity.this, "你选中了" + str, Toast.LENGTH_SHORT).show();
            }
        });
        multiChoiceDialog.show();
    }

    private void showProgressDialog() {

        /* @setProgress 设置初始进度
         * @setProgressStyle 设置样式（水平进度条）
         * @setMax 设置进度最大值
         */
        final int MAX_PROGRESS = 100;
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setProgress(0);
        progressDialog.setTitle("我是一个进度条Dialog");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.show();
        /* 模拟进度增加的过程
         * 新开一个线程，每个100ms，进度增加1
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress= 0;
                while (progress < MAX_PROGRESS){
                    try {
                        Thread.sleep(100);
                        progress++;
                        progressDialog.setProgress(progress);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                // 进度达到最大值后，窗口消失
                progressDialog.cancel();
            }
        }).start();
    }

    private void showWaitingDialog() {
        /* 等待Dialog具有屏蔽其他控件的交互能力
         * @setCancelable 为使屏幕不可点击，设置为不可取消(false)
         * 下载等事件完成后，主动调用函数关闭该Dialog
         */
        ProgressDialog waitingDialog= new ProgressDialog(MainActivity.this);
        waitingDialog.setTitle("我是一个等待Dialog");
        waitingDialog.setMessage("等待中...");
        waitingDialog.setIndeterminate(true);
        waitingDialog.setCancelable(false);
        waitingDialog.show();
    }

    private void showCustomizeDialog() {
        AlertDialog.Builder customizeDialog = new AlertDialog.Builder(MainActivity.this);
        final View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_customize,null);
        customizeDialog.setTitle("我是一个自定义Dialog");
        customizeDialog.setView(dialogView);
        customizeDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText edit_text = (EditText) dialogView.findViewById(R.id.edit_text);
                Toast.makeText(MainActivity.this, edit_text.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        customizeDialog.show();

    }
}
