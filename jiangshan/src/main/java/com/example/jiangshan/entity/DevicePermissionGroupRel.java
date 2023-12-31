package com.example.jiangshan.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table device_permission_group_rel
 *
 * @mbg.generated do_not_delete_during_merge
 */
@NoArgsConstructor
@AllArgsConstructor
public class DevicePermissionGroupRel {
    /**
     * 关联ID(id)
     */
    private String id;

    /**
     * 权限组ID(permission_group_id)
     */
    private String permissionGroupId;

    /**
     * 设备序列号(device_serial)
     */
    private String deviceSerial;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_permission_group_rel.id
     *
     * @return the value of device_permission_group_rel.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_permission_group_rel.id
     *
     * @param id the value for device_permission_group_rel.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_permission_group_rel.permission_group_id
     *
     * @return the value of device_permission_group_rel.permission_group_id
     *
     * @mbg.generated
     */
    public String getPermissionGroupId() {
        return permissionGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_permission_group_rel.permission_group_id
     *
     * @param permissionGroupId the value for device_permission_group_rel.permission_group_id
     *
     * @mbg.generated
     */
    public void setPermissionGroupId(String permissionGroupId) {
        this.permissionGroupId = permissionGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_permission_group_rel.device_serial
     *
     * @return the value of device_permission_group_rel.device_serial
     *
     * @mbg.generated
     */
    public String getDeviceSerial() {
        return deviceSerial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_permission_group_rel.device_serial
     *
     * @param deviceSerial the value for device_permission_group_rel.device_serial
     *
     * @mbg.generated
     */
    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }
}