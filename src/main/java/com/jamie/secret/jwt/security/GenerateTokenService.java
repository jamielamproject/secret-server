package com.jamie.secret.jwt.security;

import com.jamie.secret.model.TokenModel;
import com.jamie.secret.model.UserProfile;

public interface GenerateTokenService {
	//Login
	String login_general_token(UserProfile userProfile);
	
	//Registration
	String registration_token(TokenModel tokenModel);
}
