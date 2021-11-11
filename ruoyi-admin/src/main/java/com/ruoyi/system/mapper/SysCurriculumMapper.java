package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysCurriculum;
import com.ruoyi.system.domain.SysStudent;
import com.ruoyi.system.domain.SysTeacher;
import com.ruoyi.system.vo.CurriculumListVo;

/**
 * 课程Mapper接口
 * 
 * @author chen
 * @date 2021-10-05
 */
public interface SysCurriculumMapper 
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
     * 通过学生查询课程列表
     *
     * @param sysStudent 学生
     * @return 课程集合
     */
    public List<SysCurriculum> selectSysCurriculumListByStudent(SysStudent sysStudent);

    /**
     * 通过教师查询课程列表
     *
     * @param sysTeacher 教师
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
     * 删除课程
     * 
     * @param id 课程主键
     * @return 结果
     */
    public int deleteSysCurriculumById(Long id);

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysCurriculumByIds(String[] ids);
}
