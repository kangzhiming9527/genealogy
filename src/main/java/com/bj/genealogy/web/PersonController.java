package com.bj.genealogy.web;

import com.bj.genealogy.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PersonController：人员控制器
 * 2019/3/23 0:09
 * by kzm
 */
@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonDao personDao;

    /**
     * 查询页面
     * @return
     */
    @RequestMapping("/list")
    public String list() {
        return "person/list";
    }
}
