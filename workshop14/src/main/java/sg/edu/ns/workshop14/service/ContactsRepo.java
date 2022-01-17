package sg.edu.ns.workshop14.service;

import java.util.List;

import sg.edu.ns.workshop14.model.Contact;

public interface ContactsRepo {
    public void save(final Contact ctc);
    public void findById(final String contactId);
    public List<Contact> findAll();
    
    
}
