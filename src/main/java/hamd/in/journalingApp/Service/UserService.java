package hamd.in.journalingApp.Service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// import hamd.in.journalingApp.Entity.JournalEntry;
import hamd.in.journalingApp.Entity.User;
import hamd.in.journalingApp.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void saveEntry(User user) {
       userRepo.save(user);
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public Optional<User> findById(ObjectId id) {
        return userRepo.findById(id);
    }

    public void deleteJournalEntryById(ObjectId id) {
        userRepo.deleteById(id);
    }

    public User findByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }
}

// controller ---> service ---> repository