package Util;

import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static comtest.web.OnBoardingFlowTest.ACCOUNT_SID;

public class TwilioOTPHandle {

    public static String smsMessage() {
        String smsBody = getMessage();
        return smsBody.replaceAll("[^-?0-9]+", "");
    }

    public static String getMessage() {
        return getMessages().filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
                .filter(m -> m.getTo().equals("+13396752234")).map(Message::getBody).findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    private static Stream<Message> getMessages() {
        ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
        return StreamSupport.stream(messages.spliterator(), false);
    }

}
