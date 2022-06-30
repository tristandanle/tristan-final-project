package com.gogo.admin.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gogo.admin.FileUploadUtil;
import com.gogo.admin.domain.User;
import com.gogo.admin.security.GogoUserDetails;
import com.gogo.admin.service.UserService;



@Controller
public class AccountController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/account")
	public String viewUserAccountDetails(@AuthenticationPrincipal GogoUserDetails loggedInUser, Model model ) {
		 String usernameByEmail = loggedInUser.getUsername(); 
		 User userByEmail = userService.getUserByEmail(usernameByEmail); 
		 model.addAttribute("user",userByEmail);
		 
		 return "accountcontroller/account_form";
	}
	
	// Save users - account_form.html
	@PostMapping("/account/update")
	public String saveUpdatedUser(User user, RedirectAttributes redirectAttributes, 
			@AuthenticationPrincipal GogoUserDetails loggedInUser,
			@RequestParam("image") MultipartFile multipartFile ) throws IOException {
		
			if (!multipartFile.isEmpty()) {
				String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
				user.setPhotos(fileName);
				User savedUser = userService.updateAccount(user);
				String uploadDir = "user-photos/" + savedUser.getId();
				FileUploadUtil.cleanDir(uploadDir);
				FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
			} else {
				if (user.getPhotos().isEmpty()) user.setPhotos(null);
				userService.updateAccount(user);
			}
			
			loggedInUser.setFirstName(user.getFirstName());
			loggedInUser.setLastName(user.getLastName());
			
			redirectAttributes.addFlashAttribute("message", "You account is updated successfully.");

			return "redirect:/account";
		}
}
