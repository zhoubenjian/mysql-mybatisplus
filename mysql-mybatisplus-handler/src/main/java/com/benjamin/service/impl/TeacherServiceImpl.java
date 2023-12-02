package com.benjamin.service.impl;

import com.benjamin.entities.Teacher;
import com.benjamin.dao.TeacherMapper;
import com.benjamin.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 教师 服务实现类
 * </p>
 *
 * @author benjamin
 * @since 2023-12-02
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

}
