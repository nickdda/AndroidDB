package com.fire.table.selector;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyy on 2016/11/1.
 * 说明：查询 Where info
 */

public class WhereInfo {
    private List<String> whereLists = new ArrayList<>(5);
    private List<String> args = new ArrayList<>(5);

    public WhereInfo(String columnName , String op , String value) {
        whereAppend( null , columnName , op , value);
    }

    private void whereAppend(String condition, String columnName , String op , String value){
        StringBuilder builder = new StringBuilder();
        if (!TextUtils.isEmpty(condition)){
            builder.append(condition);
        }
        builder.append(columnName).append(op).append("? ");
        args.add(value);
        whereLists.add(builder.toString());
    }

    void and(String columnName , String op , String value){
        whereAppend("AND ",columnName , op , value);
    }

    void or(String columnName , String op , String value){
        whereAppend("OR ",columnName , op , value);
    }

    public List<String> getWhereLists() {
        return whereLists;
    }

    public List<String> getArgs() {
        return args;
    }
}
