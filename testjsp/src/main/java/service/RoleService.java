package service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.DatabaseManagerSingleton;
import proxima.informatica.academy.dto.RoleDto;

public class RoleService {
	private final static Logger logger = LoggerFactory.getLogger(RoleService.class);

	private RoleService() {
		logger.debug("Instanziato Costruttore Privato UserService Singleton");
	}

	private static RoleService instance;

	public static RoleService getInstance() {
		if (instance == null) {
			instance = new RoleService();
		}
		return instance;
	}


	public boolean insert(RoleDto role) {
		boolean response = false;

		if (DatabaseManagerSingleton.getInstance().insertRole(role) > 0)
			response = true;
		return response;
	}
	
	public RoleDto selectById(int id) {
		RoleDto roleRetrived = new RoleDto();
		roleRetrived = DatabaseManagerSingleton.getInstance().getRoleById(id);

		return roleRetrived;
	}

	public ArrayList<RoleDto> getAllRoles() {
		ArrayList<RoleDto> listRoles = new ArrayList<RoleDto>();

		listRoles = DatabaseManagerSingleton.getInstance().selectAllRoles();

		return listRoles;
	}

	public boolean updateRole(RoleDto role) {
		boolean response = false;

		if (DatabaseManagerSingleton.getInstance().updateRole(role) > 0)
			response = true;

		return response;
	}

	public boolean deleteRole(int id) {
		boolean response = false;

		if (DatabaseManagerSingleton.getInstance().deleteRole(id) > 0)
			response = true;

		return response;
	}

}
