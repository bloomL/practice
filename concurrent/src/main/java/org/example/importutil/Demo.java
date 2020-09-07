package org.example.importutil;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author liguo
 * @Description
 * @date 2020/8/3/003 11:35
 */
@Data
public class Demo {
    @ExcelProperty("序号")
    private String number;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("性别")
    private String sex;

    @ExcelProperty("所属专业")
    private String profession;

    @ExcelProperty("生源地类型")
    private String sourceType;

    @ExcelProperty("来源地区")
    private String sourceArea;

    @ExcelProperty("来源学校")
    private String sourceSchool;

    @ExcelProperty("毕业班级")
    private String classes;

    @ExcelProperty("就读方式")
    private String way;

    @ExcelProperty("监护人电话")
    private String phone;

    @ExcelProperty("推荐人")
    private String people;

    @ExcelProperty("报名日期")
    private String date;

    @ExcelProperty("中考成绩")
    private String grade;
}
