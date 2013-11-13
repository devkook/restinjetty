package devkook.study.rest.contact;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Contact")
public class ContactVo {
    String email;
    String name;
    String phone;
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
}
