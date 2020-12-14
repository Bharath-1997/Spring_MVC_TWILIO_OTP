package Spring.Twilio.Service;




import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.verify.v2.service.Verification;

import com.twilio.rest.verify.v2.service.VerificationCheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class PhoneVerificationService {

//	 static final String ACCOUNT_SID = "";
//	 static final String AUTH_TOKEN = "";
//   
//
	    private static String VERIFICATION_SID = "";
          
         @Autowired 
	    public PhoneVerificationService(Twilioproperties properties) {
        	 PhoneVerificationService.VERIFICATION_SID=properties.getTwiliovsid();
	        Twilio.init(properties.getTwilioAccountSid(),properties.getTwilioAuthToken());
	    }

	    public VerificationResult startVerification(String phone, String channel) {
	        try {
	            Verification verification = Verification.creator(VERIFICATION_SID, phone, "sms").create();
	            System.out.println("phone -"+phone+"\n sid -"+verification.getSid());
	            return new VerificationResult(verification.getSid());
	        } catch (ApiException exception) {
	            return new VerificationResult(new String[] {exception.getMessage()});
	        }
	    }

	    public VerificationResult checkVerification(String phone, String code) {
	        try {
	            VerificationCheck verification = VerificationCheck.creator(VERIFICATION_SID, code).setTo(phone).create();
	            if("approved".equals(verification.getStatus())) {
	                return new VerificationResult(verification.getSid());
	            }
	            return new VerificationResult(new String[]{"Invalid code."});
	        } catch (ApiException exception) {
	            return new VerificationResult(new String[]{exception.getMessage()});
	        }
	    }
	}
