package org.example.importutil;

import com.alibaba.excel.EasyExcel;

/**
 * @author liguo
 * @Description
 * @date 2020/8/3/003 13:43
 */
public class DemoTest {

    public static void main(String[] args) {
        EasyExcel.read("C:/Users/Administrator/Desktop/sql.xlsx", Demo.class, new DemoListener()).sheet().doRead();
    }
}
