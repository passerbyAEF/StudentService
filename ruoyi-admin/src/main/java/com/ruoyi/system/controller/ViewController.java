package com.ruoyi.system.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.SysCurriculum;
import com.ruoyi.system.domain.SysStudent;
import com.ruoyi.system.domain.SysTeacher;
import com.ruoyi.system.service.ISysCurriculumService;
import com.ruoyi.system.service.ISysStudentService;
import com.ruoyi.system.service.ISysTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller()
@RequestMapping("/view")
public class ViewController extends BaseController {
    @Autowired
    private ISysCurriculumService sysCurriculumService;
    @Autowired
    private ISysTeacherService sysTeacherService;
    @Autowired
    private ISysStudentService sysStudentService;

    /**
     * 课程List获取
     */
    @PostMapping("/student/list")
    @ResponseBody
    public TableDataInfo getStudentList() {
        SysUser user = getSysUser();
        SysStudent student= sysStudentService.selectStudentByUserId(user.getUserId());
        startPage();
        List<SysCurriculum> list = sysCurriculumService.selectSysCurriculumListByStudent(student);
        return getDataTable(list);
    }

    /**
     * 课程List获取
     */
    @PostMapping("/teacher/list")
    @ResponseBody
    public TableDataInfo getTeacherList() {
        SysUser user = getSysUser();
        SysTeacher teacher= sysTeacherService.selectSysTeacherByUserId(user.getUserId());
        startPage();
        List<SysCurriculum> list = sysCurriculumService.selectSysCurriculumListByTeacher(teacher);
        return getDataTable(list);
    }

    @GetMapping("/studentview")
    public String student(Model model) {
        SysUser user = getSysUser();
        SysStudent student= sysStudentService.selectStudentByUserId(user.getUserId());
        model.addAttribute("sysStudent",student);
        return "view/studentsview";
    }

    @GetMapping("/teacherview")
    public String teacher(Model model) {
        SysUser user = getSysUser();
        SysTeacher teacher= sysTeacherService.selectSysTeacherByUserId(user.getUserId());
        model.addAttribute("sysTeacher",teacher);
        return "view/teacherview";
    }
}
