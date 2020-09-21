/*
 * package com.example.WebProject.controller;
 * 
 * import java.io.PrintWriter;
 * 
 * import javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * import com.example.WebProject.domain.ListDao; import
 * com.example.WebProject.domain.ListDto; import
 * com.example.WebProject.domain.UserDao; import
 * com.example.WebProject.service.UserService;
 * 
 * @Controller
 * 
 * @RequestMapping("user") public class UserController {
 * 
 * @Autowired UserService userService;
 * 
 * @GetMapping("/login") public String login() {
 * 
 * return "user/loginform"; }
 * 
 * 
 * @GetMapping("/checklogin") public String checkLogin() {
 * 
 * return "redirect:/list"; }
 * 
 * 
 * 
 * @PostMapping("/") public String checkLogin(HttpSession session) { long
 * loginedMemberLoginId = 0;
 * 
 * if (session.getAttribute("loginedMemberLoginId") != null) {
 * loginedMemberLoginId = (long) session.getAttribute("loginedMemberLoginId"); }
 * return "redirect:/list"; }
 * 
 * 
 * // 세션초기화 로그아웃 로그인 페이지 이동
 * 
 * @PostMapping("/logout") public String logout(HttpSession session) {
 * session.invalidate(); // 세션초기 return "redirect:/"; }
 * 
 * @PostMapping("/login") public String login(@RequestParam("id") String
 * id, @RequestParam String password, HttpServletResponse response, HttpSession
 * session) throws Exception {
 * 
 * int check = userService.userCheck(id, password); System.out.println(check);
 * if (check != UserService.ID_AND_PASSWD_OK) { String message = ""; switch
 * (check) { case UserService.ONLY_PASSWD_FAIL: message = "패스워드 틀림"; break; case
 * UserService.ID_AND_PASSWD_FAIL: message = "아이디 없음"; break; }
 * 
 * response.setContentType("text/html; charset=UTF-8"); PrintWriter out =
 * response.getWriter();
 * 
 * out.println("<script>"); out.println("alert('" + message + "');");
 * out.println("history.back();"); out.println("</script>"); out.close(); return
 * null; } session.setAttribute("id", id);
 * 
 * return "redirect:user/main"; }
 * 
 * @GetMapping("main") public String main(HttpSession session) { String id =
 * (String) session.getAttribute("id");
 * 
 * if (id == null) { return "redirect:/user/login"; } return "user/main"; }
 * 
 * }
 */