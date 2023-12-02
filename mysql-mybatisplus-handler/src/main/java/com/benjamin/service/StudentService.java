package com.benjamin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.benjamin.entities.Student;
import com.benjamin.request.StudentForm;
import com.benjamin.request.StudentReq;
import com.benjamin.response.ResponseWithCollection;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.vo.StudentVo;

import java.util.List;

/**
 * <p>
 * 学生 服务类
 * </p>
 *
 * @author benjamin
 * @since 2023-12-02
 */
public interface StudentService extends IService<Student> {

    /**
     * 新增学生
     *
     * @param studentForm
     * @return
     */
    ResponseWithEntities<String> addStudent(StudentForm studentForm);

    /**
     * 所有学生
     *
     * @return
     */
    ResponseWithEntities<List<StudentVo>> queryAllStudents();

    /**
     * 关键字查询学生
     *
     * @param studentReq
     * @return
     */
    ResponseWithCollection<StudentVo> queryStudentsByKey(StudentReq studentReq);
}
