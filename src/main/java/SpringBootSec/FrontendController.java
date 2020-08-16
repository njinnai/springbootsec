 
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
 
@Controller
@RequestMapping("/frontend")
public class FrontendController {
 
    @RequestMapping("/main")
    public String login(Model model) {
     
        try {
            // セッション情報からユーザ情報を取得し画面に反映
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            LoginUser user = (LoginUser) auth.getPrincipal();
            // userIdを反映
            model.addAttribute("username", user.getUsername());
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "/main/main";
    }
     
}
