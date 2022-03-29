package ma.ibm.service;

import java.util.List;

import ma.ibm.modele.Role;

public interface IRoleService {

	public boolean saveRole(Role role);
		
	public List<Role> findRoleAll();
	
	public Role findRoleByLib(String lib);
	
}
