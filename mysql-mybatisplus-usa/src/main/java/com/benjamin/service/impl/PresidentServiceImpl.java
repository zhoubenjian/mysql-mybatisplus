package com.benjamin.service.impl;

import com.benjamin.converter.ApiConverter;
import com.benjamin.entities.President;
import com.benjamin.dao.PresidentMapper;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.PresidentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.benjamin.vo.PresidentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 总统 服务实现类
 * </p>
 *
 * @author benjamin
 * @since 2022-10-06
 */
@Service
public class PresidentServiceImpl extends ServiceImpl<PresidentMapper, President> implements PresidentService {

    @Autowired
    private PresidentMapper presidentMapper;

    @Autowired
    private ApiConverter apiConverter;



    /**
     * 查询所有总统
     * @return
     */
    @Override
    public ResponseWithEntities<List<PresidentVo>> queryAllPresident() {
        List<President> presidentList = presidentMapper.selectList(null);
        // President => PresidentVo
        List<PresidentVo> presidentVoList = apiConverter.PresidentList2PresidentVoList(presidentList);
        LocalDate now = LocalDate.now();
        // 就算年龄
        presidentVoList.stream().forEach(p -> p.setAge(p.getBirthday().until(now).getYears()));
        return new ResponseWithEntities<List<PresidentVo>>().setData(presidentVoList);
    }
}
