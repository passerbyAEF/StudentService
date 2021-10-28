package com.ruoyi.system.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysCurriculum;
import com.ruoyi.system.domain.SysStudent;
import com.ruoyi.system.service.ISysCurriculumService;
import com.ruoyi.system.service.ISysStudentService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.vo.CurriculumListVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生信息Controller
 *
 * @author chen
 * @date 2021-10-05
 */
@Controller
@RequestMapping("/system/student")
public class SysStudentController extends BaseController {
    private String prefix = "system/student";

    @Autowired
    private ISysStudentService sysStudentService;
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysCurriculumService sysCurriculumService;

    String authCheck(SysStudent sysStudent) {
        SysUser user = sysUserService.selectUserById(sysStudent.getUserId());
        if (null == user) {
            return "用户不存在";
        }
        for (SysRole r : user.getRoles()) {
            if (!"学生".equals(r.getRoleName())) {
                return "用户非法！";
            }
        }
        return null;
    }

    @RequiresPermissions("system:student:view")
    @GetMapping()
    public String student() {
        return prefix + "/student";
    }

    /**
     * 查询学生信息列表
     */
    @RequiresPermissions("system:student:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysStudent sysStudent) {
        startPage();
        List<SysStudent> list = sysStudentService.selectSysStudentList(sysStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生信息列表
     */
    @RequiresPermissions("system:student:export")
    @Log(title = "学生信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysStudent sysStudent) {
        List<SysStudent> list = sysStudentService.selectSysStudentList(sysStudent);
        ExcelUtil<SysStudent> util = new ExcelUtil<SysStudent>(SysStudent.class);
        return util.exportExcel(list, "学生信息数据");
    }

    /**
     * 新增学生信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存学生信息
     */
    @RequiresPermissions("system:student:add")
    @Log(title = "学生信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysStudent sysStudent) {
        String checkMsg = authCheck(sysStudent);
        if (null != checkMsg) return error(checkMsg);
        if (sysStudentService.insertSysStudent(sysStudent) == 0) {
            return error();
        }
        return success();
    }

    /**
     * 修改学生信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        SysStudent sysStudent = sysStudentService.selectSysStudentById(id);
        mmap.put("sysStudent", sysStudent);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生信息
     */
    @RequiresPermissions("system:student:edit")
    @Log(title = "学生信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysStudent sysStudent) {
        String checkMsg = authCheck(sysStudent);
        if (null != checkMsg) return error(checkMsg);
        if (sysStudentService.updateSysStudent(sysStudent) == 0) {
            return error();
        }
        return success();
    }

    /**
     * 删除学生信息
     */
    @RequiresPermissions("system:student:remove")
    @Log(title = "学生信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(sysStudentService.deleteSysStudentByIds(ids) > 1);
    }

    /**
     * 修改课程视图
     */
    @RequiresPermissions("system:student:curriculum")
    @GetMapping("/edit/setCurriculum/{id}")
    public String setCurriculum(@PathVariable("id") Long id, ModelMap mmap) {
        SysStudent sysStudent = sysStudentService.selectSysStudentById(id);
        mmap.put("sysStudent", sysStudent);
        return prefix + "/curriculum-edit";
    }

    /**
     * 课程List获取
     */
    @RequiresPermissions("system:student:curriculum")
    @PostMapping("/edit/setCurriculum/list/{id}")
    @ResponseBody
    public TableDataInfo getCurriculumListByStudent(@PathVariable("id") Long id) {
        startPage();
        List<SysCurriculum> list = sysCurriculumService.selectSysCurriculumList(new SysCurriculum());
        SysStudent student = new SysStudent();
        student.setId(id);
        List<CurriculumListVo> sclist = sysCurriculumService.selectSysCurriculumListByStudent(student);
        return getDataTable(list);
    }

    /**
     * 课程List获取
     */
    @RequiresPermissions("system:student:curriculum")
    @PostMapping("/edit/setCurriculum/edit")
    @ResponseBody
    public AjaxResult editCurriculum(@RequestParam("id") Integer id, @RequestParam("datalist") List<Integer> dataList) {
//        startPage();
//        List<SysCurriculum> list = sysCurriculumService.selectSysCurriculumList(new SysCurriculum());
        return success();
    }
}
