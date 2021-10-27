package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysTeacherMapper;
import com.ruoyi.system.domain.SysTeacher;
import com.ruoyi.system.service.ISysTeacherService;
import com.ruoyi.common.core.text.Convert;

/**
 * 教师Service业务层处理
 * 
 * @author chen
 * @date 2021-10-05
 */
@Service
public class SysTeacherServiceImpl implements ISysTeacherService 
{
    @Autowired
    private SysTeacherMapper sysTeacherMapper;

    /**
     * 查询教师
     * 
     * @param id 教师主键
     * @return 教师
     */
    @Override
    public SysTeacher selectSysTeacherById(Long id)
    {
        return sysTeacherMapper.selectSysTeacherById(id);
    }

    /**
     * 查询教师列表
     * 
     * @param sysTeacher 教师
     * @return 教师
     */
    @Override
    public List<SysTeacher> selectSysTeacherList(SysTeacher sysTeacher)
    {
        return sysTeacherMapper.selectSysTeacherList(sysTeacher);
    }

    /**
     * 新增教师
     * 
     * @param sysTeacher 教师
     * @return 结果
     */
    @Override
    public int insertSysTeacher(SysTeacher sysTeacher)
    {
        return sysTeacherMapper.insertSysTeacher(sysTeacher);
    }

    /**
     * 修改教师
     * 
     * @param sysTeacher 教师
     * @return 结果
     */
    @Override
    public int updateSysTeacher(SysTeacher sysTeacher)
    {
        return sysTeacherMapper.updateSysTeacher(sysTeacher);
    }

    /**
     * 批量删除教师
     * 
     * @param ids 需要删除的教师主键
     * @return 结果
     */
    @Override
    public int deleteSysTeacherByIds(String ids)
    {
        return sysTeacherMapper.deleteSysTeacherByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除教师信息
     * 
     * @param id 教师主键
     * @return 结果
     */
    @Override
    public int deleteSysTeacherById(Long id)
    {
        return sysTeacherMapper.deleteSysTeacherById(id);
    }
}
