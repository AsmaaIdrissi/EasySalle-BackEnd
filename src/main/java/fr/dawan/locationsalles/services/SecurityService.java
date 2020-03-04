package fr.dawan.locationsalles.services;

public interface SecurityService {
	String findLoggedInUsername();

    void autoLogin(String username, String password);

}
