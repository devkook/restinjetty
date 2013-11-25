package devkook.study.rest.contact;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ContactDao {
    Hashtable<String, ContactVo> contacts = new Hashtable<String, ContactVo>();
    
    public ContactDao(){
        ContactVo vo = new ContactVo();
        vo.setEmail("a@bc.com");
        vo.setName("me");
        vo.setPhone("123");
        this.contacts.put("a@bc.com", vo);
    }

    public void add(String email, ContactVo vo) {
        contacts.put(email, vo);
    }

    public void update(String email, ContactVo vo) {
        contacts.put(email, vo);
    }

    public void remove(String email) {
        contacts.remove(email);
    }
    
    public ContactVo get(String email){
        return contacts.get(email);
    }
    
    public List<ContactVo> getList() {
        return new ArrayList<ContactVo>(contacts.values());
    }
}
