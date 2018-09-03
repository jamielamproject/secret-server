package com.jamie.secret.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.jamie.secret.exception.TokenValidationException;
import com.jamie.secret.model.UserProfile;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	UserProfileService userProfileService;
	
	@Override
	public boolean hardcodeChecking(UserProfile userProfile) {
		// TODO Auto-generated method stub
		 return "admin".equals(userProfile.getUsername())
	                && "admin".equals(userProfile.getPassword());
	}

	@Override
	public UserProfile generalChecking(UserProfile userProfile) {
		// TODO Auto-generated method stub
		UserProfile u = null;
		if(userProfile != null && !ObjectUtils.isEmpty(userProfile.getUsername()) && !ObjectUtils.isEmpty(userProfile.getPassword())){
			try{
				u = userProfileService.findByUsernameAndPassword(userProfile.getUsername(), userProfile.getPassword());
				if(u != null){
					return u;
				}else{
					throw new TokenValidationException("Incorrect Account");
				}
			}catch(Exception e){
				throw new TokenValidationException(e.getMessage());
			}
		}
		return u;

	}

}
