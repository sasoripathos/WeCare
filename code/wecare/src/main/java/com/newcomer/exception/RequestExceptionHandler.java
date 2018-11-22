package com.newcomer.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@ControllerAdvice
public class RequestExceptionHandler {
	
	@ExceptionHandler(InvalidParameterException.class)
	public String invalidParameterResponse(RedirectAttributes redirectAttrs, InvalidParameterException excep) {
		redirectAttrs.addFlashAttribute("state", excep.getMessage());
		return "redirect:/dashboard";
	}
	
	@ExceptionHandler(UserExistedException.class)
	public String userExistedResponse(RedirectAttributes redirectAttrs, UserExistedException excep) {
		redirectAttrs.addFlashAttribute("state", excep.getMessage());
		return "redirect:/dashboard";
	}
}
