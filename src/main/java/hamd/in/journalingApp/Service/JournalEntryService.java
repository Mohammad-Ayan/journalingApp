package hamd.in.journalingApp.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hamd.in.journalingApp.Entity.JournalEntry;
import hamd.in.journalingApp.Entity.User;
import hamd.in.journalingApp.repository.JournalEntryRepo;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;

    @Autowired
    private UserService userService;

    public void saveEntry(JournalEntry journalEntry, String userName) {
            User user = userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepo.save(journalEntry);
            user.getJournal_entries().add(saved);
            userService.saveEntry(user);
        }

    public List<JournalEntry> getAll() {
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepo.findById(id);
    }

    public void deleteJournalEntryById(ObjectId id) {
        journalEntryRepo.deleteById(id);
    }
}

// controller ---> service ---> repository 