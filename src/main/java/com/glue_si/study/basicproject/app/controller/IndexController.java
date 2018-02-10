package com.glue_si.study.basicproject.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.glue_si.study.basicproject.app.form.LoginNameForm;
import com.glue_si.study.basicproject.webbase.appbase.BaseController;
import com.glue_si.study.basicproject.webbase.appbase.BeforeLogin;

/**
 * INDEX画面の表示用コントローラ。
 *
 * @author ishigouoka_k
 * $Id$
 */
@BeforeLogin
@Controller
@RequestMapping(value = "/")
public class IndexController extends BaseController {


    @RequestMapping(method = RequestMethod.GET)
    public String index(@ModelAttribute("form") LoginNameForm form, Model model) throws Exception {

        model.addAttribute("form", form);

        if (userInfo.isLogined()) {
            return redirect("/loginTop");
        }


        return "index";
    }

}
