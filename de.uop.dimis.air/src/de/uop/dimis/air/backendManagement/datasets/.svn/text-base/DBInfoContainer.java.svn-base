package de.uop.dimis.air.backendManagement.datasets;

import de.uop.dimis.air.internalObjects.mpqf.InputManagementType;

/**
 * Contains the informations needed for working with the registered data bases.
 * 
 * 
 * @author yakimov
 */
public class DBInfoContainer {

	/**
	 * Password of the database. Used for unregister.
	 */
	private String password;
	/**
	 * Capabilities of the database.
	 */
	private InputManagementType imt;

	/**
	 * Creates an {@link DBInfoContainer} object with the given capabilities,
	 * contained in the {@link InputManagementType}.
	 * 
	 * @param imt -
	 *            capabilities for this {@link DBInfoContainer}
	 */
	public DBInfoContainer(InputManagementType imt) {
		this.imt = imt;
	}

	/**
	 * Returns the id of this data base.
	 * 
	 * @return - id of the data base
	 */
	public String getID() {
		return imt.getServiceID().get(0);
	}

	/**
	 * Returns all capabilities of the data base
	 * 
	 * @return - capabilities of the data base
	 */
	public InputManagementType getImt() {
		return imt;
	}

	/**
	 * Returns the password of this data base (from the registration).
	 * 
	 * @return - registration password of the data base
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password
	 * 
	 * @param password -
	 *            password for the registration
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
