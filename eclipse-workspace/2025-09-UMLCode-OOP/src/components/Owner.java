package components;

public class Owner {
    private String name;
    private String company;
    private String licenseNumber;
    private String contactInfo;

    public Owner(String name, String company, String licenseNumber, String contactInfo) {
        this.name = name;
        this.company = company;
        this.licenseNumber = licenseNumber;
        this.contactInfo = contactInfo;
    }

    public void assignTruck(String truckType) {
        System.out.println(name + " from " + company + " is assigned to drive " + truckType);
    }

    public void reportMaintenance() {
        System.out.println(name + " reports: Truck maintenance required");
    }

    public void updateContact(String newContact) {
        this.contactInfo = newContact;
        System.out.println("Contact updated for " + name + ": " + newContact);
    }

    // Getters
    public String getName() { return name; }
    public String getCompany() { return company; }
    public String getLicenseNumber() { return licenseNumber; }
    public String getContactInfo() { return contactInfo; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setCompany(String company) { this.company = company; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
}
