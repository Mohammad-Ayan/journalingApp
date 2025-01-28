package hamd.in.journalingApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import hamd.in.journalingApp.Entity.User;

public interface UserRepo extends MongoRepository <User, ObjectId> {
    
}       