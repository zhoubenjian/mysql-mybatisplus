package com.benjamin.dao;

import com.benjamin.entities.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 学生 Mapper 接口
 * </p>
 *
 * @author benjamin
 * @since 2023-12-02
 */
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 关键字查询学生
     *
     * @param key   关键字
     * @return
     */
    List<Student> queryStudentsByKey(@Param("key") String key);
}
