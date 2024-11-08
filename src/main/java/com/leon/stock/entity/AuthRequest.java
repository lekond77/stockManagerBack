package com.leon.stock.entity;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class AuthRequest {

	private String username;
	private String password;
}
