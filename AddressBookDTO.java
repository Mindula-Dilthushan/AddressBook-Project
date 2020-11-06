public class AddressBookDTO {
    private String fname;
    private String lname;
    private String address;
    private String contact;
    private String email;

    public AddressBookDTO() {
        fname = "";
        lname = "";
        address = "";
        contact = "";
        email = "";
    }

    public AddressBookDTO(String fname,String lname, String address, String contact, String email) {
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }

	 public String getfName() {

        return fname;
    }
    public void setfName(String fname) {

        this.fname = fname;
    }
   
   
   
	public String getlName() {

        return lname;
    }
    public void setlName(String lname) {

        this.lname = lname;
    }
  


	public String getAddress() {

        return address;
    }
    public void setAddress(String address) {

        this.address = address;
    }
   
   

	public String getcontact() {
		return contact;
    }
    public void setContact(String contact) {

        this.contact = contact;
    }
    

	public String getEmail(){
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }


    
}
