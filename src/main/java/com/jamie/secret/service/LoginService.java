package com.jamie.secret.service;

import com.jamie.secret.model.UserProfile;

public interface LoginService {
	UserProfile generalChecking(UserProfile userProfile);
	boolean hardcodeChecking(UserProfile userProfile);
}
