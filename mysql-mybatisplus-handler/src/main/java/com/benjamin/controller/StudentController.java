package com.benjamin.controller;

import com.benjamin.request.StudentForm;
import com.benjamin.request.StudentReq;
import com.benjamin.response.ResponseWithCollection;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.StudentService;
import com.benjamin.vo.StudentVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 学生 前端控制器
 * </p>
 *
 * @author benjamin
 * @since 2023-12-02
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;



    /**
     * 新增学生
     *
     * @param studentForm
     * @return
     */
    @ApiOperation("新增学生")
    @PostMapping("/add")
    public ResponseWithEntities<String> addStudent(@Valid @RequestBody StudentForm studentForm) {
        return studentService.addStudent(studentForm);
    }

    /**
     * 所有学生
     *
     * @return
     */
    @ApiOperation("所有学生")
    @GetMapping("/all")
    public ResponseWithEntities<List<StudentVo>> queryAllStudents() {
        return studentService.queryAllStudents();
    }

    /**
     * 关键字查询学生
     *
     * @param studentReq
     * @return
     */
    @ApiOperation("关键字查询学生")
    @GetMapping("")
    public ResponseWithCollection<StudentVo> queryStudentsByKey(StudentReq studentReq) {
        return studentService.queryStudentsByKey(studentReq);
    }
}

