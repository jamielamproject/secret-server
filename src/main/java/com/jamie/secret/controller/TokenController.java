package com.jamie.secret.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jamie.secret.jwt.security.GenerateTokenService;
import com.jamie.secret.jwt.security.JwtUtil;
import com.jamie.secret.model.TokenModel;

@RequestMapping(value="/secret/token/request")
@Controller
public class TokenController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private GenerateTokenService generateTokenService;
	
	@PostMapping("/registration")
	 public void login(HttpServletResponse response,
            @RequestBody final TokenModel tokenModel) throws IOException {
		try{
			if(tokenModel != null && tokenModel.getMacAddress() != null){
				String token = generateTokenService.registration_token(tokenModel);
				response.addHeader(JwtUtil.HEADER_REGISTRATION, JwtUtil.TOKEN_PREFIX + " " + token);
	        }else
	            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Wrong credentials");
		}catch (Exception e){
			
		}
	}
}
