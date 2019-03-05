package testActor

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import akka.util.Timeout
import message.SetRequest
import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import akka.util.Timeout
import org.scalatest.{FunSpecLike, Matchers}
import scala.concurrent.duration._

class actorDBSpec extends FunSpecLike with Matchers {
  implicit val system = ActorSystem()
  implicit val timeout = Timeout(5 seconds)
  describe("actorDB") {
    describe("given SetRequest") {
      it("should place key/value into map") {
        val actorRef = TestActorRef(new actorDB)
        actorRef ! SetRequest("key", "value")
        val akkademyDb = actorRef.underlyingActor
        akkademyDb.map.get("key") should equal(Some("value"))
      }
    }
  }
}