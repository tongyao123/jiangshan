package com.example.jiangshan.open.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.jiangshan.open.api.param.GroupAddParam;
import com.example.jiangshan.open.api.vo.GroupVO;
import com.example.jiangshan.open.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 开发者服务demo-组织管理相关API
 */
@RestController
@Api(value = "组织管理")
@RequestMapping("/demo/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @CrossOrigin
    @ApiOperation(value = "新增组织")
    @PostMapping("/add")
    public HttpResult addGroup(@RequestBody GroupAddParam groupAddParam) {
        groupService.addGroup(groupAddParam);
        return new HttpResult<>();
    }

    @CrossOrigin
    @ApiOperation(value = "查询所有组织")
    @GetMapping("/list")
    public HttpResult<List<GroupVO>> listGroup() {
        List<GroupVO> groupVOS = groupService.listGroup();
        return new HttpResult<>(groupVOS);
    }

}
