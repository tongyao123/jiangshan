package com.example.jiangshan.open.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.jiangshan.open.api.param.DeviceAddGroupParam;
import com.example.jiangshan.open.api.param.PermissionGroupAddParam;
import com.example.jiangshan.open.api.param.PermissionGroupIdParam;
import com.example.jiangshan.open.api.param.PersonAddGroupParam;
import com.example.jiangshan.open.api.vo.PermissionGroupVO;
import com.example.jiangshan.open.service.PermissionGroupService;

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
