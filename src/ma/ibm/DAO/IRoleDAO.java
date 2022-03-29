package ma.ibm.DAO;


import java.util.List;

import ma.ibm.modele.Role;

public interface IRoleDAO {

	public boolean saveRole(Role role);
	
	public List<Role> findRoleAll();
	
	public Role findRoleByLib(String lib);
	
}
