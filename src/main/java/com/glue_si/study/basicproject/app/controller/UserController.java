package com.glue_si.study.basicproject.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.glue_si.study.basicproject.webbase.appbase.BaseController;

/**
 * INDEX画面の表示用コントローラ。
 *
 * @author ishigouoka_k
 * $Id$
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {


    @RequestMapping(value = "/list")
    public String list(Model model) throws Exception {

        model.addAttribute("key", "値");
        model.addAttribute("dispTitle", "一覧画面");

        return "/user/list";
    }

    @RequestMapping(value = "/detail")
    public String detail() throws Exception {


        return "/user/detail";
    }

    @RequestMapping(value = "/add")
    public String add() throws Exception {


        return "/user/add";
    }

    @RequestMapping(value = "/update")
    public String update() throws Exception {

        return "/user/update";
    }

}
