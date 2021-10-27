package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysTeacher;

/**
 * 教师Mapper接口
 * 
 * @author chen
 * @date 2021-10-05
 */
public interface SysTeacherMapper 
{
    /**
     * 查询教师
     * 
     * @param id 教师主键
     * @return 教师
     */
    public SysTeacher selectSysTeacherById(Long id);

    /**
     * 查询教师列表
     * 
     * @param sysTeacher 教师
     * @return 教师集合
     */
    public List<SysTeacher> selectSysTeacherList(SysTeacher sysTeacher);

    /**
     * 新增教师
     * 
     * @param sysTeacher 教师
     * @return 结果
     */
    public int insertSysTeacher(SysTeacher sysTeacher);

    /**
     * 修改教师
     * 
     * @param sysTeacher 教师
     * @return 结果
     */
    public int updateSysTeacher(SysTeacher sysTeacher);

    /**
     * 删除教师
     * 
     * @param id 教师主键
     * @return 结果
     */
    public int deleteSysTeacherById(Long id);

    /**
     * 批量删除教师
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysTeacherByIds(String[] ids);
}
