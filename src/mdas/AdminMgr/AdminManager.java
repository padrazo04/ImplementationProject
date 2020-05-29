package mdas.AdminMgr;

import java.util.List;

public class AdminManager implements IAdminMGT{
	
	private List<Admin> admins;

	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}
	
	public int loadAdmins(String AdminFile) {
		return 0;
	}
	
}
