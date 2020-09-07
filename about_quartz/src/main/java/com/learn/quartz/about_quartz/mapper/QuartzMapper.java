package com.learn.quartz.about_quartz.mapper;

import com.learn.quartz.about_quartz.entity.QuartzEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author liguo
 * @Description
 * @date 2020/9/7/007 16:28
 */
@Mapper
public interface QuartzMapper {
    @Select({"<script>",
            "select * from quartz_info",
            "</script>"})
    public List<QuartzEntity> getAll();
}
