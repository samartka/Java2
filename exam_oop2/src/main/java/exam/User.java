package exam;

public class User 
{
    private String firstname;
    private String lastname;
    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void phoneCall(Mobile mobile, String phoneNumber) {
        
    }
    public void internetSurfingTo(Mobile mobile, String url) {
        
    }
    public void takeAphoto(ICamera mobileWithCamera, User target) {
        
    }
    public void takeAvideo(ICamera mobileWithCamera, User target) {
        
    }
    public void fold(IFoldable mobileFoldable) {
        
    }
    
}
