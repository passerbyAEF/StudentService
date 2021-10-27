package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程对象 sys_curriculum
 * 
 * @author chen
 * @date 2021-10-05
 */
public class SysCurriculum extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 课程名字 */
    @Excel(name = "课程名字")
    private String name;

    /** 课程学分 */
    @Excel(name = "课程学分")
    private Long num;

    /** 及格线 */
    @Excel(name = "及格线")
    private Long passLine;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setNum(Long num) 
    {
        this.num = num;
    }

    public Long getNum() 
    {
        return num;
    }
    public void setPassLine(Long passLine) 
    {
        this.passLine = passLine;
    }

    public Long getPassLine() 
    {
        return passLine;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("num", getNum())
            .append("passLine", getPassLine())
            .toString();
    }
}
