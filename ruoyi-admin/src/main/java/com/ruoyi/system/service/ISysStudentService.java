package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysStudent;

/**
 * 学生信息Service接口
 * 
 * @author chen
 * @date 2021-10-05
 */
public interface ISysStudentService 
{
    /**
     * 查询学生信息
     * 
     * @param id 学生信息主键
     * @return 学生信息
     */
    public SysStudent selectSysStudentById(Long id);

    /**
     * 查询学生信息列表
     * 
     * @param sysStudent 学生信息
     * @return 学生信息集合
     */
    public List<SysStudent> selectSysStudentList(SysStudent sysStudent);

    /**
     * 新增学生信息
     * 
     * @param sysStudent 学生信息
     * @return 结果
     */
    public int insertSysStudent(SysStudent sysStudent);

    /**
     * 修改学生信息
     * 
     * @param sysStudent 学生信息
     * @return 结果
     */
    public int updateSysStudent(SysStudent sysStudent);

    /**
     * 批量删除学生信息
     * 
     * @param ids 需要删除的学生信息主键集合
     * @return 结果
     */
    public int deleteSysStudentByIds(String ids);

    /**
     * 删除学生信息信息
     * 
     * @param id 学生信息主键
     * @return 结果
     */
    public int deleteSysStudentById(Long id);

    public int updateStudentAndCurriculum(Integer id,List<Integer> Cid);

    SysStudent selectStudentByUserId(Long id);
}
