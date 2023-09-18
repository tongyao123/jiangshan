package com.example.jiangshan.controller;

import java.util.List;

import com.example.jiangshan.controller.param.DeviceAddGroupParam;
import com.example.jiangshan.controller.param.PermissionGroupAddParam;
import com.example.jiangshan.controller.param.PermissionGroupIdParam;
import com.example.jiangshan.controller.param.PersonAddGroupParam;
import com.example.jiangshan.controller.vo.PermissionGroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.jiangshan.service.domain.PermissionGroupService;

/**
 * @author yanyuechao
 * @date 2020-05-20 11:37
 **/
@RestController
@RequestMapping("/demo/permissionGroups")
public class PermissionGroupController {

    @Autowired
    private PermissionGroupService permissionGroupService;

    @CrossOrigin
    @PostMapping("/add")
    public HttpResult addPermissionGroup(@RequestBody PermissionGroupAddParam permissionGroupAddParam) {

        permissionGroupService.addPermissionGroup(permissionGroupAddParam);
        return new HttpResult<>();
    }

    @CrossOrigin
    @PostMapping("/actions/addDevices")
    public HttpResult addDevices(@RequestBody DeviceAddGroupParam deviceAddGroupParam) {

        permissionGroupService.addDevices(deviceAddGroupParam);
        return new HttpResult<>();
    }

    @CrossOrigin
    @PostMapping("/actions/addPersons")
    public HttpResult addPersons(@RequestBody PersonAddGroupParam personAddGroupParam) {

        permissionGroupService.addPersons(personAddGroupParam);
        return new HttpResult<>();
    }

    @CrossOrigin
    @GetMapping("/list")
    public HttpResult<List<PermissionGroupVO>> listPermissionGroups() {

        return new HttpResult<>(permissionGroupService.listPermissionGroups());
    }


    @CrossOrigin
    @PostMapping("/actions/issuePermission")
    public HttpResult addPersons(@RequestBody PermissionGroupIdParam permissionGroupIdParam) {

        permissionGroupService.issuePermission(permissionGroupIdParam);
        return new HttpResult<>();
    }
}
