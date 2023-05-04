package com.benjamin.controller;

import com.benjamin.request.BasePageRequest;
import com.benjamin.response.ResponseWithCollection;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.PresidentService;
import com.benjamin.vo.PresidentStateVo;
import com.benjamin.vo.PresidentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 总统 前端控制器
 * </p>
 *
 * @author benjamin
 * @since 2022-10-06
 */
@Api(value = "总统接口", tags = {"总统接口"})
@RestController
@RequestMapping("/president")
public class PresidentController {

    @Autowired
    private PresidentService presidentService;



    /**
     * 所有总统
     *
     * @return
     */
    @GetMapping("/all")
    @ApiOperation("所有总统")
    public ResponseWithEntities<List<PresidentVo>> queryAllPresident() {
        return presidentService.queryAllPresident();
    }

    /**
     * 在世总统
     *
     * @return
     */
    @GetMapping("/alive")
    @ApiOperation("在世总统")
    public ResponseWithEntities<List<PresidentVo>> queryAlivePresident() {
        return presidentService.queryAlivePresident();
    }

    /**
     * 川皇（美利坚大统领）（懂王）
     *
     * @return
     */
    @GetMapping("/dt")
    @ApiOperation("川皇（美利坚大统领）（懂王）")
    public ResponseWithEntities<PresidentVo> queryOnePresident() {
        return presidentService.queryOnePresident();
    }

    /**
     * 出生日期查询
     *
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("/birthday")
    @ApiOperation("出生日期查询")
    public ResponseWithEntities<List<PresidentVo>> queryPresidentByBirthDate(@RequestParam(value = "startTime", required = false) String startTime,
                                                                             @RequestParam(value = "endTime", required = false) String endTime) {
        return presidentService.queryPresidentByBirthDate(startTime, endTime);
    }

    /**
     * 总统对应的州(一对一)
     *
     * @param basePageRequest
     * @return
     */
    @GetMapping("/withstate")
    @ApiOperation("总统对应的州")
    public ResponseWithCollection<PresidentStateVo> queryPresidentWithState(BasePageRequest basePageRequest) {
        return presidentService.queryPresidentWithState(basePageRequest);
    }

    /**
     * 导出总统（流式）
     *
     * @param response
     * @param key
     */
    @PostMapping("/export")
    @ApiOperation("导出总统（流式）")
    public void exportPresidentBySteam(HttpServletResponse response, String key) {
        presidentService.exportPresidentBySteam(response, key);
    }
}

