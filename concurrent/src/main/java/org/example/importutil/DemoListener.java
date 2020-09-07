package org.example.importutil;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liguo
 * @Description
 * @date 2020/8/3/003 11:43
 */
public class DemoListener extends AnalysisEventListener<Demo> {


    List<Demo> list = new ArrayList<>();

    @Override
    public void invoke(Demo data, AnalysisContext analysisContext) {
        list.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveDate();
        System.out.println("解析完成");
    }

    /**
     * 保存数据库
     */
    private void saveDate() {
        List<Demo> filterList = list.stream().filter(i -> i.getGrade() != null).collect(Collectors.toList());
        for (Demo excel: filterList) {
            StringBuilder sb = new StringBuilder();
            sb.append("update yysd_yxxt_b_xsjbxxb set zkcj ="+"'"+excel.getGrade()+"'");
            sb.append(" where xm = " + "'" +excel.getName() +"'");
            sb.append(" and jhrlxdh = " + "'" + excel.getPhone() + "'" + " and " + "(" +"zkcj is NULL or zkcj =''"+");");
            System.out.println(sb.toString());
        }
    }
}
