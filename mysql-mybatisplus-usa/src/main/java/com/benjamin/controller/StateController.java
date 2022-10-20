package com.benjamin.controller;

import com.benjamin.request.BasePageRequest;
import com.benjamin.response.ResponseWithCollection;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.StateService;
import com.benjamin.vo.StateVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 州 前端控制器
 * </p>
 *
 * @author benjamin
 * @since 2022-10-01
 */
@Api(value = "州接口", tags = {"州接口"})
@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateService stateService;



    /**
     * 查询所有州
     * @return
     */
    @ApiOperation("所有州")
    @GetMapping("/all")
    public ResponseWithEntities<List<StateVo>> queryAllState() {
        return stateService.queryAllState();
    }

    /**
     * 分页查询州
     * @param basePageRequest
     * @return
     */
    @GetMapping("")
    @ApiOperation("分页查询州")
    public ResponseWithCollection<StateVo> queryStateByPage(BasePageRequest basePageRequest) {
        return stateService.queryStateByPage(basePageRequest);
    }

    /**
     * 州对应的总统
     * @param basePageRequest
     * @return
     */
    @GetMapping("withpresident")
    @ApiOperation("州对应的总统")
    public ResponseWithCollection<StateVo> queryStateWithPresident(BasePageRequest basePageRequest) {
        return stateService.queryStateWithPresident(basePageRequest);
    }
}

