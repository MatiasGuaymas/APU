package ar.edu.unlp.info.oo2._Ejercicio17;

import java.util.Collection;
import java.util.List;

public class DatabaseProxy implements DatabaseAccess {
	private DatabaseAccess database;
	private boolean loggedIn;
	private String key;
	
	public DatabaseProxy (DatabaseAccess database, String key) {
		this.database = database;
		this.loggedIn = false;
		this.key = key;
	}
	
	@Override
	public Collection<String> getSearchResults(String queryString) {
		if (this.loggedIn) {
			return this.database.getSearchResults(queryString);
		} 
		throw new IllegalArgumentException("El usuario no se encuentra registrado");
	}

	@Override
	public int insertNewRow(List<String> rowData) {
		if (this.loggedIn) {
			return this.database.insertNewRow(rowData);
		}
		throw new IllegalArgumentException("El usuario no se encuentra registrado");
	}
	
	public void login(String password) {
		if(!this.loggedIn) {
			if(this.key.equals(password)) {
				this.loggedIn = true;
			} else {
				throw new RuntimeException("Contraseña inválida");
			}
		} else {
			throw new RuntimeException("Sesión ya iniciada");
		}
	}

	public void logOut() {
		if(this.loggedIn) {
			this.loggedIn = false;
		} else {
			throw new RuntimeException("Sesión sin iniciar");
		}
	}
	
}
