package com.example.jiangshan.entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AgricultureStatistics {
    private Integer plantationNumber;
    private Integer plantationArea;
    private Integer plantationEmployeesNumber;
    private Integer farmNumber;
    private Integer farmArea;
    private Integer farmEmployeesNumber;
    private Integer teaNumber;
    private Integer teaArea;
    private Integer teaEstimatedOutput;

    public Integer getPlantationNumber() {
        return plantationNumber;
    }

    public void setPlantationNumber(Integer plantationsNumber) {
        this.plantationNumber = plantationsNumber;
    }

    public Integer getPlantationArea() {
        return plantationArea;
    }

    public void setPlantationArea(Integer plantationsArea) {
        this.plantationArea = plantationsArea;
    }

    public Integer getPlantationEmployeesNumber() {
        return plantationEmployeesNumber;
    }

    public void setPlantationEmployeesNumber(Integer plantationsEmployeesNumber) {
        this.plantationEmployeesNumber = plantationsEmployeesNumber;
    }

    public Integer getFarmNumber() {
        return farmNumber;
    }

    public void setFarmNumber(Integer farmNumber) {
        this.farmNumber = farmNumber;
    }

    public Integer getFarmArea() {
        return farmArea;
    }

    public void setFarmArea(Integer farmArea) {
        this.farmArea = farmArea;
    }

    public Integer getFarmEmployeesNumber() {
        return farmEmployeesNumber;
    }

    public void setFarmEmployeesNumber(Integer farmEmployeesNumber) {
        this.farmEmployeesNumber = farmEmployeesNumber;
    }

    public Integer getTeaNumber() {
        return teaNumber;
    }

    public void setTeaNumber(Integer teaNumber) {
        this.teaNumber = teaNumber;
    }

    public Integer getTeaArea() {
        return teaArea;
    }

    public void setTeaArea(Integer teaArea) {
        this.teaArea = teaArea;
    }

    public Integer getTeaEstimatedOutput() {
        return teaEstimatedOutput;
    }

    public void setTeaEstimatedOutput(Integer teaEstimatedOutput) {
        this.teaEstimatedOutput = teaEstimatedOutput;
    }

}
