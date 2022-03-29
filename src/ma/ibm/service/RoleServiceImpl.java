package ma.ibm.service;

import java.util.List;

import ma.ibm.DAO.IRoleDAO;
import ma.ibm.DAO.RoleDAOImpl;
import ma.ibm.modele.Role;

public class RoleServiceImpl implements IRoleService{
	
	IRoleDAO dao=new RoleDAOImpl();
	@Override
	public boolean saveRole(Role role) {
		return dao.saveRole(role);	}

	@Override
	public List<Role> findRoleAll() {
		return dao.findRoleAll();
	}

	@Override
	public Role findRoleByLib(String lib) {
		return dao.findRoleByLib(lib);
	}

}
