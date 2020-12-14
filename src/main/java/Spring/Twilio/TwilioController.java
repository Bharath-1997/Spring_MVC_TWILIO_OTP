package Spring.Twilio;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import Spring.Twilio.Service.PhoneVerificationService;
import Spring.Twilio.Service.VerificationResult;
import com.twilio.rest.verify.v2.service.Verification;

@Controller
public class TwilioController {
	
//	  public static final String ACCOUNT_SID = "";
//	  public static final String AUTH_TOKEN = "";
//	  static
//	  {
//	  Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//	  }
	  
	  private PhoneVerificationService phoneVerificationService;
	  
	  @Autowired
	    public TwilioController(PhoneVerificationService phoneVerificationService)
	    {

	        this.phoneVerificationService = phoneVerificationService;

	    }
	@RequestMapping("/")
	public String homepage(ModelAndView model)
	{
		return "index";
	}
	
	@RequestMapping(value="/sendotp", method=RequestMethod.POST)
	public  ResponseEntity<String> sendotp(@RequestParam("phone") String phone)
	{
		
		
		VerificationResult result = phoneVerificationService.startVerification(phone, "sms");
        if(result.isValid()) {
        	return new ResponseEntity<>("Otp Sent",HttpStatus.OK);
        }
		
		
        return new ResponseEntity<>("Otp failed to sent. try again",HttpStatus.OK);
     }
	@RequestMapping(value="/verifyotp", method=RequestMethod.POST)
	public ResponseEntity<String> verify(@RequestParam("phone") String phone,@RequestParam("otp") String otp)
	{
		

        VerificationResult result = phoneVerificationService.checkVerification(phone, otp);
        if(result.isValid()) {
           
        	return new ResponseEntity<>("Phone is verified",HttpStatus.OK);
            
        } 
        return new ResponseEntity<>("Something Wrong/Otp incorrect",HttpStatus.BAD_REQUEST);
    }
}
