package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Map;

/**
 * 学生信息对象 sys_student
 *
 * @author chen
 * @date 2021-10-05
 */
public class SysStudent extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 学生名称
     */
    @Excel(name = "学生名称")
    private String name;

    /**
     * 年龄
     */
    @Excel(name = "年龄")
    private Long age;

    /**
     * 性别（0男 1女 2未知）
     */
    @Excel(name = "性别", readConverterExp = "0=男,1=女,2=未知")
    private String sex;

    /**
     * 状态（0正常 1停用）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /**
     * 学号
     */
    @Excel(name = "学号")
    private String studentId;

    private Long userId;

    private String userName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserId(String userName) {
        this.userName = userName;
    }

    public SysStudent() {
    }

    public SysStudent(Long id, String name, Long age, String sex, String status, String studentId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.status = status;
        this.studentId = studentId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Long getAge() {
        return age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("age", getAge())
                .append("sex", getSex())
                .append("status", getStatus())
                .append("studentId", getStudentId())
                .append("userId",getUserId())
                .append("userName",getUserName())
                .toString();
    }
}
