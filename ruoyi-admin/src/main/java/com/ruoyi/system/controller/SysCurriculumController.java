package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysCurriculum;
import com.ruoyi.system.service.ISysCurriculumService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 课程Controller
 * 
 * @author chen
 * @date 2021-10-05
 */
@Controller
@RequestMapping("/system/curriculum")
public class SysCurriculumController extends BaseController
{
    private String prefix = "system/curriculum";

    @Autowired
    private ISysCurriculumService sysCurriculumService;

    @RequiresPermissions("system:curriculum:view")
    @GetMapping()
    public String curriculum()
    {
        return prefix + "/curriculum";
    }

    /**
     * 查询课程列表
     */
    @RequiresPermissions("system:curriculum:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysCurriculum sysCurriculum)
    {
        startPage();
        List<SysCurriculum> list = sysCurriculumService.selectSysCurriculumList(sysCurriculum);
        return getDataTable(list);
    }

    /**
     * 导出课程列表
     */
    @RequiresPermissions("system:curriculum:export")
    @Log(title = "课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysCurriculum sysCurriculum)
    {
        List<SysCurriculum> list = sysCurriculumService.selectSysCurriculumList(sysCurriculum);
        ExcelUtil<SysCurriculum> util = new ExcelUtil<SysCurriculum>(SysCurriculum.class);
        return util.exportExcel(list, "课程数据");
    }

    /**
     * 新增课程
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存课程
     */
    @RequiresPermissions("system:curriculum:add")
    @Log(title = "课程", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysCurriculum sysCurriculum)
    {
        return toAjax(sysCurriculumService.insertSysCurriculum(sysCurriculum));
    }

    /**
     * 修改课程
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SysCurriculum sysCurriculum = sysCurriculumService.selectSysCurriculumById(id);
        mmap.put("sysCurriculum", sysCurriculum);
        return prefix + "/edit";
    }

    /**
     * 修改保存课程
     */
    @RequiresPermissions("system:curriculum:edit")
    @Log(title = "课程", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysCurriculum sysCurriculum)
    {
        return toAjax(sysCurriculumService.updateSysCurriculum(sysCurriculum));
    }

    /**
     * 删除课程
     */
    @RequiresPermissions("system:curriculum:remove")
    @Log(title = "课程", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysCurriculumService.deleteSysCurriculumByIds(ids));
    }
}
