package ua.lviv.iot.secterica.heysmell;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


public class MongoApp {

    private static final Log log = LogFactory.getLog(MongoApp.class);

    public static void main(String[] args) {
        Date date = Date.from(Instant.now());
        Date date2 = new Date();
        LocalDate date3 = null;
//      i think i can use this class for my purposes, it's quite easy and simple and etc.
        LocalDateTime dateTime = LocalDateTime.now();

        date3 = LocalDate.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth());
        System.out.println(date2);
        System.out.println(date3);
//        System.out.println(date.toInstant());
//        MongoClient mongoClient = MongoClients.create();
//        MongoDatabase database = mongoClient.getDatabase("localhost");
//        MongoTemplate template = new MongoTemplate(MongoClients.create(), "lol");
//        template.find(Query.query(Criteria.where("").all().all().all().all().all().all()), Person.class);
//        MongoCollection collection = database.getCollection("iot");
//        MongoCollection mongoCollection = template.getCollection("iot");
//        System.out.println(collection.find());
//        System.out.println(mongoCollection.find());
//        template.find(new Query(Criteria.where("percentageOfSth").is(300.1)), AirQuality.class);
//        System.out.println(template.find(new Query(Criteria.where("percentageOfSth").is(300.2)), AirQuality.class));
//        MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "database");
//        mongoOps.insert(new Person("Joe", 34));
//
//        log.info(mongoOps.findOne(new Query(Criteria.where("name").is("Joe")), Person.class));
//
//        mongoOps.dropCollection("person");
    }
//    public static void main(String args[]) {
//
//        // Obtain a LocalDateTime object by parsing a date and time string.
//        LocalDateTime curDateTime = LocalDateTime.parse("July 21, 2014 12:01 AM",
//                DateTimeFormatter.ofPattern("MMMM d',' yyyy hh':'mm a", Locale.US));
//
//        // Now, display the parsed date and time.
//        System.out.println(curDateTime.format(DateTimeFormatter.ofPattern("MM d',' yyyy hh':'mm a", Locale.US)));
//    }
}
