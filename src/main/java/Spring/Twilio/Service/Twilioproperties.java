package Spring.Twilio.Service;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("tiwlio.prop")
public class Twilioproperties {

	private String twilioAccountSid = "Your account SID";
	private String twilioAuthToken = "Your Auth Token";
	private String twiliovsid = "Your Verification ID";
	public Twilioproperties(String twilioAccountSid, String twilioAuthToken, String twiliovsid) {
		super();
		this.twilioAccountSid = twilioAccountSid;
		this.twilioAuthToken = twilioAuthToken;
		this.twiliovsid = twiliovsid;
	}
	public Twilioproperties() {
		// TODO Auto-generated constructor stub
	}
	public String getTwilioAccountSid() {
		return twilioAccountSid;
	}
	public void setTwilioAccountSid(String twilioAccountSid) {
		this.twilioAccountSid = twilioAccountSid;
	}
	public String getTwilioAuthToken() {
		return twilioAuthToken;
	}
	public void setTwilioAuthToken(String twilioAuthToken) {
		this.twilioAuthToken = twilioAuthToken;
	}
	public String getTwiliovsid() {
		return twiliovsid;
	}
	public void setTwiliovsid(String twiliovsid) {
		this.twiliovsid = twiliovsid;
	}
}
