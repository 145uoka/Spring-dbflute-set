package com.glue_si.study.basicproject.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.glue_si.study.basicproject.app.form.LoginNameForm;
import com.glue_si.study.basicproject.app.service.SystemPropertyService;
import com.glue_si.study.basicproject.app.util.EncryptUtil;
import com.glue_si.study.basicproject.app.util.MessageKeyUtil;
import com.glue_si.study.basicproject.dbflute.exbhv.UserTBhv;
import com.glue_si.study.basicproject.webbase.appbase.BaseController;
import com.glue_si.study.basicproject.webbase.appbase.BeforeLogin;
import com.glue_si.study.basicproject.webbase.common.constants.MessageKeyConstants;
import com.glue_si.study.basicproject.webbase.common.constants.SystemCodeConstants;
import com.glue_si.study.basicproject.webbase.common.constants.SystemCodeConstants.MessageType;
import com.glue_si.study.basicproject.webbase.common.constants.SystemCodeConstants.Permissions;

/**
 * ログイン用コントローラ。
 *
 * @author ishigouoka_k
 * $Id: LoginController.java 591 2017-08-08 07:48:14Z kanai_y@glue-si.com $
 */
@BeforeLogin
@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController {

    @Autowired
    SystemPropertyService systemPropertyService;

    @Autowired
    UserTBhv userTBhv;

    @RequestMapping(method = RequestMethod.POST)
    public String loginName(@ModelAttribute("form") LoginNameForm form, BindingResult bindingResult,
            RedirectAttributes redirectAttributes, Model model) throws Exception {

        String userName = form.getUserName();
        String encPassword = EncryptUtil.saltHash(form.getPassword(), EncryptUtil.EncryptType.MD5);

        userTBhv.selectEntity(cb -> {
            cb.query().setUserName_Equal(userName);
            cb.query().setPassword_Equal(encPassword);
        }).ifPresent(userT -> {
            // called if present
            userInfo.setLogined(true);
            userInfo.setUserName(userT.getUserName());
            userInfo.setEmail(userT.getEmail());
            userInfo.setUserType(userT.getUserType());


            Permissions permissions = Permissions.getPermissions(userT.getAuthLevel());

            if (permissions == SystemCodeConstants.Permissions.ADMIN){
                userInfo.setAdminFlg(true);
            } else {
                userInfo.setGeneralFlg(true);
            }

            Set<SystemCodeConstants.Permissions> permissionsSet = new HashSet<SystemCodeConstants.Permissions>();
            permissionsSet.add(permissions);
            userInfo.setPermissions(permissionsSet);

        }).orElse(() -> {
            // called if not present
            userInfo.setLogined(false);

            String message = messageSource.getMessage(
                    MessageKeyUtil.encloseStringDelete(MessageKeyConstants.Error.LOGIN),
                    null,
                    Locale.getDefault());
            List<String> errorMessageList = new ArrayList<String>(Arrays.asList(message));
            redirectAttributes.addFlashAttribute(MessageType.ERROR, errorMessageList);

        });


        return redirect("/");
    }
}
