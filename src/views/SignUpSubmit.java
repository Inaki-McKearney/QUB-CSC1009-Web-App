package views;

import org.h2.mvstore.MVMap;

import model.UserInformation;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class SignUpSubmit extends DynamicWebPage
{

	public SignUpSubmit(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
		if(toProcess.path.equalsIgnoreCase("SignUpSubmit.html"))
		{
			UserInformation user = new UserInformation();
			user.userEmailAddress = toProcess.params.get("userEmail");
			user.userPassword = toProcess.params.get("userPassword");
			
			MVMap<String, UserInformation> users = db.s.openMap("Users");
			
			
			if(!users.containsKey(user.userEmailAddress)&&
					toProcess.params.get("userEmail").length()>0
					&&toProcess.params.get("userPassword").length()>0){
			users.put(user.userEmailAddress, user);
			db.commit();

			String stringToSendToWebBrowser = "";
			stringToSendToWebBrowser += "<html>\n";
			stringToSendToWebBrowser += "  \n";
			stringToSendToWebBrowser += "  <head>\n";
			stringToSendToWebBrowser += "    <meta charset=\"utf-8\">\n";
			stringToSendToWebBrowser += "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n";
			stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js\"></script>\n";
			stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n";
			stringToSendToWebBrowser += "    <link href=\"http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css\"\n";
			stringToSendToWebBrowser += "    rel=\"stylesheet\" type=\"text/css\">\n";
			stringToSendToWebBrowser += "    <link href=\"http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css\"\n";
			stringToSendToWebBrowser += "    rel=\"stylesheet\" type=\"text/css\">\n";
			stringToSendToWebBrowser += "  </head>\n";
			stringToSendToWebBrowser += "  \n";
			stringToSendToWebBrowser += "  <body>\n";
			stringToSendToWebBrowser += "    <div class=\"section\">\n";
			stringToSendToWebBrowser += "      <div class=\"container\">\n";
			stringToSendToWebBrowser += "        <div class=\"row\">\n";
			stringToSendToWebBrowser += "          <div class=\"col-md-12\">\n";
			stringToSendToWebBrowser += "            <h1>Submitted</h1>\n";
			stringToSendToWebBrowser += "			<p>"+user.userEmailAddress+"</p>\n";
			stringToSendToWebBrowser += "            <a href=\"LandingPage.html\">Back to login</a>\n";
			stringToSendToWebBrowser += "          </div>\n";
			stringToSendToWebBrowser += "        </div>\n";
			stringToSendToWebBrowser += "      </div>\n";
			stringToSendToWebBrowser += "    </div>\n";
			stringToSendToWebBrowser += "  </body>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "</html>\n";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
			
			}else{
				String stringToSendToWebBrowser = "";
				stringToSendToWebBrowser += "<html>\n";
				stringToSendToWebBrowser += "  \n";
				stringToSendToWebBrowser += "  <head>\n";
				stringToSendToWebBrowser += "    <meta charset=\"utf-8\">\n";
				stringToSendToWebBrowser += "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n";
				stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js\"></script>\n";
				stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n";
				stringToSendToWebBrowser += "    <link href=\"http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css\"\n";
				stringToSendToWebBrowser += "    rel=\"stylesheet\" type=\"text/css\">\n";
				stringToSendToWebBrowser += "    <link href=\"http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css\"\n";
				stringToSendToWebBrowser += "    rel=\"stylesheet\" type=\"text/css\">\n";
				stringToSendToWebBrowser += "  </head>\n";
				stringToSendToWebBrowser += "  \n";
				stringToSendToWebBrowser += "  <body>\n";
				stringToSendToWebBrowser += " <h> Invalid Details Please Try Again </h>\n";
				stringToSendToWebBrowser += " <p>   </p>\n";
				
				//incorrect input feedback
				if(users.containsKey(user.userEmailAddress)){
					stringToSendToWebBrowser += " <p> Email Address in Use, Please Try Another  </p>\n";
				}
				if(toProcess.params.get("userEmail").length()<=0){
					stringToSendToWebBrowser += " <p>  Please Enter an Email Address </p>\n";
				}
				if(toProcess.params.get("userPassword").length()<=0){
					stringToSendToWebBrowser += " <p>  Please Enter a Password </p>\n";
				}
				stringToSendToWebBrowser += "         <p><a href=\"signuppage.html\">Back to signup</a>\n</p>";
				stringToSendToWebBrowser += "         <p><a href=\"LandingPage.html\">Back to HomePage</a>\n</p>";
				stringToSendToWebBrowser += "  </body>\n";
				stringToSendToWebBrowser += "\n";
				stringToSendToWebBrowser += "</html>\n";
				toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
				return true;
				
			}
		}
		
		
		
		
		
		
		return false;
	}

}
