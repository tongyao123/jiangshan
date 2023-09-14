package com.example.jiangshan.open.service;

import com.example.jiangshan.open.api.param.GroupAddParam;
import com.example.jiangshan.open.api.vo.GroupVO;
import com.example.jiangshan.open.client.OpenBasicClient;
import com.example.jiangshan.open.client.response.GroupListResponse;
import com.example.jiangshan.open.constant.ExceptionEnum;
import com.example.jiangshan.open.domain.GroupMapper;
import com.example.jiangshan.open.domain.entity.Group;
import com.example.jiangshan.open.util.Assert;
import com.example.jiangshan.open.util.UuidUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yanyuechao
 * @date 2020-05-19 11:03
 **/
@Service
public class GroupService {

    @Autowired
    private OpenBasicClient openBasicClient;
    @Autowired
    private GroupMapper groupMapper;

    public void addGroup(GroupAddParam groupAddParam) {

        String parentNo = null;
        Group parentGroup = null;
        if (StringUtils.isNotBlank(groupAddParam.getParentId())) {
            parentGroup = groupMapper.selectByPrimaryKey(groupAddParam.getParentId());
            Assert.isTrue(parentGroup != null, ExceptionEnum.PARENT_GROUP_NOT_EXIST);
            parentNo =  parentGroup.getGroupNo();
        }
        openBasicClient.addGroup(groupAddParam,parentNo);
        Group group = getGroup(groupAddParam, parentGroup);
        groupMapper.insert(group);
    }

    public List<GroupVO> listGroup() {

        List<Group> groups = groupMapper.listGroups();
        return toGroupVO(groups);
    }

    private Group getGroup(GroupAddParam groupAddParam,Group parentGroup) {

        Group group = new Group();
        String groupId = UuidUtil.create();
        group.setGroupId(groupId);
        group.setGroupNo(groupAddParam.getGroupNo());
        group.setGroupName(groupAddParam.getGroupName());
        group.setPath(groupId);
        if (StringUtils.isNotBlank(groupAddParam.getParentId())) {
            group.setParentId(groupAddParam.getParentId());
            group.setPath(parentGroup.getPath() + "/" + groupId);
        }
        return group;
    }

    private List<GroupVO> toGroupVO(List<Group> groups) {

        return groups.stream().map(group -> new GroupVO(group.getGroupId(), group.getGroupName()))
                .collect(Collectors.toList());
    }

    public void batchAddGroup(List<GroupListResponse.GroupRow> groupRows) {

        if(CollectionUtils.isNotEmpty(groupRows)) {
            List<Group> groups = groupRows.stream().map(groupRow -> Group.aBuilder.aGroup().setGroupId(groupRow.getGroupId()).setGroupName
                    (groupRow.getGroupName()).setGroupNo(groupRow.getGroupNo()).setParentId(groupRow.getParentId()).build
                    ()).collect(Collectors.toList());
            groupMapper.batchInsert(groups);
        }
    }
}
