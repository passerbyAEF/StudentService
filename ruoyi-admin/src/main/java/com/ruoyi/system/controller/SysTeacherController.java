package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.service.ISysUserService;
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
import com.ruoyi.system.domain.SysTeacher;
import com.ruoyi.system.service.ISysTeacherService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教师Controller
 *
 * @author chen
 * @date 2021-10-05
 */
@Controller
@RequestMapping("/system/teacher")
public class SysTeacherController extends BaseController {
    private String prefix = "system/teacher";

    @Autowired
    private ISysTeacherService sysTeacherService;
    @Autowired
    private ISysUserService sysUserService;

    String authCheck(SysTeacher sysTeacher){
        SysUser user = sysUserService.selectUserById(sysTeacher.getUserId());
        if (null == user) {
            return "用户不存在";
        }
        for(SysRole r: user.getRoles()){
            if(!"教师".equals(r.getRoleName())){
                return "用户非法！";
            }
        }
        return null;
    }

    @RequiresPermissions("system:teacher:view")
    @GetMapping()
    public String teacher() {
        return prefix + "/teacher";
    }

    /**
     * 查询教师列表
     */
    @RequiresPermissions("system:teacher:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysTeacher sysTeacher) {
        startPage();
        List<SysTeacher> list = sysTeacherService.selectSysTeacherList(sysTeacher);
        return getDataTable(list);
    }

    /**
     * 导出教师列表
     */
    @RequiresPermissions("system:teacher:export")
    @Log(title = "教师", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysTeacher sysTeacher) {
        List<SysTeacher> list = sysTeacherService.selectSysTeacherList(sysTeacher);
        ExcelUtil<SysTeacher> util = new ExcelUtil<SysTeacher>(SysTeacher.class);
        return util.exportExcel(list, "教师数据");
    }

    /**
     * 新增教师
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存教师
     */
    @RequiresPermissions("system:teacher:add")
    @Log(title = "教师", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysTeacher sysTeacher) {
        String checkMsg=authCheck(sysTeacher);
        if(null!=checkMsg) return error(checkMsg);
        if (sysTeacherService.insertSysTeacher(sysTeacher) == 0) {
            return error();
        }
        return success();
    }

    /**
     * 修改教师
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        SysTeacher sysTeacher = sysTeacherService.selectSysTeacherById(id);
        mmap.put("sysTeacher", sysTeacher);
        return prefix + "/edit";
    }

    /**
     * 修改保存教师
     */
    @RequiresPermissions("system:teacher:edit")
    @Log(title = "教师", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysTeacher sysTeacher) {
        String checkMsg=authCheck(sysTeacher);
        if(null!=checkMsg) return error(checkMsg);
        if (sysTeacherService.updateSysTeacher(sysTeacher) == 0) {
            return error();
        }
        return success();
    }

    /**
     * 删除教师
     */
    @RequiresPermissions("system:teacher:remove")
    @Log(title = "教师", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(sysTeacherService.deleteSysTeacherByIds(ids) > 1);
    }
}
