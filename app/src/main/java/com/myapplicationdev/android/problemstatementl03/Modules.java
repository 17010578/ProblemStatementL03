package com.myapplicationdev.android.problemstatementl03;

public class Modules {

    private String moduleCode;
    private String DG;
    private String grade;
    private int week;


    public String getModuleCode() {
        return moduleCode;
    }

    public String getGrade() {
        return grade;
    }

    public int getWeek() {
        return week;
    }

    public String getDG() {
        return DG;
    }

    public Modules( int week, String moduleCode,String DG, String grade) {
        this.grade = grade;
        this.moduleCode = moduleCode;
        this.week = week;
        this.DG = DG;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public void setDG (String DG){
        this.DG = DG;
    }
}
