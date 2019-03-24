package com.bj.genealogy.web;

import com.bj.genealogy.bean.Person;
import com.bj.genealogy.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
     * 树视图
     * @return
     */
    @RequestMapping("/view")
    public ModelAndView view() {
        List<Person> tree = personDao.findAll();
        String view = "person/view";
        if(tree.size()==0){
            view = "person/list";
        }
        ModelAndView mav = new ModelAndView(view);
        mav.addObject("tree", tree);
        return mav;
//        return "person/view";
    }

    /**
     * 列表页面
     * @return
     */
    @RequestMapping("/list")
        public ModelAndView list(@RequestParam(value = "start", defaultValue = "0") Integer start,
                                 @RequestParam(value = "limit", defaultValue = "2") Integer limit) {
        start = start < 0 ? 0 : start;

        Sort sort = new Sort(Sort.DEFAULT_DIRECTION, "id");
        Pageable pageable = new PageRequest(start, limit, sort);
        Page<Person> page = personDao.findAll(pageable);
        ModelAndView mav = new ModelAndView("person/list");
        mav.addObject("page", page);
        return mav;
    }
    /**
     * 类别新增视图
     * @return
     */
    @RequestMapping("/add")
    public ModelAndView add(@RequestParam(name = "pid", required = false,defaultValue="0") int pid) {
        ModelAndView mav = new ModelAndView("person/add");
        mav.addObject("pid", pid);
        return mav;
    }

    /**
     * 类别新增操作
     * @param model
     * @return
     */
    @RequestMapping("/save")
    public String save(Person model) {
        personDao.save(model);
        return "redirect:view";
    }

    /**
     * 类别删除操作
     * @param id
     * @return
     */
    @RequestMapping("/del")
    public String categorydelete(Integer id) {
        personDao.deleteById(id);
        return "redirect:person/list";
    }

    /**
     * 类别编辑视图
     * @param id
     * @return
     */
    @RequestMapping("/edit")
    public ModelAndView categoryedit(Integer id) {
        Person model = personDao.getOne(id);

        ModelAndView mav = new ModelAndView("person/edit");
        mav.addObject("person", model);
        return mav;
    }

    /**
     * 类别编辑操作
     * @param model
     * @return
     */
    @RequestMapping("/update")
    public String categoryupdate(Person model) {
        personDao.save(model);
        return "redirect:person/list";
    }
}
