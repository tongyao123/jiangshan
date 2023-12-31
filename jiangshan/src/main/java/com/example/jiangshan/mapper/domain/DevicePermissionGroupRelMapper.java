package com.example.jiangshan.mapper.domain;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.jiangshan.entity.DevicePermissionGroupRel;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DevicePermissionGroupRelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_permission_group_rel
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_permission_group_rel
     *
     * @mbg.generated
     */
    int insertSelective(DevicePermissionGroupRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_permission_group_rel
     *
     * @mbg.generated
     */
    DevicePermissionGroupRel selectByPrimaryKey(String id);

    List<DevicePermissionGroupRel> listPermissionGroupDevices(@Param("groupId") String groupId);

    void batchInsert(@Param("devicePermissionGroupRels") List<DevicePermissionGroupRel> devicePermissionGroupRels);

    List<DevicePermissionGroupRel> listPermissionGroupDevicesBySerial(@Param("groupId")String groupId, @Param("deviceSerial")String deviceSerial);
}