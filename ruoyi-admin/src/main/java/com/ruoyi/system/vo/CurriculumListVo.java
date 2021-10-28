package com.ruoyi.system.vo;

public class CurriculumListVo {
    /**
     *
     */
    private Long id;

    private String name;

    private Long num;

    private Long passLine;

    private Boolean isCheck;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Long getPassLine() {
        return passLine;
    }

    public void setPassLine(Long passLine) {
        this.passLine = passLine;
    }

    public Boolean getCheck() {
        return isCheck;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
    }

    @Override
    public String toString() {
        return "CurriculumLIstVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", passLine=" + passLine +
                ", isCheck=" + isCheck +
                '}';
    }
}
