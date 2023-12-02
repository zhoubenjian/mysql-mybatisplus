package com.benjamin.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.benjamin.convert.HandlerConverter;
import com.benjamin.dao.StudentMapper;
import com.benjamin.entities.Student;
import com.benjamin.error.SystemErrors;
import com.benjamin.exception.WebException;
import com.benjamin.request.StudentForm;
import com.benjamin.request.StudentReq;
import com.benjamin.response.ResponseWithCollection;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.StudentService;
import com.benjamin.singleton.AesInstance;
import com.benjamin.vo.StudentVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 学生 服务实现类
 * </p>
 *
 * @author benjamin
 * @since 2023-12-02
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private HandlerConverter handlerConverter;

    private final SymmetricCrypto aes = AesInstance.getInstance();



    /**
     * 新增学生
     *
     * @param studentForm
     * @return
     */
    @Override
    public ResponseWithEntities<String> addStudent(StudentForm studentForm) {

        // 姓名校验
        if (!Validator.isChinese(studentForm.getStudentName()))
            throw new WebException(SystemErrors.NAME_ILLEGAL);

        // 身份证校验
        if (!IdcardUtil.isValidCard(studentForm.getIdNumber()))
            throw new WebException(SystemErrors.ID_NUMBER_ILLEGAL);

        // 手机号校验
        if (!Validator.isMobile(studentForm.getPhone()))
            throw new WebException(SystemErrors.PHONE_ILLEGAL);

        // StudentForm => Student
        Student student = handlerConverter.studentForm2Student(studentForm);
        // 由身份证获取性别
        student.setGender(IdcardUtil.getGenderByIdCard(student.getIdNumber()));
        // 由身份证获取年龄
        student.setAge(IdcardUtil.getAgeByIdCard(student.getIdNumber()));

        student.setStudentNo("S-" + IdUtil.simpleUUID());
        // 插入
        studentMapper.insert(student);

        return new ResponseWithEntities<String>().setData(studentForm.getStudentName() + "，添加成功！");
    }

    /**
     * 所有学生
     *
     * @return
     */
    @Override
    public ResponseWithEntities<List<StudentVo>> queryAllStudents() {

        // 调用系统查询方法，无需解密
        List studentList = Optional.ofNullable(studentMapper.selectList(null)).orElse(Collections.EMPTY_LIST);

        // Student => StudentVo
        List<StudentVo> studentVos = handlerConverter.studentList2StudentVoList(studentList);
        return new ResponseWithEntities<List<StudentVo>>().setData(studentVos);
    }

    /**
     * 关键字查询学生
     *
     * @param studentReq
     * @return
     */
    @Override
    public ResponseWithCollection<StudentVo> queryStudentsByKey(StudentReq studentReq) {

        // 分页参数
        Page page = PageHelper.startPage((int) studentReq.getPage(), (int) studentReq.getPageSize());
        List studentList = Optional.ofNullable(studentMapper.queryStudentsByKey(studentReq.getKey())).orElse(Collections.EMPTY_LIST);

        // Student => StudentVo
        List<StudentVo> studentVos = handlerConverter.studentList2StudentVoList(studentList);
        return ResponseWithCollection.buildResponse(studentReq, studentVos, page.getTotal());
    }
}
