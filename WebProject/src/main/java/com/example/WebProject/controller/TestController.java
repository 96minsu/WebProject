package com.example.WebProject.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.WebProject.domain.ListDto;
import com.example.WebProject.domain.dao.TestDAO;
import com.example.WebProject.domain.dto.FileVO;
import com.example.WebProject.domain.dto.TestDTO;
import com.example.WebProject.service.TestService;

@MapperScan(basePackages = "com.example.WebProject.domain.dao")
@Controller
public class TestController {
	@Autowired
	private TestService testService;

	@Autowired
	SqlSession sqlSession;

	// JSON 데이터로 리스트 나열
	@RequestMapping("/users")
	@ResponseBody
	public List<TestDTO> uesrs(@RequestParam(value = "listName", defaultValue = "") String listName) throws Exception {
		final TestDTO testDTO = null;
		final List<TestDTO> userList = testService.selectUsers(testDTO);
		return userList;
	}

	@RequestMapping("/json")
	@ResponseBody
	public List<TestDTO> loginform() throws Exception {
		List<TestDTO> dto = testService.testList();
		return dto;
	}

	@PostMapping("/add")
	public String insertList(TestDTO testDTO, HttpServletRequest request, @RequestPart MultipartFile files)
			throws Exception {
		FileVO file = new FileVO();

		if (files.isEmpty()) {
			testService.write(testDTO);
		} else {
			String fileName = files.getOriginalFilename();
			String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();
			File destinationFile;
			String destinationFileName;
			String fileUrl = "C:/Users/JK코어/Desktop/project/git 저장소/WebProject/WebProject/src/main/webapp/WEB-INF/uploadFiles/";

			do {
				destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
				destinationFile = new File(fileUrl + destinationFileName);
			} while (destinationFile.exists());

			destinationFile.getParentFile().mkdirs();
			files.transferTo(destinationFile);

			testService.write(testDTO);

			file.setListNum(testDTO.getListNum());
			file.setFilename(destinationFileName);
			file.setFileOriName(fileName);
			file.setFileUrl(fileUrl);

			testService.insertFileService(file);
		}

		System.out.println(testDTO.getListName());

		return "redirect:/index2";
	}

	@PostMapping("/update")
	public String updateList(TestDTO testDTO) throws Exception {
		System.out.print(testDTO);
		testService.modify(testDTO);

		return "redirect:/index2";
	}

	@GetMapping("/delete")
	public String deleteList(int listNum) throws Exception {
		System.out.print(listNum);
		testService.remove(listNum);

		return "redirect:/index2";
	}

	@GetMapping("/detail/{listNum}")
	public String listDetail(@PathVariable int listNum, Model model) throws Exception {
		model.addAttribute("detail", testService.listDetailService(listNum));
		return "detailform";
	}
	
	@GetMapping("/detail2/{listNum}")
	public String listDetail2(@PathVariable int listNum, Model model) throws Exception {
		model.addAttribute("detail", testService.listDetailService(listNum));
		model.addAttribute("files", testService.fileDetailService(listNum));
		System.out.println(listNum);
		return "detail";
	}

	@RequestMapping("fileDown/{listNum}")
	private void fileDown(@PathVariable int listNum, HttpServletRequest request,
				HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		FileVO fileVO = testService.fileDetailService(listNum);
		
		try {
			String fileUrl = fileVO.getFileUrl();
			fileUrl += "/";
			String savePath = fileUrl;
			String fileName = fileVO.getFilename();
			
			String oriFileName = fileVO.getFileOriName();
			InputStream in = null;
			OutputStream os = null;
			File file = null;
			boolean skip = false;
			String client = "";
			
			try {
				file = new File(savePath, fileName);
				in = new FileInputStream(file);
			} catch (Exception e) {
				skip = true;
			}
			
			client = request.getHeader("User-Agent");
			
			response.reset();
			response.setContentType("apllication/otect-stream");
			response.setHeader("Content-Description", "JSP Generated Data");
			
			if (!skip) {
				if (client.indexOf("MSIE") != -1) {
                    response.setHeader("Content-Disposition", "attachment; filename=\""
                            + java.net.URLEncoder.encode(oriFileName, "UTF-8").replaceAll("\\+", "\\ ") + "\"");
                    // IE 11 이상.
                } else if (client.indexOf("Trident") != -1) {
                    response.setHeader("Content-Disposition", "attachment; filename=\""
                            + java.net.URLEncoder.encode(oriFileName, "UTF-8").replaceAll("\\+", "\\ ") + "\"");
                } else {
                    // 한글 파일명 처리
                    response.setHeader("Content-Disposition",
                            "attachment; filename=\"" + new String(oriFileName.getBytes("UTF-8"), "ISO8859_1") + "\"");
                    response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
                }
                response.setHeader("Content-Length", "" + file.length());
                os = response.getOutputStream();
                byte b[] = new byte[(int) file.length()];
                int leng = 0;
                while ((leng = in.read(b)) > 0) {
                    os.write(b, 0, leng);
                }
            } else {
                response.setContentType("text/html;charset=UTF-8");
                System.out.println("<script language='javascript'>alert('파일을 찾을 수 없습니다');history.back();</script>");
            }
            in.close();
            os.close();
        } catch (Exception e) {
            System.out.println("ERROR : " + e.getMessage());
        }
	}
}
