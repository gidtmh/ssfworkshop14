package sg.edu.ns.workshop14.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;
import sg.edu.ns.workshop14.model.Contact;

@Service
public class ContactsRedis implements ContactsRepo {
    //private static final Logger logger = LoggerFactory.getLogger(ContactsRedis.class);
    private final String CONTACT_CACHE = "CONTACT";

    @Autowired
    RedisTemplate<String, Contact> redisTemplate;

    @Override
    public void save(final Contact ctc){
        redisTemplate.opsForValue().set(ctc.getId(),ctc);
    }

    @Override
    public void findById(final String contactId){
        redisTemplate.opsForValue().get(contactId);
    }
    
    
}
