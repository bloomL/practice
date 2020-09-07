package com.learn.quartz.about_quartz.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liguo
 * @Description
 * @date 2020/9/7/007 16:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "quartz_info")
public class QuartzEntity {
    private Long id;
    private String name;
}
