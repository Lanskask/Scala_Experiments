
// -----------

val inMemoryDataBase: Map[String, String] = Map(
	"db.default.driver" -> "org.h2.Driver",
	"db.default.url" -> "jdbc:h2:mem:play-test",
	"evolutionplugin" -> "disabled"
)

"getAllMeetings" should {
	"return all meatings ordered by start date" {
		running(FakeApplication(additionalConfiguration = inMemoryDataBase)).initializeDatabase()
		_
	}
}

// -------------

db.default.driver = org.postgres.Driver
db.default.url="jdbc:postgres://:5432/meetings"
db.default.user=postgres
db.default.password="password"
db.default.lofStatements=true

logger.scala.slick.jdbc.JdbcBacked.statement=DEBUG
// ---------

meetings
	.innerJoin(documents).on { ... }
	.where {...}
	.mapResult { case (meeting, document) => 
		meeting.documents = Some(Set(document))
		meeting
	}.list.reduceOption { (previousMeeting, meeting) => 
		previousMeeting.documents = 
			Some(previousMeeting.documents.get ++ , meeting.documents.get)
		previousMeeting
	}

meetings
	.leftJoin(attendeeLinks).on ( ... )
	.leftJoin(attendees).on {...}
	.map { case ((meeting, attendeeLink), attendee) => 
		(meeting, attendee.?)
	}.mapResult { case (meeting: Meeting, attendeeOption: Option[Attendee]) => 
		meeting.attendees = attendeeOption.map(Set(_)).orElse(Some(Set.empty[Attendee]))
		meeting
	}
	.list.groupBy(_.id).mapValues {
		meetingsWithSameId => 
		meetingsWithSameId.reduce { (previousMeeting, meeting) => 
			previousMeeting.attendees = 
				Some(previousMeeting.attendees.get ++ meeting.attendees.get)
			previousMeeting
		}
	}.values.toList