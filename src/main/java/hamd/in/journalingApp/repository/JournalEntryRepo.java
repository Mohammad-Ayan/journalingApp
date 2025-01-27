package hamd.in.journalingApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import hamd.in.journalingApp.Entity.JournalEntry;

public interface JournalEntryRepo extends MongoRepository <JournalEntry, ObjectId> {
    
}       