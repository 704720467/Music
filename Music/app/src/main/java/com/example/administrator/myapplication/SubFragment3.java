package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SubFragment3 extends Fragment implements View.OnClickListener {
    private Button logindemo;
    private Button signupdemo;
    private EditText username;
    private EditText password;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SubFragment3() {
        // Required empty public constructor
    }

    public static SubFragment3 newInstance(String param1, String param2) {
        SubFragment3 fragment = new SubFragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_fragment3, container, false);
        username = (EditText) view.findViewById(R.id.username);
        password = (EditText) view.findViewById(R.id.passward);
        view.findViewById(R.id.login_button).setOnClickListener(this);
        view.findViewById(R.id.signup_button).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        String msg = "";
        switch (v.getId()) {
            case R.id.login_button:
                if (TextUtils.isEmpty(username.getText()) || TextUtils.isEmpty(password.getText()))
                    msg = "用户或者密码不能为空！";
                else
                    msg = "登陆成功！\n用户名：" + username.getText() + "\n密    码：" + password.getText();
                break;
            case R.id.signup_button:
                if (TextUtils.isEmpty(username.getText()) || TextUtils.isEmpty(password.getText()))
                    msg = "用户或者密码不能为空！";
                else
                    msg = "注册成功！\n用户名：" + username.getText() + "\n密    码：" + password.getText();
                break;
        }
        if (!TextUtils.isEmpty(msg))
            Toast.makeText(SubFragment3.this.getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
