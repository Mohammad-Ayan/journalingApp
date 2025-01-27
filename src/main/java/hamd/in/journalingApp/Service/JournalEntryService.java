package hamd.in.journalingApp.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hamd.in.journalingApp.Entity.JournalEntry;
import hamd.in.journalingApp.repository.JournalEntryRepo;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;

    public void saveEntry(JournalEntry journalEntry) {
        try {
            journalEntry.setDate(LocalDateTime.now());
            journalEntryRepo.save(journalEntry);

        } catch (Exception e) {
            log.error("Exception", e);
        }
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