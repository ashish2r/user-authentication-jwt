package com.ashish.usermgmt.security;

import com.ashish.usermgmt.model.User;

public final class JwtUserFactory {

	private JwtUserFactory() {
	}

	public static JwtUser create(User user) {
		return new JwtUser(
				user.getId(), 
				user.getUsername(), 
				user.getPassword(), 
				user.getName(), 
				user.getPersonid(),
				user.getEnabled(), 
				user.getLastPasswordResetDate());
	}
}
