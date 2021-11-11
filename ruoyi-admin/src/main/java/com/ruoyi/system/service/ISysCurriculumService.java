package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysCurriculum;
import com.ruoyi.system.domain.SysStudent;
import com.ruoyi.system.domain.SysTeacher;
import com.ruoyi.system.vo.CurriculumListVo;

/**
 * 课程Service接口
 * 
 * @author chen
 * @date 2021-10-05
 */
public interface ISysCurriculumService 
{
    /**
     * 查询课程
     * 
     * @param id 课程主键
     * @return 课程
     */
    public SysCurriculum selectSysCurriculumById(Long id);

    /**
     * 查询课程列表
     * 
     * @param sysCurriculum 课程
     * @return 课程集合
     */
    public List<SysCurriculum> selectSysCurriculumList(SysCurriculum sysCurriculum);

    /**
     * 通学生信息查询课程列表
     *
     * @param sysStudent 学生信息
     * @return 课程集合
     */
    public List<SysCurriculum> selectSysCurriculumListByStudent(SysStudent sysStudent);

    /**
     * 通教师信息查询课程列表
     *
     * @param sysTeacher 教师信息
     * @return 课程集合
     */
    public List<SysCurriculum> selectSysCurriculumListByTeacher(SysTeacher sysTeacher);

    /**
     * 新增课程
     * 
     * @param sysCurriculum 课程
     * @return 结果
     */
    public int insertSysCurriculum(SysCurriculum sysCurriculum);

    /**
     * 修改课程
     * 
     * @param sysCurriculum 课程
     * @return 结果
     */
    public int updateSysCurriculum(SysCurriculum sysCurriculum);

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的课程主键集合
     * @return 结果
     */
    public int deleteSysCurriculumByIds(String ids);

    /**
     * 删除课程信息
     * 
     * @param id 课程主键
     * @return 结果
     */
    public int deleteSysCurriculumById(Long id);
}
