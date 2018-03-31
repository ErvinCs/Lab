package ro.blooddonation.Domain;

import java.time.LocalDate;


public class SuperAdmin {

    private String username;
    private String password;

    /**
     * Is assigned from idk, the State or w/e a username and password.
     * Administrates the staff of hospitals.
     * @param username: String
     * @param password: String
     */
    public SuperAdmin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * @param username: String; unique Admin username
     * @param password: String
     * @return: Admin(username, password)
     */
    public Admin createAdmin(String username, String password) {
        return new Admin(username, password);
    }

    /**
     *
     * @param firstName: String
     * @param lastName: String
     * @param bDay: LocalDate
     * @param address: Address
     * @param residence: Address
     * @param CNP: Long
     * @param username: String
     * @param password: String
     * @param doningCenter: DoningCenter
     * @return DCPMember(firstName, lastName, bDay, address, residence, CNP,
                         username, password, doningCenter)
     */
    public DCPMember createDCP(String firstName, String lastName, LocalDate bDay, Address address, Address residence, Long CNP,
                               String username, String password, DoningCenter doningCenter) {
        return new DCPMember(firstName, lastName, bDay, address, residence, CNP,
                username, password, doningCenter);
    }

    /**
     * @param id
     */
    public void removeAdmin(Long id) {
        // TODO: call remove from the repo; coupling?
    }

    /**
     * @param id
     */
    public void removeDCP(Long id) {
        // TODO: call remove from the repo; coupling?
    }

}