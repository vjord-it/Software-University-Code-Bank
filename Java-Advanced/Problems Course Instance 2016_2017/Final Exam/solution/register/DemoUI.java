package register;

import register.controller.RegisterFrame;
import register.model.History;
import register.model.Register;
import register.model.RegisterManager;
import register.persistance.PersistanceManager;

public class DemoUI {

	public static void main(String[] args) {
		RegisterManager registerManager = new RegisterManager(PersistanceManager.getInstance(), new History(), new Register(null));
		RegisterFrame frame = new RegisterFrame(registerManager);
		frame.setVisible(true);
	}
}