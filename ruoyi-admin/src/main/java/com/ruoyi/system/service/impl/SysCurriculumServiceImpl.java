package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SysCurriculum;
import com.ruoyi.system.domain.SysStudent;
import com.ruoyi.system.mapper.SysCurriculumMapper;
import com.ruoyi.system.service.ISysCurriculumService;
import com.ruoyi.system.vo.CurriculumListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程Service业务层处理
 *
 * @author chen
 * @date 2021-10-05
 */
@Service
public class SysCurriculumServiceImpl implements ISysCurriculumService {
    @Autowired
    private SysCurriculumMapper sysCurriculumMapper;

    /**
     * 查询课程
     *
     * @param id 课程主键
     * @return 课程
     */
    @Override
    public SysCurriculum selectSysCurriculumById(Long id) {
        return sysCurriculumMapper.selectSysCurriculumById(id);
    }

    /**
     * 查询课程列表
     *
     * @param sysCurriculum 课程
     * @return 课程
     */
    @Override
    public List<SysCurriculum> selectSysCurriculumList(SysCurriculum sysCurriculum) {
        return sysCurriculumMapper.selectSysCurriculumList(sysCurriculum);
    }

    @Override
    public List<CurriculumListVo> selectSysCurriculumListByStudent(SysStudent sysStudent) {
        return sysCurriculumMapper.selectSysCurriculumListByStudent(sysStudent);
    }

    /**
     * 新增课程
     *
     * @param sysCurriculum 课程
     * @return 结果
     */
    @Override
    public int insertSysCurriculum(SysCurriculum sysCurriculum) {
        return sysCurriculumMapper.insertSysCurriculum(sysCurriculum);
    }

    /**
     * 修改课程
     *
     * @param sysCurriculum 课程
     * @return 结果
     */
    @Override
    public int updateSysCurriculum(SysCurriculum sysCurriculum) {
        return sysCurriculumMapper.updateSysCurriculum(sysCurriculum);
    }

    /**
     * 批量删除课程
     *
     * @param ids 需要删除的课程主键
     * @return 结果
     */
    @Override
    public int deleteSysCurriculumByIds(String ids) {
        return sysCurriculumMapper.deleteSysCurriculumByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课程信息
     *
     * @param id 课程主键
     * @return 结果
     */
    @Override
    public int deleteSysCurriculumById(Long id) {
        return sysCurriculumMapper.deleteSysCurriculumById(id);
    }
}
